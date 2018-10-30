package contactschallenge.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;

import app.contactschallenge.R;
import contactschallenge.apputils.GlobalValues;
import contactschallenge.core.BaseActivity;

/**
 * Created by harish on 29/10/18.
 */

public class SplashActivity extends BaseActivity {
    @Override
    public int getLayoutId() {
        return R.layout.layout_splash_screen;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                activitySwitcher(SplashActivity.this, MainActivity.class, null);
                finish();

            }
        }, GlobalValues.TIME_DURATIONS.EXTRA_LARGE);
    }
}
