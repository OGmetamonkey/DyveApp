package com.Dyve.Dyve;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;


/**
 * Created by Jake on 3/21/2016.
 */

public class IncomingCallReceiver extends BroadcastReceiver {

    static ThePhoneStateListener phoneStateListener;
    private static final String TAG = "MyListener";

    @Override
    public void onReceive(Context arg0, Intent arg1) {
        Log.i(TAG, "RIGHT_ON_RECEIVE " + "test");

            TelephonyManager tm = (TelephonyManager) arg0.getSystemService(arg0.TELEPHONY_SERVICE);
        //if (phoneStateListener == null) {
            phoneStateListener = new ThePhoneStateListener(arg0);
            Log.i(TAG, "broadcast " + "test");

            tm.listen(phoneStateListener, android.telephony.PhoneStateListener.LISTEN_CALL_STATE);
            tm.listen(phoneStateListener, PhoneStateListener.LISTEN_NONE);

        //}else {
            //Log.i(TAG, "phoneStateListener must not be null");
        }
    }

//}




