package labelnet.cn.ledou.fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import labelnet.cn.ledou.R;

public class TestFragment extends Fragment {


    private String title;


    public TestFragment(String mtitle) {
        this.title = mtitle;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_test, container, false);

        TextView frgm_tv = (TextView) view.findViewById(R.id.frgm_tv);
        frgm_tv.setText(title);
        return view;
    }
}
