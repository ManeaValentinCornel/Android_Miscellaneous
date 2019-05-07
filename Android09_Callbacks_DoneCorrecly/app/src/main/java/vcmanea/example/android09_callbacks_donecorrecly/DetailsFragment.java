package vcmanea.example.android09_callbacks_donecorrecly;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class DetailsFragment extends Fragment {
    View view;
    String countryName;
    TextView descriptionTextView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_details, container, false);
        descriptionTextView = view.findViewById(R.id.details_text);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //that is for the default value
        Bundle bundle = getArguments();
        if (bundle != null) {
            countryName = bundle.getString(CallBackInterface.KEY_SELECTED_COUNTRY);

            descriptionTextView.setText(countryName);
        }

    }
}
