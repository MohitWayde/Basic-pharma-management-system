package com.cws.pharma;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class MyDbHelper extends SQLiteOpenHelper {

    static String dbname = "pharmacy";
    String tbname = "pharm";
    String name = "name";
    String quantity = "quantity";
    String price = "price";

    static int dbversion = 1;


    public MyDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, dbname, factory, dbversion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "create table pharm(name varchar(100), quantity varchar(10),price varchar(20));";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query = "drop table pharm";
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);
    }

    public void addStudent(Student s) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(name, s.getName());
        values.put(quantity, s.getQuantity());
        values.put(price, s.getPrice());


        db.insert(tbname, null, values);
        db.close();
    }


    public Student findStudent(String ne) {
        SQLiteDatabase db = this.getReadableDatabase();
       // String query = "select * from pharm where name=" + ne ;
        Cursor c1 = db.rawQuery("select * from pharm where name= '"+ne+"'", null);
        Student s = new Student();

        if (c1 != null) {
            c1.moveToNext();
            s.setName(c1.getString(0));
            s.setQuantity(c1.getString(1));
            s.setPrice(c1.getString(2));
        }
        else{
                s=null;
        }

        db.close();
        return s;
    }


    public void deleteStudent(String nm){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tbname,name+"=?",new String[]{String.valueOf(nm)});
        db.close();
    }

    public boolean UpdateStudent(Student s) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(name,s.getName());
        cv.put(price,s.getPrice());
        db.update(tbname, cv, "name=?", new String[]{String.valueOf(s.getName())});
        db.close();
        return true;
    }


}
