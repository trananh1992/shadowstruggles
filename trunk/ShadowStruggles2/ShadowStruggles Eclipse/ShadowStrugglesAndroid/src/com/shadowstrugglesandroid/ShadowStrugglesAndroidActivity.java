package com.shadowstrugglesandroid;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.shadowstruggles.ShadowStruggles;

import android.os.Bundle;
import android.view.View;

public class ShadowStrugglesAndroidActivity extends AndroidApplication {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        initialize(new ShadowStruggles(), false);
    }
    
    public void clicar(View v){
    	
    }
}