package ru.a799000.android.anitapplication.app;

import ru.a799000.android.anitapplication.di.ApplicationComponent;
import ru.a799000.android.anitapplication.di.ApplicationModule;
import ru.a799000.android.anitapplication.di.DaggerApplicationComponent;
import ru.a799000.android.anitapplication.di.NetworkingModule;

/**
 * Created by Alex on 02.05.2017.
 */

public class ApplicationAnit extends android.app.Application {

    private static ApplicationComponent mAppComponent;


    @Override
    public void onCreate() {
        super.onCreate();
        init();

    }

    /*
    Инициализация всего
     */
    void init(){
        mAppComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .networkingModule(new NetworkingModule("http://172.31.255.150/"))
                .build();
    }

    public static ApplicationComponent getAppComponent() {
        return mAppComponent;
    }


}
