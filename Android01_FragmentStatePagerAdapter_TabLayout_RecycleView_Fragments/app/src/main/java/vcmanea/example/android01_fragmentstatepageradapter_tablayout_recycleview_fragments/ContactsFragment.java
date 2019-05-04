package vcmanea.example.android01_fragmentstatepageradapter_tablayout_recycleview_fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class ContactsFragment extends Fragment {
    private RecyclerView mRecyclerView;
    private List<Contact> contactsList;
    private RecycleViewAdapter mRecycleViewAdapter;
    View mView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.contacts, container, false);
        mRecyclerView=mView.findViewById(R.id.recycle_view_id);
        mRecycleViewAdapter=new RecycleViewAdapter(getContext(),contactsList);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setAdapter(mRecycleViewAdapter);

        return mView;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        contactsList=new ArrayList<>();
        contactsList.add(new Contact("Gica","Rada",R.drawable.ic_call_black_24dp));
        contactsList.add(new Contact("Gica","Rada",R.drawable.ic_call_black_24dp));
        contactsList.add(new Contact("Gica","Rada",R.drawable.ic_call_black_24dp));
        contactsList.add(new Contact("Gica","Rada",R.drawable.ic_call_black_24dp));
        contactsList.add(new Contact("Gica","Rada",R.drawable.ic_call_black_24dp));









    }
}
