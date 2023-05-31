package no2114_2127.project.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

public class CakeMakePageFragment extends Fragment {
    // button
    TextView decorationButtonTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cake_make_page, container, false);

        //button find view by id
        decorationButtonTextView = view.findViewById(R.id.decoration_button_text_view);
        decorationButtonTextView.setOnClickListener(onClickListener);
        return view;
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    public static CakeMakePageFragment cakeMakePageInstance() {
        return new CakeMakePageFragment();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.fragment_cake_make_page:

            }
        }
    };
}