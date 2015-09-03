package com.sajal.astha;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddCC extends ActionBarActivity {

	EditText ccname, ccphone;
	Button addcc;
	DatabaseHelper dbHelper;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_cc);
		
		
		ccname = (EditText)findViewById(R.id.etccName);
		ccphone = (EditText)findViewById(R.id.etccName);
		addcc = (Button)findViewById(R.id.btADDCC);
		dbHelper = new DatabaseHelper(this);
		addcc.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {

				String cc_name = ccname.getText().toString();
				String cc_phone = ccphone.getText().toString();
				CC cc = new CC(cc_name,cc_phone);
				long inserted = dbHelper.addCC(cc);
				if(inserted>0)
					Toast.makeText(getApplicationContext(),
							"Insert Success!!!!",
							Toast.LENGTH_SHORT).show();
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.add_cc, menu);
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
