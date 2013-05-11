package edu.gvsu.cis.waterfortheworld;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {
	final Context context = this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void yHaveWF(View view){
		startActivity(new Intent(context, FilterTypeActivity.class));
	}
	
	public void nHaveWF(View view){
		startActivity(new Intent(context, ObtainWaterBottleActivity.class));
	}

}
