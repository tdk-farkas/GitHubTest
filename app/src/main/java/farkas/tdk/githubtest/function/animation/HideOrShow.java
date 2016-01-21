package farkas.tdk.githubtest.function.animation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;

/**
 *
 * Created by tangdikun on 16/1/15.
 */
public class HideOrShow {
    public static boolean hideView(final View view){
        if(Build.VERSION.SDK_INT>=21 && view != null){
            int cx = (view.getLeft() + view.getRight()) / 2;
            int cy = (view.getTop() + view.getBottom()) / 2;

            int initialRadius = view.getWidth();

            Animator anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, initialRadius, 0);

            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    view.setVisibility(View.INVISIBLE);
                }
            });
            anim.start();
            return true;
        }else{
            return false;
        }
    }

    public static boolean hideView(final View view,final int visibility){
        if(Build.VERSION.SDK_INT>=21 && view != null){
            int cx = (view.getLeft() + view.getRight()) / 2;
            int cy = (view.getTop() + view.getBottom()) / 2;

            int initialRadius = view.getWidth();

            Animator anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, initialRadius, 0);

            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    view.setVisibility(visibility);
                }
            });
            anim.start();
            return true;
        }else {
            return false;
        }
    }

    public static boolean showView(final View view){
        if(Build.VERSION.SDK_INT>=21 && view != null){
            int cx = (view.getLeft() + view.getRight()) / 2;
            int cy = (view.getTop() + view.getBottom()) / 2;

            int finalRadius = Math.max(view.getWidth(), view.getHeight());

            final Animator anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, 0, finalRadius);
            anim.addListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationStart(Animator animation) {
                    super.onAnimationStart(animation);
                    view.setVisibility(View.VISIBLE);
                }
            });

            anim.start();

            return true;
        }
        return false;
    }
}
