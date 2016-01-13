package io.github.prashantsolanki3.shootsample;

import android.app.Application;
import android.widget.Toast;

import io.github.prashantsolanki3.shoot.Shoot;
import io.github.prashantsolanki3.shoot.listener.OnShootListener;
import io.github.prashantsolanki3.shoot.utils.Scope;

/**
 *
 * Created by Prashant on 1/14/2016.
 *
 */
public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Shoot.with(this);

        Shoot.once("test", new OnShootListener() {
            @Override
            public void onExecute(@Scope int scope, String TAG, int timesExecuted) {
                Toast.makeText(getApplicationContext(),"Toast "+TAG,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNotExecuted(@Scope int scope, String TAG, int timesExecuted) {
                Toast.makeText(getApplicationContext(),"Not Executed: "+TAG+" : "+timesExecuted, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
