package no2114_2127.project.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CardAdapter extends BaseAdapter {
    ArrayList<CardListItem> itmes = new ArrayList<CardListItem>();
    Context context;

    public void addItme(CardListItem itme){
        itmes.add(itme);
        for(int i =0;i< itmes.size(); i++) {
            Log.d("확인", itmes.get(i) + "!");
        }
        Log.d("끝", "-----------------------------------------------");
    }
    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        context = parent.getContext();
        Log.d("확인 !", convertView+"" );
        CardListItem cardListItem = itmes.get(position);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.cake_list_item, parent, false);
        }

        TextView tvNickname = convertView.findViewById(R.id.tv_nickname);
        TextView tvNameBirthday = convertView.findViewById(R.id.tv_name_birthday);
        tvNickname.setText(cardListItem.getUserName());
        tvNameBirthday.setText(cardListItem.getDate());

//        ImageView cakeIcon = convertView.findViewById(R.id.cake_icon);
//        ImageView iconCircle = convertView.findViewById(R.id.icon_circle);
//        Log.d("확인 ", cardListItem.getIcon()+"" );
//        Log.d("확인 ","-----------------------------------------------");
//        cakeIcon.setImageResource(cardListItem.getIcon());
//        iconCircle.setImageResource(cardListItem.getCircle());
        return convertView;
    }
}
