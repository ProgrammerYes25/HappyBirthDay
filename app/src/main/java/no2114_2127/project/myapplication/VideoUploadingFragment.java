package no2114_2127.project.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class VideoUploadingFragment extends Fragment {
    private static final int REQUEST_VIDEO_CAPTURE =1 ;
    TextView videoButtonTextView;

    // video view 선언
    VideoView videoUplodeView;

    //Linear Layout 선언
    LinearLayout videoUplodeLayout;
    FirebaseStorage firebaseStorage;
    StorageReference storageReference;
    private Uri uri;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_uploading, container, false);
        // video view findViewById
        videoUplodeView = view.findViewById(R.id.video_uplode_view);
        videoUplodeView.setOnClickListener(onClickListener);
        // LinearLayout findViewById
        videoUplodeLayout = view.findViewById(R.id.video_uplode_layout);
        videoUplodeLayout.setOnClickListener(onClickListener);
        // Textview findViewById
        videoButtonTextView = view.findViewById(R.id.video_button_text_view);
        videoButtonTextView.setOnClickListener(onClickListener);

        firebaseStorage = FirebaseStorage.getInstance();
        storageReference = firebaseStorage.getReference();

        return view;
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    public static VideoUploadingFragment VideoUploadingInstance() {
        return new VideoUploadingFragment();
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(getActivity(), CardMakePageActivity.class);

            switch (v.getId()) {
                case R.id.video_button_text_view:
                    getActivity().finish();
                    VariableClass.stage = 3;
                    startActivity(intent);
                    break;
                case R.id.video_uplode_layout:
                    videoUplodeView.setVisibility(View.VISIBLE);
                case R.id.video_uplode_view:
                    TakeVideo();
//                    Intent intentImage = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
//                    intentImage.setType("video/*");
//                    launcher.launch(intentImage);

                    break;
            }
        }
    };
    private void TakeVideo() {
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(requireActivity().getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
        }
    }
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.d("확인 ", "");
        if (requestCode == REQUEST_VIDEO_CAPTURE && resultCode == Activity.RESULT_OK) {
            Uri videoUri = data.getData();
            uri = videoUri;
            videoUpload();;
        }
    }
    private void videoUpload() {

        UploadTask uploadTask = storageReference.child("videos/"+uri.getLastPathSegment()).putFile(uri);
        CardClass.videoClass.setVideoName(uri.getLastPathSegment());
        Log.d("확인 : ", uri+"");
        uploadTask.addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception exception) {
                // Handle unsuccessful uploads
                Log.d("성공 확인 : ", uri+"");
            }
        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
            @Override
            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
                // ...
                Log.d("석세스 성공 확인 : ", uri+"");
            }
        });
    }
}