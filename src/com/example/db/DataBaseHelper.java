package com.example.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.hardware.SensorManager;

public class DataBaseHelper extends SQLiteOpenHelper{

	public static final String DB_NAME="Planetas";
	public static final int DB_VERSION=1;
	
	public DataBaseHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		
		String sql="CREATE TABLE "+Planeta.TABLE_NAME
				+"(" 
				+"_id INTEGER AUTO_INCREMENT PRIMARY KEY,"
				+Planeta.COLUMN_NAME+" VARCHAR,"
				+Planeta.COLUMN_GRAVITY+" FLOAT,"
				+Planeta.COLUMN_DISTANCE+" LONG"
				+")";
		
		db.execSQL(sql);
		
		ContentValues cV= new ContentValues();
		
		cV.put(Planeta.COLUMN_NAME, "Tierra");
		cV.put(Planeta.COLUMN_GRAVITY
				, SensorManager.GRAVITY_EARTH);
		cV.put(Planeta.COLUMN_DISTANCE, 0);
		
		db.insert(Planeta.TABLE_NAME,
				null, cV);
		
		cV.put(Planeta.COLUMN_NAME, "Marte");
		cV.put(Planeta.COLUMN_GRAVITY
				, SensorManager.GRAVITY_MARS);
		cV.put(Planeta.COLUMN_DISTANCE, 12000);
		
		db.insert(Planeta.TABLE_NAME,
				null, cV);
		
		cV.put(Planeta.COLUMN_NAME, "Jupiter");
		cV.put(Planeta.COLUMN_GRAVITY
				, SensorManager.GRAVITY_JUPITER);
		cV.put(Planeta.COLUMN_DISTANCE, 300000);
		
		db.insert(Planeta.TABLE_NAME,
				null, cV);				
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE "+Planeta.TABLE_NAME);
		onCreate(db);	
	}

}
