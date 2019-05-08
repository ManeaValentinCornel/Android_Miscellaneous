package vcmanea.example.android10_fragments_supporting_multiple_layouts;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


import java.util.List;

public class CountryFragment extends Fragment {
    View rootView;
    RecyclerView mRecyclerView;
    List<Country> countryList;
    private static final String TAG = "CountryFragment";



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_country, container, false);
        Log.d(TAG, "onCreateView: ");
        initUI();
        return rootView;
    }


    public void initUI(){

        mRecyclerView=rootView.findViewById(R.id.recycle_view);
        countryList=Country.getCountryList();
        RecyclerAdapterCountry adapter=new RecyclerAdapterCountry(getContext(),countryList);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayout.VERTICAL,false));
        mRecyclerView.setAdapter(adapter);
        adapter.setOnCountryClickListener((MainActivity)getActivity());
        adapter.notifyDataSetChanged();


    }




}
