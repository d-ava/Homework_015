package com.example.homework_015

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore


val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "userInfo")
val firstNameKey = stringPreferencesKey("firstName")
val lastNameKey = stringPreferencesKey("lastName")

val ageKey = stringPreferencesKey("age")

val emailKey = stringPreferencesKey("email")
val phoneKey = stringPreferencesKey("phone")
val genderKey = stringPreferencesKey("gender")


val imageKey = stringPreferencesKey("image")