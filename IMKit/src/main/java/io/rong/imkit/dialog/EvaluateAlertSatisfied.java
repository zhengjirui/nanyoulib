package io.rong.imkit.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.IdRes;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import io.rong.imkit.R;
import io.rong.imkit.Utils.SharedUtil;

/**
 * Created by 18513 on 2018/1/17.
 */

public class EvaluateAlertSatisfied {
    private Context context;
    private Dialog dialog;
    private final int RADIOBGSIZE = 90;//背景的大小
    private final int RADIOPADDSIZE = 0;//边距大小
    private LinearLayout lLayout_bg;
    private Display display;
    private TextView rc_btn_ok;
    private TextView rc_btn_cancel;
    private String mStatisfied = "满意";
    private RadioGroup mRadioGroup;
    private RadioButton mRadio1;
    private RadioButton mRadio2;
    private RadioButton mRadio3;
    private RadioButton mRadio4;
    private RadioButton mRadio5;
    private TextView mTextView;
    //    private StarBar star_bar;


    public EvaluateAlertSatisfied(Context context) {
        this.context = context;
        WindowManager windowManager = (WindowManager) context
                .getSystemService(Context.WINDOW_SERVICE);
        display = windowManager.getDefaultDisplay();
    }

    public EvaluateAlertSatisfied builder() {
        // 获取Dialog布局
        View view = LayoutInflater.from(context).inflate(
                R.layout.ny_alert_satisfied_evaluation, null);

        mTextView = (TextView) view.findViewById(R.id.textView);
        // 获取自定义Dialog布局中的控件
        lLayout_bg = (LinearLayout) view.findViewById(R.id.lLayout_bg);
        mRadioGroup = (RadioGroup) view.findViewById(R.id.radio_group);
        mRadio1 = (RadioButton) view.findViewById(R.id.radio_1);
        mRadio2 = (RadioButton) view.findViewById(R.id.radio_2);
        mRadio3 = (RadioButton) view.findViewById(R.id.radio_3);
        mRadio4 = (RadioButton) view.findViewById(R.id.radio_4);
        mRadio5 = (RadioButton) view.findViewById(R.id.radio_5);

        //设置单选按钮的左侧选框大小
        setRadioLeftDrawable(mRadio1);
        setRadioLeftDrawable(mRadio2);
        setRadioLeftDrawable(mRadio3);
        setRadioLeftDrawable(mRadio4);
        setRadioLeftDrawable(mRadio5);

        //设置每个单选按钮的值
        setRadioText();

        //设置监听
        onClickRadio();

        rc_btn_ok = (TextView) view.findViewById(R.id.rc_btn_ok);
        rc_btn_cancel = (TextView) view.findViewById(R.id.rc_btn_cancel);
//        star_bar = (StarBar) view.findViewById(R.id.star_bar);
//        star_bar.setStarMark(5);
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

    private void setRadioLeftDrawable(RadioButton radio) {
        Drawable drawableRadio = context.getResources().getDrawable(R.drawable.ny_radio_selector_bar);
        drawableRadio.setBounds(RADIOPADDSIZE, RADIOPADDSIZE, RADIOBGSIZE, RADIOBGSIZE);
        radio.setCompoundDrawables(drawableRadio, null, null, null);
    }

    private void setRadioText() {
        String mRadio1Text = (String) SharedUtil.get("feed_back_value1", "");
        String mRadio2Text = (String) SharedUtil.get("feed_back_value2", "");
        String mRadio3Text = (String) SharedUtil.get("feed_back_value3", "");
        String mRadio4Text = (String) SharedUtil.get("feed_back_value4", "");
        String mRadio5Text = (String) SharedUtil.get("feed_back_value5", "");
        vertifyString(mRadio1,mRadio1Text);
        vertifyString(mRadio2,mRadio2Text);
        vertifyString(mRadio3,mRadio3Text);
        vertifyString(mRadio4,mRadio4Text);
        vertifyString(mRadio5,mRadio5Text);
        setmStatisfied(mRadio1.getText().toString());

    }

    private void vertifyString(RadioButton radio,String text){
        if(text != null && !text.equalsIgnoreCase("")){
            radio.setText(text);
            radio.setVisibility(View.VISIBLE);
        }else {
            radio.setVisibility(View.GONE);
        }
    }

    public void onClickRadio(){
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                if (checkedId == R.id.radio_1){
                        setmStatisfied(mRadio1.getText().toString());
                }else if(checkedId == R.id.radio_2){
                        setmStatisfied(mRadio2.getText().toString());
                }else if(checkedId == R.id.radio_3){
                        setmStatisfied(mRadio3.getText().toString());
                }else if(checkedId == R.id.radio_4){
                        setmStatisfied(mRadio4.getText().toString());
                }else if(checkedId == R.id.radio_5){
                        setmStatisfied(mRadio5.getText().toString());
                }
            }
        });
    }

    public EvaluateAlertSatisfied setCancelable(boolean cancel) {
        dialog.setCancelable(cancel);
        return this;
    }

    public EvaluateAlertSatisfied setTitle(String title){
        String titleName = (String)SharedUtil.get("feed_back_msg","您可以为客服进行评价！");
        if(title != null && !title.equalsIgnoreCase("")){
            mTextView.setText(titleName.replace("%",title));
        }else {
            mTextView.setText(titleName);
        }
        return this;
    }

    public EvaluateAlertSatisfied setPositiveButton(String text, final View.OnClickListener listener) {
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

    public EvaluateAlertSatisfied setNegativeButton(String text, final View.OnClickListener listener) {
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

    public String getmStatisfied() {
        return mStatisfied;
    }

    public void setmStatisfied(String mStatisfied) {
        this.mStatisfied = mStatisfied;
    }
}
