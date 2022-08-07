package com.example.chat.util;//package com.example.chat.util;
//
//import lombok.Data;
//
//import java.io.Serializable;
//
///**
// * 响应实体类
// *
// * @author andilylzy
// * @data 2022/5/21 上午10:44
// */
//@Data
//public class ResMsg implements Serializable {
//
//    private Integer code;
//
//    private String msg;
//
//
//    /**
//     * 成功
//     */
//    public static final int SUCCESS = Constants.SUCCESS;
//
//    /**
//     * 失败
//     */
//    public static final int FAIL = Constants.FAIL;
//
//
//
//    public static ResMsg ok(String msg) {
//        return resMsg(SUCCESS,msg);
//    }
//
//    public static ResMsg fail(String msg){
//        return resMsg(FAIL,msg);
//    }
//
//    private static ResMsg resMsg(int code,String msg) {
//        ResMsg resMsg = new ResMsg();
//        resMsg.setCode(code);
//        resMsg.setMsg(msg);
//
//        return resMsg;
//    }
//}
