package perisic.luka.taboogame.ui.game.play;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

import perisic.luka.taboogame.data.local.model.GameModel;
import perisic.luka.taboogame.data.local.model.WordModel;

public class WordViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<WordModel> dataList = new ArrayList<>();
    private OnAnswerClick listener;

    public WordViewPagerAdapter(FragmentManager fm, OnAnswerClick listener) {
        super(fm);
        this.listener = listener;
    }

    @Override
    public Fragment getItem(int position) {

        return WordFragment.newInstance(dataList.get(position));
    }

    @Override
    public int getCount() {
        return dataList.size();
    }

    public void addData(List<WordModel> data) {
        this.dataList.addAll(data);
    }



    public interface OnAnswerClick{
        void onAnswer(boolean isCorrect);
    }
}
