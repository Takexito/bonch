package com.example.bonchapp.ui.profile

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.bonchapp.R
import com.example.bonchapp.coordinator.MainCoordinator
import com.example.bonchapp.model.pojo.AccountDTO
import com.example.bonchapp.model.pojo.DebtDTO
import com.example.bonchapp.model.pojo.ElectiveDTO
import com.example.bonchapp.model.pojo.MarkDTO
import com.example.bonchapp.presenter.ProfilePresenter
import com.example.bonchapp.ui.profile.debt.ProfileDebtFragment
import com.example.bonchapp.ui.profile.electives.ProfileElectivesFragment
import com.example.bonchapp.ui.profile.main.ProfilePagerAdapter
import com.example.bonchapp.ui.profile.recordbook.ProfileRecordbookFragment
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {

    lateinit var profilePresenter: ProfilePresenter

    lateinit var adapter:ProfilePagerAdapter

    val profileDebtFragment = ProfileDebtFragment()
    val profileRecordbookFragment = ProfileRecordbookFragment()
    val profileElectivesFragment = ProfileElectivesFragment()

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

        adapter = ProfilePagerAdapter(
            this,
            profileDebtFragment,
            profileRecordbookFragment,
            profileElectivesFragment
        )
        adapter.notifyDataSetChanged()

        profileViewPager.adapter = adapter

        profileTabLayout.setupWithViewPager(profileViewPager)

        adapter.notifyDataSetChanged()


        initBtn()

        profilePresenter = ProfilePresenter(this, this)
    }

    private fun initBtn() {
        settings.setOnClickListener {
            MainCoordinator.navigateToSettings(this)
        }
    }

    fun showUser(user: AccountDTO) {
        val s = "hehehe"
    }

    fun showDebt(user: ArrayList<DebtDTO>) {
        val j = 5 + 5
    }

    fun showElectives(user: ArrayList<ElectiveDTO>) {
        profileElectivesFragment.setArray(user)
    }

    fun showMark(user: ArrayList<MarkDTO>) {
        //Log.d("Debbik", "Showing")

        profileRecordbookFragment.setArray(user)
        // Тут вылетает((
    }


    /*override fun onStart() {
        super.onStart()
        Log.d("Debbik", "Start")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Debbik", "Create")
    }

    override fun onResume() {
        super.onResume()
        Log.d("Debbik", "Resume")
    }*/

    override fun onStop() {
        super.onStop()
        adapter.notifyDataSetChanged()
        //Log.d("Debbik", "Stop")

    }

    /*override fun onPause() {
        super.onPause()
        Log.d("Debbik", "Pause")

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Debbik", "Destroy")

    }

    override fun onDestroyView() {
        super.onDestroyView()
        Log.d("Debbik", "DestroyView")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("Debbik", "Detach")
    }*/


}
