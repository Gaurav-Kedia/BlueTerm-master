package es.pymasde.blueterm;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
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

        list = new ArrayList<String>();
        list.clear();
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
        cursor.close();
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
        SharedPreferences sharedpreferences = getApplicationContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        messaget.setText(sharedpreferences.getString("Send_message", null));

    }

    public void save_to_SqLite(View view) {
        String s1, s2, s3, s4, s5, sum1, sum2, sum3, sum4, sum5, msg;
        long newRowId = 0;
        ArrayList<String> updated_lists = new ArrayList<String>();
        updated_lists.clear();

        //list.clear();
        EmulatorView.list.clear();

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

        if (!sum1.substring(0, 3).equalsIgnoreCase("+91")) {
            sum1 = "+91" + sum1;
        }
        if (!sum2.substring(0, 3).equalsIgnoreCase("+91")) {
            sum2 = "+91" + sum2;
        }
        if (!sum3.substring(0, 3).equalsIgnoreCase("+91")) {
            sum3 = "+91" + sum3;
        }
        if (!sum4.substring(0, 3).equalsIgnoreCase("+91")) {
            sum4 = "+91" + sum4;
        }
        if (!sum5.substring(0, 3).equalsIgnoreCase("+91")) {
            sum5 = "+91" + sum5;
        }

        msg = messaget.getText().toString().trim();
        DbHelper Db = new DbHelper(Register.this);
        SQLiteDatabase db = Db.getWritableDatabase();

        if ((!s1.equals("")) && (!sum1.equals(""))) {
            ContentValues cv1 = new ContentValues();
            cv1.put(Contract.Entry.NAME, s1);
            cv1.put(Contract.Entry.NUMBER, sum1);
            if (list.size() == 0) {
                newRowId = db.insert(TABLE_NAME, null, cv1);
                list.add(sum1);
            } else {
                newRowId = db.update(Contract.Entry.TABLE_NAME, cv1, _ID + " = ?", new String[]{"1"});
                updated_lists.add(sum1);
            }
        }


        if ((!s2.equals("")) && (!sum2.equals(""))) {
            ContentValues cv2 = new ContentValues();
            cv2.put(Contract.Entry.NAME, s2);
            cv2.put(Contract.Entry.NUMBER, sum2);
            if (list.size() == 1) {
                newRowId = db.insert(TABLE_NAME, null, cv2);
                list.add(sum2);
            } else {
                newRowId = db.update(Contract.Entry.TABLE_NAME, cv2, _ID + " = ?", new String[]{"2"});
                updated_lists.add(sum2);
            }
        }


        if ((!s3.equals("")) && (!sum3.equals(""))) {
            ContentValues cv3 = new ContentValues();
            cv3.put(Contract.Entry.NAME, s3);
            cv3.put(Contract.Entry.NUMBER, sum3);
            if (list.size() == 2) {
                newRowId = db.insert(TABLE_NAME, null, cv3);
                list.add(sum3);
            } else {
                newRowId = db.update(Contract.Entry.TABLE_NAME, cv3, _ID + " = ?", new String[]{"3"});
                updated_lists.add(sum3);
            }
        }


        if ((!s4.equals("")) && (!sum4.equals(""))) {
            ContentValues cv4 = new ContentValues();
            cv4.put(Contract.Entry.NAME, s4);
            cv4.put(Contract.Entry.NUMBER, sum4);
            if (list.size() == 3) {
                newRowId = db.insert(TABLE_NAME, null, cv4);
                list.add(sum4);
            } else {
                newRowId = db.update(Contract.Entry.TABLE_NAME, cv4, _ID + " = ?", new String[]{"4"});
                updated_lists.add(sum4);
            }
        }


        if ((!s5.equals("")) && (!sum5.equals(""))) {
            ContentValues cv5 = new ContentValues();
            cv5.put(Contract.Entry.NAME, s5);
            cv5.put(Contract.Entry.NUMBER, sum5);
            if (list.size() == 4) {
                newRowId = db.insert(TABLE_NAME, null, cv5);
                list.add(sum5);
            } else {
                newRowId = db.update(Contract.Entry.TABLE_NAME, cv5, _ID + " = ?", new String[]{"5"});
                updated_lists.add(sum5);
            }
        }

        EmulatorView.list = new ArrayList<String>();
        EmulatorView.list.clear();
        if (list.size() == 5) {
            EmulatorView.list = (ArrayList<String>) list.clone();
        }
        if (updated_lists.size() == 5) {
            EmulatorView.list = (ArrayList<String>) updated_lists.clone();
        }
        list = new ArrayList<String>();
        list.clear();
        updated_lists = new ArrayList<String>();
        updated_lists.clear();

        Toast.makeText(Register.this, "Saved", Toast.LENGTH_SHORT).show();

        SharedPreferences sharedpreferences = getApplicationContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedpreferences.edit();
        editor.putString("Send_message", msg);
        EmulatorView.msg = msg;
        editor.apply();
        finish();
    }
}
