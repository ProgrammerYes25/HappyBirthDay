package no2114_2127.project.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;

public class SettingActivity extends AppCompatActivity {
    int nChecked = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        Switch switchButton = findViewById(R.id.setting_switch);
        switchButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    // switchButton이 체크된 경우
                    nChecked = 1;
                } else {
                    // switchButton이 체크되지 않은 경우
                    nChecked = 0;
                }
            }
        });
    }
}