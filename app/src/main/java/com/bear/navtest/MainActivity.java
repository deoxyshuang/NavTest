package com.bear.navtest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navController = Navigation.findNavController(this,R.id.fragment);
        NavigationUI.setupActionBarWithNavController(this,navController); //開啟ActionBar的返回按鈕icon
    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp(); //返回上一頁
//        return super.onSupportNavigateUp();
    }
}