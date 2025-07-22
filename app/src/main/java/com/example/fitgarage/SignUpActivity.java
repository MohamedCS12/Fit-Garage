package com.example.fitgarage;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    EditText editTextUsername, editTextEmail, editTextPassword, editTextRepassword;
    DatabaseHelper db;

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "userpref";
    private static final String KEY_ID = "user_id";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        editTextUsername = (EditText) findViewById(R.id.et_username);
        editTextEmail = (EditText) findViewById(R.id.et_email);
        editTextPassword = (EditText) findViewById(R.id.et_password);
        editTextRepassword = (EditText) findViewById(R.id.et_repassword);

        db = new DatabaseHelper(this);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
    }

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    public void onButtonRegisterClicked(View view) {

        String username = editTextUsername.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String repassword = editTextRepassword.getText().toString().trim();

        if (username.equals("") || email.equals("") || password.equals("") || repassword.equals("")) {
            Toast.makeText(SignUpActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
        }
        else if (!isEmailValid(email)) {
                Toast.makeText(SignUpActivity.this, "Invalid email address", Toast.LENGTH_SHORT).show();
        }
        else {
            if (password.equals(repassword)) {
                Boolean checkUsername = db.checkUsername(username);
                Boolean checkEmail = db.checkEmail(email);

                if (checkUsername == false && checkEmail == false) {
                    Boolean insert = db.insertUsersData(username, email, password);

                    if (insert == true) {
                        Toast.makeText(SignUpActivity.this, "Registered successfully", Toast.LENGTH_SHORT).show();

                        Cursor cursor = db.getUserId(username);
                        if (cursor.getCount() == 1) {
                            cursor.moveToFirst();
                            Integer userid = cursor.getInt(0);
                            db.insertUserId("Milestones", userid);
                            db.insertUserId("Rewards", userid);
                            db.insertUserId("Statistics", userid);

                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString(KEY_ID, String.valueOf(userid));
                            editor.apply();
                        }

                        Intent intent = new Intent(this, HomeActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(SignUpActivity.this, "Registration failed", Toast.LENGTH_SHORT).show();
                    }

                } else {
                    Toast.makeText(SignUpActivity.this, "User already exists! Please log in", Toast.LENGTH_SHORT).show();
                }

            } else {
                Toast.makeText(SignUpActivity.this, "Passwords not matching", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void onButtonExistingUserClicked(View view) {
        Intent intent = new Intent(this, LogInActivity.class);
        startActivity(intent);
    }

}