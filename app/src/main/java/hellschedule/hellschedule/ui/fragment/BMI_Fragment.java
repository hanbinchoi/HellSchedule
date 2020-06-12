package hellschedule.hellschedule.ui.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.makeramen.roundedimageview.RoundedImageView;

import hellschedule.hellschedule.MainActivity;
import hellschedule.hellschedule.R;

public class BMI_Fragment extends Fragment {

    ViewGroup v;
    //SharedPreferences를 이용하여 키,몸무게,bmi측정 결과값을 저장할 변수 선언.
    SharedPreferences sh_Pref;
    SharedPreferences.Editor toEdit;
    String s1;
    String s2;
    String s3;
    EditText bmi_height;
    EditText bmi_weight;
    TextView bmi_result;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = (ViewGroup) inflater.inflate(R.layout.fragment_bmi, container, false);

        bmi_height = (EditText) v.findViewById(R.id.edit_height); //EditText 키 연결
        bmi_weight = (EditText) v.findViewById(R.id.edit_weight); //EditText 몸무게 연결
        bmi_result = (TextView) v.findViewById(R.id.bmi_result); //TextView bmi결과 연결
        RoundedImageView bmi_search_button = (RoundedImageView) v.findViewById(R.id.bmi_search1);//bmi검색 이미지버튼 연결

        //bmi 검색 이미지 버튼을 클릭했을 때 이벤트
        bmi_search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //키, 몸무게 두개 중 하나라도 입력을 안했을 때 Toast메시지 출력해줌.
                if (bmi_height.getText().toString().equals("") ||
                        bmi_weight.getText().toString().equals("")) {
                    Toast.makeText(getActivity(),
                            "값이 없습니다.",
                            Toast.LENGTH_LONG).show();
                } else { //둘 다 공백이 아닐때
                    s1 = bmi_height.getText().toString();//1번 키 값 가져오기(xml->java)
                    s2 = bmi_weight.getText().toString();//2번 몸무게 값 가져오기(xml->java)
                    double result = Double.parseDouble(s2) / Math.pow(Double.parseDouble(s1) / 100, 2); //BMI result : 몸무게 / ( 키(m)**2 )
                    result = Math.round(result * 100) / 100.0; // Math의 round메소드로 소숫점 두 번째 자리 표현

                    if (result >= 0 && result < 18.5) {
                        bmi_result.setText(result + " 당신은 저체중 입니다.");
                        s3=bmi_result.getText().toString();
                        sharedPrefernces();
                    } else if (result >= 18.5 && result < 23) {
                        bmi_result.setText(result + " 당신은 정상체중 입니다.");
                        s3=bmi_result.getText().toString();
                        sharedPrefernces();
                    } else if (result >= 23 && result < 25) {
                        bmi_result.setText(result + " 당신은 과체중 입니다.");
                        s3=bmi_result.getText().toString();
                        sharedPrefernces();
                    } else if (result >= 25 && result < 30) {
                        bmi_result.setText(result + " 당신은 비만 입니다.");
                        s3=bmi_result.getText().toString();
                        sharedPrefernces();
                    } else {
                        bmi_result.setText(result + " 당신은 고도비만 입니다.");
                        s3=bmi_result.getText().toString();
                        sharedPrefernces();
                    }

                }
            }
        });

        //region 체중별 BMI 운동 루틴 버튼 객체 4개 생성
        RoundedImageView bmi_menu_button1 = (RoundedImageView) v.findViewById(R.id.bmi_button1);
        RoundedImageView bmi_menu_button2 = (RoundedImageView) v.findViewById(R.id.bmi_button2);
        RoundedImageView bmi_menu_button3 = (RoundedImageView) v.findViewById(R.id.bmi_button3);
        RoundedImageView bmi_menu_button4 = (RoundedImageView) v.findViewById(R.id.bmi_button4);

        bmi_menu_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // getActivity()로 MainActivity의 replaceFragment를 불러옵니다.
                // 새로 불러올 Fragment의 Instance를 Main으로 전달
                ((MainActivity) getActivity()).replaceFragment(BMI1_Fragment.newInstance());
            }
        });
        bmi_menu_button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replaceFragment(BMI2_Fragment.newInstance());
            }
        });
        bmi_menu_button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replaceFragment(BMI3_Fragment.newInstance());
            }
        });
        bmi_menu_button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity) getActivity()).replaceFragment(BMI4_Fragment.newInstance());
            }
        });
        //endregion
        applySharedPreference();
        return v;
    }

    //region Activity 하위의 모든 Fragment들이 newInstance() 메소드를 가지고 있어야 화면 전환이 가능하다.
    public static BMI_Fragment newInstance() {
        return new BMI_Fragment();
    }
    //endregion

    public void sharedPrefernces() {
        Context context = getActivity();
        sh_Pref = context.getSharedPreferences("Login Credentials", context.MODE_PRIVATE);
        toEdit = sh_Pref.edit();
        toEdit.putString("height", s1);
        toEdit.putString("weight", s2);
        toEdit.putString("bmi", s3);

        toEdit.commit();
    }

    public void applySharedPreference() {
        Context context = getActivity();
        sh_Pref = context.getSharedPreferences("Login Credentials", context.MODE_PRIVATE);
        if (sh_Pref != null && sh_Pref.contains("height") && sh_Pref.contains("weight")) {
            String height = sh_Pref.getString("height", "");
            String weight = sh_Pref.getString("weight", "");
            String bmi_screen = sh_Pref.getString("bmi", "");

            bmi_height.setText(height);
            bmi_weight.setText(weight);
            bmi_result.setText(bmi_screen);
        }
    }
}