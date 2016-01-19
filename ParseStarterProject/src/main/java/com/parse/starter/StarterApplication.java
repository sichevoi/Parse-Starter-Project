/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.app.Application;

import com.facebook.FacebookSdk;
import com.parse.Parse;
import com.parse.ParseACL;
import com.parse.ParseTwitterUtils;
import com.parse.ParseUser;


public class StarterApplication extends Application {

  private static final String PARSE_CLIENT_ID = "PARSE_CLIENT_ID";
  private static final String PARSE_CLIENT_KEY = "PARSE_CLIENT_KEY";
  private static final String TWITTER_CONSUMER_KEY = "TWITTER_CONSUMER_KEY";
  private static final String TWITTER_CONSUMER_SECRET = "TWITTER_CONSUMER_SECRET";

  @Override
  public void onCreate() {
    super.onCreate();

    // Enable Local Datastore.
    Parse.enableLocalDatastore(this);

    FacebookSdk.sdkInitialize(this.getApplicationContext());

    Parse.initialize(this, PARSE_CLIENT_ID, PARSE_CLIENT_KEY);
    ParseTwitterUtils.initialize(TWITTER_CONSUMER_KEY, TWITTER_CONSUMER_SECRET);

    ParseUser.enableAutomaticUser();
    ParseACL defaultACL = new ParseACL();
    // Optionally enable public read access.
    // defaultACL.setPublicReadAccess(true);
    ParseACL.setDefaultACL(defaultACL, true);
  }
}
