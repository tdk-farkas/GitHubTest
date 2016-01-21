package farkas.tdk.githubtest.activity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.Toast;

import farkas.tdk.githubtest.R;
import farkas.tdk.githubtest.function.animation.Transition;

/**
 *
 * Created by tangdikun on 16/1/13.
 */
public class NextActivity extends AppCompatActivity {
    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_next);

        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.id_collapsingtoolbarlayout);
        Toolbar toolbar = (Toolbar) findViewById(R.id.id_toolbar);
        setSupportActionBar(toolbar);

        ImageView imageView = (ImageView) findViewById(R.id.id_imageview);

        if(!Transition.receiveTransition(this, imageView)){
            Bundle bundle = getIntent().getExtras();
            byte[] byteArray = bundle.getByteArray(this.getClass().getName());
            if(byteArray!=null) {
                Bitmap bitmap = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
                imageView.setImageBitmap(bitmap);
            }else{
                Toast.makeText(this, "载入图片出错", Toast.LENGTH_LONG).show();
            }
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                collapsingToolbarLayout.setContentScrimColor(ContextCompat.getColor(NextActivity.this, R.color.colorPrimary));
            }
        }, 1000);

        collapsingToolbarLayout.setExpandedTitleColor(ContextCompat.getColor(this, R.color.colorAccent));
        collapsingToolbarLayout.setCollapsedTitleTextColor(ContextCompat.getColor(this, R.color.main_white));

//        添加返回按钮
//        if(getSupportActionBar()!=null) {
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.act_move_in, R.anim.act_move_out);
        if(Build.VERSION.SDK_INT>=21)
            finishAfterTransition();
    }
}