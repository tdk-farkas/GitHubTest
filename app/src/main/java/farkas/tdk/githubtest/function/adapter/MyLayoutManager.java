package farkas.tdk.githubtest.function.adapter;

import android.content.Context;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.AttributeSet;

/**
 *
 * Created by tangdikun on 16/1/14.
 */
public class MyLayoutManager {

    public static MyGridManager getGridManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        return new MyGridManager(context,attrs,defStyleAttr,defStyleRes);
    }

    public static MyGridManager getGridManager(Context context, int spanCount){
        return new MyGridManager(context,spanCount);
    }

    public static MyGridManager getGridManager(Context context, int spanCount, int orientation, boolean reverseLayout){
        return new MyGridManager(context,spanCount,orientation,reverseLayout);
    }

    public static MyLinearManager getLinearManager(Context context){
        return new MyLinearManager(context);
    }

    public static MyLinearManager getLinearManager(Context context, int orientation, boolean reverseLayout){
        return new MyLinearManager(context, orientation, reverseLayout);
    }

    public static MyLinearManager getLinearManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        return new MyLinearManager(context, attrs, defStyleAttr, defStyleRes);
    }

    public static StaggeredGridLayoutManager getStaggeredGridManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes){
        return new StaggeredGridLayoutManager(context,attrs,defStyleAttr,defStyleRes);
    }

    public static StaggeredGridLayoutManager getStaggeredGridManager(int spanCount, int orientation){
        return new StaggeredGridLayoutManager(spanCount,orientation);
    }
}
