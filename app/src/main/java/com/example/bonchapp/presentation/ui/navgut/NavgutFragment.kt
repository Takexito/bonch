package com.example.bonchapp.presentation.ui.navgut

import android.annotation.SuppressLint
import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.bonchapp.R
import com.example.bonchapp.presentation.presenter.navgut.NavgutPresenter

class NavgutFragment : Fragment() {

    private lateinit var webView: WebView
    private lateinit var progressBar: ProgressBar
    private lateinit var errorTW: TextView

    val presenter =
        NavgutPresenter(this)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        presenter.currentCabinet = arguments?.getString("cabinet")
        val root = inflater.inflate(R.layout.fragment_navgut, container, false)
        initView(root)

        presenter.onCreate(webView)

        setClicker()
        return root
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun initView(view: View) {
        webView = view.findViewById(R.id.web_view)
        webView.settings.javaScriptEnabled = true

        progressBar = view.findViewById(R.id.progress_bar)
        errorTW = view.findViewById(R.id.error_text_view)
    }

    fun hideProgressBar() {
        progressBar.visibility = View.GONE
    }

    fun showProgressBar() {
        progressBar.visibility = View.VISIBLE
    }

    fun pageLoaded() {
        hideProgressBar()
        webView.visibility = View.VISIBLE
        errorTW.visibility = View.GONE
    }

    fun pageLoadError() {
        webView.visibility = View.GONE
        hideProgressBar()
        errorTW.visibility = View.VISIBLE
    }

    fun pageLoadStarted() {
        errorTW.visibility = View.GONE
        webView.visibility = View.GONE
        showProgressBar()
    }

    private fun setClicker() {
        errorTW.setOnClickListener {
            presenter.reloadPage()
        }
    }

    override fun onPause() {
        presenter.onPause()
        super.onPause()
    }

    fun isOnline(): Boolean {
        val cm = NavgutFragment@context!!.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetwork = cm.activeNetworkInfo
        return activeNetwork !== null && activeNetwork.isConnectedOrConnecting
    }
}
