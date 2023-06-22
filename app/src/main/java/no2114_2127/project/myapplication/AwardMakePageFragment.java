package no2114_2127.project.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import org.checkerframework.checker.nullness.qual.NonNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class AwardMakePageFragment extends Fragment {
    TextView awardButtonTextView;

    GridView makeAwardGridView;
    FirebaseFirestore db ;
    CollectionReference awardCardColl;
    FirebaseUser firebaseUser;
    AwardAdapter makeAwardAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_award_make_page, container, false);
        awardButtonTextView = view.findViewById(R.id.award_button_text_view);
        awardButtonTextView.setOnClickListener(onClickListener);
        db = FirebaseFirestore.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        awardCardColl = db.collection("cards").document(VariableClass.cadeID).collection("awardValue");
        makeAwardGridView = view.findViewById(R.id.make_award_grid_view);
        makeAwardAdapter = new AwardAdapter();
        setAdapter();
        return view;
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    public static AwardMakePageFragment AwardMakePageInstance() {
        return new AwardMakePageFragment();
    }
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), CardMakeingPageActivity.class);

            switch (v.getId()){
                case R.id.award_button_text_view:
                    getActivity().finish();
                    startActivity(intent);
                    break;
            }
        }
    };

    public void setAdapter(){
        List<String> documenPath = new ArrayList<String>();
        awardCardColl.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.d("확인1", document.getId() + "");
                        // (String) Objects.requireNonNull(document.get("fieldName"))
                        //q47BnidbW3FygI43J09N
                        // db.collection("cards").document(Objects.requireNonNull(document.get("fieldName")).toString()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        documenPath.add(document.getId());
                    }
                    if (documenPath.size() > 0) {
//                        String path = documenPath.get(0).trim();
//                        Log.d("확인2",documenPath.get(0));
//                        Log.d("확인2",documenPath.size()+"");
                        // 비동기 작업의 완료를 기다리기 위한 카운터 변수
                        AtomicInteger counter = new AtomicInteger(documenPath.size());
                        for (int i = 0; i < documenPath.size(); i++) {
                            if (documenPath.get(i) == null) {
                                continue;
                            }
                            String path = documenPath.get(i).trim();

                            awardCardColl.document(path)
                                    .get()
                                    .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                        @Override
                                        public void onComplete(Task<DocumentSnapshot> task) {
                                            if (task.isSuccessful()) {
                                                DocumentSnapshot snapshot = task.getResult();
                                                if (snapshot.exists()) {
                                                    Map<String, Object> data = snapshot.getData();
                                                    Log.d("확인4", data.get("awardDate") + "");
                                                    Log.d("확인4", data.get("awardFrom") + "");
                                                    Log.d("확인4", data.get("awardText") + "");
                                                    Log.d("확인4", data.get("awardTitle") + "");
                                                    Log.d("확인4", data.get("awardToName") + "");
                                                    // Log.d("확인!", cardAdapter.getItem()+ "");
                                                    makeAwardAdapter.addItem(new AwardClass(data.get("awardTitle")+"", data.get("awardText")+"",data.get("awardToName") +"",data.get("awardDate")+"",data.get("awardFrom")+"" ));
                                                    //cardAdapter.notifyDataSetChanged();
                                                }
                                            } else {
                                                Log.d("확인", "Error getting document: ", task.getException());
                                            }

                                            // 비동기 작업이 완료되면 카운터를 감소시키고 체크
                                            if (counter.decrementAndGet() == 0) {
                                                Log.d("확인5", "");
                                                // 모든 작업이 완료되었을 때 실행할 코드
                                                makeAwardGridView.setAdapter(makeAwardAdapter);

                                            }
                                        }
                                    });


                        }
                    }

                } else {
                    Log.d("확인", "Error getting documents: ", task.getException());
                }
            }
        });
    }
}