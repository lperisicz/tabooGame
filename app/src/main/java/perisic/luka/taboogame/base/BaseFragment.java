package perisic.luka.taboogame.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(setLayoutResource(), container, false);
        ButterKnife.bind(this, view);
        setupViewModel();
        setupUi();
        observeData();
        return view;

    }

    protected abstract void setupViewModel();

    protected abstract void setupUi();

    protected abstract void observeData();

    protected abstract int setLayoutResource();
}
