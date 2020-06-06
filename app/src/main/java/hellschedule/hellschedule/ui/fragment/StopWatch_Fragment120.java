package hellschedule.hellschedule.ui.fragment;

import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import hellschedule.hellschedule.MainActivity;
import hellschedule.hellschedule.R;

public class StopWatch_Fragment120 extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup v = (ViewGroup) inflater.inflate(R.layout.fragment_timer120, container, false);

        //region ImageView 형태의 splash GIF 변수를 만들고 Glide로 gif파일 불러오기
        ImageView splashGif = (ImageView)v.findViewById(R.id.timer120);
        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(splashGif);
        Glide.with(getContext()).load(R.raw.timer120).into(splashGif);

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

    //Activity 하위의 모든 Fragment들이 newInstance() 메소드를 가지고 있어야 화면 전환이 가능하다.
    public static StopWatch_Fragment120 newInstance() {
        return new StopWatch_Fragment120();
    }
}
