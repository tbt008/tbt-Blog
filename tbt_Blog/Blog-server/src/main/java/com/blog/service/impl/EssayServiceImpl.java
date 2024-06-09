package com.blog.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.blog.domain.entity.Essay;
import com.blog.mapper.EssayMapper;
import com.blog.service.IEssayService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EssayServiceImpl extends ServiceImpl<EssayMapper, Essay> implements IEssayService {
    @Override
    public void addEssay(Essay essay) {
        essay.setCreateTime(LocalDateTime.now());
this.save(essay);
    }

    @Override
    public void deleteEssay(Integer id) {
this.removeById(id);
    }

    @Override
    public List<Essay> getAll() {
      return this.lambdaQuery().orderBy(true,false,Essay::getCreateTime).list();
    }

    @Override
    public void updateByid(Essay essay) {
this.updateById(essay);
    }
}
