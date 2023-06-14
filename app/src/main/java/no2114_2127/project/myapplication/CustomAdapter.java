package no2114_2127.project.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    Context mContext;
    List<MainDecoListItem> items = new ArrayList<MainDecoListItem>();
    public CustomAdapter() {

    }
    public CustomAdapter(Context context, List<MainDecoListItem> layoutList) {
        mContext = context;
        items = layoutList;
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
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.main_grid_shortcut, parent, false);
        }

        // 아이템에 대한 처리 로직 구현

        return convertView;
    }

    public void addItem(MainDecoListItem item) {
        items.add(item);
//        for(int i =0; i< items.size(); i++) {
//            Log.d("확인", items.get(i) + "!");
//        }
//        Log.d("끝", "-----------------------------------------------");
    }
}