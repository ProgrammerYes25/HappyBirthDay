package no2114_2127.project.myapplication;

import static no2114_2127.project.myapplication.CardClass.awardClass;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AwardMakeingWritingPageFragment extends Fragment {
    String CALENDAR_FORMAT = "yyyy/MM/dd";
    // text view 선언
    TextView  nextButtonTextView;
    // EditText 선언
    EditText awardTitleEditText, awardTextEditText, awardNameEditText;

    RelativeLayout awardMakeingLayout;
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
        awardTitleEditText.addTextChangedListener(awardWatcher);
        awardTextEditText.addTextChangedListener(awardWatcher);
        awardNameEditText.addTextChangedListener(awardWatcher);
        nextButtonTextView.setOnClickListener(onClickListener);
        awardMakeingLayout = view.findViewById(R.id.award_makeing_layout);
        awardMakeingLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideKeyboard();
                return false;
            }
        });

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
                    if(awardTitleEditText.getText().toString().length() > 0 &&  awardTextEditText.getText().toString().length()>0 &&  awardNameEditText.getText().toString().length() > 0) {
                        awardClass.setAwardTitle(awardTitleEditText.getText().toString());
                        awardClass.setAwardText(awardTextEditText.getText().toString());
                        awardClass.setAwardDate(dateFormat(CALENDAR_FORMAT));
                        awardClass.setAwardFrom(awardNameEditText.getText().toString());
                        ((CardMakeingPageActivity) getActivity()).replaceFragment(AwardMakeingPageFragment.AwardMakeiangPageInstance());
                    }
                    break;
            }
        }
    };


    TextWatcher awardWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(awardTitleEditText.getText().toString().length() > 0 &&  awardTextEditText.getText().toString().length()>0 &&  awardNameEditText.getText().toString().length() > 0){
                nextButtonActivation();
            }else{
                nextButtonDeactivation();
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    public void nextButtonDeactivation(){
        nextButtonTextView.setBackgroundResource(R.drawable.rectangle_resource_perimeter_deactivation);
        nextButtonTextView.setTextColor(Color.parseColor("#98A2B3"));
    }
    public void nextButtonActivation(){
        nextButtonTextView.setBackgroundResource(R.drawable.rectangle_resource_perimeter_activation);
        nextButtonTextView.setTextColor(Color.parseColor("#585062"));
    }
    // dateFormat
    public String dateFormat(String pattern) {
        Date date = new Date();
        return new SimpleDateFormat(pattern).format(date);
    }
    private void hideKeyboard()
    {
        if (getActivity() != null && getActivity().getCurrentFocus() != null)
        {
            // 프래그먼트기 때문에 getActivity() 사용
            InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}