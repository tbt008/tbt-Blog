package com.blog.controller.user;


import com.blog.Result;
import com.blog.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author tbt
 * @since 2024-05-01
 */
@RestController
@RequestMapping("/music")
public class MusicController {
//查询歌单
    @Autowired
    private IMusicService iMusicService;
    @GetMapping("/get")
    public Result getMusic(){

        return Result.success(iMusicService.getMusic());

    }
}
