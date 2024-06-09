package com.blog.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.blog.domain.dto.MessageDTO;
import com.blog.domain.entity.Message;
import com.blog.mapper.MessageMapper;
import com.blog.service.IMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {


    @Override
    public List<Message> getAllMessage() {
        List<Message> list = this.lambdaQuery().orderBy(true,false,Message::getCreateTime).list();
        return list;
    }

    @Override
    public void addMessage(MessageDTO messageDTO) {
//        System.out.println(messageDTO);
        Message message = BeanUtil.copyProperties(messageDTO, Message.class);
        message.setCreateTime(LocalDateTime.now());
        this.save(message);
    }
}
