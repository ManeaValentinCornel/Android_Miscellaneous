package vcmanea.example.android24_recyclerview_expandable_thoughtbot;

import android.view.View;
import android.widget.TextView;

import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder;




public class ProductViewHolder extends ChildViewHolder {

    private TextView mTextView;


    public ProductViewHolder(View itemView) {
        super(itemView);
        mTextView=itemView.findViewById(R.id.text_product);
    }

    public void bind(Product product){
        mTextView.setText(product.name);
    }


}
