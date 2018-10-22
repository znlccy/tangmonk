package com.znlccy.tangmonk.activity;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.znlccy.tangmonk.R;
import com.znlccy.tangmonk.fragment.AudioFragment;
import com.znlccy.tangmonk.fragment.HotspotFragment;
import com.znlccy.tangmonk.fragment.NewsFragment;
import com.znlccy.tangmonk.fragment.ReadFragment;
import com.znlccy.tangmonk.fragment.SettingFragment;
import com.znlccy.tangmonk.pager.ContentViewPager;
import com.znlccy.tangmonk.receiver.MyReceive;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ContentViewPager contentViewPager;
    private RadioGroup radioGroup;
    private MyReceive receive;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private List<Fragment> content_list = null;

    /* 初始化数据 */
    private void initData() {
        content_list = new ArrayList<>();
        content_list.add(new NewsFragment());
        content_list.add(new HotspotFragment());
        content_list.add(new AudioFragment());
        content_list.add(new ReadFragment());
        content_list.add(new SettingFragment());
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
