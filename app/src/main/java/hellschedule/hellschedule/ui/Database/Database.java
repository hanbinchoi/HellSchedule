package hellschedule.hellschedule.ui.Database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteAssetHelper {
    private static final String DB_NAME= "Hellschedule_DB_Test6.db";
    private static final int DB_VER=1;
    public static Context context2;

    public Database(Context context) {
        super(context, DB_NAME, null, DB_VER);
        context2 = context;
    }

    //region Function get all Exercise List
    public List<Exercise_DB_list> get_Exercise_List1(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        //Make sure all is column name in your Table
        String[] sqlSelect={"Exercise_partial","Exercise_name", "Exercise_set","Exercise_image","Exercise_youtube"};
        //Make sure this is your table name
        String tableName="Biginning_level";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);
        List<Exercise_DB_list> result = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do {
                Exercise_DB_list exerciseList = new Exercise_DB_list();
                exerciseList.setExercise_partial(cursor.getString(cursor.getColumnIndex("Exercise_partial")));
                exerciseList.setExercise_name(cursor.getString(cursor.getColumnIndex("Exercise_name")));
                exerciseList.setExercise_set(cursor.getString(cursor.getColumnIndex("Exercise_set")));
                exerciseList.setExercise_image(cursor.getBlob(cursor.getColumnIndex("Exercise_image")));
                exerciseList.setExercise_youtube(cursor.getString(cursor.getColumnIndex("Exercise_youtube")));

                result.add(exerciseList);
            }while (cursor.moveToNext());
        }
        return result;
    }
    //endregion

    //region Function get all Exercise List
    public List<Exercise_DB_list> get_Exercise_List2(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        //Make sure all is column name in your Table
        String[] sqlSelect={"Exercise_partial","Exercise_name", "Exercise_set","Exercise_image","Exercise_youtube"};
        //Make sure this is your table name
        String tableName="Middle_level";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);
        List<Exercise_DB_list> result = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do {
                Exercise_DB_list exerciseList = new Exercise_DB_list();
                exerciseList.setExercise_partial(cursor.getString(cursor.getColumnIndex("Exercise_partial")));
                exerciseList.setExercise_name(cursor.getString(cursor.getColumnIndex("Exercise_name")));
                exerciseList.setExercise_set(cursor.getString(cursor.getColumnIndex("Exercise_set")));
                exerciseList.setExercise_image(cursor.getBlob(cursor.getColumnIndex("Exercise_image")));
                exerciseList.setExercise_youtube(cursor.getString(cursor.getColumnIndex("Exercise_youtube")));
                result.add(exerciseList);

            }while (cursor.moveToNext());
        }
        return result;
    }
    //endregion

    //region Function get all Exercise List
    public List<Exercise_DB_list> get_Exercise_List3(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        //Make sure all is column name in your Table
        String[] sqlSelect={"Exercise_partial","Exercise_name", "Exercise_set","Exercise_image","Exercise_youtube"};
        //Make sure this is your table name
        String tableName="High_level";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);
        List<Exercise_DB_list> result = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do {
                Exercise_DB_list exerciseList = new Exercise_DB_list();
                exerciseList.setExercise_partial(cursor.getString(cursor.getColumnIndex("Exercise_partial")));
                exerciseList.setExercise_name(cursor.getString(cursor.getColumnIndex("Exercise_name")));
                exerciseList.setExercise_set(cursor.getString(cursor.getColumnIndex("Exercise_set")));
                exerciseList.setExercise_image(cursor.getBlob(cursor.getColumnIndex("Exercise_image")));
                exerciseList.setExercise_youtube(cursor.getString(cursor.getColumnIndex("Exercise_youtube")));
                result.add(exerciseList);

            }while (cursor.moveToNext());
        }
        return result;
    }
    //endregion
////////////////////////////////////////////////////////////////////////////////////////////
    //region Function get all Exercise List
    public List<Trail_DB_list> get_Trail_List1(){
        SQLiteDatabase db2 = getReadableDatabase();
        SQLiteQueryBuilder qb2 = new SQLiteQueryBuilder();

        //Make sure all is column name in your Table
        String[] sqlSelect={"name","location", "course","image","distance"};
        //Make sure this is your table name
        String tableName="Trail_modern";
        qb2.setTables(tableName);
        Cursor cursor2 = qb2.query(db2, sqlSelect, null, null, null, null, null);
        List<Trail_DB_list> result = new ArrayList<>();
        if(cursor2.moveToFirst())
        {
            do {
                Trail_DB_list trailList = new Trail_DB_list();
                trailList.setTrail_name(cursor2.getString(cursor2.getColumnIndex("name")));
                trailList.setTrail_location(cursor2.getString(cursor2.getColumnIndex("location")));
                trailList.setTrail_course(cursor2.getBlob(cursor2.getColumnIndex("course")));
                trailList.setTrail_image(cursor2.getBlob(cursor2.getColumnIndex("image")));
                trailList.setTrail_distance(cursor2.getString(cursor2.getColumnIndex("distance")));

                result.add(trailList);
            }while (cursor2.moveToNext());
        }
        return result;
    }
    //endregion

    //region Function get all Exercise List
    public List<Trail_DB_list> get_Trail_List2(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        //Make sure all is column name in your Table
        String[] sqlSelect={"name","location", "distance","image","course"};
        //Make sure this is your table name
        String tableName="Trail_forest";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);
        List<Trail_DB_list> result = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do {
                Trail_DB_list trailList = new Trail_DB_list();
                trailList.setTrail_name(cursor.getString(cursor.getColumnIndex("name")));
                trailList.setTrail_location(cursor.getString(cursor.getColumnIndex("location")));
                trailList.setTrail_distance(cursor.getString(cursor.getColumnIndex("distance")));
                trailList.setTrail_image(cursor.getBlob(cursor.getColumnIndex("image")));
                trailList.setTrail_course(cursor.getBlob(cursor.getColumnIndex("course")));

                result.add(trailList);
            }while (cursor.moveToNext());
        }
        return result;
    }
    //endregion

    //region Function get all Exercise List
    public List<Trail_DB_list> get_Trail_List3(){
        SQLiteDatabase db2 = getReadableDatabase();
        SQLiteQueryBuilder qb2 = new SQLiteQueryBuilder();

        //Make sure all is column name in your Table
        String[] sqlSelect={"name","location", "course","image","distance"};
        //Make sure this is your table name
        String tableName="Trail_river";
        qb2.setTables(tableName);
        Cursor cursor2 = qb2.query(db2, sqlSelect, null, null, null, null, null);
        List<Trail_DB_list> result = new ArrayList<>();
        if(cursor2.moveToFirst())
        {
            do {
                Trail_DB_list trailList = new Trail_DB_list();
                trailList.setTrail_name(cursor2.getString(cursor2.getColumnIndex("name")));
                trailList.setTrail_location(cursor2.getString(cursor2.getColumnIndex("location")));
                trailList.setTrail_course(cursor2.getBlob(cursor2.getColumnIndex("course")));
                trailList.setTrail_image(cursor2.getBlob(cursor2.getColumnIndex("image")));
                trailList.setTrail_distance(cursor2.getString(cursor2.getColumnIndex("distance")));

                result.add(trailList);
            }while (cursor2.moveToNext());
        }
        return result;
    }
    //endregion

    //region Function get all Exercise List
    public List<Trail_DB_list> get_Trail_List4(){
        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        //Make sure all is column name in your Table
        String[] sqlSelect={"name","location", "distance","image","course"};
        //Make sure this is your table name
        String tableName="Trail_bike";
        qb.setTables(tableName);
        Cursor cursor = qb.query(db, sqlSelect, null, null, null, null, null);
        List<Trail_DB_list> result = new ArrayList<>();
        if(cursor.moveToFirst())
        {
            do {
                Trail_DB_list trailList = new Trail_DB_list();
                trailList.setTrail_name(cursor.getString(cursor.getColumnIndex("name")));
                trailList.setTrail_location(cursor.getString(cursor.getColumnIndex("location")));
                trailList.setTrail_distance(cursor.getString(cursor.getColumnIndex("distance")));
                trailList.setTrail_image(cursor.getBlob(cursor.getColumnIndex("image")));
                trailList.setTrail_course(cursor.getBlob(cursor.getColumnIndex("course")));

                result.add(trailList);
            }while (cursor.moveToNext());
        }
        return result;
    }
    //endregion


}
