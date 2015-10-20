package labelnet.cn.adapter;

import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import labelnet.cn.bluetoothdemo.R;

/**
 * Created by yuan on 15-9-20.
 */
public class SelectedAdaprer extends BaseAdapter {

    private List<BluetoothDevice> devices;
    private Context context;

    public SelectedAdaprer(List<BluetoothDevice> devices, Context context) {
        this.devices = devices;
        this.context = context;
    }

    @Override
    public int getCount() {
        return devices.size();
    }

    @Override
    public Object getItem(int position) {
        return devices.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {



        View view = LayoutInflater.from(context).inflate(R.layout.list_item, parent,false);
        TextView tv_item = (TextView) view.findViewById(R.id.tv_item);
        BluetoothDevice device = devices.get(position);
        String result = "设备名称: " + device.getName() + "\n 设备地址: " + device.getAddress();
        tv_item.setText(result);


        return convertView;
    }
}
