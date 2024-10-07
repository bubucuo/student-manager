package com.tbl.studentmanager.controller;

import com.tbl.studentmanager.model.R;
import com.tbl.studentmanager.model.User;
import com.tbl.studentmanager.service.UserService;
import com.tbl.studentmanager.utils.Const;
import com.tbl.studentmanager.utils.SysUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Object register(@RequestBody User user){
        user.setRollId(Const.student);
        return R.OK(userService.saveUser(user));
    }

    @PostMapping("/delete")
    public Object delete(@RequestBody User user){

        userService.deleteUser(user);
        return R.OK();
    }

    @PostMapping("/update")
    public Object update(@RequestBody User user){
        userService.updateUser(user);
        return R.OK();
    }

    @PostMapping("/list")
    public Object list(@RequestBody User user){
        SysUtils.checkAdmin();
        userService.list(user);
        return R.OK();
    }
}
