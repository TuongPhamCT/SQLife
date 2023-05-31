package com.example.buoi5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ClassDetailActivity extends AppCompatActivity {
    private ListView lvSTD;
    TextView classid;
    TextView classname;
    TextView classStu;
    Classes _class;
    List<Student> Arr;
    StudentListAdapter adt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.class_detail_screen);
        lvSTD = (ListView) findViewById(R.id.listStu);
        classid = (TextView) findViewById(R.id.classid);
        classname = (TextView) findViewById(R.id.classname);
        classStu = (TextView) findViewById(R.id.classstudents);
        loadData();
    }
    private void loadData() {
        Intent intent = getIntent();
        _class = (Classes) intent.getSerializableExtra("class");

        if (_class != null) {
            classid.setText(_class.getIdclass());
            classname.setText(_class.getNameclass());
            classStu.setText(String.valueOf(_class.getStuclass()));
        }
        Database database = new Database(getApplicationContext());
        Arr = database.findStudentsInClass(_class.getIdclass());
        if (Arr != null) {
            lvSTD.setAdapter(new StudentListAdapter(getApplicationContext(), R.layout.liststudents, Arr));
        }
    }
}