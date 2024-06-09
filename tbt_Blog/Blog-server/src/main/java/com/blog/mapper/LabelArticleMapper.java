package com.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.domain.entity.Label;
import com.blog.domain.entity.LabelArticle;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LabelArticleMapper extends BaseMapper<LabelArticle> {


}
