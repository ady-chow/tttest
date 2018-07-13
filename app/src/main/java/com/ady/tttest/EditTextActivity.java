package com.ady.tttest;

import android.os.Bundle;
import android.support.annotation.Nullable;
import com.ady.tttest.base.BaseActivity;

/**
 * Created by ady on 2018/7/11.
 */

public class EditTextActivity extends BaseActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_edittext);
    showBackAndTitleInTitleBar("EditText test");
  }
}
