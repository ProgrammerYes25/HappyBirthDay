package no2114_2127.project.myapplication;

import static no2114_2127.project.myapplication.CardMakeingPageActivity.rollingPaperLayout;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class CardShowPageActivity extends AppCompatActivity {

    ImageView cancelButtonImageView;
    Fragment cardShowPageFragment;
    String userUid;
    static EditText rollingPaperContent, rollingPaperFrom;

    static LinearLayout rollingPaperShowLayout;
    static LayoutInflater inflaterShow1;
    private FirebaseAuth mAuth;
    FirebaseFirestore firebaseFirestore;
    static LinearLayout.LayoutParams paramsShow;
    static TextView rollingPaperNextTextView, rollingPaperPreviousTextView;
    static ImageView rollingPaperIcon, rollingPaperFrame;
    TextView cerdShowTitleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_show_page);
        inflaterShow1 = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        rollingPaperShowLayout = (LinearLayout) inflaterShow1.inflate(R.layout.rolling_paper_frames_bottom_sheet, null);
        rollingPaperShowLayout.setBackgroundColor(Color.parseColor("#99000000"));
        paramsShow = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT);
        cancelButtonImageView = findViewById(R.id.cancel_button_imate_view);
        cerdShowTitleTextView=findViewById(R.id.cerd_show_title_text_view);

        // rollingPaper를 보여주기 위한 셋팅
        addContentView(rollingPaperShowLayout, paramsShow);
        rollingPaperShowLayout.setVisibility(View.GONE);   //처음에는 없애둔다
        // rollingPaperLayout textView 설정
        rollingPaperNextTextView = rollingPaperShowLayout.findViewById(R.id.rolling_paper_next_button_text_view);
        rollingPaperPreviousTextView = rollingPaperShowLayout.findViewById(R.id.rolling_paper_previous_button_text_view);
        rollingPaperNextTextView.setOnClickListener(onClickListener);
        rollingPaperPreviousTextView.setOnClickListener(onClickListener);
        // rollingPaperIcon EditText 설정
        rollingPaperIcon = rollingPaperShowLayout.findViewById(R.id.rolling_paper_icon);
        // rollingPaperLayout EditText 설정
        rollingPaperContent = (EditText) rollingPaperShowLayout.findViewById(R.id.rolling_paper_content);
        rollingPaperFrom = (EditText) rollingPaperShowLayout.findViewById(R.id.rolling_paper_from);
        rollingPaperFrame = rollingPaperShowLayout.findViewById(R.id.rolling_paper_frame);


        cancelButtonImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        cardShowPageFragment = new CardShowPageFragment();
        getSupportFragmentManager().beginTransaction().add(R.id.card_show_frame_layout, cardShowPageFragment).commitAllowingStateLoss();
//        mAuth = FirebaseAuth.getInstance(); //FirevaseAuth 객체 정의
//        FirebaseUser currentUser = mAuth.getCurrentUser();
//        userUid = currentUser.getUid();
//        firebaseFirestore.collection("cards")
//                .document(userUid)
//                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
//                    @Override
//                    public void onComplete(@NonNull Task<DocumentSnapshot> task) {
//                        Map<String, Object> data =  task.getResult().getData();
//                        String cardName = (String) data.get("cardName");
//                        cerdShowTitleTextView.setText(cardName);
//                    }
//                });
    }
    public static void rollingPaperSheet(){
        //rollingPapaerLinearLayout.setVisibility(View.VISIBLE);
        rollingPaperShowLayout.setVisibility(View.VISIBLE);//필요할때 다시 보여주는코드


    }
    View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.rolling_paper_next_button_text_view:
                case R.id.rolling_paper_previous_button_text_view:
                    rollingPaperShowLayout.setVisibility(View.GONE);
                    break;
            }
        }
    };
}