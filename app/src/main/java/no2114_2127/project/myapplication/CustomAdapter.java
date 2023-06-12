package no2114_2127.project.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<String> {
    private Context context;
    private List<String> data;

    public CustomAdapter(Context context, List<String> data) {
        super(context, R.layout.main_grid_shortcut, data);
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.main_grid_shortcut, parent, false);
        }

//        ImageView imageView = convertView.findViewById(R.id.imageView);
//        TextView textView = convertView.findViewById(R.id.textView);

        // 데이터 설정
        String item = data.get(position);
//        textView.setText(item);

        // 이미지 설정 등 추가적인 작업 수행 가능

        return convertView;
    }
}
