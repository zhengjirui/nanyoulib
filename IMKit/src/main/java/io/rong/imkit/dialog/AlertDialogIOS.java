package io.rong.imkit.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import io.rong.imkit.R;

/**
 * Created by 18513 on 2017/12/20.
 */

public class AlertDialogIOS {

    private Context context;
    private Dialog dialog;
    private LinearLayout lLayout_bg;
    private Button btn_neg;
    private Button btn_pos;
    private Display display;
    private EditText et_leaving_message;
    private EditText et_leaving_name;
    private EditText et_leaving_num;

    public AlertDialogIOS(Context context) {
        this.context = context;
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
    }

    public AlertDialogIOS builderLeavingMessageDialog(){
        // 获取Dialog布局
        View view = LayoutInflater.from(context).inflate(
                R.layout.ny_view_leaving_message, null);
        et_leaving_name = (EditText) view.findViewById(R.id.et_leaving_name);
        et_leaving_num = (EditText) view.findViewById(R.id.et_leaving_num);
        et_leaving_message = (EditText) view.findViewById(R.id.et_leaving_message);

        // 定义Dialog布局和参数
        dialog = new Dialog(context, R.style.AlertDialogStyle);
        dialog.setContentView(view);
        lLayout_bg = (LinearLayout) view.findViewById(R.id.lLayout_bg);
        btn_neg = (Button) view.findViewById(R.id.btn_neg);
        btn_pos = (Button) view.findViewById(R.id.btn_pos);

        // 调整dialog背景大小
        lLayout_bg.setLayoutParams(new FrameLayout.LayoutParams((int) (display
                .getWidth() * 0.85), LinearLayout.LayoutParams.WRAP_CONTENT));

        return this;
    }

    public AlertDialogIOS setPositiveButton(String text, final View.OnClickListener listener) {
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

    public AlertDialogIOS setNegativeButton(String text, final View.OnClickListener listener) {
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


    public String getLeavingName(){
        return et_leaving_name.getText().toString();
    }

    public String getLeavingNum(){
        return et_leaving_num.getText().toString();
    }

    public String getLeavingContent(){
        return et_leaving_message.getText().toString();
    }


    public void setLeavingName(String nextName){
        et_leaving_name.setText(nextName);
    }

    public void setLeavingNum(String nextNum){
        et_leaving_num.setText(nextNum);
    }

    public void setLeavingContent(String nextContent){
        et_leaving_message.setText(nextContent);
    }



}
