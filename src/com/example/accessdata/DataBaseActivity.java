package com.example.accessdata;

import java.util.List;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import com.example.accessdata.adapters.PlanetaAdapter;
import com.example.db.Planeta;
import com.example.db.PlanetaDAO;

public class DataBaseActivity extends ActionBarActivity{

	ListView list;
	List<Planeta> data;
	PlanetaDAO planetaDAO;
	PlanetaAdapter adapter;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_db);
		
		list= (ListView) findViewById(R.id.list);
		planetaDAO= new PlanetaDAO(this);
		data= planetaDAO.getAllPlaneta();
		adapter= new PlanetaAdapter(data,this);
		list.setAdapter(adapter);
		
	}
	
}
