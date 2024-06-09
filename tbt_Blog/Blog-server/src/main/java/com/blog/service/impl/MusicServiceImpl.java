package com.blog.service.impl;

import com.blog.domain.entity.Music;
import com.blog.mapper.MusicMapper;
import com.blog.service.IMusicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tbt
 * @since 2024-05-01
 */
@Service
public class MusicServiceImpl extends ServiceImpl<MusicMapper, Music> implements IMusicService {

    @Override
    public List<Music> getMusic() {
       return this.lambdaQuery().list();
    }
}
