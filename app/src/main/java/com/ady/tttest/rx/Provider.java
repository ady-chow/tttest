package com.ady.tttest.rx;

import rx.functions.Action1;

public interface Provider<T> extends Action1<Receiver<T>> {}
