package baltamon.mx.localstoragepractice.persistence;

import android.content.Context;
import android.content.SharedPreferences;

import baltamon.mx.localstoragepractice.models.UserModel;

/**
 * Created by Baltazar Rodriguez on 02/02/2017.
 */

public class UserSession {

    private SharedPreferences manager;
    private SharedPreferences.Editor editor;

    public static final String SESSION_TAG = "user_session";
    public static final String USER_NAME = "user_name";
    public static final String USER_EMAIL = "user_email";
    public static final String USER_PHONE = "user_phone";
    public static final String USER_PASSWORD = "user_password";

    public UserSession(Context context){
        manager = context.getSharedPreferences(SESSION_TAG, 0);
        editor = manager.edit();
    }

    public boolean isLogged(){
        return getUserName() != null;
    }

    public void logout(){
        editor.clear();
        editor.commit();
    }

    public void saveUserData(UserModel userModel){
        setUserName(userModel.getUserName());
        setUserEmail(userModel.getUserEmail());
        setUserPhone(userModel.getUserPhone());
        setUserPassword(userModel.getUserPassword());
    }

    public void setUserName(String userName){
        editor.putString(USER_NAME, userName);
        editor.commit();
    }

    public String getUserName(){
        return manager.getString(USER_NAME, null);
    }

    public void setUserEmail(String userEmail){
        editor.putString(USER_EMAIL, userEmail);
        editor.commit();
    }

    public String getUserEmail(){
        return manager.getString(USER_EMAIL, null);
    }

    public void setUserPhone(String userPhone){
        editor.putString(USER_PHONE, userPhone);
        editor.commit();
    }

    public String getUserPhone(){
        return manager.getString(USER_PHONE, null);
    }

    public void setUserPassword(String userPassword){
        editor.putString(USER_PASSWORD, userPassword);
        editor.commit();
    }

    public String getUserPassword(){
        return manager.getString(USER_PASSWORD, null);
    }
}
