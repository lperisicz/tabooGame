package perisic.luka.taboogame.ui.game.play;

import android.annotation.SuppressLint;
import android.arch.lifecycle.Observer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

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
    @BindView(R.id.timeRemainingText)
    TextView timeRemainingText;
    @BindView(R.id.first_frame)
    FrameLayout firstFrame;
    @BindView(R.id.second_frame)
    FrameLayout secondFrame;
    @BindView(R.id.player1_score)
    TextView player1Score;
    @BindView(R.id.player2_score)
    TextView player2Score;

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

    @SuppressLint("ClickableViewAccessibility")
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
            viewModel.getFirstScore().observe(this, new Observer<Integer>() {
                @Override
                public void onChanged(@Nullable Integer integer) {
                    player1Score.setText(String.valueOf(integer));
                }
            });
            viewModel.getSecondScore().observe(this, new Observer<Integer>() {
                @Override
                public void onChanged(@Nullable Integer integer) {
                    player2Score.setText(String.valueOf(integer));
                }
            });
            viewModel.getIsFirstTurn().observe(this, new Observer<Boolean>() {
                @Override
                public void onChanged(@Nullable Boolean aBoolean) {
                    if(aBoolean != null){
                        if(aBoolean){
                            firstFrame.setVisibility(View.VISIBLE);
                            secondFrame.setVisibility(View.GONE);
                        }else{
                            secondFrame.setVisibility(View.VISIBLE);
                            firstFrame.setVisibility(View.GONE);
                        }
                    }
                }
            });
            viewModel.getTimeRemaining().observe(this, new Observer<Long>() {
                @Override
                public void onChanged(@Nullable Long aLong) {
                    if (aLong != null) {
                        long time = aLong/1000L;
                        timeRemainingText.setText(String.valueOf(time));
                    }

                }
            });
            viewModel.startTimer();
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
        viewModel.setAnswer(isCorrect);
        viewPager.setCurrentItem(
                viewPager.getCurrentItem() + 1
        );
    }
}
