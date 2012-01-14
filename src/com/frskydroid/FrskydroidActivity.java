package com.frskydroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.bluetooth.BluetoothAdapter;
import android.widget.Toast;
import android.content.Intent;
import android.bluetooth.BluetoothAdapter.*;
import com.frskydroid.Print;

public class FrskydroidActivity extends Activity {
    /** Called when the activity is first created. */	          
    
	public static String TAG="FrskydroidActivity";
	
    public int rx;
    public int tx;
    public int ad1;
    public int ad2;
    public BluetoothAdapter mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

    private final static int REQUEST_ENABLE_BT = 1;
	
	
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
     
    	Log.v(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
    	Log.v(TAG, "Check for Bluetooth availability");
        if (mBluetoothAdapter==null) {
        	Toast.makeText(this, R.string.MSG_BT_not_supported, Toast.LENGTH_LONG).show();
        	Log.e(TAG, "Bluetooth not supported by device");
        	this.finish();
        	return; // necessary to be sure that finish will stop the activity now
        }

        Log.v(TAG, "Check if bluetooth is enabled");
        if (!mBluetoothAdapter.isEnabled()) {
            Log.v(TAG, "Lauch Bluetooth setting activity");
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT);
        }
        
    }
    
    public void setup() {
        Log.v(TAG, "setup");    	
        Toast.makeText(this, "setup", Toast.LENGTH_SHORT).show();    	
    }

	public void onActivityResult(int requestCode, int resultCode, Intent data) {
//	    if(D) Log.d(TAG, "onActivityResult " + resultCode);
	    switch (requestCode) {
	    case REQUEST_ENABLE_BT:
	        // When the request to enable Bluetooth returns
	        if (resultCode == Activity.RESULT_OK) {
	            // Bluetooth is now enabled, so set up a chat session
	            setup();
	        } else {
	            // User did not enable Bluetooth or an error occurred
//	            Log.d(TAG, "BT not enabled");
	            Toast.makeText(this, R.string.MSG_must_activate_BT, Toast.LENGTH_SHORT).show();
	            finish();
	        }
	    }
	}
}