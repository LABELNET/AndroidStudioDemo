package util;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuan on 15-9-20.
 */
public class BluetoothUtil {


    private BluetoothAdapter bluetoothAdapter;
    private Context context;

    public BluetoothUtil(Context context) {
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        this.context = context;
    }


    /**
     * 蓝牙设备的可见性
     */
    public void selectDevice() {
        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
        intent.putExtra(BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
        context.startActivity(intent);
    }

    /**
     * 查找设备
     */
    public void findDevice() {
        if (bluetoothAdapter != null) {
            bluetoothAdapter.startDiscovery();
        }
    }

    /**
     * 获得设备列表
     */
    public List<BluetoothDevice> getDevice() {
        return new ArrayList(bluetoothAdapter.getBondedDevices());
    }

    /**
     * 判断是否支持蓝牙
     *
     * @return
     */
    public boolean isSupportBluetooth() {
        return bluetoothAdapter == null ? false : true;
    }


    /**
     * 判断是否可用
     *
     * @return
     */
    public boolean isBluetoothStatus() {
        assert (bluetoothAdapter != null);
        return bluetoothAdapter.isEnabled();
    }

    /**
     * 打开蓝牙
     * 使用Intent 实现
     */
    public void openBluetooth(Activity activity, int requestCode) {

        Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
        activity.startActivityForResult(intent, requestCode);
        bluetoothAdapter.enable();
    }

    public boolean closeBluetooth() {
        return bluetoothAdapter.disable();
    }


}
