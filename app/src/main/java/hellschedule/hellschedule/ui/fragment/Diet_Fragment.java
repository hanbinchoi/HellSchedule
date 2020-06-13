package hellschedule.hellschedule.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.makeramen.roundedimageview.RoundedImageView;

import hellschedule.hellschedule.MainActivity;
import hellschedule.hellschedule.R;

public class Diet_Fragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Fragment로 불러올 xml파일을 view로 가져옵니다.
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_diet, container, false);
        final ImageView background = (ImageView) v.findViewById(R.id.diet_change_imageview);

        final RoundedImageView diet_menu_button1 = (RoundedImageView) v.findViewById(R.id.diet_button1);
        final RoundedImageView diet_menu_button2 = (RoundedImageView) v.findViewById(R.id.diet_button2);
        final RoundedImageView diet_menu_button3 = (RoundedImageView) v.findViewById(R.id.diet_button3);
        final RoundedImageView diet_menu_button4 = (RoundedImageView) v.findViewById(R.id.diet_button4);
        final RoundedImageView diet_menu_button5 = (RoundedImageView) v.findViewById(R.id.diet_button5);
        final RoundedImageView diet_menu_button6 = (RoundedImageView) v.findViewById(R.id.diet_button6);
        diet_menu_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                background.setBackgroundResource(R.drawable.diet1);
            }
        });
        diet_menu_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                background.setBackgroundResource(R.drawable.diet2);
            }
        });
        diet_menu_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                background.setBackgroundResource(R.drawable.diet3);
            }
        });
        diet_menu_button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                background.setBackgroundResource(R.drawable.diet4);
            }
        });
        diet_menu_button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                background.setBackgroundResource(R.drawable.diet5);
            }
        });
        diet_menu_button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                background.setBackgroundResource(R.drawable.diet6);
            }
        });


        return v;
    }


    //Activity 하위의 모든 Fragment들이 newInstance() 메소드를 가지고 있어야 화면 전환이 가능하다.
    public static Diet_Fragment newInstance(){return new Diet_Fragment();}
}
