package no2114_2127.project.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PolaroidMakeingPageFragment extends Fragment {
    TextView polaroidButtonTextView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_polaroid_makeing_page, container, false);
        polaroidButtonTextView = view.findViewById(R.id.polaroid_button_text_view);
        polaroidButtonTextView.setOnClickListener(onClickListener);
        return view;
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    public static PolaroidMakeingPageFragment PolaroidMakeingPageInstance() {
        return new PolaroidMakeingPageFragment();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), CerdMakePageActivity.class);

            switch (v.getId()){
                case R.id.polaroid_button_text_view:
                    getActivity().finish();
                    StageClass.stage =2;
                    startActivity(intent);
                    break;
            }
        }
    };
}
