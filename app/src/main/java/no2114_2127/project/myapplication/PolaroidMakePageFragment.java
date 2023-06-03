package no2114_2127.project.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PolaroidMakePageFragment extends Fragment {
    TextView polaroidButtonTextView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_polaroid_make_page, container, false);

        polaroidButtonTextView = view.findViewById(R.id.polaroid_button_text_view);
        polaroidButtonTextView.setOnClickListener(onClickListener);

        return view;
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    public static PolaroidMakePageFragment PolaroidMakePageInstance() {
        return new PolaroidMakePageFragment();
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), CerdMakeingPageActivity.class);

            switch (v.getId()){
                case R.id.polaroid_button_text_view:
                    getActivity().finish();
                    startActivity(intent);
                    break;
            }
        }
    };
}