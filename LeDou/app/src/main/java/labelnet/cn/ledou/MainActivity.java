package labelnet.cn.ledou;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.Window;

import com.romainpiel.shimmer.Shimmer;
import com.romainpiel.shimmer.ShimmerTextView;


public class MainActivity extends Activity {


    SharedPreferences spre=null;

    private ShimmerTextView shimmerTextView;
    private Shimmer shimmer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //设置没有title
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_main);


        //Shimmer 闪光字
        shimmerTextView= (ShimmerTextView) findViewById(R.id.shimmer_tv);
        shimmer = new Shimmer();
        shimmer.start(shimmerTextView);

        spre=this.getSharedPreferences("ledou", MODE_PRIVATE);
        initMethod();

    }





    /**
     * Handler 操作进行延时操作 ，延时 3s 后 ，进入 主界面
     */
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {

            //默认值为1 ， 第一次运行必为1，下次运行的时候，就不为1了。
            if(spre.getInt("once",1)==1){

                //修改为0,后跳转
                SharedPreferences.Editor editor=spre.edit();
                editor.putInt("once",0);
                editor.commit();
                //第一次运行
                startActivity(new Intent(MainActivity.this, WelcomeActivity.class));
            }else{
                //不是第一次运行
                startActivity(new Intent(MainActivity.this,LedouActivity.class));
            }


            finish();
        }
    };

    private  void initMethod(){
        //Log.i("LeDou",spre.getInt("once",0)+"");
        //延时操作
        handler.sendEmptyMessageDelayed(0, 3000);

    }


}
