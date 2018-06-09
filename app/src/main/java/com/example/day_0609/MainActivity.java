package com.example.day_0609;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private TitleView titleView;
    private FlowLayout flowLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //初始化页面
        initViews();
    }


    private void initViews() {
        titleView = findViewById(R.id.titleView_main);
        flowLayout = findViewById(R.id.flowLayout_main);
        //设置监听
        titleView.setButtonOnClickListener(new TitleView.ButtonOnClickListener() {
            @Override
            public void leftOnClick() {
                //左按钮点击减少view
                flowLayout.removeViewAt(0);
            }

            @Override
            public void titleOnCLick() {
                //标题点击清除view
                flowLayout.removeAllViews();
            }

            @Override
            public void rightOnClick() {
                //右按钮点击添加view
                Button button = new Button(getApplicationContext());
                button.setText("杨运泽   宇宙无敌");
                button.setTextColor(Color.RED);
                //FlowLayout 继承的是ViewGroup，所以这里用ViewGroup
                ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT
                );
                //设置宽度为屏幕的一半
                params.width = getWindowManager().getDefaultDisplay().getWidth()/2;
                //设置高度为屏幕的1/5
                params.height = getWindowManager().getDefaultDisplay().getHeight()/25;
                //添加布局
                flowLayout.addView(button,params);
            }

        });
    }
}
