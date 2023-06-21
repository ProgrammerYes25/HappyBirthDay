package no2114_2127.project.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class CardShowPageActivity extends AppCompatActivity {

    ImageView cancelButtonImageView;
    Fragment cardShowPageFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_show_page);

        cancelButtonImageView = findViewById(R.id.cancel_button_imate_view);
        cancelButtonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        cardShowPageFragment = new CardShowPageFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.card_show_frame_layout, cardShowPageFragment).commitAllowingStateLoss();

    }
}