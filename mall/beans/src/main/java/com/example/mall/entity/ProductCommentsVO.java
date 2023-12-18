package com.example.mall.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductCommentsVO {
    private String commId;
    private String productId;
    private String productName;
    private String orderItemId;
    private Integer isAnonymous;
    private Integer commType;
    private Integer commLevel;
    private String commContent;
    private String commImgs;
    private Date commTime;
    private Integer replyStatus;
    private String replyContent;
    private Date replyTime;
    private Integer isShow;
    //封装评论对应的用户数据
    private String userId;
    private String username;
    private String nickname;
    private String userImg;
}
