package com.sajal.astha;



import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends ActionBarActivity {

	EditText etUserName, etPassWord;
	Button btLog;
	DatabaseHelper dbHelper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_admin_login);
		
		
		
		etUserName = (EditText)findViewById(R.id.et_adminUsername);
		etPassWord  = (EditText)findViewById(R.id.et_adminPassword);
		btLog = (Button)findViewById(R.id.btLogin);
		dbHelper = new DatabaseHelper(this);
		
		btLog.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String etPass = etPassWord.getText().toString();
				String etUser = etUserName.getText().toString();
				int check = dbHelper.admin_login_cheak(etPass,etUser );
				if (check == 1)
				{
					Toast.makeText(getApplicationContext(),
							"Login Success!!!!",
							Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(AdminLogin.this, AdminHome.class);
					startActivity(intent);
				}
				else
				{
					Toast.makeText(getApplicationContext(),
							"Username or Password combination are wrong!!!!!!!",
							Toast.LENGTH_SHORT).show();
				}
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.admin_login, menu);
		
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
