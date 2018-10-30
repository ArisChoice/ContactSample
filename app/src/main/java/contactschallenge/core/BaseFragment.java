package contactschallenge.core;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import javax.inject.Inject;

import butterknife.ButterKnife;
import contactschallenge.apputils.PreferenceManager;

/**
 * Created by harish on 16/10/18.
 */

public abstract class BaseFragment extends Fragment {
    @Inject
    public PreferenceManager mPref;


    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ((ContactApplication) getActivity().getApplication()).getMyComponent(getActivity()).inject(this);
        View rootView = inflater.inflate(getFragmentLayout(), container, false);
        ButterKnife.bind(this, rootView);
        return inflater.inflate(getFragmentLayout(), container, false);
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    protected abstract int getFragmentLayout();

    public abstract void UpdateData(int position, Bundle bundle);
}
