package com.example.bonchapp.presentation.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bonchapp.R
import com.example.bonchapp.presentation.App
import com.example.bonchapp.presentation.presenter.profile.ProfilePresenter
import com.example.bonchapp.router.MainRouter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.fragment_profile.*
import javax.inject.Inject


class ProfileFragment : Fragment(),IProfileView {

    @Inject
    lateinit var presenter: ProfilePresenter

    lateinit var adapter: ProfilePagerAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_profile, container, false)

        return root
    }

    init {
        App.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBtn()
        initAdapter()
    }

    private fun initAdapter() {
        adapter = ProfilePagerAdapter(
            requireActivity()
        )
        profileViewPager.adapter = adapter

        TabLayoutMediator(profileTabLayout, profileViewPager, object : TabLayoutMediator.TabConfigurationStrategy {
            override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                when(position){
                    0 -> tab.text = "Задолженность"
                    1 -> tab.text = "Зачетка"
                    2 -> tab.text = "Файлы группы"
                    3 -> tab.text = "Факультативы"
                }

                // Styling each tab here
            }
        }).attach()

    }

    private fun initBtn() {
        settings.setOnClickListener {
            //MainRouter.navigateToSettings(this)
            adapter.notifyDataSetChanged()
        }
    }
}
