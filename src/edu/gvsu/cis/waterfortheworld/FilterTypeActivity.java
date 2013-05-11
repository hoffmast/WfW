package edu.gvsu.cis.waterfortheworld;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class FilterTypeActivity extends Activity {
	final Context context = this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.filter_type);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void solarFilter(View view){
		Intent intent =  new Intent(context,FilterWorkingActivity.class);
                intent.putExtra("fType", "solar");
		startActivity(intent);
	}
	
	public void bioFilter(View view){
		Intent intent =  new Intent(context,FilterWorkingActivity.class);
                intent.putExtra("fType", "bio");
		startActivity(intent);
	}
	
	public void ceramicFilter(View view){
		Intent intent =  new Intent(context,FilterWorkingActivity.class);
                intent.putExtra("fType", "ceramic");
		startActivity(intent);
	}
}
