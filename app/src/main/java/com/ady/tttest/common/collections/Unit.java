package com.ady.tttest.common.collections;

import rx.functions.Action1;

public class Unit {

  private Unit() {}

  public static final Unit UNIT = new Unit();

  public static Action1<Unit> IGNORE = u -> {};
}
