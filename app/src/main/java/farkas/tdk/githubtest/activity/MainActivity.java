package farkas.tdk.githubtest.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import java.io.ByteArrayOutputStream;

import farkas.tdk.githubtest.R;
import farkas.tdk.githubtest.function.Bean.DataItem;
import farkas.tdk.githubtest.function.adapter.MyLayoutManager;
import farkas.tdk.githubtest.function.adapter.MyRecyclerViewAdapter;
import farkas.tdk.githubtest.function.animation.Transition;
import farkas.tdk.githubtest.function.utils.SnackbarUtil;

public class MainActivity extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener,
        MyRecyclerViewAdapter.OnItemClickListener,
        View.OnClickListener {
    private SwipeRefreshLayout swipeRefreshLayout;
    private MyRecyclerViewAdapter recyclerViewAdapter;
    private MainActivity context;
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private FloatingActionButton floatingActionButton;
    private CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.v7_act_main);

        context = MainActivity.this;
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.id_recyclerview);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.id_swiperefreshlayout);

        recyclerViewAdapter = new MyRecyclerViewAdapter(context);

        recyclerViewAdapter.mDatas.add(new DataItem(R.drawable.pic_1));
        recyclerViewAdapter.mDatas.add(new DataItem(R.drawable.pic_2));
        recyclerViewAdapter.mDatas.add(new DataItem(R.drawable.pic_3));
        recyclerViewAdapter.mDatas.add(new DataItem(R.drawable.pic_4));
        recyclerViewAdapter.mDatas.add(new DataItem(R.drawable.pic_5));
        recyclerViewAdapter.mDatas.add(new DataItem(R.drawable.pic_6));
        recyclerViewAdapter.mDatas.add(new DataItem(R.drawable.pic_7));
        recyclerViewAdapter.mDatas.add(new DataItem(R.drawable.pic_8));
        recyclerViewAdapter.mDatas.add(new DataItem(R.drawable.pic_9));
        recyclerViewAdapter.mDatas.add(new DataItem(R.drawable.pic_10));

        recyclerViewAdapter.setOnItemClickListener(context);//设置项点击事件
        recyclerView.setAdapter(recyclerViewAdapter);//设置视图适配器
//        recyclerView.setLayoutManager(MyLayoutManager.getGridManager(context, 2, GridLayoutManager.VERTICAL, false));//设置布局管理器
        recyclerView.setLayoutManager(MyLayoutManager.getLinearManager(context, LinearLayoutManager.VERTICAL, false));//设置布局管理器
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        swipeRefreshLayout.setColorSchemeResources(R.color.main_blue_light, R.color.main_blue_dark);
        swipeRefreshLayout.setOnRefreshListener(context);

        floatingActionButton = (FloatingActionButton) findViewById(R.id.id_floatingactionbutton);
        floatingActionButton.setOnClickListener(context);

        Toolbar toolBar = (Toolbar) findViewById(R.id.id_toolbar);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.id_coordinatorlayout);

        setSupportActionBar(toolBar);

        drawerLayout = (DrawerLayout) findViewById(R.id.id_drawerlayout);

        ActionBarDrawerToggle mActionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolBar, R.string.open, R.string.close);
        mActionBarDrawerToggle.syncState();
        drawerLayout.setDrawerListener(mActionBarDrawerToggle);

        navigationView = (NavigationView) findViewById(R.id.id_navigationview);

        navigationView.inflateHeaderView(R.layout.header_nav);
        navigationView.inflateMenu(R.menu.menu_nav);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(final MenuItem menuItem) {
                String msgString = (String) menuItem.getTitle();

                switch (menuItem.getItemId()) {
                    case R.id.nav_menu_home:
                        break;
                    case R.id.nav_menu_categories:
                        break;
                    case R.id.nav_menu_feedback:
                        break;
                    case R.id.nav_menu_setting:
                        break;
                    case R.id.nav_menu_item_1:
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                menuItem.setChecked(false);
                            }
                        }, 500);
                        break;
                    case R.id.nav_menu_item_2:
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                menuItem.setChecked(false);
                            }
                        }, 500);
                        break;
                }

                menuItem.setChecked(true);
//                drawerLayout.closeDrawers();

                SnackbarUtil.show(navigationView, msgString, 0);
                return true;
            }
        });
    }

    @Override
    public void onRefresh() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                swipeRefreshLayout.setRefreshing(false);
                int temp = (int) (Math.random() * 10);
                recyclerViewAdapter.mDatas.add(0, new DataItem("new" + temp));
                recyclerViewAdapter.notifyDataSetChanged();
            }
        }, 1000);
    }

    @Override
    public void onItemClick(View view, int position) {
        if (!Transition.StartTransition(MainActivity.this, NextActivity.class, view, "image", true)) {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            ((BitmapDrawable) ((ImageView) view).getDrawable()).getBitmap().compress(Bitmap.CompressFormat.PNG, 100, stream);
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, NextActivity.class);
            intent.putExtra(NextActivity.class.getName(), stream.toByteArray());
            startActivity(intent);
            overridePendingTransition(R.anim.act_move_in, R.anim.act_move_out);
        }
    }

    @Override
    public void onItemLongClick(View view, int position) {
        SnackbarUtil.show(coordinatorLayout, getString(R.string.item_longclicked), 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.id_floatingactionbutton:
                SnackbarUtil.show(coordinatorLayout, getString(R.string.item_falot), 0);
                break;
        }
    }
}