package contactschallenge.core;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import app.contactschallenge.R;
import butterknife.ButterKnife;
import contactschallenge.apputils.CommonUtils;
import contactschallenge.apputils.Dialogs;
import contactschallenge.apputils.GlobalValues;
import contactschallenge.apputils.PreferenceManager;

/**
 * Created by harish on 16/10/18.
 */

public abstract class BaseActivity extends AppCompatActivity {
    // since its going to be common for all the activities
    private ProgressDialog mProgressDialog;
    private Dialogs dialogs;
    @Inject
    public PreferenceManager mPref;
    @Inject
    public CommonUtils cUtils;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        performDataBinding();
        dialogs = Dialogs.getInstance(this);
        ((ContactApplication) getApplication()).getMyComponent(this).inject(this);

    }

    /**
     * @return layout resource id
     */
    public abstract
    @LayoutRes
    int getLayoutId();

    private void performDataBinding() {
        setContentView(getLayoutId());
        ButterKnife.bind(this);
    }

    public void showLoading() {
        hideLoading();
        mProgressDialog = dialogs.showLoadingDialog(this);
        mProgressDialog.setCancelable(false);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mProgressDialog.setCancelable(true);
            }
        }, GlobalValues.TIME_DURATIONS.LARGE);

    }

    public void hideLoading() {
        dialogs.DismissDialog(mProgressDialog);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_from_left, R.anim.slide_to_right);
    }

    public static void activitySwitcher(Activity from, Class<?> to, Bundle bundle) {

        Intent intent = new Intent(from, to);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        from.startActivity(intent);
        from.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }

    public static void activitySwitcherResult(Activity from, Class<?> to, Bundle bundle, int requestCode) {

        Intent intent = new Intent(from, to);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        from.startActivityForResult(intent, requestCode);
        from.overridePendingTransition(R.anim.slide_from_right, R.anim.slide_to_left);
    }
}
