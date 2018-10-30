package contactschallenge.ui.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import app.contactschallenge.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import contactschallenge.apputils.calbacks.OnItemClickListener;
import contactschallenge.apputils.dbmodels.ContactDetailModel;
import contactschallenge.core.BaseFragment;
import contactschallenge.ui.adapter.ContactListAdapter;
import io.realm.Realm;
import io.realm.RealmResults;


/**
 * Created by harish on 23/10/18.
 */

public class ContactFragment extends BaseFragment {
    String TAG = ContactFragment.class.getSimpleName();
    @BindView(R.id.recyclar_list)
    RecyclerView recyclarList;
    @BindView(R.id.no_contact)
    TextView noContact;
    private ContactListAdapter contactAdapter;
    private Realm realm;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void getContactList() {
        realm = Realm.getDefaultInstance();
        realm.beginTransaction();
        RealmResults<ContactDetailModel> results = realm.where(ContactDetailModel.class).findAll();
        contactAdapter.updateAll(results);
    }

    private void initRcyclarView() {
        contactAdapter = new ContactListAdapter(getActivity(), new ArrayList<ContactDetailModel>(),
                new OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position, int type, Object t) {

                    }
                });
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclarList.setLayoutManager(layoutManager);
        recyclarList.setAdapter(contactAdapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(getFragmentLayout(), container, false);
        ButterKnife.bind(this, rootView);
        initRcyclarView();
//        getContactList();
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
