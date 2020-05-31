package hellschedule.hellschedule.ui.bottom_fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.makeramen.roundedimageview.RoundedImageView;

import hellschedule.hellschedule.MainActivity;
import hellschedule.hellschedule.R;
import hellschedule.hellschedule.ui.Activity.RoutineActivity;
import hellschedule.hellschedule.ui.fragment.Diet_Fragment;
import hellschedule.hellschedule.ui.fragment.OCR_Fragment;
import hellschedule.hellschedule.ui.fragment.Routine_Fragment;
import hellschedule.hellschedule.ui.fragment.Trail_Fragment;

public class Bottom_HomeFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Fragment로 불러올 xml파일을 view로 가져옵니다.
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.bottom_home, container, false);
        //버튼 객체 4개 생성
        RoundedImageView main_menu_button1 = (RoundedImageView) v.findViewById(R.id.main_menu1);
        RoundedImageView main_menu_button2 = (RoundedImageView) v.findViewById(R.id.main_menu2);
        RoundedImageView main_menu_button3 = (RoundedImageView) v.findViewById(R.id.main_menu3);
        RoundedImageView main_menu_button4 = (RoundedImageView) v.findViewById(R.id.main_menu4);
        // ImageButton을 Click할때 Fragment를 전환할 event를 정의한다.
        main_menu_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getActivity()로 MainActivity의 replaceFragment를 불러옵니다.
                // 새로 불러올 Fragment의 Instance를 Main으로 전달
                ((MainActivity) getActivity()).replaceFragment(Routine_Fragment.newInstance());
            }
        });
        main_menu_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replaceFragment(OCR_Fragment.newInstance());
            }
        });
        main_menu_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replaceFragment(Diet_Fragment.newInstance());
            }
        });
        main_menu_button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replaceFragment(Trail_Fragment.newInstance());
            }
        });
        return v;
    }

    public static Bottom_HomeFragment newInstance() {
        return new Bottom_HomeFragment();
    }
}
