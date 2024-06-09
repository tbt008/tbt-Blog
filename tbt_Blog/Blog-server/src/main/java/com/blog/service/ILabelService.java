package com.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.domain.dto.LabelDTO;
import com.blog.domain.entity.Label;
import com.blog.domain.query.Query;

import java.util.List;

public interface ILabelService extends IService<Label> {
    void addLabel(LabelDTO labelDTO);

    void deleteFriend(Integer id);

    void updateLabel(Label label);

    Label getByid(Integer id);

    List<Label> getAll();

    List<Label> queryLabel(Query query);

    Object countId(Integer id);

    List<Long> BatchCount(List<Long> list);
}
