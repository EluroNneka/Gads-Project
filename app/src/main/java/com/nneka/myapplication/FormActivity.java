package com.nneka.myapplication;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class FormActivity extends AppCompatActivity {

    private TextView mFirstName;
    private TextView mLastName;
    private TextView mEmail;
    private TextView mLink;
    private Button mSubmit;
    private final String FORMURL = "https://doc.google.com/forms/d/e/";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        mFirstName =   findViewById(R.id.fname);
        mLastName =    findViewById(R.id.lname);
        mEmail = findViewById(R.id.email);
        mLink = findViewById(R.id.link);
        mSubmit = findViewById(R.id.submit_button);

        form();

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(this,);
                builder.setMessage(R.string.confirmation)
                        .setIcon()
                        .setPositiveButton(R.string.send,
                                new DialogInterface.OnClickListener(){
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        postForm();
                                    }
                                }).setOnCancelListener(new DialogInterface.OnCancelListener() {
                    @Override
                    public void onCancel(DialogInterface dialogInterface) {
                       dialogInterface.cancel();
                    }
                });
                AlertDialog dialog = new AlertDialog();
                       builder.create();
                       dialog.show();



                                ;



            }
        }){};
    }

    private void postForm() {
        RListService hService = ServiceBuilder.BuildService(RListService.class);
        Call<FormD> fCall = fService.sendFormD(FORMURL,
                mFirstName.getText().toString(),
                mLastName.getText().toString(),
                mEmail.getText().toString(),
                mLink.getText().toString());

        fCall.enqueue(new Callback<FormD>() {
            @Override
            public void onResponse(Call<FormD> call, Response<FormD> response) {
               successful();
            }

            @Override
            public void onFailure(Call<List<LHours>> call, Throwable throwable) {
               notSuccessful();
            }
        });

    }

    private void notSuccessful() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon().setMessage(R.string.fail);
        AlertDialog dialog = new AlertDialog();
        builder.create();
        dialog.show();
    }

    private void successful() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon().setMessage(R.string.success);
        AlertDialog dialog = new AlertDialog();
        builder.create();
        dialog.show();
    }

    private void form() {
        Intent intent = getIntent();


    }

}
