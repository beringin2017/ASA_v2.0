package com.imk.asa20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class Ajukansurat : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_ajukansurat, container, false)

        val webView: WebView = view.findViewById(R.id.ajukanView)
        webView.webViewClient = WebViewClient()
        webView.settings.setJavaScriptEnabled(true)
        webView.setVerticalScrollBarEnabled(true)
        webView.setHorizontalScrollBarEnabled(true)
        webView.loadUrl("https://asa.usu.ac.id")

        return view

    }

}