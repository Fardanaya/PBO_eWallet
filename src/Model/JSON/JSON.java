package Model.JSON;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.JsonArray;

public abstract class JSON<T> {
    public final String fname;

    public JSON(String fname) {
        this.fname = fname;
        setupFile();
    }

    public abstract boolean checkFile();

    public abstract void setupFile();

    public abstract JsonArray convertListToJsonArray(ArrayList<T> list);

    public abstract ArrayList<T> convertJsonArrayToList(JsonArray jsonArray, Type type);

    public abstract void writeToFile(ArrayList<T> list);

    public abstract ArrayList<T> readFromFile(Type type);
}
