package com.bondan.githubuserapp.view.favorites

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.bondan.githubuserapp.model.database.FavoriteUser
import com.bondan.githubuserapp.model.repository.FavoriteUserRepository

class FavoriteUserViewModel(application: Application) : ViewModel() {
	private val mFavoriteUserRepository: FavoriteUserRepository = FavoriteUserRepository(application)

	fun getAllFavorites(): LiveData<List<FavoriteUser>> = mFavoriteUserRepository.getAllFavorites()
}