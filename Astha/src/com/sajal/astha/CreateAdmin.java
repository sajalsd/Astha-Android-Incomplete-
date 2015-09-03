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

public class CreateAdmin extends ActionBarActivity {

	
	EditText etName, etPhone, etUserName, etPass;
	Button btRegister;
	DatabaseHelper dbHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_create_admin);
		
		etName = (EditText)findViewById(R.id.etName);
		etPhone = (EditText)findViewById(R.id.etPhone);
		etUserName = (EditText)findViewById(R.id.etUserName);
		etPass = (EditText)findViewById(R.id.etPass);
		btRegister = (Button)findViewById(R.id.btRegister);
		dbHelper = new DatabaseHelper(this);
		
		btRegister.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String name = etName.getText().toString();
				String phone = etPhone.getText().toString();
				String userName = etUserName.getText().toString();
				String pass = etPass.getText().toString();
				
				Admin admin = new Admin(name, phone, userName, pass);
				long check = dbHelper.insertIntoAdmin(admin);
				if(check>0)
				{
					Toast.makeText(getApplicationContext(),
							"New Admin Created Successfully!!!!",
							Toast.LENGTH_SHORT).show();
					Intent intent = new Intent(CreateAdmin.this, AdminHome.class);
					startActivity(intent);
				}

				
			}
		});
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.create_admin, menu);
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
