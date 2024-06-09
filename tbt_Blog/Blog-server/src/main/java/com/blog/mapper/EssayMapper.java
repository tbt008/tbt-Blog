package com.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.blog.domain.entity.Essay;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface EssayMapper extends BaseMapper<Essay> {
}
