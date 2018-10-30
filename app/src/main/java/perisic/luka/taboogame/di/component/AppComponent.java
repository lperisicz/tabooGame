package perisic.luka.taboogame.di.component;


import javax.inject.Singleton;

import dagger.Component;
import perisic.luka.taboogame.di.module.RemoteModule;
import perisic.luka.taboogame.ui.add.AddGameActivity;
import perisic.luka.taboogame.ui.game.GameActivity;
import perisic.luka.taboogame.ui.game.list.GameListFragment;
import perisic.luka.taboogame.ui.game.play.PlayFragment;
import perisic.luka.taboogame.ui.main.MainActivity;

@Singleton
@Component(modules = {RemoteModule.class})
public interface AppComponent {

    void inject(MainActivity mainActivity);

    void inject(AddGameActivity addGameActivity);

    void inject(GameActivity gameActivity);

    void inject(GameListFragment gameListFragment);

    void inject(PlayFragment playFragment);
}