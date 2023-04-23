package no2114_2127.project.myapplication;

import android.graphics.Paint;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView toggleDeco=findViewById(R.id.toggle_tv_deco);
        //Y-초기커밋~~~!!
        //C-테스트커밋!!
        toggleDeco.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG) ;
    }
}