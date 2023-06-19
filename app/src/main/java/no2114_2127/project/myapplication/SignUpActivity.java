package no2114_2127.project.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignUpActivity extends AppCompatActivity {
    private static final String TAG  = "signUpActivity";
    private FirebaseAuth mAuth; //FirevaseAuth 객체 선언
    // editText 선언
    EditText  nameEditText, emailEditText,
            passEditText, passCheckEditText,
            yearEditText, monthEditText, dayEditText;
    // textView 선언
    TextView signUpButtonTextView, bakeTextView;
    ImageView passwordCheckIcon;
    LinearLayout signUpLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        // editText findViewById
        nameEditText = findViewById(R.id.name_edit_text);
        emailEditText = findViewById(R.id.email_edit_text);
        passEditText = findViewById(R.id.pass_edit_text);
        passCheckEditText = findViewById(R.id.pass_check_edit_text);
        yearEditText = findViewById(R.id.year_edit_text);
        monthEditText = findViewById(R.id.month_edit_text);
        dayEditText = findViewById(R.id.day_edit_text);
        signUpButtonTextView = findViewById(R.id.sign_up_button_text_view);
        bakeTextView = findViewById(R.id.bake_text_view);
        signUpButtonTextView.setOnClickListener(onClickListener);
        bakeTextView.setOnClickListener(onClickListener);
        passCheckEditText.addTextChangedListener(passCheckWatcher);
        passwordCheckIcon = findViewById(R.id.password_check_icon);
        signUpLayout = findViewById(R.id.sign_up_layout);
        signUpLayout.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                hideKeyboard();
                return false;
            }
        });
        mAuth = FirebaseAuth.getInstance();
    }

    TextWatcher passCheckWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            if(s.toString().equals(passEditText.getText().toString())){
                passwordCheckIcon.setImageResource(R.drawable.password_check_icon);
            }
        }
    };


    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.sign_up_button_text_view:
                    signUP();
                    break;
                case R.id.bake_text_view:
                    finish();
                    break;
            }
        }
    };


    private void signUP(){
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String password = passEditText.getText().toString();
        String passwordCheck = passCheckEditText.getText().toString();
        String year = yearEditText.getText().toString();
        String month = monthEditText.getText().toString();
        String day = dayEditText.getText().toString();
        if(email.length()>0 && password.length()>0){//비밀번호와 이메일 비어있는 지 확인
            if(password.equals(passwordCheck)){//비밀번호와 비밀번호확인이 일치하는지 확인

                //회원 가입
                // FirevaseAuth에 있는 createUserWithEmailAndPassword는 파이어 베이스에서 회원 가입 할때 사용
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                            //통신 하고 나서 무슨일을 할지
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // 로그인 성공시
                                    Log.d(TAG, "createUserWithEmail:success");
                                    showToast("회원가입에 성공하였습니다.");
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
                                    MemberClass memberClass = new MemberClass(name, email, password, year+"/"+month+"/"+day+"/");
                                    firebaseFirestore.collection("users").document(user.getUid()).set(memberClass);
                                    startLoginActivity();
                                } else {
                                    // 로그인 실패시
                                    Log.w(TAG, "createUserWithEmail:failure", task.getException());
                                    showToast("회원가입에 실패 하였습니다.\n    다시 확인해주세요.");
                                }
                            }
                        });

            }
            else{
                showToast("비밀번호가 일치하지 않습니다.\n   다시 확인해주세요.");
            }
        }
        else {
            showToast("이메일 또는 비밀번호를 입력해주세요.");
        }
    }

    private void showToast(String msg) {//토스트 보여주는 메소드
        Toast.makeText(this, msg,Toast.LENGTH_SHORT).show();
    }
    private void startLoginActivity(){
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
    void hideKeyboard()
    {
        if(getApplicationContext().getResources().getConfiguration().hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO) {
            InputMethodManager inputManager = (InputMethodManager) this.getSystemService(Context.INPUT_METHOD_SERVICE);
            inputManager.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}