package edu.gvsu.cis.waterfortheworld.tools;

import java.util.Locale;
import java.util.ResourceBundle;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

/*************************************************************
 * Manages Locale specific items, including the language
 * selection spinner and the current selected locale.
 * 
 * @author Steven M.W. Hoffman
 * @version May 17, 2013
 ************************************************************/
public class LocaleManager {
    
    /** The singleton object */
    private static LocaleManager singleton;
    
    /** The current selected Locale */
    private Locale currentLocale;
    
    /** The TextBundle for the current Locale */
    private ResourceBundle textBundle;
    
    /** A list of the different supported languages */
    public final static String[][] langs = {{"Set Language","English", "Español"}, {"en", "en", "es"}};
    
    /************************************************************
     * Private Constructor for Singleton Design Pattern
     ************************************************************/
    private LocaleManager() {
        currentLocale = null;
        textBundle = null;
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
     * Sets the current locale to the passed locale only if current
     * locale was null when method was called.
     * 
     * @param locale The locale to make current.
     */
    public void setFirstLocale(Locale locale) {
        if (currentLocale ==  null) {
            currentLocale = locale;
            textBundle = ResourceBundle.getBundle("TextBundle", currentLocale);
        }
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
     * Sets up the language selection spinner.
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
    }
}
