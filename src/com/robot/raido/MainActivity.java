package com.robot.raido;

import android.app.*;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MainActivity extends Activity
{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		Button b = (Button)findViewById(R.id.btn_f);
		
		b.setOnClickListener(new View.OnClickListener() {
			public void onClick(View view) {
				
			}
		});
		
		BTConnector connector = new BTConnector(this);
		if (connector.init())
			connector.connect();
		else
			Toast.makeText(this, "Unable to find the other party", 
							Toast.LENGTH_LONG).show();
    }
}
