package labelnet.cn.ledou;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by yuan on 15-10-25.
 * 作用： 提取公共方法 和 UI
 * 实现 ： 侧边栏效果和浮动按钮
 */
public class LeBaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lebase);

    }
}
