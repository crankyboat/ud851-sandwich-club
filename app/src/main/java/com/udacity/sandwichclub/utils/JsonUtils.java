package com.udacity.sandwichclub.utils;

import com.udacity.sandwichclub.model.Sandwich;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static List<String> parseStringListFromJsonArray(JSONArray jsonArray) throws JSONException {

        List<String> stringList = new ArrayList<String>();

        for (int i = 0; i < jsonArray.length(); i++) {
            stringList.add(jsonArray.getString(i));
        }

        return stringList;
    }

    public static Sandwich parseSandwichJson(String json) throws JSONException {

        final String SANDWICH_NAME = "name";
        final String SANDWICH_MAINNAME = "mainName";
        final String SANDWICH_ALSOKNOWNAS= "alsoKnownAs";
        final String SANDWICH_PLACEOFORIGIN = "placeOfOrigin";
        final String SANDWICH_DESCRIPTION = "description";
        final String SANDWICH_IMAGE = "image";
        final String SANDWICH_INGREDIENTS = "ingredients";

        JSONObject sandwichJson = new JSONObject(json);
        JSONObject sandwichName = sandwichJson.getJSONObject(SANDWICH_NAME);

        String mainName = sandwichName.getString(SANDWICH_MAINNAME);
        String placeOfOrigin = sandwichJson.getString(SANDWICH_PLACEOFORIGIN);
        String description = sandwichJson.getString(SANDWICH_DESCRIPTION);
        String image = sandwichJson.getString(SANDWICH_IMAGE);

        List<String> alsoKnownAs = parseStringListFromJsonArray(
                sandwichName.getJSONArray(SANDWICH_ALSOKNOWNAS));
        List<String> ingredients = parseStringListFromJsonArray(
                sandwichJson.getJSONArray(SANDWICH_INGREDIENTS));

        return new Sandwich(mainName, alsoKnownAs, placeOfOrigin, description, image, ingredients);
    }
}
