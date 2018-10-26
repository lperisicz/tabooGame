package perisic.luka.taboogame.data.repository;

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
}
