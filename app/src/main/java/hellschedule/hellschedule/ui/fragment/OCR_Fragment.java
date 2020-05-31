package hellschedule.hellschedule.ui.fragment;

import android.content.Intent;
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
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v = (ViewGroup) inflater.inflate(R.layout.fragment_ocr, container, false);

        final EditText bmi_height = (EditText) v.findViewById(R.id.edit_height); //EditText 키 연결
        final EditText bmi_weight = (EditText) v.findViewById(R.id.edit_weight); //EditText 몸무게 연결
        final TextView bmi_result = (TextView) v.findViewById(R.id.bmi_result); //TextView bmi결과 연결
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
                    String s1 = bmi_height.getText().toString();//1번 키 값 가져오기(xml->java)
                    String s2 = bmi_weight.getText().toString();//2번 몸무게 값 가져오기(xml->java)
                    double result =  Double.parseDouble(s2) / Math.pow(Double.parseDouble(s1)/100,2);
                    result = Math.round(result*100)/100.0;

                    if (result>=0 && result<18.5) {
                        bmi_result.setText(result +" 당신은 저체중 입니다.");
                    }
                    else if (result>=18.5 && result<23){
                        bmi_result.setText(result+" 당신은 정상체중 입니다.");
                    }
                    else if (result>=23 && result<25){
                        bmi_result.setText(result+" 당신은 과체중 입니다.");
                    }
                    else if (result>=25 && result<30){
                        bmi_result.setText(result+" 당신은 비만 입니다.");
                    }
                    else{
                        bmi_result.setText(result+" 당신은 고도비만 입니다.");
                    }

                }

            }
        });

        //region OCR_Button만들기
        Search_BMI_Image = (Button)v.findViewById(R.id.search_bmi_image);
        Search_BMI_Image.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() .getApplicationContext(), OCRActivity.class);
                startActivityForResult(intent,1);//보내고 난후의 인텐트에서 끝난 이벤트를 받는것
            }
        });
        //endregion

        return v;
    }
    //region OCR Result 값 가져오기
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        TextView OCR_Text;
        //Intent intent2 = getIntent();
        String BMI = data.getExtras().getString("BMI");

        OCR_Text = (TextView) v.findViewById(R.id.OCR_ResultText);
        OCR_Text.setText("BMI 측정 결과 : " + BMI);
    }
    //endregion

    //region Activity 하위의 모든 Fragment들이 newInstance() 메소드를 가지고 있어야 화면 전환이 가능하다.
    public static OCR_Fragment newInstance() {return new OCR_Fragment();}
    //endregion
}
