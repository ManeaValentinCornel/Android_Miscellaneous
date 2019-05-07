package vcmanea.example.android09_callbacks_donecorrecly;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class CountryFragment extends Fragment {
    View mView;
    String countries[];
    ListView mListView;
    ArrayAdapter<String> mAdapter;
    Context mContext;


    CallBackInterface mCallBackInterface;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_country, container, false);
        initUI();
        return mView;

    }

    /////very important... when you rotate the device //setCallBackInterface will not be called again... because we checked it in the Main activity.... and if it is not null will not launch the setCallBackInterface again
    // and it will try to get get the reference from the alst activity which is already destroyed////
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            mCallBackInterface = (MainActivity) getActivity();
        }
    }

    public void setCallBackInterface(CallBackInterface mCallBackInterface) {
        this.mCallBackInterface = mCallBackInterface;
    }


    private void initUI(){
        mListView=mView.findViewById(R.id.list_view_countries);
        countries=getResources().getStringArray(R.array.countries);
        mContext=getContext();
        mAdapter=new ArrayAdapter<>(mContext,android.R.layout.simple_list_item_1,countries);
        mListView.setAdapter(mAdapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(mCallBackInterface!=null){
                    mCallBackInterface.onCountrySelected(countries[position]);
                }
            }
        });

    }
}
