package com.example.test;

import androidx.annotation.AnimRes;
import androidx.annotation.AnimatorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toolbar;

import org.w3c.dom.Text;

import java.util.zip.Inflater;

public class RegisterActivity extends AppCompatActivity {
    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView title = (TextView) findViewById(R.id.toolbar_title);
        title.setText("إنشاء حساب");
        Fragment fragment = new freeJobs();
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in,R.anim.fade_out).replace(R.id.main_container,fragment).
        addToBackStack(null).commit();
        i=1;
        Button free = (Button)findViewById(R.id.free_jobs);
        Button Companies = (Button)findViewById(R.id.company);
        Button employee = (Button)findViewById(R.id.employee);
        free.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new freeJobs();
                loadFragment(fragment);
            }
        });
        Companies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment company = new companies();
                loadFragment(company);
            }
        });
    }
    @Override
    public void onBackPressed(){
        if(i<=1){
            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            this.finish();
        }else{
            i--;
        }
    }
    public void loadFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().setCustomAnimations(R.anim.slide_in,R.anim.fade_out).replace(R.id.main_container,fragment).
                addToBackStack(null).commit();
        i++;
    }
}