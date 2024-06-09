package com.blog.controller.user;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.blog.Result;
import com.blog.domain.dto.MessageDTO;
import com.blog.domain.entity.Message;
import com.blog.domain.query.ArticleQuery;
import com.blog.domain.vo.ArticleVO;
import com.blog.service.IMessageService;
import com.blog.service.impl.MessageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private IMessageService iMessageService;

    @GetMapping("/getAll")
    public Result getAllMessage(){
        return Result.success(iMessageService.getAllMessage());
    }


    //         分页查询
    @GetMapping("/page")

    public Result getArticlePage(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize ){
        List<Message> records = iMessageService.lambdaQuery().orderBy(true,false,Message::getCreateTime).page(new Page<>(pageNo, pageSize)).getRecords();
        return Result.success(records);
    }
    @PostMapping("/add")
    public Result addMessage(@RequestBody MessageDTO messageDTO){

        iMessageService.addMessage(messageDTO);
        return Result.success();
    }
    //删除留言
    @PostMapping("/delete/{id}")
    public Result deleteArticle(@PathVariable("id") Integer id){
        iMessageService.removeById(id);
        return Result.success();
    }

}
