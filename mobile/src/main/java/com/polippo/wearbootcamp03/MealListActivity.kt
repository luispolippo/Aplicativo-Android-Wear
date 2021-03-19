package com.polippo.wearbootcamp03

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_meal.*

class MealListActivity : AppCompatActivity(), MealListAdapter.Callback {

    private var adapter: MealListAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meal)
        val meals = MealStore.fetchMeals(this)
        adapter = MealListAdapter(meals, this)
        list.adapter = adapter
        list.layoutManager = LinearLayoutManager(this)
    }

    override fun mealClicked(meal: Meal) {
        TODO("Not yet implemented")
    }
}