package es.pymasde.blueterm;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

import es.pymasde.blueterm.data.Contract;
import es.pymasde.blueterm.data.DbHelper;

import static es.pymasde.blueterm.data.Contract.Entry.NAME;
import static es.pymasde.blueterm.data.Contract.Entry.NUMBER;
import static es.pymasde.blueterm.data.Contract.Entry.TABLE_NAME;
import static es.pymasde.blueterm.data.Contract.Entry._ID;

public class Register extends AppCompatActivity {

    EditText n1, n2, n3, n4, n5, num1, num2, num3, num4, num5, messaget;
    ArrayList<String> list = new ArrayList<String>();
    ArrayList<String> list1 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.contact_activity);

        n1 = findViewById(R.id.n1);
        n2 = findViewById(R.id.n2);
        n3 = findViewById(R.id.n3);
        n4 = findViewById(R.id.n4);
        n5 = findViewById(R.id.n5);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        num5 = findViewById(R.id.num5);

        messaget = findViewById(R.id.message_txt);

        String[] proj = {
                _ID, NAME, NUMBER};
        DbHelper mDbHelper = new DbHelper(this);
        SQLiteDatabase db = mDbHelper.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, proj, null, null, null, null, null);

        int idColumnIndex = cursor.getColumnIndex(_ID);
        int nameColumnIndex = cursor.getColumnIndex(NAME);
        int numberColumnIndex = cursor.getColumnIndex(NUMBER);

        while (cursor.moveToNext()) {
            int currentID = cursor.getInt(idColumnIndex);
            String getname = cursor.getString(nameColumnIndex);
            String getnumber = cursor.getString(numberColumnIndex);

            list.add(getnumber);
            list1.add(getname);
        }
//        System.out.println(list);

        if (list.size() != 0) {
            if (list.get(0) != null) {
                num1.setText(list.get(0));
                n1.setText(list1.get(0));
            }
            if (list.get(1) != null) {
                num2.setText(list.get(1));
                n2.setText(list1.get(1));
            }
            if (list.get(2) != null) {
                num3.setText(list.get(2));
                n3.setText(list1.get(2));
            }
            if (list.get(3) != null) {
                num4.setText(list.get(3));
                n4.setText(list1.get(3));
            }
            if (list.get(4) != null) {
                num5.setText(list.get(4));
                n5.setText(list1.get(4));
            }
        }

    }

    public void save_to_SqLite(View view) {
        String s1, s2, s3, s4, s5, sum1, sum2, sum3, sum4, sum5, msg;
        long newRowId = 0;
        s1 = n1.getText().toString().trim();
        s2 = n2.getText().toString().trim();
        s3 = n3.getText().toString().trim();
        s4 = n4.getText().toString().trim();
        s5 = n5.getText().toString().trim();

        sum1 = num1.getText().toString().trim();
        sum2 = num2.getText().toString().trim();
        sum3 = num3.getText().toString().trim();
        sum4 = num4.getText().toString().trim();
        sum5 = num5.getText().toString().trim();

        msg = messaget.getText().toString().trim();
        DbHelper Db = new DbHelper(Register.this);
        SQLiteDatabase db = Db.getWritableDatabase();

        SharedPreferences sharedpreferences = getSharedPreferences("prefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();

        if ((!s1.equals("")) && (!sum1.equals(""))) {
            ContentValues cv1 = new ContentValues();
            cv1.put(Contract.Entry.NAME, s1);
            cv1.put(Contract.Entry.NUMBER, sum1);
            if (list.size() == 0) {
                newRowId = db.insert(TABLE_NAME, null, cv1);
                editor.putString("one", sum1);
                list.add(sum1);
            } else {
                newRowId = db.update(Contract.Entry.TABLE_NAME, cv1, _ID + "=" + 1, null);
            }
        }

        System.out.println(newRowId);

        if ((!s2.equals("")) && (!sum2.equals(""))) {
            ContentValues cv2 = new ContentValues();
            cv2.put(Contract.Entry.NAME, s2);
            cv2.put(Contract.Entry.NUMBER, sum2);
            if (list.size() == 1) {
                newRowId = db.insert(TABLE_NAME, null, cv2);
                editor.putString("two", sum2);
                list.add(sum2);
            } else {
                newRowId = db.update(Contract.Entry.TABLE_NAME, cv2, _ID + "=" + 2, null);
            }
        }


        if ((!s3.equals("")) && (!sum3.equals(""))) {
            ContentValues cv3 = new ContentValues();
            cv3.put(Contract.Entry.NAME, s3);
            cv3.put(Contract.Entry.NUMBER, sum3);
            if (list.size() == 2) {
                newRowId = db.insert(TABLE_NAME, null, cv3);
                editor.putString("three", sum3);
                list.add(sum3);
            } else {
                newRowId = db.update(Contract.Entry.TABLE_NAME, cv3, _ID + "=" + 3, null);
            }
        }


        if ((!s4.equals("")) && (!sum4.equals(""))) {
            ContentValues cv4 = new ContentValues();
            cv4.put(Contract.Entry.NAME, s4);
            cv4.put(Contract.Entry.NUMBER, sum4);
            if (list.size() == 3) {
                newRowId = db.insert(TABLE_NAME, null, cv4);
                editor.putString("four", sum4);
                list.add(sum4);
            } else {
                newRowId = db.update(Contract.Entry.TABLE_NAME, cv4, _ID + "=" + 4, null);
            }
        }


        if ((!s5.equals("")) && (!sum5.equals(""))) {
            ContentValues cv5 = new ContentValues();
            cv5.put(Contract.Entry.NAME, s5);
            cv5.put(Contract.Entry.NUMBER, sum5);
            if (list.size() == 4) {
                newRowId = db.insert(TABLE_NAME, null, cv5);
                editor.putString("five", sum5);
                list.add(sum5);
            } else {
                newRowId = db.update(Contract.Entry.TABLE_NAME, cv5, _ID + "=" + 5, null);
            }
        }
        list = new ArrayList<String>();
        editor.commit();
        Toast.makeText(Register.this, "Saved", Toast.LENGTH_SHORT).show();
        finish();
    }

    public ArrayList<String> getNUMBERS() {

        ArrayList<String> list_to_be_send = new ArrayList<String>();

        /*String[] proj = {
                _ID, NAME, NUMBER};
        DbHelper Db1 = new DbHelper(Register.this);
        SQLiteDatabase db1 = Db1.getReadableDatabase();
        Cursor cursor = db1.query(TABLE_NAME, proj,null,null,null,null,null);

        int idColumnIndex = cursor.getColumnIndex(_ID);
        int nameColumnIndex = cursor.getColumnIndex(NAME);
        int numberColumnIndex = cursor.getColumnIndex(NUMBER);

        while(cursor.moveToNext()){
            int currentID = cursor.getInt(idColumnIndex);
            String getname = cursor.getString(nameColumnIndex);
            String getnumber = cursor.getString(numberColumnIndex);

            list_to_be_send.add(getnumber);
        }
        *//*Cursor cursor = getContentResolver().query(Contract.Entry.CONTENT_URI, proj, null, null, null);
        int numberColumnIndex = cursor.getColumnIndex(NUMBER);

        while(cursor.moveToNext()){
            String getnumber = cursor.getString(numberColumnIndex);
            list_to_be_send.add(getnumber);
        }*/
        list_to_be_send.add(PreferenceManager.getDefaultSharedPreferences(getBaseContext()).getString("one", "0000"));
        list_to_be_send.add(PreferenceManager.getDefaultSharedPreferences(getBaseContext()).getString("two", "0000"));
        list_to_be_send.add(PreferenceManager.getDefaultSharedPreferences(getBaseContext()).getString("three", "0000"));
        list_to_be_send.add(PreferenceManager.getDefaultSharedPreferences(getBaseContext()).getString("four", "0000"));
        list_to_be_send.add(PreferenceManager.getDefaultSharedPreferences(getBaseContext()).getString("five", "0000"));

        return list_to_be_send;
    }
}
