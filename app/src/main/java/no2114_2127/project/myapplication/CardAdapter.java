package no2114_2127.project.myapplication;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

public class CardAdapter extends BaseAdapter {
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
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
