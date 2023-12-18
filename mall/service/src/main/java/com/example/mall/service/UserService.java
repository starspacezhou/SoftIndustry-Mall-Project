package com.example.mall.service;

import com.example.mall.vo.ResultVO;

public interface UserService {

    // 用户注册
    public ResultVO userRegister(String name, String pwd);

    // 用户登录
    public ResultVO checkLogin(String name, String pwd);
}
