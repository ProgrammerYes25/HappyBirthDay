package no2114_2127.project.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class CakeGridListAdapter extends BaseAdapter {
    ArrayList<CakeListItem> itmes = new ArrayList<CakeListItem>();
    Context context;

    public void addItme(CakeListItem itme){
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
        CakeListItem cakeListItem = itmes.get(position);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.cake_list_item, parent, false);
        }

        ImageView cakeIcon = convertView.findViewById(R.id.cake_icon);
        Log.d("확인 ", cakeListItem.getIcon()+"" );
        Log.d("확인 ","-----------------------------------------------");
        cakeIcon.setImageResource(cakeListItem.getIcon());
        return convertView;
    }
}
