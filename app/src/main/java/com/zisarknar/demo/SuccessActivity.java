package com.zisarknar.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.facebook.accountkit.Account;
import com.facebook.accountkit.AccountKit;
import com.facebook.accountkit.AccountKitCallback;
import com.facebook.accountkit.AccountKitError;

public class SuccessActivity extends AppCompatActivity {

    private Button btnLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_success);

        btnLogout = findViewById(R.id.btnLogOut);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AccountKit.logOut();
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        AccountKit.getCurrentAccount(new AccountKitCallback<Account>() {
            @Override
            public void onSuccess(Account account) {
                TextView tvId, tvEmail, tvPhone;

                tvId = findViewById(R.id.tvId);
                tvId.setText("User Id is " + account.getId());

                tvEmail = findViewById(R.id.tvEmail);
                tvEmail.setText("User Email is " + account.getEmail());

                tvPhone = findViewById(R.id.tvPhone);
                tvPhone.setText("User Phone is " + account.getPhoneNumber());
            }

            @Override
            public void onError(AccountKitError accountKitError) {

            }
        });
    }
}
