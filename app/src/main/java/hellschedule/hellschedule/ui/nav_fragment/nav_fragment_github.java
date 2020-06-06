package hellschedule.hellschedule.ui.nav_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import hellschedule.hellschedule.R;

public class nav_fragment_github extends Fragment {
    private WebView mwv;//mobile web view

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_github, container, false);

        mwv = (WebView) v.findViewById(R.id.github_fragment_webview);

        WebSettings mws=mwv.getSettings();//Mobile Web Setting
        mws.setJavaScriptEnabled(true);//자바스크립트 허용
        mws.setLoadWithOverviewMode(true);//컨텐츠가 웹뷰보다 클 경우 스크린 크기에 맞게 조정

        mwv.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        mwv.loadUrl("https://github.com/hanbinchoi/HellSchedule"); //헬스코리아 웹사이트 연동

        return v;
    }
}
