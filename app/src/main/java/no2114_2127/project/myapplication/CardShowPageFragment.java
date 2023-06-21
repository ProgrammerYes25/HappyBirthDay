package no2114_2127.project.myapplication;

import android.os.Bundle;
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

public class CardShowPageFragment extends Fragment {
    // textView button
    TextView decorationButtonTextView,pageNumTextView,makePolaroidTitleTextView,makePolaroidSubtitleTextView,
            makeVideoTitleTextView,makeVideoSubtitleTextView,makeAwardTitleTextView,makeAwardSubtitleTextView;
    LinearLayout leftLayout, rightLayout;
    ImageView decorative1ImageView, decorative2ImageView, decorative3ImageView,
            decorative4ImageView, decorative5ImageView, decorative6ImageView;

    GridView makePolaroidGridView,videoGridView,makeAwardGridView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cerd_show_page, container, false);
        //button find view by id
       // decorationButtonTextView = view.findViewById(R.id.decoration_button_text_view);

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
}
