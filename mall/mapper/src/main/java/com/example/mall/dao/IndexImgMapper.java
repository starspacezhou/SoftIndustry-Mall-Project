package com.example.mall.dao;

import com.example.mall.entity.IndexImg;
import com.example.mall.general.GeneralDAO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IndexImgMapper extends GeneralDAO<IndexImg> {

    //1.查询轮播图信息：查询status=1且按照seq进行排序
    public List<IndexImg> selectIndexImgs();
}