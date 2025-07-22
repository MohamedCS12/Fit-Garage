package com.example.fitgarage;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fitgarage.databinding.ActivityStoreBinding;

public class StoreActivity extends DrawerBaseActivity {

    ActivityStoreBinding activityStoreBinding;
    DatabaseHelper db;

    SharedPreferences sharedPreferences;
    private static final String SHARED_PREF_NAME = "userpref";
    private static final String KEY_ID = "user_id";

    private Button buttonRedeem1;
    private Button buttonRedeem2;
    private Button buttonRedeem3;
    private Button buttonRedeem4;

    private Integer fitTokens;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityStoreBinding = ActivityStoreBinding.inflate(getLayoutInflater());
        setContentView(activityStoreBinding.getRoot());
        allocatedActivityTitle("Store");

        db = new DatabaseHelper(this);
        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String userid = sharedPreferences.getString("user_id", null);
        fitTokens = loadFitTokensData(userid);

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Confirmation of Redemption");
        builder.setMessage("Are you sure you want to redeem this voucher?");
        builder.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                db.decrementDataById("Users", "fit_tokens", userid, "100");
                Toast.makeText(StoreActivity.this,"You have successfully claimed the voucher!",Toast.LENGTH_SHORT).show();
                dialog.dismiss();

                fitTokens = loadFitTokensData(userid);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int id) {
                Toast.makeText(StoreActivity.this,"Redemption has been canceled!",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        buttonRedeem1 = (Button) findViewById(R.id.btn_redeem_1);
        buttonRedeem1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fitTokens >= 100) {
                    dialog.show();
                }
                else
                    Toast.makeText(StoreActivity.this,"Insufficient FitTokens!",Toast.LENGTH_SHORT).show();
            }
        });

        buttonRedeem2 = (Button) findViewById(R.id.btn_redeem_2);
        buttonRedeem2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fitTokens >= 100) {
                    dialog.show();
                }
                else
                    Toast.makeText(StoreActivity.this,"Insufficient FitTokens!",Toast.LENGTH_SHORT).show();
            }
        });

        buttonRedeem3 = (Button) findViewById(R.id.btn_redeem_3);
        buttonRedeem3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fitTokens >= 100) {
                    dialog.show();
                }
                else
                    Toast.makeText(StoreActivity.this,"Insufficient FitTokens!",Toast.LENGTH_SHORT).show();
            }
        });

        buttonRedeem4 = (Button) findViewById(R.id.btn_redeem_4);
        buttonRedeem4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (fitTokens >= 100) {
                    dialog.show();
                }
                else
                    Toast.makeText(StoreActivity.this,"Insufficient FitTokens!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        finish();
        startActivity(intent);
    }

    private Integer loadFitTokensData(String userid) {
        Integer fitTokens = 0;

        Cursor cursor = db.findDataById("Users", new String[] {"fit_tokens"}, userid);
        if (cursor.getCount() == 1) {
            cursor.moveToFirst();
            fitTokens = cursor.getInt(0);
        }
        else {
            Toast.makeText(StoreActivity.this, "No data found", Toast.LENGTH_SHORT).show();
        }

        TextView textViewFitTokens = findViewById(R.id.tv_fit_tokens);
        textViewFitTokens.setText(String.valueOf(fitTokens));
        return fitTokens;
    }

}