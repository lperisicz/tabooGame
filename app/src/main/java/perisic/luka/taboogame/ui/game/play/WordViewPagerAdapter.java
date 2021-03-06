package perisic.luka.taboogame.ui.game.play;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import perisic.luka.taboogame.data.local.model.WordModel;

public class WordViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<WordModel> dataList;
    private OnAnswerClick listener;

    public WordViewPagerAdapter(FragmentManager fm, List<WordModel> dataList, OnAnswerClick listener) {
        super(fm);
        this.dataList = dataList;
        this.listener = listener;
    }

    @Override
    public Fragment getItem(int position) {

        return WordFragment.newInstance(dataList.get(position), listener);
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    public interface OnAnswerClick{
        void onAnswer(boolean isCorrect);
    }
}
