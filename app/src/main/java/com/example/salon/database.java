package com.example.salon;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class database extends SQLiteOpenHelper {



    public database(Context context) {
        super(context, "sallon.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE "+"login"+
                "("+"id"+"INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "username"+"Text,"+
                "password"+"Text);";

        String query1 = "CREATE TABLE "+"employee"+
                "("+"employee_id"+"INTEGER PRIMARY KEY AUTOINCREMENT,"+
                "name"+"Text,"+
                "salaire"+"Double"+
                "last_name"+"Text);";


        db.execSQL(query1);
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+"login");
        db.execSQL("DROP TABLE IF EXISTS "+"employee");
        db.execSQL("DROP TABLE IF EXISTS "+"branche");
    }
    public Boolean checkusernamepass (String username,String password){
        SQLiteDatabase db= this.getReadableDatabase();
        Cursor cursor  = db. rawQuery ( "select * from Login where user=? and Password=?", new String[] {username,password});
        if(cursor.getCount()>0)
            return true;
        else
            return false;
    }


    public void addemployee(String Name, String lastname, double salair) {

        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();

        values.put("name", Name);
        values.put("last_name", lastname);
        values.put("salaire", salair);



        db.insert("employee", null, values);
        db.close();
    }
    public void deleteemployee(String empname) {

        // on below line we are creating
        // a variable to write our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are calling a method to delete our
        // course and we are comparing it with our course name.
        db.delete("employee", "Resto_Name=?", new String[]{empname});
        db.close();
    }
    public ArrayList<employee> readEmplyee() {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor Cursor = db.rawQuery("SELECT * FROM " + "Resto", null);

        ArrayList<employee> RestoArrayList = new ArrayList<>();

        if (Cursor.moveToFirst()) {
            do {
                RestoArrayList.add(new employee(Cursor.getString(1),
                        Cursor.getString(2),
                        Cursor.getDouble(3)
                        ));
            } while (Cursor.moveToNext());
        }

        Cursor.close();
        return RestoArrayList;
    }
    public void updateemployee(String originalemployee, double salaire, String employeeprenom,String name) {

        // calling a method to get writable database.
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.

        values.put("name", name);
        values.put("salaire", salaire);
        values.put("last_name", employeeprenom);


        // on below line we are calling a update method to update our database and passing our values.
        // and we are comparing it with name of our course which is stored in original name variable.
        db.update("employee", values, "name=?", new String[]{originalemployee});
        db.close();
    }
}