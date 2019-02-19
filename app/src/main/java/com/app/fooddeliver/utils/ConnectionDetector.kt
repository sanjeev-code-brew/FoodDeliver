package com.app.fooddeliver.utils

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.provider.Settings
import android.support.v7.app.AlertDialog
import com.app.fooddeliver.R


private fun showNoInternetDialog(context: Context) {
    AlertDialog.Builder(context)
            .setCancelable(false)
            .setTitle(context.getString(R.string.internet))
            .setMessage(context.getString(R.string.check_internet))
            .setPositiveButton(context.getString(R.string.ok)) { _, _ ->
                val intent = Intent(Settings.ACTION_SETTINGS)
                context.startActivity(intent)
            }.show()
}

/*  fun showRetrofitErrorToast() {
      Toast.makeText(context, context.getString(R.string.might_problem), Toast.LENGTH_LONG).show()
  }*/

fun isConnectingToInternet(context: Context, showAlert: Boolean): Boolean {
    val connectivity = context
            .getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = connectivity.activeNetworkInfo

    return if (activeNetwork != null && activeNetwork.isConnected)
        true
    else {
        if (showAlert)
            showNoInternetDialog(context)
        false
    }
}