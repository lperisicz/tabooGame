package perisic.luka.taboogame;

import android.app.Application;

import perisic.luka.taboogame.di.component.AppComponent;
import perisic.luka.taboogame.di.component.DaggerAppComponent;
import perisic.luka.taboogame.di.module.RoomModule;

public class TabooGame extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }

    private void initDagger() {
        appComponent = DaggerAppComponent
                .builder()
                .roomModule(new RoomModule(this))
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }
}
