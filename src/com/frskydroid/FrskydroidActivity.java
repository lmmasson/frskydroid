package com.frskydroid;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import android.bluetooth.BluetoothAdapter;
import android.widget.Toast;
import android.content.Intent;
import android.bluetooth.BluetoothAdapter.*;



public class FrskydroidActivity extends Activity {
    /** Called when the activity is first created. */	          
    
    public int rx;
    public int tx;
    public int ad1;
    public int ad2;
    public BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        // Check for Bluetooth availability
        if (mBluetoothAdapter==null) {
        	Toast.makeText(this, "BlueTooth Not supported", Toast.LENGTH_LONG).show();
        	this.finish();
        	return; // necessary to be sure that finish will stop the activity now
        } else {
        	Toast.makeText(this, "BlueTooth ok", Toast.LENGTH_SHORT).show();	
        }

        // Check if bluetooth is enabled
        if (!mBluetoothAdapter.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, 2);
        }
        
    }
}