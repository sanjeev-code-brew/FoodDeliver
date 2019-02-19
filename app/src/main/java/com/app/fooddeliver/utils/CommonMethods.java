package com.app.fooddeliver.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import com.app.fooddeliver.R;

/**
 * Created by 123 on 30-Jan-18.
 */

public class CommonMethods {

    public static void languagedialog(final boolean isEnglishLang, final LanguageListener languageListener, Context context) {
        final Dialog mDialog = new Dialog(context, R.style.MyDialog);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = mDialog.getWindow();
        window.setGravity(Gravity.CENTER);
        window.setGravity(Gravity.CENTER_VERTICAL);
        window.setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.transparent_image)));
        mDialog.setContentView(R.layout.lang_dialog);
        mDialog.setCancelable(true);

        TextView tvArabic = mDialog.findViewById(R.id.tvArabic);
        TextView tvEnglish = mDialog.findViewById(R.id.tvEnglish);

        if (isEnglishLang) {
            tvEnglish.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.lang_tick_padding, 0);
            tvArabic.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        } else {
            tvEnglish.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
            tvArabic.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.lang_tick_padding, 0);
        }


        tvArabic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvEnglish.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                tvArabic.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.lang_tick_padding, 0);
                languageListener.arabicSelected();
                mDialog.hide();
            }
        });

        tvEnglish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tvArabic.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                tvEnglish.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.lang_tick_padding, 0);
                languageListener.englishSelected();
                mDialog.hide();
            }
        });

        mDialog.show();
    }

    public static void commonDialog(final String type, final YesNoDialogListener yesNoDialogListener, Context context) {
        final Dialog mDialog = new Dialog(context, R.style.MyDialog);
        mDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        Window window = mDialog.getWindow();
        window.setGravity(Gravity.CENTER);
        window.setGravity(Gravity.CENTER_VERTICAL);
        window.setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(R.color.transparent_image)));
        mDialog.setContentView(R.layout.common_dialog);
        mDialog.setCancelable(true);

        TextView tvCancel = mDialog.findViewById(R.id.tvCancel);
        TextView tvYes = mDialog.findViewById(R.id.tvYes);


        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yesNoDialogListener.onNoClicked();
                mDialog.hide();
            }
        });

        tvYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                yesNoDialogListener.onYesClicked();
                mDialog.hide();
            }
        });

        mDialog.show();
    }


}
