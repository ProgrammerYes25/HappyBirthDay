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
import android.widget.TextView;

import java.util.ArrayList;

public class AwardAdapter extends BaseAdapter {
    ArrayList<AwardClass> items = new ArrayList<AwardClass>();
    Context context;

    public void addItem(AwardClass item){
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
        AwardClass awardClass = items.get(position);
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.mini_award_item, parent, false);
        }
        TextView awardTitleEditText = convertView.findViewById(R.id.award_title);
        TextView awardTextEditText = convertView.findViewById(R.id.award_text);
        TextView awardToNameEditText = convertView.findViewById(R.id.award_to_name);
        TextView awardDateEditText = convertView.findViewById(R.id.award_date);
        TextView awardFromEditText = convertView.findViewById(R.id.award_from);

        Log.d("확인 ", awardClass.getAwardTitle()+"" );
        Log.d("확인 ", awardClass.getAwardText()+"" );
        Log.d("확인 ", awardClass.getAwardToName()+"" );
        Log.d("확인 ", awardClass.getAwardDate()+"" );
        Log.d("확인 ", awardClass.getAwardFrom()+"" );
        Log.d("확인 ","-----------------------------------------------");

        String awardTitle = awardClass.getAwardTitle();
        String awardText = awardClass.getAwardText();
        String awardToName = awardClass.getAwardToName();
        String awardDate = awardClass.getAwardDate();
        String awardFrom = awardClass.getAwardFrom();
        awardTitleEditText.setText(awardTitle);
        awardTextEditText.setText(awardText);;
        awardToNameEditText.setText(awardToName);
        awardDateEditText.setText(awardDate);
        awardFromEditText.setText(awardFrom);

        return convertView;
    }
}
