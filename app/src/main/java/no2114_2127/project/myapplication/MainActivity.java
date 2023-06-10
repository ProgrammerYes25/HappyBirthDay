package no2114_2127.project.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    Dialog addLink;
    private FirebaseAuth mAuth; //FirevaseAuth 객체 선언
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addLink = new Dialog(MainActivity.this);       // Dialog 초기화
        addLink.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        addLink.setContentView(R.layout.dialog_input_link);             // xml 레이아웃 파일과 연결
        findViewById(R.id.main_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddLink(); // 아래 showDialog01() 함수 호출
            }
        });

        TextView toggleDeco=findViewById(R.id.toggle_tv_deco);
        //Y-초기커밋~~~!!ㅣㅐㅣㅡ
        //C-테스트커밋!!

        ImageView settingButton = findViewById(R.id.btn_setting);
        settingButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
            }
        });


        mAuth = FirebaseAuth.getInstance(); //FirevaseAuth 객체 정의
        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if(currentUser == null){    //로그인이 되어있지 않은면 SignUpActivity를 실행 시킴
//            startActivityM(LoginActivity.class);
//        }
    }
    private void startActivityM(Class activityClass){ //activity전환 메소드
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }

    // dialog01을 디자인하는 함수
    public void showAddLink(){
        addLink.show(); // 다이얼로그 띄우기
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            Objects.requireNonNull(addLink.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        /* 이 함수 안에 원하는 디자인과 기능을 구현하면 된다. */

        // 위젯 연결 방식은 각자 취향대로~
        // '아래 아니오 버튼'처럼 일반적인 방법대로 연결하면 재사용에 용이하고,
        // '아래 네 버튼'처럼 바로 연결하면 일회성으로 사용하기 편함.
        // *주의할 점: findViewById()를 쓸 때는 -> 앞에 반드시 다이얼로그 이름을 붙여야 한다.

        // 취소 버튼
        TextView noBtn = addLink.findViewById(R.id.btn_cancel);
        TextView yesBtn = addLink.findViewById(R.id.btn_add);
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 원하는 기능 구현
                addLink.dismiss(); // 다이얼로그 닫기
            }
        });
        //추가 버튼
        yesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 원하는 기능 구현

            }
        });
    }
}
