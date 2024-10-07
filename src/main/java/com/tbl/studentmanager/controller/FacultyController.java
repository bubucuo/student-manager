package com.tbl.studentmanager.controller;

import com.tbl.studentmanager.model.R;
import com.tbl.studentmanager.model.User;
import com.tbl.studentmanager.service.UserService;
import com.tbl.studentmanager.utils.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    private UserService userService;

    @PostMapping("/faculty/add")
    public Object register(@RequestBody User user){
        user.setRollId(Const.faculty);
        return R.OK(userService.saveUser(user));
    }

    @PostMapping("/faculty/delete")
    public Object delete(@RequestBody User user){
        userService.deleteUser(user);
        return R.OK();
    }

    @PostMapping("/faculty/update")
    public Object update(@RequestBody User user){
        userService.updateUser(user);
        return R.OK();
    }
}
