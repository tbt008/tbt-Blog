package com.blog.controller.user;

import com.blog.Result;
import com.blog.domain.dto.LabelDTO;
import com.blog.domain.dto.TypeDTO;
import com.blog.domain.entity.Type;
import com.blog.domain.query.ArticleQuery;
import com.blog.domain.query.Query;
import com.blog.domain.vo.ArticleVO;
import com.blog.service.ILabelService;
import com.blog.service.ITypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/type")
public class TypeController {


    @Autowired
    private ITypeService iTypeService;


    @PostMapping("/add")
    public Result addType(TypeDTO typeDTO){

        iTypeService.addType(typeDTO);
        return Result.success();
    }
    @PostMapping("/delete/{id}")
    public Result deleteType(@PathVariable("id")Integer id){
        iTypeService.deleteType(id);
        return Result.success();
    }
    @PostMapping("/update")
    public Result updateType(Type type){
        iTypeService.updateType(type);

        return Result.success();
    }
//    根据id查所以文章
    @GetMapping("/getArticle/{id}")
    public Result getArticle(@PathVariable("id")Integer id){

        return Result.success(iTypeService.getArticle(id));
    }
    @GetMapping("/{id}")
    public Result getByid(@PathVariable("id")Integer id){

        return Result.success(iTypeService.getByid(id));
    }  @GetMapping("/getAll")
    public Result getAll(){

        return Result.success(iTypeService.getAll());
    }
    @GetMapping("/page")

    public Result getTypePage(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize

    ){

        Query query = new Query();
        query.setPageNo(pageNo);
        query.setPageSize(pageSize);

        List<Type> art = iTypeService.queryType(query);
        if(art==null){
            return Result.success();
        }
        return Result.success(art);
    }
}
