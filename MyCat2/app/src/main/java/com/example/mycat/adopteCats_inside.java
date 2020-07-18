package com.example.mycat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
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

import de.hdodenhof.circleimageview.CircleImageView;

public class adopteCats_inside extends AppCompatActivity {

    private TextView done1_inside2;
    private TextView done2_inside2;
    private TextView reason_inside2;
    private TextView rules_inside2;
    private TextView health_inside2;
    private TextView phone_inside2;
    private TextView name_inside2;

    //phone call
    private static final int REQUEST_CALL = 1;


//////////////////////////////////////////////////////////////////

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_adopte_cats_inside);

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
                            Intent i = new Intent (adopteCats_inside.this,selection_A.class);
                            startActivity (i);
                        }
                        if(drawerItem.getIdentifier ()==2){
                            Intent i = new Intent (adopteCats_inside.this,adopte_add3.class);
                            startActivity (i);
                        }
                        if(drawerItem.getIdentifier ()==3){
                            Intent i = new Intent (adopteCats_inside.this,add_lostCats.class);
                            startActivity (i);
                        }
                        if(drawerItem.getIdentifier ()==4) {
                            Intent i = new Intent (adopteCats_inside.this, profile.class);
                            startActivity (i);
                        }
                        return false;
                    }
                })
                .build ();


        /////////////////////////////////////////////

        done1_inside2 = findViewById (R.id.resultsDone1_inside2);
        done2_inside2 = findViewById (R.id.resultsDone2_inside2);
        phone_inside2 = findViewById (R.id.phone_inside2);
        rules_inside2 = findViewById (R.id.rules_inside2);
        reason_inside2 = findViewById (R.id.reason_inside2);
        health_inside2 = findViewById (R.id.health_inside2);
        name_inside2 = findViewById (R.id.name_inside2);

        CircleImageView image_inside2 = findViewById (R.id.image_inside2);

        Bundle b2 = getIntent().getExtras();
        Cats2 p2 = (Cats2) b2.getSerializable ("Cats2");


        done1_inside2.setText (p2.getCheck1 ()+"");
        done2_inside2.setText (p2.getCheck2 ()+"");
        health_inside2.setText (p2.getHealth ()+"");
        rules_inside2.setText (p2.getRules ()+"");
        reason_inside2.setText (p2.getReason ()+"");
        phone_inside2.setText (p2.getNumber2 ()+"");
        name_inside2.setText (p2.getName2 ()+"");

        image_inside2.setImageResource (p2.getImage2 ());



//////////////////////////////    phone call //////////////////////////////////////////////////////

        ImageView imageCall2 = findViewById(R.id.call_btn2);

        imageCall2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePhoneCall();
            }
        });
    }
    private void makePhoneCall() {
        String number = phone_inside2.getText().toString();
        if (number.trim().length() > 0) {
            if (ContextCompat.checkSelfPermission(adopteCats_inside.this,
                    Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(adopteCats_inside.this,
                        new String[]{Manifest.permission.CALL_PHONE}, REQUEST_CALL);
            } else {
                String dial = "tel:" + number;
                startActivity(new Intent(Intent.ACTION_CALL, Uri.parse(dial)));
            }
        } else {
            Toast.makeText(adopteCats_inside.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
        }
//////////////////////////////////////////////////////////////////////////////////////////



    }

    ///////////////// phone call 2 //////////////

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_CALL) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                makePhoneCall();
            } else {
                Toast.makeText(this, "Permission DENIED", Toast.LENGTH_SHORT).show();
            }
        }
    }



    ///////////////////////////////////////////////////////
}