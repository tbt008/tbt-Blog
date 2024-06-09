package com.blog.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.domain.dto.ArticleDTO;
import com.blog.domain.dto.LabelDTO;
import com.blog.domain.entity.Article;
import com.blog.domain.entity.Label;
import com.blog.domain.entity.LabelArticle;
import com.blog.domain.entity.Type;
import com.blog.domain.query.ArticleQuery;
import com.blog.domain.vo.ArticleVO;
import com.blog.mapper.ArticleMapper;
import com.blog.mapper.LabelMapper;
import com.blog.mapper.TypeMapper;
import com.blog.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.service.ILabelArticleService;
import com.blog.service.ILabelService;
import com.blog.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tbt
 * @since 2024-03-22
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {
    @Resource
    private TypeMapper typeMapper;
    @Resource
    private LabelMapper labelMapper;
    @Resource
    private ILabelService iLabelService;
    @Autowired
    private ILabelArticleService ILabelArticleService;
    /**
     * 新增文章
     * @param article  实体类
     */
    @Override
    public void addArticle(Article article) {
//        校验
        if(article.getContent()==null||article.getTitle()==null){
           throw new IllegalArgumentException("内容或标题不能为空");
        }
//        数据处理
        article.setCreateUser("金屋藏小猪");
        article.setCreateTime(LocalDateTime.now());

//        添加数据库
       this.save(article);


    }
    /**
     * 修改文章
     * @param articleDTO  实体类
     */
    @Override
    public void updateArticle(ArticleDTO articleDTO) {


        //        校验
         if(articleDTO.getId()==null){
             throw new IllegalArgumentException("id不能为空");
         }

        if(articleDTO.getContent()==null||articleDTO.getTitle()==null){

            throw new IllegalArgumentException("内容或标题不能为空");
        }
//        数据处理
        Article article = BeanUtil.copyProperties(articleDTO, Article.class);
        article.setUpdateTime(LocalDateTime.now());
        //        修改数据库
        this.updateById(article);
//        把标签都保存一遍

        List<String> label = articleDTO.getLabel();
//        如果不存在就新增
        for (String s : label) {
            Label one = iLabelService.lambdaQuery().eq(Label::getName, s).one();
            if(one==null){
//                不存在
                LabelDTO labelDTO = new LabelDTO();
                labelDTO.setName(s);
                iLabelService.addLabel(labelDTO);
            }
//            查询label名字对应的id
            Label name = iLabelService.lambdaQuery().eq(Label::getName, s).one();
            Integer id = name.getId();
//           新增关联表
            LabelArticle labelArticle = new LabelArticle();
            labelArticle.setArticleId(articleDTO.getId());
            labelArticle.setLabelId(id);
            ILabelArticleService.save(labelArticle);
        }



    }


    @Override
    public void deleteArticle(Integer id) {
        this.removeById(id);
    }

    @Override
    public Object countId(Integer id) {
        List<LabelArticle> list1 = ILabelArticleService.list();
        List<LabelArticle> collect = list1.stream().filter(new Predicate<LabelArticle>() {
            @Override
            public boolean test(LabelArticle labelArticle) {
                if (labelArticle.getArticleId() == id) {
                    return true;
                }
                return false;
            }
        }).collect(Collectors.toList());
        Long count = Long.valueOf(collect.size());
        return count;

    }

    @Override
    public List<ArticleVO> queryArticle(ArticleQuery query) {
        Page<Article> page = this.lambdaQuery()
                .eq(query.getTypeId()!=null,Article::getType,query.getTypeId())
                .orderBy(true,query.getIsAsc(),Article::getCreateTime) .page(query.toPage());
        List<Article> records = page.getRecords();
        List<ArticleVO> list=new ArrayList<>();
        for (Article record : records) {
            ArticleVO articleVO = BeanUtil.copyProperties(record, ArticleVO.class);
            articleVO.setLabelList(this.getLabelById(record.getId()));
            articleVO.setType(this.getTypeById(articleVO.getId()).getName());
            list.add(articleVO);
        }

        return list;

    }

    @Override
    public Type getTypeById(Integer id) {
        Article article = this.getById(id);
        return typeMapper.selectById(article.getType());
    }

    @Override
    public void setHideById(Integer id) {
        Article article = this.getById(id);
        article.setStatus(1);
        this.updateById(article);
    }

    @Override
    public List<Label> getLabelById(Integer id) {
return  ILabelArticleService.getLabelByArticleId(id);
    }
}
