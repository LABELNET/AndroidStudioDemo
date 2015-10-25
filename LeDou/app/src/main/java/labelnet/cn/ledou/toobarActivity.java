package labelnet.cn.ledou;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import labelnet.cn.ledou.adpater.RecyclerTestAdapter;

/**
 * Created by yuan on 15-10-22.
 */
public class toobarActivity extends AppCompatActivity {


    /**
     * RecyclerView 使用
     */
    private RecyclerView recycler_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toobar);

//
//        //浮动按钮
//        final FloatingActionButton float_btn = (FloatingActionButton) findViewById(R.id.float_btn);
//        float_btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Snackbar.make(float_btn, "你还好吗?", Snackbar.LENGTH_SHORT)
//                        .show();
//            }
//        });


        //toolbar
        final Toolbar toolbar_bars= (Toolbar) findViewById(R.id.toolbar_bars);
        setSupportActionBar(toolbar_bars);


        CollapsingToolbarLayout collapsing_toolbarlayout= (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbarlayout);
        collapsing_toolbarlayout.setTitle("乐逗-真逗!");

        initView();
    }

    private void initView() {

        /**
         * RecyclerView 使用
         */
        recycler_view= (RecyclerView) findViewById(R.id.recycler_view);
        // 设置LinearLayoutManager , 控制 横向 还是 纵向
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this);
       // linearLayoutManager.setOrientation(LinearLayout.HORIZONTAL);

        recycler_view.setLayoutManager(linearLayoutManager);



        /**
         * 准备数据
         */
        List<String> models=new ArrayList<String>();
        for (int i=0;i<20;i++){
            models.add("yuan"+i);
        }

        /**
         * 设置适配器
         */
        RecyclerTestAdapter recyclerTestAdapter=new RecyclerTestAdapter(models,this);
        recycler_view.setAdapter(recyclerTestAdapter);

        for(int i=0;i<models.size();i++){
            Log.i("Model", models.get(i));
        }

    }



}
