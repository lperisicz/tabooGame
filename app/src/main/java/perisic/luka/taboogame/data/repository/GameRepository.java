package perisic.luka.taboogame.data.repository;

import android.arch.lifecycle.LiveData;

import java.util.List;

import perisic.luka.taboogame.data.local.model.GameModel;

public interface GameRepository {


    void addNewGame(GameModel gameModel);

    LiveData<List<GameModel>> getAllGames();

    LiveData<GameModel> getGameById(int id);
}
