package io.rong.imkit.provider;

import android.net.Uri;

import io.rong.imkit.RongIM;
import io.rong.imlib.model.UserInfo;

/**
 * Created by 18513 on 2018/1/12.
 */

public class RongUserInfoProvider implements RongIM.UserInfoProvider {

    private String mUserId = "";
    private String mUserName = "";
    private String mPortraitUri = "";

    public RongUserInfoProvider(String mUserId, String mUserName, String mPortraitUri) {
        this.mUserId = mUserId;
        this.mUserName = mUserName;
        this.mPortraitUri = mPortraitUri;
    }

    @Override
    public UserInfo getUserInfo(String s) {
        UserInfo userInfo = new UserInfo(this.mUserId, this.mUserName, Uri.parse(mPortraitUri));
        RongIM.getInstance().refreshUserInfoCache(userInfo);
        return userInfo;
    }

    public String getmUserId() {
        return mUserId;
    }

    public void setmUserId(String mUserId) {
        this.mUserId = mUserId;
    }

    public String getmUserName() {
        return mUserName;
    }

    public void setmUserName(String mUserName) {
        this.mUserName = mUserName;
    }

    public String getmPortraitUri() {
        return mPortraitUri;
    }

    public void setmPortraitUri(String mPortraitUri) {
        this.mPortraitUri = mPortraitUri;
    }
}
