package hellschedule.hellschedule.ui.Activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import hellschedule.hellschedule.MainActivity;
import hellschedule.hellschedule.R;

public class LoadingActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        //region ImageView 형태의 splash GIF 변수를 만들고 Glide로 gif파일 불러오기
        ImageView splashGif = (ImageView)findViewById(R.id.loading_gif);
        GlideDrawableImageViewTarget gifImage = new GlideDrawableImageViewTarget(splashGif);
        Glide.with(this).load(R.raw.loading_gif).into(splashGif);

        //startLoading함수 실행
        startLoading();
    }
    //region //startLoading함수 선언 및 Intent로 스플레쉬스크린 실행 후 메인으로 넘어가게하기
    private void startLoading() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run(){
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 5000);
    }//endregion
}
