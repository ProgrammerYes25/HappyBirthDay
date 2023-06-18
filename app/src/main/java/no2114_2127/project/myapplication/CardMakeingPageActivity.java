package no2114_2127.project.myapplication;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CardMakeingPageActivity extends AppCompatActivity {
    public Context context = this;
    // image View
    ImageView backButtonImageView;
    LayoutInflater inflater;
    // TextView
    TextView cerdMakeSubtitleTextView, cerdMakeTitleTextView;
    // Fragment
    Fragment CakeMakeingPageFragment,
            PolaroidMakeingPageFragment,
            VideoUploadingFragment,
            AwardMakeingWritingPageFragment;

    // rollingPaper를 보여주기 위한 셋팅
    static LinearLayout rollingPaperLayout;
    static LayoutInflater inflater1;
    static EditText rollingPaperContent, rollingPaperFrom;
    static LinearLayout.LayoutParams params;
    static ImageView rollingPaperIcon, rollingPaperFrame;
    static TextView rollingPaperNextTextView, rollingPaperPreviousTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cerd_makeing_page);
        backButtonImageView = findViewById(R.id.back_button_image_view);
        backButtonImageView.setOnClickListener(onClickListener);
        CakeMakeingPageFragment = new CakeMakeingPageFragment();
        PolaroidMakeingPageFragment = new PolaroidMakeingPageFragment();
        VideoUploadingFragment = new VideoUploadingFragment();
        AwardMakeingWritingPageFragment = new AwardMakeingWritingPageFragment();

        //textView 정의
        cerdMakeTitleTextView = findViewById(R.id.cerd_make_title_text_view);
        cerdMakeSubtitleTextView = findViewById(R.id.cerd_make_subtitle_text_view);

        // rollingPaper를 보여주기 위한 셋팅
        inflater1 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rollingPaperLayout = (LinearLayout) inflater1.inflate(R.layout.rolling_paper_frames_bottom_sheet, null);
        rollingPaperLayout.setBackgroundColor(Color.parseColor("#99000000"));
        params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);

        //fragment 교체를 위한 switch문
        switch (VariableClass.stage){
            case 0:
                //케이크
                cerdMakeTitleTextView.setText("케이크를 꾸며요!");
                cerdMakeSubtitleTextView.setText("꾸밀 재료를 선택한 후, 편지를 작성합니다");
                cakeView();
                break;
            case 1:
                //폴라로이드
                cerdMakeTitleTextView.setText("폴라로이드 사진을 만들어요!");
                cerdMakeSubtitleTextView.setText("폴라로이드 색상, 사진을 선택한 후 제목을 붙여요.");
                polaroidView();
                break;
            case 2:
                //동영상
                cerdMakeTitleTextView.setText("소중한 추억을 공유해요!");
                cerdMakeSubtitleTextView.setText("친구와 함께했던 영상을 업로드 해보세요");
                videoView();
                break;
            case 3:
                //상장
                cerdMakeTitleTextView.setText("친구를 위한 상장을 만들어요!");
                cerdMakeSubtitleTextView.setText("특별한 상장을 만들어보세요");
                awardView();
                break;
        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(CardMakeingPageActivity.this, CardMakePageActivity.class);
            switch (view.getId()){
                case R.id.rolling_paper_next_button_text_view:
                    VariableClass.stage = 1;   //완료시 폴라로이드 페이지 넘어가기 위한 코드
                case R.id.back_button_image_view:
                    finish();
                    startActivity(intent);
                    break;
                case R.id.rolling_paper_previous_button_text_view:
                    rollingPaperLayout.setVisibility(View.GONE);
                    break;
            }
        }
    };


    private void cakeView(){
        getSupportFragmentManager().beginTransaction().add(R.id.cerd_make_frame_layout, CakeMakeingPageFragment).commitAllowingStateLoss();
        // rollingPaper를 보여주기 위한 셋팅
        addContentView(rollingPaperLayout, params);
        rollingPaperLayout.setVisibility(View.GONE);   //처음에는 없애둔다
        // rollingPaperLayout textView 설정
        rollingPaperNextTextView = rollingPaperLayout.findViewById(R.id.rolling_paper_next_button_text_view);
        rollingPaperPreviousTextView = rollingPaperLayout.findViewById(R.id.rolling_paper_previous_button_text_view);
        rollingPaperNextTextView.setOnClickListener(onClickListener);
        rollingPaperPreviousTextView.setOnClickListener(onClickListener);
        // rollingPaperIcon EditText 설정
        rollingPaperIcon = rollingPaperLayout.findViewById(R.id.rolling_paper_icon);
        // rollingPaperLayout EditText 설정
        rollingPaperContent = (EditText) rollingPaperLayout.findViewById(R.id.rolling_paper_content);
        rollingPaperFrom = (EditText) rollingPaperLayout.findViewById(R.id.rolling_paper_from);
        rollingPaperFrame = rollingPaperLayout.findViewById(R.id.rolling_paper_frame);
    }

    public static void rollingPaperSheet(){
        //rollingPapaerLinearLayout.setVisibility(View.VISIBLE);
        rollingPaperLayout.setVisibility(View.VISIBLE);//필요할때 다시 보여주는코드


    }

    private void polaroidView() {
        getSupportFragmentManager().beginTransaction().add(R.id.cerd_make_frame_layout, PolaroidMakeingPageFragment).commitAllowingStateLoss();

    }

    private void videoView() {
        getSupportFragmentManager().beginTransaction().add(R.id.cerd_make_frame_layout, VideoUploadingFragment).commitAllowingStateLoss();
    }
    private void awardView() {
        getSupportFragmentManager().beginTransaction().add(R.id.cerd_make_frame_layout, AwardMakeingWritingPageFragment).commitAllowingStateLoss();

    }

    public void replaceFragment(Fragment fragment) {
        //fragment 바꾸는 메소드
        getSupportFragmentManager().beginTransaction().replace(R.id.cerd_make_frame_layout, fragment).commitAllowingStateLoss();
    }


}