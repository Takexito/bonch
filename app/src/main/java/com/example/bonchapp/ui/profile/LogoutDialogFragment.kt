package com.example.bonchapp.ui.profile

import android.R
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment


class LogoutDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder =
            AlertDialog.Builder(activity!!)
        return builder
            .setTitle("Вы действительно хотите покинуть личный кабинет?")
            .setIcon(R.drawable.ic_dialog_alert)
            .setMessage("Вы будете отчислены")
            .setPositiveButton("Пофиг", null)
            .setNegativeButton("Не пофиг", null)
            .create()
    }

    fun onClick(dialog: DialogInterface?, which: Int) {

    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
    }

    override fun onCancel(dialog: DialogInterface) {
        super.onCancel(dialog)
    }
}