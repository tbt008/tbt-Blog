package com.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.domain.entity.Label;
import com.blog.domain.entity.LabelArticle;

import java.util.List;

public interface ILabelArticleService extends IService<LabelArticle> {

     List<Label> getLabelByArticleId(Integer id);
}
