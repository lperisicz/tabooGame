package perisic.luka.taboogame.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutResource());
        ButterKnife.bind(this);
        setupViewModel();
        setupUi();
//        observeData();
//        fetchData();
    }

    protected abstract void setupUi();

    protected abstract void setupViewModel();

    protected abstract int setLayoutResource();

    protected void inflateFragment(int containerId, Fragment fragment){
        getSupportFragmentManager().beginTransaction().replace(containerId, fragment).commit();
    }
}