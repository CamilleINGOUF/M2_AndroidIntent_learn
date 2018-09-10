package com.example.camille.testintent03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    public static final int RESULT = 2;

    private String strBuffer;
    private TextView textView;

    private Button upperButton;
    private Button reverseButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        upperButton = findViewById(R.id.uppercaseButton);
        reverseButton = findViewById(R.id.reverseButton);
        textView = findViewById(R.id.pendingText);

        Intent intent = getIntent();
        strBuffer = intent.getStringExtra("text_init");
        textView.setText(strBuffer);

        upperButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent tmpIntent = new Intent(SecondActivity.this,MainActivity.class);
                tmpIntent.putExtra("text_result",strBuffer.toUpperCase());
                setResult(RESULT, tmpIntent);
                finish();
            }
        });

        reverseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent tmpIntent = new Intent(SecondActivity.this,MainActivity.class);
                String tmpStr = new String("");

                for(char c : strBuffer.toCharArray())
                {
                    tmpStr = c + tmpStr;
                }

                tmpIntent.putExtra("text_result",tmpStr);
                setResult(RESULT, tmpIntent);
                finish();
            }
        });
    }
}
