package io.rong.imkit.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import io.rong.imkit.R;

/**
 * Created by 18513 on 2017/12/24.
 */

public class ConversitionOffDialog {

    private Context context;
    private Dialog dialog;
    private LinearLayout lLayout_bg;
    private TextView txt_title;
    private TextView txt_msg;
    private Button btn_neg;
    private Button btn_pos;
    private Display display;



    public ConversitionOffDialog(Context context) {
        this.context = context;
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
    }

    public ConversitionOffDialog builder() {
        // 获取Dialog布局
        View view = LayoutInflater.from(context).inflate(
                R.layout.ny_conversation_off_alertdialog, null);

        // 获取自定义Dialog布局中的控件
        lLayout_bg = (LinearLayout) view.findViewById(R.id.lLayout_bg);
        txt_title = (TextView) view.findViewById(R.id.txt_title);
        txt_msg = (TextView) view.findViewById(R.id.txt_msg);
        btn_neg = (Button) view.findViewById(R.id.btn_neg);
        btn_pos = (Button) view.findViewById(R.id.btn_pos);

        // 定义Dialog布局和参数
        dialog = new Dialog(context, R.style.AlertDialogStyle);
        dialog.setContentView(view);

        // 调整dialog背景大小
        lLayout_bg.setLayoutParams(new FrameLayout.LayoutParams((int) (display
                .getWidth() * 0.85), LinearLayout.LayoutParams.WRAP_CONTENT));
        Window dialogWindow = dialog.getWindow();
		WindowManager.LayoutParams lp = dialogWindow.getAttributes();
		dialogWindow.setGravity(Gravity.CENTER_HORIZONTAL);
		lp.y = -200;
		dialogWindow.setAttributes(lp);
        return this;
    }

    public ConversitionOffDialog setTitle(String title) {
        if ("".equals(title)) {
            txt_title.setText("");
        } else {
            txt_title.setText(title);
        }
        return this;
    }

    public ConversitionOffDialog setMsg(String msg) {
        if ("".equals(msg)) {
            txt_msg.setText("");
        } else {
            txt_msg.setText(msg);
        }
        return this;
    }

    public ConversitionOffDialog setCancelable(boolean cancel) {
        dialog.setCancelable(cancel);
        return this;
    }

    public ConversitionOffDialog setPositiveButton(String text, final View.OnClickListener listener) {
        if ("".equals(text)) {
            btn_pos.setText("");
        } else {
            btn_pos.setText(text);
        }
        btn_pos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
//				dialog.dismiss();
            }
        });
        return this;
    }

    public ConversitionOffDialog setNegativeButton(String text, final View.OnClickListener listener) {
        if ("".equals(text)) {
            btn_neg.setText("");
        } else {
            btn_neg.setText(text);
        }
        btn_neg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
                dialog.dismiss();
            }
        });
        return this;
    }

    public void show() {
        dialog.show();
    }

    public void dismiss() {
        dialog.dismiss();
    }

}
