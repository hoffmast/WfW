package edu.gvsu.cis.waterfortheworld.activities;

import java.util.Locale;
import java.util.Observable;
import java.util.Observer;
import java.util.ResourceBundle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import edu.gvsu.cis.waterfortheworld.R;
import edu.gvsu.cis.waterfortheworld.tools.LocaleManager;

public class MainActivity extends Activity implements Observer {
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
        lm.setCurrentLocale(lcl);
        lm.addObserver(this);
        
        langSpinner = (Spinner) findViewById(R.id.haveWFSpinner);
        questionText = (TextView) findViewById(R.id.haveWF);
        yesRadButton = (RadioButton) findViewById(R.id.haveWFYes);
        noRadButton = (RadioButton) findViewById(R.id.haveWFNo);
        
        lm.setUpLangSpinner(langSpinner, this);
        
        setTextToCurrentLocale();
    }
    
    /* (non-Javadoc)
     * @see android.app.Activity#onDestroy()
     */
    @Override
    protected void onDestroy() {
        lm.deleteObserver(this);
        super.onDestroy();
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
        startActivity(new Intent(context, FilterTypeActivity.class));
    }
    
    public void nHaveWF(View view){
        startActivity(new Intent(context, ObtainWaterBottleActivity.class));
    }
    
    @Override
    public void update(Observable arg0, Object arg1) {
        setTextToCurrentLocale();
        langSpinner.setSelection((Integer) arg1);
    }
    
}
