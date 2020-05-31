package hellschedule.hellschedule;

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
import hellschedule.hellschedule.ui.bottom_fragment.Bottom_StorageFragment;
import hellschedule.hellschedule.ui.bottom_fragment.Bottom_YoutubeFragment;

import hellschedule.hellschedule.ui.nav_fragment.nav_fragment_home;
import hellschedule.hellschedule.ui.nav_fragment.nav_fragment_gallery;
import hellschedule.hellschedule.ui.nav_fragment.nav_fragment_send;
import hellschedule.hellschedule.ui.nav_fragment.nav_fragment_share;
import hellschedule.hellschedule.ui.nav_fragment.nav_fragment_slideshow;
import hellschedule.hellschedule.ui.nav_fragment.nav_fragment_tools;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;

    // FrameLayout에 각 메뉴의 Fragment를 바꿔 줌
    public FragmentManager fragmentManager = getSupportFragmentManager();
    // 4개의 메뉴에 들어갈 Fragment들을 가져와 변수로 선언
    private Bottom_HomeFragment bottom_home_fragment = new Bottom_HomeFragment();
    private Bottom_ShopFragment bottom_shop_fragment = new Bottom_ShopFragment();
    private Bottom_StorageFragment bottom_storage_fragment = new Bottom_StorageFragment();
    private Bottom_YoutubeFragment bottom_youtube_fragment = new Bottom_YoutubeFragment();

    private nav_fragment_home nav_fragment_home = new nav_fragment_home();
    private nav_fragment_gallery nav_fragment_gallery = new nav_fragment_gallery();
    private nav_fragment_send nav_fragment_send = new nav_fragment_send();
    private nav_fragment_share nav_fragment_share = new nav_fragment_share();
    private nav_fragment_slideshow nav_fragment_slideshow = new nav_fragment_slideshow();
    private nav_fragment_tools nav_fragment_tools = new nav_fragment_tools();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Navigation drawer부분
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        // LeftNavigation
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send,R.id.nav_start)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        //BottomNav부분
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation_view);
        NavigationView LeftNavigationView = findViewById(R.id.nav_view);

        //FragmentTransaction transaction2 = fragmentManager.beginTransaction();
        //transaction2.replace(R.id.nav_host_fragment, nav_fragment_home).commitAllowingStateLoss();

        LeftNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transaction = fragmentManager.beginTransaction();
                switch (menuItem.getItemId()) {
                    case R.id.nav_home: {
                        transaction.replace(R.id.nav_host_fragment, nav_fragment_home).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.nav_gallery: {
                        transaction.replace(R.id.nav_host_fragment, nav_fragment_gallery).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.nav_send: {
                        transaction.replace(R.id.nav_host_fragment, nav_fragment_send).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.nav_share: {
                        transaction.replace(R.id.nav_host_fragment, nav_fragment_share).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.nav_slideshow: {
                        transaction.replace(R.id.nav_host_fragment, nav_fragment_slideshow).commitAllowingStateLoss();
                        break;
                    }
                    case R.id.nav_tools: {
                        transaction.replace(R.id.nav_host_fragment, nav_fragment_tools).commitAllowingStateLoss();
                        break;
                    }
                }
                return true;
            }
        });

        // 첫 화면 지정 replace를 통해 nav_host_fragment 에서 bottom_home_fragment에 해당화면 교체
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
                        transaction.replace(R.id.nav_host_fragment, bottom_storage_fragment).commitAllowingStateLoss();
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

    //Fragment화면 대체
    public void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.nav_host_fragment, fragment).commit();      // Fragment로 사용할 MainActivity내의 layout공간을 선택합니다.
    }
}
