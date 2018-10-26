package perisic.luka.taboogame.ui.splash;

import android.content.Intent;

import java.util.Timer;
import java.util.TimerTask;

import perisic.luka.taboogame.R;
import perisic.luka.taboogame.base.BaseActivity;
import perisic.luka.taboogame.ui.main.MainActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected int setLayoutResource() {
        return R.layout.activity_splash;
    }

    @Override
    protected void setupUi() {
        startTimer();
    }

    @Override
    protected void setupViewModel() {

    }

    //region HELPER_METHODS

    private void startTimer() {
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                startMain();
            }
        }, 2500);
    }

    private void startMain() {
        startActivity(
                new Intent(this, MainActivity.class)
        );
    }

    //endregion
}
