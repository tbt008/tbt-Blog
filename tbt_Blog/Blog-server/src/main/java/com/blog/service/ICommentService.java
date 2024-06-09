package com.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.domain.dto.CommentDTO;
import com.blog.domain.entity.Comment;

import java.util.List;

public interface ICommentService extends IService<Comment> {
    List<Comment> getAll();

    List<Comment> getBySourceId(String source,Integer sourceId);

    List<Comment> getByTagetId(Integer tagetId);

    void addBySourceId(CommentDTO commentDTO);

    void addByTagetId(CommentDTO commentDTO);

    void deleteById(Integer id);
}
