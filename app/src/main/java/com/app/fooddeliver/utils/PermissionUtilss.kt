package com.app.fooddeliver.utils


import android.content.Context
import android.content.Intent
import android.net.Uri
import android.provider.Settings
import android.support.annotation.StringRes
import android.support.v7.app.AlertDialog
import com.app.fooddeliver.R
import permissions.dispatcher.PermissionRequest


object PermissionUtilss {
    fun showRationalDialog(context: Context, @StringRes messageResId: Int, request: PermissionRequest) {
        AlertDialog.Builder(context)
                .setPositiveButton(R.string.permission_btn_allow) { _, _ -> request.proceed() }
                .setNegativeButton(R.string.permission_btn_deny) { _, _ -> request.cancel() }

                .setCancelable(false)
                .setMessage(messageResId)
                .show()
    }

    fun showAppSettingsDialog(context: Context, @StringRes messageResId: Int) {
        AlertDialog.Builder(context)
                .setPositiveButton(R.string.okay) { _, _ ->
                    val intent = Intent()
                    intent.action = Settings.ACTION_APPLICATION_DETAILS_SETTINGS
                    intent.data = Uri.fromParts("package", context.packageName, null)
                    context.startActivity(intent)
                }
                .setNegativeButton(R.string.cancel) { dialog, _ -> dialog.dismiss() }
                .setCancelable(false)
                .setMessage(messageResId)
                .show()
    }
}

