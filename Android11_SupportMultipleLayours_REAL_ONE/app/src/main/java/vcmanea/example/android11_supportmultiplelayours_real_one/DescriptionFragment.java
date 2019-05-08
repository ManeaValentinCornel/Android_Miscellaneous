package vcmanea.example.android11_supportmultiplelayours_real_one;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class DescriptionFragment extends Fragment {
    View holderView;
    private static final String TAG = "DescriptionFragment";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        holderView = inflater.inflate(R.layout.description_fragment, container, false);
        Log.d(TAG, "onCreateView: Description");
        return holderView;

    }
}
