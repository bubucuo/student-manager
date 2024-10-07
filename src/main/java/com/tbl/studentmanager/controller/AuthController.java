package com.tbl.studentmanager.controller;

import com.tbl.studentmanager.exception.ServiceException;
import com.tbl.studentmanager.model.LoginRequest;
import com.tbl.studentmanager.model.R;
import com.tbl.studentmanager.model.User;
import com.tbl.studentmanager.service.UserService;
import com.tbl.studentmanager.utils.SysUtils;
import com.tbl.studentmanager.utils.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("")
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public Object login(@RequestBody LoginRequest loginRequest){
        User user = userService.getUserByUserId(loginRequest.getUserId());
        if(user == null){
            throw new ServiceException("用户不存在");
        }
        if(!SysUtils.encodePwd(loginRequest.getPassword()).equals(user.getPassword())){
            throw new ServiceException("密码不正确");
        }
        SysUtils.setUserInfo(new UserInfo(UUID.randomUUID().toString(), user.getName(), user.getRollId()));
        return R.OK();
    }

    @PostMapping("/logout")
    public Object logout(){
        SysUtils.removeUserInfo();
        return R.OK();
    }
}
