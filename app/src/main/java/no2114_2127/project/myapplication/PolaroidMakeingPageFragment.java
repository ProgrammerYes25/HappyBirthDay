package no2114_2127.project.myapplication;

import static android.app.Activity.RESULT_OK;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
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

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PolaroidMakeingPageFragment extends Fragment {
    //text View 선언
    TextView polaroidButtonTextView;

    // image view 선언
    ImageView polaroidImageView, polaroidFrame1, polaroidFrame2, polaroidFrame3,
            polaroidFrame4, polaroidFrame5, polaroidFrame6,
            polaroidFrame7, polaroidFrame8, polaroidFrame9;
    // editText
    EditText polaroidEditText;

    RelativeLayout polaroidMakeingLayout;
    // polaroid frame item 배열
    int polaroidFrame[] = {R.drawable.polaroid_frame_1, R.drawable.polaroid_frame_2, R.drawable.polaroid_frame_3,
            R.drawable.polaroid_frame_4, R.drawable.polaroid_frame_5,R.drawable.polaroid_frame_6,
            R.drawable.polaroid_frame_7, R.drawable.polaroid_frame_8, R.drawable.polaroid_frame_9 };
    int polaroidFrameItem[] = {R.drawable.polaroid_frame_item_1, R.drawable.polaroid_frame_item_2, R.drawable.polaroid_frame_item_3,
            R.drawable.polaroid_frame_item_4, R.drawable.polaroid_frame_item_5, R.drawable.polaroid_frame_item_6,
            R.drawable.polaroid_frame_item_7, R.drawable.polaroid_frame_item_8, R.drawable.polaroid_frame_item_9};
    // polaroid frame on item 배열
    int polaroidFrameOnItem[] = {R.drawable.polaroid_frame_on_item_1, R.drawable.polaroid_frame_on_item_2, R.drawable.polaroid_frame_on_item_3,
            R.drawable.polaroid_frame_on_item_4, R.drawable.polaroid_frame_on_item_5, R.drawable.polaroid_frame_on_item_6,
            R.drawable.polaroid_frame_on_item_7, R.drawable.polaroid_frame_on_item_8, R.drawable.polaroid_frame_on_item_9};
    ImageView choiceImageView, polaroidPhotoImageView;
    int choiceindex = 0;

    private Uri uri =null;

    Context mContext = getActivity();
    private static final int REQUEST_IMAGE_CODE = 101;
    Bitmap bitmap;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_polaroid_makeing_page, container, false);
        // image view find View by id
        polaroidPhotoImageView = view.findViewById(R.id.polaroid_photo_image_view);
        polaroidFrame1 = view.findViewById(R.id.polaroid_frame_1);
        polaroidFrame2 = view.findViewById(R.id.polaroid_frame_2);
        polaroidFrame3 = view.findViewById(R.id.polaroid_frame_3);
        polaroidFrame4 = view.findViewById(R.id.polaroid_frame_4);
        polaroidFrame5 = view.findViewById(R.id.polaroid_frame_5);
        polaroidFrame6 = view.findViewById(R.id.polaroid_frame_6);
        polaroidFrame7 = view.findViewById(R.id.polaroid_frame_7);
        polaroidFrame8 = view.findViewById(R.id.polaroid_frame_8);
        polaroidFrame9 = view.findViewById(R.id.polaroid_frame_9);
        polaroidImageView = view.findViewById(R.id.polaroid_image_view);
        // text view find View by id
        polaroidButtonTextView = view.findViewById(R.id.polaroid_button_text_view);
        polaroidButtonTextView.setOnClickListener(onClickListener);

        // EditText find View by id
        polaroidEditText = view.findViewById(R.id.polaroid_edit_text);
        polaroidEditText.addTextChangedListener(polaroidTextWatcher);
        // image view setOnClick
        polaroidPhotoImageView.setOnClickListener(onClickListener);
        polaroidFrame1.setOnClickListener(onClickListener);
        polaroidFrame2.setOnClickListener(onClickListener);
        polaroidFrame3.setOnClickListener(onClickListener);
        polaroidFrame4.setOnClickListener(onClickListener);
        polaroidFrame5.setOnClickListener(onClickListener);
        polaroidFrame6.setOnClickListener(onClickListener);
        polaroidFrame7.setOnClickListener(onClickListener);
        polaroidFrame8.setOnClickListener(onClickListener);
        polaroidFrame9.setOnClickListener(onClickListener);

        polaroidMakeingLayout = view.findViewById(R.id.polaroid_makeing_layout);
        polaroidMakeingLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideKeyboard();
                return false;
            }
        });

        choiceImageView = polaroidFrame1;
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
                case R.id.polaroid_frame_1:
                    changePolaroidFrame(0, polaroidFrame1);
                    break;
                case R.id.polaroid_frame_2:
                    changePolaroidFrame(1, polaroidFrame2);
                    break;
                case R.id.polaroid_frame_3:
                    changePolaroidFrame(2, polaroidFrame3);
                    break;
                case R.id.polaroid_frame_4:
                    changePolaroidFrame(3, polaroidFrame4);
                    break;
                case R.id.polaroid_frame_5:
                    changePolaroidFrame(4, polaroidFrame5);
                    break;
                case R.id.polaroid_frame_6:
                    changePolaroidFrame(5, polaroidFrame6);
                    break;
                case R.id.polaroid_frame_7:
                    changePolaroidFrame(6, polaroidFrame7);
                    break;
                case R.id.polaroid_frame_8:
                    changePolaroidFrame(7, polaroidFrame8);
                    break;
                case R.id.polaroid_frame_9:
                    changePolaroidFrame(8, polaroidFrame9);
                    break;
                case R.id.polaroid_photo_image_view:
                    takePicture();
//                    polaroidPhotoImageView.setImageBitmap(getBitmap());
//                    Intent intentImage = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
//                    intentImage.setType("image/*");
//                    launcher.launch(intentImage);
                    break;
            }


        }
    };

    TextWatcher polaroidTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if(polaroidEditText.getText().toString().length() > 0 && uri!=null){
                nextButtonActivation();
            }else{
                nextButtonDeactivation();
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
    };

    public void changePolaroidFrame(int index, ImageView polaroidFrameItemImageView){
        if(choiceindex!=index){
            polaroidImageView.setImageResource(polaroidFrame[index]);
            polaroidFrameItemImageView.setImageResource(polaroidFrameOnItem[index]);
            choiceImageView.setImageResource(polaroidFrameItem[choiceindex]);
            choiceImageView = polaroidFrameItemImageView;
            choiceindex = index;
        }
    }

    public void nextButtonDeactivation(){
        polaroidButtonTextView.setBackgroundResource(R.drawable.rectangle_resource_perimeter_deactivation);
        polaroidButtonTextView.setTextColor(Color.parseColor("#98A2B3"));
    }
    public void nextButtonActivation(){
        polaroidButtonTextView.setBackgroundResource(R.drawable.rectangle_resource_perimeter_activation);
        polaroidButtonTextView.setTextColor(Color.parseColor("#585062"));
    }


    private final ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == RESULT_OK && result.getData() != null) {
                        uri = result.getData().getData();
                        Log.d("test", uri.toString());
                        polaroidPhotoImageView.setImageURI(uri);
                        MediaClass.imageClass.setImageUri(uri);
                    }
                    if(uri!=null&& polaroidEditText.getText().toString().length() >0 ){
                        nextButtonActivation();
                    }
                    else {
                        nextButtonDeactivation();
                    }
                }
            });

    private void hideKeyboard()
    {
        if (getActivity() != null && getActivity().getCurrentFocus() != null)
        {
            // 프래그먼트기 때문에 getActivity() 사용
            InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    public void takePicture() {
        Intent imageTakeIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (imageTakeIntent.resolveActivity(requireActivity().getPackageManager()) != null) {
            startActivityForResult(imageTakeIntent, REQUEST_IMAGE_CODE);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("확인 ", "");
        if (requestCode == REQUEST_IMAGE_CODE && resultCode == Activity.RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            Log.d("확인 ", imageBitmap + "");
            polaroidPhotoImageView.setImageBitmap(imageBitmap);
        }
    }

}
