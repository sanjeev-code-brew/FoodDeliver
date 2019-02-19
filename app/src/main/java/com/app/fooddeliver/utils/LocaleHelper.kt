package com.app.fooddeliver.utils

import android.content.Context
import com.helpo.utils.PrefsManager
import java.util.*


/**
 * Created by cbl29 on 22/2/17.
 */
object LocaleHelper {


    fun onCreate(context: Context) {
        val lang = getPersistedData(context, Locale.getDefault().language)
        setLocale(context, lang)
    }

    fun onCreate(context: Context, defaultLanguage: String) {
        val lang = getPersistedData(context, defaultLanguage)
        setLocale(context, lang)
    }

    fun getLanguage(context: Context): String {
        return getPersistedData(context, Locale.getDefault().language)
    }

    fun setLocale(context: Context, language: String) {
        persist(context, language)
        updateResources(context, language)
    }

    private fun getPersistedData(context: Context, defaultLanguage: String): String {
        return PrefsManager.get().getString(USER_LANGUAGE, "en")
    }

    private fun persist(context: Context, language: String) {
        PrefsManager.get().save(language, USER_LANGUAGE)
    }

    private fun updateResources(context: Context, language: String) {
        val locale = Locale(language)
        Locale.setDefault(locale)
        val resources = context.resources
        val configuration = resources.configuration
        configuration.locale = locale
        configuration.setLayoutDirection(locale)
        resources.updateConfiguration(configuration, resources.displayMetrics)
    }
}