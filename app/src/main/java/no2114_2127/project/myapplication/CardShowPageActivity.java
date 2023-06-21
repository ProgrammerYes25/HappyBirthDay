package no2114_2127.project.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

public class CardShowPageActivity extends AppCompatActivity {

    Fragment cardShowPageFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_show_page);
        cardShowPageFragment = new CardShowPageFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.card_show_frame_layout, cardShowPageFragment).commitAllowingStateLoss();

    }
}