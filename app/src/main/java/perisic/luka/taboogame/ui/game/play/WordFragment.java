package perisic.luka.taboogame.ui.game.play;

import android.os.Bundle;

import perisic.luka.taboogame.R;
import perisic.luka.taboogame.base.BaseFragment;
import perisic.luka.taboogame.data.local.model.WordModel;

public class WordFragment extends BaseFragment {

    public static final String BUNDLE_KEY = WordFragment.class.getSimpleName() + "bundleKey";

    public static WordFragment newInstance(WordModel wordModel) {
        Bundle args = new Bundle();
        args.putParcelable(BUNDLE_KEY, wordModel);
        WordFragment fragment = new WordFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setupViewModel() {

    }

    @Override
    protected void setupUi() {

    }

    @Override
    protected void observeData() {

    }

    @Override
    protected int setLayoutResource() {
        return R.layout.fragment_word;
    }
}
