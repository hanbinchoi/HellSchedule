package hellschedule.hellschedule.ui.Database;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BMI_DB_list {
    public String Exercise_partial;
    public String Exercise_name;
    public String Exercise_set;
    public Bitmap Exercise_image;

    public BMI_DB_list(String Exercise_partial, String Exercise_name, String Exercise_set, Bitmap Exercise_image){
        this.Exercise_partial=Exercise_partial;
        this.Exercise_name=Exercise_name;
        this.Exercise_set=Exercise_set;
        this.Exercise_image=Exercise_image;
    }

    public BMI_DB_list(){ }

    public String getExercise_partial(){ return Exercise_partial; }
    public void setExercise_partial(String Exercise_partial){ this.Exercise_partial = Exercise_partial; }

    public String getExercise_name(){ return Exercise_name; }
    public void setExercise_name(String Exercise_name){
        this.Exercise_name = Exercise_name;
    }

    public String getExercise_set(){
        return Exercise_set;
    }
    public void setExercise_set(String Exercise_set){ this.Exercise_set = Exercise_set; }

    public Bitmap getExercise_image(){return Exercise_image;}
    public void setExercise_image(byte[] Exercise_image){
        byte[] image = Exercise_image;
        Bitmap bm = BitmapFactory.decodeByteArray(image,0,image.length);
        this.Exercise_image = bm;}
}
