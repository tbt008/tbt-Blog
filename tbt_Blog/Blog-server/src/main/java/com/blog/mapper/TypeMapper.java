package com.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.blog.domain.entity.Type;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TypeMapper extends BaseMapper<Type> {
}
