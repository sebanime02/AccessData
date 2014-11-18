package com.example.accessdata;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements OnClickListener {

	TextView txt;
	Button btn;
	EditText edit;
	
	SharedPreferences preference;
	Editor editor;
	
	public static final String PREFERENCE_NAME="Datos";
	public static final String VALUE_EDIT="valorEditText";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        txt=(TextView) findViewById(R.id.txt);
        btn= (Button) findViewById(R.id.btn);
        edit= (EditText) findViewById(R.id.edit);
        
        btn.setOnClickListener(this);
        
        preference= getSharedPreferences(PREFERENCE_NAME,0);
        editor=preference.edit();
        
        String value=preference.getString(VALUE_EDIT,
        		getString(R.string.txt)
        		);
        
        txt.setText(value);
    }


    @Override
	public void onClick(View v) {
    	editor.putString(VALUE_EDIT, edit.getText()
    			.toString());
    	editor.commit();
    	Toast.makeText(this, "Dato Almacenado !",Toast.LENGTH_SHORT)
    	.show();
	}
}
