package hellschedule.hellschedule.ui.Activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import hellschedule.hellschedule.MainActivity;
import hellschedule.hellschedule.R;
import hellschedule.hellschedule.ui.fragment.Diet_Fragment;

public class CalorieActivity extends AppCompatActivity {
    private WebView mwv;//mobile web view

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calories);

        Intent intent = getIntent();
        int totalKcal = intent.getIntExtra("totalKcal",0);
        int carboKcal = intent.getIntExtra("carboKcal",0);
        int proteinKcal = intent.getIntExtra("proteinKcal",0);
        int fatKcal = intent.getIntExtra("fatKcal",0);

        TextView total = (TextView)findViewById(R.id.total);
        TextView carbo = (TextView)findViewById(R.id.carbo);
        TextView protein = (TextView)findViewById(R.id.protein);
        TextView fat = (TextView)findViewById(R.id.fat);

        total.setText(totalKcal + "Kcal");
        carbo.setText(carboKcal + "Kcal");
        protein.setText(proteinKcal + "Kcal");
        fat.setText(fatKcal + "Kcal");

        TextView carboG = (TextView)findViewById(R.id.carboG);
        TextView proteinG = (TextView)findViewById(R.id.proteinG);
        TextView fatG = (TextView)findViewById(R.id.fatG);

        carboG.setText("탄수화물 " + carboKcal/4 + "g");
        proteinG.setText("단백질 " + proteinKcal/4 + "g");
        fatG.setText("지방     " + fatKcal/9 + "g");


        Button reset = (Button)findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent1);
            }
        });

        mwv = (WebView) findViewById(R.id.calorie_webView);

        WebSettings mws=mwv.getSettings();//Mobile Web Setting
        mws.setJavaScriptEnabled(true);//자바스크립트 허용.
        mws.setLoadWithOverviewMode(true);//컨텐츠가 웹뷰보다 클 경우 스크린 크기에 맞게 조정1

        mwv.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        mwv.loadUrl("https://www.dietshin.com/calorie/calorie_main.asp"); //헬스코리아 웹사이트 연동
    }
}
