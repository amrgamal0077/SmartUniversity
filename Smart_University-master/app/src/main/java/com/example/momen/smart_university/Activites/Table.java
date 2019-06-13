package com.example.momen.smart_university.Activites;

import android.support.design.widget.TabItem;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.momen.smart_university.Adapter.PageAdapter;
import com.example.momen.smart_university.R;

public class Table extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);
        final TabLayout table =findViewById(R.id.tabLayout);
        TabItem sun =findViewById(R.id.sun);
        TabItem mon =findViewById(R.id.mon);
        TabItem tues =findViewById(R.id.tues);
        TabItem wed =findViewById(R.id.wed);
        TabItem thurs =findViewById(R.id.thurs);
        final ViewPager viewPager=findViewById(R.id.viewpager);
        String type = getIntent().getStringExtra("type");

        PageAdapter pageAdapter=new PageAdapter(getSupportFragmentManager(),table.getTabCount(),type);
        viewPager.setAdapter(pageAdapter);

        table.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {

                viewPager.setCurrentItem(tab.getPosition());

                if(tab.getPosition()==0)
                {
                    table.setBackgroundColor(ContextCompat.getColor(Table.this,R.color.colorPrimaryDark));

                }
                else if(tab.getPosition()==2)
                {
                    table.setBackgroundColor(ContextCompat.getColor(Table.this,R.color.colorPrimaryDark));

                }
                else if(tab.getPosition()==3)
                {
                    table.setBackgroundColor(ContextCompat.getColor(Table.this,R.color.colorPrimaryDark));
                }
                else
                {

                    table.setBackgroundColor(ContextCompat.getColor(Table.this,R.color.colorPrimaryDark));
                }

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        table.setupWithViewPager(viewPager);

    }
}
