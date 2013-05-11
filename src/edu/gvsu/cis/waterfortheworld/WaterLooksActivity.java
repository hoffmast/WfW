package edu.gvsu.cis.waterfortheworld;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class WaterLooksActivity extends Activity {
	final Context context = this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.water_looks);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void gt200nm(View view){
		//startActivity(new Intent(context,Main.class));
		//use salted water sanitation video
	}
	
	public void lt200nm(View view){
		//startActivity(new Intent(context,Main.class));
		//use standard solar water sanitation video
	}
}
