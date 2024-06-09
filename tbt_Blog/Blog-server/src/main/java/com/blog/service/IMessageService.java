package com.blog.service;

import com.blog.domain.dto.MessageDTO;
import com.blog.domain.entity.Message;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author tbt
 * @since 2024-04-28
 */
public interface IMessageService extends IService<Message> {

    List<Message> getAllMessage();

   void addMessage(MessageDTO messageDTO);
}
