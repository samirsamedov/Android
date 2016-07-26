package com.sam.facebookloginex;

import android.content.Context;

public class FBPrefUtils {

    //FB FBPrefUtils
    public static void setCurrentUser(FBUser currentFBUser, Context ctx){
        ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(ctx, "user_prefs", 0);
        complexPreferences.putObject("current_user_value", currentFBUser);
        complexPreferences.commit();
    }

    public static FBUser getCurrentUser(Context ctx){
        ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(ctx, "user_prefs", 0);
        FBUser currentFBUser = complexPreferences.getObject("current_user_value", FBUser.class);
        return currentFBUser;
    }

    public static void clearCurrentUser( Context ctx){
        ComplexPreferences complexPreferences = ComplexPreferences.getComplexPreferences(ctx, "user_prefs", 0);
        complexPreferences.clearObject();
        complexPreferences.commit();
    }


}
