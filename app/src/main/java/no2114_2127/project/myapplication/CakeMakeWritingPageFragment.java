package no2114_2127.project.myapplication;

import static no2114_2127.project.myapplication.CerdClass.cakeClass;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class CakeMakeWritingPageFragment extends Fragment {
    //text view 선언
    TextView previousButtonTextView, nextButtonTextView, fromEditTextCaution;

    // edit text 선언
    EditText rollingPaperEditText, fromEditText;

    // Image view 선언
    ImageView decoImageView;
    RelativeLayout cakeMakeingLayout;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cake_make_writing_page, container, false);
        // text view find View by id
        previousButtonTextView = view.findViewById(R.id.previous_button_text_view);
        nextButtonTextView = view.findViewById(R.id.next_button_text_view);
        fromEditTextCaution = view.findViewById(R.id.from_edit_text_caution);

        // edit text find View by id
        rollingPaperEditText = view.findViewById(R.id.rolling_paper_edit_text);
        fromEditText = view.findViewById(R.id.from_edit_text);
        rollingPaperEditText.addTextChangedListener(rollingPaperTextWatcher);
        fromEditText.addTextChangedListener(fromTextWatcher);

        // Image view find View by id
        decoImageView = view.findViewById(R.id.deco_image_view);

        cakeMakeingLayout = view.findViewById(R.id.cake_makeing_layout);
        cakeMakeingLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideKeyboard();
                return false;
            }
        });


        // textView setOnClick
        previousButtonTextView.setOnClickListener(onClickListener);
        nextButtonTextView.setOnClickListener(onClickListener);

        // ImageView view
        decoImageView.setImageResource(cakeClass.getDecoImage());
        return view;
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    public static CakeMakeWritingPageFragment CakeMakeWritingPageInstance() {
        return new CakeMakeWritingPageFragment();
    }

    TextWatcher fromTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(s.length()>=6){
                fromEditTextCaution.setVisibility(View.VISIBLE);
                nextButtonDeactivation();
            }else{
                fromEditTextCaution.setVisibility(View.INVISIBLE);
                if(rollingPaperEditText.getText().toString().length() > 0 && s.length() > 0){
                    nextButtonActivation();
                }else{
                    nextButtonDeactivation();
                }
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    TextWatcher rollingPaperTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(fromEditText.getText().toString().length() > 0 && fromEditText.getText().toString().length()<=6 && s.length() > 0){
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

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.previous_button_text_view:
                    ((CerdMakeingPageActivity)getActivity()).replaceFragment(CakeMakeingPageFragment.CakeMakeingPageInstance());
                    break;
                case R.id.next_button_text_view:
                    if(fromEditText.getText().toString().length() > 0 && fromEditText.getText().toString().length()<=6 && rollingPaperEditText.getText().toString().length() > 0) {
                        //((CerdMakeingPageActivity)getActivity()).replaceFragment(CakeMakeWritingPageFragment.CakeMakeWritingPageInstance());
                        cakeClass.setRollingPaper(rollingPaperEditText.getText().toString());
                        cakeClass.setFrom(fromEditText.getText().toString());
                        Log.d("from 확인", cakeClass.getFrom());
                        CerdMakeingPageActivity.rollingPaperContent.setText(cakeClass.getRollingPaper());
                        CerdMakeingPageActivity.rollingPaperFrom.setText(cakeClass.getFrom());
                        CerdMakeingPageActivity.rollingPaperIcon.setImageResource(cakeClass.getDecoImage());
                        switch (cakeClass.getDecoImage()){
                            case R.drawable.cake_decorative_strawberrie: case  R.drawable.cake_decorative_flower: case  R.drawable.cake_decorative_cherry:
                                CerdMakeingPageActivity.rollingPaperFrame.setImageResource(R.drawable.rolling_paper_frame_1);
                                break;
                            case R.drawable.cake_decorative_gift: case R.drawable.cake_decorative_chocolate: case R.drawable.cake_decorative_heart:
                                CerdMakeingPageActivity.rollingPaperFrame.setImageResource(R.drawable.rolling_paper_frame_2);
                                break;
                            case R.drawable.cake_decorative_rabbit: case R.drawable.cake_decorative_chick: case R.drawable.cake_decorative_puppy:
                                CerdMakeingPageActivity.rollingPaperFrame.setImageResource(R.drawable.rolling_paper_frame_3);
                                break;
                            case R.drawable.cake_decorative_muffin: case  R.drawable.cake_decorative_donut: case  R.drawable.cake_decorative_balloon:
                                CerdMakeingPageActivity.rollingPaperFrame.setImageResource(R.drawable.rolling_paper_frame_4);
                                break;
                        }
                        ((CerdMakeingPageActivity) getActivity()).rollingPaperSheet();
                    }
                    break;
            }
        }
    };

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
