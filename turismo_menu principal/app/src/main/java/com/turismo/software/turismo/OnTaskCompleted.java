package com.turismo.software.turismo;

/**
 * Created by Clases on 30/05/2015.
 */import java.util.HashMap;
import java.util.List;
public interface OnTaskCompleted {
    void onTaskCompleted(List<List<HashMap<String, String>>> jsonObj);
}
