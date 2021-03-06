package com.polippo.wearbootcamp03

import android.content.Context
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.BufferedReader
import java.io.InputStreamReader

object MealStore {

    fun fetchMeals(context: Context): MutableList<com.polippo.sharedlib.Meal>{
        val stream = context.resources.openRawResource(R.raw.meal)
        val reader = BufferedReader(InputStreamReader(stream, "UTF-8"))
        val listType = object: TypeToken<ArrayList<com.polippo.sharedlib.Meal>>() {}.type
        return Gson().fromJson(reader, listType)
    }

}