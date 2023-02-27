package com.learnandroid.loginapplication

import android.annotation.SuppressLint
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class AppDataStore(private val context: Context) {
    private val Context.datastore: DataStore<Preferences> by preferencesDataStore(name = "app_dataStore")
    private val NAME = stringPreferencesKey(name = "name")
    private val EMAIL_ADDRESS = stringPreferencesKey(name = "email_address")
    private val PASSWORD = stringPreferencesKey(name = "password")

    companion object {
        @SuppressLint("StaticFieldLeak")
        var INSTANCE: AppDataStore? = null
        fun getInstance(base: Context): AppDataStore? {
            if (INSTANCE == null) {
                synchronized(AppDataStore::class.java) {
                    INSTANCE = AppDataStore(base.applicationContext)
                }
            }

            return INSTANCE
        }
    }

    suspend fun setName(name: String) {
        context.datastore.edit { key ->
            key[NAME] = name
        }
    }

    suspend fun setEmail(email: String) {
        context.datastore.edit { key ->
            key[EMAIL_ADDRESS] = email
        }
    }

    suspend fun setPassword(password: String) {
        context.datastore.edit { key ->
            key[PASSWORD] = password
        }
    }

    val getName: Flow<String> = context.datastore.data.map { preferences ->
        preferences[NAME] ?: ""
    }

    val getEmail: Flow<String> = context.datastore.data.map { preferences ->
        preferences[EMAIL_ADDRESS] ?: ""
    }

    val getPassword: Flow<String> = context.datastore.data.map { preferences ->
        preferences[PASSWORD] ?: ""
    }
}