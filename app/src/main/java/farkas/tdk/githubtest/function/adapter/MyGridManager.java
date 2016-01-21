package farkas.tdk.githubtest.function.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;

/**
 *
 * Created by tangdikun on 16/1/14.
 */
public class MyGridManager extends GridLayoutManager {

    public MyGridManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public MyGridManager(Context context, int spanCount) {
        super(context, spanCount);
    }

    public MyGridManager(Context context, int spanCount, int orientation, boolean reverseLayout) {
        super(context, spanCount, orientation, reverseLayout);
    }

    @Override
    public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int widthSpec,int heightSpec) {
        int itemCount = getItemCount() ;
        if(itemCount == 0) {
            super.onMeasure(recycler, state, widthSpec, heightSpec);
            return ;
        }

        View view = recycler.getViewForPosition(0);
        if(view != null){
            measureChild(view, widthSpec, heightSpec);
            int measuredWidth = View.MeasureSpec.getSize(widthSpec);
            int measuredHeight = view.getMeasuredHeight();
            setMeasuredDimension(measuredWidth, measuredHeight);
        }
    }
}
