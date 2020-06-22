package hellschedule.hellschedule.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.makeramen.roundedimageview.RoundedImageView;

import java.util.StringTokenizer;

import hellschedule.hellschedule.MainActivity;
import hellschedule.hellschedule.R;
import hellschedule.hellschedule.ui.Activity.CalorieActivity;

public class Diet_Fragment extends Fragment {
    private final static String NOTES = "notes.txt";
    int sex;
    int age;
    double height_cm;
    double weight_kg;
    double totalKcal;
    String ratio;
    String perKcal;
    double carboKcal;
    double proteinKcal;
    double fatKcal;
    String[] selectSex = {"남자","여자"};

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

        final EditText heightField = (EditText)v.findViewById(R.id.height);
        final EditText weightField = (EditText)v.findViewById(R.id.weight);
        final EditText ageField = (EditText)v.findViewById(R.id.age);
        Button submit = (Button)v.findViewById(R.id.submit);

        //칼로리 계산 버튼 클릭 리스너
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int count = 0;

                if(heightField.getText().toString().length()==0)
                    Toast.makeText(getActivity(),"신장을 입력하세요",Toast.LENGTH_LONG).show();
                else
                {
                    count++;
                    height_cm = Integer.parseInt(heightField.getText().toString());
                }
                if(weightField.getText().toString().length()==0)
                    Toast.makeText(getActivity(),"몸무게를 입력하세요",Toast.LENGTH_LONG).show();
                else
                {
                    count++;
                    weight_kg = Integer.parseInt(weightField.getText().toString());
                }
                if(ageField.getText().toString().length()==0)
                    Toast.makeText(getActivity(),"나이를 입력하세요",Toast.LENGTH_LONG).show();
                else
                {
                    count++;
                    age = Integer.parseInt(ageField.getText().toString());
                }
                //전부 다 입력되면 칼로리 계산 페이지 열기
                if(count == 3){
                    //남자 기초대사량 계산식
                    if(sex == 0)
                        totalKcal = (66.47 + (13.75*weight_kg) + (5*height_cm)-(6.76*(double)age));
                    else
                        totalKcal = (655.1 + (9.56*weight_kg) + (1.85*height_cm)-(4.68*(double)age));
                    //마른사람일 경우 벌크업(기초대사량 + 300kcal, 비율은 탄:단:지 4:4:2)
                    if((double)(weight_kg/((double)height_cm/100*(double)height_cm/100))<18.5){
                        totalKcal += 300;
                        ratio = "4:4:2";
                    }
                    //비만일 경우 다이어트(기초대사량 - 500kcal, 비율은 탄:단:지 3:4:3)
                    else if((double)(weight_kg/((double)height_cm/100*(double)height_cm/100))>23){
                        totalKcal -= 500;
                        ratio = "3:4:3";
                    }
                    //보통체형인 경우 린매스업(기초대사량 + 200kcal, 비율은 탄:단:지 5:3:2)
                    else{
                        totalKcal += 200;
                        ratio = "5:3:2";
                    }
                    totalKcal = Math.floor(totalKcal);
                    perKcal = diet(totalKcal,ratio);
                    StringTokenizer st = new StringTokenizer(perKcal,":");
                    carboKcal = Math.round(Double.parseDouble(st.nextToken()));
                    proteinKcal = Math.round(Double.parseDouble(st.nextToken()));
                    fatKcal = Math.round(Double.parseDouble(st.nextToken()));
                    Intent intent = new Intent(getActivity(), CalorieActivity.class);
                    intent.putExtra("totalKcal",(int)totalKcal);
                    intent.putExtra("carboKcal",(int)carboKcal);
                    intent.putExtra("proteinKcal",(int)proteinKcal);
                    intent.putExtra("fatKcal",(int)fatKcal);

                    startActivity(intent);
                }
            }
        });
        Spinner spinner = (Spinner)v.findViewById(R.id.sex);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_item, selectSex);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                sex = position;
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
        //버튼 클릭 리스너
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
    //칼로리 계산 클래스
    public String diet(double totalKcal, String ratio){
        StringTokenizer st = new StringTokenizer(ratio,":");
        double carbo = Double.parseDouble(st.nextToken());
        double protein = Double.parseDouble(st.nextToken());
        double fat = Double.parseDouble(st.nextToken());
        double unit = (totalKcal/10);

        //탄단지 각각의 일일 섭취 kcal를 구분자 :로 리턴
        return (Double.toString(carbo*unit) + ":" + Double.toString(protein*unit) + ":" + Double.toString(fat*unit));
    }
    //Activity 하위의 모든 Fragment들이 newInstance() 메소드를 가지고 있어야 화면 전환이 가능하다.
    public static Diet_Fragment newInstance(){return new Diet_Fragment();}
}
