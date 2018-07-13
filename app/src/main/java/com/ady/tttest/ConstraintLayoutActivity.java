package com.ady.tttest;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import com.ady.tttest.base.BaseActivity;

/**
 * Created by ady on 2018/7/4.
 */

public class ConstraintLayoutActivity extends BaseActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_constraint_layout);
    showBackAndTitleInTitleBar("ConstraintLayout test");
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == android.R.id.home) {
      Intent upIntent = NavUtils.getParentActivityIntent(this);
      if (NavUtils.shouldUpRecreateTask(this, upIntent)) {
        // create new task
        TaskStackBuilder.create(this).addNextIntentWithParentStack(upIntent).startActivities();
      } else {
        // Stay in same task
        NavUtils.navigateUpTo(this, upIntent);
      }
      return true;
    }
    return super.onOptionsItemSelected(item);
  }

}
