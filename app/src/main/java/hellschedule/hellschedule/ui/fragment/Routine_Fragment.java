package hellschedule.hellschedule.ui.fragment;

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

public class Routine_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Fragment로 불러올 xml파일을 view로 가져옵니다.
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_routine, container, false);

        //버튼 객체 3개 생성
        RoundedImageView routine_menu_button1 = (RoundedImageView) v.findViewById(R.id.routine_menu1);
        RoundedImageView routine_menu_button2 = (RoundedImageView) v.findViewById(R.id.routine_menu2);
        RoundedImageView routine_menu_button3 = (RoundedImageView) v.findViewById(R.id.routine_menu3);

        routine_menu_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getActivity()로 MainActivity의 replaceFragment를 불러옵니다.
                // 새로 불러올 Fragment의 Instance를 Main으로 전달
                ((MainActivity) getActivity()).replaceFragment(Routine_Fragment_Slim.newInstance());
            }
        });
        routine_menu_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replaceFragment(Routine_Fragment_Usual.newInstance());
            }
        });
        routine_menu_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replaceFragment(Routine_Fragment_Big.newInstance());
            }
        });
        return v;
    }




    //Activity 하위의 모든 Fragment들이 newInstance() 메소드를 가지고 있어야 화면 전환이 가능하다.
    public static Routine_Fragment newInstance() {
        return new Routine_Fragment();
    }
}
