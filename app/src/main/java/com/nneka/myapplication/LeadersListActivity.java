package com.nneka.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import com.nneka.myapplication.ui.main.SectionsPagerAdapter;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class LeadersListActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private LinearLayoutManager LinearLayoutManager;
    private HRecyclerAdapter mListAdapter;
    private SRecyclerAdapter mSListAdapter;
    public List<LHours> mLHoursList;
    private List<LSkills> mLSkillsList;
    private RecyclerView mRecyclerViewSkills;
    private LinearLayoutManager LinearLayoutManagerS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaders_list);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager(),fra);
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);

        mRecyclerView = findViewById(R.id.recycler_tab);
        mRecyclerViewSkills = findViewById(R.id.recycler_tab_skills);


        initRV();



    }
    private void initRV(){
      LinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(LinearLayoutManager);
        mListAdapter = new HRecyclerAdapter(this,mLHoursList);



                RListService hService = ServiceBuilder.BuildService(RListService.class);
         Call<List<LHours>> hCall = hService.getHours();

        hCall.enqueue(new Callback<List<LHours>>() {
            @Override
            public void onResponse(Call<List<LHours>> call, Response<List<LHours>> response) {
                mLHoursList = response.body();
                mRecyclerView.setAdapter(mListAdapter);
             }

            @Override
            public void onFailure(Call<List<LHours>> call, Throwable throwable) {
                Snackbar.make(mRecyclerView,"Failed to retrieve data", Snackbar.LENGTH_LONG).show();

            }
        });


        LinearLayoutManagerS = new LinearLayoutManager(this);
        mRecyclerViewSkills.setLayoutManager(LinearLayoutManagerS);
        mSListAdapter = new SRecyclerAdapter(this,mLSkillsList);

        RListService sService = ServiceBuilder.BuildService(RListService.class);
        Call<List<LSkills>> sCall = sService.getSkills();

        sCall.enqueue(new Callback<List<LSkills>>() {
            @Override
            public void onResponse(Call<List<LSkills>> call, Response<List<LSkills>> response) {
                mLSkillsList = response.body();
                mRecyclerView.setAdapter(mSListAdapter);
            }

            @Override
            public void onFailure(Call<List<LSkills>> call, Throwable throwable) {
                Snackbar.make(mRecyclerView,"Failed to retrieve data", Snackbar.LENGTH_LONG).show();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater()
                inflater.inflate(R.menu.smenu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        item = findViewById(R.id.fill_form);
               fillForm();
        return super.onOptionsItemSelected(item);
    }

    private void fillForm() {
        Intent intent = new Intent(this,FormActivity.class);
        startActivity(intent);
    }
}