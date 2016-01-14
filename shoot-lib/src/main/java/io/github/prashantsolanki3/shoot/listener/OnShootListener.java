package io.github.prashantsolanki3.shoot.listener;

import io.github.prashantsolanki3.shoot.utils.Scope;

public abstract class OnShootListener{

    public abstract void onExecute(@Scope int scope,String TAG ,int iterationCount);
    public void onNotExecuted(@Scope int scope,String TAG, int iterationCount){

    }
}