package com.bedulin.android.app.sp;

import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.widget.Toast;

/**
 * Created with IntelliJ IDEA.
 * User: alexandr.bedulin
 * Date: 11/19/12
 * Time: 6:16 PM
 * To change this template use File | Settings | File Templates.
 */
public class SendTo extends PreferenceActivity implements Preference.OnPreferenceClickListener, Preference.OnPreferenceChangeListener {
    // ===========================================================
    // Constants
    // ===========================================================

    // ===========================================================
    // Fields
    // ===========================================================
    private EditTextPreference prefFacebook, prefTwitter, prefVkontakte, prefMemory, prefEmail;

    // ===========================================================
    // Constructors
    // ===========================================================

    // ===========================================================
    // Getter & Setter
    // ===========================================================

    // ===========================================================
    // Methods for/from SuperClass/Interfaces
    // ===========================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.send);

        prefFacebook  = (EditTextPreference)findPreference("facebook");
        prefTwitter   = (EditTextPreference)findPreference("twitter");
        prefVkontakte = (EditTextPreference)findPreference("vkontakte");
        prefEmail     = (EditTextPreference)findPreference("email");
        prefMemory    = (EditTextPreference)findPreference("memory");

        prefFacebook.    setOnPreferenceClickListener(this);
        prefTwitter.     setOnPreferenceClickListener(this);
        prefVkontakte.   setOnPreferenceClickListener(this);
        prefEmail.       setOnPreferenceClickListener(this);
        prefMemory.      setOnPreferenceClickListener(this);

        prefFacebook.    setOnPreferenceChangeListener(this);
        prefTwitter.     setOnPreferenceChangeListener(this);
        prefVkontakte.   setOnPreferenceChangeListener(this);
        prefEmail.       setOnPreferenceChangeListener(this);
        prefMemory.      setOnPreferenceChangeListener(this);

        prefFacebook.    setDialogMessage(R.string.input_name);
        prefTwitter.     setDialogMessage(R.string.input_name);
        prefVkontakte.   setDialogMessage(R.string.input_name);
        prefEmail.       setDialogMessage(R.string.input_name);
        prefMemory.      setDialogMessage(R.string.input_name);

    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        if(!preference.equals(prefMemory)){
            Toast.makeText(this, "Not implemented yet", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object o) {
                Toast.makeText(this,"Not implemented yet",Toast.LENGTH_SHORT).show();
        return true;
    }


    // ===========================================================
    // Methods
    // ===========================================================

    // ===========================================================
    // Inner and Anonymous Classes
    // ===========================================================
}
