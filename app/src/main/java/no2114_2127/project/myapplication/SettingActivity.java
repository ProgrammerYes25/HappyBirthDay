package no2114_2127.project.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class SettingActivity extends AppCompatActivity {
    int nChecked = 0;
    Dialog dialog01;
    TextView logoutButtonTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

//        dialog01 = new Dialog(SettingActivity.this);
//        dialog01.setContentView(R.layout.dialog_setting);

        logoutButtonTextView = findViewById(R.id.logout_button_text_view);
        logoutButtonTextView.setOnClickListener(onClickListener);

        ImageView backButton = findViewById(R.id.btn_back);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

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
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.logout_button_text_view:
                    FirebaseAuth.getInstance().signOut();
                    startActivityM(LoginActivity.class);
                    break;
            }
        }
    };

    private void startActivityM(Class activityClass){ //activity전환 메소드
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}