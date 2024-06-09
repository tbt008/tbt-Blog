package com.blog.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.domain.dto.CommentDTO;
import com.blog.domain.entity.Comment;
import com.blog.mapper.CommentMapper;
import com.blog.service.ICommentService;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class CommentServiceImpl  extends ServiceImpl<CommentMapper, Comment> implements ICommentService {



    @Override
    public List<Comment> getAll() {
        return this.list();
    }

    @Override
    public List<Comment> getBySourceId(String source, Integer sourceId) {
      return this.lambdaQuery().eq(Comment::getSource,source)
              .eq(Comment::getSourceId,sourceId).orderBy(true,false,Comment::getCreateTime).list();
    }

    @Override
    public List<Comment> getByTagetId(Integer tagetId) {
        return this.lambdaQuery().eq(Comment::getTargetId,tagetId).list();
    }

    @Override
    public void addBySourceId(CommentDTO commentDTO) {
        Comment comment = BeanUtil.copyProperties(commentDTO, Comment.class);
        comment.setCreateTime(LocalDateTime.now());
        this.save(comment);

    }

    @Override
    public void addByTagetId(CommentDTO commentDTO) {
        if(commentDTO.getTargetId()==null||commentDTO.getSource()==null){
            return;
        }
        Comment comment = BeanUtil.copyProperties(commentDTO, Comment.class);
        Comment byId = this.getById(commentDTO.getTargetId());
        comment.setTargetName(byId.getName());
        comment.setCreateTime(LocalDateTime.now());
        this.save(comment);
    }

    @Override
    public void deleteById(Integer id) {
this.removeById(id);
    }
}
