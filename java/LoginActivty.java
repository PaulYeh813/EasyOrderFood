package com.paul.easyorderfood;

import android.app.SearchManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private DrawerLayout DL;
    protected NavigationView NV;
    boolean[] flag;
    int price;
    int DATASET_COUNT = 16;
    ArrayList<Item> mDataset = new ArrayList<>();
    //String[] mDataset;
    RecyclerView mRecyclerView;
    DishAdapter mAdapter;
    FloatingActionButton fab;
    CheckBox mCheckBox;
    String order;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        oncreatefab();
        oncreatetoolbar();
        initiateRecyclervie();
        mCheckBox = findViewById(R.id.checkBox);
        flag = new boolean[16];
        order = "";
        findViewById(R.id.action_logout).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, LoginActivty.class));
            }
        });
    }

    private void initiateRecyclervie() {
        initDataset();
        /*for(int i = 0; i < 100; i++){
            mDataset.add(Integer.toString(i));
        }*/
        mAdapter = new DishAdapter(mDataset);
        mRecyclerView = (RecyclerView) findViewById(R.id.list_view);
        final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void oncreatetoolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                // Handle the menu item
                return true;
            }
        });
        toolbar.inflateMenu(R.menu.menu_main);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setLogo(R.drawable.abc_ab_share_pack_mtrl_alpha);
        //把DrawerLayout跟Toolbar綁在一起
        DrawerLayout mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle mActionBarDrawerToggle = new ActionBarDrawerToggle(this,
                mDrawerLayout, toolbar, R.string.open, R.string.close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mActionBarDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mActionBarDrawerToggle);
    }

    //初始化menu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);

        MenuItem menuSearchItem = menu.findItem(R.id.my_search);

        // Get the SearchView and set the searchable configuration
        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView = (SearchView) menuSearchItem.getActionView();

        // Assumes current activity is the searchable activity
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

        // 這邊讓icon可以還原到搜尋的icon
        searchView.setIconifiedByDefault(true);
        return true;
    }

    private void oncreatefab() {
        fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mDataset.get(0).isCheck()) {
                    price = price + 80;
                    order = order + mDataset.get(0).getText().toString() + "\n";
                    //Log.d(TAG,String.valueOf(price));
                }
                if (mDataset.get(1).isCheck()) {
                    price = price + 50;
                    order = order + mDataset.get(1).getText().toString() + "\n";
                    //Log.d(TAG,String.valueOf(price));
                }
                if (mDataset.get(2).isCheck()) {
                    price = price + 60;
                    order = order + mDataset.get(2).getText().toString() + "\n";
                    //Log.d(TAG,String.valueOf(price));
                }
                if (mDataset.get(3).isCheck()) {
                    price = price + 100;
                    order = order + mDataset.get(3).getText().toString() + "\n";
                    //Log.d(TAG,String.valueOf(price));
                }
                if (mDataset.get(4).isCheck()) {
                    price = price + 30;
                    order = order + mDataset.get(4).getText().toString() + "\n";
                    //Log.d(TAG,String.valueOf(price));
                }
                if (mDataset.get(5).isCheck()) {
                    price = price + 40;
                    order = order + mDataset.get(5).getText().toString() + "\n";
                    //Log.d(TAG,String.valueOf(price));
                }
                if (mDataset.get(6).isCheck()) {
                    price = price + 30;
                    order = order + mDataset.get(6).getText().toString() + "\n";
                    //Log.d(TAG,String.valueOf(price));
                }
                if (mDataset.get(7).isCheck()) {
                    price = price + 30;
                    order = order + mDataset.get(7).getText().toString() + "\n";
                    //Log.d(TAG,String.valueOf(price));
                }
                if (mDataset.get(8).isCheck()) {
                    price = price + 30;
                    order = order + mDataset.get(8).getText().toString() + "\n";
                    //Log.d(TAG,String.valueOf(price));
                }
                if (mDataset.get(9).isCheck()) {
                    price = price + 30;
                    order = order + mDataset.get(9).getText().toString() + "\n";
                    //Log.d(TAG,String.valueOf(price));
                }
                if (mDataset.get(10).isCheck()) {
                    price = price + 120;
                    order = order + mDataset.get(10).getText().toString() + "\n";
                    //Log.d(TAG,String.valueOf(price));
                }
                if (mDataset.get(11).isCheck()) {
                    price = price + 60;
                    order = order + mDataset.get(11).getText().toString() + "\n";
                    //Log.d(TAG,String.valueOf(price));
                }
                if (mDataset.get(12).isCheck()) {
                    price = price + 80;
                    order = order + mDataset.get(12).getText().toString() + "\n";
                    //Log.d(TAG,String.valueOf(price));
                }
                if (mDataset.get(13).isCheck()) {
                    price = price + 80;
                    order = order + mDataset.get(13).getText().toString() + "\n";
                    //Log.d(TAG,String.valueOf(price));
                }
                if (mDataset.get(14).isCheck()) {
                    price = price + 50;
                    order = order + mDataset.get(14).getText().toString() + "\n";
                    //Log.d(TAG,String.valueOf(price));
                }
                if (mDataset.get(15).isCheck()) {
                    price = price + 40;
                    order = order + mDataset.get(15).getText().toString() + "\n";
                    //Log.d(TAG,String.valueOf(price));
                }
                Log.d(TAG, String.valueOf(price));
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("確認訂單")
                        .setMessage(order + "一共是" + price + "元")
                        .setPositiveButton("確定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(getApplicationContext(), "訂購完成", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        })
                        .show();
            }
        });
    }


    private void initDataset() {
        Item item = new Item();
        item.setText("漢堡 80元");
        mDataset.add(item);

        Item item1 = new Item();
        item1.setText("薯條 50元");
        mDataset.add(item1);

        Item item2 = new Item();
        item2.setText("雞塊 60元");
        mDataset.add(item2);

        Item item3 = new Item();
        item3.setText("義大利麵 100元");
        mDataset.add(item3);

        Item item4 = new Item();
        item4.setText("玉米濃湯 30元");
        mDataset.add(item4);

        Item item5 = new Item();
        item5.setText("香蒜麵包 40元");
        mDataset.add(item5);

        Item item6 = new Item();
        item6.setText("冰淇淋 30元");
        mDataset.add(item6);

        Item item7 = new Item();
        item7.setText("可口可樂 30元");
        mDataset.add(item7);

        Item item8 = new Item();
        item8.setText("百事可樂 30元");
        mDataset.add(item8);

        Item item9 = new Item();
        item9.setText("紅茶 30元");
        mDataset.add(item9);

        Item item10 = new Item();
        item10.setText("披薩 120元");
        mDataset.add(item10);

        Item item11 = new Item();
        item11.setText("豬肉總匯 60元");
        mDataset.add(item11);

        Item item12 = new Item();
        item12.setText("卡拉雞腿堡 80元");
        mDataset.add(item12);

        Item item13 = new Item();
        item13.setText("5盎司牛肉堡 80元");
        mDataset.add(item13);

        Item item14 = new Item();
        item14.setText("炸雞 50元");
        mDataset.add(item14);

        Item item15 = new Item();
        item15.setText("沙拉 40元");
        mDataset.add(item15);
    }
}
