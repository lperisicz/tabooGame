package perisic.luka.taboogame.ui.game.play;

import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;

import javax.inject.Inject;

import butterknife.BindView;
import perisic.luka.taboogame.R;
import perisic.luka.taboogame.TabooGame;
import perisic.luka.taboogame.base.BaseFragment;
import perisic.luka.taboogame.data.local.model.GameModel;
import perisic.luka.taboogame.ui.game.PlayViewModel;

public class PlayFragment extends BaseFragment implements Observer<GameModel>,WordViewPagerAdapter.OnAnswerClick {

    public static final String BUNDLE_KEY = PlayFragment.class.getSimpleName() + "bundle_key";

    @BindView(R.id.word_view_pager)
    ViewPager viewPager;

    @Inject
    PlayViewModel viewModel;
    private WordViewPagerAdapter adapter;
    private int id;

    public static PlayFragment newInstance(int gameId) {
        Bundle args = new Bundle();
        args.putInt(BUNDLE_KEY, gameId);
        PlayFragment fragment = new PlayFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setupViewModel() {
        TabooGame.getAppComponent()
                .inject(this);

    }

    @Override
    protected void setupUi() {
        if (getArguments() != null) {
            id = getArguments().getInt(BUNDLE_KEY, -1);
        }
    }

    @Override
    protected void observeData() {
        if (id != -1) {
            viewModel.getGame(id).observe(this, this);
        }
    }

    @Override
    protected int setLayoutResource() {
        return R.layout.fragment_play;
    }

    @Override
    public void onChanged(@Nullable GameModel gameModel) {
        if(gameModel != null){
            adapter = new WordViewPagerAdapter(getFragmentManager(), gameModel.getGameWords(), this);
            viewPager.setAdapter(adapter);
        }
    }

    @Override
    public void onAnswer(boolean isCorrect) {

    }
}
