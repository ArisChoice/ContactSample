package contactschallenge.ui;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import app.contactschallenge.R;
import butterknife.BindView;
import butterknife.OnClick;
import contactschallenge.core.BaseActivity;
import contactschallenge.ui.adapter.HomePageAdapter;

public class MainActivity extends BaseActivity {


    @BindView(R.id.back_toolbar)
    ImageView backToolbar;
    @BindView(R.id.txt_title_toolbar)
    TextView txtTitleToolbar;
    @BindView(R.id.img_edit)
    ImageView imgEdit;
    @BindView(R.id.pager_main)
    ViewPager pagerMain;
    @BindView(R.id.navigation)
    BottomNavigationView navigation;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    txtTitleToolbar.setText(R.string.title_contacts);
                    imgEdit.setVisibility(View.VISIBLE);
                    return true;
                case R.id.navigation_dashboard:
                    txtTitleToolbar.setText(R.string.title_history);
                    imgEdit.setVisibility(View.INVISIBLE);
                    return true;
            }
            return false;
        }
    };
    private HomePageAdapter mainPagerAdapter;
    public int currentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        backToolbar.setVisibility(View.INVISIBLE);
        txtTitleToolbar.setVisibility(View.VISIBLE);
        imgEdit.setVisibility(View.VISIBLE);
        txtTitleToolbar.setText(R.string.title_contacts);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initPager();
    }

    /**
     * initialize pager
     */
    private void initPager() {
        mainPagerAdapter = new HomePageAdapter(getApplicationContext(), getSupportFragmentManager());
        pagerMain.setAdapter(mainPagerAdapter);
        pagerMain.setOffscreenPageLimit(2);
//        pointDetailPager.setPageTransformer(true, new AccordionTransformer());
        pagerMain.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {


            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @OnClick({R.id.back_toolbar, R.id.img_edit})
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.img_edit:
                activitySwitcher(MainActivity.this, AddContactScreen.class, new Bundle());
                break;
        }
    }
}
