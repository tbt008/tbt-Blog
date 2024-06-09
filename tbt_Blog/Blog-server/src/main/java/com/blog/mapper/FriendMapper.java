package com.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.domain.entity.Friend;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FriendMapper extends BaseMapper<Friend> {
}
