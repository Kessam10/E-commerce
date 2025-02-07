package com.example.data.request

import com.google.gson.annotations.SerializedName

data class LoginRequestModel(

	@field:SerializedName("password")
	val password: String? = null,

	@field:SerializedName("email")
	val email: String? = null
)
