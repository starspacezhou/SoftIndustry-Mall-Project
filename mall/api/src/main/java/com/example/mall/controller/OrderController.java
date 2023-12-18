package com.example.mall.controller;

import com.example.mall.config.MyPayConfig;
import com.example.mall.entity.Orders;
import com.example.mall.service.OrderService;
import com.example.mall.vo.ResStatus;
import com.example.mall.vo.ResultVO;
import com.github.wxpay.sdk.WXPay;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/order")
@Api(value = "提供订单相关的操作接口", tags = "订单接口")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    @ApiOperation("订单添加接口")
    public ResultVO addOrder(String cids, @RequestBody Orders order) {
        ResultVO resultVO = null;
        try {
            Map<String, String> orderInfo = orderService.addOrder(cids, order);
            if (orderInfo != null) {
                String orderId = orderInfo.get("orderId");
                //设置当前订单信息
                HashMap<String, String> data = new HashMap<>();
                data.put("body", orderInfo.get("productNames")); //商品描述
                data.put("out_trade_no", orderId); //使用当前用户订单的编号作为当前支付交易的交易号
                data.put("fee_type", "CNY"); //支付币种
                //data.put("total_fee", order.getActualAmount()*100+""); //将分换算成元
                data.put("total_fee", "1"); //支付金额
                data.put("trade_type", "NATIVE"); //交易类型
                data.put("notify_url", "http://47.118.45.73:8080/pay/callback"); //内网穿透的网址设置支付完成时的回调方法接口

                //发送请求，获取响应
                //微信支付：申请支付连接
                WXPay wxPay = new WXPay(new MyPayConfig());
                Map<String, String> resp = wxPay.unifiedOrder(data);
                orderInfo.put("payUrl", resp.get("code_url"));
                //orderInfo中包含：订单编号，购买的商品名称，支付链接
                resultVO = new ResultVO(ResStatus.OK, "提交订单成功！", orderInfo);
            } else {
                resultVO = new ResultVO(ResStatus.NO, "提交订单失败！", null);
            }
        } catch (SQLException e) {
            resultVO = new ResultVO(ResStatus.NO, "提交订单失败！", null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultVO;
    }

    @GetMapping("/status/{oid}")
    @ApiOperation("订单状态接口")
    public ResultVO getOrderStatus(@PathVariable("oid") String orderId, @RequestHeader("token") String token) {
        ResultVO resultVO = orderService.getOrderById(orderId);
        return resultVO;
    }

    @GetMapping("/list")
    @ApiOperation("订单查询接口")
    @ApiImplicitParams({
            @ApiImplicitParam(dataType = "string", name = "userId", value = "用户ID", required = true),
            @ApiImplicitParam(dataType = "string", name = "status", value = "订单状态", required = false),
            @ApiImplicitParam(dataType = "int", name = "pageNum", value = "当前页码", required = true),
            @ApiImplicitParam(dataType = "int", name = "limit", value = "每页显示条数", required = true)
    })
    public ResultVO list(@RequestHeader("token") String token,
                         String userId, String status, Integer pageNum, Integer limit) {
        ResultVO resultVO = orderService.listOrders(userId, status, pageNum, limit);
        return resultVO;
    }
}
