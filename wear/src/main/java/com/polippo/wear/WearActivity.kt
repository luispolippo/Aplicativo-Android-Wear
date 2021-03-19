package com.polippo.wear

import android.os.Bundle
import android.support.wearable.activity.WearableActivity

class WearActivity : WearableActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wear)

        // Enables Always-on
        setAmbientEnabled()
    }
}