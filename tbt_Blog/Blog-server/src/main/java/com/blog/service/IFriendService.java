package com.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;

import com.blog.domain.dto.FriendDTO;
import com.blog.domain.entity.Friend;
import com.blog.domain.query.Query;
import com.blog.domain.vo.ArticleVO;

import java.util.List;


public interface IFriendService extends IService<Friend> {
    void addFriend(FriendDTO friendDTO);

    void deleteFriend(Integer id);

    void updateFriend(Friend friend);

    Friend getByid(Integer id);

    List<Friend> getAll();

    List<Friend> queryFriend(Query query);
}
