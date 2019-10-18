package com.example.bottombar.demowebview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.fragment_child.view.*

class ChildFragment : BaseWebView(), BaseWebView.IWebViewInit {
    override fun getIWebViewInit(): IWebViewInit {
        return this
    }

    override fun initWebViewClient(webView: WebView) {
       webView.webViewClient = object : WebViewClient() {
       }
    }

    override fun getLayoutId(): Int {
        return R.layout.fragment_child
    }

    override fun getWebView(rootView: View): WebView {
         return rootView.webView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        webView.loadUrl("https://tech.meituan.com/WebViewPerf.html")
    }
}