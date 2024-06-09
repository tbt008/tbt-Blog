package com.blog.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.domain.dto.LabelDTO;
import com.blog.domain.entity.Label;
import com.blog.domain.entity.LabelArticle;
import com.blog.domain.query.Query;
import com.blog.mapper.LabelMapper;

import com.blog.service.ILabelService;
import com.blog.service.ILabelArticleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class LabelServiceImpl  extends ServiceImpl<LabelMapper, Label> implements ILabelService {
   @Resource
   private ILabelArticleService ILabelArticleService;

    @Override
    public void addLabel(LabelDTO labelDTO) {
        //        校验
        if(labelDTO.getName()==null){
            throw new IllegalArgumentException("名字不能为空");
        }
        Label label = BeanUtil.copyProperties(labelDTO, Label.class);

//        添加数据库
        this.save(label);
    }

    @Override
    public void deleteFriend(Integer id) {
        this.removeById(id);
    }

    @Override
    public void updateLabel(Label label) {
        //        校验
        if(label.getId()==null){
            throw new IllegalArgumentException("id不能为空");
        }

        if(label.getName()==null){

            throw new IllegalArgumentException("内容或标题不能为空");
        }

//        修改数据库
        this.updateById(label);
    }

    @Override
    public Label getByid(Integer id) {
      return this.getById(id);
    }

    @Override
    public List<Label>  getAll() {
return this.list();
    }

    @Override
    public List<Label> queryLabel(Query query) {
        Page<Label> page = this.lambdaQuery()
                .page(query.toPage());

        List<Label> records = page.getRecords();



        return records;
    }

    @Override
    public Long countId(Integer id) {

        List<LabelArticle> list1 = ILabelArticleService.list();
        List<LabelArticle> collect = list1.stream().filter(new Predicate<LabelArticle>() {
            @Override
            public boolean test(LabelArticle labelArticle) {
                if (labelArticle.getLabelId() == id) {
                    return true;
                }
                return false;
            }
        }).collect(Collectors.toList());
        Long count = Long.valueOf(collect.size());
        return count;
    }

    @Override
    public List<Long> BatchCount(List<Long> list) {
//        System.out.println("!!!!!!!");
        for (int i=0;i<list.size();i++) {

            Long id=list.get(i);
            List<LabelArticle> list1 = ILabelArticleService.list();
            List<LabelArticle> collect = list1.stream().filter(new Predicate<LabelArticle>() {
                @Override
                public boolean test(LabelArticle labelArticle) {
                    if (labelArticle.getLabelId() == id.intValue()) {
                        return true;
                    }
                    return false;
                }
            }).collect(Collectors.toList());
            Long count = Long.valueOf(collect.size());

            list.set(i,count);
        }
      return list;
    }
}
