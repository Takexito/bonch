package com.example.bonchapp.ui.authorization

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.bonchapp.R
import com.example.bonchapp.presenter.AuthPresenter
import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import kotlinx.android.synthetic.main.auth_page_2.view.*

class AuthFragment : Fragment() {

    lateinit var pager: ViewPager2
    private lateinit var dotsIndicator: DotsIndicator

    private lateinit var pagerAdapter: PagerAdapter

    var presenter: AuthPresenter? = AuthPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_authorization, container, false)

        initView(view)

        return view
    }

    private fun initView(view: View) {
        pager = view.findViewById(R.id.auth_pager)
        pagerAdapter = PagerAdapter(this)
        pager.adapter = pagerAdapter
        pager.isUserInputEnabled = false

        dotsIndicator = view.findViewById(R.id.dots_indicator)
        dotsIndicator.setViewPager2(pager)
    }

    fun nextPage() {
        pager.setCurrentItem(1, true)
    }

    fun previousPage() {
        pager.setCurrentItem(0, true)
    }

    fun onSignInError() {
        pager.sign_in_error.visibility = View.VISIBLE
    }

    override fun onDestroy() {
        presenter = null
        super.onDestroy()
    }
}