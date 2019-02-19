package com.app.fooddeliver.utils

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.provider.Settings
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import com.app.fooddeliver.R
import com.app.fooddeliver.utils.AlertDialogUtil


object PermissionUtil {

    fun hasPermission(activity: Activity, permission: String): Boolean {
        return ContextCompat.checkSelfPermission(activity, permission) == PackageManager.PERMISSION_GRANTED
    }


    fun requestPermission(activity: Activity, requestCode: Int, permission: String,
                          descResId: Int) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {

            AlertDialogUtil.getInstance().createOkCancelDialog(activity, 0,
                    descResId, R.string.yes, R.string.no, true,
                    object : AlertDialogUtil.OnOkCancelDialogListener {
                        override fun onOkButtonClicked() {

                        }

                        override fun onCancelButtonClicked() {

                        }
                    })
        } else {
            ActivityCompat.requestPermissions(activity, arrayOf(permission), requestCode)
        }
    }


    fun requestPermission(activity: Activity, requestCode: Int, permissions: Array<String>,
                          descResId: Int) {

        var needToShowRationale = false

        for (permission in permissions) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(activity, permission)) {
                needToShowRationale = true
                break
            }
        }


        if (needToShowRationale) {
            AlertDialogUtil.getInstance().createOkCancelDialog(activity, R.string.permission_req,
                    descResId, R.string.yes, R.string.no, true,
                    object : AlertDialogUtil.OnOkCancelDialogListener {

                        override fun onOkButtonClicked() {
                            val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                            val uri = Uri.fromParts("package", activity.packageName, null)
                            intent.data = uri
                            activity.startActivity(intent)
                        }

                        override fun onCancelButtonClicked() {
                            //do nothing
                        }
                    }).show()
        } else {
            ActivityCompat.requestPermissions(activity, permissions, requestCode)
        }
    }


}
