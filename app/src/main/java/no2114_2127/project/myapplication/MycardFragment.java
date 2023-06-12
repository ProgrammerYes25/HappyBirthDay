package no2114_2127.project.myapplication;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.GridView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class MycardFragment extends Fragment {
    private GridView MycardGridView;
    Dialog addCard;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mycard, container, false);
        MycardGridView = view.findViewById(R.id.main_mycard_grid);

        addCard = new Dialog(getActivity());       // Dialog 초기화
        addCard.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        addCard.setContentView(R.layout.dialog_input_card_name);             // xml 레이아웃 파일과 연결

        CustomAdapter MainMycardGridAdapter = new CustomAdapter(requireContext(), getData());

        view.findViewById(R.id.card_add_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddCard(); // 아래 showDialog01() 함수 호출
            }
        });

        // 어댑터를 GridView에 설정
        MycardGridView.setAdapter(MainMycardGridAdapter);

        return view;
    }
    private List<String> getData() {
        List<String> data = new ArrayList<>();

        return data;
    }
    public void showAddCard(){
        addCard.show(); // 다이얼로그 띄우기
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT){
            Objects.requireNonNull(addCard.getWindow()).setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        }
        /* 이 함수 안에 원하는 디자인과 기능을 구현하면 된다. */

        // 위젯 연결 방식은 각자 취향대로~
        // '아래 아니오 버튼'처럼 일반적인 방법대로 연결하면 재사용에 용이하고,
        // '아래 네 버튼'처럼 바로 연결하면 일회성으로 사용하기 편함.
        // *주의할 점: findViewById()를 쓸 때는 -> 앞에 반드시 다이얼로그 이름을 붙여야 한다.

        // 취소 버튼
        TextView noBtn = addCard.findViewById(R.id.btn_cancel);
        TextView yesBtn = addCard.findViewById(R.id.btn_add);
        noBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 원하는 기능 구현
                addCard.dismiss(); // 다이얼로그 닫기
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







