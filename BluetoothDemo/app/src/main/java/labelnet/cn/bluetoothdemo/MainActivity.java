package labelnet.cn.bluetoothdemo;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import util.BluetoothUtil;

public class MainActivity extends Activity implements View.OnClickListener {


    private static final int REQUEST_CODE = 0;
    private TextView tv_show;
    private Button btn_support, btn_status, btn_open, btn_close, btn_play;


    private BluetoothUtil bluetoothUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_show = (TextView) findViewById(R.id.tv_show);

        btn_support = (Button) findViewById(R.id.btn_support);
        btn_status = (Button) findViewById(R.id.btn_status);
        btn_open = (Button) findViewById(R.id.btn_open);
        btn_close = (Button) findViewById(R.id.btn_close);

        btn_play = (Button) findViewById(R.id.btn_play);
        btn_play.setOnClickListener(this);
        btn_close.setOnClickListener(this);
        btn_open.setOnClickListener(this);
        btn_status.setOnClickListener(this);
        btn_support.setOnClickListener(this);

        //声明蓝牙操作类
        bluetoothUtil = new BluetoothUtil(this);

    }

    /**
     * 用到的 快捷键
     * ctrl + shift +L
     * ctrl +shift + m
     * ctrl +shift + n
     *
     * @param v
     */

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_support:
                String result = bluetoothUtil.isSupportBluetooth() ? "支持蓝牙" : "不支持蓝牙";
                tv_show.setText(result);
                break;
            case R.id.btn_status:
                String result_staus = bluetoothUtil.isBluetoothStatus() ? "已经打开" : "不可用";
                tv_show.setText(result_staus);
                break;
            case R.id.btn_open:
                bluetoothUtil.openBluetooth(MainActivity.this, REQUEST_CODE);
                break;
            case R.id.btn_close:
                String result_close = bluetoothUtil.closeBluetooth() ? "蓝牙已关闭" : "蓝牙没有关闭";
                tv_show.setText(result_close);
                break;
            case R.id.btn_play:
                startActivity(new Intent(MainActivity.this, BluetoothActivity.class));
                break;
        }

    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == RESULT_OK) {
            tv_show.setText("成功打开");
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
