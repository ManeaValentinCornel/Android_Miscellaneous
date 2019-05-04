package vcmanea.example.android01_fragmentstatepageradapter_tablayout_recycleview_fragments;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    Context mContext;
    List <Contact> mContacts;

    public RecycleViewAdapter(Context context, List<Contact> contacts) {
        mContext = context;
        mContacts = contacts;
    }

    @NonNull
    @Override
    public RecycleViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v;
        v= LayoutInflater.from(mContext).inflate(R.layout.item_contact,viewGroup,false);

        MyViewHolder myViewHolder=new MyViewHolder(v);
        return myViewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull RecycleViewAdapter.MyViewHolder viewHolder, int i) {

        viewHolder.tvName.setText(mContacts.get(i).getName());
        viewHolder.tvPhone.setText(mContacts.get(i).getPhone());
        viewHolder.img.setImageResource(mContacts.get(i).getPhoto());


    }

    @Override
    public int getItemCount() {
      return mContacts.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView tvName;
        private TextView tvPhone;
        private ImageView img;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName=itemView.findViewById(R.id.name_contact);
            tvPhone=itemView.findViewById(R.id.phoone_contact);
            img=itemView.findViewById(R.id.img_contact);



        }
    }


}
