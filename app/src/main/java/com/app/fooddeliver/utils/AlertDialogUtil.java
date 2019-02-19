package com.app.fooddeliver.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.StringRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import com.app.fooddeliver.R;


/**
 * Created by Rohit Sharma on 19/12/16.
 */
public class AlertDialogUtil {

    private static AlertDialogUtil mInstance;

    public static AlertDialogUtil getInstance() {
        if (null == mInstance) {
            mInstance = new AlertDialogUtil();
        }
        return mInstance;
    }

    public AlertDialog createOkCancelDialog(final Context context, @StringRes int titleResourceId, @StringRes int messageResourceId,
                                            @StringRes int positiveResourceId, @StringRes int negativeResourceId, boolean cancelable,
                                            final OnOkCancelDialogListener listener) {
        final AlertDialog.Builder alertDialog = new AlertDialog
                .Builder(context);
        if (titleResourceId != 0) {
            alertDialog.setTitle(titleResourceId);
        }
        if (titleResourceId != 0) {
            alertDialog.setMessage(messageResourceId);
        }
        alertDialog.setCancelable(cancelable);
        alertDialog.setPositiveButton(positiveResourceId,
                (dialog, which) -> {
                    if (listener != null)
                        listener.onOkButtonClicked();
                    dialog.dismiss();
                });
        if (negativeResourceId != 0) {
            alertDialog.setNegativeButton(negativeResourceId, (dialog, which) -> {
                if (listener != null)
                    listener.onCancelButtonClicked();
                dialog.dismiss();
            });
        }
        final AlertDialog dialog = alertDialog.create();
        dialog.setOnShowListener(dialogInterface -> {
            dialog.getButton(DialogInterface.BUTTON_POSITIVE).setTextColor(ContextCompat
                    .getColor(context, R.color.colorPrimary));
            dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setTextColor(ContextCompat
                    .getColor(context, R.color.colorPrimary));
        });
        return dialog;
    }



    public interface OnOkCancelDialogListener {
        void onOkButtonClicked();

        void onCancelButtonClicked();
    }
}