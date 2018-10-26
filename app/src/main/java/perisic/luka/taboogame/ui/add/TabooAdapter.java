package perisic.luka.taboogame.ui.add;

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

public class TabooAdapter extends RecyclerView.Adapter<TabooAdapter.TabooViewHolder> {

    private List<String> dataList = new ArrayList<>();

    @NonNull
    @Override
    public TabooViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_taboo_text, parent, false);
        return new TabooViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TabooViewHolder holder, int position) {
        holder.bindData(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void additem(String item){
        dataList.add(item);
        notifyDataSetChanged();
    }

    public List<String> getDataList() {
        return dataList;
    }

    public void addItems(List<String> tabooWords) {
        if(tabooWords != null){
            dataList.clear();
            dataList.addAll(tabooWords);
            notifyDataSetChanged();
        }
    }

    class TabooViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.taboo_word)
        TextView taboo_word;

        public TabooViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindData(String text){
            taboo_word.setText(text);
        }
    }
}
