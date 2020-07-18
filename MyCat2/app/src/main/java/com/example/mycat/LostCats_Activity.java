package com.example.mycat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;     //STUFF
                              //STUFF (java)
public class LostCats_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_lost_cats_);

        ArrayList<Cats> lostCats = new ArrayList<> ();

        Cats c1 = new Cats("Vaato","حولي","3-7","212148164","عيناه زرقاء و عمره شهرين و لونه رمادي فاتح مع خطوط سوداء","amarican shorthair",R.drawable.cat2);
        Cats c2 = new Cats("Sokka","ardyiah","32-7","33568410","ذكر و لديه سن مكسور و لونه بني مع خطوط سوداء ","قط بلدي",R.drawable.cat1)  ;
        Cats c4 = new Cats("سكر","الفنطاس","53-9","99584702"," قطة انثى كبيره في السن فرائها لونه ابيض و عيناها لونهما عسلي", "مكس شيرازي و بلدي" ,R.drawable.cat3);
        Cats c5= new Cats("Shurl","الفردوس","5-1","57823664","قط بدون شعر و لون ظهره اسود و لون بطنه وردي و عليه طوق", "sphynix" ,R.drawable.cat8);

       lostCats.add(c1);
       lostCats.add(c2);
       lostCats.add (c4);
       lostCats.add (c5);


        Bundle b = getIntent().getExtras();
        if(b!=null) {
            String add_name = b.getString ("data_name");
            String add_phoneNumber = b.getString ("data_phone");
            String add_area = b.getString ("data_area");
            String add_blockAndStreet = b.getString ("data_block");
            String add_details = b.getString ("data_details");
            String add_breed = b.getString ("data_breed");
            Cats c3 = new Cats (add_name, add_area, add_blockAndStreet, add_phoneNumber, add_details, add_breed, R.drawable.empty);
            lostCats.add(c3);
        }

        RecyclerView rv = findViewById (R.id.RecyclerView);

        //ترتيب  ال recycel view
        rv.setHasFixedSize (true);
        RecyclerView.LayoutManager lm = new LinearLayoutManager (this);
        rv.setLayoutManager (lm);

        adapter adapter = new adapter(lostCats,this);
        rv.setAdapter (adapter);

    }


}