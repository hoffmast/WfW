package edu.gvsu.cis.waterfortheworld.activities;

import edu.gvsu.cis.waterfortheworld.R;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class ObtainWaterBottleActivity extends Activity {
	final Context context = this;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.obtain_water_bottle);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void yObtainWaterBottle(View view){
		startActivity(new Intent(context,WaterLooksActivity.class));
	}
	
	public void nObtainWaterBottle(View view){
		//Display ceramic filteration video
	}
}
