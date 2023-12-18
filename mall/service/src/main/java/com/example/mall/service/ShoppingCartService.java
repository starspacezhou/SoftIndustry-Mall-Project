package com.example.mall.service;

import com.example.mall.entity.ShoppingCart;
import com.example.mall.vo.ResultVO;

public interface ShoppingCartService {

    public ResultVO addShoppingCart(ShoppingCart cart);

    public ResultVO listShoppingCartsByUserId(int userId);

    public ResultVO updateShoppingCart(int cartId, int cartNum);

    public ResultVO listShoppingCartsByCartIds(String cids);
}
