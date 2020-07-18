package com.example.mycat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class sign_in_Activity extends AppCompatActivity {

    private Button register;
    private Button login;
    private EditText editTextUsername;
    private EditText editTextEmail;
    private EditText editTextPassword;
    private Button reset;

    /////////////////shared prefrences

    public SharedPreferences sharedPreferences;

    private static final String SHARED_PREF_NAME = "mypref";
    private static final String USERNAME = "username";
    private static final String EMAIL1 = "email";
    private static final String PASS = "pass";


      /////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_sign_in_);

        //// loading

        final LoadingDialog loadingDialog = new LoadingDialog (sign_in_Activity.this);

        ///////////////////////////


        reset = findViewById(R.id.reset_btn);
        editTextUsername = findViewById(R.id.UserName_EditText);
        editTextPassword = findViewById(R.id.Password_EditText);
        editTextEmail = findViewById(R.id.Email_EditText);
        register = findViewById(R.id.register_btn);
        login = findViewById(R.id.sign_in_btn);

        //////////////////////////////////// shared preference

        sharedPreferences = getSharedPreferences ("",MODE_PRIVATE);
        String nameee = sharedPreferences.getString (USERNAME,null);
        String emailadress = sharedPreferences.getString (EMAIL1,null);
        String passCode = sharedPreferences.getString (PASS,null);

/////////////////////////////////////////////////////////////////////////////////////

        login.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Toast.makeText(sign_in_Activity.this, "الحساب غير موجود",Toast.LENGTH_SHORT).show();

            }
        });

        register.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                if(editTextPassword.length ()<8){
                    editTextPassword.setError ("يجب ان تكون كلمة السر اكثر من 8 احرف");
                }
                else if(editTextEmail.length ()==0){
                    editTextEmail.setError ("ادخل البريد الالكتروني");
                }
                else if(editTextUsername.length ()==0){
                    editTextUsername.setError ("ادخل اسم المستخدم");
                }
                else {

                    SharedPreferences.Editor editor= sharedPreferences.edit ();
                    editor.putString (USERNAME,editTextUsername.getText ().toString ());
                    editor.putString (EMAIL1,editTextEmail.getText ().toString ());
                    editor.putString (PASS,editTextPassword.getText ().toString ());
                    editor.apply ();

                    Intent i = new Intent( sign_in_Activity.this, selection_A.class);


                    // loading
                    loadingDialog.StartLoadingDialog ();
                    Handler handler = new Handler ();
                    handler.postDelayed (new Runnable () {
                                             @Override
                                             public void run() {
                                                 loadingDialog.dismisDialog ();

                                             }
                                         }, 20000
                    );

                    startActivity (i);

                }

            }
        });
  ///////////////////reset button :
        reset.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                editTextUsername.setText ("");
                editTextEmail.setText ("");
                editTextPassword.setText ("");

            }
        });
   ////////////////////////////////////////////

    }

}