# Shoot
Run a method once or repeat after some iterations. Super simple, One liners.

## Features

* Call Once
* Call after every 'n' times.
* Make the calls according to app version and app installs.

## Add to your project

[![Release](https://img.shields.io/github/release/prashantsolanki3/Snap-RecyclerView-Utils.svg?label=jitpack)](https://jitpack.io/#prashantsolanki3/Snap-RecyclerView-Utils)

Add JitPack to repositories in your project's root `build.gradle` file:

```Gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

Add the dependency to your module's `build.gradle` file:

```Gradle
dependencies {
	...
    compile 'com.github.prashantsolanki3:Shoot:0.8.3'
}
```

## Usage

* Initialize in your `Application` class's `onCreate()`.

```Java
    @Override
    public void onCreate() {
        super.onCreate();
        Shoot.with(this);
   }
```

* To Execute code only once, on App install.

```Java
Shoot.once("UNIQUE_TAG", new OnShootListener() {
            @Override
            public void onExecute(@Scope int scope, String TAG, int iterationCount) {
                Toast.makeText(getApplicationContext(),"Toast "+TAG,Toast.LENGTH_SHORT).show();
            }
          });
            
```

* To Execute code after every 'n' times.
```Java
Shoot.repeatAfter(3 //After how many time codes should be executed
, "UNIQUE_TAG", new OnShootListener() {
                    @Override
                    public void onExecute(@Scope int scope, String TAG, int iterationCount) {
                        Toast.makeText(getApplicationContext(),"Executed: "+TAG+" : "+ iterationCount,Toast.LENGTH_SHORT).show();
                    }
                });
````

By Default All the calls are executed accroding to the App install Scope.
* To execute a code on every new app version.
```Java

Shoot.once(Shoot.APP_VERSION,"UNIQUE_TAG", new OnShootListener() {
            @Override
            public void onExecute(@Scope int scope, String TAG, int iterationCount) {
                Toast.makeText(getApplicationContext(),"Toast "+TAG,Toast.LENGTH_SHORT).show();
            }
          });
```

