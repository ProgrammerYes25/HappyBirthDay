package no2114_2127.project.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class CerdMakeingPageActivity extends AppCompatActivity {
    // image View
    ImageView backButtonImageView;
    LayoutInflater inflater;

    Fragment CakeMakeingPageFragment, CakeMakeWritingPageFragment,
            PolaroidMakeingPageFragment,
            VideoUploadingPragment,
            AwardMakeChooseFragment, AwardMakeChooseFormFragment, AwardMakeWritingPageFragment;

    static BottomSheetDialog bottomSheetDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerd_makeing_page);
        backButtonImageView = findViewById(R.id.back_button_image_view);
        backButtonImageView.setOnClickListener(onClickListener);
        CakeMakeingPageFragment = new CakeMakeingPageFragment();
        inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        switch (CerdMakePageActivity.stage){
            case 0:
                //케이크
                cakeView();
                break;
            case 1:
                //폴라로이드
                break;
            case 3:
                //동영상
                break;
            case 4:
                //상장
                break;
        }
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.back_button_image_view:
                    finish();
                    break;
            }
        }
    };

    private void cakeView(){
        getSupportFragmentManager().beginTransaction().add(R.id.cerd_make_frame_layout, CakeMakeingPageFragment).commitAllowingStateLoss();
        View view = inflater.inflate(R.layout.rolling_paper_frames_bottom_sheet, null, false);
        bottomSheetDialog = new BottomSheetDialog(CerdMakeingPageActivity.this);
        bottomSheetDialog.setContentView(view);
    }
    public static void rollingPaperSheet(){
        bottomSheetDialog.show();
    }

    public void replaceFragment(Fragment fragment) {
        //fragment 바꾸는 메소드
        getSupportFragmentManager().beginTransaction().replace(R.id.cerd_make_frame_layout, fragment).commitAllowingStateLoss();
    }
}