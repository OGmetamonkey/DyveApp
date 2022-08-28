package com.Dyve.Dyve;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.telephony.PhoneStateListener;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.biapps.Contact;
import com.biapps.DatabaseHandler;

import java.util.List;
import java.util.Random;

/**
 * Created by Jake on 5/2/2016.
 */
public class ThePhoneStateListener extends PhoneStateListener {

    Context context;

    private static final String TAG = "MyListener";

    static Random r = new Random();
    static int i1 = r.nextInt(10000 - 1000) + 1000;
    static String dyveNumber = " (Dyve: " + i1 + ")";
    public ThePhoneStateListener(Context context) {
       this.context = context;
    }

    @Override

    public void onCallStateChanged(int state, String incomingNumber) {

        super.onCallStateChanged(state, incomingNumber);
        final String txtCheck = context.getResources().getString(com.Dyve.Dyve.R.string.emgrCustomTxt);
        final String txt2Check = context.getResources().getString(com.Dyve.Dyve.R.string.nonEmgrCustomTxt);
        final String postScript = context.getResources().getString(com.Dyve.Dyve.R.string.postScript);
        try {
            Context applicationContext = CustomizeMsg.getContextOfApplication();

            int Call_State_Ringing = TelephonyManager.CALL_STATE_RINGING;

            if (Call_State_Ringing == state) {
                Log.i(TAG, "listener " + "test");
                Log.i(TAG, "number: " + incomingNumber + "");


                switch (state) {
                    case TelephonyManager.CALL_STATE_RINGING:
                        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(applicationContext);
                        SharedPreferences prefs2 = PreferenceManager.getDefaultSharedPreferences(applicationContext);
                        String emgrMsgUse = prefs.getString("autoSave20", "");
                        String nonEmgrMsgUse = prefs2.getString("nonAutoSave20", "");
                        DatabaseHandler db_con = new DatabaseHandler(context);
                        //SQLiteDatabase db = db_con.getReadableDatabase();

                        List<Contact> contacts = db_con.getAllContacts();

                        String textNumber = null;
                        for (Contact cn : contacts) {
                            String phoneNumbers = cn.getPhoneNumber();
                            String phoneNumbers1 = phoneNumbers.replaceAll("[^0-9]", "");
                            Log.i(TAG, "list numbers " + phoneNumbers1 + "");
                            if (incomingNumber.contains(phoneNumbers1) || phoneNumbers1.contains(incomingNumber)) {
                                Log.i(TAG, "emergency contact found " + incomingNumber + "");
                                textNumber = phoneNumbers1;

                            } else {

                                Log.i(TAG, "generic contact found " + incomingNumber + "");

                            }
                        }
                        try {
                            if (textNumber == (null)) {

                                Log.i(TAG, "texting generic contact " + incomingNumber + "");
                                SmsManager smsManager = SmsManager.getDefault();

                                    smsManager.sendTextMessage(incomingNumber, null, nonEmgrMsgUse + " " + postScript, null, null);

                            } else {

                                Log.i(TAG, "texting emergency contact " + incomingNumber + "");

                                SmsManager smsManager = SmsManager.getDefault();

                                    smsManager.sendTextMessage(incomingNumber, null, emgrMsgUse + dyveNumber, null, null);
                                }

                        } catch (Exception f) {
                            Log.i(TAG, "Exception smsReceiver");
                        }
                }
            }
        } catch (Exception e) {
            Log.i(TAG, "Exception no Custom");

            int Call_State_Ringing = TelephonyManager.CALL_STATE_RINGING;

            if (Call_State_Ringing == state) {

                Log.i(TAG, "number: " + incomingNumber + "");


                switch (state) {
                    case TelephonyManager.CALL_STATE_RINGING:


                        DatabaseHandler db_con = new DatabaseHandler(context);
                        //SQLiteDatabase db = db_con.getReadableDatabase();

                        List<Contact> contacts = db_con.getAllContacts();

                        String textNumber = null;
                        for (Contact cn : contacts) {
                            String phoneNumbers = cn.getPhoneNumber();
                            String phoneNumbers1 = phoneNumbers.replaceAll("[^0-9]","");
                            Log.i(TAG, "list numbers " + phoneNumbers1 + "");
                            if (incomingNumber.contains(phoneNumbers1) || phoneNumbers1.contains(incomingNumber)) {
                                Log.i(TAG, "emergency contact found " + incomingNumber + "");
                                textNumber = phoneNumbers1;

                            } else {

                                Log.i(TAG, "generic contact found " + incomingNumber + "");

                            }
                        }
                        try {
                            if (textNumber == (null)) {

                                Log.i(TAG, "texting generic contact " + incomingNumber + "");
                                SmsManager smsManager = SmsManager.getDefault();

                                    smsManager.sendTextMessage(incomingNumber, null, txt2Check + " " + postScript, null, null);

                                }
                            else
                            {

                                Log.i(TAG, "texting emergency contact " + incomingNumber + "");

                                SmsManager smsManager = SmsManager.getDefault();

                                smsManager.sendTextMessage(incomingNumber, null, txtCheck + dyveNumber, null, null);
                            }
                            /*
                            else {

                                Log.i(TAG, "texting emergency contact " + incomingNumber + "");

                                SmsManager smsManager = SmsManager.getDefault();

                                    smsManager.sendTextMessage(incomingNumber, null, txtCheck + dyveNumber + postScript, null, null);

                                }*/


                        }catch (Exception f) {
                            Log.i(TAG, "Exception smsReceiver");
                        }
                }
            }}
    }
}








