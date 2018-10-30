package contactschallenge.ui.adapter;

import android.content.res.TypedArray;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import app.contactschallenge.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import contactschallenge.apputils.GlobalValues;
import contactschallenge.apputils.calbacks.OnItemClickListener;
import contactschallenge.apputils.dbmodels.ContactDetailModel;


public class ContactListAdapter extends RecyclerView.Adapter<ContactListAdapter.OptionViewHolder> {

    FragmentActivity activity;
    ArrayList<ContactDetailModel> list;
    OnItemClickListener listener;
    TypedArray icons;

    public ContactListAdapter(FragmentActivity activity, ArrayList<ContactDetailModel> list, OnItemClickListener listener) {
        this.activity = activity;
        this.list = list;
        this.listener = listener;
    }

    @Override
    public OptionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_contact_adapter, parent, false);
        return new OptionViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(OptionViewHolder holder, int position) {
//        MoreOptionModel positionDta = moreOptionModels.get(position);
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void updateAll(List<ContactDetailModel> posts) {
        this.list.clear();
        this.list.addAll(posts);
        notifyDataSetChanged();
    }

    public void addItem(ContactDetailModel posts) {
//        this.slotsList.add(0, posts);
//        notifyDataSetChanged();
    }

    public void updateLikeData(int selectedPosition, String status, String postId) {

    }


    public class OptionViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.contact_name_char)
        TextView contactChar;
        @BindView(R.id.contact_name)
        TextView contactName;
        @BindView(R.id.contact_number)
        TextView contactNumber;

        public OptionViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);

        }

        @OnClick({R.id.contact_name})
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.contact_name:
                    Log.e("onClick", "   " + list.get(getAdapterPosition()).getUserName());
                    listener.onItemClick(v, getAdapterPosition(), GlobalValues.ClickOperations.DETAIL_CLICK, list.get(getAdapterPosition()));
                    break;

            }
        }

        public void setData(ContactDetailModel slotData) {
            // User Detail


        }

        private void toggleRefreshing(boolean b) {

        }


    }
}