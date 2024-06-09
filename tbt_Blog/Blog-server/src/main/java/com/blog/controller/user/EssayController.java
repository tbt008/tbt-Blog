package com.blog.controller.user;

import com.blog.Result;
import com.blog.domain.entity.Essay;
import com.blog.service.IEssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user/essay")
public class EssayController {
    @Autowired
    private IEssayService iEssayService;
    @PostMapping("/add")
    public Result addEssay(Essay essay){
        iEssayService.addEssay(essay);
        return Result.success();
    }
    @PostMapping("/delete/{id}")
    public Result deleteEssay(@PathVariable("id") Integer id){
        iEssayService.deleteEssay(id);
        return Result.success();
    } @PostMapping("/update")
    public Result updateEssay(Essay essay){
        iEssayService.updateByid(essay);
        return Result.success();
    }
    @GetMapping("/get/{id}")
    public Result getById(@PathVariable("id") Integer id){

        return Result.success(iEssayService.getById(id));
    }
    @GetMapping("get/all")
    public Result getAll(){

        return Result.success( iEssayService.getAll());
    }
}
