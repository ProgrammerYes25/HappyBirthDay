package no2114_2127.project.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class CardShowPageActivity extends AppCompatActivity {
    String CerdMakeTitle = "의 생일카드";

    int cerdMakeFrameLayoutId;
    //Layout
    FrameLayout cerdMakeFrameLayout;
    //TextView
    TextView cerdMakeSubtitleTextView;
    //ImageView
    ImageView backButtonImageView;
    Fragment CakeMakePageFragment, CakeMakeingPageFragment, CakeMakeWritingPageFragment,
            PolaroidMakePageFragment, PolaroidMakeingPageFragment,
            VideoUploadFragment, VideoUploadingPragment,
            AwardMakePageFragment, AwardMakeChooseFragment, AwardMakeChooseFormFragment, AwardMakeWritingPageFragment,
            FromFinishPageFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerd_show_page);
        cerdMakeFrameLayoutId = R.id.cerd_make_frame_layout;
        // Layout find View by id
        cerdMakeFrameLayout = findViewById(R.id.cerd_make_frame_layout);
        // textView find View by id
        // ImageView find View by id
        backButtonImageView = findViewById(R.id.back_button_image_view);

        // Fragent
        CakeMakePageFragment = new CakeMakePageFragment();
        PolaroidMakePageFragment = new PolaroidMakePageFragment();
        AwardMakePageFragment = new AwardMakePageFragment();
        VideoUploadFragment = new VideoUploadFragment();
        // setOnClick
        // backButtonImageView setOnClick
        backButtonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        getSupportFragmentManager().beginTransaction().add(R.id.cerd_make_frame_layout, CakeMakePageFragment).commitAllowingStateLoss();
    }
}