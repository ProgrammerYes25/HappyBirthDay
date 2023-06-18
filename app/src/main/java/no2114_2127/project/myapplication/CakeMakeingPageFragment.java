package no2114_2127.project.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class CakeMakeingPageFragment extends Fragment {
    // TextView Button
    TextView nextButtonTextView;

    GridView decorativeListGridView;
    CakeGridListAdapter adapter;

    int cakeDecorative[] = {R.drawable.cake_decorative_strawberrie, R.drawable.cake_decorative_flower, R.drawable.cake_decorative_cherry,
            R.drawable.cake_decorative_gift, R.drawable.cake_decorative_chocolate, R.drawable.cake_decorative_heart,
            R.drawable.cake_decorative_rabbit, R.drawable.cake_decorative_chick, R.drawable.cake_decorative_puppy,
            R.drawable.cake_decorative_muffin, R.drawable.cake_decorative_donut, R.drawable.cake_decorative_balloon};
    int circle[] = {R.drawable.img_decorative_icon_circle_border,R.drawable.img_decorative_icon_circle_border,R.drawable.img_decorative_icon_circle_border,
            R.drawable.img_decorative_icon_circle_border,R.drawable.img_decorative_icon_circle_border,R.drawable.img_decorative_icon_circle_border,
            R.drawable.img_decorative_icon_circle_border,R.drawable.img_decorative_icon_circle_border,R.drawable.img_decorative_icon_circle_border,
            R.drawable.img_decorative_icon_circle_border, R.drawable.img_decorative_icon_circle_border,R.drawable.img_decorative_icon_circle_border};
    int choice = -1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cake_makeing_page, container, false);
        // nextButton 세팅
        nextButtonTextView = view.findViewById(R.id.next_button_text_view);
        nextButtonTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(choice > -1){
                    ((CardMakeingPageActivity)getActivity()).replaceFragment(CakeMakeWritingPageFragment.CakeMakeWritingPageInstance());
                    CardClass.cakeClass.setDecoImage(cakeDecorative[choice]);// 아이콘 저장
                }
            }
        });

        //GridView 셋팅
        decorativeListGridView = view.findViewById(R.id.decorative_list_grid_view);
        adapter = new CakeGridListAdapter();
        setAdapter();
        decorativeListGridView.setOnItemClickListener(onItemClickListener);
        return view;
    }

    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            CakeListItem item = (CakeListItem) adapter.getItem(position);
            Log.d("선택 :",position+" ");
            circle[position] = R.drawable.img_decorative_icon_circle;
            if(position == choice){
                circle[choice] = R.drawable.img_decorative_icon_circle_border;
                nextButtonDeactivation();
                choice = -1;
            }else if(choice != -1 ){
                circle[choice] = R.drawable.img_decorative_icon_circle_border;
                choice = position;
            }else {
                choice = position;
                nextButtonActivation();
            }
            for(int i =0; i<cakeDecorative.length; i++) {
                Log.d("Circle확인 : ", circle[i]+"");
            }
            resetAdapter();
        }
    };

    public void setAdapter(){
        for(int i =0; i<cakeDecorative.length; i++) {
            adapter.addItme(new CakeListItem(cakeDecorative[i], circle[i]));
        }
        decorativeListGridView.setAdapter(adapter);
    }

    public void nextButtonDeactivation(){
        nextButtonTextView.setBackgroundResource(R.drawable.rectangle_resource_perimeter_deactivation);
        nextButtonTextView.setTextColor(Color.parseColor("#98A2B3"));
    }
    public void nextButtonActivation(){
        nextButtonTextView.setBackgroundResource(R.drawable.rectangle_resource_perimeter_activation);
        nextButtonTextView.setTextColor(Color.parseColor("#585062"));
    }
    public void resetAdapter(){
        for(int i =0; i<cakeDecorative.length; i++) {
            adapter.itmes.add(i, new CakeListItem(cakeDecorative[i], circle[i]));
            adapter.itmes.remove(i+1);
        }
        decorativeListGridView.setAdapter(adapter);
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    public static CakeMakeingPageFragment CakeMakeingPageInstance() {
        return new CakeMakeingPageFragment();
    }

}
