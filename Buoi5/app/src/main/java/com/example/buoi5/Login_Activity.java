package com.example.buoi5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class Login_Activity extends AppCompatActivity {
    List<User> userList;
    EditText userName;
    EditText passWord;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);
        loadData();
        button = (Button) findViewById(R.id.btnLogin);
        userName = (EditText)findViewById(R.id.username);
        passWord = (EditText)findViewById(R.id.password);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (userVerify()) {
                    finish();
                } else {
                    Toast toast = Toast.makeText(getApplicationContext(), "Login Failed", Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
    private void loadData() {
        Database database = new Database(getApplicationContext());
        userList = database.findAllUser();
    }
    private boolean userVerify() {
        String username = userName.getText().toString();
        String password = passWord.getText().toString();
        for (User user:
                userList) {
            if (user.getUserName().equals(username) &&
                    user.getPassWord().equals(password)) {
                return true;
            }
        }
        return false;
    }
}