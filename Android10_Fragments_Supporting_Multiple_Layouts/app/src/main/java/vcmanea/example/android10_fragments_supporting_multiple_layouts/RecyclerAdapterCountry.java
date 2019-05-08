package vcmanea.example.android10_fragments_supporting_multiple_layouts;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerAdapterCountry extends RecyclerView.Adapter<RecyclerAdapterCountry.MyViewHolder> {
    Context mContext;
    List<Country> myCountryList;
    OnCountryClickListener mOnCountryClickListener;

    public interface OnCountryClickListener{
        void onCountryClick(int position);
    }

    public void setOnCountryClickListener(OnCountryClickListener onCountryClickListener){
        this.mOnCountryClickListener=onCountryClickListener;
    }




    public RecyclerAdapterCountry(Context mContext,List<Country> listCountry){
        this.mContext=mContext;
        this.myCountryList=listCountry;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view;
        view=LayoutInflater.from(mContext).inflate(R.layout.country_entry,viewGroup,false);

        return new MyViewHolder(view,mOnCountryClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
        myViewHolder.mTextView.setText(myCountryList.get(i).getCountryName());

    }

    @Override
    public int getItemCount() {
        if (myCountryList != null){
            return myCountryList.size();
    }
        return 0;

}
//better to assign the clickListenert than in the onBind... cause in onBinde will be a costly operation... because all the time when we will scroll.. an onClclicklistener will be assigned-bear in mind
    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        public MyViewHolder(@NonNull View itemView , final OnCountryClickListener onCountryClickListener) {
            super(itemView);
            mTextView=itemView.findViewById(R.id.text_view);


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (onCountryClickListener!=null){
                        int position=getAdapterPosition();

                        if(position!=RecyclerView.NO_POSITION){
                            onCountryClickListener.onCountryClick(position);
                        }
                    }
                }




            });





        }
    }

}
