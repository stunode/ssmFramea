package com.quartztask.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * 百度地图接口工具类
 */
public class BasePriceByBaiduMap {
    /**城市之间的距离，单位：公里**/
    public static final String CITY_DISTANCE = "CITY_DISTANCE";
    /**城市之间的运输价格，单位：元**/
    public static final String CITY_PRICE = "CITY_PRICE";

    private final String ak = "g8uk5hqjt1ccLnISoWt17vz4wDpYoGW9";

    /**
     * 获得两个城市之间的距离，单位：米
     * http://api.map.baidu.com/direction/v1/routematrix
     * ?output=json
     * &origins=%E5%8C%97%E4%BA%AC
     * &destinations=%E4%B8%8A%E6%B5%B7
     * &ak=vdaBLGVOiAsQOKzIgnUSiNij
     * 如果距离没有正常获得，则为-1
     */
    public int getCitysDistance(String fromCity, String toCity) {
        int ndistance;
        try {
            String distance = "";
            String url = "http://api.map.baidu.com/direction/v1/routematrix?"
                    + "origins=" + fromCity //起点名称
                    + "&destinations=" + toCity//终点名称
                    + "&output=json&ak=" + this.ak;
            String json = this.loadJSON(url);
            JSONObject obj = JSON.parseObject(json);
            if (obj.get("status").toString().equals("0")) {
                JSONArray routes = obj.getJSONObject("result").getJSONArray("elements");
                if (routes.size() > 0) {
                    JSONObject rt = (JSONObject) routes.get(0);
                    JSONObject dis = (JSONObject) rt.get("distance");
                    distance = dis.get("value").toString();
                }
            }
            ndistance = Integer.parseInt(distance);
        } catch (Exception e) {
            ndistance = -1;
        }
        return ndistance;
    }

    //调用百度接口
    private String loadJSON(String url) {
        StringBuilder json = new StringBuilder();
        BufferedReader in = null;
        try {
            URL qurl = new URL(url);
            URLConnection yc = qurl.openConnection();
            in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null) {
                json.append(inputLine);
            }
        } catch (MalformedURLException e) {
            return "-1";
        } catch (IOException e) {
            return "-1";
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (Exception ignored) {
                }
            }
        }
        return json.toString();
    }

    public static void main(String[] args) {
        BasePriceByBaiduMap basePriceByBaiduMap = new BasePriceByBaiduMap();
        int distance = basePriceByBaiduMap.getCitysDistance("上海", "北京");
        System.out.println("distance is =========" + distance);

        BigDecimal price = new BigDecimal(distance);//把距离包装为bigDecimal进行商业运算
        price = price.divide(new BigDecimal("1000.00"), 2, BigDecimal.ROUND_HALF_UP);//计算公里数：按除数保留小数2为，舍入模式为BigDecimal.ROUND_HALF_UP
        System.out.println("price1 is =========" +price);
        price = price.multiply(new BigDecimal(2));//按单价为2元进行计算
        System.out.println("price2 is =========" +price);
    }
}
