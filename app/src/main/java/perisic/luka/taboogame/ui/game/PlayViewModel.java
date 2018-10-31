package perisic.luka.taboogame.ui.game;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.CountDownTimer;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import perisic.luka.taboogame.data.local.model.GameModel;
import perisic.luka.taboogame.data.repository.GameRepository;

@Singleton
public class PlayViewModel extends ViewModel {

    private GameRepository repository;
    private MutableLiveData<Boolean> inGame = new MutableLiveData<>();
    private MutableLiveData<Boolean> isFirstTurn = new MutableLiveData<>();
    private MutableLiveData<Integer> firstScore = new MutableLiveData<>();
    private MutableLiveData<Integer> secondScore = new MutableLiveData<>();
    private MutableLiveData<Long> timeRemaining = new MutableLiveData<>();

    private int gameId;

    @Inject
    public PlayViewModel(GameRepository repository) {
        this.repository = repository;
        firstScore.postValue(0);
        secondScore.postValue(0);
        isFirstTurn.postValue(true);
    }

    //region HELPER_METHODS

    public void startTimer(){
        new CountDownTimer(60000, 1000) {
            @Override
            public void onTick(long l) {
                timeRemaining.postValue(l);
            }

            @Override
            public void onFinish() {
                startTimer();
                if(isFirstTurn.getValue() != null && isFirstTurn.getValue()){
                    isFirstTurn.postValue(false);
                }else{
                    isFirstTurn.postValue(true);
                }
            }
        }.start();
    }

    //endregion

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

    public MutableLiveData<Boolean> getIsFirstTurn() {
        return isFirstTurn;
    }

    public MutableLiveData<Integer> getFirstScore() {
        return firstScore;
    }

    public MutableLiveData<Integer> getSecondScore() {
        return secondScore;
    }

    public LiveData<Long> getTimeRemaining() {
        return this.timeRemaining;
    }

    public int getGameId() {
        return this.gameId;
    }

    //endregion

    //region SETTERS

    public void setInGame(Boolean inGame) {
        this.inGame.postValue(inGame);
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
    }

    public void setAnswer(boolean isCorrect) {
        if(isFirstTurn.getValue() != null){
            if(isFirstTurn.getValue()){
                int currentFirstScore = firstScore.getValue();
                if(isCorrect){
                    firstScore.postValue(++currentFirstScore);
                }else{
                    firstScore.postValue(--currentFirstScore);
                }
            }else{
                int currentSecondScore = secondScore.getValue();
                if(isCorrect){
                    secondScore.postValue(++currentSecondScore);
                }else{
                    secondScore.postValue(--currentSecondScore);
                }
            }
        }else{
            isFirstTurn.postValue(true);
        }
    }

    //endregion
}

