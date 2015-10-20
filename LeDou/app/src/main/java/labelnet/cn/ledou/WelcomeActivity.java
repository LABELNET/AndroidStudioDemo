package labelnet.cn.ledou;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

import labelnet.cn.ledou.adpater.ViewPagerAdapter;
import labelnet.cn.ledou.anim.DepthPageTransformer;

public class WelcomeActivity extends Activity {

    private Button btn_welcome;
    private ViewPager vp_welcome;

    private List<ImageView> views;

    private int [] imagesids ={R.drawable.img_welcome_one,R.drawable.img_welcome_two,R.drawable.img_welcome_three};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //设置没有title
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_welcome);


        initView();


    }

    /**
     * 初始化控件
     * 初始化Viewpager数据
     */
    private void initView() {
        views = new ArrayList<ImageView>();
        btn_welcome = (Button) findViewById(R.id.btn_welcome);
        vp_welcome = (ViewPager) findViewById(R.id.vp_welcome);

        //设置适配器
        ViewPagerAdapter pagerAdapter=new ViewPagerAdapter(imagesids,this);
        vp_welcome.setPageTransformer(true, new DepthPageTransformer());

        vp_welcome.setAdapter(pagerAdapter);

        //设置viewpager转换事件
        ViewPagerChangeListener changeListener = new ViewPagerChangeListener();
        vp_welcome.setOnPageChangeListener(changeListener);

        //设置点击事件
        BtnWelcomeClickListener btnWelcomeClickListener = new BtnWelcomeClickListener();
        btn_welcome.setOnClickListener(btnWelcomeClickListener);
    }


    /**
     * 按钮点击事件
     */
    class BtnWelcomeClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(getBaseContext(), LedouActivity.class));
            finish();
        }
    }

    /**
     * 给ViewPager 添加 监听事件
     * 当 为第三页的时候 ， 按钮出现 ， 点击进入 应用主页面
     * 通过 SimpleOnPageChangeListener 实现
     */
    class ViewPagerChangeListener extends ViewPager.SimpleOnPageChangeListener {
        @Override
        public void onPageSelected(int position) {
            if (position == 2) {
                btn_welcome.setVisibility(View.VISIBLE);
            } else {
                btn_welcome.setVisibility(View.GONE);
            }
        }
    }


}
