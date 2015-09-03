package com.sajal.astha;



import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class Main extends ActionBarActivity {

	
	DatabaseHelper dbHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		dbHelper = new DatabaseHelper(this);
		
		Button bt_admin = (Button)findViewById(R.id.bt_Admin);
		Button bt_ccm = (Button)findViewById(R.id.bt_Ccm);
		Button bt_user = (Button)findViewById(R.id.bt_User);
		bt_admin.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				if(dbHelper.getAdmin() > 0){
		    		Intent intent = new Intent(Main.this,AdminLogin.class);
		    		startActivity(intent);
		    	}
		    	else
		    	{
		    		Intent intent = new Intent(Main.this,CreateAdmin.class);
		    		startActivity(intent);
		    	}
			
				

			}
		});
		
		
		bt_ccm.setOnClickListener(new OnClickListener() {
						
			@Override
			public void onClick(View v) {
			
				Intent intent = new Intent(Main.this,CcmLogin.class);
				startActivity(intent);

			}
		});
			
			
			
			
		bt_user.setOnClickListener(new OnClickListener() {
				
			@Override
			public void onClick(View v) {
			
				Intent intent = new Intent(Main.this,UserHome.class);
				startActivity(intent);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
