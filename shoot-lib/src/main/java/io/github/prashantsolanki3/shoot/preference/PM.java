package io.github.prashantsolanki3.shoot.preference;

import android.content.Context;
import android.content.SharedPreferences;

import java.security.InvalidParameterException;

import io.github.prashantsolanki3.shoot.Shoot;

import static io.github.prashantsolanki3.shoot.Shoot.context;
import static io.github.prashantsolanki3.shoot.Shoot.isInit;

/**
 * Package io.github.prashantsolanki3.shoot.preference
 * <p>
 * Created by Prashant on 1/13/2016.
 * <p>
 * Email: solankisrp2@gmail.com
 * Github: @prashantsolanki3
 */
public class PM {
    // Shared Preferences
    static SharedPreferences pref;
    // Editor for Shared preferences
    static SharedPreferences.Editor editor;

    private final static String PREFIX_RUN="run_",
            PREFIX_TIME="time_",
            PREFIX_ITERATION="it_",
            PREFIX_INSTALL="install_";
    private static String PREFIX_VERSION="version_";

    public static void init(){
        isInit();
        pref = context.getSharedPreferences("shoot_preferences", Context.MODE_PRIVATE);
        editor = pref.edit();

    }

    public static void setRun(@Shoot.Scope int scope,String TAG,boolean bool){
        init();
        editor.putBoolean(getScopePrefix(scope)+PREFIX_RUN+TAG,bool);
        editor.commit();
    }

    public static boolean getRun(@Shoot.Scope int scope,String TAG){
        init();
        return pref.getBoolean(getScopePrefix(scope)+PREFIX_RUN+TAG,false);
    }

    public static void setExecutionTime(@Shoot.Scope int scope,String TAG,long time){
        init();

        editor.putLong(getScopePrefix(scope)+PREFIX_TIME+TAG, time);
        editor.commit();
    }

    public static long getExecutionTime(@Shoot.Scope int scope,String TAG){
        init();
        return pref.getLong(getScopePrefix(scope)+PREFIX_TIME+TAG, -1);
    }

    public static void setIteration(@Shoot.Scope int scope,String TAG,int iteration){
        init();

        editor.putInt(getScopePrefix(scope)+PREFIX_ITERATION+TAG, iteration);
        editor.commit();
    }

    public static int getIteration(@Shoot.Scope int scope,String TAG){
        init();
        return pref.getInt(getScopePrefix(scope)+PREFIX_ITERATION+TAG, -1);
    }

    public static String getScopePrefix(@Shoot.Scope int scope){
        if (scope==Shoot.APP_INSTALL)
            return PREFIX_INSTALL;
        else if (scope==Shoot.APP_VERSION)
            return PREFIX_VERSION;
        else
            throw new InvalidParameterException(scope+" is not a valid Scope");
    }

}