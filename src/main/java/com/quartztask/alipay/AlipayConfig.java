package com.quartztask.alipay;

/* *
 *类名：AlipayConfig
 *功能：基础配置类 WAP端
 *详细：设置帐户有关信息及返回路径
 *版本：3.3
 *日期：2012-08-10
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。

 *提示：如何获取安全校验码和合作身份者ID
 *1.用您的签约支付宝账号登录支付宝网站(www.alipay.com)
 *2.点击“商家服务”(https://b.alipay.com/order/myOrder.htm)
 *3.点击“查询合作者身份(PID)”、“查询安全校验码(Key)”

 *安全校验码查看时，输入支付密码后，页面呈灰色的现象，怎么办？
 *解决方法：
 *1、检查浏览器配置，不让浏览器做弹框屏蔽设置
 *2、更换浏览器或电脑，重新登录查询。
 */

public class AlipayConfig {

    // ↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓
    // 合作身份者ID，以2088开头由16位纯数字组成的字符串
    public static String partner = "2088021116899573";

    // 收款支付宝账号，以2088开头由16位纯数字组成的字符串
    public static String seller_id = partner;

    // 签约支付宝账号
    public static String seller_email = "chehaoyunfinancial@anji-logistics.com";

    // 商户的私钥
    public static String private_key = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBAJXMZqi+SL1Odyqc6QJ80aNpRfW1tuvJCdeW7wATrSt"
            + "t+PDmmOB59DL8pzBUz2m9NQL4X+2OeoEiqgLK72yHpsotfDLuLRGG1P1DCoyHpPUUfgkF7fF9J6VAY4pm+5P/Yhgz/23pXCeDUQgxwShSBwD2GSqKQ/U"
            + "X5oy9MexcHebDAgMBAAECgYEAhUntBrTZ8GgDLM2Vn3sE5kxjzbA05TRrJ4PLgdwAOCaQXXoyCXs6SKv678xnCgUrSEtMwAoJAyKe+AEubPl+9AZm1Vl"
            + "gj64tmiRxB9vAccSsGqjFY1TbiMWi5ma8BuId2aQZXx7OGnq/cOQQpTmu7bW6LVoxfEqE8/Ek5SCnLkECQQDFjnD1CWnOk6nU0mPYrZOvIr9cdbuJVwI"
            + "edK2kIgLlmIyTZMpt1bskQYDRSSJIcnRqp3POqQwzyFnYcUQXreJTAkEAwh0Z0ROHxBFHsQELkvukERYRmPZ+acDubNZN64jluOVsU6I4Hoe51YEA+VT"
            + "jkMQc+4NmnzurnXWcaWydCiU70QJBAKLTxEYyfALHsjK3NZRhfFfdS9vpLakFDboMcRHW9oxGL5dMe4wLnTNEyee1X4xWyZ0eZ1TuACCuAV9j+7uIlgE"
            + "CQF96yPQaUzGR/l2GUhceR/lPjaBbvppuF9jZIMK2N6jW0I3iwQ/jWvk11zDNHJJcpJTicVvpkeSFsUX58tTGs8ECQERfDw93SOEEotcTZJsa0xk5oD9"
            + "bbko3URbejs5OwEQUiXGkO4SKX0MfUxFw/Q6qqzTE1b6k6iBhUrMEPwo7JV0=";

    // 支付宝的公钥，无需修改该值
    public static String ali_public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCnxj/9qwVfgoUh/y2W89L6BkRAFljhNhgPdyPuBV64bfQNN1PjbCz"
            + "kIM6qRdKBoLPXmKKMiFYnkd6rAoprih3/PrQEB/VsW8OoM8fxn67UDYuyBTqA23MML9q1+ilIZwBC2AQ2UBVOrFXfFl75p6/B5KsiNG9zpgmLCUYuLkxpLQIDAQAB";

    // ↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    // 调试用，创建TXT日志文件夹路径
    public static String log_path = "/data/weball/anjiilp2/logs/anjiilp2/";

    // 字符编码格式 目前支持 gbk 或 utf-8
    public static String input_charset = "utf-8";

    // 签名方式 不需修改
    public static String sign_type = "RSA";

}
