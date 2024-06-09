package com.blog.controller.user;

import com.blog.Result;
import com.blog.domain.dto.CommentDTO;
import com.blog.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/comment")
public class CommentController {
    @Autowired
    ICommentService iCommentService;
//    获取所有
    @GetMapping("/getAll")
    public Result getAll(){

        return Result.success(iCommentService.getAll());
    }
//获取一级回复
    @GetMapping("/getOne/{source}/{id}")
    public Result getBySourceId(@PathVariable("source") String source,@PathVariable("id") Integer sourceId){
      return Result.success(iCommentService.getBySourceId(source,sourceId));

    }
    //获取二级回复
    @GetMapping("/getTwo/{id}")
    public Result getByTagetId(@PathVariable("id") Integer tagetId){

        return  Result.success( iCommentService.getByTagetId(tagetId));
    }
    //   添加一级回复
    @PostMapping("/addOne")
    public Result addBySourceId(@RequestBody CommentDTO commentDTO){

        iCommentService.addBySourceId(commentDTO);
        return Result.success();
}
    //   添加二级回复
    @PostMapping("/addTwo")
    public Result addByTagetId(@RequestBody CommentDTO commentDTO){

        iCommentService.addByTagetId(commentDTO);
        return Result.success();
    }
    //  根据id删除
    @PostMapping("/delete/{id}")
    public Result deleteById(@PathVariable("id") Integer id){
        iCommentService.deleteById(id);
        return Result.success();
    }





}
