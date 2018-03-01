package io.rong.imkit.events;

/**
 * Created by 18513 on 2018/1/22.
 */

public class CustomerStateLisenter extends EventBusAbstract {

    private int type = 0;//-1为mCustomerState类型，1为mIsTransfer类型
    private boolean mCustomerState = false;//保持客服链接为true，断开为false（进入到聊天界面为链接状态）

    private boolean mIsTransfer = true;//客服转接中
    private String kf_id;
    private String session_id;


    public CustomerStateLisenter(int type ,boolean mCustomerState) {
        this.type = type;
        this.mCustomerState = mCustomerState;
    }

    public CustomerStateLisenter(int type, boolean mIsTransfer, String kf_id, String session_id) {
        this.type = type;
        this.mIsTransfer = mIsTransfer;
        this.kf_id = kf_id;
        this.session_id = session_id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public boolean ismCustomerState() {
        return mCustomerState;
    }

    public void setmCustomerState(boolean mCustomerState) {
        this.mCustomerState = mCustomerState;
    }

    public boolean ismIsTransfer() {
        return mIsTransfer;
    }

    public void setmIsTransfer(boolean mIsTransfer) {
        this.mIsTransfer = mIsTransfer;
    }

    public String getKf_id() {
        return kf_id;
    }

    public void setKf_id(String kf_id) {
        this.kf_id = kf_id;
    }

    public String getSession_id() {
        return session_id;
    }

    public void setSession_id(String session_id) {
        this.session_id = session_id;
    }
}
