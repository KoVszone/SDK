package com.vszone.ko.battlechannel.demo;

import cn.vszone.ko.tv.battle.channel.StartUpActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    
    public void onConfirmClick(View v){
        Intent intent = new Intent(this, StartUpActivity.class);
        
        startActivity(intent);
    }
}
