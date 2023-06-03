package no2114_2127.project.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AwardMakeingWritingPageFragment extends Fragment {
    TextView  nextButtonTextView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_award_makeing_writing_page, container, false);
        nextButtonTextView = view.findViewById(R.id.next_button_text_view);
        nextButtonTextView.setOnClickListener(onClickListener);
        return view;
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    public static AwardMakeingWritingPageFragment AwardMakeChooseFormInstance() {
        return new AwardMakeingWritingPageFragment();
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.next_button_text_view:
                    ((CerdMakeingPageActivity)getActivity()).replaceFragment(AwardMakeingPageFragment.AwardMakeiangPageInstance());
                    break;
            }
        }
    };
}