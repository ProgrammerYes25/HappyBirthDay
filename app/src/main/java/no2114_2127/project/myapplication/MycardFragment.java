package no2114_2127.project.myapplication;

import android.app.Dialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


public class MycardFragment extends Fragment {
    private GridView MycardGridView;
    Dialog addCard;
    TextView cardName;
    TextView nameBirth;
    TextView cardName2;
    TextView nameBirth2;
    private CustomAdapter MainMycardGridAdapter;
    private RecyclerView mRecyclerView;
    private RecyclerView mRecyclerView2;
    private ArrayList<MainMycardRecyclerViewItem> mList;
    private ArrayList<MainMycardRecyclerViewItem> mList2;
    private MainMycardRecyclerViewAdapter mRecyclerViewAdapter;
    private MainMycardRecyclerViewAdapter mRecyclerViewAdapter2; //congrate

    FirebaseFirestore db ;
    FirebaseUser firebaseUser;
    CollectionReference collectionRef, userCardColl;
    String userUid;
    CardDataClass cardDataClass;
    RecyclerView thisYear;
    RecyclerView congrate;
    //    TextView cardName;
//    TextView nameBirth;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mycard, container, false);
        firstInit();
//        thisYear=view.findViewById(R.id.this_year_recyclerView);
//        congrate=view.findViewById(R.id.my_congratulatory_record_recyclerView);

        mRecyclerView = view.findViewById(R.id.this_year_recyclerView);
//        cardName=view3.findViewById(R.id.tv_nickname);
//        nameBirth=view3.findViewById(R.id.tv_name_birthday);
        mRecyclerViewAdapter = new MainMycardRecyclerViewAdapter(mList);
        mRecyclerView.addItemDecoration(new RecyclerViewDecoration(60));

        //축하 기록 recyclerView
        mRecyclerView2 = view.findViewById(R.id.my_congratulatory_record_recyclerView);
//        cardName=view3.findViewById(R.id.tv_nickname);
//        nameBirth=view3.findViewById(R.id.tv_name_birthday);
        mRecyclerViewAdapter2 = new MainMycardRecyclerViewAdapter(mList2);
        mRecyclerView2.addItemDecoration(new RecyclerViewDecoration(60)); //간격 조정
        mRecyclerViewAdapter2.addItem( new MainMycardRecyclerViewItem(nameBirth2,cardName2));
        mRecyclerView2.setAdapter(mRecyclerViewAdapter2);
        //  mRecyclerView2.setAdapter(mRecyclerViewAdapter);
        mRecyclerView2.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false));
        //recyclerView 가로로 생기게 설정
        // mRecyclerView2.setLayoutManager(new LinearLayoutManager(requireContext(), RecyclerView.HORIZONTAL, false));


        addCard = new Dialog(getActivity());       // Dialog 초기화
        addCard.requestWindowFeature(Window.FEATURE_NO_TITLE); // 타이틀 제거
        addCard.setContentView(R.layout.dialog_input_card_name);             // xml 레이아웃 파일과 연결

        View view2 = inflater.inflate(R.layout.dialog_input_card_name, container, false);
        View view3 = inflater.inflate(R.layout.main_grid_shortcut, container, false);
        cardName=view3.findViewById(R.id.tv_nickname);
        nameBirth=view3.findViewById(R.id.tv_name_birthday);

//	파이어베이스
        db = FirebaseFirestore.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        userUid = firebaseUser.getUid();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        userCardColl = db.collection("users").document(firebaseUser.getUid()).collection("userCard");


        cardName2=view3.findViewById(R.id.tv_nickname);
        nameBirth2=view3.findViewById(R.id.tv_name_birthday);

        view.findViewById(R.id.card_add_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                showAddCard(); // 아래 showDialog01() 함수 호출
            }
        });

        return view;
    }


    private List<MainDecoListItem> getData() {
        List<MainDecoListItem> data = new ArrayList<>();

        return data;
    }

    public void firstInit(){

        mList = new ArrayList<>();
        mList2 = new ArrayList<>();
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
        EditText inputCard=addCard.findViewById(R.id.put_text);
        TextView noBtn = addCard.findViewById(R.id.btn_cancel);
        TextView yesBtn = addCard.findViewById(R.id.btn_save);
        // 취소 버튼
        inputCard.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.length()<=0) {
                    Log.d("확인", "onTextChanged: ");
                    // 추가 버튼 비활성화
                    yesBtn.setClickable(false);
                    yesBtn.setBackground(null);
                    yesBtn.setBackgroundResource(R.drawable.rectangle_resource_activation_radadd_enabled);

                } else {
                    Log.d("확인2", "onTextChanged: ");
                    yesBtn.setClickable(true);
                    yesBtn.setBackground(null);
                    yesBtn.setBackgroundResource(R.drawable.rectangle_resource_activation_radadd);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
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
                String inputText = inputCard.getText().toString();
                Log.d("input 확인", inputText);// 가져온 링크
                if (inputText.length()>0) {
                    Log.d("확인", "onTextChanged: ");


                    db.collection("users")
                            .document(userUid)
                            .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                    Log.d("input 확인", inputText);
                                    Map<String, Object> data =  task.getResult().getData();
                                    cardDataClass = new CardDataClass((String) data.get("name"), inputText, (String) data.get("birthDay"), (String) data.get("email"));
                                    db.collection("cards").document().set(cardDataClass);
                                }
                            });

                    //Log.d("확인", cardDataClass.getClass()+"!!!!!!!!!!!!!!!!!!!!!!!");
                    collectionRef = db.collection("users").document(firebaseUser.getUid()).collection("userCard");
                    collectionRef.whereEqualTo("fieldName", inputText)
                            .get()
                            .addOnCompleteListener(task -> {
                                if (task.isSuccessful()) {
                                    QuerySnapshot querySnapshot = task.getResult();

                                    // 겹치는 값이 없는 경우 값을 삽입
                                    Map<String, Object> data = new HashMap<>();
                                    data.put("fieldName", inputText);
                                    collectionRef.document().set(data);

                                } else {
                                    // 조회 실패 처리 로직을 수행
                                }
                            });
                    addCard.dismiss();

                }
            }
        });

    }

}
