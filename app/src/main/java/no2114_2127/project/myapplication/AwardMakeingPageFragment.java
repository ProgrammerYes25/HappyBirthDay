package no2114_2127.project.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AwardMakeingPageFragment extends Fragment {
    // text view 선언
    TextView previousButtonTextView, nextButtonTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_award_makeing_page, container, false);
        // TextView findViewById
        previousButtonTextView = view.findViewById(R.id.previous_button_text_view);
        nextButtonTextView = view.findViewById(R.id.next_button_text_view);

        // EditText findViewById

        // Text setOnClick
        previousButtonTextView.setOnClickListener(onClickListener);
        nextButtonTextView.setOnClickListener(onClickListener);

        return view;
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    public static AwardMakeingPageFragment AwardMakeiangPageInstance() {
        return new AwardMakeingPageFragment();
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), CerdMakePageActivity.class);


            switch (v.getId()) {
                case R.id.previous_button_text_view:
                    ((CerdMakeingPageActivity) getActivity()).replaceFragment(CakeMakeWritingPageFragment.CakeMakeWritingPageInstance());
                    break;
                case R.id.next_button_text_view:
                    //((CerdMakeingPageActivity)getActivity()).replaceFragment(CakeMakeWritingPageFragment.CakeMakeWritingPageInstance());
                    getActivity().finish();
                    StageClass.stage = 4;
                    startActivity(intent);
                    break;
            }
        }
    };
}