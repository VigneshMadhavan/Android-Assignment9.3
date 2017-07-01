package com.example.vimadhavan.assignment93;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button saveBtn = (Button)findViewById(R.id.saveBtn);
        Button chkBtn = (Button)findViewById(R.id.checkBtn);

        saveBtn.setOnClickListener(this);
        chkBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){

            case R.id.saveBtn:
                SaveAction();
                break;
            case R.id.checkBtn:
                CheckAction();
                break;

        }

    }

    private void  SaveAction(){
        String fileName = "Assignment_9.2_File";
        String content = "Created by Vignesh";
        FileOutputStream outputStream = null;
        try {
            outputStream = openFileOutput(fileName, Context.MODE_PRIVATE);

            outputStream.write(content.getBytes());
            outputStream.close();
            Toast.makeText(MainActivity.this, "File Saved !!", Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void  CheckAction(){

        String path=getFilesDir().getAbsolutePath()+"/Assignment_9.2_File";
        File file = new File ( path );

        if (file.exists())
        {
            // Toast File is exists
            Toast.makeText(MainActivity.this, "File exist !!", Toast.LENGTH_SHORT).show();
        }
        else
        {
            // Toast File is not exists
            Toast.makeText(MainActivity.this, "File not exist !!", Toast.LENGTH_SHORT).show();
        }
    }
}
