package no2114_2127.project.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.net.DatagramPacket;
import java.util.Map;

public class SettingActivity extends AppCompatActivity {
    int nChecked = 0;
    Dialog dialog01;
    TextView logoutButtonTextView;

    //EeitText 선언
    EditText userNameEditText, userIdEditText, userDateEditText;
    FirebaseUser user;
    FirebaseFirestore firebaseFirestore;
    String userUid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

//        dialog01 = new Dialog(SettingActivity.this);
//        dialog01.setContentView(R.layout.dialog_setting);

        logoutButtonTextView = findViewById(R.id.logout_button_text_view);
        logoutButtonTextView.setOnClickListener(onClickListener);

        //EeitText findViewById
        userNameEditText = findViewById(R.id.user_name_edit_text);
        userIdEditText = findViewById(R.id.user_id_edit_text);
        userDateEditText = findViewById(R.id.user_date_edit_text);

        // firebase 정보 빼오기
        user = FirebaseAuth.getInstance().getCurrentUser();
        userUid = user.getUid();
        firebaseFirestore = FirebaseFirestore.getInstance();

        firebaseFirestore.collection("users")
                .document(userUid)
                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                        Map<String, Object> data =  task.getResult().getData();
                        String name = (String) data.get("name");
                        String date = (String) data.get("birthDay");
                        String email = (String) data.get("email");
                        userNameEditText.setText(name);
                        userIdEditText.setText(email);
                        userDateEditText.setText(date);
                    }
                });

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
                    Toast.makeText(getApplicationContext(), "알림 설정이 켜졌습니다.", Toast.LENGTH_SHORT).show();
                } else {
                    // switchButton이 체크되지 않은 경우
                    nChecked = 0;
                    Toast.makeText(getApplicationContext(), "알림 설정이 꺼졌습니다.", Toast.LENGTH_SHORT).show();
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