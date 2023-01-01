package com.imk.asa20

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient

class Elearning : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_eln, container, false)

        val webView: WebView = view.findViewById(R.id.elnView)
        webView.settings.setJavaScriptEnabled(true)
        webView.setVerticalScrollBarEnabled(true)
        webView.setHorizontalScrollBarEnabled(true)
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://elearning2.usu.ac.id/login/index.php")

        return view

    }


}