package hellschedule.hellschedule.ui.bottom_fragment;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import hellschedule.hellschedule.MainActivity;
import hellschedule.hellschedule.R;
import hellschedule.hellschedule.ui.fragment.Routine_Fragment_Slim;
import hellschedule.hellschedule.ui.fragment.StopWatch_Fragment120;
import hellschedule.hellschedule.ui.fragment.StopWatch_Fragment30;
import hellschedule.hellschedule.ui.fragment.StopWatch_Fragment60;

public class Bottom_StopWatchFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.bottom_stopwatch, container, false);
        //이미지 버튼 초기화 + corner_shape(라운드)
        ImageButton btn30 = (ImageButton)v.findViewById(R.id.btn30);
        ImageButton btn60 = (ImageButton)v.findViewById(R.id.btn60);
        ImageButton btn120 = (ImageButton)v.findViewById(R.id.btn120);
        btn30.setBackground(new ShapeDrawable(new OvalShape()));
        btn30.setClipToOutline(true);
        btn60.setBackground(new ShapeDrawable(new OvalShape()));
        btn60.setClipToOutline(true);
        btn120.setBackground(new ShapeDrawable(new OvalShape()));
        btn120.setClipToOutline(true);

        btn30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getActivity()로 MainActivity의 replaceFragment를 불러옵니다.
                // 새로 불러올 Fragment의 Instance를 Main으로 전달
                ((MainActivity) getActivity()).replaceFragment(StopWatch_Fragment30.newInstance());
            }
        });
        btn60.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getActivity()로 MainActivity의 replaceFragment를 불러옵니다.
                // 새로 불러올 Fragment의 Instance를 Main으로 전달
                ((MainActivity) getActivity()).replaceFragment(StopWatch_Fragment60.newInstance());
            }
        });
        btn120.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getActivity()로 MainActivity의 replaceFragment를 불러옵니다.
                // 새로 불러올 Fragment의 Instance를 Main으로 전달
                ((MainActivity) getActivity()).replaceFragment(StopWatch_Fragment120.newInstance());
            }
        });
        return v;
    }
}
