package com.ady.tttest;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.ady.tttest.base.BaseActivity;

/**
 * Created by ady on 2018/7/19.
 */

public class WebViewActivity extends BaseActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    WebView webview = new WebView(this);
    setContentView(webview);
    WebSettings settings = webview.getSettings();
    settings.setJavaScriptEnabled(true);
    settings.setBuiltInZoomControls(true);
    settings.setDisplayZoomControls(false);
    settings.setCacheMode(WebSettings.LOAD_NO_CACHE);
    settings.setAppCacheEnabled(true);
    settings.setDomStorageEnabled(true);
//    settings.setAppCachePath(Fu.folderCache("web_cache").getPath());
    settings.setLoadsImagesAutomatically(true);
    settings.setBlockNetworkImage(false);
    settings.setBlockNetworkLoads(false);
    settings.setLoadWithOverviewMode(false);
    settings.setAllowFileAccess(true);
    // for image loading with http
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      settings.setMixedContentMode(WebSettings.MIXED_CONTENT_ALWAYS_ALLOW);
    }
    webview.setHorizontalScrollBarEnabled(false);
    Log.d("wv", "onCreate: ua = " + settings.getUserAgentString());

    if (Build.VERSION.SDK_INT >= 21) {
      settings.setMixedContentMode(0);
      webview.setLayerType(View.LAYER_TYPE_HARDWARE, null);
    } else if (Build.VERSION.SDK_INT >= 19) {
      webview.setLayerType(View.LAYER_TYPE_HARDWARE, null);
    } else if (Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT < 19) {
      webview.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
    }
    webview.loadUrl("https://omi.sg");
  }
}
