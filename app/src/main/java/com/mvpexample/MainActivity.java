package com.mvpexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Contract.View{

    private EditText Email_ID, Password;
    private Button Login;

    private Contract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        presenter = new Presenter(this);

        Email_ID = findViewById(R.id.email_id);
        Password = findViewById(R.id.password);

        Login = findViewById(R.id.login);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email_id = Email_ID.getText().toString();
                String password = Password.getText().toString();

                if (!email_id.isEmpty()) {
                    if (!password.isEmpty()) {

                        presenter.onLogin(email_id, password);

                    }else {
                        //Toast.makeText(MainActivity.this, "Enter Password.", Toast.LENGTH_SHORT).show();
                        onError("Enter Password.");
                    }
                }else {
                    //Toast.makeText(MainActivity.this, "Enter Email ID.", Toast.LENGTH_SHORT).show();
                    onError("Enter Email ID.");
                }

            }
        });
    }

    @Override
    public void onSuccess(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}