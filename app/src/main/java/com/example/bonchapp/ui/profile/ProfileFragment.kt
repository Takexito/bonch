package com.example.bonchapp.ui.profile

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bonchapp.R
import com.example.bonchapp.coordinator.MainCoordinator
import com.example.bonchapp.model.pojo.AccountDTO
import com.example.bonchapp.model.pojo.DebtDTO
import com.example.bonchapp.model.pojo.ElectiveDTO
import com.example.bonchapp.model.pojo.MarkDTO
import com.example.bonchapp.presenter.ProfilePresenter
import com.example.bonchapp.ui.profile.main.ProfilePagerAdapter
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    lateinit var profilePresenter: ProfilePresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_profile, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        profileViewPager.adapter =
            ProfilePagerAdapter(this)
        profileTabLayout.setupWithViewPager(profileViewPager)
        initBtn()

        profilePresenter = ProfilePresenter(this, this)
    }

    private fun initBtn() {
        settings.setOnClickListener {
            MainCoordinator.navigateToSettings(this)
        }
    }

    fun showUser(user: AccountDTO) {
        val j = 5 + 5
    }

    fun showDebt(user: ArrayList<DebtDTO>) {
        val j = 5 + 5
    }

    fun showElectives(user: ArrayList<ElectiveDTO>) {
        val j = 5 + 5
    }

    fun showMark(user: ArrayList<MarkDTO>) {
        val j = 5 + 5
    }
}
