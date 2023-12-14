package com.systematic.doosystematic.utils;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.systematic.doosystematic.domain.entities.Article;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class JSONParser {

    public static List<Article> parseJSONFile(String filePath) {
        try {
            Gson gson = new Gson();
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            Type listType = new com.google.gson.reflect.TypeToken<List<Article>>() {}.getType();
            List<Article> articles = gson.fromJson(reader, listType);

            reader.close();

            return articles;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            System.out.println("O arquivo selecionado não é um JSON válido");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}