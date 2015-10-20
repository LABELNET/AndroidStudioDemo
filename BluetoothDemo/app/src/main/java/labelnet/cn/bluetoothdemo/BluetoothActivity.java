package labelnet.cn.bluetoothdemo;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.Toast;

import labelnet.cn.receiver.BluetoothReceiver;

public class BluetoothActivity extends Activity {

    private Switch switch_open, switch_select;
    private ListView lv_selected, lv_bonded;

    private boolean bluetoothStatus = false;

    //蓝牙操作 BluetoothAdapter
    private BluetoothAdapter btadapter;
    private BluetoothReceiver bluetoothReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        initView();

        //注册BordcasrtReceiver
        resgReceiver();
    }

    /**
     * 注册 BordcastReceiver , 搜索 信息使用
     */
    private void resgReceiver() {
        bluetoothReceiver = new BluetoothReceiver(lv_selected);
        IntentFilter intentFilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(bluetoothReceiver, intentFilter);

        IntentFilter intentFilter1 = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        registerReceiver(bluetoothReceiver, intentFilter1);
    }

    /**
     * 初始化控件 和事件
     */
    private void initView() {

        //蓝牙操作实例化
        btadapter = BluetoothAdapter.getDefaultAdapter();

        switch_open = (Switch) findViewById(R.id.switch_open);
        switch_select = (Switch) findViewById(R.id.switch_select);
        lv_selected = (ListView) findViewById(R.id.lv_selected);
        lv_bonded = (ListView) findViewById(R.id.lv_bonded);

        //初始化事件
        switch_select.setOnCheckedChangeListener(new switchOpenListener());
        switch_open.setOnCheckedChangeListener(new switchOpenListener());

        if (isBluetoothStatus() == true) {
            //搜索设备
            switch_open.setChecked(true);
        }
    }


    /**
     * Switch 按钮转换事件
     */

    private class switchOpenListener implements CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

            //判断蓝牙可用否
            if (btadapter == null) {
                show("你的设备不支持蓝牙操作,谢谢使用!");
                return;
            }


            if (buttonView.getId() == R.id.switch_open) {
                //打开蓝牙操作
                show("打开蓝牙按钮");
                //判断打开还是关闭
                if (isChecked) {
                    openBlueTooth();
                } else {
                    closeBlueTooth();
                }


            } else {
                show("可见性按钮!!!isChecked=" + isChecked);
                //打开设备可见性
                if (isChecked) {
                    startDiscovery();

                } else {
                    closeDiscovery();
                }
            }
        }


    }

    /**
     * 检测蓝牙状态 ,打开还是 关闭
     *
     * @return
     */
    private boolean isBluetoothStatus() {
        return btadapter.isEnabled();
    }

    /**
     * 打开蓝牙可见性
     */
    private void startDiscovery() {
        btadapter.startDiscovery();
    }

    /**
     * 关闭蓝牙可见性
     */
    private void closeDiscovery() {
        //取消搜索蓝牙设备
        btadapter.cancelDiscovery();
    }

    /**
     * 关闭蓝牙
     */
    private void closeBlueTooth() {
        btadapter.disable();

        //清楚list 可用设备
    }

    /**
     * 打开蓝牙操作
     */
    private void openBlueTooth() {

        //做提示打开
        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        startActivityForResult(intent, 0);

        //不做提示打开
        // btadapter.enable();
    }



    /**
     * Toast提醒
     *
     * @param text
     */
    private void show(String text) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
    }


    /**
     * 返回结果
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
