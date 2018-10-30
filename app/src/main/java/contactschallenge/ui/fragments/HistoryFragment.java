package contactschallenge.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import app.contactschallenge.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import contactschallenge.core.BaseFragment;


/**
 * Created by harish on 23/10/18.
 */

public class HistoryFragment extends BaseFragment {
    String TAG = HistoryFragment.class.getSimpleName();
    @BindView(R.id.recyclar_list)
    RecyclerView recyclarList;
    @BindView(R.id.no_contact)
    TextView noContact;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(getFragmentLayout(), container, false);
        ButterKnife.bind(this, rootView);
        return rootView;
    }

    @Override
    protected int getFragmentLayout() {
        return R.layout.layout_contact_list;
    }

    @Override
    public void UpdateData(int position, Bundle bundle) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception
       /* try {
            calBackInterface = (PageChangeCallBack) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement MyInterface ");
        }*/
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(TAG, " " + requestCode);
        try {
//            Log.e(TAG, " " + data.getStringExtra(GlobalValues.Extras.ADD_MOBILE));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
