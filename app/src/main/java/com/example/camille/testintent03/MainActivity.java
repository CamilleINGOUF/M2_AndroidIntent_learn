package com.example.camille.testintent03;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button editButton;
    private Button validButton;

    private TextView proposedEdit;

    private EditText enteredValue;

    public static final int SEND_INIT = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editButton = findViewById(R.id.editButton);
        validButton = findViewById(R.id.validButton);
        proposedEdit = findViewById(R.id.proposedView);
        enteredValue = findViewById(R.id.enterText);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = enteredValue.getText().toString();
                if(str.equals(""))
                {
                    Toast.makeText(MainActivity.this,"No text entered",Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra("text_init",str);

                startActivityForResult(intent,SEND_INIT);
            }
        });

        validButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = proposedEdit.getText().toString();
                if(str.equals(""))
                {
                    Toast.makeText(MainActivity.this,"No proposed text.",Toast.LENGTH_SHORT).show();
                    return;
                }

                enteredValue.setText(str);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        String result = data.getStringExtra("text_result");
        proposedEdit.setText(result);
    }
}
