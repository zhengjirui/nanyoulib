package io.rong.imkit.constant;

/**
 * Created by 18513 on 2017/12/13.
 */

public class Constant {
    public static String miao = "8000";

    public static final boolean isDebug = true;

    // -1 网络错误
    // 0  链接成功
    // 1  正在链接中
    // 2  断开链接
    // 3  多端登录被动下线
    public static int CONNECTION_STATUS = 2;//默认为断开链接

    //主机地址
    public static final String HOST = "http://192.168.2.122/";//开发1
//    public static final String HOST = "http://192.168.2.123/";//测试2
//    public static final String HOST = "http://192.168.5.105:8080/";
//    public static final String HOST = "https://kefuapi.dianwoda.com/";//生产3


    //登录验证app_key和签名
    public static final String LOGIN_VERTIFY = HOST + "im/verify/sign";

    //用户初始化
    public static final String USER_INIT = HOST + "im/entrance/attr";

    //测试
    public static final String REQUEST_SERVICE = HOST + "im/getStaff";



    //访客如队列
    public static final String REQUEST_CONVERCATION = HOST + "im/visitor/enqueue";
    //留言
    public static final String REQUEST_LEAVEMSG = HOST + "im/visitor/msg";
    //移除队列
    public static final String REQUEST_MOVE = HOST + "im/visitor/loginout";

    //会话界面
    public static final String REQUEST_HANGUP = HOST + "im/visitor/off";
    public static final String REQUEST_EVALUATE = HOST + "im/visitor/evaluate";

}
