package com.example.mycat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import info.hoang8f.android.segmented.SegmentedGroup;

public class adopte_add3 extends AppCompatActivity {

    public Button go2 ;
    public ImageView mChooseBtn2;
    public ImageView mImageView2;
    public EditText add_name2;
    public EditText add_phoneNumber2;
    public EditText add_age;
    public EditText add_Details2;
    public EditText add_Breed2;
    public EditText add_reason;
    public EditText add_rules;
    public EditText add_health;

    public RadioButton add_male;
    public RadioButton add_female;
    public RadioButton add_done1;
    public RadioButton add_Undone1;
    public RadioButton add_done2;
    public RadioButton add_Undone2;

   public SegmentedGroup sg ;
    public SegmentedGroup sg2;
    public SegmentedGroup sg3 ;

   String selected = "";
    String selected2 = "";
    String selected3= "";


    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_adopte_add3);

        ////////////////toolBar////////////////////

        Toolbar tool = findViewById (R.id.toolbar2);

        AccountHeader hr = new AccountHeaderBuilder ()
                .withActivity (this)
                .withHeaderBackground (R.color.weak)
                .addProfiles (new ProfileDrawerItem ().withName ("MyCat").withEmail ("your Gateway to a Purr-fect frienship").withIcon (R.drawable.logo_final))
                .build ();

        PrimaryDrawerItem item1 = new PrimaryDrawerItem ().withIdentifier(1).withName ("الصفحة الرئيسية ").withIcon (R.drawable.home);
        PrimaryDrawerItem item2 = new PrimaryDrawerItem ().withIdentifier (2).withName ("اضافة قط للتبني").withIcon (R.drawable.add);
        PrimaryDrawerItem item3 = new PrimaryDrawerItem ().withIdentifier (3).withName ("اضافة قط مفقود").withIcon (R.drawable.add);

        SecondaryDrawerItem item4 = new SecondaryDrawerItem ().withIdentifier (4).withName ("معلومات الحساب").withIcon (R.drawable.account);


        new DrawerBuilder ().withActivity (this)
                .withToolbar (tool)
                .withAccountHeader (hr)
                .addDrawerItems (item1)
                .addDrawerItems (new DividerDrawerItem ())
                .addDrawerItems (item2)
                .addDrawerItems (item3)
                .addDrawerItems (new DividerDrawerItem ())
                .addDrawerItems (item4)

                .withOnDrawerItemClickListener (new Drawer.OnDrawerItemClickListener () {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        if(drawerItem.getIdentifier ()==1){
                            Intent i = new Intent (adopte_add3.this,selection_A.class);
                            startActivity (i);
                        }
                        if(drawerItem.getIdentifier ()==2){
                            Intent i = new Intent (adopte_add3.this,adopte_add3.class);
                            startActivity (i);
                        }
                        if(drawerItem.getIdentifier ()==3){
                            Intent i = new Intent (adopte_add3.this,add_lostCats.class);
                            startActivity (i);
                        }
                        if(drawerItem.getIdentifier ()==4) {
                            Intent i = new Intent (adopte_add3.this, profile.class);
                            startActivity (i);
                        }
                        return false;
                    }
                })
                .build ();


        /////////////////////////////////////////////

        mImageView2 = findViewById (R.id.add_adopte_image);
        mChooseBtn2 = findViewById (R.id.mchoose_btn);
        go2 = findViewById (R.id.go3);


        add_Breed2 = findViewById (R.id.addAdopte_breed2_textView);
        add_name2 = findViewById (R.id.addAdopte_name_textView);
        add_Details2 = findViewById (R.id.addAdopte_details2_textView);
        add_health = findViewById (R.id.addAdopte_health_textView);
        add_rules = findViewById (R.id.addAdopte_rules_textView);
        add_phoneNumber2 = findViewById (R.id.addAdopte_phone2_textView);
        add_reason = findViewById (R.id.addAdopte_reason_textView);
        add_age = findViewById (R.id.addAdopte_age_textView);

        add_male = findViewById (R.id.male);
        add_female = findViewById (R.id.female);
        add_done1 = findViewById (R.id.done1);
        add_Undone1 = findViewById (R.id.unDone1);
        add_done2 = findViewById (R.id.done2);
        add_Undone2 = findViewById (R.id.unDone2);

        sg = findViewById (R.id.six1);
        sg2 = findViewById (R.id.six2);
        sg3 = findViewById (R.id.six3);


        add_female.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                selected="انثى";
            }
        });
        add_male.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                selected="ذكر";
            }
        });

        add_done1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                selected2="تم";
            }
        });
        add_Undone1.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                selected2="لم يتم";
            }
        });

        add_done2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                selected3="تم";
            }
        });
        add_Undone2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                selected3="لم يتم";
            }
        });

            ////////////////////////////////////////////////////

        mChooseBtn2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
                    if (checkSelfPermission (Manifest.permission.READ_EXTERNAL_STORAGE)
                            == PackageManager.PERMISSION_DENIED){
                        String[] permissions ={Manifest.permission.READ_EXTERNAL_STORAGE};

                        requestPermissions (permissions,PERMISSION_CODE);
                    }
                    else{
                        pickImageFromGallery();
                        ;
                    }

                }
                else {
                    pickImageFromGallery();

                }
            }
        });

        ///////////////////////////    go    ///////////////////////////////

        go2.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                if(add_phoneNumber2.length ()<8) {
                    add_phoneNumber2.setError ("رقم الهاتف غير صحيح");
                }else if(add_phoneNumber2.length ()>8){
                    add_phoneNumber2.setError ("رقم الهاتف غير صحيح");
                }
                else {

                Intent i = new Intent (adopte_add3.this, adopteCats_Activity.class);

                    Toast.makeText(adopte_add3.this, "تمت اضافة قطك للتبني",Toast.LENGTH_SHORT).show();

                i.putExtra("data_health",add_health.getText().toString());
                i.putExtra("data_reason",add_reason.getText().toString());
                i.putExtra("data_rules",add_rules.getText().toString());
                i.putExtra("data_breed2",add_Breed2.getText().toString());
                i.putExtra("data_name2",add_name2.getText().toString());
                i.putExtra("data_phone2",add_phoneNumber2.getText().toString());
                i.putExtra("data_age",add_age.getText().toString());
                i.putExtra("data_details2",add_Details2.getText().toString());
                i.putExtra("data_gender",selected);
                i.putExtra("data_check1",selected2);
                i.putExtra("data_check2",selected3);


                startActivity (i);}
            }
        });

        ///////////////////////////////////////////////////////////////////////
    }

    private void pickImageFromGallery() {
        Intent intent = new Intent (Intent.ACTION_PICK);
        intent.setType ("image/*");
        startActivityForResult (intent,IMAGE_PICK_CODE);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {





        switch(requestCode){
            case PERMISSION_CODE:{
                if(grantResults.length>0 && grantResults[0] ==
                        PackageManager.PERMISSION_GRANTED){

                    pickImageFromGallery ();
                }
                else {
                    Toast.makeText (this, "Permission was denied...!",Toast.LENGTH_SHORT).show();
                }
            }

        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult (requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == IMAGE_PICK_CODE) {

            mImageView2.setImageURI (data.getData ());
        }
    }


}