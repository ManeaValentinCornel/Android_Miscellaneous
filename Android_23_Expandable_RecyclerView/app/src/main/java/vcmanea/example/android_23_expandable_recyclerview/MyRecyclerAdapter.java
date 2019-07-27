package vcmanea.example.android_23_expandable_recyclerview;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.util.SparseBooleanArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.github.aakira.expandablelayout.ExpandableLayoutListener;
import com.github.aakira.expandablelayout.ExpandableLayoutListenerAdapter;
import com.github.aakira.expandablelayout.ExpandableLinearLayout;
import com.github.aakira.expandablelayout.Utils;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    private List<Pioneer> pioneers;
    private Context mContext;
    //SparseBooleanArray map integers to booleans.

    private SparseBooleanArray expandStates= new SparseBooleanArray();

    public MyRecyclerAdapter(List<Pioneer> pioneers, Context context) {
        this.pioneers = pioneers;
        this.mContext=context;
        for(int i=0;i<pioneers.size();i++) expandStates.append(i, false);
    }







    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(mContext).inflate(R.layout.recycler_view_list,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        holder.setIsRecyclable(false);
        holder.txtTitle.setText(pioneers.get(position).getName());
        holder.txtDescription.setText(pioneers.get(position).getDescription());
        holder.mExpandableLinearLayout.setInRecyclerView(true);

        holder.mExpandableLinearLayout.setInterpolator(Utils.createInterpolator(Utils.BOUNCE_INTERPOLATOR));
        holder.mExpandableLinearLayout.setExpanded(expandStates.get(position));
        holder.mExpandableLinearLayout.setListener(new ExpandableLayoutListenerAdapter() {
            @Override
            public void onPreOpen() {
                super.onPreOpen();
                createRotationAnimator(holder.btn,0,180).start();
                expandStates.put(position,true);
            }

            @Override
            public void onPreClose() {
                super.onPreClose();
                createRotationAnimator(holder.btn,180,0).start();
                expandStates.put(position,false);
            }
        });


        holder.btn.setRotation(expandStates.get(position) ? 180f : 0f);
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickButton(holder.mExpandableLinearLayout);

            }
        });

    }

    @Override
    public int getItemCount() {
        return pioneers.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView txtTitle, txtDescription;
        public View btn;

        public ExpandableLinearLayout mExpandableLinearLayout;

        public ViewHolder(View view) {
            super(view);

            txtTitle = view.findViewById(R.id.txt_title);
            txtDescription = view.findViewById(R.id.txt_description);
            btn = view.findViewById(R.id.button);
            mExpandableLinearLayout = view.findViewById(R.id.expamdeble_linear);

        }

    }
        //Toggle out exapandable layout stat when clicked
        private void onClickButton(final ExpandableLinearLayout expandableLinearLayout) {
            expandableLinearLayout.toggle();
        }

        //Create animation from our expandable Layout
        //We use Objec animator, a subclass of ValueAnimator that will provide us support
        public ObjectAnimator createRotationAnimator(View target, float from, float to) {
            ObjectAnimator animator = ObjectAnimator.ofFloat(target, "rotation", from, to);
            animator.setDuration(300);
            animator.setInterpolator(Utils.createInterpolator(Utils.LINEAR_INTERPOLATOR));
            return animator;
        }
    }



