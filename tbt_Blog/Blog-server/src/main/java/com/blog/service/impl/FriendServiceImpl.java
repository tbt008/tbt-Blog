package com.blog.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.blog.domain.dto.FriendDTO;
import com.blog.domain.entity.Friend;
import com.blog.domain.entity.Label;
import com.blog.domain.query.Query;
import com.blog.domain.vo.ArticleVO;
import com.blog.mapper.FriendMapper;
import com.blog.service.IFriendService;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FriendServiceImpl extends ServiceImpl<FriendMapper, Friend> implements IFriendService {


    @Override
    public void addFriend(FriendDTO friendDTO) {
        //        校验
        if(friendDTO.getDescription()==null||friendDTO.getImg()==null||friendDTO.getName()==null
                ||friendDTO.getUrl()==null){
            throw new IllegalArgumentException("字段不能为空");
        }
        Friend friend = BeanUtil.copyProperties(friendDTO, Friend.class);

//        添加数据库
        this.save(friend);
    }

    @Override
    public void deleteFriend(Integer id) {
  this.removeById(id);
    }

    @Override
    public void updateFriend(Friend friend) {
        //        校验
        if(friend.getId()==null){
            throw new IllegalArgumentException("id不能为空");
        }
        if(friend.getDescription()==null||friend.getImg()==null||friend.getName()==null
                ||friend.getUrl()==null){
            throw new IllegalArgumentException("字段不能为空");
        }

//        修改数据库
        this.updateById(friend);
    }

    @Override
    public Friend getByid(Integer id) {
       return getById(id);
    }

    @Override
    public List<Friend> getAll() {
return list();
    }

    @Override
    public List<Friend> queryFriend(Query query) {
        Page<Friend> page = this.lambdaQuery()
                .page(query.toPage());
        List<Friend> records = page.getRecords();
        return records;
    }
}
