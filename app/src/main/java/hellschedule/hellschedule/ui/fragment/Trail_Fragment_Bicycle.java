package hellschedule.hellschedule.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import hellschedule.hellschedule.R;
import hellschedule.hellschedule.ui.Database.Database;
import hellschedule.hellschedule.ui.Database.RecyclerViewAdapter_Trail;

public class Trail_Fragment_Bicycle extends Fragment {

    public static View view_Trail_Fragment;
    public static RecyclerView recyclerView_trail;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter_Trail adapter;
    Database database;
    public static Context context_trail;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view_Trail_Fragment =  inflater.inflate(R.layout.fragment_trail_db, container, false);

        context_trail = getActivity().getApplicationContext();

        recyclerView_trail = (RecyclerView) view_Trail_Fragment.findViewById(R.id.recycler_view_trail);
        layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView_trail.setLayoutManager(layoutManager);
        recyclerView_trail.setHasFixedSize(true); // recyclerView 사이즈 고정

        //init DB
        database = new Database(getActivity().getApplicationContext());

        adapter = new RecyclerViewAdapter_Trail(getActivity().getApplicationContext(), database.get_Trail_List4());
        recyclerView_trail.setAdapter(adapter);

        return view_Trail_Fragment;
    }

    //Activity 하위의 모든 Fragment들이 newInstance() 메소드를 가지고 있어야 화면 전환이 가능하다.
    public static Trail_Fragment_Bicycle newInstance() {
        return new Trail_Fragment_Bicycle();
    }
}
