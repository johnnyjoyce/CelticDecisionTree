package ie.gmit.computing;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Preferences extends ActionBarActivity {

	private TextView text1 = null;
	private TextView text2 = null;
	private TextView text3 = null;
	private TextView text4 = null;
	private TextView countyList = null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_preferences);
		
		text1 = (TextView)findViewById(R.id.text1);
		text2 = (TextView)findViewById(R.id.text2);
		text3 = (TextView)findViewById(R.id.text3);
		text4 = (TextView)findViewById(R.id.text4);
		countyList = (TextView)findViewById(R.id.list);
		
	}
	
	@Override
	public void onResume(){
		super.onResume();
		
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
		
		text1.setText(prefs.getString("text1", "<unset>"));
		text2.setText(prefs.getString("text2", "<unset>"));
		text3.setText(prefs.getString("text3", "<unset>"));
		text4.setText(prefs.getString("text4", "<unset>"));
		countyList.setText(prefs.getString("list", "<unset>"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.preferences, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {       
		case R.id.edit_pref:
		startActivity(new Intent(this, EditPreferences.class));        
		return true;      
	} 
		return super.onOptionsItemSelected(item);
	}
}
