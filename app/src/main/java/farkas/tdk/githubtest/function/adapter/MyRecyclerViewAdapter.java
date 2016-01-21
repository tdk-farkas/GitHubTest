package farkas.tdk.githubtest.function.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import farkas.tdk.githubtest.R;
import farkas.tdk.githubtest.function.Bean.DataItem;

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<MyRecyclerViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(View view, int position);

        void onItemLongClick(View view, int position);
    }

    public OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }


    public Context mContext;
    public List<DataItem> mDatas;
    public LayoutInflater mLayoutInflater;

    public MyRecyclerViewAdapter(Context mContext) {
        this.mContext = mContext;
        mLayoutInflater = LayoutInflater.from(mContext);
        mDatas = new ArrayList<>();
    }

    /**
     * 创建ViewHolder
     */
    @Override
    public MyRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View mView = mLayoutInflater.inflate(R.layout.item_card, parent, false);
        View mView = mLayoutInflater.inflate(R.layout.item_line, parent, false);
        return new MyRecyclerViewHolder(mView);
    }

    /**
     * 绑定ViewHoler，给item中的控件设置数据
     */
    @Override
    public void onBindViewHolder(final MyRecyclerViewHolder holder, final int position) {
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mOnItemClickListener.onItemClick(holder.mImageView, position);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    mOnItemClickListener.onItemLongClick(holder.itemView, position);
                    return true;
                }
            });
        }

        if(mDatas.get(position).getName()==null) {
//            Bitmap bitmap = MyUtil.getBitmapForCircular(ContextCompat.getDrawable(mContext, mDatas.get(position).getResId()));
//            holder.mImageView.setImageBitmap(bitmap);
            holder.mImageView.setImageDrawable(ContextCompat.getDrawable(mContext, mDatas.get(position).getResId()));
        }else {
            holder.mTextView.setText(mDatas.get(position).getName());
//            Bitmap bitmap = MyUtil.getBitmapForCircular(ContextCompat.getDrawable(mContext, R.drawable.ic_user_background));
//            holder.mImageView.setImageBitmap(bitmap);
            holder.mImageView.setImageDrawable(ContextCompat.getDrawable(mContext, R.drawable.ic_user_background));
        }
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }
}
