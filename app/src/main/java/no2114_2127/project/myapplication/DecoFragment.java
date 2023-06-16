package no2114_2127.project.myapplication;

import android.app.Dialog;
import android.content.ClipData;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class DecoFragment extends Fragment {
    private GridView DecoGridView;
    Dialog addLink;
//    TextView noBtn;
//    TextView yesBtn;
    EditText inputLink;
    TextView cardName;
    TextView nameBirth;
    String inputText;


    private CustomAdapter MainDecoGridAdapter;
    TextView noBtn;
    TextView yesBtn;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_deco, container, false);
        View view2 = inflater.inflate(R.layout.dialog_input_link, container, false);
        View view3 = inflater.inflate(R.layout.main_grid_shortcut, container, false);
        DecoGridView=view.findViewById(R.id.main_deco_grid);
        cardName=view3.findViewById(R.id.tv_nickname);
        nameBirth=view3.findViewById(R.id.tv_name_birthday);
        addLink = new Dialog(getActivity());       // Dialog 초기화
        addLink.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        addLink.setContentView(R.layout.dialog_input_link);             // xml 레이아웃 파일과 연결
        MainDecoGridAdapter = new CustomAdapter(requireContext(), getData());
        inputLink=view2.findViewById(R.id.put_text);
        noBtn = addLink.findViewById(R.id.btn_cancel);
        yesBtn = addLink.findViewById(R.id.btn_add);
        inputText = inputLink.getText().toString();
        view.findViewById(R.id.link_add_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAddLink(); // 아래 showDialog01() 함수 호출
            }
        });
        MainDecoGridAdapter = new CustomAdapter(requireContext(),getData());

        // 어댑터를 GridView에 설정
        DecoGridView.setAdapter(MainDecoGridAdapter);

        return view;
    }
    private List<MainDecoListItem> getData() {
        List<MainDecoListItem> data = new ArrayList<>();

        return data;
    }
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
                if (inputText.isEmpty()) {
                    // 입력된 텍스트가 비어 있는 경우
                    yesBtn.setEnabled(false); // 추가 버튼 비활성화
                    // yesBtn.setBackground(null);
                    yesBtn.setBackground(getResources().getDrawable(R.drawable.rectangle_resource_activation_radadd_enabled));
                } else {
                    // 입력된 텍스트가 있는 경우
                    yesBtn.setEnabled(true); // 추가 버튼 활성화
                    //yesBtn.setBackground(null);
                    yesBtn.setBackground(getResources().getDrawable(R.drawable.rectangle_resource_activation_radadd));
                    MainDecoGridAdapter.addItem(new MainDecoListItem(cardName, nameBirth));
                    MainDecoGridAdapter.notifyDataSetChanged();
                    addLink.dismiss();

                }

                    //inputLink.setError("입력이 필요합니다.");


//                        MainDecoGridAdapter.addItem(new MainDecoListItem(cardName,nameBirth));
//                        MainDecoGridAdapter.notifyDataSetChanged();
//                        addLink.dismiss();
                    //}
                }
    });
//        inputLink.addTextChangedListener(new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
//            }
//
//            @Override
//            public void afterTextChanged(Editable editable) {
//                if (editable.toString().isEmpty()) {
//                    // 입력된 텍스트가 비어 있는 경우
//                    yesBtn.setEnabled(false); // 추가 버튼 비활성화
//                    // yesBtn.setBackground(null);
//                    yesBtn.setBackground(getResources().getDrawable(R.drawable.rectangle_resource_activation_radadd_enabled));
//                } else {
//                    // 입력된 텍스트가 있는 경우
//                    yesBtn.setEnabled(true); // 추가 버튼 활성화
//                    //yesBtn.setBackground(null);
//                    yesBtn.setBackground(getResources().getDrawable(R.drawable.rectangle_resource_activation_radadd));
//                }
//            }
//        });
    }

}







