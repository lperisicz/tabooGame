package perisic.luka.taboogame.data.repository;

import android.arch.lifecycle.LiveData;

import java.util.List;

import perisic.luka.taboogame.data.local.database.DataBase;
import perisic.luka.taboogame.data.local.model.GameModel;

public class GameRepositoryImpl implements GameRepository {

    private DataBase localDatabase;

    public GameRepositoryImpl(DataBase localDatabase) {
        this.localDatabase = localDatabase;
    }

    @Override
    public void addNewGame(GameModel gameModel) {
        localDatabase.gameModelDao().saveGameModel(gameModel);
    }

    @Override
    public LiveData<List<GameModel>> getAllGames() {
        return localDatabase.gameModelDao().getAllGames();
    }

    @Override
    public LiveData<GameModel> getGameById(int id) {
        return localDatabase.gameModelDao().getGameById(id);
    }
}
