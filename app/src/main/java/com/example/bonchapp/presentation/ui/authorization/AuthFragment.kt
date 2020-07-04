package com.example.bonchapp.presentation.ui.authorization

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.bonchapp.R
import com.example.bonchapp.presentation.App
import com.example.bonchapp.presentation.presenter.auth.IAuthPresenter
import com.example.bonchapp.router.Constants
//import com.tbuonomo.viewpagerdotsindicator.DotsIndicator
import kotlinx.android.synthetic.main.auth_page_2.view.*
import kotlinx.android.synthetic.main.fragment_authorization.*
import javax.inject.Inject

class AuthFragment: Fragment(), IAuthView {

    lateinit var pager: ViewPager2
    //private lateinit var dotsIndicator: DotsIndicator

    private lateinit var pagerAdapter: PagerAdapter
    @Inject
    lateinit var presenter: IAuthPresenter

    init{
        App.appComponent.inject(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_authorization, container, false)

        presenter.attachView(this)
        initView(view)

        return view
    }

    private fun getSharedPreference(): SharedPreferences {
       return requireActivity().getSharedPreferences(Constants.APP_PREFERENCE, Context.MODE_PRIVATE)
    }

    private fun initView(view: View) {
        pager = view.findViewById(R.id.auth_pager)
        pagerAdapter =
            PagerAdapter(this)
        pager.adapter = pagerAdapter
        pager.isUserInputEnabled = false

        //dotsIndicator = view.findViewById(R.id.dots_indicator)
        //dotsIndicator.setViewPager2(pager)
    }

    fun nextPage() {
        pager.setCurrentItem(1, true)
    }

    fun previousPage() {
        pager.setCurrentItem(0, true)
        pager.sign_in_error.visibility = View.GONE
        pagerAdapter.previousPage()
        
        //hide soft keyboard
        val imm = requireActivity().getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        var view = requireActivity().currentFocus
        if (view == null) {
            view = View(activity)
        }
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun onSignInError() {
        pager.sign_in_error.visibility = View.VISIBLE
        //pagerAdapter.signInError()
    }

    override fun showError(message: String){
        Toast.makeText(context, message, Toast.LENGTH_LONG).show()
    }

    override fun getSharedPref(): SharedPreferences {
        return getSharedPreference()
    }

    override fun showProgressBar() {
        auth_pager.visibility = View.GONE
        authProgressBar.visibility = View.VISIBLE
    }

    override fun hideProgressBar() {
        auth_pager.visibility = View.VISIBLE
        authProgressBar.visibility = View.GONE
    }

}