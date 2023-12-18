package com.example.mall.service;

import com.example.mall.vo.ResultVO;

public interface ProductCommentsService {

    /**
     * 根据商品id实现评论的分页查询
     * @param productId 商品ID
     * @param pageNum 查询页码
     * @param limit 每页显示条数
     * @return
     */
    public ResultVO listCommentsByProductId(String productId, int pageNum, int limit);

    /**
     * 根据商品ID统计当前商品的评价信息
     * @param productId
     * @return
     */
    public ResultVO getCommentsCountByProductId(String productId);
}
