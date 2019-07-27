package vcmanea.example.android24_recyclerview_expandable_thoughtbot;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.GroupViewHolder;

public class CompanyViewHolder extends GroupViewHolder {

    private TextView mTextView;
    //Animation
    private ImageView arrow;

    public CompanyViewHolder(View itemView) {
        super(itemView);
        arrow=itemView.findViewById(R.id.arrow);
        mTextView = itemView.findViewById(R.id.text_company);
    }


    public void bind(Company company){
        mTextView.setText(company.getTitle());
    }


    @Override
    public void expand() {
        animateExpand();
    }

    @Override
    public void collapse() {
        animateCollapse();
    }


    private void animateExpand(){
        RotateAnimation rotate=new RotateAnimation(360,180, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }

    private void animateCollapse(){
        RotateAnimation rotate=new RotateAnimation(180,360,Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rotate.setDuration(300);
        rotate.setFillAfter(true);
        arrow.setAnimation(rotate);
    }
}
