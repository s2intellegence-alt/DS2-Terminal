package com.ds2.terminal;
import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.widget.*;
import android.view.Gravity;
import android.view.View;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.BLACK);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(50, 50, 50, 50);

        TextView header = new TextView(this);
        header.setText("DS2 TERMINAL v1.0\nSYSTEM ENCRYPTED");
        header.setTextColor(Color.GREEN);
        header.setTextSize(20);
        header.setGravity(Gravity.CENTER);
        layout.addView(header);

        final EditText input = new EditText(this);
        input.setHint("ENTER ACCESS KEY");
        input.setHintTextColor(Color.GRAY);
        input.setTextColor(Color.GREEN);
        input.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
        layout.addView(input);

        Button loginBtn = new Button(this);
        loginBtn.setText("AUTHENTICATE");
        loginBtn.setBackgroundColor(Color.DKGRAY);
        loginBtn.setTextColor(Color.GREEN);
        layout.addView(loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (input.getText().toString().equals("$trolz!81")) {
                    header.setText("ACCESS GRANTED\nWELCOME OPERATOR");
                    input.setVisibility(View.GONE);
                    v.setVisibility(View.GONE);
                } else {
                    Toast.makeText(MainActivity.this, "INVALID KEY", Toast.LENGTH_SHORT).show();
                }
            }
        });

        setContentView(layout);
    }
}
