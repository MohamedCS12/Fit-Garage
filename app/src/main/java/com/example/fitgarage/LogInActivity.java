package com.example.fitgarage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LogInActivity extends AppCompatActivity {

    EditText editTextUsername, editTextPassword;
    DatabaseHelper db;

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "userpref";
    private static final String KEY_ID = "user_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        editTextUsername = (EditText) findViewById(R.id.et_username);
        editTextPassword = (EditText) findViewById(R.id.et_password);

        db = new DatabaseHelper(this);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
    }

    public void onButtonLogInClicked(View view) {

        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();

        if (username.equals("") || password.equals(""))
            Toast.makeText(LogInActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
        else {
            Boolean checkUsernamePassword = db.checkUsernamePassword(username, password);

            if (checkUsernamePassword == true) {
                Toast.makeText(LogInActivity.this, "Log in successful", Toast.LENGTH_SHORT).show();

                Cursor cursor = db.getUserId(username);
                if (cursor.getCount() == 1) {
                    cursor.moveToFirst();
                    Integer userid = cursor.getInt(0);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString(KEY_ID, String.valueOf(userid));
                    editor.apply();
                }

                Intent intent = new Intent(this, HomeActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(LogInActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
            }
        }
    }

}