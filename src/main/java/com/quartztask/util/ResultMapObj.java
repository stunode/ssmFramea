package com.quartztask.util;

import com.alibaba.fastjson.JSONObject;

import java.util.HashMap;
import java.util.Map;

/**
 * 用于ajax返回状态
 */
public class ResultMapObj {
    private boolean flag = true;
    private String msg;
    private Object obj;

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }

    public ResultMapObj() {

    }

    public ResultMapObj(boolean flag, String msg, Object obj) {
        super();
        this.flag = flag;
        this.msg = msg;
        this.obj = obj;
    }

    public ResultMapObj(boolean flag, String msg) {
        super();
        this.flag = flag;
        this.msg = msg;
    }

    public String toJson() {
        Map map = new HashMap();
        map.put("flag", flag);
        map.put("msg", msg);
        String json = JSONObject.toJSONString(map);
        System.out.println(json);
        return json;
    }
}
