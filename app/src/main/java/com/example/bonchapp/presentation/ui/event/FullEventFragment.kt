package com.example.bonchapp.presentation.ui.event

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.bonchapp.R
import com.example.bonchapp.router.MainRouter
import com.example.bonchapp.presentation.presenter.event.FullEventPresenter
import com.example.bonchapp.router.MainCoordinator
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.fragment_full_event.*


class FullEventFragment : BottomSheetDialogFragment() {

    val presenter =
        FullEventPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_full_event, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fab.setOnClickListener { presenter.onRegButtonPress(it) }
        presenter.onCreate()

        orgInfoView.setOnClickListener {
            MainCoordinator.navigateToOrgInfo(this)
        }
    }


    companion object{
        val fragment = FullEventFragment()
    }


}