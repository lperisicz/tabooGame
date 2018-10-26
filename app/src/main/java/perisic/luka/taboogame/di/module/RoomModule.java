package perisic.luka.taboogame.di.module;

import android.arch.persistence.room.Room;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import perisic.luka.taboogame.TabooGame;
import perisic.luka.taboogame.data.local.database.DataBase;

@Module(includes = AppModule.class)
public class RoomModule {

    public static final String DATABASE_NAME = DataBase.class.getSimpleName();

    private DataBase dataBase;
    private TabooGame tabooApplication;

    public RoomModule(TabooGame tabooApplication) {
        this.tabooApplication = tabooApplication;
        this.dataBase = Room
                .databaseBuilder(
                        tabooApplication,
                        DataBase.class,
                        DATABASE_NAME)
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
    }

    @Provides
    @Singleton
    public DataBase providesDatabase(){
        return this.dataBase;
    }

}
