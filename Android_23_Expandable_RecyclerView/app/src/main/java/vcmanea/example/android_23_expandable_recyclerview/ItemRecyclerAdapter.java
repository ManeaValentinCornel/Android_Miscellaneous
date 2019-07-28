package vcmanea.example.android_23_expandable_recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ItemRecyclerAdapter extends RecyclerView.Adapter<ItemRecyclerAdapter.ItemViewHolder> {
    private ArrayList<Item> mItemArrayList;
    private Context mContext;

    public ItemRecyclerAdapter(ArrayList<Item> itemArrayList, Context context) {
        mItemArrayList = itemArrayList;
        mContext = context;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_with_children, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, final int position) {
        final Item item = mItemArrayList.get(position);
        //Set item data
        holder.bind(item);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get currentstate of the item
                boolean expanded = item.isExpanded();
                //Change the state
                item.setExpanded(!expanded);
                //Notify the adapter taht item is changed
                notifyItemChanged(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return (mItemArrayList == null) ? 0 : mItemArrayList.size();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView firstItem;
        TextView seconItem;
        LinearLayout subItem;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            firstItem = itemView.findViewById(R.id.first_item);
            seconItem=itemView.findViewById(R.id.second_item);

            subItem = itemView.findViewById(R.id.sub_item);

        }


        // Method in ViewHolder class

        private void bind(Item item) {
            //Get the state
            boolean expanded = item.isExpanded();
            //Set visibility bsed on state
            subItem.setVisibility(expanded? View.VISIBLE : View.GONE);

            firstItem.setText(item.getText());
              seconItem.setText(item.getSubText());

        }


    }
}