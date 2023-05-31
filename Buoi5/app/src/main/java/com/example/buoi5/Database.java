package com.example.buoi5;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Universe.db";
    public static String classTable = "Class";
    public static String studentTable = "Student";
    public static String userTable = "User";

    public static String idColumn = "id";
    public static String nameColumn = "name";
    public static String dobColumn = "dob";
    public static String imageSourceColumn = "imageSource";
    public static String userNameColumn = "userName";
    public static String passWordColumn = "passWord";

    public Database(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + classTable + "(" +
                idColumn + " text primary key, " +
                nameColumn + " text" +
                ")");
        sqLiteDatabase.execSQL("create table " + studentTable + "(" +
                idColumn + " text primary key, " +
                nameColumn + " text, " +
                dobColumn + " text, " +
                imageSourceColumn + " integer " +
                ")");
        sqLiteDatabase.execSQL("create table " + userTable + "(" +
                userNameColumn + " text primary key, " +
                passWordColumn + " text" +
                ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public boolean createClass(Classes _class){
        try {
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(idColumn, _class.getIdclass());
            contentValues.put(nameColumn, _class.getNameclass());
            return sqLiteDatabase.insert(classTable, null, contentValues) > 0;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean createStudent(Student student){
        try {
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(idColumn, student.getId());
            contentValues.put(nameColumn, student.getName());
            contentValues.put(dobColumn, student.getDob());
            contentValues.put(imageSourceColumn, student.getImage());
            return sqLiteDatabase.insert(studentTable, null, contentValues) > 0;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean createUser(User user){
        try {
            SQLiteDatabase sqLiteDatabase = getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put(userNameColumn, user.getUserName());
            contentValues.put(passWordColumn, user.getPassWord());
            return sqLiteDatabase.insert(userTable, null, contentValues) > 0;
        }
        catch (Exception e){
            return false;
        }
    }

    public List<Classes> findAllClasses(){
        List<Classes> classList = null;
        try {
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from " + classTable, null);
            if (cursor.moveToFirst()){
                classList = new ArrayList<>();
                do {
                    Classes _class = new Classes();
                    _class.setIdclass(cursor.getString(0));
                    _class.setNameclass(cursor.getString(1));
                    List<Student> studentList = findStudentsInClass(cursor.getString(0));
                    _class.setStuclass(3);
                    classList.add(_class);
                } while (cursor.moveToNext());
            }
        }
        catch (Exception e){
            classList = null;
        }
        return classList;
    }

    public List<Student> findAllStudents(){
        List<Student> studentList = null;
        try {
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from " + studentTable, null);
            if (cursor.moveToFirst()){
                studentList = new ArrayList<>();
                do {
                    Student student = new Student();
                    student.setId(cursor.getString(0));
                    student.setName(cursor.getString(1));
                    student.setDob(cursor.getString(2));
                    student.setImage(cursor.getInt(3));
                    studentList.add(student);
                } while (cursor.moveToNext());
            }
        }
        catch (Exception e){
            studentList = null;
        }
        return studentList;
    }

    public List<Student> findStudentsInClass(String classId) {
        List<Student> studentList = null;
        try {
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from " + studentTable, null);
            if (cursor.moveToFirst()) {
                studentList = new ArrayList<>();
                do {
                    Student student = new Student();
                    student.setId(cursor.getString(0));
                    student.setName(cursor.getString(1));
                    student.setDob(cursor.getString(2));
                    student.setImage(cursor.getInt(3));
                    studentList.add(student);
                } while (cursor.moveToNext());
            }
        }
        catch (Exception e) {
            studentList = null;
        }
        return studentList;
    }

    public List<User> findAllUser(){
        List<User> userList = null;
        try {
            SQLiteDatabase sqLiteDatabase = getReadableDatabase();
            Cursor cursor = sqLiteDatabase.rawQuery("select * from " + userTable, null);
            if (cursor.moveToFirst()){
                userList = new ArrayList<>();
                do {
                    User user = new User();
                    user.setUserName(cursor.getString(0));
                    user.setPassWord(cursor.getString(1));
                    userList.add(user);
                } while (cursor.moveToNext());
            }
        }
        catch (Exception e){
            userList = null;
        }
        return userList;
    }
}