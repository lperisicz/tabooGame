package perisic.luka.taboogame.ui.game.play;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import perisic.luka.taboogame.R;
import perisic.luka.taboogame.base.BaseFragment;
import perisic.luka.taboogame.data.local.model.WordModel;
import perisic.luka.taboogame.ui.add.TabooAdapter;
import perisic.luka.taboogame.ui.add.WordAdapter;

public class WordFragment extends BaseFragment {

    public static final String BUNDLE_KEY = WordFragment.class.getSimpleName() + "bundleKey";

    @BindView(R.id.wordTextView)
    TextView wordText;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @OnClick(R.id.button_wrong)
    public void onWrong(){}
    @OnClick(R.id.button_correct)
    public void onCorrect(){}

    private WordModel wordModel;
    private TabooAdapter adapter;

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
        adapter = new TabooAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
        if(getArguments() != null){
            wordModel = getArguments().getParcelable(BUNDLE_KEY);
            if(wordModel != null){
                wordText.setText(wordModel.getWord());
                adapter.addItems(wordModel.getTabooWords());
            }
        }
    }

    @Override
    protected void observeData() {

    }

    @Override
    protected int setLayoutResource() {
        return R.layout.fragment_word;
    }
}
