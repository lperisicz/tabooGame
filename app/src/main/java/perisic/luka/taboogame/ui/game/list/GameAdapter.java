package perisic.luka.taboogame.ui.game.list;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import perisic.luka.taboogame.R;
import perisic.luka.taboogame.data.local.model.GameModel;
import perisic.luka.taboogame.util.OnItemClick;

public class GameAdapter extends RecyclerView.Adapter<GameAdapter.GameViewHolder> {

    private OnItemClick listener;
    private List<GameModel> dataList = new ArrayList<>();

    public GameAdapter(OnItemClick listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public GameViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_game, parent, false);
        return new GameViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameViewHolder holder, int position) {
        holder.bindData(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addItems(List<GameModel> gameModel){
        dataList.addAll(gameModel);
        notifyDataSetChanged();
    }

    class GameViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.game_title)
        TextView gameTitle;

        GameViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindData(GameModel gameModel) {

            if(gameModel != null){
                gameTitle.setText(gameModel.getTitle());
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        listener.onItemClick(
                                dataList.get(getAdapterPosition())
                                .getId()
                        );
                    }
                });
            }
        }
    }

}
