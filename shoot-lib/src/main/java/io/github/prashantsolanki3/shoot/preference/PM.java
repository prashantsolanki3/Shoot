package io.github.prashantsolanki3.shoot.preference;

import android.content.Context;
import android.content.SharedPreferences;

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

    private static String PREFIX_RUN="run_",PREFIX_TIME="time_",PREFIX_ITERATION="it_";

    public static void init(){
        isInit();
        pref = context.getSharedPreferences("shoot_preferences",Context.MODE_PRIVATE);
        editor = pref.edit();
    }

    public static void setRun(String TAG,boolean bool){
        init();

        editor.putBoolean(PREFIX_RUN+TAG,bool);
        editor.commit();
    }

    public static boolean getRun(String TAG){
        init();
        return pref.getBoolean(PREFIX_RUN+TAG,false);
    }

    public static void setExecutionTime(String TAG,long time){
        init();

        editor.putLong(PREFIX_TIME+TAG, time);
        editor.commit();
    }

    public static long getExecutionTime(String TAG){
        init();
        return pref.getLong(PREFIX_TIME+TAG, -1);
    }

    public static void setIteration(String TAG,int iteration){
        init();

        editor.putInt(PREFIX_ITERATION+TAG, iteration);
        editor.commit();
    }

    public static int getIteration(String TAG){
        init();
        return pref.getInt(PREFIX_ITERATION+TAG, -1);
    }

}