package org.example.datatypes.districts;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JsonToDistricts {
  public static List<District> convertJsonToDistricts(String filePath) throws IOException {
    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();

    Type listType = new TypeToken<List<District>>() {}.getType();

    try (FileReader reader = new FileReader(filePath)) {
      return gson.fromJson(reader, listType);
    }
  }
}
