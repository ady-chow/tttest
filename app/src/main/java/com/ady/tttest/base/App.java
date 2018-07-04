package com.ady.tttest.base;

import static com.ady.tttest.BuildConfig.DEBUG;

import android.app.Application;
import android.util.Log;
import com.ady.tttest.MockBiz;

/**
 * Created by ady on 2018/6/27.
 */

public class App extends Application {

  public static App me;

  public static MockBiz biz;

  @Override
  public void onCreate() {
    super.onCreate();
    me = this;
    afterMe();
  }

  private void afterMe() {
    biz = new MockBiz();
  }

  public void logError(Throwable tr) {
    logError(tr, null);
  }

  public void logError(Throwable tr, String extra) {
    if (DEBUG) {
      Log.e("omi", "logError:" + extra, tr);
    }
  }
}
