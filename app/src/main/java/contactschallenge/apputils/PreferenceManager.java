package contactschallenge.apputils;

import android.content.Context;
import android.content.SharedPreferences;

import contactschallenge.core.ContactApplication;

/**
 * Created by Harish on 29/10/18.
 */
public class PreferenceManager {

    private static final String USER_SETTINGS = "userSettings";
    private final String PREFERENCE_NAME = "User_PREFERENCES";
    private final String TUTORIAL_STATUS = "TutorialStatus";
    private final String DEVICE_ID = "device_id";
    private final String USER_DATA = "user_data";
    private static Context context;
    private static PreferenceManager ourInstance;
    private final String USER_LOCATION = "user_location";
    private String DEVICE_TOKEN="deviceToken";

    public static PreferenceManager getInstance(Context context1) {
        PreferenceManager.context = context1;
        if (ourInstance == null) {
            ourInstance = new PreferenceManager();
        }
        return ourInstance;
    }

    private SharedPreferences getPreferences() {
        if (context != null)
            return context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        else
            return ContactApplication.getInstance().getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
    }

   /* private SharedPreferences.Editor getEditor() {
        return getPreferences().edit();
    }*/

    /**
     * SharedStorage
     * SAVE STRING VALUES
     */
    public String getPrefrencesString(String key) {
        try {
            return getPreferences().getString(key, null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setPrefrencesString(String key, String value) {
        getPreferences().edit().putString(key, value).apply();
    }

    /**
     * SAVE boolean VALUES
     */
    public boolean getPrefrencesBoolean(String key) {
        try {
            return getPreferences().getBoolean(key, false);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void setPrefrencesBoolean(String key, boolean value) {
        getPreferences().edit().putBoolean(key, value).apply();
    }

    public void setTutorialStatus(boolean isShown) {
        getPreferences().edit().putBoolean(TUTORIAL_STATUS, isShown).apply();
    }

    public boolean getTutorialStatus() {
        return getPreferences().getBoolean(TUTORIAL_STATUS, false);
    }

    public void setDeviceId(String deviceId) {
        getPreferences().edit().putString(DEVICE_ID, deviceId).apply();
    }

    public String getDeviceId() {
        return getPreferences().getString(DEVICE_ID, "");
    }

    public void setUserSettings(String userData) {

        getPreferences().edit().putString(USER_SETTINGS, userData).apply();
    }

    public String getUserSettings() {
        return getPreferences().getString(USER_SETTINGS, null);
    }



    public void setUserData(String userData) {

        getPreferences().edit().putString(USER_DATA, userData).apply();
    }

    public String getUserData() {
        return getPreferences().getString(USER_DATA, null);
    }





    public void clearUserData() {
        getPreferences().edit().remove(USER_DATA).apply();
        getPreferences().edit().remove(DEVICE_ID).apply();
    }


    public void setUserLocation(String location) {
        getPreferences().edit().putString(USER_LOCATION, location).apply();
    }





    public void save(String key, Object value) {
        SharedPreferences.Editor editor = getPreferences().edit();
        if (value instanceof Boolean) {
            editor.putBoolean(key, (Boolean) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, (Integer) value);
        } else if (value instanceof Float) {
            editor.putFloat(key, (Float) value);
        } else if (value instanceof Long) {
            editor.putLong(key, (Long) value);
        } else if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Enum) {
            editor.putString(key, value.toString());
        } else if (value != null) {
            throw new RuntimeException("Attempting to save non-supported preference");
        }

        editor.commit();
    }


    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        return (T) getPreferences().getAll().get(key);
    }

    public String getDeviceToken() {
        return getPreferences().getString(DEVICE_TOKEN, "");
    }

   /* public void saveFileId(QBUser qbUser) {
        save(QB_FILE_ID, qbUser.getFileId());
    }*/
}
