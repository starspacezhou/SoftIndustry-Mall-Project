package com.example.mall.service.impl;

import com.example.mall.dao.IndexImgMapper;
import com.example.mall.entity.IndexImg;
import com.example.mall.service.IndexImgService;
import com.example.mall.vo.ResStatus;
import com.example.mall.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndexImgServiceImpl implements IndexImgService {

    @Autowired
    private IndexImgMapper indexImgMapper;

    @Override
    public ResultVO listIndexImgs() {
        List<IndexImg> indexImgs = indexImgMapper.selectIndexImgs();
        if (indexImgs.size() == 0) {
            return new ResultVO(ResStatus.NO, "轮播图查询失败", null);
        } else {
            return new ResultVO(ResStatus.OK, "轮播图查询成功", indexImgs);
        }
    }
}
