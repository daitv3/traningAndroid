package com.example.administrator.traning.appfinal;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.administrator.traning.R;

import java.util.ArrayList;
import java.util.List;

public class Main_fn_Home extends AppCompatActivity implements Fragment_BanHang.OnClickButtonFn{
    TabLayout tabLayout;
    ViewPager viewPager;
    Fragment_BanHang fragment_banHang;
    public static String Token = null;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_fn_home);
        tabLayout = (TabLayout) findViewById(R.id.tab_layout_fn_home);
        viewPager= (ViewPager) findViewById(R.id.fn_view_pager);
        setupViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
        fragment_banHang = new Fragment_BanHang();
        if(getIntent()!= null){
            Token = getIntent().getStringExtra("token");
        }
    }



    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new Fragment_BanHang(), "Bán Hàng");
        adapter.addFragment(new Fragment_CaNhan(), "Hỗ Trợ");
        adapter.addFragment(new Fragment_DaoTao(), "Đào Tạo");
        adapter.addFragment(new Fragment_HoTro(), "Cá Nhân");
        viewPager.setAdapter(adapter);
        viewPager.setOffscreenPageLimit(3);

    }

    private void setupTabIcons() {
        tabLayout.getTabAt(0).setIcon(R.drawable.clerk_with_tie);
        tabLayout.getTabAt(1).setIcon(R.drawable.combined_shape);
        tabLayout.getTabAt(2).setIcon(R.drawable.book);
        tabLayout.getTabAt(3).setIcon(R.drawable.customer_service);

    }

    @Override
    public void onCLickButton() {
        Intent intent = new Intent(Main_fn_Home.this,Ac_Update_Info.class);
         startActivity(intent);
    }


    class ViewPagerAdapter extends FragmentPagerAdapter {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

    }
}
