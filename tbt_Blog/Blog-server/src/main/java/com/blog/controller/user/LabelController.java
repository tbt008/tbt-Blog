package com.blog.controller.user;

import com.blog.Result;
import com.blog.domain.dto.LabelDTO;
import com.blog.domain.entity.Label;
import com.blog.domain.query.ArticleQuery;
import com.blog.domain.query.Query;
import com.blog.domain.vo.ArticleVO;
import com.blog.service.IFriendService;
import com.blog.service.ILabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/label")
public class LabelController {

    @Autowired
    private ILabelService iLabelService;

    @PostMapping("/add")
    public Result addLabel(LabelDTO labelDTO){

        iLabelService.addLabel(labelDTO);
        return Result.success();
    }
    @PostMapping("/delete/{id}")
    public Result deleteLabel(@PathVariable("id")Integer id){
        iLabelService.deleteFriend(id);
        return Result.success();
    }
    @PostMapping("/update")
    public Result updateLabel(Label label){

        iLabelService.updateLabel(label);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getByid(@PathVariable("id")Integer id){

        return Result.success(iLabelService.getByid(id));
    }
    @GetMapping("/count/{id}")
    public Result countId(@PathVariable("id")Integer id){
        return Result.success(iLabelService.countId(id));
    }
    @GetMapping("/BatchCount")
    public Result BatchCount(@RequestParam("ids") List<Long> list){
        return Result.success(iLabelService.BatchCount(list));
    }
    @GetMapping("/getAll")
    public Result getAll(){

        return Result.success(iLabelService.getAll());
    }


    @GetMapping("/page")

    public Result getLabelPage(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize

    ){

        Query query = new Query();
        query.setPageNo(pageNo);
        query.setPageSize(pageSize);

        List<Label> art = iLabelService.queryLabel(query);
        if(art==null){
            return Result.success();
        }
        return Result.success(art);
    }
}

