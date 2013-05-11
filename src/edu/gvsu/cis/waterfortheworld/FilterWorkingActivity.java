package edu.gvsu.cis.waterfortheworld;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class FilterWorkingActivity extends Activity {
	final Context context = this;
	private String value;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.filter_working);
		Bundle extras = getIntent().getExtras();
		if (extras != null){
			value = extras.getString("fType");
			Log.d(this.getClass().getName(), "We have extras! val = "
			        + value);
		}
		else {
		    Log.d(this.getClass().getName(), "No extras.");
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void yFilterWorking(View view){
		//add something here
		startActivity(new Intent(context,MainActivity.class));
	} 
	
	public void nFilterWorking(View view){
		//needs to be updated
		//startActivity(new Intent(context,MainActivity.class));
		if(value.equals("solar")){
			//display maintenance or repair video for solar filter
		}else if(value.equals("bio")){
			//display maintenance or repair video for bio filter
		}else if(value.equals("ceramic")){
			//display maintenance or repair video for ceramic filter
		}else{
			
		}
	} 
}
