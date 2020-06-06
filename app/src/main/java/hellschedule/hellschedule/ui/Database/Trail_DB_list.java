package hellschedule.hellschedule.ui.Database;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Trail_DB_list {
    public String Trail_name;
    public String Trail_location;
    public Bitmap Trail_course;
    public Bitmap Trail_image;
    public String Trail_distance;
    public Trail_DB_list(String Trail_name, String Trail_location, Bitmap Trail_course, Bitmap Trail_image,String Trail_distance){
        this.Trail_name =Trail_name;
        this.Trail_location = Trail_location;
        this.Trail_course = Trail_course;
        this.Trail_image = Trail_image;
        this.Trail_distance = Trail_distance;
    }
    public Trail_DB_list(){ }

    public String getTrail_name(){ return Trail_name; }
    public void setTrail_name(String Trail_name){ this.Trail_name = Trail_name; }
    public String getTrail_location(){ return Trail_location; }
    public void setTrail_location(String Exercise_name){
        this.Trail_location = Exercise_name;
    }
    public String getTrail_distance(){
        return Trail_distance;
    }
    public void setTrail_distance(String Exercise_set){ this.Trail_distance = Exercise_set; }

    public Bitmap getTrail_image(){return Trail_image;}
    public void setTrail_image(byte[] Trail_image){
        byte[] image = Trail_image;
        Bitmap bm = BitmapFactory.decodeByteArray(image,0,image.length);
        this.Trail_image = bm;}

    public Bitmap getTrail_course(){return Trail_course;}
    public void setTrail_course(byte[] Trail_course){
        byte[] image = Trail_course;
        Bitmap bm2 = BitmapFactory.decodeByteArray(image,0,image.length);
        this.Trail_course = bm2;}
}
