package perisic.luka.taboogame.ui.game;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import perisic.luka.taboogame.data.local.model.GameModel;
import perisic.luka.taboogame.data.repository.GameRepository;

@Singleton
public class PlayViewModel extends ViewModel {

    private GameRepository repository;
    private MutableLiveData<Boolean> inGame = new MutableLiveData<>();
    private int gameId;

    @Inject
    public PlayViewModel(GameRepository repository) {
        this.repository = repository;
    }

    //region GETTERS

    public LiveData<List<GameModel>> getAllGames(){
        return repository.getAllGames();
    }

    public LiveData<Boolean> getInGame() {
        return inGame;
    }

    public LiveData<GameModel> getGame(int id) {
        return repository.getGameById(id);
    }

    //endregion

    //region SETTERS

    public void setInGame(Boolean inGame) {
        this.inGame.postValue(inGame);
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public int getGameId() {
        return this.gameId;
    }

    //endregion
}

