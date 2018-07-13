package com.ady.tttest.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.ady.tttest.rx.Rxu;
import rx.Observable;
import rx.functions.Func0;
import rx.subjects.BehaviorSubject;

/**
 * Created by ady on 2018/6/27.
 */

public class BaseActivity extends AppCompatActivity {

  private final BehaviorSubject<LifecycleEvent> lifecycleSubject = BehaviorSubject.create();

  public <T> Observable<T> duringCreated(final Func0<Observable<T>> source, boolean delayOnStop) {
    return Rxu.lazyWithLifecycle(source, lifecycleForThrottle(), delayOnStop);
  }

  public <T> Observable<T> duringCreated(final Observable<T> source, boolean delayOnStop) {
    return duringCreated(() -> source, delayOnStop);
  }

  public <T> Observable<T> duringCreated(final Func0<Observable<T>> source) {
    return duringCreated(source, true);
  }

  public <T> Observable<T> duringCreated(final Observable<T> source) {
    return duringCreated(() -> source, true);
  }

  public Observable<LifecycleEvent> lifecycle() {
    return lifecycleSubject;
  }

  public LifecycleEvent lifecycle_() {
    return lifecycleSubject.getValue();
  }

  private Observable<LifecycleEvent> lifecycleForThrottle() {
    return lifecycle()
        .filter(
            a ->
                a == LifecycleEvent.AfterCreate
                    || a == LifecycleEvent.Start
                    || a == LifecycleEvent.Resume
                    || a == LifecycleEvent.Stop
                    || a == LifecycleEvent.Destroy);
  }

  public void preCreateView(Bundle sis) {
  }

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    preCreateView(savedInstanceState);
    lifecycleSubject.onNext(LifecycleEvent.AfterCreate);
  }

  @Override
  protected void onStart() {
    super.onStart();
    lifecycleSubject.onNext(LifecycleEvent.Start);
  }

  @Override
  protected void onResume() {
    super.onResume();
    lifecycleSubject.onNext(LifecycleEvent.Resume);
  }

  @Override
  protected void onPause() {
    super.onPause();
    lifecycleSubject.onNext(LifecycleEvent.Pause);
  }

  @Override
  protected void onStop() {
    super.onStop();
    lifecycleSubject.onNext(LifecycleEvent.Stop);
  }

  @Override
  protected void onDestroy() {
    super.onDestroy();
    lifecycleSubject.onNext(LifecycleEvent.Destroy);
    lifecycleSubject.onCompleted();
  }

  public void showBackAndTitleInTitleBar(String title) {
    ActionBar actionBar = getSupportActionBar();
    if (actionBar != null) {
      actionBar.setDisplayHomeAsUpEnabled(true);
      actionBar.setTitle(title);
    }
  }

  public void showBackAndTitleInTitleBar(int titleRes) {
    showBackAndTitleInTitleBar(getString(titleRes));
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home) {
      finish();
      return true;
    }
    return super.onOptionsItemSelected(item);
  }
}
