package com.example.buoi5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<Classes> arrayList;
    ClassListAdapter adt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listclass);
        addData(); //Login bang UsernName: admin123   Password: admin123

        loadData();
        Intent i = new Intent(MainActivity.this, Login_Activity.class);
        startActivity(i);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent a = new Intent(getApplicationContext(),ClassDetailActivity.class);
                a.putExtra("class", arrayList.get(i));
                startActivity(a);
            }
        });
    }
    private void loadData() {
        Database database = new Database(getApplicationContext());
        arrayList = database.findAllClasses();
        if (arrayList != null) {
            listView.setAdapter(new ClassListAdapter(this, R.layout.listclasses, arrayList));
        }
    }

    private void addData() {
        Database database = new Database(getApplicationContext());
        if (database.findAllUser() == null) {
            database.createUser(new User("admin", "admin"));
        }
        if (database.findAllStudents() == null) {
            database.createStudent(new Student("Pham Thanh Tuong", "12/05/2003", "student01", R.drawable.profile));
            database.createStudent(new Student("Nguyen Thu Hong", "08/05/2003", "student02", R.drawable.profile));
            database.createStudent(new Student("Nguyen Trong Tin", "01/02/2003", "student03", R.drawable.profile));
        }
        if (database.findAllClasses() == null) {
            //adding Classes.
            database.createClass(new Classes("Class001", "Class001"));
            database.createClass(new Classes("Class002", "Class002"));
            database.createClass(new Classes("Class003", "Class003"));
        }
    }
}