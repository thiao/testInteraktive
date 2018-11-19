package com.interaktive.test.helper;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;

public class DialogHelper {

    public static Dialog createAlertDialog(Activity context, String message, String positiveText,
                                           DialogInterface.OnClickListener positiveHandler){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message);
        builder.setPositiveButton(positiveText, positiveHandler);
        return builder.create();
    }

    public static Dialog createConfirmDialog(Activity context, String message, String positiveText,
                                             String negativeText,
                                             DialogInterface.OnClickListener positiveHandler,
                                             DialogInterface.OnClickListener negativeHandler){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message);
        builder.setPositiveButton(positiveText, positiveHandler);
        builder.setNegativeButton(negativeText, negativeHandler);
        return builder.create();
    }

    public static Dialog createCustomDialog(Activity context, View view, String positiveText,
                                            String negativeText,
                                            DialogInterface.OnClickListener positiveHandler,
                                            DialogInterface.OnClickListener negativeHandler){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        if(positiveText != null && positiveHandler != null)
            builder.setView(view).setPositiveButton(positiveText, positiveHandler);

        if(negativeText != null && negativeHandler != null)
            builder.setView(view).setNegativeButton(negativeText,negativeHandler);


        return builder.create();
    }

    public static View getInflatedView(Activity context, int layoutId){
        LayoutInflater inflater = context.getLayoutInflater();
        return inflater.inflate(layoutId, null);
    }

}
