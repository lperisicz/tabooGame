package perisic.luka.taboogame.di.module;


import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import perisic.luka.taboogame.data.local.database.DataBase;
import perisic.luka.taboogame.data.repository.GameRepository;
import perisic.luka.taboogame.data.repository.GameRepositoryImpl;

@Module(includes = RoomModule.class)
public class RemoteModule {


    @Singleton
    @Provides
    public GameRepository providesGameRepository(DataBase localDatabase){
        return new GameRepositoryImpl(localDatabase);
    }

}
