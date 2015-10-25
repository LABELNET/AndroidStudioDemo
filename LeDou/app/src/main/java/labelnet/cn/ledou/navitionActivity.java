package labelnet.cn.ledou;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class navitionActivity extends AppCompatActivity {


    /**
     * SwipeRefreshLayout
     */
    private SwipeRefreshLayout swipe_refresh;
    private ListView refresh_listview;
    private List<Map<String, String>> datas;
    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navition);

//        设置toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.navi_toolbar);
        setSupportActionBar(toolbar);

        // StatusBarCompat.compat(this,getResources().getColor(R.color.zhushen_color));
        // StatusBarCompat.compat(this);

        initview();
    }

    private void initview() {

        /**
         * 初始化控件
         */
        swipe_refresh = (SwipeRefreshLayout) findViewById(R.id.swipe_refresh);
        refresh_listview = (ListView) findViewById(R.id.refsh_listview);

        /**
         * 初始化数据
         */
        datas = new ArrayList<Map<String, String>>();
        for (int i = 0; i < 20; i++) {
            Map<String, String> map = new HashMap<String, String>();
            map.put("key", "labelnet" + i);
            datas.add(map);
        }

        /**
         * 初始化适配器
         */
        adapter = new SimpleAdapter(this, datas, R.layout.list_item_layout
                , new String[]{"key"}, new int[]{R.id.tv_list_item});
        refresh_listview.setAdapter(adapter);


        /**
         * 刷新控件 设置
         *
         */
        swipe_refresh.setColorSchemeResources(R.color.zhu_color, R.color.zhushen_color
                , R.color.fu_color, R.color.white_color);

        swipe_refresh.setSize(SwipeRefreshLayout.LARGE);
        swipe_refresh.setProgressViewEndTarget(true, 100);
        swipe_refresh.setTop(50);
        /**
         * 刷新设置 监听
         */
        swipe_refresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                //在
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        /**
                         * 模拟刷新添加5条数据
                         */
                        for (int i = 0; i < 5; i++) {
                            Map<String, String> map = new HashMap<String, String>();
                            map.put("key", "yuan" + i);
                            datas.add(map);
                        }

                        /**
                         * 延迟5s时间
                         */
                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        handler.sendEmptyMessage(0x11);

                    }
                }).start();

//                Message message=handler.obtainMessage();
//                message.what=0x11;
//                handler.sendMessageDelayed(message,5000);
            }
        });


        //listview设置 监听事件
        listviewListener listviewListener=new listviewListener();
        refresh_listview.setOnItemClickListener(listviewListener);
    }


    class listviewListener implements AdapterView.OnItemClickListener{
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            TextView view1= (TextView) view.findViewById(R.id.tv_list_item);
            //通过 SnackBar实现 提醒
            Snackbar.make(refresh_listview,view1.getText().toString(),Snackbar.LENGTH_LONG).show();

        }
    }


    /**
     * handler
     */
    private Handler handler=new Handler() {
        @Override
        public void handleMessage(Message msg) {

            /**
             * 数据更新完了,开始更新UI
             */

            if(msg.what==0x11) {
                for (int i = 0; i < 5; i++) {
                            Map<String, String> map = new HashMap<String, String>();
                            map.put("key", "yuan" + i);
                            datas.add(map);
                        }
                //更新ui
                adapter.notifyDataSetChanged();
                swipe_refresh.setRefreshing(false);
            }

        }
    };


}
