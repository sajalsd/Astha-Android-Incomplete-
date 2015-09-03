package com.sajal.astha;

import java.util.ArrayList;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

	public static final String DB_NAME = "Cyclone_management";
	public static final int DB_VERSION = 1;

	// TABLE for User Password and information
	// LOGIN TABLE
	public static final String ADMIN_LOGIN_TABLE = "admin_login";
	public static final String NAME_FIELD = "name";
	public static final String PHONE_FIELD = "phone";
	public static final String USERNAME_FIELD = "username";
	public static final String PASSWORD_FIELD = "password";

	public static final String ADMIN_LOGIN_TABLE_SQL = "CREATE TABLE " + ADMIN_LOGIN_TABLE
			+ "(" + USERNAME_FIELD + " TEXT  PRIMARY KEY, " + NAME_FIELD
			+ " TEXT , " + PHONE_FIELD + " TEXT, " + PASSWORD_FIELD + " TEXT);";
	
	
	//Table for cc
	public static final String CC_TABLE = "cc";
	public static final String CC_ID_FIELD = "cc_id";
	public static final String CC_NAME_FIELD = "cc_name";
	public static final String CC_PHONE_FIELD = "cc_phone";
	//public static final String CC_DIS_NAME_FIELD = "cc_dis";
	//public static final String CC_PS_NAME_FIELD = "cc_ps";
	//public static final String CC_UNION_NAME_FIELD = "cc_union";
	//public static final String CC_VILLAGE_NAME_FIELD = "cc_vill";
	//public static final String CC_ALT_USE_FIELD = "cc_alt";

	public static final String CC_TABLE_SQL = "CREATE TABLE " + CC_TABLE
			+ "(" + CC_ID_FIELD + " INTEGER PRIMARY KEY AUTOINCREMENT, " + CC_NAME_FIELD
			+ " TEXT , " + CC_PHONE_FIELD + " TEXT);" ;
	
	
	
	
	// TABLE FOR CCM
	// ACCOUNT TABLE
	public static final String CCM_TABLE = "ccm";
	public static final String CCM_ID_FIELD = "ccm_id";
	public static final String CCM_NAME_FIELD = "ccm_name";
	public static final String CCM_PHONE_FIELD = "ccm_phone";
	public static final String CCM_MAIL_FIELD = "ccm_mail";
	public static final String CCM_CC_FIELD = "ccm_cc";


	public static final String CCM_TABLE_SQL = "CREATE TABLE "
			+ CCM_TABLE + " (" + CCM_ID_FIELD + " INTEGER PRIMARY KEY AUTOINCREMENT, "
			+ CCM_NAME_FIELD + " TEXT, " + CCM_PHONE_FIELD + " TEXT, "+ CCM_MAIL_FIELD +
			"TEXT, " +CCM_CC_FIELD + " integer, FOREIGN KEY (" + CCM_CC_FIELD
			+ ") REFERENCES " + CC_TABLE + " (" + CC_ID_FIELD + "));"; 

	

	
	public DatabaseHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(ADMIN_LOGIN_TABLE_SQL);
		Log.e("TABLE CREATE", ADMIN_LOGIN_TABLE_SQL);
		// table creation
		db.execSQL(CC_TABLE_SQL);
		Log.e("TABLE CREATE", CC_TABLE_SQL);
		db.execSQL(CCM_TABLE_SQL);
		Log.e("TABLE CREATE", CCM_TABLE_SQL);
		
	}

	@Override
	public void onUpgrade(SQLiteDatabase arg0, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

	// first time takes user info

	// get number of user
	public int getAdmin() {

		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.query(ADMIN_LOGIN_TABLE, null, null, null, null, null, null);

		int i = c.getCount();

		return i;
	}
	public long insertIntoAdmin(Admin admin)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(NAME_FIELD, admin.getName());
		values.put(PHONE_FIELD, admin.getPhone());
		values.put(USERNAME_FIELD, admin.getUsername());
		values.put(PASSWORD_FIELD, admin.getPassward());

		long inserted = db.insert(ADMIN_LOGIN_TABLE, null, values);
		db.close();
		return inserted;
			
	}
	
	public int admin_login_cheak(String etPass,String etUser )
	{
		String password = null, username =null;
		SQLiteDatabase db = this.getReadableDatabase();

		Cursor c = db.query(ADMIN_LOGIN_TABLE, null, null, null, null, null, null);

		if ((c != null) && (c.getCount() > 0))
		{
			c.moveToFirst();
			password = c.getString(c.getColumnIndex(PASSWORD_FIELD));
			username = c.getString(c.getColumnIndex(USERNAME_FIELD));
		
		}
		if (password.equals(etPass) && username.equals(etUser))
			return 1;
		else
			return 0;
	}

	
	public long addCC(CC cc)
	{
		
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(CC_NAME_FIELD, cc.getCcName());
		values.put(CC_PHONE_FIELD, cc.getCcPhone());
		

		long inserted = db.insert(CC_TABLE, null, values);
		db.close();
		return inserted;
		
	}
	public long addCCM(CCM ccm)
	{
		
		SQLiteDatabase db = this.getWritableDatabase();
		ContentValues values = new ContentValues();
		values.put(CCM_NAME_FIELD, ccm.getCcm_name());
		values.put(CCM_PHONE_FIELD, ccm.getCcm_phnone());
		

		long inserted = db.insert(CC_TABLE, null, values);
		db.close();
		
		return inserted;
	
	}
	
	


}
