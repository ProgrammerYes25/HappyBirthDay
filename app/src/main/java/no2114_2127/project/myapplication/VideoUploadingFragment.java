package no2114_2127.project.myapplication;

import static android.app.Activity.RESULT_OK;
import static android.content.Context.CONTEXT_IGNORE_SECURITY;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.google.firebase.auth.FirebaseAuth;

public class VideoUploadingFragment extends Fragment {
    TextView videoButtonTextView;

    // video view 선언
    VideoView videoUplodeView;

    //Linear Layout 선언
    LinearLayout videoUplodeLayout;
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
            Intent intent = new Intent(getActivity(), CerdMakePageActivity.class);

            switch (v.getId()){
                case R.id.video_button_text_view:
                    getActivity().finish();
                    StageClass.stage = 3;
                    startActivity(intent);
                    break;
                case R.id.video_uplode_layout:
                    videoUplodeView.setVisibility(View.VISIBLE);
                case R.id.video_uplode_view:
                    Intent intentImage = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intentImage.setType("video/*");
                    launcher.launch(intentImage);
                    break;
            }
        }

        private final ActivityResultLauncher<Intent> launcher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                new ActivityResultCallback<ActivityResult>() {
                    @Override
                    public void onActivityResult(ActivityResult result) {
                        if(result.getResultCode() == RESULT_OK && result.getData() != null) {
                            MediaController mc = new MediaController(getContext()); // 비디오 컨트롤 가능하게(일시정지, 재시작 등)
                            videoUplodeView.setMediaController(mc);
                            uri = result.getData().getData();
                            Log.d("test", uri.toString());
                            videoUplodeView.setVideoURI(uri);
                            MediaClass.videoMedioClass.setVideoUri(uri);
                        }
                    }
                });
    };
}