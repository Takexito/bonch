package com.example.bonchapp.presenter

import android.graphics.Bitmap
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.bonchapp.ui.navgut.NavgutFragment

class NavgutPresenter(private val context: NavgutFragment) {

    private val BASE_URL = "https://nav.sut.ru/"

    var currentCabinet: String? = null

    private lateinit var pWebView: WebView
    private val webViewClient = object: WebViewClient() {

        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean = true

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            if (url?.subSequence(0..18) == BASE_URL) {
                context.pageLoadStarted()
            } else pWebView.loadUrl(BASE_URL)
            super.onPageStarted(view, url, favicon)
        }

        override fun onPageFinished(view: WebView?, url: String?) {
            context.pageLoaded()
            super.onPageFinished(view, url)
        }

        override fun onReceivedError(
            view: WebView?,
            request: WebResourceRequest?,
            error: WebResourceError?
        ) {
            super.onReceivedError(view, request, error)
            context.pageLoadError()
        }
    }

    fun onCreate(webView: WebView) {
        pWebView = webView
        webView.webViewClient = webViewClient

        if (context.isOnline()) {
            if (currentCabinet == null) {
                pWebView.loadUrl(BASE_URL)
            } else {
                var url = BASE_URL
                when (currentCabinet!!.length) {
                    3 -> {
                        url += "m/?cab=k$currentCabinet"
                    }
                    5 -> {
                        url += "/?cab=k${currentCabinet!![4]}-${currentCabinet!!.substringBefore('/')}"
                    }
                    7 -> {
                        url += "/?cab=k${currentCabinet!!.substringAfterLast('/')}-${currentCabinet!!.substringBefore('/')}a${currentCabinet!![4]}"
                    }
                }
                pWebView.loadUrl(url)
            }
        } else {
            context.pageLoadError()
        }
    }

    fun reloadPage() {
        if (context.isOnline()) {
            if (currentCabinet == null) {
                pWebView.loadUrl(BASE_URL)
                context.pageLoadStarted()
            } else {
                pWebView.loadUrl(currentCabinet)
                context.pageLoadStarted()
            }
        } else {
            context.pageLoadError()
        }
    }

    fun onPause() {
        pWebView.stopLoading()
    }
    
}