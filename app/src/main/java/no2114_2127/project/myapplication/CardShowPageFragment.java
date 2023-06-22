package no2114_2127.project.myapplication;

import android.os.Bundle;
import android.provider.MediaStore;
import android.telecom.InCallService;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class CardShowPageFragment extends Fragment {
    // textView button
    TextView decorationButtonTextView,pageNumTextView,makePolaroidTitleTextView,makePolaroidSubtitleTextView,
            makeVideoTitleTextView,makeVideoSubtitleTextView,makeAwardTitleTextView,makeAwardSubtitleTextView;
    LinearLayout leftLayout, rightLayout;
    ImageView decorative1ImageView, decorative2ImageView, decorative3ImageView,
            decorative4ImageView, decorative5ImageView, decorative6ImageView;

    GridView makePolaroidGridView,videoGridView,makeAwardGridView;
    FirebaseFirestore db ;
    FirebaseUser firebaseUser;
    CollectionReference collectionRef, cakeCardColl, polaroidCardColl, awardCardColl, videoCardColl;
    PolaroidAdapter makePolaroidAdapter;
    AwardAdapter makeAwardAdapter;
    VideoAdapter makeVideoAdapter;
    String userUid;

    ArrayList<CakeClass> cakeClasses = new ArrayList<>();
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cerd_show_page, container, false);
        //button find view by id
       // decorationButtonTextView = view.findViewById(R.id.decoration_button_text_view);

        db = FirebaseFirestore.getInstance();
        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();
//        userCardColl = db.collection("users").document(firebaseUser.getUid()).collection("userHaveCard");
//        userUid = firebaseUser.getUid();

        //ImageView
        decorative1ImageView = view.findViewById(R.id.decorative1_image_view);
        decorative2ImageView = view.findViewById(R.id.decorative2_image_view);
        decorative3ImageView = view.findViewById(R.id.decorative3_image_view);
        decorative4ImageView = view.findViewById(R.id.decorative4_image_view);
        decorative5ImageView = view.findViewById(R.id.decorative5_image_view);
        decorative6ImageView = view.findViewById(R.id.decorative6_image_view);

        // Layout
        leftLayout = view.findViewById(R.id.left_layout);
        rightLayout = view.findViewById(R.id.right_layout);

        pageNumTextView=view.findViewById(R.id.page_num_text_view);
        makePolaroidTitleTextView=view.findViewById(R.id.make_polaroid_title_text_view);
        makePolaroidSubtitleTextView=view.findViewById(R.id.make_polaroid_subtitle_text_view);
        makeVideoTitleTextView=view.findViewById(R.id.make_video_title_text_view);
        makeVideoSubtitleTextView=view.findViewById(R.id.make_video_subtitle_text_view);
        makeAwardTitleTextView=view.findViewById(R.id.make_award_title_text_view);
        makeAwardSubtitleTextView=view.findViewById(R.id.make_award_subtitle_text_view);
        decorationButtonTextView=view.findViewById(R.id.decoration_button_text_view);

        makePolaroidGridView=view.findViewById(R.id.make_polaroid_grid_view);
        videoGridView=view.findViewById(R.id.video_grid_view);
        makeAwardGridView=view.findViewById(R.id.make_award_grid_view);

        leftLayout.setOnClickListener(layoutOnClickListener);
        rightLayout.setOnClickListener(layoutOnClickListener);


        cakeCardColl = db.collection("cards").document(VariableClass.cadeID).collection("cakeValue");
        polaroidCardColl = db.collection("cards").document(VariableClass.cadeID).collection("polaroidValue");
        awardCardColl = db.collection("cards").document(VariableClass.cadeID).collection("awardValue");
        videoCardColl = db.collection("cards").document(VariableClass.cadeID).collection("videoValue");
        makePolaroidAdapter = new PolaroidAdapter();
        makeAwardAdapter = new AwardAdapter();
        makeVideoAdapter = new VideoAdapter();
        // = new VideoClass();
        setAdapter();
        return view;
    }
    View.OnClickListener layoutOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){
                case R.id.left_layout:
                    Toast.makeText(getContext(),"왼쪽",Toast.LENGTH_SHORT).show();
                    break;
                case R.id.right_layout:
                    Toast.makeText(getContext(),"오른쪽",Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    };

    public void setAdapter(){
        List<String> documenPath = new ArrayList<String>();

        cakeCardColl.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.d("확인1", document.getId()+"" );
                        // (String) Objects.requireNonNull(document.get("fieldName"))
                        //q47BnidbW3FygI43J09N
                        // db.collection("cards").document(Objects.requireNonNull(document.get("fieldName")).toString()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        documenPath.add(document.getId());
                    }
                    if(documenPath.size()>0){
//                        String path = documenPath.get(0).trim();
//                        Log.d("확인2",documenPath.get(0));
//                        Log.d("확인2",documenPath.size()+"");
                        // 비동기 작업의 완료를 기다리기 위한 카운터 변수
                        AtomicInteger counter = new AtomicInteger(documenPath.size());

                        String path = documenPath.get(i).trim();
                        for (int i = 0; i < documenPath.size(); i++) {
                            if(documenPath.get(i)==null){
                                continue;
                            }
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
                                                    cakeClasses.add(new CakeClass(data.get("rollingPaper")+"",data.get("from") + "", data.get("decoImage")+"",data.get("rollingPaper")+""));

                                                }
                                            } else {
                                                Log.d("확인", "Error getting document: ", task.getException());
                                            }
                                        }
                                    });
                        }

                        decorative1ImageView.setImageResource(cakeClasses.get(0).getDecoImage());
                        decorative2ImageView.setImageResource(cakeClasses.get(1).getDecoImage());
//                        decorative3ImageView.setImageResource(cakeClasses.get(0).getDecoImage());
//                        decorative4ImageView.setImageResource(cakeClasses.get(0).getDecoImage());
//                        decorative5ImageView.setImageResource(cakeClasses.get(0).getDecoImage());
//                        decorative6ImageView.setImageResource(cakeClasses.get(0).getDecoImage());

                    }

                } else {
                    Log.d("확인", "Error getting documents: ", task.getException());
                }
            }});
        polaroidCardColl.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.d("확인1", document.getId()+"" );
                        // (String) Objects.requireNonNull(document.get("fieldName"))
                        //q47BnidbW3FygI43J09N
                        // db.collection("cards").document(Objects.requireNonNull(document.get("fieldName")).toString()).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                        documenPath.add(document.getId());
                    }
                    if(documenPath.size()>0){
//                        String path = documenPath.get(0).trim();
//                        Log.d("확인2",documenPath.get(0));
//                        Log.d("확인2",documenPath.size()+"");
                        // 비동기 작업의 완료를 기다리기 위한 카운터 변수
                        AtomicInteger counter = new AtomicInteger(documenPath.size());
                        for (int i = 0; i < documenPath.size(); i++) {
                            if(documenPath.get(i)==null){
                                continue;
                            }
                            String path = documenPath.get(i).trim();

                            polaroidCardColl.document(path)
                                    .get()
                                    .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                        @Override
                                        public void onComplete(Task<DocumentSnapshot> task) {
                                            if (task.isSuccessful()) {
                                                DocumentSnapshot snapshot = task.getResult();
                                                if (snapshot.exists()) {
                                                    Map<String, Object> data = snapshot.getData();
                                                    Log.d("확인4", data.get("photoImage") + "");
                                                    Log.d("확인4", data.get("polaroidImage") + "");
                                                    Log.d("확인4", data.get("polaroidText") + "");
                                                    // Log.d("확인!", cardAdapter.getItem()+ "");
                                                    makePolaroidAdapter.addItem(new PolaroidClass(data.get("photoImage")+"", data.get("polaroidImage")+"", data.get("polaroidText")+""));
                                                    //cardAdapter.notifyDataSetChanged();
                                                }
                                            } else {
                                                Log.d("확인", "Error getting document: ", task.getException());
                                            }

                                            // 비동기 작업이 완료되면 카운터를 감소시키고 체크
                                            if (counter.decrementAndGet() == 0) {
                                                Log.d("확인5", "");
                                                // 모든 작업이 완료되었을 때 실행할 코드
                                                makePolaroidGridView.setAdapter(makePolaroidAdapter);

                                            }
                                        }
                                    });


                        }
                    }

                } else {
                    Log.d("확인", "Error getting documents: ", task.getException());
                }
            }});

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


                        videoCardColl.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
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

                                            videoCardColl.document(path)
                                                    .get()
                                                    .addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                                        @Override
                                                        public void onComplete(Task<DocumentSnapshot> task) {
                                                            if (task.isSuccessful()) {
                                                                DocumentSnapshot snapshot = task.getResult();
                                                                if (snapshot.exists()) {
                                                                    Map<String, Object> data = snapshot.getData();
                                                                    Log.d("확인4", data.get("videoName") + "");
                                                                    // Log.d("확인!", cardAdapter.getItem()+ "");
                                                                    makeVideoAdapter.addItem(new VideoClass("videoName"));
                                                                    //cardAdapter.notifyDataSetChanged();
                                                                }
                                                            } else {
                                                                Log.d("확인", "Error getting document: ", task.getException());
                                                            }

                                                            // 비동기 작업이 완료되면 카운터를 감소시키고 체크
                                                            if (counter.decrementAndGet() == 0) {
                                                                Log.d("확인5", "");
                                                                // 모든 작업이 완료되었을 때 실행할 코드
                                                                makePolaroidGridView.setAdapter(makeVideoAdapter);

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



//                Log.d("확인5", "");
//                mainDecoGridView.setAdapter(cardAdapter)

    }
}