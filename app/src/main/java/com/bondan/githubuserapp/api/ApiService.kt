package com.bondan.githubuserapp.api

import com.bondan.githubuserapp.BuildConfig
import com.bondan.githubuserapp.model.response.DetailResponse
import com.bondan.githubuserapp.model.response.GithubUser
import com.bondan.githubuserapp.model.response.UserResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

	@GET("search/users")
	@Headers("Authorization: token ${BuildConfig.GITHUB_TOKEN}")
	fun searchUser(
		@Query("q") login: String
	): Call<UserResponse>

	@GET("users/{login}")
	@Headers("Authorization: token ${BuildConfig.GITHUB_TOKEN}")
	fun getUserDetail(
		@Path("login") login: String
	): Call<DetailResponse>

	@GET("users/{login}/followers")
	@Headers("Authorization: token ${BuildConfig.GITHUB_TOKEN}")
	fun getUserFollowers(
		@Path("login") login: String
	): Call<List<GithubUser>>

	@GET("users/{login}/following")
	@Headers("Authorization: token ${BuildConfig.GITHUB_TOKEN}")
	fun getUserFollowings(
		@Path("login") login: String
	): Call<List<GithubUser>>
}