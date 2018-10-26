package perisic.luka.taboogame.ui.add;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import perisic.luka.taboogame.R;
import perisic.luka.taboogame.TabooGame;
import perisic.luka.taboogame.base.BaseActivity;
import perisic.luka.taboogame.data.local.model.GameModel;

public class AddGameActivity extends BaseActivity implements Observer<GameModel> {

    @BindView(R.id.gameTitle)
    EditText gameTitle;

    @BindView(R.id.words_recycler_view)
    RecyclerView recyclerView;

    @OnClick(R.id.add_word_button)
    public void addWordClick(){adapter.addItem();}

    @OnClick(R.id.save_game_button)
    public void saveGame(){
        viewModel.setGameModel(
                new GameModel(
                        gameTitle.getText().toString(),
                        adapter.getDataList()
                )
        );
    }

    @Inject
    AddGameViewModel viewModel;
    private WordAdapter adapter;

    @Override
    protected void setupUi() {
        adapter = new WordAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void setupViewModel() {
        TabooGame.getAppComponent()
                .inject(this);
        viewModel.getGameModel().observe(this,this);
    }

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_add_game;
    }

    @Override
    public void onChanged(@Nullable GameModel gameModel) {
        viewModel.addNewGame();
    }
}
