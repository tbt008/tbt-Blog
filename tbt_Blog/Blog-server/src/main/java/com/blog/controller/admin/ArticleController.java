package com.blog.controller.admin;

import com.blog.Result;
import com.blog.domain.dto.ArticleDTO;
import com.blog.domain.dto.LabelDTO;
import com.blog.domain.entity.Article;
import com.blog.domain.entity.Label;
import com.blog.domain.entity.LabelArticle;
import com.blog.service.IArticleService;
import com.blog.service.ILabelArticleService;
import com.blog.service.ILabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tbt
 * @since 2024-03-22
 */
@RestController
@RequestMapping("/admin/article")
@CrossOrigin(origins = "*")
public class ArticleController {
  @Resource
  private IArticleService iArticleService;
  @Autowired
  private ILabelService iLabelService;
  @Autowired
  private ILabelArticleService iLabelArticleService;
//     添加文章
  @PostMapping("/upload")
    public Result addArticle(  ArticleDTO articleDTO) throws IOException {


      Article article=new Article();
      article.setContent(articleDTO.getContent());
      article.setTitle(articleDTO.getTitle());
      article.setDescription(articleDTO.getDescription());
      article.setCoverImg(articleDTO.getCoverImg());
      article.setType(articleDTO.getType());
    //        把标签都保存一遍
    iArticleService.addArticle(article);
    List<String> label = articleDTO.getLabel();
//   查询文章
    Article art = iArticleService.lambdaQuery()
            .eq(Article::getCoverImg, articleDTO.getCoverImg())
            .eq(Article::getContent, articleDTO.getContent())
            .eq(Article::getDescription, articleDTO.getDescription())
            .one();
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
//           新增关联表
      LabelArticle labelArticle = new LabelArticle();
      labelArticle.setArticleId(art.getId());
      labelArticle.setLabelId(name.getId());
      iLabelArticleService.save(labelArticle);
    }


      return Result.success();
  }

    //     修改文章
    @PostMapping("/update")
    public Result updateArticle( ArticleDTO articleDTO){
      iArticleService.updateArticle(articleDTO);
      return Result.success();
    }

     //删除文章
   @PostMapping("/delete/{id}")
  public Result deleteArticle(@PathVariable("id") Integer id){
     iArticleService.deleteArticle(id);
     return Result.success();
  }


}
