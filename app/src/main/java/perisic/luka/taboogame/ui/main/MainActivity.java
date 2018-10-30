package perisic.luka.taboogame.ui.main;

import android.content.Intent;

import butterknife.OnClick;
import perisic.luka.taboogame.R;
import perisic.luka.taboogame.TabooGame;
import perisic.luka.taboogame.base.BaseActivity;
import perisic.luka.taboogame.ui.add.AddGameActivity;
import perisic.luka.taboogame.ui.game.GameActivity;

public class MainActivity extends BaseActivity {

    @OnClick(R.id.play_image_view)
    public void onPlayClick(){startActivity(new Intent(this, GameActivity.class));}

    @OnClick(R.id.add_game_image_view)
    public void onAddGameClick(){startActivity(new Intent(this, AddGameActivity.class));}

    @OnClick(R.id.exit_image_view)
    public void onExitClick(){onBackPressed();}

    @Override
    protected void setupUi() {

    }

    @Override
    protected void setupViewModel() {
        TabooGame
                .getAppComponent()
                .inject(this);
    }

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_main;
    }
}