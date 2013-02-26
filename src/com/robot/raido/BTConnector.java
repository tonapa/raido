package com.robot.raido;
import android.bluetooth.*;
import java.util.*;
import java.io.*;
import android.widget.*;
import android.content.*;
import android.util.Log;

public class BTConnector {
    static String TAG = "BTConnector";
	static String BTNAME = "Nexus";
	
    BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
	BluetoothDevice device;
	BluetoothSocket socket;
	Context context;
	
	static UUID SPP_UUID = UUID.fromString(
		"00001101-0000-1000-8000-00805F9B34FB");
		
	public BTConnector(Context context) {
		this.context = context;
	}
	
	public boolean init(){
		Set<BluetoothDevice> devices = adapter.getBondedDevices();
		for (BluetoothDevice d : devices) {
			Toast.makeText(context,d.getName(),Toast.LENGTH_SHORT).show();
			if (d.getName().indexOf(BTNAME) != -1) {
				device = d;
			}
		}
		if (device == null) 
			return false;
		return true;
	}
	
	public boolean connect() {
		adapter.cancelDiscovery();
		try {
			socket = device.createInsecureRfcommSocketToServiceRecord(SPP_UUID);
            socket.connect();
		} catch (IOException e) {
			Toast.makeText(context,"Can't connect",Toast.LENGTH_LONG).show();
			Log.e(TAG, "Error connecting to robot");
			return false;
		}
		return true;
	}
	
	public void send(byte b) {
		try {
			socket.getOutputStream().write(b);
		} catch (IOException e) {
			Toast.makeText(context, "Command was not sent",
					Toast.LENGTH_SHORT);
		} catch (NullPointerException e) {
			Toast.makeText(context, "Not connected", 
					Toast.LENGTH_LONG);
		}
	}
}
