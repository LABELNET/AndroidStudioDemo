package com.example.dmoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

	
	private Button button1;
	private TextView tv;
	private int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        button1=(Button) findViewById(R.id.button1);
        tv=(TextView) findViewById(R.id.textView1);
        
        button1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				tv.setText("我是desk"+i);
				i++;
			}
		});
    }
    
    
    
    
    
}
