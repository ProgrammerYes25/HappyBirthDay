package no2114_2127.project.myapplication;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;

import com.bumptech.glide.Glide;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;

public class VideoAdapter extends BaseAdapter {
    ArrayList<VideoClass> items = new ArrayList<VideoClass>();
    Context context;

    public void addItem(VideoClass item){
        items.add(item);
        for(int i =0;i< items.size(); i++) {
            Log.d("확인", items.get(i) + "!");
        }
        Log.d("끝", "-----------------------------------------------");
    }
    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = parent.getContext();
        Log.d("확인 !", convertView+"" );
        VideoClass videoClass = items.get(position);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.mini_polaroid_item, parent, false);
        }
        VideoView videoView = convertView.findViewById(R.id.make_video_grid_view);
       Log.d("확인 ", videoClass.getVideoName()+ "");
        Log.d("확인 ","-----------------------------------------------");

//        StorageReference storageReference = FirebaseStorage.getInstance().getReference("Study");
//        storageReference.child("images").child("image").getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
//            @Override
//            public void onSuccess(Uri uri) {
//                Glide.with(context).load(uri).into;
//            }
//        });

//        String photoImage =  videoClass.getPhotoImage();
//        int polaroidImage = videoClass.getPolaroidImage();
//        String polaroidText = videoClass.getPolaroidText();
//        //photoImageView.setImageURI(Uri.parse(photoImage));
//        polaroidImageView.setImageResource(polaroidFrame[polaroidImage]);
//        polaroidEditText.setText(polaroidText);

        return convertView;
    }
}
