package vcmanea.example.android07_implementation;

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

public class CountriesFragment extends Fragment {
    View rootView;
    Context mContext;
    String[] countries;
    ListView mListView;
    ArrayAdapter<String> mAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView=inflater.inflate(R.layout.fragment_countries,container,false);
        initUI();
        return rootView;
    }
    private void initUI(){
        mContext=getContext();
        countries=getResources().getStringArray(R.array.countries);
        mListView=rootView.findViewById(R.id.list_view);

        mAdapter=new ArrayAdapter(mContext,android.R.layout.simple_list_item_1,countries);
        mListView.setAdapter(mAdapter);



        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });



    }
}
