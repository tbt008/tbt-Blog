package com.blog.mapper;

import com.blog.domain.entity.Article;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;


/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tbt
 * @since 2024-03-22
 */
@Mapper
public interface ArticleMapper extends BaseMapper<Article> {

}
