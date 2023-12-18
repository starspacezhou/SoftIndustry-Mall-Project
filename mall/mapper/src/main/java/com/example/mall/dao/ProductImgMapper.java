package com.example.mall.dao;

import com.example.mall.entity.ProductImg;
import com.example.mall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductImgMapper extends GeneralDAO<ProductImg> {

    /**
     * 根据商品id查询当前商品的图片信息
     * @param productId 商品ID
     * @return
     */
    public List<ProductImg> selectProductImgByProductId(int productId);
}