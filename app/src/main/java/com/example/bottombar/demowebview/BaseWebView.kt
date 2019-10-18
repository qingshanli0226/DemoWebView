package com.example.bottombar.demowebview

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView

abstract class BaseWebView : Fragment(){
    private lateinit var iWebViewInit: IWebViewInit
    protected lateinit var webView:WebView
    abstract fun getLayoutId():Int
    abstract fun getWebView(rootView:View):WebView
    abstract fun getIWebViewInit():IWebViewInit


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        var rootView = inflater.inflate(getLayoutId(), container, false)
        webView = getWebView(rootView)
        iWebViewInit = getIWebViewInit()
        iWebViewInit.initWebViewSettings(webView)
        iWebViewInit.initWebViewClient(webView)
        iWebViewInit.initWebChromClient(webView)
        iWebViewInit.addWebViewJavaInterface(webView)

        return rootView
    }

    //定义初始化接口
    interface IWebViewInit {
        fun initWebViewSettings(webView: WebView) {

        }
        fun initWebViewClient(webView: WebView)
        fun initWebChromClient(webView: WebView) {
            
        }
        fun addWebViewJavaInterface(webView: WebView)   {
            
        }
    }

    override fun onResume() {
        super.onResume()
        webView.onResume()
    }

    override fun onPause() {
        super.onPause()
        webView.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        webView.removeAllViews()
        webView.destroy()
    }
}