package no2114_2127.project.myapplication;



import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class CakeMakeWritingPageFragment extends Fragment {
    //text view 선언
    TextView previousButtonTextView, nextButtonTextView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cake_make_writing_page, container, false);
        previousButtonTextView = view.findViewById(R.id.previous_button_text_view);
        nextButtonTextView = view.findViewById(R.id.next_button_text_view);
        previousButtonTextView.setOnClickListener(onClickListener);
        nextButtonTextView.setOnClickListener(onClickListener);

        return view;
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    public static CakeMakeWritingPageFragment CakeMakeWritingPageInstance() {
        return new CakeMakeWritingPageFragment();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.previous_button_text_view:
                    ((CerdMakeingPageActivity)getActivity()).replaceFragment(CakeMakeingPageFragment.CakeMakeingPageInstance());
                    break;
                case R.id.next_button_text_view:
                    //((CerdMakeingPageActivity)getActivity()).replaceFragment(CakeMakeWritingPageFragment.CakeMakeWritingPageInstance());
                    CerdMakeingPageActivity.rollingPaperSheet();
                    break;
            }
        }
    };
}
