package com.tbl.studentmanager.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tbl.studentmanager.exception.ServiceException;
import com.tbl.studentmanager.mapper.UserMapper;
import com.tbl.studentmanager.model.Fee;
import com.tbl.studentmanager.model.User;
import com.tbl.studentmanager.utils.SysUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Objects;

@Service
public class UserService {

    @Autowired
    public UserMapper userMapper;

    public User getUserByUserId(String userId){
        return userMapper.findByUserId(userId);
    }

    public User saveUser(User user) {
        User newUser = getUserByUserId(user.getUserId());
        if (newUser != null){
            throw new ServiceException("user existed");
        }
        if (!StringUtils.hasLength(user.getUserId())){
            throw new ServiceException("userId is required");
        }
        SysUtils.checkRole(user.getRollId());
        if (!StringUtils.hasLength(user.getPassword())){
            throw new ServiceException("password is required");
        }
        user.setPassword(SysUtils.encodePwd(user.getPassword()));
        userMapper.insert(user);
        return getUserByUserId(user.getUserId());
    }

    public void deleteUser(User user) {
        User u = getUserByUserId(user.getUserId());
        if (u == null){
            return;
        }
        if (u.getUserId().equals("000")){
            throw new ServiceException("userId is admin");
        }
        userMapper.deleteByUserId(user.getUserId());
    }

    public void updateUser(User user) {
        if (!StringUtils.hasLength(user.getUserId())){
            throw new ServiceException("userId is required");
        }
        userMapper.updateByUserId(user);
    }

    public PageInfo<User> list(User user) {
        Objects.requireNonNull(user.getPage(), "page is required");
        Objects.requireNonNull(user.getSize(), "size is required");
        PageHelper.startPage(user.getPage(), user.getSize());
        List<User> results = userMapper.findAll(user);
        return new PageInfo<>(results);
    }
}
