package labelnet.cn.ledou.adpater;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import labelnet.cn.ledou.util.PictureUtil;

public class ViewPagerAdapter extends PagerAdapter {
    /**
     * Welcome引导页适配器
     * ViewPager的适配器
     */
        private int [] ids;
        private Context context;

    /**
     * 构造函数
     * @param ids
     * @param context
     */
        public ViewPagerAdapter(int [] ids,Context context){
            this.ids=ids;
            this.context=context;
        }

        @Override
        public int getCount() {
            return ids.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object o) {
            return view == o;
        }


        /**
         * 重写 instantiateItem 方法
         *
         * @param container
         * @param position
         * @return
         */
        @Override
        public Object instantiateItem(ViewGroup container, int position) {

            Bitmap bitmap=PictureUtil.readBitMap(context, ids[position]);

            ImageView imageView=new ImageView(context);
            imageView.setTag(ids[position]);
            imageView.setImageBitmap(bitmap);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            container.addView(imageView);

            return imageView;
        }

        /**
         * 重写 destroyItem 方法
         *
         * @param container
         * @param position
         * @param object
         */

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            //通过tag 移除 对应的ImageView
            ImageView imageView=(ImageView)container.findViewWithTag(ids[position]);
            container.removeView(imageView);
        }
    }