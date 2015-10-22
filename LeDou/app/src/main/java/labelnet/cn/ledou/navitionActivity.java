package labelnet.cn.ledou;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class navitionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navition);

//        设置toolbar
        Toolbar toolbar= (Toolbar) findViewById(R.id.navi_toolbar);
        setSupportActionBar(toolbar);

       // StatusBarCompat.compat(this,getResources().getColor(R.color.zhushen_color));
       // StatusBarCompat.compat(this);

    }


}
