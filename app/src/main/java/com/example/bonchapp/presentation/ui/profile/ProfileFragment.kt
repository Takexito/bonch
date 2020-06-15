package com.example.bonchapp.presentation.ui.profile

import android.os.Bundle
import android.preference.PreferenceManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.bonchapp.R
import com.example.bonchapp.domain.entities.AccountDTO
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

    lateinit var root: View


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        root = inflater.inflate(R.layout.fragment_profile, container, false)

        return root
    }

    init {
        App.appComponent.inject(this)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initBtn()
        initAdapter()
        presenter.attachView(this)
        presenter.updateData()
    }

    private fun initAdapter() {
        adapter = ProfilePagerAdapter(
            requireActivity()
        )
        profileViewPager.adapter = adapter

        TabLayoutMediator(profileTabLayout, profileViewPager, object : TabLayoutMediator.TabConfigurationStrategy {
            override fun onConfigureTab(tab: TabLayout.Tab, position: Int) {
                when(position){
                    0 -> tab.text = resources.getText(R.string.text_profile_tab_debt)
                    1 -> tab.text = resources.getText(R.string.text_profile_tab_record)
                    2 -> tab.text = resources.getText(R.string.text_profile_tab_groupFiles)
                    3 -> tab.text = resources.getText(R.string.text_profile_tab_electives)
                }

                // Styling each tab here
            }
        }).attach()

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(root.context)
        var lang = sharedPreferences.getString("lang", "ru")!!

        if(lang == "en")
            profileTabLayout.tabMode = TabLayout.MODE_FIXED
        else
            profileTabLayout.tabMode = TabLayout.MODE_SCROLLABLE

    }

    private fun initBtn() {
        settings.setOnClickListener {
            MainRouter().navigateToSettings(this)
        }
    }

    override fun setData(data: AccountDTO){
        root.findViewById<TextView>(R.id.profileStudentName).text = data.fullname
        root.findViewById<TextView>(R.id.profileGroup).text = data.group
    }
}
