package com.polippo.wearbootcamp03

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.adapter_meal.view.*

class MealListAdapter(
    private val meals: MutableList<com.polippo.sharedlib.Meal>,
    private val callback: Callback?
    ): RecyclerView.Adapter<MealListAdapter.MealViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealListAdapter.MealViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_meal, parent, false)
        return  MealViewHolder(view)
    }

    override fun onBindViewHolder(holder: MealListAdapter.MealViewHolder, position: Int) {
        val meal = meals[position]
        holder.itemView.title.text = meal.title
        holder.itemView.ingredients.text = meal.ingredients.joinToString(separator = ", ")
        holder.itemView.calories.text = meal.calories.toString()
        holder.itemView.star.visibility = if(meal.favored) View.VISIBLE else View.INVISIBLE
        holder.itemView.setOnClickListener {
             callback?.mealClicked(meal)
        }
    }

    fun updateMeal(meal: com.polippo.sharedlib.Meal){
        for((index, value) in meals.withIndex()){
            if(value.title == meal.title){
                meals[index] = meal
            }
        }
        notifyDataSetChanged()
    }

    override fun getItemCount() = meals.size

    inner class MealViewHolder(view: View): RecyclerView.ViewHolder(view)

    interface Callback{
        fun mealClicked(meal: com.polippo.sharedlib.Meal)
    }

}