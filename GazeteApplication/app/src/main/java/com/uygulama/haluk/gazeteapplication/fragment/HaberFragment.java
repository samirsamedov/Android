package com.uygulama.haluk.gazeteapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.uygulama.haluk.gazeteapplication.R;
import com.uygulama.haluk.gazeteapplication.activity.HaberActivity;

/**
 * Created by Samir on 7.5.2016.
 */
public class HaberFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_haber, container, false);

        WebView webView = (WebView) view.findViewById(R.id.web_view_page);
        String haberBaglanti = getArguments().getString(HaberActivity.EXTRA_NEWS_LINK);

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl(haberBaglanti);
        return view;
    }
}
