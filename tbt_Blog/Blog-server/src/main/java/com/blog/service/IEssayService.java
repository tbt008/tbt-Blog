package com.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.domain.entity.Essay;

import java.util.List;

public interface IEssayService extends IService<Essay> {
    void addEssay(Essay essay);

    void deleteEssay(Integer id);



    List<Essay> getAll();

    void updateByid(Essay essay);
}
