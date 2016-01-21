package farkas.tdk.githubtest.function.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import farkas.tdk.githubtest.R;


/**
 *
 * Created by Monkey on 2015/6/29.
 */
public class MyRecyclerViewHolder extends RecyclerView.ViewHolder {

    public TextView mTextView;
    public ImageView mImageView;
    public MyRecyclerViewHolder(final View itemView) {
        super(itemView);
        mTextView = (TextView) itemView.findViewById(R.id.id_textview);
        mImageView = (ImageView) itemView.findViewById(R.id.id_imageview);
    }
}
