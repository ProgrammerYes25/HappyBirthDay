package no2114_2127.project.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CardShowPageFragment extends Fragment {
    // textView button
    TextView decorationButtonTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cerd_show_page, container, false);
        //button find view by id
       // decorationButtonTextView = view.findViewById(R.id.decoration_button_text_view);


        return view;
    }
}
