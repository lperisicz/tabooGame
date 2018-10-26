package perisic.luka.taboogame.util;

import android.arch.persistence.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

import perisic.luka.taboogame.data.local.model.WordModel;

public class RoomUtilConverter {


    //region WORD_MODEL_LIST_CONVERTER
    @TypeConverter
    public static List<WordModel> listFromString(String data){
        Gson gson = new Gson();
        if(data == null){
            return Collections.emptyList();
        }else{
            Type listType = new TypeToken<List<WordModel>>() {}.getType();
            return gson.fromJson(data, listType);
        }
    }

    @TypeConverter
    public static String modelListToString(List<WordModel> options){
        Gson gson = new Gson();
        return gson.toJson(options);
    }
    //endregion

    //region STRING_LIST_CONVERTER
    @TypeConverter
    public static List<String> stringListFromString(String data){
        Gson gson = new Gson();
        if(data == null){
            return Collections.emptyList();
        }else{
            Type listType = new TypeToken<List<String>>() {}.getType();
            return gson.fromJson(data, listType);
        }
    }

    @TypeConverter
    public static String stringListToString(List<String> options){
        Gson gson = new Gson();
        return gson.toJson(options);
    }
    //endregion


}