package io.rong.imkit.home.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import io.rong.imkit.home.basebean.AbMenuBean;

/**
 * Created by 18513 on 2017/12/16.
 */

public class MsgTypeAttrs implements Serializable{


    /**
     * attr : [{"start_menu2":{"group_id":"79","is_del":"1","rule_id":"1","status":"1","msg":"欢迎您进去南邮app"},"start_menu1":{"menu_4":{"group_id":"79","is_del":"1","rule_id":"1","icon":"","status":"1","msg":"欢迎您充值","name":"充值"},"menu_5":{"group_id":"79","is_del":"1","rule_id":"1","icon":"","status":"1","msg":"欢迎您退款","name":"退款"},"menu_6":{"group_id":"79","is_del":"1","rule_id":"1","icon":"","status":"1","msg":"欢迎您反馈","name":"反馈"},"menu_7":{"group_id":"79","is_del":"1","rule_id":"1","icon":"","status":"1","msg":"欢迎您业务","name":"业务"},"menu_1":{"group_id":"79","is_del":"1","rule_id":"1","icon":"","status":"1","msg":"欢迎您咨询","name":"咨询"},"menu_2":{"group_id":"79","is_del":"1","rule_id":"1","icon":"","status":"1","msg":"欢迎您举报","name":"举报"},"menu_3":{"group_id":"79","is_del":"1","rule_id":"1","icon":"","status":"1","msg":"欢迎您投诉","name":"投诉"},"menu_8":{"group_id":"79","is_del":"1","rule_id":"1","icon":"","status":"1","msg":"欢迎您订单","name":"订单"},"menu_9":{"group_id":"79","is_del":"1","rule_id":"1","icon":"","status":"1","msg":"请问您想咨询什么内容呢","name":"其他"}},"start_menu_status":1},{"vain_filtration_status":1},{"queue_rule_msg":"坐席全忙，在您前面有%个等待的用户，您可以点击下面的按钮留言或者继续等待","queue_rule_status":1},{"msg_rule_status":1,"msg_type1_msg":"您好，客服貌似全被火星人抓走了，您可以稍后来访或留言，我们会在第一时间与您联系.","msg_type2_status":"103","msg_type2_count":"24","msg_type2_msg":"您好，当前排队的人山人海，建议您点击下面按钮留言，我们将尽快与您联系"},{"session_stop_status":1,"session_stop_msg":"感谢您的来访，祝您工作生活愉快，再见"},{"feed_back_thank":"感谢您的反馈","feed_back_value5":"非常不满意","feed_back_msg":"刚刚为您服务的是%坐席代表，请您为ta的服务做一个评价","feed_back_value4":"不满意","feed_back_value3":"一般","feed_back_value2":"满意","feed_back_type":1,"feed_back_value1":"超级满意","feed_back_status":1},{"dumb_rule_time":24,"dumb_rule_status":1,"dump_rule_msg":"由于。。。。"},{"res_timeout_status":1,"res_timeout_time":45},{"course_dumb_status":1,"course_dump_value2_overtime":10,"course_dumb_value2_time":30,"course_dumb_vakue2_msg":"稍后会结束您的会话。","course_dumb_vakue1_msg":"请问有什么能帮助您的吗？","course_dumb_value1_time":50},{"network_anomaly_time":5,"network_anomaly_type":1,"network_anomaly_msg":"我们的客服被外星人带走了","network_anomaly_status":1},{"cvst_category_status":1},{"repetion_session_time":24,"repetition_session_status":1},{"once_splve_time":24,"once_solve_status":1},{"visitor_switch_status":"1","greeting_content_msg":"您好，欢迎您访问南邮"}]
     * visitor_token : eyJpdiI6IlVVWlNxYTFDTEUxMW9SWFdkTlpzYkE9PSIsInZhbHVlIjoiYUF5MEUzbXdvQng3ZDBlUSs5TWlkVE1OY3NHVUVydEd2T2krWFJGODgyQ3NkTk9HVEkrazdXWUVva3hKK3phTDFrUnY4aTBjek0xWFwvbjdmTXZseUFBPT0iLCJtYWMiOiI4MzM3YzRiNjhkYTMyZTA3NjlmMDZiZmUxYWViNDJjZGM1NGQ1YzYwMmNiNGUzMTZmYTgwYzYyMzY5MjBiMjkxIn0=
     */

    private String visitor_token = "";
    private String rong_code = "";
    private String customerToken = "";
    private int app_sign = -1;
    private List<AttrBean> attr = new ArrayList<>();

    public String getVisitor_token() {
        return visitor_token;
    }

    public void setVisitor_token(String visitor_token) {
        this.visitor_token = visitor_token;
    }

    public String getRong_code() {
        return rong_code;
    }

    public void setRong_code(String rong_code) {
        this.rong_code = rong_code;
    }

    public String getCustomerToken() {
        return customerToken;
    }

    public void setCustomerToken(String customerToken) {
        this.customerToken = customerToken;
    }

    public int getApp_sign() {
        return app_sign;
    }

    public void setApp_sign(int app_sign) {
        this.app_sign = app_sign;
    }

    public List<AttrBean> getAttr() {
        return attr;
    }

    public void setAttr(List<AttrBean> attr) {
        this.attr = attr;
    }

    public static class AttrBean implements Serializable{
        /**
         * start_menu2 : {"group_id":"79","is_del":"1","rule_id":"1","status":"1","msg":"欢迎您进去南邮app"}
         * start_menu1 : {"menu_4":{"group_id":"79","is_del":"1","rule_id":"1","icon":"","status":"1","msg":"欢迎您充值","name":"充值"},"menu_5":{"group_id":"79","is_del":"1","rule_id":"1","icon":"","status":"1","msg":"欢迎您退款","name":"退款"},"menu_6":{"group_id":"79","is_del":"1","rule_id":"1","icon":"","status":"1","msg":"欢迎您反馈","name":"反馈"},"menu_7":{"group_id":"79","is_del":"1","rule_id":"1","icon":"","status":"1","msg":"欢迎您业务","name":"业务"},"menu_1":{"group_id":"79","is_del":"1","rule_id":"1","icon":"","status":"1","msg":"欢迎您咨询","name":"咨询"},"menu_2":{"group_id":"79","is_del":"1","rule_id":"1","icon":"","status":"1","msg":"欢迎您举报","name":"举报"},"menu_3":{"group_id":"79","is_del":"1","rule_id":"1","icon":"","status":"1","msg":"欢迎您投诉","name":"投诉"},"menu_8":{"group_id":"79","is_del":"1","rule_id":"1","icon":"","status":"1","msg":"欢迎您订单","name":"订单"},"menu_9":{"group_id":"79","is_del":"1","rule_id":"1","icon":"","status":"1","msg":"请问您想咨询什么内容呢","name":"其他"}}
         * start_menu_status : 1
         * vain_filtration_status : 1
         * queue_rule_msg : 坐席全忙，在您前面有%个等待的用户，您可以点击下面的按钮留言或者继续等待
         * queue_rule_status : 1
         * msg_rule_status : 1
         * msg_type1_msg : 您好，客服貌似全被火星人抓走了，您可以稍后来访或留言，我们会在第一时间与您联系.
         * msg_type2_status : 103
         * msg_type2_count : 24
         * msg_type2_msg : 您好，当前排队的人山人海，建议您点击下面按钮留言，我们将尽快与您联系
         * session_stop_status : 1
         * session_stop_msg : 感谢您的来访，祝您工作生活愉快，再见
         * feed_back_thank : 感谢您的反馈
         * feed_back_value5 : 非常不满意
         * feed_back_msg : 刚刚为您服务的是%坐席代表，请您为ta的服务做一个评价
         * feed_back_value4 : 不满意
         * feed_back_value3 : 一般
         * feed_back_value2 : 满意
         * feed_back_type : 1
         * feed_back_value1 : 超级满意
         * feed_back_status : 1
         * dumb_rule_time : 24
         * dumb_rule_status : 1
         * dump_rule_msg : 由于。。。。
         * res_timeout_status : 1
         * res_timeout_time : 45
         * course_dumb_status : 1
         * course_dump_value2_overtime : 10
         * course_dumb_value2_time : 30
         * course_dumb_vakue2_msg : 稍后会结束您的会话。
         * course_dumb_vakue1_msg : 请问有什么能帮助您的吗？
         * course_dumb_value1_time : 50
         * network_anomaly_time : 5
         * network_anomaly_type : 1
         * network_anomaly_msg : 我们的客服被外星人带走了
         * network_anomaly_status : 1
         * cvst_category_status : 1
         * repetion_session_time : 24
         * repetition_session_status : 1
         * once_splve_time : 24
         * once_solve_status : 1
         * visitor_switch_status : 1
         * greeting_content_msg : 您好，欢迎您访问南邮
         */

        private StartMenu2Bean start_menu2 = new StartMenu2Bean();
        private StartMenu1Bean start_menu1 = new StartMenu1Bean();
        private int start_menu_status = -1;
        private int vain_filtration_status = -1;
        private String queue_rule_msg = "";
        private int queue_rule_status = -1;
        private int msg_rule_status = -1;
        private String msg_type1_msg = "";
        private String msg_type2_status = "";
        private String msg_type2_count = "";
        private String msg_type2_msg = "";
        private int session_stop_status = -1;
        private String session_stop_msg = "";
        private String feed_back_thank = "";
        private String feed_back_value5 = "";
        private String feed_back_msg = "";
        private String feed_back_value4 = "";
        private String feed_back_value3 = "";
        private String feed_back_value2 = "";
        private int feed_back_type = -1;
        private String feed_back_value1 = "";
        private int feed_back_status = -1;
        private int dumb_rule_time = -1;
        private int dumb_rule_status = -1;
        private String dump_rule_msg = "";
        private int res_timeout_status = 1;
        private int res_timeout_time = -1;
        private int course_dumb_status = -1;
        private int course_dump_value2_overtime = -1;
        private int course_dumb_value2_time = -1;
        private String course_dumb_vakue2_msg  = "";
        private String course_dumb_vakue1_msg  = "";
        private int course_dumb_value1_time = -1;
        private int network_anomaly_time = -1;
        private int network_anomaly_type = -1;
        private String network_anomaly_msg = "";
        private int network_anomaly_status = -1;
        private int cvst_category_status = -1;
        private int repetion_session_time = -1;
        private int repetition_session_status = -1;
        private int once_splve_time = -1;
        private int once_solve_status = -1;
        private String visitor_switch_status = "";
        private String greeting_content_msg = "";
        private String kefu_name = "";
        private String kefu_icon = "";
        private String vis_icon = "";
        private String title = "";


        public StartMenu2Bean getStart_menu2() {
            return start_menu2;
        }

        public void setStart_menu2(StartMenu2Bean start_menu2) {
            this.start_menu2 = start_menu2;
        }

        public StartMenu1Bean getStart_menu1() {
            return start_menu1;
        }

        public void setStart_menu1(StartMenu1Bean start_menu1) {
            this.start_menu1 = start_menu1;
        }

        public int getStart_menu_status() {
            return start_menu_status;
        }

        public void setStart_menu_status(int start_menu_status) {
            this.start_menu_status = start_menu_status;
        }

        public int getVain_filtration_status() {
            return vain_filtration_status;
        }

        public void setVain_filtration_status(int vain_filtration_status) {
            this.vain_filtration_status = vain_filtration_status;
        }

        public String getQueue_rule_msg() {
            return queue_rule_msg;
        }

        public void setQueue_rule_msg(String queue_rule_msg) {
            this.queue_rule_msg = queue_rule_msg;
        }

        public int getQueue_rule_status() {
            return queue_rule_status;
        }

        public void setQueue_rule_status(int queue_rule_status) {
            this.queue_rule_status = queue_rule_status;
        }

        public int getMsg_rule_status() {
            return msg_rule_status;
        }

        public void setMsg_rule_status(int msg_rule_status) {
            this.msg_rule_status = msg_rule_status;
        }

        public String getMsg_type1_msg() {
            return msg_type1_msg;
        }

        public void setMsg_type1_msg(String msg_type1_msg) {
            this.msg_type1_msg = msg_type1_msg;
        }

        public String getmsg_type2_status() {
            return msg_type2_status;
        }

        public void setmsg_type2_status(String msg_type2_status) {
            this.msg_type2_status = msg_type2_status;
        }

        public String getMsg_type2_count() {
            return msg_type2_count;
        }

        public void setMsg_type2_count(String msg_type2_count) {
            this.msg_type2_count = msg_type2_count;
        }

        public String getMsg_type2_msg() {
            return msg_type2_msg;
        }

        public void setMsg_type2_msg(String msg_type2_msg) {
            this.msg_type2_msg = msg_type2_msg;
        }

        public int getSession_stop_status() {
            return session_stop_status;
        }

        public void setSession_stop_status(int session_stop_status) {
            this.session_stop_status = session_stop_status;
        }

        public String getSession_stop_msg() {
            return session_stop_msg;
        }

        public void setSession_stop_msg(String session_stop_msg) {
            this.session_stop_msg = session_stop_msg;
        }

        public String getFeed_back_thank() {
            return feed_back_thank;
        }

        public void setFeed_back_thank(String feed_back_thank) {
            this.feed_back_thank = feed_back_thank;
        }

        public String getFeed_back_value5() {
            return feed_back_value5;
        }

        public void setFeed_back_value5(String feed_back_value5) {
            this.feed_back_value5 = feed_back_value5;
        }

        public String getFeed_back_msg() {
            return feed_back_msg;
        }

        public void setFeed_back_msg(String feed_back_msg) {
            this.feed_back_msg = feed_back_msg;
        }

        public String getFeed_back_value4() {
            return feed_back_value4;
        }

        public void setFeed_back_value4(String feed_back_value4) {
            this.feed_back_value4 = feed_back_value4;
        }

        public String getFeed_back_value3() {
            return feed_back_value3;
        }

        public void setFeed_back_value3(String feed_back_value3) {
            this.feed_back_value3 = feed_back_value3;
        }

        public String getFeed_back_value2() {
            return feed_back_value2;
        }

        public void setFeed_back_value2(String feed_back_value2) {
            this.feed_back_value2 = feed_back_value2;
        }

        public int getFeed_back_type() {
            return feed_back_type;
        }

        public void setFeed_back_type(int feed_back_type) {
            this.feed_back_type = feed_back_type;
        }

        public String getFeed_back_value1() {
            return feed_back_value1;
        }

        public void setFeed_back_value1(String feed_back_value1) {
            this.feed_back_value1 = feed_back_value1;
        }

        public int getFeed_back_status() {
            return feed_back_status;
        }

        public void setFeed_back_status(int feed_back_status) {
            this.feed_back_status = feed_back_status;
        }

        public int getDumb_rule_time() {
            return dumb_rule_time;
        }

        public void setDumb_rule_time(int dumb_rule_time) {
            this.dumb_rule_time = dumb_rule_time;
        }

        public int getDumb_rule_status() {
            return dumb_rule_status;
        }

        public void setDumb_rule_status(int dumb_rule_status) {
            this.dumb_rule_status = dumb_rule_status;
        }

        public String getDump_rule_msg() {
            return dump_rule_msg;
        }

        public void setDump_rule_msg(String dump_rule_msg) {
            this.dump_rule_msg = dump_rule_msg;
        }

        public int getRes_timeout_status() {
            return res_timeout_status;
        }

        public void setRes_timeout_status(int res_timeout_status) {
            this.res_timeout_status = res_timeout_status;
        }

        public int getRes_timeout_time() {
            return res_timeout_time;
        }

        public void setRes_timeout_time(int res_timeout_time) {
            this.res_timeout_time = res_timeout_time;
        }

        public int getCourse_dumb_status() {
            return course_dumb_status;
        }

        public void setCourse_dumb_status(int course_dumb_status) {
            this.course_dumb_status = course_dumb_status;
        }

        public int getCourse_dump_value2_overtime() {
            return course_dump_value2_overtime;
        }

        public void setCourse_dump_value2_overtime(int course_dump_value2_overtime) {
            this.course_dump_value2_overtime = course_dump_value2_overtime;
        }

        public int getCourse_dumb_value2_time() {
            return course_dumb_value2_time;
        }

        public void setCourse_dumb_value2_time(int course_dumb_value2_time) {
            this.course_dumb_value2_time = course_dumb_value2_time;
        }

        public String getCourse_dumb_vakue2_msg() {
            return course_dumb_vakue2_msg;
        }

        public void setCourse_dumb_vakue2_msg(String course_dumb_vakue2_msg) {
            this.course_dumb_vakue2_msg = course_dumb_vakue2_msg;
        }

        public String getCourse_dumb_vakue1_msg() {
            return course_dumb_vakue1_msg;
        }

        public void setCourse_dumb_vakue1_msg(String course_dumb_vakue1_msg) {
            this.course_dumb_vakue1_msg = course_dumb_vakue1_msg;
        }

        public int getCourse_dumb_value1_time() {
            return course_dumb_value1_time;
        }

        public void setCourse_dumb_value1_time(int course_dumb_value1_time) {
            this.course_dumb_value1_time = course_dumb_value1_time;
        }

        public int getNetwork_anomaly_time() {
            return network_anomaly_time;
        }

        public void setNetwork_anomaly_time(int network_anomaly_time) {
            this.network_anomaly_time = network_anomaly_time;
        }

        public int getNetwork_anomaly_type() {
            return network_anomaly_type;
        }

        public void setNetwork_anomaly_type(int network_anomaly_type) {
            this.network_anomaly_type = network_anomaly_type;
        }

        public String getNetwork_anomaly_msg() {
            return network_anomaly_msg;
        }

        public void setNetwork_anomaly_msg(String network_anomaly_msg) {
            this.network_anomaly_msg = network_anomaly_msg;
        }

        public int getNetwork_anomaly_status() {
            return network_anomaly_status;
        }

        public void setNetwork_anomaly_status(int network_anomaly_status) {
            this.network_anomaly_status = network_anomaly_status;
        }

        public int getCvst_category_status() {
            return cvst_category_status;
        }

        public void setCvst_category_status(int cvst_category_status) {
            this.cvst_category_status = cvst_category_status;
        }

        public int getRepetion_session_time() {
            return repetion_session_time;
        }

        public void setRepetion_session_time(int repetion_session_time) {
            this.repetion_session_time = repetion_session_time;
        }

        public int getRepetition_session_status() {
            return repetition_session_status;
        }

        public void setRepetition_session_status(int repetition_session_status) {
            this.repetition_session_status = repetition_session_status;
        }

        public int getOnce_splve_time() {
            return once_splve_time;
        }

        public void setOnce_splve_time(int once_splve_time) {
            this.once_splve_time = once_splve_time;
        }

        public int getOnce_solve_status() {
            return once_solve_status;
        }

        public void setOnce_solve_status(int once_solve_status) {
            this.once_solve_status = once_solve_status;
        }

        public String getVisitor_switch_status() {
            return visitor_switch_status;
        }

        public void setVisitor_switch_status(String visitor_switch_status) {
            this.visitor_switch_status = visitor_switch_status;
        }

        public String getGreeting_content_msg() {
            return greeting_content_msg;
        }

        public void setGreeting_content_msg(String greeting_content_msg) {
            this.greeting_content_msg = greeting_content_msg;
        }

        public String getKefu_name() {
            return kefu_name;
        }

        public void setKefu_name(String kefu_name) {
            this.kefu_name = kefu_name;
        }

        public String getKefu_icon() {
            return kefu_icon;
        }

        public void setKefu_icon(String kefu_icon) {
            this.kefu_icon = kefu_icon;
        }

        public String getVis_icon() {
            return vis_icon;
        }

        public void setVis_icon(String vis_icon) {
            this.vis_icon = vis_icon;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public static class StartMenu2Bean implements Serializable {
            /**
             * group_id : 79
             * is_del : 1
             * rule_id : 1
             * status : 1
             * msg : 欢迎您进去南邮app
             */

            private String group_id;
            private String is_del;
            private String rule_id;
            private String status;
            private String msg;
            private String name;

            public String getGroup_id() {
                return group_id;
            }

            public void setGroup_id(String group_id) {
                this.group_id = group_id;
            }

            public String getIs_del() {
                return is_del;
            }

            public void setIs_del(String is_del) {
                this.is_del = is_del;
            }

            public String getRule_id() {
                return rule_id;
            }

            public void setRule_id(String rule_id) {
                this.rule_id = rule_id;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getMsg() {
                return msg;
            }

            public void setMsg(String msg) {
                this.msg = msg;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }

        public static class StartMenu1Bean implements Serializable {
            /**
             * menu_4 : {"group_id":"79","is_del":"1","rule_id":"1","icon":"","status":"1","msg":"欢迎您充值","name":"充值"}
             * menu_5 : {"group_id":"79","is_del":"1","rule_id":"1","icon":"","status":"1","msg":"欢迎您退款","name":"退款"}
             * menu_6 : {"group_id":"79","is_del":"1","rule_id":"1","icon":"","status":"1","msg":"欢迎您反馈","name":"反馈"}
             * menu_7 : {"group_id":"79","is_del":"1","rule_id":"1","icon":"","status":"1","msg":"欢迎您业务","name":"业务"}
             * menu_1 : {"group_id":"79","is_del":"1","rule_id":"1","icon":"","status":"1","msg":"欢迎您咨询","name":"咨询"}
             * menu_2 : {"group_id":"79","is_del":"1","rule_id":"1","icon":"","status":"1","msg":"欢迎您举报","name":"举报"}
             * menu_3 : {"group_id":"79","is_del":"1","rule_id":"1","icon":"","status":"1","msg":"欢迎您投诉","name":"投诉"}
             * menu_8 : {"group_id":"79","is_del":"1","rule_id":"1","icon":"","status":"1","msg":"欢迎您订单","name":"订单"}
             * menu_9 : {"group_id":"79","is_del":"1","rule_id":"1","icon":"","status":"1","msg":"请问您想咨询什么内容呢","name":"其他"}
             */

            private Menu4Bean menu_4;
            private Menu5Bean menu_5;
            private Menu6Bean menu_6;
            private Menu7Bean menu_7;
            private Menu1Bean menu_1;
            private Menu2Bean menu_2;
            private Menu3Bean menu_3;
            private Menu8Bean menu_8;
            private Menu9Bean menu_9;
            private Menu10Bean menu_10;
            private Menu11Bean menu_11;
            private Menu12Bean menu_12;
            private Menu13Bean menu_13;
            private Menu14Bean menu_14;
            private Menu15Bean menu_15;
            private Menu16Bean menu_16;
            private Menu17Bean menu_17;
            private Menu18Bean menu_18;
            private Menu19Bean menu_19;
            private Menu20Bean menu_20;

            public Menu4Bean getMenu_4() {
                return menu_4;
            }

            public void setMenu_4(Menu4Bean menu_4) {
                this.menu_4 = menu_4;
            }

            public Menu5Bean getMenu_5() {
                return menu_5;
            }

            public void setMenu_5(Menu5Bean menu_5) {
                this.menu_5 = menu_5;
            }

            public Menu6Bean getMenu_6() {
                return menu_6;
            }

            public void setMenu_6(Menu6Bean menu_6) {
                this.menu_6 = menu_6;
            }

            public Menu7Bean getMenu_7() {
                return menu_7;
            }

            public void setMenu_7(Menu7Bean menu_7) {
                this.menu_7 = menu_7;
            }

            public Menu1Bean getMenu_1() {
                return menu_1;
            }

            public void setMenu_1(Menu1Bean menu_1) {
                this.menu_1 = menu_1;
            }

            public Menu2Bean getMenu_2() {
                return menu_2;
            }

            public void setMenu_2(Menu2Bean menu_2) {
                this.menu_2 = menu_2;
            }

            public Menu3Bean getMenu_3() {
                return menu_3;
            }

            public void setMenu_3(Menu3Bean menu_3) {
                this.menu_3 = menu_3;
            }

            public Menu8Bean getMenu_8() {
                return menu_8;
            }

            public void setMenu_8(Menu8Bean menu_8) {
                this.menu_8 = menu_8;
            }

            public Menu9Bean getMenu_9() {
                return menu_9;
            }

            public void setMenu_9(Menu9Bean menu_9) {
                this.menu_9 = menu_9;
            }

            public Menu10Bean getMenu_10() {
                return menu_10;
            }

            public void setMenu_10(Menu10Bean menu_10) {
                this.menu_10 = menu_10;
            }

            public Menu11Bean getMenu_11() {
                return menu_11;
            }

            public void setMenu_11(Menu11Bean menu_11) {
                this.menu_11 = menu_11;
            }

            public Menu12Bean getMenu_12() {
                return menu_12;
            }

            public void setMenu_12(Menu12Bean menu_12) {
                this.menu_12 = menu_12;
            }

            public Menu13Bean getMenu_13() {
                return menu_13;
            }

            public void setMenu_13(Menu13Bean menu_13) {
                this.menu_13 = menu_13;
            }

            public Menu14Bean getMenu_14() {
                return menu_14;
            }

            public void setMenu_14(Menu14Bean menu_14) {
                this.menu_14 = menu_14;
            }

            public Menu15Bean getMenu_15() {
                return menu_15;
            }

            public void setMenu_15(Menu15Bean menu_15) {
                this.menu_15 = menu_15;
            }

            public Menu16Bean getMenu_16() {
                return menu_16;
            }

            public void setMenu_16(Menu16Bean menu_16) {
                this.menu_16 = menu_16;
            }

            public Menu17Bean getMenu_17() {
                return menu_17;
            }

            public void setMenu_17(Menu17Bean menu_17) {
                this.menu_17 = menu_17;
            }

            public Menu18Bean getMenu_18() {
                return menu_18;
            }

            public void setMenu_18(Menu18Bean menu_18) {
                this.menu_18 = menu_18;
            }

            public Menu19Bean getMenu_19() {
                return menu_19;
            }

            public void setMenu_19(Menu19Bean menu_19) {
                this.menu_19 = menu_19;
            }

            public Menu20Bean getMenu_20() {
                return menu_20;
            }

            public void setMenu_20(Menu20Bean menu_20) {
                this.menu_20 = menu_20;
            }

            public static class Menu4Bean extends AbMenuBean  implements Serializable {
                /**
                 * group_id : 79
                 * is_del : 1
                 * rule_id : 1
                 * icon :
                 * status : 1
                 * msg : 欢迎您充值
                 * name : 充值
                 */
                @Override
                public String getGroup_id() {
                    return super.getGroup_id();
                }

                @Override
                public void setGroup_id(String group_id) {
                    super.setGroup_id(group_id);
                }

                @Override
                public String getIs_del() {
                    return super.getIs_del();
                }

                @Override
                public void setIs_del(String is_del) {
                    super.setIs_del(is_del);
                }

                @Override
                public String getRule_id() {
                    return super.getRule_id();
                }

                @Override
                public void setRule_id(String rule_id) {
                    super.setRule_id(rule_id);
                }

                @Override
                public String getIcon() {
                    return super.getIcon();
                }

                @Override
                public void setIcon(String icon) {
                    super.setIcon(icon);
                }

                @Override
                public String getStatus() {
                    return super.getStatus();
                }

                @Override
                public void setStatus(String status) {
                    super.setStatus(status);
                }

                @Override
                public String getMsg() {
                    return super.getMsg();
                }

                @Override
                public void setMsg(String msg) {
                    super.setMsg(msg);
                }

                @Override
                public String getName() {
                    return super.getName();
                }

                @Override
                public void setName(String name) {
                    super.setName(name);
                }
            }

            public static class Menu5Bean extends AbMenuBean  implements Serializable {
                /**
                 * group_id : 79
                 * is_del : 1
                 * rule_id : 1
                 * icon :
                 * status : 1
                 * msg : 欢迎您退款
                 * name : 退款
                 */
                @Override
                public String getGroup_id() {
                    return super.getGroup_id();
                }

                @Override
                public void setGroup_id(String group_id) {
                    super.setGroup_id(group_id);
                }

                @Override
                public String getIs_del() {
                    return super.getIs_del();
                }

                @Override
                public void setIs_del(String is_del) {
                    super.setIs_del(is_del);
                }

                @Override
                public String getRule_id() {
                    return super.getRule_id();
                }

                @Override
                public void setRule_id(String rule_id) {
                    super.setRule_id(rule_id);
                }

                @Override
                public String getIcon() {
                    return super.getIcon();
                }

                @Override
                public void setIcon(String icon) {
                    super.setIcon(icon);
                }

                @Override
                public String getStatus() {
                    return super.getStatus();
                }

                @Override
                public void setStatus(String status) {
                    super.setStatus(status);
                }

                @Override
                public String getMsg() {
                    return super.getMsg();
                }

                @Override
                public void setMsg(String msg) {
                    super.setMsg(msg);
                }

                @Override
                public String getName() {
                    return super.getName();
                }

                @Override
                public void setName(String name) {
                    super.setName(name);
                }
            }

            public static class Menu6Bean extends AbMenuBean  implements Serializable {
                /**
                 * group_id : 79
                 * is_del : 1
                 * rule_id : 1
                 * icon :
                 * status : 1
                 * msg : 欢迎您反馈
                 * name : 反馈
                 */
                @Override
                public String getGroup_id() {
                    return super.getGroup_id();
                }

                @Override
                public void setGroup_id(String group_id) {
                    super.setGroup_id(group_id);
                }

                @Override
                public String getIs_del() {
                    return super.getIs_del();
                }

                @Override
                public void setIs_del(String is_del) {
                    super.setIs_del(is_del);
                }

                @Override
                public String getRule_id() {
                    return super.getRule_id();
                }

                @Override
                public void setRule_id(String rule_id) {
                    super.setRule_id(rule_id);
                }

                @Override
                public String getIcon() {
                    return super.getIcon();
                }

                @Override
                public void setIcon(String icon) {
                    super.setIcon(icon);
                }

                @Override
                public String getStatus() {
                    return super.getStatus();
                }

                @Override
                public void setStatus(String status) {
                    super.setStatus(status);
                }

                @Override
                public String getMsg() {
                    return super.getMsg();
                }

                @Override
                public void setMsg(String msg) {
                    super.setMsg(msg);
                }

                @Override
                public String getName() {
                    return super.getName();
                }

                @Override
                public void setName(String name) {
                    super.setName(name);
                }
            }

            public static class Menu7Bean extends AbMenuBean  implements Serializable {
                /**
                 * group_id : 79
                 * is_del : 1
                 * rule_id : 1
                 * icon :
                 * status : 1
                 * msg : 欢迎您业务
                 * name : 业务
                 */
                @Override
                public String getGroup_id() {
                    return super.getGroup_id();
                }

                @Override
                public void setGroup_id(String group_id) {
                    super.setGroup_id(group_id);
                }

                @Override
                public String getIs_del() {
                    return super.getIs_del();
                }

                @Override
                public void setIs_del(String is_del) {
                    super.setIs_del(is_del);
                }

                @Override
                public String getRule_id() {
                    return super.getRule_id();
                }

                @Override
                public void setRule_id(String rule_id) {
                    super.setRule_id(rule_id);
                }

                @Override
                public String getIcon() {
                    return super.getIcon();
                }

                @Override
                public void setIcon(String icon) {
                    super.setIcon(icon);
                }

                @Override
                public String getStatus() {
                    return super.getStatus();
                }

                @Override
                public void setStatus(String status) {
                    super.setStatus(status);
                }

                @Override
                public String getMsg() {
                    return super.getMsg();
                }

                @Override
                public void setMsg(String msg) {
                    super.setMsg(msg);
                }

                @Override
                public String getName() {
                    return super.getName();
                }

                @Override
                public void setName(String name) {
                    super.setName(name);
                }
            }

            public static class Menu1Bean extends AbMenuBean implements Serializable {
                /**
                 * group_id : 79
                 * is_del : 1
                 * rule_id : 1
                 * icon :
                 * status : 1
                 * msg : 欢迎您咨询
                 * name : 咨询
                 */
                @Override
                public String getGroup_id() {
                    return super.getGroup_id();
                }

                @Override
                public void setGroup_id(String group_id) {
                    super.setGroup_id(group_id);
                }

                @Override
                public String getIs_del() {
                    return super.getIs_del();
                }

                @Override
                public void setIs_del(String is_del) {
                    super.setIs_del(is_del);
                }

                @Override
                public String getRule_id() {
                    return super.getRule_id();
                }

                @Override
                public void setRule_id(String rule_id) {
                    super.setRule_id(rule_id);
                }

                @Override
                public String getIcon() {
                    return super.getIcon();
                }

                @Override
                public void setIcon(String icon) {
                    super.setIcon(icon);
                }

                @Override
                public String getStatus() {
                    return super.getStatus();
                }

                @Override
                public void setStatus(String status) {
                    super.setStatus(status);
                }

                @Override
                public String getMsg() {
                    return super.getMsg();
                }

                @Override
                public void setMsg(String msg) {
                    super.setMsg(msg);
                }

                @Override
                public String getName() {
                    return super.getName();
                }

                @Override
                public void setName(String name) {
                    super.setName(name);
                }
            }

            public static class Menu2Bean extends AbMenuBean  implements Serializable {
                /**
                 * group_id : 79
                 * is_del : 1
                 * rule_id : 1
                 * icon :
                 * status : 1
                 * msg : 欢迎您举报
                 * name : 举报
                 */
                @Override
                public String getGroup_id() {
                    return super.getGroup_id();
                }

                @Override
                public void setGroup_id(String group_id) {
                    super.setGroup_id(group_id);
                }

                @Override
                public String getIs_del() {
                    return super.getIs_del();
                }

                @Override
                public void setIs_del(String is_del) {
                    super.setIs_del(is_del);
                }

                @Override
                public String getRule_id() {
                    return super.getRule_id();
                }

                @Override
                public void setRule_id(String rule_id) {
                    super.setRule_id(rule_id);
                }

                @Override
                public String getIcon() {
                    return super.getIcon();
                }

                @Override
                public void setIcon(String icon) {
                    super.setIcon(icon);
                }

                @Override
                public String getStatus() {
                    return super.getStatus();
                }

                @Override
                public void setStatus(String status) {
                    super.setStatus(status);
                }

                @Override
                public String getMsg() {
                    return super.getMsg();
                }

                @Override
                public void setMsg(String msg) {
                    super.setMsg(msg);
                }

                @Override
                public String getName() {
                    return super.getName();
                }

                @Override
                public void setName(String name) {
                    super.setName(name);
                }
            }

            public static class Menu3Bean extends AbMenuBean  implements Serializable {
                /**
                 * group_id : 79
                 * is_del : 1
                 * rule_id : 1
                 * icon :
                 * status : 1
                 * msg : 欢迎您投诉
                 * name : 投诉
                 */

                @Override
                public String getGroup_id() {
                    return super.getGroup_id();
                }

                @Override
                public void setGroup_id(String group_id) {
                    super.setGroup_id(group_id);
                }

                @Override
                public String getIs_del() {
                    return super.getIs_del();
                }

                @Override
                public void setIs_del(String is_del) {
                    super.setIs_del(is_del);
                }

                @Override
                public String getRule_id() {
                    return super.getRule_id();
                }

                @Override
                public void setRule_id(String rule_id) {
                    super.setRule_id(rule_id);
                }

                @Override
                public String getIcon() {
                    return super.getIcon();
                }

                @Override
                public void setIcon(String icon) {
                    super.setIcon(icon);
                }

                @Override
                public String getStatus() {
                    return super.getStatus();
                }

                @Override
                public void setStatus(String status) {
                    super.setStatus(status);
                }

                @Override
                public String getMsg() {
                    return super.getMsg();
                }

                @Override
                public void setMsg(String msg) {
                    super.setMsg(msg);
                }

                @Override
                public String getName() {
                    return super.getName();
                }

                @Override
                public void setName(String name) {
                    super.setName(name);
                }
            }

            public static class Menu8Bean extends AbMenuBean  implements Serializable {
                /**
                 * group_id : 79
                 * is_del : 1
                 * rule_id : 1
                 * icon :
                 * status : 1
                 * msg : 欢迎您订单
                 * name : 订单
                 */
                @Override
                public String getGroup_id() {
                    return super.getGroup_id();
                }

                @Override
                public void setGroup_id(String group_id) {
                    super.setGroup_id(group_id);
                }

                @Override
                public String getIs_del() {
                    return super.getIs_del();
                }

                @Override
                public void setIs_del(String is_del) {
                    super.setIs_del(is_del);
                }

                @Override
                public String getRule_id() {
                    return super.getRule_id();
                }

                @Override
                public void setRule_id(String rule_id) {
                    super.setRule_id(rule_id);
                }

                @Override
                public String getIcon() {
                    return super.getIcon();
                }

                @Override
                public void setIcon(String icon) {
                    super.setIcon(icon);
                }

                @Override
                public String getStatus() {
                    return super.getStatus();
                }

                @Override
                public void setStatus(String status) {
                    super.setStatus(status);
                }

                @Override
                public String getMsg() {
                    return super.getMsg();
                }

                @Override
                public void setMsg(String msg) {
                    super.setMsg(msg);
                }

                @Override
                public String getName() {
                    return super.getName();
                }

                @Override
                public void setName(String name) {
                    super.setName(name);
                }
            }

            public static class Menu9Bean extends AbMenuBean  implements Serializable {
                /**
                 * group_id : 79
                 * is_del : 1
                 * rule_id : 1
                 * icon :
                 * status : 1
                 * msg : 请问您想咨询什么内容呢
                 * name : 其他
                 */

                @Override
                public String getGroup_id() {
                    return super.getGroup_id();
                }

                @Override
                public void setGroup_id(String group_id) {
                    super.setGroup_id(group_id);
                }

                @Override
                public String getIs_del() {
                    return super.getIs_del();
                }

                @Override
                public void setIs_del(String is_del) {
                    super.setIs_del(is_del);
                }

                @Override
                public String getRule_id() {
                    return super.getRule_id();
                }

                @Override
                public void setRule_id(String rule_id) {
                    super.setRule_id(rule_id);
                }

                @Override
                public String getIcon() {
                    return super.getIcon();
                }

                @Override
                public void setIcon(String icon) {
                    super.setIcon(icon);
                }

                @Override
                public String getStatus() {
                    return super.getStatus();
                }

                @Override
                public void setStatus(String status) {
                    super.setStatus(status);
                }

                @Override
                public String getMsg() {
                    return super.getMsg();
                }

                @Override
                public void setMsg(String msg) {
                    super.setMsg(msg);
                }

                @Override
                public String getName() {
                    return super.getName();
                }

                @Override
                public void setName(String name) {
                    super.setName(name);
                }
            }

            public static class Menu10Bean extends AbMenuBean  implements Serializable {
                /**
                 * group_id : 79
                 * is_del : 1
                 * rule_id : 1
                 * icon :
                 * status : 1
                 * msg : 请问您想咨询什么内容呢
                 * name : 其他
                 */

                @Override
                public String getGroup_id() {
                    return super.getGroup_id();
                }

                @Override
                public void setGroup_id(String group_id) {
                    super.setGroup_id(group_id);
                }

                @Override
                public String getIs_del() {
                    return super.getIs_del();
                }

                @Override
                public void setIs_del(String is_del) {
                    super.setIs_del(is_del);
                }

                @Override
                public String getRule_id() {
                    return super.getRule_id();
                }

                @Override
                public void setRule_id(String rule_id) {
                    super.setRule_id(rule_id);
                }

                @Override
                public String getIcon() {
                    return super.getIcon();
                }

                @Override
                public void setIcon(String icon) {
                    super.setIcon(icon);
                }

                @Override
                public String getStatus() {
                    return super.getStatus();
                }

                @Override
                public void setStatus(String status) {
                    super.setStatus(status);
                }

                @Override
                public String getMsg() {
                    return super.getMsg();
                }

                @Override
                public void setMsg(String msg) {
                    super.setMsg(msg);
                }

                @Override
                public String getName() {
                    return super.getName();
                }

                @Override
                public void setName(String name) {
                    super.setName(name);
                }
            }

            public static class Menu11Bean extends AbMenuBean  implements Serializable {
                /**
                 * group_id : 79
                 * is_del : 1
                 * rule_id : 1
                 * icon :
                 * status : 1
                 * msg : 请问您想咨询什么内容呢
                 * name : 其他
                 */

                @Override
                public String getGroup_id() {
                    return super.getGroup_id();
                }

                @Override
                public void setGroup_id(String group_id) {
                    super.setGroup_id(group_id);
                }

                @Override
                public String getIs_del() {
                    return super.getIs_del();
                }

                @Override
                public void setIs_del(String is_del) {
                    super.setIs_del(is_del);
                }

                @Override
                public String getRule_id() {
                    return super.getRule_id();
                }

                @Override
                public void setRule_id(String rule_id) {
                    super.setRule_id(rule_id);
                }

                @Override
                public String getIcon() {
                    return super.getIcon();
                }

                @Override
                public void setIcon(String icon) {
                    super.setIcon(icon);
                }

                @Override
                public String getStatus() {
                    return super.getStatus();
                }

                @Override
                public void setStatus(String status) {
                    super.setStatus(status);
                }

                @Override
                public String getMsg() {
                    return super.getMsg();
                }

                @Override
                public void setMsg(String msg) {
                    super.setMsg(msg);
                }

                @Override
                public String getName() {
                    return super.getName();
                }

                @Override
                public void setName(String name) {
                    super.setName(name);
                }
            }

            public static class Menu12Bean extends AbMenuBean  implements Serializable {
                /**
                 * group_id : 79
                 * is_del : 1
                 * rule_id : 1
                 * icon :
                 * status : 1
                 * msg : 请问您想咨询什么内容呢
                 * name : 其他
                 */

                @Override
                public String getGroup_id() {
                    return super.getGroup_id();
                }

                @Override
                public void setGroup_id(String group_id) {
                    super.setGroup_id(group_id);
                }

                @Override
                public String getIs_del() {
                    return super.getIs_del();
                }

                @Override
                public void setIs_del(String is_del) {
                    super.setIs_del(is_del);
                }

                @Override
                public String getRule_id() {
                    return super.getRule_id();
                }

                @Override
                public void setRule_id(String rule_id) {
                    super.setRule_id(rule_id);
                }

                @Override
                public String getIcon() {
                    return super.getIcon();
                }

                @Override
                public void setIcon(String icon) {
                    super.setIcon(icon);
                }

                @Override
                public String getStatus() {
                    return super.getStatus();
                }

                @Override
                public void setStatus(String status) {
                    super.setStatus(status);
                }

                @Override
                public String getMsg() {
                    return super.getMsg();
                }

                @Override
                public void setMsg(String msg) {
                    super.setMsg(msg);
                }

                @Override
                public String getName() {
                    return super.getName();
                }

                @Override
                public void setName(String name) {
                    super.setName(name);
                }
            }

            public static class Menu13Bean extends AbMenuBean  implements Serializable {
                /**
                 * group_id : 79
                 * is_del : 1
                 * rule_id : 1
                 * icon :
                 * status : 1
                 * msg : 请问您想咨询什么内容呢
                 * name : 其他
                 */

                @Override
                public String getGroup_id() {
                    return super.getGroup_id();
                }

                @Override
                public void setGroup_id(String group_id) {
                    super.setGroup_id(group_id);
                }

                @Override
                public String getIs_del() {
                    return super.getIs_del();
                }

                @Override
                public void setIs_del(String is_del) {
                    super.setIs_del(is_del);
                }

                @Override
                public String getRule_id() {
                    return super.getRule_id();
                }

                @Override
                public void setRule_id(String rule_id) {
                    super.setRule_id(rule_id);
                }

                @Override
                public String getIcon() {
                    return super.getIcon();
                }

                @Override
                public void setIcon(String icon) {
                    super.setIcon(icon);
                }

                @Override
                public String getStatus() {
                    return super.getStatus();
                }

                @Override
                public void setStatus(String status) {
                    super.setStatus(status);
                }

                @Override
                public String getMsg() {
                    return super.getMsg();
                }

                @Override
                public void setMsg(String msg) {
                    super.setMsg(msg);
                }

                @Override
                public String getName() {
                    return super.getName();
                }

                @Override
                public void setName(String name) {
                    super.setName(name);
                }
            }

            public static class Menu14Bean extends AbMenuBean  implements Serializable {
                /**
                 * group_id : 79
                 * is_del : 1
                 * rule_id : 1
                 * icon :
                 * status : 1
                 * msg : 请问您想咨询什么内容呢
                 * name : 其他
                 */

                @Override
                public String getGroup_id() {
                    return super.getGroup_id();
                }

                @Override
                public void setGroup_id(String group_id) {
                    super.setGroup_id(group_id);
                }

                @Override
                public String getIs_del() {
                    return super.getIs_del();
                }

                @Override
                public void setIs_del(String is_del) {
                    super.setIs_del(is_del);
                }

                @Override
                public String getRule_id() {
                    return super.getRule_id();
                }

                @Override
                public void setRule_id(String rule_id) {
                    super.setRule_id(rule_id);
                }

                @Override
                public String getIcon() {
                    return super.getIcon();
                }

                @Override
                public void setIcon(String icon) {
                    super.setIcon(icon);
                }

                @Override
                public String getStatus() {
                    return super.getStatus();
                }

                @Override
                public void setStatus(String status) {
                    super.setStatus(status);
                }

                @Override
                public String getMsg() {
                    return super.getMsg();
                }

                @Override
                public void setMsg(String msg) {
                    super.setMsg(msg);
                }

                @Override
                public String getName() {
                    return super.getName();
                }

                @Override
                public void setName(String name) {
                    super.setName(name);
                }
            }

            public static class Menu15Bean extends AbMenuBean  implements Serializable {
                /**
                 * group_id : 79
                 * is_del : 1
                 * rule_id : 1
                 * icon :
                 * status : 1
                 * msg : 请问您想咨询什么内容呢
                 * name : 其他
                 */

                @Override
                public String getGroup_id() {
                    return super.getGroup_id();
                }

                @Override
                public void setGroup_id(String group_id) {
                    super.setGroup_id(group_id);
                }

                @Override
                public String getIs_del() {
                    return super.getIs_del();
                }

                @Override
                public void setIs_del(String is_del) {
                    super.setIs_del(is_del);
                }

                @Override
                public String getRule_id() {
                    return super.getRule_id();
                }

                @Override
                public void setRule_id(String rule_id) {
                    super.setRule_id(rule_id);
                }

                @Override
                public String getIcon() {
                    return super.getIcon();
                }

                @Override
                public void setIcon(String icon) {
                    super.setIcon(icon);
                }

                @Override
                public String getStatus() {
                    return super.getStatus();
                }

                @Override
                public void setStatus(String status) {
                    super.setStatus(status);
                }

                @Override
                public String getMsg() {
                    return super.getMsg();
                }

                @Override
                public void setMsg(String msg) {
                    super.setMsg(msg);
                }

                @Override
                public String getName() {
                    return super.getName();
                }

                @Override
                public void setName(String name) {
                    super.setName(name);
                }
            }

            public static class Menu16Bean extends AbMenuBean  implements Serializable {
                /**
                 * group_id : 79
                 * is_del : 1
                 * rule_id : 1
                 * icon :
                 * status : 1
                 * msg : 请问您想咨询什么内容呢
                 * name : 其他
                 */

                @Override
                public String getGroup_id() {
                    return super.getGroup_id();
                }

                @Override
                public void setGroup_id(String group_id) {
                    super.setGroup_id(group_id);
                }

                @Override
                public String getIs_del() {
                    return super.getIs_del();
                }

                @Override
                public void setIs_del(String is_del) {
                    super.setIs_del(is_del);
                }

                @Override
                public String getRule_id() {
                    return super.getRule_id();
                }

                @Override
                public void setRule_id(String rule_id) {
                    super.setRule_id(rule_id);
                }

                @Override
                public String getIcon() {
                    return super.getIcon();
                }

                @Override
                public void setIcon(String icon) {
                    super.setIcon(icon);
                }

                @Override
                public String getStatus() {
                    return super.getStatus();
                }

                @Override
                public void setStatus(String status) {
                    super.setStatus(status);
                }

                @Override
                public String getMsg() {
                    return super.getMsg();
                }

                @Override
                public void setMsg(String msg) {
                    super.setMsg(msg);
                }

                @Override
                public String getName() {
                    return super.getName();
                }

                @Override
                public void setName(String name) {
                    super.setName(name);
                }
            }

            public static class Menu17Bean extends AbMenuBean  implements Serializable {
                /**
                 * group_id : 79
                 * is_del : 1
                 * rule_id : 1
                 * icon :
                 * status : 1
                 * msg : 请问您想咨询什么内容呢
                 * name : 其他
                 */

                @Override
                public String getGroup_id() {
                    return super.getGroup_id();
                }

                @Override
                public void setGroup_id(String group_id) {
                    super.setGroup_id(group_id);
                }

                @Override
                public String getIs_del() {
                    return super.getIs_del();
                }

                @Override
                public void setIs_del(String is_del) {
                    super.setIs_del(is_del);
                }

                @Override
                public String getRule_id() {
                    return super.getRule_id();
                }

                @Override
                public void setRule_id(String rule_id) {
                    super.setRule_id(rule_id);
                }

                @Override
                public String getIcon() {
                    return super.getIcon();
                }

                @Override
                public void setIcon(String icon) {
                    super.setIcon(icon);
                }

                @Override
                public String getStatus() {
                    return super.getStatus();
                }

                @Override
                public void setStatus(String status) {
                    super.setStatus(status);
                }

                @Override
                public String getMsg() {
                    return super.getMsg();
                }

                @Override
                public void setMsg(String msg) {
                    super.setMsg(msg);
                }

                @Override
                public String getName() {
                    return super.getName();
                }

                @Override
                public void setName(String name) {
                    super.setName(name);
                }
            }

            public static class Menu18Bean extends AbMenuBean  implements Serializable {
                /**
                 * group_id : 79
                 * is_del : 1
                 * rule_id : 1
                 * icon :
                 * status : 1
                 * msg : 请问您想咨询什么内容呢
                 * name : 其他
                 */

                @Override
                public String getGroup_id() {
                    return super.getGroup_id();
                }

                @Override
                public void setGroup_id(String group_id) {
                    super.setGroup_id(group_id);
                }

                @Override
                public String getIs_del() {
                    return super.getIs_del();
                }

                @Override
                public void setIs_del(String is_del) {
                    super.setIs_del(is_del);
                }

                @Override
                public String getRule_id() {
                    return super.getRule_id();
                }

                @Override
                public void setRule_id(String rule_id) {
                    super.setRule_id(rule_id);
                }

                @Override
                public String getIcon() {
                    return super.getIcon();
                }

                @Override
                public void setIcon(String icon) {
                    super.setIcon(icon);
                }

                @Override
                public String getStatus() {
                    return super.getStatus();
                }

                @Override
                public void setStatus(String status) {
                    super.setStatus(status);
                }

                @Override
                public String getMsg() {
                    return super.getMsg();
                }

                @Override
                public void setMsg(String msg) {
                    super.setMsg(msg);
                }

                @Override
                public String getName() {
                    return super.getName();
                }

                @Override
                public void setName(String name) {
                    super.setName(name);
                }
            }

            public static class Menu19Bean extends AbMenuBean  implements Serializable {
                /**
                 * group_id : 79
                 * is_del : 1
                 * rule_id : 1
                 * icon :
                 * status : 1
                 * msg : 请问您想咨询什么内容呢
                 * name : 其他
                 */

                @Override
                public String getGroup_id() {
                    return super.getGroup_id();
                }

                @Override
                public void setGroup_id(String group_id) {
                    super.setGroup_id(group_id);
                }

                @Override
                public String getIs_del() {
                    return super.getIs_del();
                }

                @Override
                public void setIs_del(String is_del) {
                    super.setIs_del(is_del);
                }

                @Override
                public String getRule_id() {
                    return super.getRule_id();
                }

                @Override
                public void setRule_id(String rule_id) {
                    super.setRule_id(rule_id);
                }

                @Override
                public String getIcon() {
                    return super.getIcon();
                }

                @Override
                public void setIcon(String icon) {
                    super.setIcon(icon);
                }

                @Override
                public String getStatus() {
                    return super.getStatus();
                }

                @Override
                public void setStatus(String status) {
                    super.setStatus(status);
                }

                @Override
                public String getMsg() {
                    return super.getMsg();
                }

                @Override
                public void setMsg(String msg) {
                    super.setMsg(msg);
                }

                @Override
                public String getName() {
                    return super.getName();
                }

                @Override
                public void setName(String name) {
                    super.setName(name);
                }
            }

            public static class Menu20Bean extends AbMenuBean  implements Serializable {
                /**
                 * group_id : 79
                 * is_del : 1
                 * rule_id : 1
                 * icon :
                 * status : 1
                 * msg : 请问您想咨询什么内容呢
                 * name : 其他
                 */

                @Override
                public String getGroup_id() {
                    return super.getGroup_id();
                }

                @Override
                public void setGroup_id(String group_id) {
                    super.setGroup_id(group_id);
                }

                @Override
                public String getIs_del() {
                    return super.getIs_del();
                }

                @Override
                public void setIs_del(String is_del) {
                    super.setIs_del(is_del);
                }

                @Override
                public String getRule_id() {
                    return super.getRule_id();
                }

                @Override
                public void setRule_id(String rule_id) {
                    super.setRule_id(rule_id);
                }

                @Override
                public String getIcon() {
                    return super.getIcon();
                }

                @Override
                public void setIcon(String icon) {
                    super.setIcon(icon);
                }

                @Override
                public String getStatus() {
                    return super.getStatus();
                }

                @Override
                public void setStatus(String status) {
                    super.setStatus(status);
                }

                @Override
                public String getMsg() {
                    return super.getMsg();
                }

                @Override
                public void setMsg(String msg) {
                    super.setMsg(msg);
                }

                @Override
                public String getName() {
                    return super.getName();
                }

                @Override
                public void setName(String name) {
                    super.setName(name);
                }
            }
        }
    }
}
