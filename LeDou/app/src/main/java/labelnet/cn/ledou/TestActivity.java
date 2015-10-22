package labelnet.cn.ledou;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;

import java.util.ArrayList;
import java.util.List;

import labelnet.cn.ledou.adpater.TestFragmentAdapter;
import labelnet.cn.ledou.fragment.TestFragment;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);


        TabLayout tabs= (TabLayout) findViewById(R.id.tabs);
        final ViewPager vp_test= (ViewPager) findViewById(R.id.vp_test);

        //初始化数据
        List<String> titles=new ArrayList<String>();
        titles.add("笑话");
        titles.add("欣赏");
        titles.add("高考");
        titles.add("不得");

        List<Fragment> fragments=new ArrayList<Fragment>();
        for (int i=0;i<4;i++){
            tabs.addTab(tabs.newTab().setText(titles.get(i)));
            TestFragment testFragment=new TestFragment(titles.get(i));
            fragments.add(testFragment);

        }



        //设置adapter
        FragmentManager fragmentManager =this.getSupportFragmentManager();
        TestFragmentAdapter testFragmentAdapter=new TestFragmentAdapter(fragmentManager,fragments,titles);
        vp_test.setAdapter(testFragmentAdapter);

        //将tablayout 和Viewpager 关联起来
        tabs.setupWithViewPager(vp_test);
        tabs.setTabsFromPagerAdapter(testFragmentAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_test,menu);

        return true;
    }
}
