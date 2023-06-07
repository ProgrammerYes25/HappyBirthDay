package no2114_2127.project.myapplication;

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
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cake_makeing_page, container, false);
        // nextButton 세팅
        nextButtonTextView = view.findViewById(R.id.next_button_text_view);
        nextButtonTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((CerdMakeingPageActivity)getActivity()).replaceFragment(CakeMakeWritingPageFragment.CakeMakeWritingPageInstance());
            }
        });

        //GridView 셋팅
        decorativeListGridView = view.findViewById(R.id.decorative_list_grid_view);
        adapter = new CakeGridListAdapter();
        setAdapter();
        //decorativeListGridView.setOnItemClickListener();
        return view;
    }
    public void setAdapter(){
        for(int id : cakeDecorative) {
            adapter.addItme(new CakeListItem(id));
        }
        decorativeListGridView.setAdapter(adapter);
    }
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
    public static CakeMakeingPageFragment CakeMakeingPageInstance() {
        return new CakeMakeingPageFragment();
    }
//    AdapterView.OnItemClickListener onItemClickListener = new AdapterView.OnItemClickListener() {
//        @Override
//        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//
//        }
//    };
}
