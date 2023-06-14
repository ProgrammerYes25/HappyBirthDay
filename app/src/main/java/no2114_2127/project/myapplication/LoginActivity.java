package no2114_2127.project.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    // editText 선언
    EditText idEditText, passEditText;
    // textView 선언
    TextView loginButtonTextView, loginSignupButtonTextView;

    private FirebaseAuth mAuth; //FirevaseAuth 객체 선언
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // editText findViewById
        idEditText = findViewById(R.id.id_edit_text);
        passEditText = findViewById(R.id.pass_edit_text);

        // editText findViewById
        loginButtonTextView = findViewById(R.id.login_button_text_view);
        loginSignupButtonTextView = findViewById(R.id.login_signup_button_text_view);
        loginButtonTextView.setOnClickListener(onClickListener);
        loginSignupButtonTextView.setOnClickListener(onClickListener);

        mAuth = FirebaseAuth.getInstance(); //FirevaseAuth 객체 정의
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.login_button_text_view:
                    login();
                    break;
                case R.id.login_signup_button_text_view:
                    signUP();
                    break;
            }
        }
    };
    private void signUP(){
        startActivityM(SignUpActivity.class);
    }
    private void login(){
        String email = idEditText.getText().toString();
        String password = passEditText.getText().toString();
        if(email.length()>0 && password.length()>0){//비밀번호와 이메일 비어있는 지 확인
            // 로그인
            // FirevaseAuth에 있는 signInUserWithEmailAndPassword는 파이어 베이스에서 로그인 할때 사용
            mAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        //통신 하고 나서 무슨일을 할지
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // 로그인 성공시
                                showToast("로그인에 성공 하셨습니다.");
                                FirebaseUser user = mAuth.getCurrentUser();
                                startActivityM(MainActivity.class);
                            } else {
                                // 로그인 실패시
                                showToast("이메일 또는 비밀번호를 다시 확인해주세요.");
                            }
                        }
                    });
        }
        else {
            showToast("이메일 또는 비밀번호를 입력해주세요.");
        }

    }
    private void startActivityM(Class ActivityClass){//activity전환 메소드
        Intent intent = new Intent(this, ActivityClass);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
    private void showToast(String msg) {    //토스트 보여주는 메소드
        Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();
    }
}