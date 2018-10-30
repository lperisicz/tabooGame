package perisic.luka.taboogame.data.local.dao;


import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import perisic.luka.taboogame.data.local.model.GameModel;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

@Dao
public interface GameModelDao {

    @Query("SELECT * FROM gameData")
    LiveData<List<GameModel>> getAllGames();

    @Insert(onConflict = REPLACE)
    void saveGameModel(GameModel gameModel);

    @Query("DELETE FROM gameData")
    void deleteGameData();

    @Query("SELECT * FROM gameData WHERE id = :id")
    LiveData<GameModel> getGameById(int id);
}