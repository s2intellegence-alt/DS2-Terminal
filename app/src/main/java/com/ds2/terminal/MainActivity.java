package com.ds2.terminal;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConstraintLayout layout = new ConstraintLayout(this);
        setContentView(layout);

        EditText inputField = new EditText(this);
        inputField.setHint("Enter Input");
        layout.addView(inputField);

        Button button = new Button(this);
        button.setText("Verify");
        button.setBackgroundColor(0xFF800000); // Maroon
        layout.addView(button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (inputField.getText().toString().equals("$trolz!81")) {
                    Toast.makeText(MainActivity.this, "Handshake Successful", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}

package com.ds2.terminal;
import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
}
