package com.example.bonchapp.ui.navgut

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import com.example.bonchapp.R
import com.example.bonchapp.presenter.NavgutPresenter

class NavgutFragment : Fragment() {

    private lateinit var webView: WebView

    private lateinit var presenter: NavgutPresenter

    private val webViewClient = object: WebViewClient() {
        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean = true
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_navgut, container, false)

        presenter = NavgutPresenter(this)

        initWebView(root)

        return root
    }

    @SuppressLint("SetJavaScriptEnabled")
    fun initWebView(view: View) {
        webView = view.findViewById(R.id.webview)
        webView.settings.javaScriptEnabled = true
        webView.webViewClient = webViewClient
    }

    fun hideProgressBar() {

    }

    fun showProgressBar() {

    }

    override fun onResume() {
        super.onResume()
        webView.loadUrl("https://nav.sut.ru/")
    }
}
