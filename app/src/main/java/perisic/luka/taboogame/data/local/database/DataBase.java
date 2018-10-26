package perisic.luka.taboogame.data.local.database;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;

import perisic.luka.taboogame.data.local.dao.GameModelDao;
import perisic.luka.taboogame.data.local.model.GameModel;
import perisic.luka.taboogame.data.local.model.WordModel;
import perisic.luka.taboogame.util.RoomUtilConverter;

@Database(entities = {GameModel.class, WordModel.class}, version = 1, exportSchema = false)
@TypeConverters({RoomUtilConverter.class})
public abstract class DataBase extends RoomDatabase {

    public abstract GameModelDao gameModelDao();

}