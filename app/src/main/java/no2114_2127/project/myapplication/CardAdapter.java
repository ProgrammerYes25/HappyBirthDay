package no2114_2127.project.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.ArrayList;

public class CardAdapter extends BaseAdapter {
    ArrayList<CardListItem> itmes = new ArrayList<CardListItem>();
    Context context;
    BottomSheetDialog bottomSheetDialog;

    public void getBottomSheetDialog(BottomSheetDialog bottomSheetDialog){
        this.bottomSheetDialog = bottomSheetDialog;
    }
    public void addItme(CardListItem itme){
        itmes.add(itme);
        for(int i =0;i< itmes.size(); i++) {
            Log.d("확인", itmes.get(i) + "!");
        }
        Log.d("끝", "-----------------------------------------------");
    }
    @Override
    public int getCount() {
        return itmes.size();
    }

    @Override
    public Object getItem(int position) {
        return itmes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = parent.getContext();
        Log.d("확인 !", convertView+"" );
        CardListItem cardListItem = itmes.get(position);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.main_grid_shortcut, parent, false);
        }
        ImageView mainMenu = convertView.findViewById(R.id.main_menu);
        EditText tvNickname = convertView.findViewById(R.id.tv_nickname);
        EditText tvNameBirthday = convertView.findViewById(R.id.tv_name_birthday);
        Log.d("확인 ", cardListItem.getUserName()+"" );
        Log.d("확인 ", cardListItem.getDate()+"" );
        Log.d("확인 ","-----------------------------------------------");
        String name =  cardListItem.getUserName();
        String date =  cardListItem.getDate();
        tvNickname.setText(name);
        tvNameBirthday.setText(date);
        mainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bottomSheetDialog.show();
            }
        });

//        ImageView cakeIcon = convertView.findViewById(R.id.cake_icon);
//        ImageView iconCircle = convertView.findViewById(R.id.icon_circle);
//        Log.d("확인 ", cardListItem.getIcon()+"" );
//        Log.d("확인 ","-----------------------------------------------");
//        cakeIcon.setImageResource(cardListItem.getIcon());
//        iconCircle.setImageResource(cardListItem.getCircle());
        return convertView;
    }
}
