package com.blog.service;

import com.blog.domain.entity.Music;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tbt
 * @since 2024-05-01
 */
public interface IMusicService extends IService<Music> {

    List<Music> getMusic();
}
