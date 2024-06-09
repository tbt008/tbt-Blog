package com.blog.controller.user;



import cn.hutool.core.bean.BeanUtil;
import com.blog.Result;
import com.blog.domain.entity.Article;
import com.blog.domain.entity.Label;
import com.blog.domain.entity.Type;
import com.blog.domain.query.ArticleQuery;
import com.blog.domain.vo.ArticleVO;
import com.blog.service.IArticleService;
import com.blog.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tbt
 * @since 2024-03-22
 */
@RestController("userArticleController")
@RequestMapping("/user/article")
public class ArticleController {
    @Autowired
    IArticleService iArticleService;

    //         分页查询文章
    @GetMapping("/page")

    public Result getArticlePage(@RequestParam(value = "typeId" ,required = false) Integer typeId,@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize,
    @RequestParam("isAsc") Boolean isAsc
    ){

        ArticleQuery query = new ArticleQuery();
          query.setPageNo(pageNo);
            query.setPageSize(pageSize);
            query.setIsAsc(isAsc);
            if(typeId!=null){
                query.setTypeId(typeId);
            }

        List<ArticleVO> art = iArticleService.queryArticle(query);
        if(art==null){
            return Result.success();
        }
        return Result.success(art);
    }
//    根据id查询
@GetMapping("{id}")
public Result getById(@PathVariable("id") Integer id){

    Article article = iArticleService.getById(id);
    ArticleVO articleVO = BeanUtil.copyProperties(article, ArticleVO.class);
    articleVO.setType(iArticleService.getTypeById(id).getName());
    return Result.success(articleVO);
}
    //    根据id设置隐藏
    @GetMapping("hide/{id}")
    public Result setHideById(@PathVariable("id") Integer id){



        iArticleService.setHideById(id);
        return Result.success();
    }
//查询id对应标签数
    @GetMapping("/count/{id}")
    public Result countId(@PathVariable("id")Integer id){

        return Result.success(iArticleService.countId(id));
    }
    //    根据id查询分类
    @GetMapping("/getTypeById/{id}")
    public Result getTypeById(@PathVariable("id") Integer id){

        Type type = iArticleService.getTypeById(id);
        return Result.success(type);
    }
    @GetMapping("/getLabelById/{id}")
    public Result getLabelById(@PathVariable("id") Integer id){

        List<Label> labelList = iArticleService.getLabelById(id);
        return Result.success(labelList);
    }

}
