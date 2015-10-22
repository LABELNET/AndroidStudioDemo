package labelnet.cn.ledou;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

/**
 * Created by yuan on 15-10-22.
 */
public class toobarActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toobar);


        //浮动按钮
        final FloatingActionButton float_btn = (FloatingActionButton) findViewById(R.id.float_btn);
        float_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(float_btn, "你还好吗?", Snackbar.LENGTH_SHORT)
                        .show();
            }
        });


        //toolbar
        final Toolbar toolbar_bars= (Toolbar) findViewById(R.id.toolbar_bars);
        setSupportActionBar(toolbar_bars);


        CollapsingToolbarLayout collapsing_toolbarlayout= (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbarlayout);
        collapsing_toolbarlayout.setTitle("乐逗-真逗!");

    }
}
