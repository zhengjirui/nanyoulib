package io.rong.imkit.plugin;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;

import io.rong.imkit.R;
import io.rong.imkit.RongExtension;
import io.rong.imkit.Utils.NyUtiles;
import io.rong.imlib.model.Conversation;

/**
 * Created by 18513 on 2017/12/14.
 */

public class EvaluatePlugin implements IPluginModule {
    Conversation.ConversationType conversationType;
    String targetId;

    public EvaluatePlugin() {
    }

    public Drawable obtainDrawable(Context context) {
        return ContextCompat.getDrawable(context, R.drawable.rc_ext_plugin_image_selector);
    }

    public String obtainTitle(Context context) {
        return "评论";
    }

    public void onClick(Fragment currentFragment, RongExtension extension) {
        NyUtiles.showToast("评论");
//        String[] permissions = new String[]{"android.permission.READ_EXTERNAL_STORAGE"};
//        if(PermissionCheckUtil.requestPermissions(currentFragment, permissions)) {
//            this.conversationType = extension.getConversationType();
//            this.targetId = extension.getTargetId();
//            Intent intent = new Intent(currentFragment.getActivity(), PictureSelectorActivity.class);
//            extension.startActivityForPluginResult(intent, 23, this);
//        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }
}
