package hellschedule.hellschedule;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;


import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;

import hellschedule.hellschedule.ui.bottom_fragment.Bottom_HomeFragment;
import hellschedule.hellschedule.ui.bottom_fragment.Bottom_ShopFragment;
import hellschedule.hellschedule.ui.bottom_fragment.Bottom_StopWatchFragment;
import hellschedule.hellschedule.ui.bottom_fragment.Bottom_SearchFragment;

import hellschedule.hellschedule.ui.nav_fragment.nav_fragment_help;
import hellschedule.hellschedule.ui.nav_fragment.nav_fragment_manual;
import hellschedule.hellschedule.ui.nav_fragment.nav_fragment_policy;
import hellschedule.hellschedule.ui.nav_fragment.nav_fragment_developer;
import hellschedule.hellschedule.ui.nav_fragment.nav_fragment_github;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    // FrameLayout에 각 메뉴의 Fragment를 바꿔 줌.
    public FragmentManager fragmentManager = getSupportFragmentManager();
    // 4개의 메뉴에 들어갈 Fragment들을 가져와 변수로 선언
    private Bottom_HomeFragment bottom_home_fragment = new Bottom_HomeFragment();
    private Bottom_ShopFragment bottom_shop_fragment = new Bottom_ShopFragment();
    private Bottom_StopWatchFragment bottom_stopWatchFragment = new Bottom_StopWatchFragment();
    private Bottom_SearchFragment bottom_youtube_fragment = new Bottom_SearchFragment();

    private nav_fragment_manual nav_fragment_manual = new nav_fragment_manual();
    private nav_fragment_policy nav_fragment_policy = new nav_fragment_policy();
    private nav_fragment_developer nav_fragment_developer = new nav_fragment_developer();
    private nav_fragment_github nav_fragment_github = new nav_fragment_github();
    private nav_fragment_help nav_fragment_help = new nav_fragment_help();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toolbar 설정1
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // LeftNavigation
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_manual, R.id.nav_policy,
                R.id.nav_github, R.id.nav_developer, R.id.nav_email,R.id.nav_start)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //BottomNav부분d
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        NavigationView LeftNavigationView = findViewById(R.id.nav_view);


        LeftNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (menuItem.getItemId()) {
                    case R.id.nav_manual: {
                        transaction.replace(R.id.nav_host_fragment, nav_fragment_manual).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.nav_policy: {
                        transaction.replace(R.id.nav_host_fragment, nav_fragment_policy).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.nav_email: {
                        Intent email = new Intent(Intent.ACTION_SEND);
                        email.setType("plain/text");
                        String[] address = {"email@address.com"};
                        email.putExtra(Intent.EXTRA_EMAIL, address);
                        email.putExtra(Intent.EXTRA_SUBJECT, "GachonSoftware@gachon.ac.kr");
                        email.putExtra(Intent.EXTRA_TEXT, "안녕하세요. 소프트웨어학과 15학번 강호동입니다. (내용 미리적을 수 있음)");
                        startActivity(email);
                        break;
                    }
                    case R.id.nav_developer: {
                        transaction.replace(R.id.nav_host_fragment, nav_fragment_developer).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.nav_help:{
                        transaction.replace(R.id.nav_host_fragment, nav_fragment_help).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.nav_github: {
                        transaction.replace(R.id.nav_host_fragment, nav_fragment_github).commitAllowingStateLoss();
                        break;
                    }
                }
                return true;
            }
        });

        // 첫 화면 지정 replace를 통해 nav_host_fragment 에서 bottom_home_fragment에 해당화면 교체21
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.nav_host_fragment, bottom_home_fragment).commitAllowingStateLoss();

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (menuItem.getItemId()){
                    case R.id.navigation_menu1: {
                        transaction.replace(R.id.nav_host_fragment, bottom_home_fragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_menu2: {
                        transaction.replace(R.id.nav_host_fragment, bottom_stopWatchFragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_menu3: {
                        transaction.replace(R.id.nav_host_fragment, bottom_youtube_fragment).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.navigation_menu4: {
                        transaction.replace(R.id.nav_host_fragment, bottom_shop_fragment).commitAllowingStateLoss();
                        break;
                    }
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    //Fragment 화면 전환
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment).commit();      // Fragment로 사용할 MainActivity내의 layout공간을 선택합니다.
    }
}
