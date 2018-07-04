package com.ady.tttest;


import com.ady.tttest.rx.Rxu;
import rx.Observable;

/**
 * Created by ady on 2018/6/27.
 */

public class MockBiz {

  public Observable<String> username() {
    return Observable.just("ady");
  }

}
