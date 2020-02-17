package com.example.bonchapp.ui.navgut

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.bonchapp.R
import com.example.bonchapp.ui.event.EventViewModel

class NavgutFragment : Fragment() {

    private lateinit var navgutViewModel: NavgutViewModel
    private lateinit var webView: WebView

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
//        navgutViewModel =
//            ViewModelProviders.of(this).get(NavgutViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_navgut, container, false)
//        val textView: TextView = root.findViewById(R.id.text_navgut)
//        navgutViewModel.text.observe(viewLifecycleOwner, Observer {
//            textView.text = it
//        })
        webView = root.findViewById(R.id.webview)

        webView.webViewClient = object: WebViewClient() {
            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                return true
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                Log.d("webView", "page started")
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                Log.d("webView", "page finished")
            }
        }

        webView.settings.javaScriptEnabled = true
        return root
    }

    override fun onResume() {
        webView.loadUrl("https://nav.sut.ru/")
        super.onResume()
    }
}
