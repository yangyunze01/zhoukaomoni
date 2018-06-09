package com.example.day_0609;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by 杨运泽 on 2018/6/9.
 */

public class TitleView extends LinearLayout implements View.OnClickListener {
    private ButtonOnClickListener buttonOnClickListener;

    public TitleView(Context context) {
        super(context);
    }

    public TitleView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TitleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        //加载属性
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.TitleView, 0, 0);
        String titleText = typedArray.getString(R.styleable.TitleView_title_text);
        String leftText = typedArray.getString(R.styleable.TitleView_left_text);
        String rightText = typedArray.getString(R.styleable.TitleView_right_text);

        //加载布局
        View inflate = inflate(context, R.layout.title_view_layout, this);
        TextView titleTv = inflate.findViewById(R.id.tv_title);
        Button leftBtn = inflate.findViewById(R.id.btn_left);
        Button rightBtn = inflate.findViewById(R.id.btn_right);
        //设置属性
        titleTv.setText(titleText);
        leftBtn.setText(leftText);
        rightBtn.setText(rightText);
        //设置点击事件
        leftBtn.setOnClickListener(this);
        titleTv.setOnClickListener(this);
        rightBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_left:
                buttonOnClickListener.leftOnClick();
                break;
            case R.id.tv_title:
                buttonOnClickListener.titleOnCLick();
                break;
            case R.id.btn_right:
                buttonOnClickListener.rightOnClick();
                break;
            default:
                break;
        }
    }

    //接口回调
    public interface ButtonOnClickListener {
        void leftOnClick();

        void titleOnCLick();

        void rightOnClick();
    }

    //外部访问的方法
    public void setButtonOnClickListener(ButtonOnClickListener buttonOnClickListener) {
        this.buttonOnClickListener = buttonOnClickListener;
    }
}

