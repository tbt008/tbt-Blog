package com.blog.mapper;

import com.blog.domain.entity.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tbt
 * @since 2024-04-28
 */
@Mapper
public interface MessageMapper extends BaseMapper<Message> {

}
