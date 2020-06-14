<<<<<<< HEAD:app/src/main/java/com/example/bonchapp/presentation/ui/profile/LogoutDialogFragment.kt
package com.example.bonchapp.presentation.ui.profile
=======
package com.example.bonchapp.presentation.ui.profile.settings
>>>>>>> StudentProfile:app/src/main/java/com/example/bonchapp/presentation/ui/profile/settings/LogoutDialogFragment.kt

import com.example.bonchapp.R
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment


class LogoutDialogFragment : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder =
            AlertDialog.Builder(requireActivity())
        return builder
            .setTitle(getString(R.string.text_warningLogout))
            .setMessage("Вы будете отчислены")
            .setPositiveButton("Пофиг", null)
            .setNegativeButton("Не пофиг", null)

            .create()//.getButton(AlertDialog.BUTTON_NEGATIVE).setTextColor(R.color.colorTextBlue);
        //return builder.setView(R.layout.fragment_logout_dialog).create()
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
