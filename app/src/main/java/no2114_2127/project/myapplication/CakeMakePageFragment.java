package no2114_2127.project.myapplication;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

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

public class CakeMakePageFragment extends Fragment {
    // textView button
    TextView decorationButtonTextView;
    ImageView decorative1ImageView, decorative2ImageView, decorative3ImageView,
            decorative4ImageView, decorative5ImageView, decorative6ImageView;
    FirebaseFirestore db ;
    CollectionReference cakeCardColl;
    FirebaseUser firebaseUser;
    AwardAdapter cakeAwardAdapter;
    ArrayList<CakeClass> cakeClasses = new ArrayList<CakeClass>();
    int int1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cake_make_page, container, false);
        //button find view by id
        decorationButtonTextView = view.findViewById(R.id.decoration_button_text_view);
        decorationButtonTextView.setOnClickListener(onClickListener);

        decorative1ImageView = view.findViewById(R.id.decorative1_image_view);
        decorative2ImageView = view.findViewById(R.id.decorative2_image_view);
        decorative3ImageView = view.findViewById(R.id.decorative3_image_view);
        decorative4ImageView = view.findViewById(R.id.decorative4_image_view);
        decorative5ImageView = view.findViewById(R.id.decorative5_image_view);
        decorative6ImageView = view.findViewById(R.id.decorative6_image_view);

        db = FirebaseFirestore.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
        cakeCardColl = db.collection("cards").document(VariableClass.cadeID).collection("cakeValue");
        cakeAwardAdapter = new AwardAdapter();
        setAdapter();
        return view;
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    public static CakeMakePageFragment cakeMakePageInstance() {
        return new CakeMakePageFragment();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), CardMakeingPageActivity.class);

            switch (v.getId()){
                case R.id.decoration_button_text_view:
                    getActivity().finish();
                    startActivity(intent);
                break;
            }
        }
    };
    public void setAdapter() {
        List<String> documenPath = new ArrayList<String>();


        cakeCardColl.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
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
                        int1 = 0;
//                        String path = documenPath.get(0).trim();
//                        Log.d("확인2",documenPath.get(0));
//                        Log.d("확인2",documenPath.size()+"");
                        // 비동기 작업의 완료를 기다리기 위한 카운터 변수
                        //AtomicInteger counter = new AtomicInteger(documenPath.size());

                        for (int i = 0; i < documenPath.size(); i++) {
                            if (documenPath.get(i) == null) {
                                continue;
                            }
                            Log.d("확인확인", i + "");
                            String path = documenPath.get(i).trim();

                            cakeCardColl.document(path)
                                    .get()
                                    .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                        @Override
                                        public void onComplete(Task<DocumentSnapshot> task) {
                                            if (task.isSuccessful()) {
                                                DocumentSnapshot snapshot = task.getResult();
                                                if (snapshot.exists()) {
                                                    Map<String, Object> data = snapshot.getData();
                                                    Log.d("확인4", data.get("decoImage") + "");
                                                    Log.d("확인4", data.get("from") + "");
                                                    Log.d("확인4", data.get("letterPaper") + "");
                                                    Log.d("확인4", data.get("rollingPaper") + "");
                                                    // Log.d("확인!", cardAdapter.getItem()+ "");
//                                                    makePolaroidAdapter.addItem(new PolaroidClass(data.get("photoImage")+"", data.get("polaroidImage")+"", data.get("polaroidText")+""));
                                                    //cardAdapter.notifyDataSetChanged();
                                                    cakeClasses.add(new CakeClass(data.get("rollingPaper") + "", data.get("from") + "", data.get("decoImage") + "", data.get("letterPaper") + ""));
//                                                    //decorative1ImageView.setImageResource(cakeClasses.get(0).getDecoImage());
                                                    Log.d("확인확인!", int1 + "");

                                                    if (int1 == 0 && cakeClasses.size() >= 0) {
                                                        decorative1ImageView.setImageResource(cakeClasses.get(0).getDecoImage());

                                                    } else if (int1 == 1 && cakeClasses.size() >= 1) {
                                                        decorative2ImageView.setImageResource(cakeClasses.get(1).getDecoImage());

                                                    } else if (int1 == 2 && cakeClasses.size() >= 2) {
                                                        decorative3ImageView.setImageResource(cakeClasses.get(2).getDecoImage());

                                                    } else if (int1 == 3 && cakeClasses.size() >= 3) {
                                                        decorative4ImageView.setImageResource(cakeClasses.get(3).getDecoImage());

                                                    } else if (int1 == 4 && cakeClasses.size() >= 4) {
                                                        decorative5ImageView.setImageResource(cakeClasses.get(4).getDecoImage());

                                                    } else if (int1 == 5 && cakeClasses.size() >= 5) {
                                                        decorative6ImageView.setImageResource(cakeClasses.get(5).getDecoImage());

                                                    }
                                                    int1++;
                                                }

                                            } else {
                                                Log.d("확인", "Error getting document: ", task.getException());
                                            }
                                        }
                                    });
                            //  decorative2ImageView.setImageResource(cakeClasses.get(1).getDecoImage());


                        }

                        //if (counter.decrementAndGet() == 0) {
//                        decorative3ImageView.setImageResource(cakeClasses.get(0).getDecoImage());
//                        decorative4ImageView.setImageResource(cakeClasses.get(0).getDecoImage());
//                        decorative5ImageView.setImageResource(cakeClasses.get(0).getDecoImage());
//                        decorative6ImageView.setImageResource(cakeClasses.get(0).getDecoImage());
                        //}
                    }

                } else {
                    Log.d("확인", "Error getting documents: ", task.getException());
                }
            }
        });
    }
}