package com.bondan.githubuserapp.model.repository

import android.app.Application
import androidx.lifecycle.LiveData
import com.bondan.githubuserapp.model.database.FavoriteUser
import com.bondan.githubuserapp.model.database.FavoriteUserDao
import com.bondan.githubuserapp.model.database.FavoriteUserRoomDatabase
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class FavoriteUserRepository(application: Application) {
	private val mFavoriteUserDao: FavoriteUserDao
	private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

	init {
		val db = FavoriteUserRoomDatabase.getDatabase(application)
		mFavoriteUserDao = db.favoriteUserDao()
	}

	fun getAllFavorites(): LiveData<List<FavoriteUser>> = mFavoriteUserDao.getAllUser()

	fun insert(user: FavoriteUser) {
		executorService.execute { mFavoriteUserDao.insertFavorite(user) }
	}

	fun delete(id: Int) {
		executorService.execute { mFavoriteUserDao.removeFavorite(id) }
	}
}