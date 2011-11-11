package com.frskydroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class FrskydroidActivity extends Activity {
    /** Called when the activity is first created. */	          
    
    public int rx;
    public int tx;
    public int ad1;
    public int ad2;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}