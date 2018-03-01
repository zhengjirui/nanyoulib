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
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import io.rong.imkit.R;
import io.rong.imkit.view.StarBar;

/**
 * Created by 18513 on 2018/1/17.
 */

public class EvaluateAlert {
    private Context context;
    private Dialog dialog;
    private LinearLayout lLayout_bg;
    private Display display;
    private TextView rc_btn_ok;
    private TextView rc_btn_cancel;
    private StarBar star_bar;


    public EvaluateAlert(Context context) {
        this.context = context;
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
    }

    public EvaluateAlert builder() {
        // 获取Dialog布局
        View view = LayoutInflater.from(context).inflate(
                R.layout.rc_cs_alert_human_evaluation, null);

        // 获取自定义Dialog布局中的控件
        lLayout_bg = (LinearLayout) view.findViewById(R.id.lLayout_bg);

        rc_btn_ok = (TextView) view.findViewById(R.id.rc_btn_ok);
        rc_btn_cancel = (TextView) view.findViewById(R.id.rc_btn_cancel);
        star_bar = (StarBar) view.findViewById(R.id.star_bar);
        star_bar.setStarMark(5);
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

    public EvaluateAlert setCancelable(boolean cancel) {
        dialog.setCancelable(cancel);
        return this;
    }

    public EvaluateAlert setPositiveButton(String text, final View.OnClickListener listener) {
        if ("".equals(text)) {
            rc_btn_ok.setText("");
        } else {
            rc_btn_ok.setText(text);
        }
        rc_btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
//				dialog.dismiss();
            }
        });
        return this;
    }

    public EvaluateAlert setNegativeButton(String text, final View.OnClickListener listener) {
        if ("".equals(text)) {
            rc_btn_cancel.setText("");
        } else {
            rc_btn_cancel.setText(text);
        }
        rc_btn_cancel.setOnClickListener(new View.OnClickListener() {
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

    public float getStarMark(){
        return star_bar.getStarMark();
    }

}
