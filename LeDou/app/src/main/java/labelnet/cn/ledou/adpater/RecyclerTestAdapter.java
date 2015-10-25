package labelnet.cn.ledou.adpater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import labelnet.cn.ledou.R;
import labelnet.cn.ledou.util.PictureUtil;

/**
 * Created by yuan on 15-10-23.
 */
public class RecyclerTestAdapter extends RecyclerView.Adapter<RecyclerTestAdapter.TmodelViewHolder> {


    private List<String> models;
    private Context mcontext;

    public RecyclerTestAdapter(List<String> models, Context mcontext) {

        this.mcontext = mcontext;
        this.models = models;

    }

    @Override
    public TmodelViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item_card, viewGroup, false);
        view.setTag(models.get(i));
        TmodelViewHolder tmode = new TmodelViewHolder(view);

        return tmode;
    }

    @Override
    public void onBindViewHolder(TmodelViewHolder tmodelViewHolder, int i) {

        tmodelViewHolder.iv_test.setImageBitmap(PictureUtil.readBitMap(mcontext, R.drawable.logo));
        tmodelViewHolder.tv_test.setText(models.get(i));

    }

    @Override
    public int getItemCount() {
        return models == null ? 0 : models.size();
    }

    /**
     * （1）实现 ViewHolder
     */
    public static class TmodelViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_test;
        private ImageView iv_test;

        public TmodelViewHolder(View itemView) {
            super(itemView);

            tv_test = (TextView) itemView.findViewById(R.id.tv_test_item);
            iv_test = (ImageView) itemView.findViewById(R.id.iv_list_item);
        }
    }
}
