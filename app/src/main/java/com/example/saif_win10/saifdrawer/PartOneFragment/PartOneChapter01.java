package com.example.saif_win10.saifdrawer.PartOneFragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;


import com.example.saif_win10.saifdrawer.R;

public class PartOneChapter01 extends Fragment {

    @SuppressLint("SetJavaScriptEnabled")
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.part_one_chapter_one, container, false);

        String url = "file:///android_asset/mathscribe/chapterOne_formula.html";

        WebView v = (WebView) view.findViewById(R.id.wbw);
        v.getSettings().setJavaScriptEnabled(true);
        v.getSettings().setBuiltInZoomControls(true);

        // The below code also works
        // v.loadUrl("file:///android_asset/mathscribe/COPY-ME.html");

        v.loadUrl(url);
        v.setWebViewClient(new MyBrowser());

        return view;
    }

    private class MyBrowser extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView v, String url) {
            v.loadUrl(url);
            return true;
        }
    }

}
