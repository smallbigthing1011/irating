package com.example.logbook4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.btncreate);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleClick();
            }
        });

    }
    private void handleClick() {
        EditText name = (EditText) findViewById(R.id.name);
        EditText type = (EditText) findViewById(R.id.type);
        EditText date = (EditText) findViewById(R.id.dateinput);
        EditText price = (EditText) findViewById(R.id.average);
        EditText service = (EditText) findViewById(R.id.service);
        EditText cleanliness = (EditText) findViewById(R.id.cleanliness);
        EditText food = (EditText) findViewById(R.id.food);
        EditText note = (EditText) findViewById(R.id.note);
        EditText reporter = (EditText) findViewById(R.id.reporter);

        String nameValue = name.getText().toString();
        String typeValue = type.getText().toString();
        String dateValue = date.getText().toString();
        String priceValue = price.getText().toString();
        String serviceValue = service.getText().toString();
        String cleanlinessValue = cleanliness.getText().toString();
        String foodValue = food.getText().toString();
        String noteValue = note.getText().toString();
        String reporterValue = reporter.getText().toString();
        String msg;
        msg = "Restaurant: " + nameValue + "\n" + "Type: " + typeValue + "\n" + "Visited: " + dateValue + "\n" + "Price: " + priceValue + "\n" + "Service: " + serviceValue + "\n" + "Cleanliness: " + cleanlinessValue + "\n" + "Food: " + foodValue + "\n" + "Note: " + noteValue + "\n" + "Reporter: " + reporterValue + "\n";
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        if(nameValue.isEmpty()||typeValue.isEmpty()||dateValue.isEmpty()||priceValue.isEmpty()||serviceValue.isEmpty()||cleanlinessValue.isEmpty()||foodValue.isEmpty()||reporterValue.isEmpty()) {
            msg = "Please check and fulfill the form";
            builder.setMessage(msg).setNegativeButton("Turn back", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
        } else if(!dateValue.matches("^\\d{4}\\-(0[1-9]|1[012])\\-(0[1-9]|[12][0-9]|3[01])$")){
            msg = "Date should be in form of yyyy-mm-dd";
            builder.setMessage(msg).setNegativeButton("Turn back", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
        } else {
            builder.setMessage(msg).setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast toast = Toast.makeText(MainActivity.this, "Successful!", Toast.LENGTH_LONG);
                    toast.show();
                    finish();
                }
            });
            builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });
        }
        AlertDialog al = builder.create();
        al.show();
    }
}

