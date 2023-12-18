package com.example.mall.controller;


import com.example.mall.entity.ShoppingCart;
import com.example.mall.service.ShoppingCartService;
import com.example.mall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/shopcart")
@Api(value = "提供购物车业务相关的接口", tags = "购物车管理")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @ApiOperation("添加购物车接口")
    @PostMapping("/add")
    public ResultVO addShoppingCart(@RequestBody ShoppingCart cart, @RequestHeader("token") String token) {
        ResultVO resultVO = shoppingCartService.addShoppingCart(cart);
        return resultVO;
    }

    @ApiOperation("查询购物车接口")
    @GetMapping("/list")
    @ApiImplicitParam(dataType = "int", name = "userId", value = "用户ID", required = true)
    public ResultVO listShoppingCartsByUserId(Integer userId, @RequestHeader("token") String token) {
        // 前端传用户id
        ResultVO resultVO = shoppingCartService.listShoppingCartsByUserId(userId);
        return resultVO;
    }

    @ApiOperation("修改购物车接口")
    @PutMapping("/update/{cid}/{cnum}")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "int", name = "cid", value = "购物车id", required = true),
            @ApiImplicitParam(dataType = "int", name = "cnum", value = "购物车数量", required = true)
    })
    public ResultVO updateShoppingCart
            (@PathVariable("cid") Integer cardId,
             @PathVariable("cnum") Integer cardNum,
             @RequestHeader("token") String token) {
        // 前端传购物车id和购物车数量
        ResultVO resultVO = shoppingCartService.updateShoppingCart(cardId, cardNum);
        return resultVO;
    }

    @ApiOperation("查询选中购物车接口")
    @GetMapping("/listbycids")
    @ApiImplicitParam(dataType = "String",name = "cids", value = "选择的购物车记录的id",required = true)
    public ResultVO listShoppingCartsByCardIds(String cids, @RequestHeader("token")String token){
        ResultVO resultVO = shoppingCartService.listShoppingCartsByCartIds(cids);
        return resultVO;
    }

}
