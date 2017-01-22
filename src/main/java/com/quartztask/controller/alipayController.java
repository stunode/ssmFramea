package com.quartztask.controller;

import com.quartztask.alipay.AlipayConfig;
import com.quartztask.alipay.AlipaySubmit;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * 支付宝支付接口调用
 */
@Controller
@RequestMapping("/alipay")
public class alipayController {

    // 服务器异步通知页面路径
    // 需http://格式的完整路径，不能加?id=123这类自定义参数
    private final String notify_url = "http://192.168.199.167:9090/anjiilp/alipay/webNotifyUrl";
    // 页面跳转同步通知页面路径
    // 需http://格式的完整路径，不能加?id=123这类自定义参数，不能写成http://localhost/
    private final String return_url = "http://192.168.199.167:9090/anjiilp/alipay/webReturnUrl";

    //跳转到支付宝确认支付页面
    @RequestMapping("/alipay")
    public String alipay() {
        return "order_pay";
    }
    //跳转到支付宝确认支付页面
    @RequestMapping("/pcalipay")
    public String pcalipay(Model model) {

        String payment_type = "1";//订单类型
        String out_trade_no = "11111111";//订单号
        String subject = "车好运订单";//订单名称
        String total_fee = "222";//付款金额
        //必填
        //订单描述
        String body = "车好运订单-车辆运输费用";

        //把请求参数打包成数组
        Map<String, String> sParaTemp = new HashMap<>();
        sParaTemp.put("service", "create_direct_pay_by_user");
        sParaTemp.put("partner", AlipayConfig.partner);
        sParaTemp.put("seller_email", AlipayConfig.seller_email);
        sParaTemp.put("_input_charset", AlipayConfig.input_charset);
        sParaTemp.put("payment_type", payment_type);
        sParaTemp.put("notify_url", notify_url);
        sParaTemp.put("return_url", return_url);
        sParaTemp.put("out_trade_no", out_trade_no);
        sParaTemp.put("subject", subject);
        sParaTemp.put("total_fee", total_fee);
        sParaTemp.put("body", body);

        //建立请求
        String sHtmlText = AlipaySubmit.buildRequest(sParaTemp, "get", "确认");
        model.addAttribute("sHtmlText", sHtmlText);

        return "commonpay/alipay";
    }
}
