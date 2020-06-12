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
import hellschedule.hellschedule.ui.Database.RecyclerViewAdapter;
import hellschedule.hellschedule.ui.Database.RecyclerViewAdapter_BMI;

public class BMI4_Fragment extends Fragment {

    public static View view_BMI_Exercise_Fragment;
    public static RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter_BMI adapter;
    Database database;
    public static Context context_bmi_exercise;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view_BMI_Exercise_Fragment =  inflater.inflate(R.layout.fragment_bmi_db, container, false);

        context_bmi_exercise = getActivity().getApplicationContext();

        recyclerView = (RecyclerView) view_BMI_Exercise_Fragment.findViewById(R.id.recycler_view_bmi);
        layoutManager = new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true); // recyclerView 사이즈 고정

        //init DB
        database = new Database(getActivity().getApplicationContext());

        adapter = new RecyclerViewAdapter_BMI(getActivity().getApplicationContext(), database.get_BMI4_List());
        recyclerView.setAdapter(adapter);

        return view_BMI_Exercise_Fragment;
    }

    //Activity 하위의 모든 Fragment들이 newInstance() 메소드를 가지고 있어야 화면 전환이 가능하다.
    public static BMI4_Fragment newInstance() {
        return new BMI4_Fragment();
    }
}
