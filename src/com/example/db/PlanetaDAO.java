package com.example.db;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PlanetaDAO {

	SQLiteDatabase db;
	
	public PlanetaDAO(Context context){
		DataBaseHelper helper= new DataBaseHelper(context);
		db= helper.getWritableDatabase();
		
	}
	
	public void insertPlaneta(Planeta planeta){
		ContentValues cV= new ContentValues();
		cV.put(Planeta.COLUMN_NAME, planeta.getNombre());
		cV.put(Planeta.COLUMN_GRAVITY
				, planeta.getGravedad());
		cV.put(Planeta.COLUMN_DISTANCE
				, planeta.getDistancia());
		
		db.insert(Planeta.TABLE_NAME
				, null
				, cV);		
		
		
	}
	
	public void deletePlaneta(Planeta planeta){
		String args[]= new String[1];
		args[0]=""+planeta.getId();
		
		db.delete(Planeta.TABLE_NAME
				, "_id=?", args);
		
	}
	
	public void deletePlanetaById(int id){
		String args[]= new String[1];
		args[0]=""+id;
		
		db.delete(Planeta.TABLE_NAME
				, "_id=?", args);
	}
	
	public void updatePlaneta(Planeta planeta){
		ContentValues cV= new ContentValues();
		cV.put(Planeta.COLUMN_NAME, planeta.getNombre());
		cV.put(Planeta.COLUMN_GRAVITY
				, planeta.getGravedad());
		cV.put(Planeta.COLUMN_DISTANCE
				, planeta.getDistancia());
		String args[]= new String[1];
		args[0]=""+planeta.getId();
		db.update(Planeta.TABLE_NAME
				, cV
				, "_id=?", args);
	} 
	
	public List<Planeta> getAllPlaneta(){
		List<Planeta> data= new ArrayList<Planeta>();
		
		Cursor cursor= db.rawQuery("SELECT * FROM "+Planeta.TABLE_NAME
				, null);
		
		if(cursor.getCount()>0){
			for(int i=0;i< cursor.getCount(); i++){
				cursor.moveToPosition(i);
				
				Planeta planeta= new Planeta();
				planeta.setId(cursor.getInt(0));
				planeta.setNombre(cursor.getString(1));
				planeta.setGravedad(cursor.getFloat(2));
				planeta.setDistancia(cursor.getLong(3));
				
				data.add(planeta);
			}
		}
		
		
		return data;
	}
	
	public Planeta getPlanetaByNombre(String planeta){
		Planeta p= null;
		
		Cursor c= db.rawQuery("SELECT * FROM "
		+Planeta.TABLE_NAME
		+" WHERE nombre LIKE '%"+planeta+"%'"
		, null);
		
		if(c.moveToNext()){
			p= new Planeta();
			p.setId(c.getInt(0));
			p.setNombre(c.getString(1));
			p.setGravedad(c.getFloat(2));
			p.setDistancia(c.getLong(3));
		}
		
		return p;
	}
	
}
