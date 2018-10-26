package perisic.luka.taboogame.data.local.model;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.ArrayList;
import java.util.List;

@Entity(tableName = "wordData")
public class WordModel {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "word")
    private String word;

    @ColumnInfo(name = "tabooWords")
    private List<String> tabooWords;

    @Ignore
    public WordModel() {
        tabooWords = new ArrayList<>();
    }

    public WordModel(String word, List<String> tabooWords) {
        this.word = word;
        this.tabooWords = tabooWords;
    }

    public int getId() {
        return id;
    }

    public String getWord() {
        return word;
    }

    public List<String> getTabooWords() {
        return tabooWords;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setId(int id) {
        this.id = id;
    }
}
