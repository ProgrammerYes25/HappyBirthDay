package no2114_2127.project.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class VideoUploadingFragment extends Fragment {
    TextView videoButtonTextView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_video_uploading, container, false);
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
            }
        }
    };
}