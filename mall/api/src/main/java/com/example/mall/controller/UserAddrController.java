package com.example.mall.controller;

import com.example.mall.service.UserAddrService;
import com.example.mall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@Api(value = "提供用户收货地址相关接口",tags = "收货地址管理")
@RequestMapping("/useraddr")
public class UserAddrController {

    @Autowired
    private UserAddrService userAddrService;

    @GetMapping("/list")
    @ApiOperation("用户地址列表接口")
    @ApiImplicitParam(dataType = "int", name = "userId", value = "用户id", required = true)
    public ResultVO listUserAddrs(Integer userId, @RequestHeader("token") String token) {
        ResultVO resultVO = userAddrService.listAddrsByUserId(userId);
        return resultVO;
    }
}
