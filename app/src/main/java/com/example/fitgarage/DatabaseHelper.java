package com.example.fitgarage;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DBNAME = "FitGarage.db";

    public DatabaseHelper(Context context) {
        super(context, "FitGarage.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Users(user_id INTEGER PRIMARY KEY, username TEXT, email TEXT, password TEXT, fit_tokens INTEGER DEFAULT 0, dob TEXT DEFAULT '01 Jan 1990')");
        sqLiteDatabase.execSQL("CREATE TABLE Milestones(user_id INTEGER PRIMARY KEY, monday DECIMAL DEFAULT 0, tuesday DECIMAL DEFAULT 0, wednesday DECIMAL DEFAULT 0, thursday DECIMAL DEFAULT 0, friday DECIMAL DEFAULT 0, saturday DECIMAL DEFAULT 0, sunday DECIMAL DEFAULT 0)");
        sqLiteDatabase.execSQL("CREATE TABLE Rewards(user_id INTEGER PRIMARY KEY, monday INTEGER DEFAULT 0, tuesday INTEGER DEFAULT 0, wednesday INTEGER DEFAULT 0, thursday INTEGER DEFAULT 0, friday INTEGER DEFAULT 0, saturday INTEGER DEFAULT 0, sunday INTEGER DEFAULT 0, four_days INTEGER DEFAULT 0, seven_days INTEGER DEFAULT 0)");
        sqLiteDatabase.execSQL("CREATE TABLE Statistics(user_id INTEGER PRIMARY KEY, workouts_completed INTEGER DEFAULT 0, rewards_redeemed INTEGER DEFAULT 0, calories_burnt DECIMAL DEFAULT 0)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Users");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Milestones");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Rewards");
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Statistics");
        onCreate(sqLiteDatabase);
    }

    public Boolean insertUsersData(String username, String email, String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("username", username);
        contentValues.put("email", email);
        contentValues.put("password", password);

        long result = sqLiteDatabase.insert("Users", null, contentValues);

        if (result == -1) return false;
        else return true;
    }

    public Boolean checkUsername(String username) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Users WHERE username = ?", new String[] {username});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkUsernameById(String userid, String username) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Users WHERE username = ? AND user_id != ?", new String[] {username, userid});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkEmail(String email) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Users WHERE email = ?", new String[] {email});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkEmailById(String userid, String email) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Users WHERE email = ? AND user_id != ?", new String[] {email, userid});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public Boolean checkUsernamePassword(String username, String password) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Users WHERE username = ? AND password = ?", new String[] {username, password});
        if (cursor.getCount() > 0)
            return true;
        else
            return false;
    }

    public void insertUserId(String tableName, Integer userid) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("user_id", userid);

        sqLiteDatabase.insert(tableName, null, contentValues);
    }

    public Cursor getUserId(String username) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String[] projection = { "user_id" };
        String selection = "username" + " = ?";
        String[] selectionArgs = { username };

        return sqLiteDatabase.query("Users", projection, selection, selectionArgs, null, null, null);
    }

    public Cursor findDataById(String tableName, String[] projection, String userid) {
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();

        String selection = "user_id" + " = ?";
        String[] selectionArgs = { userid };

        return sqLiteDatabase.query(tableName, projection, selection, selectionArgs, null, null, null);
    }

    public void setDataById(String tableName, String columnName, String userid, String setValue) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        sqLiteDatabase.execSQL("UPDATE " + tableName + " SET " + columnName + " = ? WHERE user_id = ?", new String[] {setValue, userid});
        sqLiteDatabase.close();
    }

    public void incrementDataById(String tableName, String columnName, String userid, String incrementValue) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        sqLiteDatabase.execSQL("UPDATE " + tableName + " SET " + columnName + " = " + columnName  + " + ? WHERE user_id = ?", new String[] {incrementValue, userid});
        sqLiteDatabase.close();
    }

    public void decrementDataById(String tableName, String columnName, String userid, String decrementValue) {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        sqLiteDatabase.execSQL("UPDATE " + tableName + " SET " + columnName + " = " + columnName  + " - ? WHERE user_id = ?", new String[] {decrementValue, userid});
        sqLiteDatabase.close();
    }

    public void resetMilestonesRewardsData() {
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();

        sqLiteDatabase.execSQL("UPDATE Milestones SET monday = 0, tuesday = 0, wednesday = 0, thursday = 0, friday = 0, saturday = 0, sunday = 0");
        sqLiteDatabase.execSQL("UPDATE Rewards SET monday = 0, tuesday = 0, wednesday = 0, thursday = 0, friday = 0, saturday = 0, sunday = 0, four_days = 0, seven_days = 0");
        sqLiteDatabase.close();
    }
}