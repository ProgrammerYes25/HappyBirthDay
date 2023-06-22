package no2114_2127.project.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

public class CardShowPageActivity extends AppCompatActivity {

    ImageView cancelButtonImageView;
    Fragment cardShowPageFragment;

    static LinearLayout rollingPaperShowLayout;
    static LayoutInflater inflaterShow1;

    static LinearLayout.LayoutParams paramsShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_show_page);
        inflaterShow1 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rollingPaperShowLayout = (LinearLayout) inflaterShow1.inflate(R.layout.rolling_paper_frames_bottom_sheet, null);
        rollingPaperShowLayout.setBackgroundColor(Color.parseColor("#99000000"));
        paramsShow = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
        cancelButtonImageView = findViewById(R.id.cancel_button_imate_view);
        cancelButtonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        cardShowPageFragment = new CardShowPageFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.card_show_frame_layout, cardShowPageFragment).commitAllowingStateLoss();
        addContentView(rollingPaperShowLayout, paramsShow);
        rollingPaperShowLayout.setVisibility(View.GONE);   //처음에는 없애둔다
    }
}