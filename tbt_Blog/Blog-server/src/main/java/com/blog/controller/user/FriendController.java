package com.blog.controller.user;

import com.blog.Result;
import com.blog.domain.dto.FriendDTO;
import com.blog.domain.entity.Friend;
import com.blog.domain.query.Query;
import com.blog.domain.vo.ArticleVO;
import com.blog.service.IFriendService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/friend")
public class FriendController {


    @Autowired
    private IFriendService iFriendService;
    @PostMapping("/add")
    public Result addFriend(FriendDTO friendDTO){
        iFriendService.addFriend(friendDTO);
        return Result.success();
    }
    @PostMapping("/delete/{id}")
    public Result deleteFriend(@PathVariable("id")Integer id){
        iFriendService.deleteFriend(id);
        return Result.success();
    }
    @PostMapping("/update")
    public Result updateFriend(Friend friend){
        iFriendService.updateFriend(friend);
        return Result.success();
    }
    @GetMapping("/{id}")
    public Result getByid(@PathVariable("id")Integer id){
        return Result.success(iFriendService.getByid(id));
    }  @GetMapping("/getAll")
    public Result getAll(){
        return Result.success(iFriendService.getAll());
    }
    @GetMapping("/page")

    public Result getFriendPage(@RequestParam("pageNo") Integer pageNo, @RequestParam("pageSize") Integer pageSize

    ){

        Query query = new Query();
        query.setPageNo(pageNo);
        query.setPageSize(pageSize);

        List<Friend> art = iFriendService.queryFriend(query);
        if(art==null){
            return Result.success();
        }
        return Result.success(art);
    }
}
