package hellschedule.hellschedule.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import hellschedule.hellschedule.R;
import hellschedule.hellschedule.ui.Activity.OCRActivity;
import hellschedule.hellschedule.ui.Activity.YouTubeActivity;
import hellschedule.hellschedule.ui.Database.Database;
import hellschedule.hellschedule.ui.Database.RecyclerViewAdapter;

public class Routine_Fragment_Slim extends Fragment {

    public static View view_Exercise_Fragment;
    public static RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter adapter;
    Database database;
    public static Context context_exercise;

    public ImageButton Exercise_youtube;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view_Exercise_Fragment =  inflater.inflate(R.layout.fragment_routine_db, container, false);

        context_exercise = getActivity().getApplicationContext();

        recyclerView = (RecyclerView) view_Exercise_Fragment.findViewById(R.id.recycler_view_main);
        layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true); // recyclerView 사이즈 고정

        //init DB
        database = new Database(getActivity().getApplicationContext());

        adapter = new RecyclerViewAdapter(getActivity().getApplicationContext(), database.get_Exercise_List1());
        recyclerView.setAdapter(adapter);


        return view_Exercise_Fragment;
    }

    //Activity 하위의 모든 Fragment들이 newInstance() 메소드를 가지고 있어야 화면 전환이 가능하다.
    public static Routine_Fragment_Slim newInstance() {
        return new Routine_Fragment_Slim();
    }
}
