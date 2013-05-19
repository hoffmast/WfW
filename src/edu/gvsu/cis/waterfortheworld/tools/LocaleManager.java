package edu.gvsu.cis.waterfortheworld.tools;

import java.util.Locale;
import java.util.Observable;
import java.util.ResourceBundle;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

/*************************************************************
 * Manages Locale specific items, including the language
 * selection spinner and the current selected locale.
 * 
 * @author Steven M.W. Hoffman
 * @version May 17, 2013
 ************************************************************/
public class LocaleManager extends Observable {
    
    /** The singleton object */
    private static LocaleManager singleton;
    
    /** The Listener for Language Spinners to use */
    private final OnItemSelectedListener listener;
    
    /** The current selected Locale */
    private Locale currentLocale;
    
    /** The TextBundle for the current Locale */
    private ResourceBundle textBundle;
    
    /** A list of the different supported languages */
    private String[][] langs = {{"English", "Español"}, {"en", "es"}};
    
    /************************************************************
     * Private Constructor for Singleton Design Pattern
     ************************************************************/
    private LocaleManager() {
        currentLocale = null;
        textBundle = null;
        listener = new OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view,
                    int pos, long id) {
                setCurrentLocale(new Locale(langs[1][pos]));
                setChanged();
                notifyObservers(pos);
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {}
        };
    }
    
    /***
     * Static block to initialize singleton
     */
    static {
        singleton = new LocaleManager();
    }
    
    /**
     * Returns the singleton LocaleManager.
     * @return The singleton LocaleManager.
     */
    public static LocaleManager getSingleton() {
        return singleton;
    }
    
    /**
     * Returns the current Locale.
     * @return The current Locale.
     */
    public Locale getCurrentLocale() {
        return currentLocale;
    }
    
    /**
     * Sets the current locale to the passed locale.
     * @param locale The locale to make current.
     */
    public void setCurrentLocale(Locale locale) {
        currentLocale = locale;
        textBundle = ResourceBundle.getBundle("TextBundle", currentLocale);
    }
    
    /**
     * Returns a reference to the TextBundle for the current locale.
     * @return A reference to the TextBundle for the current locale.
     */
    public ResourceBundle getTextBundle() {
        return textBundle;
    }
    
    /**
     * Sets up the language selection spinner.  Adds a listener to the
     * spinner.  The listener calls the notifyObservers() method when a 
     * spinner item is selected, sending the position of the selected item 
     * in the spinner to the update() method.
     * 
     * @param spinner The language selection spinner to setup.
     * @param context The Context of the Activity which the spinner is in.
     */
    public void setUpLangSpinner (Spinner spinner, Context context) {
        ArrayAdapter<CharSequence> adapter = 
                new ArrayAdapter<CharSequence>(context, 
                        android.R.layout.simple_spinner_item, langs[0]);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(listener);
    }
}
