package io.rong.imkit.provider;

import io.rong.imkit.RongIM;
import io.rong.imkit.model.GroupUserInfo;

/**
 * Created by 18513 on 2018/1/12.
 */

public class RongGroupUserInfoProvider implements RongIM.GroupUserInfoProvider {

    private String mGroupId = "";
    private String mUserId = "";
    private String mNackName = "";

    public RongGroupUserInfoProvider(String mGroupId, String mUserId, String mNackName) {
        this.mGroupId = mGroupId;
        this.mUserId = mUserId;
        this.mNackName = mNackName;
    }

    @Override
    public GroupUserInfo getGroupUserInfo(String s, String s1) {
        GroupUserInfo groupUserInfo = new GroupUserInfo(mGroupId, mUserId, mNackName);
        RongIM.getInstance().refreshGroupUserInfoCache(groupUserInfo);
        return null;
    }

    public String getmGroupId() {
        return mGroupId;
    }

    public void setmGroupId(String mGroupId) {
        this.mGroupId = mGroupId;
    }

    public String getmUserId() {
        return mUserId;
    }

    public void setmUserId(String mUserId) {
        this.mUserId = mUserId;
    }

    public String getmNackName() {
        return mNackName;
    }

    public void setmNackName(String mNackName) {
        this.mNackName = mNackName;
    }
}
