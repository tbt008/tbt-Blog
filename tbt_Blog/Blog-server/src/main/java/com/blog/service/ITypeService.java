package com.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.blog.domain.dto.TypeDTO;
import com.blog.domain.entity.Type;
import com.blog.domain.query.Query;

import java.util.List;

public interface ITypeService extends IService<Type> {
    void addType(TypeDTO typeDTO);

    void deleteType(Integer id);

    void updateType(Type type);

    Type getByid(Integer id);

    List<Type> getAll();

    List<Type> queryType(Query query);

    Object getArticle(Integer id);
}
