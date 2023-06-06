package no2114_2127.project.myapplication;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth; //FirevaseAuth 객체 선언
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView toggleDeco=findViewById(R.id.toggle_tv_deco);
        //Y-초기커밋~~~!!
        //C-테스트커밋!!


        mAuth = FirebaseAuth.getInstance(); //FirevaseAuth 객체 정의
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if(currentUser == null){    //로그인이 되어있지 않은면 SignUpActivity를 실행 시킴
            startActivityM(LoginActivity.class);
        }
    }
    private void startActivityM(Class activityClass){ //activity전환 메소드
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}