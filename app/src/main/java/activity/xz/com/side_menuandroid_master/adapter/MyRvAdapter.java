package activity.xz.com.side_menuandroid_master.adapter;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

import activity.xz.com.side_menuandroid_master.R;
import activity.xz.com.side_menuandroid_master.bean.WaitMVBean;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2017/7/4.
 */

public class MyRvAdapter extends RecyclerView.Adapter {

    private Context mContext;
    private List<WaitMVBean.DataBean.ComingBean> comingBeanList;
    private LayoutInflater mLayoutInflater;

    public MyRvAdapter(Context mContext, List<WaitMVBean.DataBean.ComingBean> comingBeanList) {
        this.mContext = mContext;
        this.comingBeanList = comingBeanList;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    /**
     * 创建ViewHolder
     * --->这里创建item布局
     */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(mLayoutInflater.inflate(R.layout.re_item, null));
    }

    /**
     * 绑定ViewHolder
     *
     * @param holder
     * @param position
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        //1.将holder转换为自己类型的MyViewHolder
        MyViewHolder myViewHolder = (MyViewHolder) holder;
        //2.去装配数据
        myViewHolder.setData(position);
    }

    /**
     * 获取Item的条数
     *
     * @return
     */
    @Override
    public int getItemCount() {
        return comingBeanList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView mv_name;
        private TextView mv_dec;
        private TextView mv_date;
        private ImageView imageView;


        public MyViewHolder(@Nullable View itemView) {
            super(itemView);
            mv_name = (TextView) itemView.findViewById(R.id.mv_name);
            mv_dec = (TextView) itemView.findViewById(R.id.mv_dec);
            mv_date = (TextView) itemView.findViewById(R.id.mv_date);
            imageView = (ImageView) itemView.findViewById(R.id.image);
        }

        public void setData(int position) {
            WaitMVBean.DataBean.ComingBean coming = comingBeanList.get(position);
            mv_name.setText(coming.getNm());
            mv_dec.setText(coming.getShowInfo());
            mv_date.setText(coming.getScm());
            //注：当你发下图片无法打开是，做个字符串替换即可
            String imagUrl = coming.getImg();
            String newImagUrl = imagUrl.replaceAll("w.h", "50.80");
            Glide.with(mContext).load(newImagUrl).into(imageView);
            //注意千万不能糊涂这么写哈！
//            for (int i=0;i<beanList.size();i++){
//                String actor = beanList.get(i).getActor();
//                Log.e("TAG", actor);
//                name.setText(actor);
//            }
        }
    }
}
