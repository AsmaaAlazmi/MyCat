package com.example.mycat;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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

public class add_lostCats extends AppCompatActivity {

    public Button go ;
    public ImageView mChooseBtn;
    public ImageView mImageView;
    public EditText add_name;
    public EditText add_phoneNumber;
    public EditText add_area;
    public EditText add_blockAndStreet;
    public EditText add_Details;
    public EditText add_Breed;



    private static final int IMAGE_PICK_CODE = 1000;
    private static final int PERMISSION_CODE = 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_add_lost_cats);

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
                            Intent i = new Intent (add_lostCats.this,selection_A.class);
                            startActivity (i);
                        }
                        if(drawerItem.getIdentifier ()==2){
                            Intent i = new Intent (add_lostCats.this,adopte_add3.class);
                            startActivity (i);
                        }
                        if(drawerItem.getIdentifier ()==3){
                            Intent i = new Intent (add_lostCats.this,add_lostCats.class);
                            startActivity (i);
                        }
                        if(drawerItem.getIdentifier ()==4) {
                            Intent i = new Intent (add_lostCats.this, profile.class);
                            startActivity (i);
                        }
                        return false;
                    }
                })
                .build ();


        /////////////////////////////////////////////

        mImageView = findViewById (R.id.add_lost_image);
        mChooseBtn = findViewById (R.id.download_btn);


         add_name = findViewById (R.id.addLost_name_textView);
         add_phoneNumber = findViewById (R.id.addLost_phone_textView);
         add_area = findViewById (R.id.addLost_area_textView);
         add_blockAndStreet = findViewById (R.id.addLost_street_textView);
        go = findViewById (R.id.go4);
        add_Breed = findViewById (R.id.addLost_breed_textView);
        add_Details = findViewById (R.id.addLost_details_textViewCV);

////////////////////////////// button invisble //////////////////////////////

        add_name.addTextChangedListener (loginTextWatcher);
        add_blockAndStreet.addTextChangedListener(loginTextWatcher);
        add_area.addTextChangedListener(loginTextWatcher);
        add_phoneNumber.addTextChangedListener(loginTextWatcher);
        add_Breed.addTextChangedListener(loginTextWatcher);
        add_Details.addTextChangedListener(loginTextWatcher);


////////////////////////////////////////////////////
        mChooseBtn.setOnClickListener (new View.OnClickListener () {
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

        ///////////////////////////go

        go.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {

                if(add_phoneNumber.length ()<8) {
                    add_phoneNumber.setError ("رقم الهاتف غير صحيح");
                }else if(add_phoneNumber.length ()>8){
                    add_phoneNumber.setError ("رقم الهاتف غير صحيح");
                }
                else {
                Intent i = new Intent (add_lostCats.this, LostCats_Activity.class);

                Toast.makeText(add_lostCats.this, "تمت اضافة قطك",Toast.LENGTH_SHORT).show();

                i.putExtra("data_name",add_name.getText().toString());
                i.putExtra("data_phone",add_phoneNumber.getText().toString());
                i.putExtra("data_area",add_area.getText().toString());
                i.putExtra("data_block",add_blockAndStreet.getText().toString());
                i.putExtra("data_details",add_Details.getText().toString());
                i.putExtra("data_breed",add_Breed.getText().toString());


                startActivity (i); }
            }
        });
        ////////////////////////////////////////////
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

            mImageView.setImageURI (data.getData ());
        }
    }


    /////////////button visible

    private TextWatcher loginTextWatcher = new TextWatcher () {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String nameInput = add_name.getText().toString().trim();
            String areaInput = add_area.getText().toString().trim();
            String blockInput = add_blockAndStreet.getText().toString().trim();
            String phoneInput = add_phoneNumber.getText().toString().trim();
            String detailsInput = add_Details.getText().toString().trim();
            String breedInput = add_Breed.getText().toString().trim();

            go.setEnabled(!nameInput.isEmpty() && !areaInput.isEmpty()&& !blockInput.isEmpty()&& !phoneInput.isEmpty()
                    && !breedInput.isEmpty()&& !detailsInput.isEmpty());

        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
    //////////////////////////////////////////////////////////////////////

    }
