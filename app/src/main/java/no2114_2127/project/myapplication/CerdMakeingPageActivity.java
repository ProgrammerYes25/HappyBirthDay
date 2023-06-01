package no2114_2127.project.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.SearchManager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CerdMakeingPageActivity extends AppCompatActivity {
    // image View
    ImageView backButtonImageView;


    Fragment CakeMakeingPageFragment, CakeMakeWritingPageFragment,
            PolaroidMakeingPageFragment,
            VideoUploadingPragment,
            AwardMakeChooseFragment, AwardMakeChooseFormFragment, AwardMakeWritingPageFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerd_makeing_page);
        backButtonImageView = findViewById(R.id.back_button_image_view);
        backButtonImageView.setOnClickListener(onClickListener);
        CakeMakeingPageFragment = new CakeMakeingPageFragment();

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
    }
}