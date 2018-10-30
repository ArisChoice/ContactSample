package contactschallenge.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hbb20.CountryCodePicker;

import app.contactschallenge.R;
import butterknife.BindView;
import butterknife.OnClick;
import contactschallenge.apputils.CommonUtils;
import contactschallenge.apputils.dbmodels.ContactDetailModel;
import contactschallenge.core.BaseActivity;
import io.realm.Realm;

/**
 * Created by harish on 30/10/18.
 */

public class AddContactScreen extends BaseActivity {
    @BindView(R.id.back_toolbar)
    ImageView backToolbar;
    @BindView(R.id.txt_title_toolbar)
    TextView txtTitleToolbar;
    @BindView(R.id.img_edit)
    ImageView imgEdit;
    @BindView(R.id.edtxt_contact_name)
    EditText edtxtContactName;
    @BindView(R.id.ccp)
    CountryCodePicker ccp;
    @BindView(R.id.edtxt_Number_name)
    EditText edtxtNumberName;
    @BindView(R.id.btn_save_contact)
    TextView btnSaveContact;
    private Realm realm;

    @Override
    public int getLayoutId() {
        return R.layout.layout_add_contact;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        realm = Realm.getDefaultInstance();
    }

    @OnClick({R.id.back_toolbar, R.id.btn_save_contact})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.back_toolbar:
                onBackPressed();
                break;
            case R.id.btn_save_contact:
                if (validate()) {
                    saveToDatabase();
                }
                break;
        }
    }

    private boolean validate() {
        if (CommonUtils.isEmpty(edtxtContactName)) {
            CommonUtils.getInstance(AddContactScreen.this).displayMessage(AddContactScreen.this, AddContactScreen.this.getString(R.string.error_name));
            return false;
        } else if (CommonUtils.isEmpty(edtxtNumberName)) {
            CommonUtils.getInstance(AddContactScreen.this).displayMessage(AddContactScreen.this, AddContactScreen.this.getString(R.string.error_number));
            return false;
        } else
            return true;
    }

    private void saveToDatabase() {
        realm.beginTransaction();
        ContactDetailModel userDetail = new ContactDetailModel();
        userDetail.setUserName(edtxtContactName.getText().toString());
        userDetail.setUserCountryCode(ccp.getSelectedCountryCode());
        userDetail.setUserPhoneNumber(edtxtNumberName.getText().toString());
        realm.copyToRealm(userDetail);
        realm.commitTransaction();
        new CommonUtils().displayMessage(AddContactScreen.this, getString(R.string.str_contact_saved));
    }
}
