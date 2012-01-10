package com.frskydroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.bluetooth.BluetoothAdapter;
import android.widget.Toast;


public class FrskydroidActivity extends Activity {
    /** Called when the activity is first created. */	          
    
    public int rx;
    public int tx;
    public int ad1;
    public int ad2;
    public BluetoothAdapter mBlueToothAdapter = BluetoothAdapter.getDefaultAdapter();
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        

        if (mBlueToothAdapter==null) {
        	Toast.makeText(this, "BlueTooth Not supported", Toast.LENGTH_LONG).show();
        } else {
        	Toast.makeText(this, "BlueTooth ok", Toast.LENGTH_SHORT).show();	
        }
    }
}