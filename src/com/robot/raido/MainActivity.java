package com.robot.raido;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        final BTConnector connector = new BTConnector(this);
        if (connector.init())
            connector.connect();
        else
            Toast.makeText(this, "Unable to find the other party", 
                           Toast.LENGTH_LONG).show();
        
		Button b = (Button)findViewById(R.id.btn_f);
		
        // setup button listeners
		b.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				connector.send((byte)119);
			}
		});       
		
        b = (Button)findViewById(R.id.btn_b);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                connector.send((byte)115);
            }
        });
            
        b = (Button)findViewById(R.id.btn_l);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                connector.send((byte)97);                
            }
        });
            
        b = (Button)findViewById(R.id.btn_r);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                connector.send((byte)100);                
            }
        });
        
        b = (Button)findViewById(R.id.btn_s);
        b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                connector.send((byte)32);
            }
        });
        
    }
}
