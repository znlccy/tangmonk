package com.znlccy.tangmonk.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.znlccy.tangmonk.R;
import com.znlccy.tangmonk.adapter.NewsBaseAdapter;
import com.znlccy.tangmonk.bean.Weather;

import java.util.ArrayList;
import java.util.List;

public class NewsFragment extends Fragment implements View.OnClickListener {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        initData();
        super.onCreate(savedInstanceState);
    }

    @Nullable
    private View contentView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (contentView == null) {
            contentView = initView(inflater);
        }
        return contentView;
    }

    private List<Fragment> news_fragment_list;

    /* 初始化数据 */
    private void initData() {

        news_fragment_list = new ArrayList<>();
        HeadlineFragment headline = new HeadlineFragment();
        Bundle bundleHeadline = new Bundle();
        bundleHeadline.putString("news_nav","头条");
        headline.setArguments(bundleHeadline);
        news_fragment_list.add(headline);

        HeadlineFragment entertainment = new HeadlineFragment();
        Bundle bundleEntertainment = new Bundle();
        bundleEntertainment.putString("news_nav", "娱乐");
        entertainment.setArguments(bundleEntertainment);
        news_fragment_list.add(entertainment);

        HeadlineFragment sports = new HeadlineFragment();
        Bundle bundleSports = new Bundle();
        bundleSports.putString("news_nav","体育");
        entertainment.setArguments(bundleSports);
        news_fragment_list.add(sports);

        HeadlineFragment finance = new HeadlineFragment();
        Bundle bundleFinance = new Bundle();
        bundleFinance.putString("news_nav", "财经");
        finance.setArguments(bundleFinance);
        news_fragment_list.add(finance);

        HeadlineFragment science = new HeadlineFragment();
        Bundle bundleScience = new Bundle();
        bundleScience.putString("news_nav", "科技");
        science.setArguments(bundleScience);
        news_fragment_list.add(science);

        HeadlineFragment fashion = new HeadlineFragment();
        Bundle bundleFashion = new Bundle();
        bundleFashion.putString("news_nav", "时尚");
        fashion.setArguments(bundleFashion);
        news_fragment_list.add(fashion);

        HeadlineFragment history = new HeadlineFragment();
        Bundle bundleHistory = new Bundle();
        bundleHistory.putString("news_nav", "历史");
        history.setArguments(bundleHistory);
        news_fragment_list.add(history);

        HeadlineFragment lottery = new HeadlineFragment();
        Bundle bundleLottery = new Bundle();
        bundleLottery.putString("news_nav", "彩票");
        lottery.setArguments(bundleLottery);
        news_fragment_list.add(lottery);

        HeadlineFragment military = new HeadlineFragment();
        Bundle bundleMilitary = new Bundle();
        bundleMilitary.putString("news_nav", "军事");
        military.setArguments(bundleMilitary);
        news_fragment_list.add(military);

        HeadlineFragment game = new HeadlineFragment();
        Bundle bundleGame = new Bundle();
        bundleGame.putString("news_nav", "游戏");
        game.setArguments(bundleGame);
        news_fragment_list.add(game);
    }

    /* 声明右边按钮 */
    private ImageButton btn_right;

    /* 声明悬浮按钮 */
    private View xuanfu_view;

    /* 初始化视图 */
    private View initView(LayoutInflater inflater) {
        View view = inflater.inflate(R.layout.fragment_news, null, false);
        /* 加载悬浮窗布局 */
        xuanfu_view = View.inflate(getActivity(), R.layout.pop_window_view, null);
        btn_right = (ImageButton) view.findViewById(R.id.btn_right);
        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                initPopWindowView(view);
            }
        });

        /* 新闻导航栏控件 */
        final RadioGroup news_radio = (RadioGroup) view.findViewById(R.id.news_radio_group);
        final ViewPager news_viewpage = (ViewPager) view.findViewById(R.id.news_viewpager);
        final HorizontalScrollView news_scrollview = (HorizontalScrollView) view.findViewById(R.id.news_scroll);
        final TextView news_indicator = (TextView) view.findViewById(R.id.news_indicator);

        /* 新闻页的Adapter */
        NewsFragmentAdapter fragmentAdapter = new NewsFragmentAdapter(getActivity().getSupportFragmentManager());
        news_viewpage.setAdapter(fragmentAdapter);
        news_viewpage.setOffscreenPageLimit(2);
        news_radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                ScaleAnimation animation = new ScaleAnimation(1, 1.1f, 1, 1.1f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                animation.setDuration(500);
                animation.setFillAfter(true);
                //遍历所有的RadioButton
                for (int i = 0; i < group.getChildCount(); i++) {
                    RadioButton radioButton = (RadioButton) group.getChildAt(i);
                    if (radioButton.isChecked()) {
                        radioButton.startAnimation(animation);
                    } else {
                        radioButton.clearAnimation();
                    }
                }
                switch (checkedId) {
                    case R.id.news_rb1:
                        news_viewpage.setCurrentItem(0);
                        break;
                    case R.id.news_rb2:
                        news_viewpage.setCurrentItem(1);
                        break;
                    case R.id.news_rb3:
                        news_viewpage.setCurrentItem(2);
                        break;
                    case R.id.news_rb4:
                        news_viewpage.setCurrentItem(3);
                        break;
                    case R.id.news_rb5:
                        news_viewpage.setCurrentItem(4);
                        break;
                    case R.id.news_rb6:
                        news_viewpage.setCurrentItem(5);
                        break;
                    case R.id.news_rb7:
                        news_viewpage.setCurrentItem(6);
                        break;
                    case R.id.news_rb8:
                        news_viewpage.setCurrentItem(7);
                        break;
                    case R.id.news_rb9:
                        news_viewpage.setCurrentItem(8);
                        break;
                    case R.id.news_rb10:
                        news_viewpage.setCurrentItem(9);
                        break;
                }
            }
        });
        news_viewpage.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
                /* 伴随着ViewPager的滑动，滚动指示条TextView */
                // 获取TextView在其父容器LinearLayout中的布局参数
                LinearLayout.LayoutParams params = (LinearLayout.LayoutParams) news_indicator.getLayoutParams();
                params.leftMargin = (int)((i + v) * params.width);
                news_indicator.setLayoutParams(params);
            }

            @Override
            public void onPageSelected(int i) {
                /* 获取对应的位置的RadioButton */
                RadioButton radioButton = (RadioButton) news_radio.getChildAt(1);
                /* 设置对应位置的RadioButton为选中的状态 */
                radioButton.setChecked(true);
                /* 获取屏幕信息 */
                DisplayMetrics metrics = new DisplayMetrics();
                getActivity().getWindowManager().getDefaultDisplay().getMetrics(metrics);
                /* 获取每一个RadioButton的宽度 */
                int radioBtnPiexls = radioButton.getWidth();
                /* 计算滚动距离 */
                int distance = (int)((i + 0.5) * radioBtnPiexls - metrics.widthPixels / 2);
                /* 滚动 */
                news_scrollview.scrollTo(distance, 0);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
        return null;
    }

    @Override
    public void onClick(View v) {

    }

    /* 新闻viewPager的填充类 */
    class NewsFragmentAdapter extends FragmentPagerAdapter {

        public NewsFragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int i) {
            return news_fragment_list.get(i);
        }

        @Override
        public int getCount() {
            return news_fragment_list.size();
        }
    }

    private LinearLayout search;

    private LinearLayout shangtoutiao;

    private LinearLayout lixian;

    private LinearLayout yejian;

    private LinearLayout code;

    private LinearLayout friends;

    private LinearLayout weather_all;

    private TextView tv_temperature;

    private TextView tv_date;

    private TextView tv_pm25;

    private ImageView iv_dayPictureUrl;

    private TextView tv_weather;

    private TextView tv_wind;

    private TextView currentCity;

    private TextView tv_lixian;

    private TextView tv_yejian;

    Weather weather;
    PopupWindow popupWindow;
    /* 悬浮框 */
    public void initPopWindowView(View view) {
        int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = getActivity().getWindowManager().getDefaultDisplay().getHeight();

        popupWindow = new PopupWindow(width, height-150);
        /*popupWindow.setAnimationStyle(R.style.Animation);*/
    }
}
