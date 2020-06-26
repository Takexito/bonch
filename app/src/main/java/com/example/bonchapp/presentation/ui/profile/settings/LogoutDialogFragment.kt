package com.example.bonchapp.presentation.ui.profile.settings

import com.example.bonchapp.R
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.example.bonchapp.presentation.App
import com.example.bonchapp.router.Constants
import com.example.bonchapp.router.MainCoordinator
import com.example.bonchapp.router.MainRouter
import kotlinx.android.synthetic.main.fragment_logout.*
import javax.inject.Inject
import kotlin.system.exitProcess


class LogoutDialogFragment : DialogFragment() {

    @Inject
    lateinit var router: MainRouter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_logout, container, false)
    }

    init{
        App.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        logout_exit.setOnClickListener {
            logout()
            //MainCoordinator.navigateToAuthorization(this)
            exitProcess(0)
        }

        logout_cancel.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun logout(){
        val sp = requireActivity().getSharedPreferences(Constants.APP_PREFERENCE, Context.MODE_PRIVATE)
        sp.edit().remove(Constants.TOKEN).apply()
    }
}
