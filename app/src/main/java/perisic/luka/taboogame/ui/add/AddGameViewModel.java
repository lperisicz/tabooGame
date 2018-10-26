package perisic.luka.taboogame.ui.add;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import perisic.luka.taboogame.data.local.model.GameModel;
import perisic.luka.taboogame.data.repository.GameRepository;

public class AddGameViewModel extends ViewModel {

    private GameRepository repository;
    private MutableLiveData<GameModel> gameModel = new MutableLiveData<>();

    @Inject
    public AddGameViewModel(GameRepository repository) {
        this.repository = repository;
    }

    public void addNewGame(){
        GameModel game = gameModel.getValue();
        if (game != null) {
            repository.addNewGame(game);
        }
    }

    public void setGameModel(GameModel gameModel) {
        this.gameModel.setValue(gameModel);
    }

    public MutableLiveData<GameModel> getGameModel() {
        return gameModel;
    }
}
