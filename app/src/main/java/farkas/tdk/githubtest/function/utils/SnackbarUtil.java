package farkas.tdk.githubtest.function.utils;

import android.support.design.widget.Snackbar;
import android.view.View;

import farkas.tdk.githubtest.R;

public class SnackbarUtil {

    // android-support-design兼容包中新添加的一个类似Toast的控件。
    // make()中的第一个参数，可以写当前界面中的任意一个view对象。
//    private static Snackbar snackbar;

    public static void show(View view, String msg, int flag) {
        Snackbar snackbar;
        if (flag == 0) { // 短时显示
            snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_SHORT);
        } else { // 长时显示
            snackbar = Snackbar.make(view, msg, Snackbar.LENGTH_LONG);
        }

        snackbar.show();
        // Snackbar中有一个可点击的文字，这里设置点击所触发的操作。
        snackbar.setAction(R.string.close, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Snackbar在点击“关闭”后消失
            }
        });
    }
}
