package com.silentwolfstudios.user.weather;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

public class AlertDialogFragment extends DialogFragment { //Dialog


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {  //override onCreateDialog
        Context context = getActivity(); //Context is to tell dialog where to be displayed

        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle("Ooops..Sry")   //Setup what is displayed in the Dialog
                .setMessage("No Internet Connection") //Dialog to tell user that there is no internet connection
                .setPositiveButton("OK", null) ;

        return builder.create();
    }





}