package com.znlccy.tangmonk.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.znlccy.tangmonk.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private List<Fragment> content_list = null;

    /* 初始化数据 */
    private void initData() {
        content_list = new ArrayList<>();
    }

    /* 初始化视图 */
    private void initView() {
        if (content_list == null) {
            return;
        }


    }

    /* 检查网路状态 */
    private void checkNetState() {

    }
}
