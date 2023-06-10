package no2114_2127.project.myapplication;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class AwardMakeingWritingPageFragment extends Fragment {
    // text view 선언
    TextView  nextButtonTextView;
    // EditText 선언
    EditText awardTitleEditText, awardTextEditText, awardNameEditText;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_award_makeing_writing_page, container, false);
        // text view find view by id
        nextButtonTextView = view.findViewById(R.id.next_button_text_view);
        // edit text find view by id
        awardTitleEditText = view.findViewById(R.id.award_title_edit_text);
        awardTextEditText = view.findViewById(R.id.award_text_edit_text);
        awardNameEditText = view.findViewById(R.id.award_name_edit_text);
        //awardTitleEditText.addTextChangedListener();
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


    TextWatcher awardTitleTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
//            if(s.length()>=6){
//                awardTitleEditText.setVisibility(View.VISIBLE);
//                nextButtonDeactivation();
//            }else{
//                fromEditTextCaution.setVisibility(View.INVISIBLE);
//                if(rollingPaperEditText.getText().toString().length() > 0 && s.length() > 0){
//                    nextButtonActivation();
//                }else{
//                    nextButtonDeactivation();
//                }
//            }
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

}