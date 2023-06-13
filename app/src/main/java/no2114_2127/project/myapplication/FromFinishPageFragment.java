package no2114_2127.project.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class FromFinishPageFragment extends Fragment {
    private FirebaseStorage firebaseStorage; //FirevaseAuth 객체 선언
//    private FirebaseAuth firebaseAuth; //FirevaseAuth 객체 선언
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_finish_page, container, false);
        firebaseStorage = FirebaseStorage.getInstance();
//        FirebaseUser user = firebaseAuth.getCurrentUser();
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("cards").document();
        firebaseFirestore.collection("cards").add(new CerdClass()).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d("확인", "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w("확인", "Error adding document", e);
                    }
                });

//        videoUpload();
//        imageUpload();
        return view;
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    public static FromFinishPageFragment FromFinishPageInstance() {
        return new FromFinishPageFragment();
    }

    private void videoUpload() {
        StorageReference storageReference = firebaseStorage.getReference("Study");
        storageReference.child("images").child("image").putFile(MediaClass.videoMedioClass.getVideoUri()).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(getContext(), "업로드에 성공했습니다", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getContext(), "업로드에 실패했습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void imageUpload() {
        StorageReference storageReference = firebaseStorage.getReference("Study");
        storageReference.child("images").child("image").putFile(MediaClass.imageClass.getImageUri()).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                if(task.isSuccessful()) {
                    Toast.makeText(getContext(), "업로드에 성공했습니다", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getContext(), "업로드에 실패했습니다", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
