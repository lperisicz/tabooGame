package perisic.luka.taboogame.ui.game.list;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import perisic.luka.taboogame.R;
import perisic.luka.taboogame.TabooGame;
import perisic.luka.taboogame.base.BaseFragment;
import perisic.luka.taboogame.data.local.model.GameModel;
import perisic.luka.taboogame.ui.game.PlayViewModel;
import perisic.luka.taboogame.util.OnItemClick;

public class GameListFragment extends BaseFragment implements Observer<List<GameModel>>,OnItemClick {

    @BindView(R.id.game_list_recycler)
    RecyclerView recyclerView;

    @Inject
    PlayViewModel viewModel;
    private GameAdapter adapter;

    @Override
    protected void setupViewModel() {
        TabooGame.getAppComponent()
                .inject(this);
//        if(getActivity() != null){
//            viewModel = ViewModelProviders.of(getActivity()).get(PlayViewModel.class);
//        }
    }

    @Override
    protected void setupUi() {
        adapter = new GameAdapter(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void observeData() {
        viewModel.getAllGames().observe(this, this);
    }

    @Override
    protected int setLayoutResource() {
        return R.layout.fragment_game_list;
    }

    @Override
    public void onChanged(@Nullable List<GameModel> gameModels) {
        if(gameModels != null){
            adapter.addItems(gameModels);
        }
    }

    @Override
    public void onItemClick(int id) {
        viewModel.setInGame(true);
        viewModel.setGameId(id);
    }
}
