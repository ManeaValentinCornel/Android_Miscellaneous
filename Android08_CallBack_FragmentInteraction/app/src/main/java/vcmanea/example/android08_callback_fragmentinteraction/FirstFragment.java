package vcmanea.example.android08_callback_fragmentinteraction;

import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FirstFragment extends Fragment {
    View mView;
    Button mButton;
    private static final String TAG = "FirstFragment";
    CallBackInterface mCallBackInterface;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView=inflater.inflate(R.layout.fragment_first,container,false);
        mButton=mView.findViewById(R.id.button);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mCallBackInterface!=null){
                    mCallBackInterface.callBackMethod();
                            
                }

            }
        });

        return mView;
    }

    public void setCallBackInterface(CallBackInterface mCallBackInterface){
        this.mCallBackInterface=mCallBackInterface;
    }
}
