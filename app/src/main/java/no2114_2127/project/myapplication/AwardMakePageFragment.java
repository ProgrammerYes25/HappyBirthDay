package no2114_2127.project.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AwardMakePageFragment extends Fragment {
    TextView awardButtonTextView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_award_make_page, container, false);
        awardButtonTextView = view.findViewById(R.id.award_button_text_view);
        awardButtonTextView.setOnClickListener(onClickListener);
        return view;
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    public static AwardMakePageFragment AwardMakePageInstance() {
        return new AwardMakePageFragment();
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), CardMakeingPageActivity.class);

            switch (v.getId()){
                case R.id.award_button_text_view:
                    getActivity().finish();
                    startActivity(intent);
                    break;
            }
        }
    };
}