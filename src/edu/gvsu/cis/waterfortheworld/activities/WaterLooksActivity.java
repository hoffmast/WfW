package edu.gvsu.cis.waterfortheworld.activities;


import java.util.Locale;
import java.util.ResourceBundle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.TextView;
import edu.gvsu.cis.waterfortheworld.R;
import edu.gvsu.cis.waterfortheworld.tools.LocaleManager;

public class WaterLooksActivity extends Activity {
    final Context context = this;
    
    /** The LocaleManager to use */
    private LocaleManager lm;
    
    /** The Spinner that controls the language */
    private Spinner langSpinner;
    
    /** The TextView displaying the question */
    private TextView questionText;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.water_looks);
        
        lm = LocaleManager.getSingleton();
        
        langSpinner = (Spinner) findViewById(R.id.waterLSpinner);
        questionText = (TextView) findViewById(R.id.waterL);
        
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
        questionText.setText(bundle.getString("waterLooks"));
    }
    
    public void gt200nm(View view){
        //startActivity(new Intent(context,Main.class));
        //use salted water sanitation video
    }
    
    public void lt200nm(View view){
        //startActivity(new Intent(context,Main.class));
        //use standard solar water sanitation video
    }
    
    /* (non-Javadoc)
     * @see android.app.Activity#onActivityResult(int, int, android.content.Intent)
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        setTextToCurrentLocale();
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
}
