package no2114_2127.project.myapplication;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    FragmentManager manager;
    FragmentTransaction ft;

    DecoFragment decoFragment;
    MycardFragment mycardFragment;
    private FirebaseAuth mAuth; //FirevaseAuth 객체 선언
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        manager = getSupportFragmentManager();
        TextView decoToggle = findViewById(R.id.toggle_tv_deco);
        TextView mycardToggle = findViewById(R.id.toggle_tv_mycard);
        decoFragment = new DecoFragment();
        mycardFragment=new  MycardFragment();

        ft = manager.beginTransaction();
        ft.add(R.id.fragment_container, decoFragment);
        ft.addToBackStack(null);
        ft.commit();

        decoToggle.setOnClickListener(onClickListener);
        mycardToggle.setOnClickListener(onClickListener);




        //Y-초기커밋~~~!!ㅣㅐㅣㅡ
        //C-테스트커밋!!

        ImageView settingButton = findViewById(R.id.btn_setting);
        settingButton.setOnClickListener(onClickListener);


        mAuth = FirebaseAuth.getInstance(); //FirevaseAuth 객체 정의
        FirebaseUser currentUser = mAuth.getCurrentUser();
//        if(currentUser == null){    //로그인이 되어있지 않은면 SignUpActivity를 실행 시킴
//            startActivityM(LoginActivity.class);
//        }
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ft = manager.beginTransaction();
            TextView decoToggle = findViewById(R.id.toggle_tv_deco);
            TextView mycardToggle = findViewById(R.id.toggle_tv_mycard);

            int id = v.getId();
            switch (id) {
                case R.id.toggle_tv_deco:
                    decoToggle.setTextColor(getResources().getColor(R.color.white));
                    mycardToggle.setTextColor(getResources().getColor(R.color.unselected_text_color));
                    mycardToggle.setBackground(null);
                    decoToggle.setBackground(getResources().getDrawable(R.drawable.rectangle_resource_activation_toggle2));
                    ft.replace(R.id.fragment_container, decoFragment).commitAllowingStateLoss();
                    Log.d("확인 : "," R.id.toggle_tv_deco");
                    break;
                case R.id.toggle_tv_mycard:
                    mycardToggle.setTextColor(getResources().getColor(R.color.white));
                    decoToggle.setTextColor(getResources().getColor(R.color.unselected_text_color));
                    decoToggle.setBackground(null);
                    mycardToggle.setBackground(getResources().getDrawable(R.drawable.rectangle_resource_activation_toggle));
                    ft.replace(R.id.fragment_container, mycardFragment).commitAllowingStateLoss();
                    Log.d("확인 : "," R.id.toggle_tv_mycard");

                    break;
                case R.id.btn_setting:
                    Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                    startActivity(intent);
                    break;
            }
        }
    };


    private void startActivityM(Class activityClass){ //activity전환 메소드
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }



}
