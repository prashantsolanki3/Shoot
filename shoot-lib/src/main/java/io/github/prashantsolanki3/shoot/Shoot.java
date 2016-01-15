package io.github.prashantsolanki3.shoot;

import android.content.Context;

import java.util.Date;

import io.github.prashantsolanki3.shoot.listener.OnShootListener;
import io.github.prashantsolanki3.shoot.utils.Scope;

import static io.github.prashantsolanki3.shoot.preference.PM.getExecutionTime;
import static io.github.prashantsolanki3.shoot.preference.PM.getIteration;
import static io.github.prashantsolanki3.shoot.preference.PM.getRun;
import static io.github.prashantsolanki3.shoot.preference.PM.setExecutionTime;
import static io.github.prashantsolanki3.shoot.preference.PM.setIteration;
import static io.github.prashantsolanki3.shoot.preference.PM.setRun;

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
    public static final int APP_INSTALL = 0;
    public static final int APP_VERSION = 1;
    public static String preferenceFile;

    public static synchronized void with(Context context){
        Shoot.context = context;
        preferenceFile = null;
    }

    public static synchronized void with(Context context,String preferenceFile){
        Shoot.context = context;
        Shoot.preferenceFile = preferenceFile;
    }

    public static void isInit(){
        if(context==null)
            throw new RuntimeException("Shoot must be initialized before usage.");
    }

    public static synchronized void once(String TAG, OnShootListener onShootListener) {
        once(APP_INSTALL,TAG,onShootListener);
    }

    public static synchronized void once(@Scope int scope, String TAG, OnShootListener onShootListener) {
        isInit();
        if(!getRun(scope, TAG)){
            onShootListener.onExecute(scope,TAG,0);
            setRun(scope,TAG, true);
            setExecutionTime(scope, TAG, new Date().getTime());
        }else
            onShootListener.onNotExecuted(scope,TAG,1);
    }

    public static synchronized void repeatAfter(int iterations, String Tag, OnShootListener onShootListener) {
        repeatAfter(APP_INSTALL,iterations,Tag,onShootListener);
    }

    public static synchronized void repeatAfter(@Scope int scope, int iterations, String TAG, OnShootListener onShootListener) {
        isInit();
        int iterationNo = getIteration(scope,TAG);

        if(iterationNo==-1)
            iterationNo = 0;

        if(iterationNo%iterations==0){
            onShootListener.onExecute(scope,TAG,iterationNo);
            setExecutionTime(scope, TAG, new Date().getTime());
        }else
            onShootListener.onNotExecuted(scope,TAG,iterationNo);

        setIteration(scope, TAG, iterationNo+1);
    }

    public static synchronized boolean isDone(String TAG) {
        return isDone(APP_INSTALL,TAG);
    }

    public static synchronized boolean isDone(@Scope int scope, String TAG) {
        isInit();
       return getRun(scope,TAG);
    }

    public static synchronized long getLastExecutionTime(String TAG){
        return getLastExecutionTime(APP_INSTALL,TAG);
    }

    public static synchronized long getLastExecutionTime(@Scope int scope, String TAG){
        isInit();
        return getExecutionTime(scope,TAG);
    }

}
