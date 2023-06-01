package no2114_2127.project.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CakeMakeingPageFragment extends Fragment {
    // TextView Button
    TextView nextButtonTextView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cake_makeing_page, container, false);
        nextButtonTextView = view.findViewById(R.id.next_button_text_view);
        return view;
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    public static CakeMakeingPageFragment CakeMakeingPageInstance() {
        return new CakeMakeingPageFragment();
    }
}
