package com.ds2.terminal;
import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.widget.TextView;
import android.view.Gravity;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView tv = new TextView(this);
        tv.setText("DS2 TERMINAL: ONLINE\nENTER KEY: $trolz!81");
        tv.setTextColor(Color.GREEN);
        tv.setBackgroundColor(Color.BLACK);
        tv.setTextSize(24);
        tv.setGravity(Gravity.CENTER);
        setContentView(tv);
    }
}
