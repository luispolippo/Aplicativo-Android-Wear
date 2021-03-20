package com.polippo.wear

import android.app.Activity
import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import android.util.Log
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.wearable.Wearable
import com.google.gson.Gson
import com.polippo.shared.Meal
import kotlinx.android.synthetic.main.activity_wear.*

class WearActivity :Activity(), GoogleApiClient.ConnectionCallbacks {

    private lateinit var client: GoogleApiClient
    private var currentMeal: Meal? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wear)
    }

    override fun onConnected(p0: Bundle?) {
        Wearable.MessageApi.addListener(client){ messageEvent ->
            currentMeal = Gson().fromJson(String(messageEvent.data), Meal::class.java)
            updateView()
        }
    }

    override fun onConnectionSuspended(p0: Int) {
        Log.w("Wear", "Google API Client connection suspended!")
    }

    private fun updateView() {
        currentMeal?.let {
            mealTitle.text = it.title
            calories.text = getString(R.string.calories, it.calories)
            ingredients.text = it.ingredients.joinToString(separator = ", ")

        }
    }


}