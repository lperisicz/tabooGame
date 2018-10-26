package perisic.luka.taboogame.di.module;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import perisic.luka.taboogame.TabooGame;

@Module
public class AppModule {

    private TabooGame tabooApplication;

    public AppModule(TabooGame tabooApplication) {
        this.tabooApplication = tabooApplication;
    }

    @Provides
    @Singleton
    public TabooGame provideTabooApplication() {
        return tabooApplication;
    }
}
