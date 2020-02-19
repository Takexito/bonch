package com.example.bonchapp.presenter

import android.graphics.Bitmap
import android.text.SpannableString
import android.text.style.ClickableSpan
import android.util.Log
import android.view.View
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.bonchapp.ui.navgut.NavgutFragment

class NavgutPresenter(private val context: NavgutFragment) {

    private val BASE_URL = "https://nav.sut.ru/"

    private var currentCabinet: String? = null

    private lateinit var pWebView: WebView
    private val webViewClient = object: WebViewClient() {

        override fun shouldOverrideUrlLoading(
            view: WebView?,
            request: WebResourceRequest?
        ): Boolean = true

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            context.pageLoadStarted()
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
            pWebView.loadUrl("https://nav.sut.ru/")
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