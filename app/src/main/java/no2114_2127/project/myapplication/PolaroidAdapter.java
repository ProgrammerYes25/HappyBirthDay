package no2114_2127.project.myapplication;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;

import java.util.ArrayList;

public class PolaroidAdapter extends BaseAdapter {
    ArrayList<PolaroidClass> items = new ArrayList<PolaroidClass>();
    Context context;
    int polaroidFrame[] = {R.drawable.polaroid_frame_1, R.drawable.polaroid_frame_2, R.drawable.polaroid_frame_3,
            R.drawable.polaroid_frame_4, R.drawable.polaroid_frame_5,R.drawable.polaroid_frame_6,
            R.drawable.polaroid_frame_7, R.drawable.polaroid_frame_8, R.drawable.polaroid_frame_9 };

    public void addItme(PolaroidClass item){
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
        PolaroidClass polaroidClass = items.get(position);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.mini_polaroid_item, parent, false);
        }
        ImageView photoImageView = convertView.findViewById(R.id.polaroid_photo_image_view);
        ImageView polaroidImageView = convertView.findViewById(R.id.polaroid_image_view);
        EditText polaroidEditText = convertView.findViewById(R.id.polaroid_edit_text);

        Log.d("확인 ", polaroidClass.getPolaroidText()+"" );
        Log.d("확인 ", polaroidClass.getPhotoImage()+"" );
        Log.d("확인 ", polaroidClass.getPolaroidImage()+"" );
        Log.d("확인 ","-----------------------------------------------");

        String photoImage =  polaroidClass.getPhotoImage();
        int polaroidImage = polaroidClass.getPolaroidImage();
        String polaroidText = polaroidClass.getPolaroidText();
        photoImageView.setImageURI(Uri.parse(photoImage));
        polaroidImageView.setImageResource(polaroidImage);
        polaroidEditText.setText(polaroidText);

        return convertView;
    }
}
