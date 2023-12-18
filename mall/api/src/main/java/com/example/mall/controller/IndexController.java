package com.example.mall.controller;

import com.example.mall.service.CategoryService;
import com.example.mall.service.IndexImgService;
import com.example.mall.service.ProductService;
import com.example.mall.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/index")
@Api(value = "提供首页数据显示所需的接口", tags = "首页管理")
public class IndexController {

    @Autowired
    private IndexImgService indexImgService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @ApiOperation("首页轮播图接口")
    @GetMapping("/index-image")
    public ResultVO listIndexImgs() {
        return indexImgService.listIndexImgs();
    }

    @ApiOperation("商品分类查询接口")
    @GetMapping("/category-list")
    public ResultVO listCategory() {
        return categoryService.listCategories();
    }

    @ApiOperation("新品推荐接口")
    @GetMapping("/recommend-list")
    public ResultVO listRecommendProducts() {
        return productService.listRecommendProducts();
    }

    @ApiOperation("分类推荐接口")
    @GetMapping("/recommend-category")
    public ResultVO listRecommendProductsByCategoryId() {
        return categoryService.listFirstLevelCategories();
    }
}
