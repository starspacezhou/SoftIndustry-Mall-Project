package com.example.mall.dao;

import com.example.mall.entity.Orders;
import com.example.mall.entity.OrdersVO;
import com.example.mall.general.GeneralDAO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersMapper extends GeneralDAO<Orders> {

    /**
     * 根据用户id和状态分页查询订单
     * @param userId
     * @param status
     * @param start
     * @param limit
     * @return
     */
    public List<OrdersVO> selectOrders(@Param("userId") String userId,
                                       @Param("status") String status,
                                       @Param("start") int start,
                                       @Param("limit") int limit);
}