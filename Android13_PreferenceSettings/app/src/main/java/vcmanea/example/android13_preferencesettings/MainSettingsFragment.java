package vcmanea.example.android13_preferencesettings;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import android.support.v7.preference.CheckBoxPreference;
import android.support.v7.preference.ListPreference;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceFragmentCompat;
import android.util.Log;
import android.widget.Toast;


public class MainSettingsFragment extends PreferenceFragmentCompat {
    public static final String SHARED_PREFS = "sharedPrefs";

    public static final String TEXT = "text";
    public static final String LIST1 = "list1";
    SharedPreferences sharedPreferences;
    private static final String TAG = "MainSettingsFragment";

    @Override
    public void onCreatePreferences(Bundle bundle, String s) {
        setPreferencesFromResource(R.xml.preferences, s);

        String result=loadData();
        Log.d(TAG, "onCreatePreferences: "+ result);
        ListPreference listPreference = (ListPreference) findPreference("list_preference");
        if (listPreference.getValue() == null) {
            // to ensure we don't get a null value
            // set first value by default
            listPreference.setValueIndex(0);
        }

        listPreference.setSummary(listPreference.getValue().toString());
        listPreference.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                Toast.makeText(getContext(), "" + o, Toast.LENGTH_SHORT).show();
                // preference.setDefaultValue(o);
                saveData(o.toString());
                preference.setDefaultValue(o);
                preference.setSummary(o.toString());
                return true;
            }
        });


        CheckBoxPreference category_sport=(CheckBoxPreference)findPreference("check_Sport");

        category_sport.setOnPreferenceChangeListener(new Preference.OnPreferenceChangeListener() {
            @Override
            public boolean onPreferenceChange(Preference preference, Object o) {
                Toast.makeText(getContext(),""+o,Toast.LENGTH_LONG).show();
                preference.setDefaultValue(o);
//               if(o.equals("true")){
//                   preference.setEnabled(true);
//               }
//               else {
//                   preference.setEnabled(false);
//               }
                return true;
            }
        });

    }

    public void saveData(String data) {
        sharedPreferences = getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(TEXT, data).commit();
    }

    public String loadData() {
      sharedPreferences =getActivity().getSharedPreferences(SHARED_PREFS, Context.MODE_PRIVATE);
        return sharedPreferences.getString(TEXT, null);
    }







}
