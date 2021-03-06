package com.example.foodapp.ui.favorite

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.foodapp.model.Beverage
import com.example.foodapp.model.Restaurant
import com.example.foodapp.model.Food
import com.example.foodapp.room.FoodAppDao
import com.example.foodapp.room.FoodAppDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class FavoriteViewModel(application: Application) : ViewModel() {
    private val mfoodAppDao: FoodAppDao
    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

    init {
        val db = FoodAppDatabase.getInstance(application)
        mfoodAppDao = db.foodAppDao
    }

    fun getBeverages(): LiveData<List<Beverage>> = mfoodAppDao.getBeverage()

    fun insertBeverage(beverage: Beverage){
        executorService.execute{ mfoodAppDao.insertBeverage(beverage) }
    }

    fun deleteBeverage(beverage: Beverage){
        executorService.execute{ mfoodAppDao.deleteBeverage(beverage) }
    }

    fun getRestaurant(): LiveData<List<Restaurant>> = mfoodAppDao.getRestaurant()

    fun insertRestaurant(restaurant: Restaurant){
        executorService.execute{ mfoodAppDao.insertRestaurant(restaurant) }
    }

    fun deleteRestaurant(restaurant: Restaurant){
        executorService.execute{ mfoodAppDao.deleteRestaurant(restaurant) }
    }

    fun getFood(): LiveData<List<Food>> = mfoodAppDao.getFood()

    fun insertFood(food: Food){
        executorService.execute{ mfoodAppDao.insertFood(food) }
    }

    fun deleteFood(food: Food){
        executorService.execute{ mfoodAppDao.deleteFood(food) }
    }
}