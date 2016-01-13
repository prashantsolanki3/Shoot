package io.github.prashantsolanki3.shoot;

import android.app.Application;
import android.content.Context;
import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import io.github.prashantsolanki3.shoot.listener.OnShootListener;
import io.github.prashantsolanki3.shoot.preference.PM;

/**
 * Package io.github.prashantsolanki3.shoot
 * <p>
 * Created by Prashant on 1/13/2016.
 * <p>
 * Email: solankisrp2@gmail.com
 * Github: @prashantsolanki3
 */
public class Shoot {

    public static Context context;

    public static synchronized void with(Application context){
        Shoot.context = context;
    }

    public static void isInit(){
        if(context==null)
            throw new RuntimeException("Shoot must be initialized before usage.");
    }

    public static synchronized void once(String TAG, OnShootListener onShootListener) {
        isInit();

        if(PM.getRun(TAG)){
            onShootListener.onExecute();
        }

        PM.setRun(TAG,true);
    }
 

    public static synchronized void once(@Scope int scope, String TAG, OnShootListener onShootListener) {
        isInit();
    }


    public static synchronized void repeatAfter(int iterations, String Tag, OnShootListener onShootListener) {
        isInit();
    }


    public static synchronized void repeatAfter(@Scope int scope, int iterations, String Tag, OnShootListener onShootListener) {
        isInit();
    }


    public static synchronized boolean isShot(String TAG) {
        isInit();
        return false;
    }

 
    public static synchronized boolean isShot(@Scope int Scope, String TAG) {
        isInit();
        return false;
    }


    //TODO: shoot at a specific time. See Android-Job.
/*    public static synchronized void at(String TAG, long time, OnShootListener onShootListener) {
        isInit();
    }

 
    public static synchronized void at(String TAG, int time, OnShootListener onShootListener) {
        isInit();
    }*/


    static final int THIS_APP_INSTALL = 0;
    static final int THIS_APP_VERSION = 1;

    @Retention(RetentionPolicy.SOURCE)
    @IntDef({THIS_APP_INSTALL, THIS_APP_VERSION})
    @interface Scope{

    }

}
