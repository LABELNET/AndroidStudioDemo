package com.example.yuan.yuan;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements View.OnClickListener {

    private Button btn_id;
    private TextView tv;
    private int i = 0;

    private int[] imgIds = {R.id.icon_down, R.id.icon_error, R.id.icon_left, R.id.icon_light,
            R.id.icon_location, R.id.icon_none, R.id.icon_true};

    private ImageView iv_up;
    private List<ImageView> imageViews = new ArrayList<ImageView>();

    //控制按钮
    private boolean flag = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_id = (Button) findViewById(R.id.btn_id);
        tv = (TextView) findViewById(R.id.tv_show);
        btn_id.setOnClickListener(new btnidListener());

        iv_up = (ImageView) findViewById(R.id.icon_up);
        iv_up.setOnClickListener(this);


        //初始化ImageView
        for (int id : imgIds) {
            ImageView imageView = (ImageView) findViewById(id);
            //给每个菜单设置监听事件
            imageView.setOnClickListener(this);
            imageViews.add(imageView);

        }

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.icon_up:
                if (flag) {
                    startAnim();
                    flag = false;
                } else {
                    closeAnim();
                    flag = true;
                }

                break;
            default:
                Toast.makeText(this, "点击的图片ID为" + v.getId(), Toast.LENGTH_SHORT).show();
                break;

        }

    }

    /**
     * 创建展开动画
     */
    private void startAnim() {

        for (int i = 0; i < imageViews.size(); i++) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageViews.get(i), "translationY", 0, i * 100f);
            animator.setDuration(500);
            //设置延时 一个一个出来
            //不设置 同时出来
            //设置插入器 Android 自带有插入器
            animator.setInterpolator(new BounceInterpolator());
            animator.setStartDelay(i * 300);
            animator.start();
        }

    }

    /**
     * 创建收回动画
     */
    private void closeAnim() {
        for (int i = 0; i < imageViews.size(); i++) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(imageViews.get(i),
                    "translationY", i * 100f, 0);
            animator.setDuration(500);
            //设置延时 一个一个出来
            //不设置 同时出来
            //设置插入器 Android 自带有插入器
            animator.setInterpolator(new BounceInterpolator());
            animator.setStartDelay(i * 300);
            animator.start();
        }
    }


    /**
     * 这里的快捷键有:
     * alt+/  :智能提示
     * alt+enter : 错误补全
     * <p/>
     * 自定义的快捷键设置:
     * Keymap->Main Menu->Code->Completion 里面设置
     * ctrl + shift + L : 提示实现接口
     * ctrl + shift + n :提示重写的方法
     */
    class btnidListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            //ValueAnimator
            ValueAnimator valueAnimator=ValueAnimator.ofInt(0,100);
            valueAnimator.setDuration(5000);
            //添加监听事件
            valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                @Override
                public void onAnimationUpdate(ValueAnimator animation) {
                    btn_id.setText(animation.getAnimatedValue().toString());
                }
            });
            valueAnimator.start();



            tv.setText("移动中....." + i);
            i++;
            ImageView imageView = (ImageView) findViewById(R.id.imageView);

            /**
             *   参数: rotation
             translationX
             translationY
             */

            //Animation 方式执行动画
//            TranslateAnimation animation=new TranslateAnimation(0.0f,100.0f,0.0f,100.0f);
//            animation.setDuration(2000);
//            animation.setFillAfter(true);
//            imageView.startAnimation(animation);

            /**
             * ObjectAnimator 方式执行方式
             * 设置三个动画 同时执行了;
             */
//            ObjectAnimator animation=ObjectAnimator.ofFloat(imageView,"translationX",0.0f,200.0f);
//            animation.setDuration(1000);
//            animation.start();
//
//            ObjectAnimator animation1=ObjectAnimator.ofFloat(imageView,"translationY",0.0f,200.0f);
//            animation1.setDuration(1000);
//            animation1.start();
//
//            ObjectAnimator animation2=ObjectAnimator.ofFloat(imageView,"rotation",0.0f,200.0f);
//            animation2.setDuration(1000);
//            animation2.start();

//            /**
//             * AnimatorSet
//             * 控制 多个动画的运行
//             */
//            ObjectAnimator animation=ObjectAnimator.ofFloat(imageView,"translationX",0.0f,200.0f);
//
//            ObjectAnimator animation1=ObjectAnimator.ofFloat(imageView,"translationY",0.0f,200.0f);
//
//            ObjectAnimator animation2=ObjectAnimator.ofFloat(imageView,"rotation",0.0f,200.0f);
//
//            AnimatorSet set=new AnimatorSet();
//            //多个动画同时执行
//            // set.playTogether(animation,animation1,animation2);
//            //多个动画按放入位置执行
//            // set.playSequentially(animation,animation1,animation2);
//            //顺序控制执行
//            set.play(animation1).with(animation);
//            set.play(animation2).after(animation);
//
//            set.setDuration(1000);
//            set.start();


            /**
             * PropertyValuesHolder
             * 属性集合
             * 可以方便调用使用;
             */
            PropertyValuesHolder holder = PropertyValuesHolder.ofFloat("translationX", 0.0f, 200.0f);
            PropertyValuesHolder holder1 = PropertyValuesHolder.ofFloat("translationY", 0.0f, 200.0f);
            //通过ofPropertyValuesHolder 实现
            ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(imageView, holder, holder1);
            objectAnimator.setDuration(1000);
            objectAnimator.start();

            imageView.setOnClickListener(new imageClick());

        }
    }

    class imageClick implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            Toast.makeText(MainActivity.this, "我是图片点击事件!", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
