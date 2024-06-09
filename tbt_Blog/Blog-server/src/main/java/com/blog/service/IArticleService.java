package com.blog.service;

import com.blog.domain.dto.ArticleDTO;
import com.blog.domain.entity.Article;
import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.domain.entity.Label;
import com.blog.domain.entity.Type;
import com.blog.domain.query.ArticleQuery;
import com.blog.domain.vo.ArticleVO;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tbt
 * @since 2024-03-22
 */

public interface IArticleService extends IService<Article> {

    void addArticle(Article article);

    void updateArticle(ArticleDTO articleDTO);

    void deleteArticle(Integer id);

    List<ArticleVO> queryArticle(ArticleQuery query);


    Object countId(Integer id);

    Type getTypeById(Integer id);

    List<Label> getLabelById(Integer id);

    void setHideById(Integer id);
}
