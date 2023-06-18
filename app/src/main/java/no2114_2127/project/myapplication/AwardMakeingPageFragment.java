package no2114_2127.project.myapplication;

import static no2114_2127.project.myapplication.CardClass.awardClass;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AwardMakeingPageFragment extends Fragment {
    // text view 선언
    TextView previousButtonTextView, nextButtonTextView, awardTitle, awardText, awardDate,awardFrom;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_award_makeing_page, container, false);
        // TextView findViewById
        previousButtonTextView = view.findViewById(R.id.previous_button_text_view);
        nextButtonTextView = view.findViewById(R.id.next_button_text_view);
        awardTitle= view.findViewById(R.id.award_title);
        awardText= view.findViewById(R.id.award_text);
        awardDate = view.findViewById(R.id.award_date);
        awardFrom= view.findViewById(R.id.award_from);
        awardTitle.setText(awardClass.getAwardTitle());
        awardText.setText(awardClass.getAwardText());
        awardDate.setText(awardClass.getAwardDate());
        awardFrom.setText(awardClass.getAwardFrom());

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
            Intent intent = new Intent(getActivity(), CardMakePageActivity.class);


            switch (v.getId()) {
                case R.id.previous_button_text_view:
                    ((CardMakeingPageActivity) getActivity()).replaceFragment(CakeMakeWritingPageFragment.CakeMakeWritingPageInstance());
                    break;
                case R.id.next_button_text_view:
                    //((CerdMakeingPageActivity)getActivity()).replaceFragment(CakeMakeWritingPageFragment.CakeMakeWritingPageInstance());
                    getActivity().finish();
                    VariableClass.stage = 4;
                    startActivity(intent);
                    break;
            }
        }
    };
}