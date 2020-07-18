package com.example.mycat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.ProfileDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;


public class selection_A extends AppCompatActivity {

    public Button adopte;
    public Button lost;
    public Button charity;
    public TextView nameWelcome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_selection_);

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
                            Intent i = new Intent (selection_A.this,selection_A.class);
                            startActivity (i);
                        }
                        if(drawerItem.getIdentifier ()==2){
                            Intent i = new Intent (selection_A.this,adopte_add3.class);
                            startActivity (i);
                        }
                        if(drawerItem.getIdentifier ()==3){
                            Intent i = new Intent (selection_A.this,add_lostCats.class);
                            startActivity (i);
                        }
                        if(drawerItem.getIdentifier ()==4) {
                            Intent i = new Intent (selection_A.this, profile.class);
                            startActivity (i);
                        }
                        return false;
                    }
                })
                .build ();


        /////////////////////////////////////////////

         adopte = findViewById (R.id.adopte_cat_btn);
         lost = findViewById (R.id.lost_cat_btn);
         charity = findViewById (R.id.charity_cat_btn);

        nameWelcome = findViewById (R.id.UserNameApper_textView);


        ////////////////////////////////////////////////////////////


        adopte.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (selection_A.this, adopteCats_Activity.class);
                startActivity (i);
            }
        });

        lost.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (selection_A.this, LostCats_Activity.class);
                startActivity (i);
            }
        });

        charity.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                Intent i = new Intent (selection_A.this, HelpCats_Activity.class);
                startActivity (i);
            }
        });


    }




}
