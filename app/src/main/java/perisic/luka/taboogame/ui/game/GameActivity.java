package perisic.luka.taboogame.ui.game;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;

import javax.inject.Inject;

import perisic.luka.taboogame.R;
import perisic.luka.taboogame.TabooGame;
import perisic.luka.taboogame.base.BaseActivity;
import perisic.luka.taboogame.ui.game.list.GameListFragment;
import perisic.luka.taboogame.ui.game.play.PlayFragment;

public class GameActivity extends BaseActivity implements Observer<Boolean> {

    @Inject
    PlayViewModel viewModel;

    @Override
    protected void setupUi() {
        inflateFragment(R.id.fragment_container, new GameListFragment());
    }

    @Override
    protected void setupViewModel() {
        TabooGame.getAppComponent()
                .inject(this);
        viewModel.getInGame().observe(this, this);
    }

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_play;
    }

    @Override
    public void onChanged(@Nullable Boolean inGame) {
        if(inGame!= null){
            if(inGame){
                if(viewModel.getGameId() != 0){
                    inflateFragment(R.id.fragment_container, PlayFragment.newInstance(viewModel.getGameId()));
                }
            }else{
                inflateFragment(R.id.fragment_container, new GameListFragment());
            }
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
