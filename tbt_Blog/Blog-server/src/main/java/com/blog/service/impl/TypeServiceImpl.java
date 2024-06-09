package com.blog.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.domain.dto.TypeDTO;
import com.blog.domain.entity.Article;
import com.blog.domain.entity.Type;
import com.blog.domain.query.Query;
import com.blog.domain.vo.ArticleVO;
import com.blog.mapper.ArticleMapper;
import com.blog.mapper.TypeMapper;
import com.blog.service.IArticleService;
import com.blog.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TypeServiceImpl  extends ServiceImpl<TypeMapper, Type> implements ITypeService {
@Autowired
private IArticleService iArticleService;
    @Override
    public void addType(TypeDTO typeDTO) {
//        校验
        if(typeDTO.getName()==null){
            throw new IllegalArgumentException("名字不能为空");
        }
        Type type = BeanUtil.copyProperties(typeDTO, Type.class);

//        添加数据库
        this.save(type);

    }

    @Override
    public void deleteType(Integer id) {
        this.removeById(id);
    }

    @Override
    public void updateType(Type type) {
        //        校验
        if(type.getId()==null){
            throw new IllegalArgumentException("id不能为空");
        }

        if(type.getName()==null){

            throw new IllegalArgumentException("内容或标题不能为空");
        }

//        修改数据库
        this.updateById(type);
    }

    @Override
    public Type getByid(Integer id) {
        Type type = this.getById(id);
        return type;
    }

    @Override
    public  List<Type> getAll() {
return this.list();
    }

    @Override
    public List<Type> queryType(Query query) {
        Page<Type> page = this.lambdaQuery()
              .page(query.toPage());

        List<Type> records = page.getRecords();



        return records;

    }

    @Override
    public  List<ArticleVO> getArticle(Integer id) {
        List<Article> list = iArticleService.lambdaQuery().eq(Article::getType, id).list();
        ArrayList<ArticleVO> VOList = new ArrayList<>();
        for (Article article : list) {
            ArticleVO articleVO = BeanUtil.copyProperties(article, ArticleVO.class);

            articleVO.setType(this.getById(article.getType()).getName());
            VOList.add(articleVO);
        }
        return VOList;
    }
}
