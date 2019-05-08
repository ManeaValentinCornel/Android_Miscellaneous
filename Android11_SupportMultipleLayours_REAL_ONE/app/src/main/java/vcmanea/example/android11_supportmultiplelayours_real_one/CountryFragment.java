package vcmanea.example.android11_supportmultiplelayours_real_one;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class CountryFragment extends Fragment {
   private OnCountryClickListener mOnCountryClickListener;
   private  View holderView;
   private String[] countries;
   private ArrayAdapter mArrayAdapter;
    private ListView mArrayList;
    private static final String TAG = "CountryFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        holderView = inflater.inflate(R.layout.country_fragment, container, false);
        Log.d(TAG, "onCreateView: Country");
        initUI();
        return holderView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            mOnCountryClickListener = (MainActivity) getActivity();
        }
    }

    public void setOnCountryClickListener(OnCountryClickListener countryClickListener) {
        mOnCountryClickListener=countryClickListener;
    }





    private void initUI(){
        countries=getResources().getStringArray(R.array.countries);
        mArrayList=holderView.findViewById(R.id.countries_listview);
        mArrayAdapter=new ArrayAdapter(getContext(),android.R.layout.simple_list_item_1,countries);

        mArrayList.setAdapter(mArrayAdapter);

        mArrayList.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(mOnCountryClickListener!=null) {
                    mOnCountryClickListener.onCountryClick(position);
                }
            }
        });



    }



}
