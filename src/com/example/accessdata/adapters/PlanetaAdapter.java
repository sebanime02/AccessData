package com.example.accessdata.adapters;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.accessdata.R;
import com.example.db.Planeta;

public class PlanetaAdapter extends BaseAdapter{

	List<Planeta> data;
	Context context;
	
	public PlanetaAdapter(List<Planeta> data, Context context){
		this.data=data;
		this.context=context;
	}
	
	
	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return data.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v;
		
		if(convertView==null)
			v=View.inflate(context, R.layout.item_list, null);
		else
			v=convertView;
		
		Planeta p= (Planeta) getItem(position);
		
		TextView txt= (TextView) v.findViewById(R.id.txt_name);
		txt.setText(p.getNombre());
		
		txt= (TextView) v.findViewById(R.id.txt_gravity);
		txt.setText(""+p.getGravedad());
		
		txt= (TextView) v.findViewById(R.id.txt_distance);
		txt.setText(""+p.getDistancia());
		
		return v;
	}

}
