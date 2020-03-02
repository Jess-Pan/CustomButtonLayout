package com.android.custombuttonlayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    CustomButtonLayout customButtonLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        customButtonLayout = this.findViewById(R.id.test);
        customButtonLayout.setCenterLayoutOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.e("pzh", "pzh");
            }
        });

        customButtonLayout.setLeftLayoutOnClickListener(this);
        customButtonLayout.setRightLayoutOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Log.e("pzh", "pzh");
    }
}
