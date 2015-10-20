package labelnet.cn.receiver;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import labelnet.cn.bluetoothdemo.R;

/**
 * Created by yuan on 15-9-20.
 */
public class BluetoothReceiver extends BroadcastReceiver {

    private ListView listView;
    private List<BluetoothDevice> devices;
    private ArrayAdapter<String> adapter;

    private List<String> names;

    public BluetoothReceiver(ListView listView) {
        this.listView = listView;
        devices = new ArrayList<BluetoothDevice>();
        names = new ArrayList<String>();
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();

        if (BluetoothDevice.ACTION_FOUND.equals(action)) {
            //找到设备
            BluetoothDevice device = intent.getParcelableExtra(BluetoothDevice.EXTRA_DEVICE);
            if (device.getBondState() != BluetoothDevice.BOND_BONDED) {
                devices.add(device);
                names.add(device.getName() + " \n " + device.getAddress());
            }
        } else if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED.equals(action)) {

            //搜索完毕,适配listview
            if (devices.size() > 0) {

                adapter = new ArrayAdapter<String>(context, R.layout.list_item, R.id.tv_item, names);
                listView.setAdapter(adapter);

            }

        }


    }
}
