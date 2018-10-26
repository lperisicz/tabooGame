package perisic.luka.taboogame.ui.add;

import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;
import perisic.luka.taboogame.R;
import perisic.luka.taboogame.data.local.model.WordModel;

public class WordAdapter extends RecyclerView.Adapter<WordAdapter.WordViewHolder> {

    private List<WordModel> dataList = new ArrayList<>();

    @NonNull
    @Override
    public WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater
                .from(parent.getContext())
                .inflate(
                        R.layout.item_new_word,
                        parent,
                        false
                );
        return new WordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordViewHolder holder, int position) {
        holder.bindData(dataList.get(position));
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public List<WordModel> getDataList() {
        return dataList;
    }

    public void addItem() {
        dataList.add(new WordModel());
        notifyItemChanged(dataList.size() - 1);
    }

    class WordViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.word_to_guess)
        EditText wordToGuess;
        @OnTextChanged(R.id.word_to_guess)
        public void onChanged(){
            dataList.get(getAdapterPosition()).setWord(
                    wordToGuess.getText().toString()
            );
        }

        @BindView(R.id.new_taboo_word_edit_text)
        EditText newTabooWord;
        @OnClick(R.id.new_taboo_word_button)
        public void onNewTabooWord(){
            dataList.get(getAdapterPosition())
                    .getTabooWords()
                    .add(newTabooWord.getText().toString());
            adapter.additem(newTabooWord.getText().toString());
        }

        private TabooAdapter adapter;

        public WordViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void bindData(WordModel wordModel) {
            adapter = new TabooAdapter();
            adapter.addItems(wordModel.getTabooWords());
            tabooRecycler.setLayoutManager(
                    new LinearLayoutManager(itemView.getContext())
            );
            tabooRecycler.setAdapter(
                    adapter
            );
        }

        @BindView(R.id.taboo_recycler)
        RecyclerView tabooRecycler;
    }

}
