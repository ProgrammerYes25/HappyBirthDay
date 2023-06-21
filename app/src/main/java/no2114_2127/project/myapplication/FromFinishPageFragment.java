package no2114_2127.project.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class FromFinishPageFragment extends Fragment {
    private FirebaseStorage firebaseStorage; //FirevaseAuth 객체 선언
//    private FirebaseAuth firebaseAuth; //FirevaseAuth 객체 선언

    StorageReference mountainsReference;
    StorageReference storageReference;
    byte[] data;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form_finish_page, container, false);
        firebaseStorage = FirebaseStorage.getInstance();
        storageReference = firebaseStorage.getReference();
        data = MediaClass.getImageClass();
        String imageName = "";
        for(int i = 0; i < 5; i++){
            imageName += VariableClass.cadeID.charAt(i);
        }
        imageName += String.valueOf(data);

        imageName += ".jpg";
        CardClass.polaroidClass.setPhotoImage(imageName);

        mountainsReference = storageReference.child("images/"+imageName);
//        FirebaseUser user = firebaseAuth.getCurrentUser();
        FirebaseFirestore firebaseFirestore = FirebaseFirestore.getInstance();
        firebaseFirestore.collection("cards").document();
        firebaseFirestore.collection("cards").document(VariableClass.cadeID).collection("cakeValue").add(CardClass.cakeClass).addOnSuccessListener(onSuccessListener).addOnFailureListener(onFailureListener);
        firebaseFirestore.collection("cards").document(VariableClass.cadeID).collection("polaroidValue").add(CardClass.polaroidClass).addOnSuccessListener(onSuccessListener).addOnFailureListener(onFailureListener);
        firebaseFirestore.collection("cards").document(VariableClass.cadeID).collection("videoValue").add(CardClass.videoClass).addOnSuccessListener(onSuccessListener).addOnFailureListener(onFailureListener);
        firebaseFirestore.collection("cards").document(VariableClass.cadeID).collection("awardValue").add(CardClass.awardClass).addOnSuccessListener(onSuccessListener).addOnFailureListener(onFailureListener);


        imageUpload();
//        videoUpload();
        return view;
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    public static FromFinishPageFragment FromFinishPageInstance() {
        return new FromFinishPageFragment();
    }

//    private void videoUpload() {
//        Uri uri  = Uri.fromFile(MediaClass.getVideoFileClass());
//
//        UploadTask uploadTask = storageReference.child("video/"+uri.getLastPathSegment()).putFile(uri);
//        Log.d("확인 : ", uri+"");
//        uploadTask.addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception exception) {
//                // Handle unsuccessful uploads
//                Log.d("성공 확인 : ", uri+"");
//            }
//        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//            @Override
//            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
//                // ...
//                Log.d("석세스 성공 확인 : ", uri+"");
//            }
//        });
//    }

    private void imageUpload() {
        UploadTask uploadTask = mountainsReference.putBytes(data);
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                // ...
            }
        });
//        StorageReference storageReference = firebaseStorage.getReference("Study");
//        storageReference.child("images").child("image").putFile(MediaClass.imageClass.getImageUri()).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
//            @Override
//            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
//                if(task.isSuccessful()) {
//                    Toast.makeText(getContext(), "업로드에 성공했습니다", Toast.LENGTH_SHORT).show();
//                }
//                else {
//                    Toast.makeText(getContext(), "업로드에 실패했습니다", Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }
    OnSuccessListener onSuccessListener = new OnSuccessListener<DocumentReference>() {
        @Override
        public void onSuccess(DocumentReference documentReference) {
            Log.d("확인", "DocumentSnapshot added with ID: " + documentReference.getId());
        }
    };
    OnFailureListener onFailureListener = new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception e) {
            Log.w("확인", "Error adding document", e);
        }
    };
}
