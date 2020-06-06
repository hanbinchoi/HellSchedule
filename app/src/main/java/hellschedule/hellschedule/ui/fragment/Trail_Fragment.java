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

public class Trail_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Fragment로 불러올 xml파일을 view로 가져옵니다.
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_trail, container, false);
        //버튼 객체 3개 생성
        RoundedImageView trail_menu_button1 = (RoundedImageView) v.findViewById(R.id.trail_menu1);
        RoundedImageView trail_menu_button2 = (RoundedImageView) v.findViewById(R.id.trail_menu2);
        RoundedImageView trail_menu_button3 = (RoundedImageView) v.findViewById(R.id.trail_menu3);
        RoundedImageView trail_menu_button4 = (RoundedImageView) v.findViewById(R.id.trail_menu4);

        trail_menu_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getActivity()로 MainActivity의 replaceFragment를 불러옵니다.
                // 새로 불러올 Fragment의 Instance를 Main으로 전달
                ((MainActivity) getActivity()).replaceFragment(Trail_Fragment_Romantic.newInstance());
            }
        });
        trail_menu_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replaceFragment(Trail_Fragment_Hiking.newInstance());
            }
        });
        trail_menu_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replaceFragment(Trail_Fragment_Stream.newInstance());
            }
        });
        trail_menu_button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replaceFragment(Trail_Fragment_Bicycle.newInstance());
            }
        });
        return v;
    }
    //Activity 하위의 모든 Fragment들이 newInstance() 메소드를 가지고 있어야 화면 전환이 가능하다.
    public static Trail_Fragment newInstance() {
        return new Trail_Fragment();
    }
}
