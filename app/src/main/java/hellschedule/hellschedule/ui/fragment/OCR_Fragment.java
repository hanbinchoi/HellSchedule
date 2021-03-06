package hellschedule.hellschedule.ui.fragment;

import android.content.Context;
import android.content.Intent;
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

import hellschedule.hellschedule.R;
import hellschedule.hellschedule.ui.Activity.OCRActivity;

public class OCR_Fragment extends Fragment {
    Button Search_BMI_Image;
    ViewGroup v;
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
        v = (ViewGroup) inflater.inflate(R.layout.fragment_ocr, container, false);

        bmi_height = (EditText) v.findViewById(R.id.edit_height); //EditText 키 연결
        bmi_weight = (EditText) v.findViewById(R.id.edit_weight); //EditText 몸무게 연결
        bmi_result = (TextView) v.findViewById(R.id.bmi_result); //TextView bmi결과 연결
        RoundedImageView bmi_search_button = (RoundedImageView) v.findViewById(R.id.bmi_search1);//bmi검색 이미지버튼 연결

        //bmi 검색 이미지 버튼을 클릭했을 때 이벤트
        bmi_search_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //키, 몸무게 두개 중 하나라도 입력을 안했을 때 Toast메시지 출력해줌.
                if(bmi_height.getText().toString().equals("") ||
                        bmi_weight.getText().toString().equals("")) {
                    Toast.makeText(getActivity(),
                            "값이 없습니다.",
                            Toast.LENGTH_LONG).show();
                } else { //둘 다 공백이 아닐때
                    s1 = bmi_height.getText().toString();//1번 키 값 가져오기(xml->java)
                    s2 = bmi_weight.getText().toString();//2번 몸무게 값 가져오기(xml->java)
                    double result =  Double.parseDouble(s2) / Math.pow(Double.parseDouble(s1)/100,2); //BMI result : 몸무게 / ( 키(m)**2 )
                    result = Math.round(result*100)/100.0; // Math의 round메소드로 소숫점 두 번째 자리 표현



                    if (result>=0 && result<18.5) {
                        bmi_result.setText(result +" 당신은 저체중 입니다.");
                        s3=bmi_result.getText().toString();
                        sharedPrefernces();
                    }
                    else if (result>=18.5 && result<23){
                        bmi_result.setText(result+" 당신은 정상체중 입니다.");
                        s3=bmi_result.getText().toString();
                        sharedPrefernces();
                    }
                    else if (result>=23 && result<25){
                        bmi_result.setText(result+" 당신은 과체중 입니다.");
                        s3=bmi_result.getText().toString();
                        sharedPrefernces();
                    }
                    else if (result>=25 && result<30){
                        bmi_result.setText(result+" 당신은 비만 입니다.");
                        s3=bmi_result.getText().toString();
                        sharedPrefernces();
                    }
                    else{
                        bmi_result.setText(result+" 당신은 고도비만 입니다.");
                        s3=bmi_result.getText().toString();
                        sharedPrefernces();
                    }

                }

            }
        });

        //region OCR_Button만들기
        Search_BMI_Image = (Button)v.findViewById(R.id.search_bmi_image);
        Search_BMI_Image.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                //Search_BMI_Image 버튼을 클릭하면 OCR Activity로 화면전환이 된다.
                Intent intent = new Intent(getActivity() .getApplicationContext(), OCRActivity.class);
                startActivityForResult(intent,1);//보내고 난후의 인텐트에서 끝난 이벤트를 받는것
            }
        });
        //endregion

        applySharedPreference();

        return v;
    }
    //region OCR Result 값 가져오기
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView OCR_Text;
        TextView OCR_BMI_Result;

        //OCR Activity에서 String, Double로 BMI값을 받아줌.
        String BMI = data.getExtras().getString("BMI");
        Double BMI2 = Double.parseDouble(BMI);//String으로 받은 BMI값을 Dobule로 변경

        OCR_Text = (TextView) v.findViewById(R.id.OCR_ResultText);
        OCR_Text.setText("BMI 측정 결과 : " + BMI);

        //OCR 실행 결과 식별 된 BMI 값을 통해 현재 체중 상태를 나눠준다.
        OCR_BMI_Result = (TextView) v.findViewById(R.id.bmi_ocr_result);
        if (BMI2>=0 && BMI2<18.5) {
            OCR_BMI_Result.setText(" 당신은 저체중 입니다.");
        }
        else if (BMI2>=18.5 && BMI2<23){
            OCR_BMI_Result.setText(" 당신은 정상체중 입니다.");
        }
        else if (BMI2>=23 && BMI2<25){
            OCR_BMI_Result.setText(" 당신은 과체중 입니다.");
        }
        else if (BMI2>=25 && BMI2<30){
            OCR_BMI_Result.setText(" 당신은 비만 입니다.");
        }
        else{
            OCR_BMI_Result.setText(" 당신은 고도비만 입니다.");
        }
    }
    //endregion

    //region Activity 하위의 모든 Fragment들이 newInstance() 메소드를 가지고 있어야 화면 전환이 가능하다.
    public static OCR_Fragment newInstance() {return new OCR_Fragment();}
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
    public void applySharedPreference(){
        Context context = getActivity();
        sh_Pref = context.getSharedPreferences("Login Credentials", context.MODE_PRIVATE);
        if (sh_Pref!=null && sh_Pref.contains("height") && sh_Pref.contains("weight")){
            String height = sh_Pref.getString("height", "");
            String weight = sh_Pref.getString("weight", "");
            String bmi_screen = sh_Pref.getString("bmi", "");

            bmi_height.setText(height);
            bmi_weight.setText(weight);
            bmi_result.setText(bmi_screen);
        }
    }
}
