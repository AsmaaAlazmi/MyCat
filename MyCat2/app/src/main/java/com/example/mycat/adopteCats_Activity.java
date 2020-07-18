package com.example.mycat;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class adopteCats_Activity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_adopte_cats_);

        ArrayList<Cats2> lostCats2 = new ArrayList<> ();

        Cats2 c1 = new Cats2 ("DlalFF", "انثى", " شهور 3", " 99850234", "شعر القط قصير و لونها ابيض مع خطوط سوداء و صفراء و هي من قطط الانقاذ", "ان يتم تطعيمها كاملا بعد التبني مع وجودها داخل المنزل و ارسال صورها كل شهر مره", "عدم توفر مكان لها", "بصحه ممتازه لكن لم يتم فحصها في البيطري", "لم يتم", " قط بلدي", "لم يتم",R.drawable.cat4);
        Cats2 c2 = new Cats2 ("Pepper", "ذكر", "سنة", "95550134 ", "قطه شيرازيه شعرها اسود و عيناها صفراء", "ان يكون المنزل خاليا من القطط ز الاطفال", " السفر خارج البلد", "حاليا في صحه جيده لكن تم تشخصيها بالفطريات سابقا لكن تم علاجها ", "تم", "شيرازي", "تم", R.drawable.cat5);
        Cats2 c4 = new Cats2 ("سوزي", "انثى", "سنتان", "58400049", "القطه لطيفه جدا و تحب الاطفال و تاكل جميع الاكل المعلب و اكل المنزل", "ان تكون القطه داخل المنزل و يكون المتبني اكبر من سن ال21", "السفر خارج البلد", "القطه صماء لا تسمع اما باقي صحتها فهي في اتم حاله", "لم يتم", "سيامي", "تم",  R.drawable.cat6);
        Cats2 c5 = new Cats2 ("Icey", "ذكر", "شهران", "58516549", "قط لون فرائه رمادي و عيون زرقاء و القط لعوب و حيوي", "ان يتم استكمال العلاج عند التبني مع ارسال صور كل اسبوعين", "وجود عدد كبير من القطط في المنزل", "فطريات خفيفة مع توفر العلاج", "تم", "Russian Blue", "لم يتم", R.drawable.cat7);

        lostCats2.add (c1);
        lostCats2.add (c2);
        lostCats2.add (c4);
        lostCats2.add (c5);

        Bundle b2 = getIntent().getExtras();
        if (b2!= null) {

            String phone2 = b2.getString ("data_phone2");
            String reason = b2.getString ("data_reason");
            String rules = b2.getString ("data_rules");
            String name2 = b2.getString ("data_name2");
            String health = b2.getString ("data_health");
            String breed2 = b2.getString ("data_breed2");
            String details2 = b2.getString ("data_details2");
            String age = b2.getString ("data_age");
            String gender = b2.getString ("data_gender");
            String check1 = b2.getString ("data_check1");
            String check2 = b2.getString ("data_check2");

            Cats2 c3 = new Cats2 (name2,gender,age,phone2,details2,rules,reason,health,check1,breed2,check2,R.drawable.empty);
            lostCats2.add (c3);
        }

        RecyclerView rv2 = findViewById (R.id.RecyclerView2);

        //ترتيب  ال recycel view
        rv2.setHasFixedSize (true);
        RecyclerView.LayoutManager lm2 = new LinearLayoutManager (this);
        rv2.setLayoutManager (lm2);

        adapter2 adapter2 = new adapter2 (lostCats2, this);
        rv2.setAdapter (adapter2);

    }
}