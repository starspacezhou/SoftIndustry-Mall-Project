package com.example.mall.dao;

import com.example.mall.entity.ShoppingCart;
import com.example.mall.entity.ShoppingCartVO;
import com.example.mall.general.GeneralDAO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShoppingCartMapper extends GeneralDAO<ShoppingCart> {

    /**
     * 根据用户ID查询购物车有关信息
     * @return
     */
    public List<ShoppingCartVO> selectShoppingCartByUserId(int userId);

    /**
     * 根据购物车ID更新购物车数量
     * @param cartId 购物车ID
     * @param cartNum 购物车数量
     * @return
     */
    public int updateCartNumByCartId(@Param("cartId") int cartId,
                                     @Param("cartNum") int cartNum);

    /**
     * 根据动态SQL查询购物车有关信息
     * @param cids
     * @return
     */
    public List<ShoppingCartVO> selectShoppingCartByCartIds(List<Integer> cids);

}