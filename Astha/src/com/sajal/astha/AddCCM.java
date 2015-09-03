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

public class AddCCM extends ActionBarActivity {
	EditText ccmname, ccmphone,ccemail;
	Button addccm;
	DatabaseHelper dbHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_add_ccm);
		ccmname = (EditText)findViewById(R.id.etccmName);
		ccmphone = (EditText)findViewById(R.id.etccmName);
		ccemail = (EditText)findViewById(R.id.etccmName);
		addccm = (Button)findViewById(R.id.btAddcc);
		dbHelper = new DatabaseHelper(this);
		
		addccm.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String ccm_name = ccmname.getText().toString();
				String ccm_phone = ccmphone.getText().toString();
				String ccm_mail = ccemail.getText().toString();
				CCM ccm = new CCM(ccm_name, ccm_phone, ccm_mail);
				long inserted = dbHelper.addCCM(ccm);
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
		getMenuInflater().inflate(R.menu.add_ccm, menu);
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
