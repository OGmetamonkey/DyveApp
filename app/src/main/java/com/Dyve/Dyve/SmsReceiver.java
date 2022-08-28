package com.Dyve.Dyve;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import android.os.Handler;


/**
 * Created by Jake on 5/3/2016.
 */

    public class SmsReceiver extends BroadcastReceiver {
    private AudioManager am1;
    final SmsManager sms = SmsManager.getDefault();

    private static final String TAG = "SmsReceiver";

    public void onReceive(Context context, Intent intent) {

        //Toast.makeText(context, "ON SMS RECEIVE BROADCAST", Toast.LENGTH_LONG).show();
        Log.i(TAG, "SmsListener - onReceiveCalled");
        int maxV;

        final Bundle myBundle = intent.getExtras();
        final String postScript = context.getResources().getString(com.Dyve.Dyve.R.string.postScript);
        try {
            if (myBundle != null) {

                //is bundle has content ^^ , Object [] sms will pull "pdus". pdus are: An Object[] of byte[]s containing the PDUs that make up the message.
                //The extra values can be extracted using getMessagesFromIntent(Intent).
                final Object[] sms = (Object[]) myBundle.get("pdus");

                String smsMessageStr = "";

                String smsBody = null;
                String address;
                address = null;
                for (int i = 0; i < sms.length; ++i) {
                    SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) sms[i]);

                    smsBody = smsMessage.getMessageBody().toString();
                    address = smsMessage.getOriginatingAddress();

                    smsMessageStr += "SMS From: " + address + "\n";
                    smsMessageStr += smsBody + "\n";
                }
                String address1 = address;

                Log.i(TAG, smsBody);
                String emergencytxt = String.valueOf(ThePhoneStateListener.i1);
                int ringButtonState = (MainActivity.ringbuttonstate);
                int vibrateButtonState = (MainActivity.vibratebuttonstate);
                if (smsBody.equals(emergencytxt)) {


                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(address1, null, "Contact has been alerted using Dyve. " + postScript + "", null, null);
                    Toast.makeText(context, "Dyve Alert sounded by " + address1 + "!", Toast.LENGTH_LONG).show();
                   // AudioManager.setRingerMode(2);

                    switch (vibrateButtonState) {
                        case 0:
                            if (ringButtonState == 0) {
                                final Handler mHandler = new Handler();

                                final MediaPlayer mPlayer = MediaPlayer.create(context, com.Dyve.Dyve.R.raw.sonar);
                                am1 = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);

                                maxV = am1.getStreamMaxVolume(am1.STREAM_MUSIC);
                                am1.setStreamVolume(AudioManager.STREAM_MUSIC, maxV, 0);
                                mPlayer.setAudioStreamType(am1.STREAM_MUSIC);
                                mPlayer.setVolume(1,1);
                                mPlayer.start();
                                mHandler.post(new Runnable() {
                                    public void run() {
                                        while (mPlayer.isPlaying()) {
                                            if (mPlayer.getCurrentPosition() > 15000) {
                                                mPlayer.stop();
                                                break;
                                            }
                                        }
                                    }
                                });
                                Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                                // Vibrate for 500 milliseconds
                                v.vibrate(2500);
                            } else {

                                Vibrator v = (Vibrator) context.getSystemService(Context.VIBRATOR_SERVICE);
                                // Vibrate for 500 milliseconds
                                v.vibrate(2500);

                            }
                        case 1:
                            if (ringButtonState == 0) {
                                final Handler mHandler = new Handler();

                                final MediaPlayer mPlayer = MediaPlayer.create(context, com.Dyve.Dyve.R.raw.sonar);
                                am1 = (AudioManager)context.getSystemService(Context.AUDIO_SERVICE);
                                maxV = am1.getStreamMaxVolume(am1.STREAM_MUSIC);
                                am1.setStreamVolume(AudioManager.STREAM_MUSIC, maxV, 0);
                                mPlayer.setAudioStreamType(am1.STREAM_MUSIC);
                                mPlayer.setVolume(1,1);
                                mPlayer.start();
                                mHandler.post(new Runnable() {
                                    public void run() {
                                        while (mPlayer.isPlaying()) {
                                            if (mPlayer.getCurrentPosition() > 15000) {
                                                mPlayer.stop();
                                                break;
                                            }
                                        }
                                    }
                                });

                            } else {
                                Log.i(TAG, "EMERGENCY - but no alert.");
                            }
                            }
                    }

                else {
                    Log.i(TAG, "NOT AN EMERGENCY - Text code didn't match.");
                }
            }
        }
        catch (Exception e) {
        Log.i(TAG, "Exception smsReceiver");


    }
}}




    /*
    @Override
    public void onReceive(Context context, Intent intent) {

        Log.i(TAG, "in Receiver. intent.getAction():" + intent.getAction());
        Toast.makeText(context, "ON SMS RECEIVE BROADCAST", Toast.LENGTH_LONG).show();

        Bundle bundle = intent.getExtras(); // ---get the SMS message passed
        //public static SmsMessage[] getMessagesFromIntent (Intent intent)
        // in---
        SmsMessage[] msgs = null;
        String msg_from;
        if (bundle != null) {
            // ---retrieve the SMS message received---
            try {
                Object[] pdus = (Object[]) bundle.get("pdus");
                msgs = new SmsMessage[pdus.length];
                Log.i(TAG, "pdus: " + pdus + "test");
                for (int i = 0; i < msgs.length; i++) {
                    msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                    msg_from = msgs[i].getOriginatingAddress();
                    String msgBody = msgs[i].getMessageBody();
                    NotifyMe(context, msg_from, msgBody);
                    Log.i(TAG, "1st test: " + msgBody + "test");
                }
            } catch (Exception e) {
                // Log.d("Exception caught",e.getMessage());
            }
        }
    }




    private void NotifyMe(Context context, String msg_from, String msgBody) {
        // do something
    }
}

    /*
    public void onReceive(Context arg0, Intent arg1) {
        Toast.makeText(arg0, "ON SMS RECEIVE BROADCAST", Toast.LENGTH_LONG).show();
        Log.i(TAG, "On SMS receive BROADCAST" + "test");
    }
}

*/
        /*
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "ON SMS RECEIVE BROADCAST", Toast.LENGTH_LONG).show();
            Log.i(TAG, "On SMS receive BROADCAST" + "test");
            Bundle bundle = intent.getExtras();
            Object[] messages = (Object[]) bundle.get("pdus");
            SmsMessage[] sms = new SmsMessage[messages.length];
            // Create messages for each incoming PDU
            //for (int n = 0; n < messages.length; n++) {
                //sms[n] = SmsMessage.createFromPdu((byte[]) messages[n]);
            //}
            for (SmsMessage msg : sms) {
                Log.i("RECEIVED MSG",":"+msg.getMessageBody());
                // Verify if the message came from our known sender

            }
        }}

            /*
            Bundle extras = intent.getExtras();
            String messages = "";

            if (Telephony.Sms.Intents.SMS_RECEIVED_ACTION.equals(intent.getAction())) {
                Log.i(TAG, "1st test " + "test");
                for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                    Log.i(TAG, "2nd test " + "test");
                    String messageBody = smsMessage.getMessageBody();
                    Log.i(TAG, "2nd test " + messageBody +"test");
                }
            }
        }
    }




    /*
    static SmsListener phoneStateListener;
    private SharedPreferences preferences;
    private static final String TAG = "SmsListener";
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO Auto-generated method stub
        Log.i(TAG, "On receive " + "test");
        if(intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")){
            Log.i(TAG, "1st test " + "test");
            Bundle bundle = intent.getExtras();           //---get the SMS message passed in---
            SmsMessage[] msgs = null;
            String msg_from;
            if (bundle != null) {
                Log.i(TAG, "2nd test " + "test");
                //---retrieve the SMS message received---
                String msgBody = null;
                try {
                    Log.i(TAG, "3rd test " + "test");
                    Object[] pdus = (Object[]) bundle.get("pdus");
                    msgs = new SmsMessage[pdus.length];
                    for (int i = 0; i < msgs.length; i++) {
                        Log.i(TAG, "4th test " + i + "test");
                        msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                        msg_from = msgs[i].getOriginatingAddress();
                        msgBody = msgs[i].getMessageBody();
                    }
                } catch (Exception e) {
                            Log.d("Exception caught",e.getMessage());
                }
                if (msgBody.equals(33)){
                    Log.i(TAG, "SOUND THE MOTHAFUCKIN ALARM NIH " + "test");
                    Toast.makeText(context, "SONAR SOUNDS AHHHHHHHHHHHHH", Toast.LENGTH_LONG).show();
                }
            }
        }
    }
}
*/