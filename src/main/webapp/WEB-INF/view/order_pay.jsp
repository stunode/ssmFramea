<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!doctype html>
<html class="no-js fixed-layout">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>互联物流平台</title>

  <meta name="keywords" content="index">

  <meta name="renderer" content="webkit">
  <meta http-equiv="Cache-Control" content="no-siteapp"/>

  <%--<link rel="stylesheet" href="${resRoot}css/amazeui.css"/>--%>
  <%--<link rel="stylesheet" href="${resRoot}css/base.css">--%>
  <%--<link rel="stylesheet" href="${resRoot}css/personal.css">--%>
  <%--<link rel="stylesheet" href="${resRoot}css/order.css">--%>
  <%--<link rel="stylesheet" href="${resRoot}css/bank.css">--%>
</head>

<body>
<div class="page-frame">
  <div class="am-u-lg-12">
    <!-- content start -->
    <div class="main-content">
      <div class="main-content-body">
        <div class="am-panel am-panel-default">
          <div class="am-panel-bd">
            <h3 class="title">
              <i class="icon-list"></i> <span>订单支付</span>

            </h3>
            <div class="detail">
              <hr>
              <div class="am-g order-detail pay">
                <label class="am-u-lg-2">支付方式</label>

                <div class="am-u-lg-9">
                  <div class="am-form-group pay_radio">
                    <label class="am-radio-inline">
                      <input type="radio" name="pay_radio-group" value="alipay">
                      <img src="${resRoot}i/pay_alipay.png"/> 支付宝
                    </label>
                  </div>
                </div>
              </div>

            </div>

            <div class="clearfix"></div>
          </div>
        </div>

      </div>
    </div>
    <!-- content end -->
  </div>
</div>



<script>

  $(function () {

    $("input[name='pay_radio-group']").each(function () {
      $(this).click(function () {
        $("#weixinpic").remove();
        $(".pay_way").css("border","");
        $(".pay_way").show();


        if ($(this).val() == "alipay") {
          $(".allhide ").hide();
          $(".creatcard_bank").hide();
          $(".pay_way").css("border","1px");
          window.open(getBasePath() + "/alipay/pcalipay.htm?orderId=${order.orderId}")
        }
      });
    });
  })


</script>
</body>

</html>