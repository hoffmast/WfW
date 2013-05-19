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

public class MainActivity extends Activity{
    final Context context = this;
    
    /** The LocaleManager to use */
    private LocaleManager lm;
    
    /** The Spinner that controls the language */
    private Spinner langSpinner;
    
    /** The TextView displaying the question */
    private TextView questionText;
    
    /** The RadioButton for the Yes option */
    private RadioButton yesRadButton;
    
    /** The RadioButton for the No option */
    private RadioButton noRadButton;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Locale lcl = Locale.getDefault();
        lm = LocaleManager.getSingleton();
        lm.setFirstLocale(lcl);
        
        langSpinner = (Spinner) findViewById(R.id.haveWFSpinner);
        questionText = (TextView) findViewById(R.id.haveWF);
        yesRadButton = (RadioButton) findViewById(R.id.haveWFYes);
        noRadButton = (RadioButton) findViewById(R.id.haveWFNo);
        
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
        questionText.setText(bundle.getString("haveWF"));
        yesRadButton.setText(bundle.getString("Yes"));
        noRadButton.setText(bundle.getString("No"));
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    public void yHaveWF(View view){
        Intent intent = new Intent(context, FilterTypeActivity.class);
        intent.putExtra("lang", lm.getCurrentLocale().getLanguage());
        startActivityForResult(intent, 0);
    }
    
    public void nHaveWF(View view){
        Intent intent = new Intent(context, ObtainWaterBottleActivity.class);
        intent.putExtra("lang", lm.getCurrentLocale().getLanguage());
        startActivityForResult(intent, 0);
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
