package perisic.luka.taboogame.data.local.model;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;

import java.util.List;

import perisic.luka.taboogame.util.RoomUtilConverter;

@Entity(tableName = "gameData")
public class GameModel {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "gameTitle")
    private String title;

    @ColumnInfo(name = "gameWords")
    private List<WordModel> gameWords;

    public GameModel(String title, List<WordModel> gameWords) {
        this.title = title;
        this.gameWords = gameWords;
    }

    public int getId() {
        return id;
    }

    public List<WordModel> getGameWords() {
        return gameWords;
    }

    public String getTitle() {
        return title;
    }

    public void setId(int id) {
        this.id = id;
    }
}
