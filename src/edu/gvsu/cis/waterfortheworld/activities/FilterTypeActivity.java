package edu.gvsu.cis.waterfortheworld.activities;

import java.util.Locale;
import java.util.ResourceBundle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import edu.gvsu.cis.waterfortheworld.R;
import edu.gvsu.cis.waterfortheworld.tools.LocaleManager;

public class FilterTypeActivity extends Activity {
    final Context context = this;
    
    /** The LocaleManager to use */
    private LocaleManager lm;
    
    /** The Spinner that controls the language */
    private Spinner langSpinner;
    
    /** The TextView displaying the question */
    private TextView questionText;
    
    /** The RadioButton for the Solar option */
    private RadioButton solarRadButton;
    
    /** The RadioButton for the Bio option */
    private RadioButton bioRadButton;
    
    /** The RadioButton for the Ceramic option */
    private RadioButton ceramRadButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.filter_type);
        
        lm = LocaleManager.getSingleton();
        
        langSpinner = (Spinner) findViewById(R.id.filterTSpinner);
        questionText = (TextView) findViewById(R.id.filterT);
        solarRadButton = (RadioButton) findViewById(R.id.filterTSolar);
        bioRadButton = (RadioButton) findViewById(R.id.filterTBio);
        ceramRadButton = (RadioButton) findViewById(R.id.filterTCeram);
        
        lm.setUpLangSpinner(langSpinner, this);
        langSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
            
            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                    int pos, long id) {
                if (pos != 0) {
                    lm.setCurrentLocale(new Locale(LocaleManager.langs[1][pos]));
                    setTextToCurrentLocale();
                }
            }
            
            @Override
            public void onNothingSelected(AdapterView<?> arg0) {}
        });
        
        setTextToCurrentLocale();
    }
    
    private void setTextToCurrentLocale() {
        ResourceBundle bundle = lm.getTextBundle();
        questionText.setText(bundle.getString("filterType"));
        solarRadButton.setText(bundle.getString("solarFilter"));
        bioRadButton.setText(bundle.getString("bioFilter"));
        ceramRadButton.setText(bundle.getString("ceramicFilter"));
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
    
    /* (non-Javadoc)
     * @see android.app.Activity#onActivityResult(int, int, android.content.Intent)
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        setTextToCurrentLocale();
    }
}
