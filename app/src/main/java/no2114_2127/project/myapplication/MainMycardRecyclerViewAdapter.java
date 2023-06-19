package no2114_2127.project.myapplication;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainMycardRecyclerViewAdapter extends RecyclerView.Adapter<MainMycardRecyclerViewAdapter.ViewHolder> {
    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView nameAndBirth;
        public TextView cardName;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            nameAndBirth = itemView.findViewById(R.id.tv_name_birthday);
            cardName = itemView.findViewById(R.id.tv_nickname);
        }
    }

    private ArrayList<MainMycardRecyclerViewItem> mList = null;

    public MainMycardRecyclerViewAdapter(ArrayList<MainMycardRecyclerViewItem> mList) {
        this.mList = mList;
    }

    // 아이템 뷰를 위한 뷰홀더 객체를 생성하여 리턴
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.main_grid_shortcut, parent, false);
        MainMycardRecyclerViewAdapter.ViewHolder vh = new MainMycardRecyclerViewAdapter.ViewHolder(view);
        return vh;
    }

    // position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시
    @Override
    public void onBindViewHolder(@NonNull MainMycardRecyclerViewAdapter.ViewHolder holder, int position) {
        MainMycardRecyclerViewItem item = mList.get(position);

        if (item.getNameAndBirth() != null) {
            holder.nameAndBirth.setText(item.getNameAndBirth().getText());
        } else {
            holder.nameAndBirth.setText("");
        }

        if (item.getCardName() != null) {
            holder.cardName.setText(item.getCardName().getText());
        } else {
            holder.cardName.setText("");
        }
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
    public void addItem(MainMycardRecyclerViewItem item) {
        mList.add(item);
//        for(int i =0; i< items.size(); i++) {
//            Log.d("확인", items.get(i) + "!");
//        }
//        Log.d("끝", "-----------------------------------------------");
    }

}
