package com.example.fitgarage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class EditProfileActivity extends AppCompatActivity {

    Toolbar toolbar;
    EditText editTextUsername, editTextEmail;
    TextView textViewUserId, textViewDob;
    private DatePickerDialog datePickerDialog;
    DatabaseHelper db;

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "userpref";
    private static final String KEY_ID = "user_id";

    private static final String[] profile = {"username", "user_id", "dob", "email"};
    private String[] usersData = new String[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Back");
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back);

        initDatePicker();
        editTextUsername = (EditText) findViewById(R.id.et_username);
        textViewUserId = (TextView) findViewById(R.id.tv_user_id);
        textViewDob = (TextView) findViewById(R.id.tv_dob);
        editTextEmail = (EditText) findViewById(R.id.et_email);

        db = new DatabaseHelper(this);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);

        usersData = loadUsersData();
        updateEditProfileView(usersData);
    }

    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month + 1;
                String date = formatDateString(day, month, year);
                textViewDob.setText(date);
            }
        };

        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int style = AlertDialog.THEME_HOLO_LIGHT;

        datePickerDialog = new DatePickerDialog(this, style, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMaxDate(System.currentTimeMillis());
    }

    private String formatDateString(int day, int month, int year) {
        return day + " " + getMonthFormat(month) + " " + year;
    }

    private String getMonthFormat(int month) {
        if (month == 1)
            return "Jan";
        if (month == 2)
            return "Feb";
        if (month == 3)
            return "Mar";
        if (month == 4)
            return "Apr";
        if (month == 5)
            return "May";
        if (month == 6)
            return "Jun";
        if (month == 7)
            return "Jul";
        if (month == 8)
            return "Aug";
        if (month == 9)
            return "Sep";
        if (month == 10)
            return "Oct";
        if (month == 11)
            return "Nov";
        if (month == 12)
            return "Dec";

        return "Jan";
    }

    private String[] loadUsersData() {
        String userid = sharedPreferences.getString("user_id", null);

        Cursor cursor = db.findDataById("Users", profile, userid);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();

            for (int i = 0; i < usersData.length; i++) {
                usersData[i] = cursor.getString(i);
            }
        }
        else {
            Toast.makeText(EditProfileActivity.this, "No data found", Toast.LENGTH_SHORT).show();
        }

        return usersData;
    }

    private void updateEditProfileView(String usersData[]) {
        editTextUsername.setText(usersData[0]);
        textViewUserId.setText(usersData[1]);
        textViewDob.setText(usersData[2]);
        editTextEmail.setText(usersData[3]);
    }

    public void onTextViewDobClicked(View view) {
        datePickerDialog.show();
    }

    public void onButtonSaveClicked(View view) {
        String username = editTextUsername.getText().toString().trim();
        String userid = textViewUserId.getText().toString().trim();
        String dob = textViewDob.getText().toString().trim();
        String email = editTextEmail.getText().toString().trim();

        if (username.equals("") || dob.equals("") || email.equals("")) {
            Toast.makeText(EditProfileActivity.this, "Please enter all the fields", Toast.LENGTH_SHORT).show();
        }
        else if (!isEmailValid(email)) {
            Toast.makeText(EditProfileActivity.this, "Invalid email address", Toast.LENGTH_SHORT).show();
        }
        else {
            Boolean checkUsernameById = db.checkUsernameById(userid, username);
            Boolean checkEmailById = db.checkEmailById(userid, email);

            if (checkUsernameById == false && checkEmailById == false) {

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setCancelable(false);
                builder.setTitle("Edit Profile");
                builder.setMessage("Are you sure you want to save the changes you have made?");
                builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        db.setDataById("Users", "username", userid, username);
                        db.setDataById("Users", "dob", userid, dob);
                        db.setDataById("Users", "email", userid, email);
                        Toast.makeText(EditProfileActivity.this, "Saved successfully", Toast.LENGTH_SHORT).show();
                    }
                });
                builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                    }
                });

                AlertDialog dialog = builder.create();
                dialog.show();

            }
            else {
                Toast.makeText(EditProfileActivity.this, "Username or email already taken!", Toast.LENGTH_SHORT).show();
            }
        }
    }

}