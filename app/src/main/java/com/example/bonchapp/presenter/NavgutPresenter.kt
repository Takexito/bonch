package com.example.bonchapp.presenter

import android.graphics.Bitmap
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.bonchapp.ui.navgut.NavgutFragment

class NavgutPresenter(private val context: NavgutFragment) {

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
        pWebView.loadUrl("")
    }

    fun onPause() {
        pWebView.stopLoading()
    }
}