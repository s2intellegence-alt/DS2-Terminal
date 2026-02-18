package com.ds2.terminal;
import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.*;
import android.view.*;

public class MainActivity extends Activity {
    private ScrollView scrollView;
    private TextView terminalOutput;
    private EditText commandInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showLoginScreen();
    }

    private void showLoginScreen() {
        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setBackgroundColor(Color.BLACK);
        layout.setGravity(Gravity.CENTER);
        layout.setPadding(50, 50, 50, 50);

        final TextView header = new TextView(this);
        header.setText("DS2 TERMINAL v1.1\nACCESS RESTRICTED");
        header.setTextColor(Color.GREEN);
        header.setTypeface(Typeface.MONOSPACE);
        header.setGravity(Gravity.CENTER);
        layout.addView(header);

        final EditText keyField = new EditText(this);
        keyField.setHint("ENTER KEY");
        keyField.setHintTextColor(Color.DKGRAY);
        keyField.setTextColor(Color.GREEN);
        keyField.setTransformationMethod(android.text.method.PasswordTransformationMethod.getInstance());
        layout.addView(keyField);

        Button authBtn = new Button(this);
        authBtn.setText("PROCEED");
        authBtn.setBackgroundColor(Color.parseColor("#111111"));
        authBtn.setTextColor(Color.GREEN);
        layout.addView(authBtn);

        authBtn.setOnClickListener(v -> {
            if (keyField.getText().toString().equals("$trolz!81")) {
                launchTerminal();
            } else {
                Toast.makeText(this, "DENIED", Toast.LENGTH_SHORT).show();
            }
        });
        setContentView(layout);
    }

    private void launchTerminal() {
        LinearLayout mainLayout = new LinearLayout(this);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setBackgroundColor(Color.BLACK);

        // Terminal Output Area
        scrollView = new ScrollView(this);
        terminalOutput = new TextView(this);
        terminalOutput.setText("--- DS2 CORE INITIALIZED ---\nType 'help' for commands\n\nroot@ds2:~# ");
        terminalOutput.setTextColor(Color.GREEN);
        terminalOutput.setTypeface(Typeface.MONOSPACE);
        terminalOutput.setPadding(20, 20, 20, 20);
        scrollView.addView(terminalOutput);
        
        LinearLayout.LayoutParams scrollParams = new LinearLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT, 0, 1.0f);
        mainLayout.addView(scrollView, scrollParams);

        // Command Input Area
        commandInput = new EditText(this);
        commandInput.setHint("Type command...");
        commandInput.setTextColor(Color.GREEN);
        commandInput.setBackgroundColor(Color.parseColor("#0A0A0A"));
        commandInput.setTypeface(Typeface.MONOSPACE);
        mainLayout.addView(commandInput);

        commandInput.setOnKeyListener((v, keyCode, event) -> {
            if ((event.getAction() == KeyEvent.ACTION_DOWN) && (keyCode == KeyEvent.KEYCODE_ENTER)) {
                processCommand(commandInput.getText().toString());
                commandInput.setText("");
                return true;
            }
            return false;
        });

        setContentView(mainLayout);
    }

    private void processCommand(String cmd) {
        String output = "\n" + cmd + "\n";
        switch (cmd.toLowerCase().trim()) {
            case "help":
                output += "AVAILABLE: status, clear, system_info, exit";
                break;
            case "status":
                output += "ALL SYSTEMS NOMINAL. UPLINK STABLE.";
                break;
            case "system_info":
                output += "HOST: S24_ULTRA_CORE\nOS: DS2-DROID-1.1\nKERNEL: SNAPDRAGON_8_GEN3";
                break;
            case "clear":
                terminalOutput.setText("root@ds2:~# ");
                return;
            default:
                output += "COMMAND NOT FOUND: " + cmd;
        }
        terminalOutput.append(output + "\n\nroot@ds2:~# ");
        scrollView.post(() -> scrollView.fullScroll(View.FOCUS_DOWN));
    }
}
