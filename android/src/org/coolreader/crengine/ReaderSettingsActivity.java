package org.coolreader.crengine;

import org.coolreader.R;

import android.os.Bundle;
import android.preference.ListPreference;
import android.preference.PreferenceActivity;

import com.onyx.android.sdk.data.sys.OnyxDictionaryInfo;

public class ReaderSettingsActivity extends PreferenceActivity
{
    public static final String[] sPageMarginsArray = new String[]{"0", "10", "20", "30"};

    public static final String sPageMargin = "page_margin";
    public static final String sDisplayFooter = "display_footer";
    public static final String sDisplayTime = "display_time";
    public static final String sDisplayNavigational = "display_navigational";
    public static final String sDictionaryList = "dictionary_list";

    public static final boolean sIsShowTime = true;
    public static final boolean sIsShowFooter = true;
    public static final boolean sIsShowNavigational = true;
    public static String sDictValue = null;
    public static final String sPageMageinsDefaultValue = sPageMarginsArray[1];
    private OnyxDictionaryInfo[] mDicts = null;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_activity);

        ListPreference list = (ListPreference) findPreference(sPageMargin);
        list.setEntries(sPageMarginsArray);
        list.setEntryValues(sPageMarginsArray);

        mDicts = OnyxDictionaryInfo.getDictionaryList();
        String[] dictEntries = new String[4];
        String[] dictEntryValues = new String[4];
        for (int i = 0; i < dictEntries.length; i++) {
            dictEntries[i] = mDicts[i].id;
            dictEntryValues[i] = mDicts[i].packageName;
        }
        ListPreference dictList = (ListPreference) findPreference(sDictionaryList);
        dictList.setEntries(dictEntries);
        dictList.setEntryValues(dictEntryValues);
        if (dictList.getValue() == null) {
            dictList.setValueIndex(0);
        }
    }

    public static void setDictValue(String value)
    {
        sDictValue = value;
    }
}
