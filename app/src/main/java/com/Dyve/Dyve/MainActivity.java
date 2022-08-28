package com.Dyve.Dyve;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.CountDownTimer;

import android.content.Context;

import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;

import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.CompoundButton;
import android.widget.ImageButton;

import android.widget.Switch;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    //set object labels and states here
    private AudioManager am1;
    private Switch icon;
    private ImageButton msgButton;
    private ImageButton msgButton2;
    private AudioManager am;
    private ImageButton people;
    private ImageButton ring;
    private ImageButton vibrate;
    private ImageButton help;
    private ImageButton info;
    private static final String TAG = "Main";



    IncomingCallReceiver broadCastReceiver = new IncomingCallReceiver();
    SmsReceiver smsReceiver = new SmsReceiver();

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.Dyve.Dyve.R.layout.activity_main);

        am = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        am1 = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        icon = (Switch) findViewById(com.Dyve.Dyve.R.id.icon);
        people = (ImageButton) findViewById(com.Dyve.Dyve.R.id.people);
        people.setOnClickListener(peopleButtonHandler);
        ring = (ImageButton) findViewById(com.Dyve.Dyve.R.id.ring);
        ring.setOnClickListener(ringButtonHandler);
        vibrate = (ImageButton) findViewById(com.Dyve.Dyve.R.id.vibrate);
        vibrate.setOnClickListener(vibrateButtonHandler);
        msgButton = (ImageButton) findViewById(com.Dyve.Dyve.R.id.msgButton);
        msgButton.setOnClickListener(msgButtonHandler);
        msgButton2 = (ImageButton) findViewById(com.Dyve.Dyve.R.id.msgButton2);
        msgButton2.setOnClickListener(msgButton2Handler);
        help = (ImageButton) findViewById(com.Dyve.Dyve.R.id.help);
        help.setOnClickListener(helpButtonHandler);
        info = (ImageButton) findViewById(com.Dyve.Dyve.R.id.info);
        info.setOnClickListener(infoButtonHandler);
        icon.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                imgbuttonhandler();
            }
        });




        final String PREFS_NAME = "MyPrefsFile";
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        if (settings.getBoolean("my_first_time", true)) {
            //the app is being launched for first time, do something
            Log.d("Comments", "First time");
            final Animation animation = new AlphaAnimation(1, 0); // Change alpha from fully visible to invisible
            animation.setDuration(500); // duration - half a second
            animation.setInterpolator(new LinearInterpolator()); // do not alter animation rate
            animation.setRepeatCount(8); // Repeat animation 10 times
            animation.setRepeatMode(Animation.REVERSE); // Reverse animation at the end so the button will fade back in
            Toast.makeText(getApplicationContext(), "Welcome to Dyve! Tap here to add emergency contacts!", Toast.LENGTH_LONG)
                    .show();
            people.startAnimation(animation);

            new CountDownTimer(5000,500) {
                public void onFinish() {
                    // When timer is finished
                    // Execute your code here

                    Toast toast= Toast.makeText(getApplicationContext(), "Slide down to Dyve!", Toast.LENGTH_LONG);
                    toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                    toast.show();
                    icon.startAnimation(animation);
                }

                public void onTick(long millisUntilFinished) {
                    // millisUntilFinished    The amount of time until finished.
                }
            }.start();
            settings.edit().putBoolean("my_first_time", false).commit();

        } else {
            Log.d("Comments", "Not First time");
            Toast toast3= Toast.makeText(getApplicationContext(), "Welcome back to Dyve!", Toast.LENGTH_SHORT);
            toast3.setGravity(Gravity.CENTER_VERTICAL,0,0);
            toast3.show();
        }
    }
    int buttonstate = 0;
    static int ringbuttonstate = 0;
    static int vibratebuttonstate = 0;

        public View.OnClickListener msgButtonHandler = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent myintent = new Intent(getApplicationContext(), CustomizeMsg.class); //A Context as its first parameter (this is used because the Activity class is a subclass of Context)

                startActivity(myintent);

        }
    };

    public View.OnClickListener helpButtonHandler = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            //the help button has been clicked

            final Animation animation = new AlphaAnimation(1, 0); // Change alpha from fully visible to invisible
            animation.setDuration(250); // duration - half a second
            animation.setInterpolator(new LinearInterpolator()); // do not alter animation rate
            animation.setRepeatCount(6); // Repeat animation 10 times
            animation.setRepeatMode(Animation.REVERSE); // Reverse animation at the end so the button will fade back in
            Toast.makeText(getApplicationContext(), "Tap here to add emergency contacts!", Toast.LENGTH_SHORT)
                    .show();
            people.startAnimation(animation);

            new CountDownTimer(2500,250) {
                public void onFinish() {
                    // When timer is finished
                    // Execute your code here

                    Toast toast= Toast.makeText(getApplicationContext(), "Slide down to Dyve!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                    toast.show();
                    icon.startAnimation(animation);
                }

                public void onTick(long millisUntilFinished) {
                    // millisUntilFinished    The amount of time until finished.
                }
            }.start();

            new CountDownTimer(5000,250) {
                public void onFinish() {
                    // When timer is finished
                    // Execute your code here

                    Toast toast= Toast.makeText(getApplicationContext(), "Click here to customize message for emergency contacts!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL,0,20);
                    toast.show();
                    msgButton.startAnimation(animation);
                }

                public void onTick(long millisUntilFinished) {
                    // millisUntilFinished    The amount of time until finished.
                }
            }.start();

            new CountDownTimer(7500,250) {
                public void onFinish() {
                    // When timer is finished
                    // Execute your code here

                    Toast toast= Toast.makeText(getApplicationContext(), "Click here to customize message for normal contacts!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL,0,20);
                    toast.show();
                    msgButton2.startAnimation(animation);
                }

                public void onTick(long millisUntilFinished) {
                    // millisUntilFinished    The amount of time until finished.
                }
            }.start();

        }
    };

    public View.OnClickListener infoButtonHandler = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent myintent = new Intent(getApplicationContext(), info.class); //A Context as its first parameter (this is used because the Activity class is a subclass of Context)

            startActivity(myintent);

        }
    };



    public View.OnClickListener msgButton2Handler = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent myintent = new Intent(getApplicationContext(), CustomizeMsg2.class); //A Context as its first parameter (this is used because the Activity class is a subclass of Context)

            startActivity(myintent);

        }
    };
    /*
    public View.OnClickListener toastButtonHandler = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent intent = getIntent();
            String messageText = intent.getStringExtra(EXTRA_MESSAGE);
            String messageText2 = intent.getStringExtra(EXTRA_MESSAGE_2);
            Toast.makeText(getApplicationContext(), messageText + messageText2, Toast.LENGTH_LONG)
                    .show();

        }
    };

    */
    int maxV;
    public void imgbuttonhandler() {
        final Handler mHandler = new Handler();
        final MediaPlayer mPlayer = MediaPlayer.create(this, R.raw.bubble);
        am1 = (AudioManager)this.getSystemService(Context.AUDIO_SERVICE);
        am1 = (AudioManager)this.getSystemService(Context.AUDIO_SERVICE);
        //maxV = am1.getStreamMaxVolume(am1.STREAM_MUSIC);
        //am1.setStreamVolume(AudioManager.STREAM_MUSIC, maxV, 0);
        // Get the current ringer volume as a percentage of the max ringer volume.
        int currentVolume = am1.getStreamVolume(AudioManager.STREAM_RING);
        int maxRingerVolume = am1.getStreamMaxVolume(AudioManager.STREAM_RING);
        double proportion = currentVolume/(double)maxRingerVolume;

// Calculate a desired music volume as that same percentage of the max music volume.
        int maxMusicVolume = am1.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int desiredMusicVolume = (int)(proportion * maxMusicVolume);

// Set the music stream volume.
        am1.setStreamVolume(AudioManager.STREAM_MUSIC, desiredMusicVolume, 0 /*flags*/);



        mPlayer.setAudioStreamType(am1.STREAM_MUSIC);
        mPlayer.setVolume(1,1);
        mPlayer.start();
        mHandler.post(new Runnable() {
            public void run() {
                /*
                while (mPlayer.isPlaying()) {
                    if (mPlayer.getCurrentPosition() > 5000) {
                        mPlayer.stop();
                        break;
                    }
                }
                */
            }
        });

            if (buttonstate == 0) {
                /*Spinner mySpinner=(Spinner) findViewById(R.id.msgSpinner);
                String emgrMsg = mySpinner.getSelectedItem().toString();
                final String PREFS_NAME_1 = "MyPrefsFile";
                SharedPreferences settings1 = getSharedPreferences(PREFS_NAME_1, 0);
                settings1.edit().putString("emgr_Msg_1", emgrMsg).commit();
                */
                //icon.setImageResource(R.drawable.buttonup);
                buttonstate = 1;
                am.setRingerMode(0);

                IntentFilter cr = new IntentFilter();
                cr.addAction("android.intent.action.PHONE_STATE");
                registerReceiver(broadCastReceiver, cr);

                IntentFilter fp = new IntentFilter();
                fp.addAction("android.provider.Telephony.SMS_RECEIVED");
                fp.setPriority(999);
                registerReceiver(smsReceiver, fp);

                Toast toast1= Toast.makeText(getApplicationContext(), "Dyving!", Toast.LENGTH_SHORT);

                //toast1.setGravity(Gravity.CENTER_VERTICAL,0,0);
                toast1.show();
            } else {

               // icon.setImageResource(R.drawable.button);
                buttonstate = 0;
                am.setRingerMode(2);

                unregisterReceiver(broadCastReceiver);
                unregisterReceiver(smsReceiver);
                Toast.makeText(getApplicationContext(), "Surfacing!", Toast.LENGTH_SHORT)
                        .show();
            }
        }



    public View.OnClickListener peopleButtonHandler = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            Intent myintent = new Intent(getApplicationContext(), ContactsList.class); //A Context as its first parameter (this is used because the Activity class is a subclass of Context)

            startActivity(myintent);
        }
    };


    public View.OnClickListener ringButtonHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (ringbuttonstate == 0) {

                ring.setImageResource(com.Dyve.Dyve.R.drawable.ringgrey);

                ringbuttonstate = 1;

                //

                Toast.makeText(getApplicationContext(), "Dyve Alert will not have sound!", Toast.LENGTH_SHORT)
                        .show();


            } else {

                ring.setImageResource(com.Dyve.Dyve.R.drawable.ring);
                ringbuttonstate = 0;

                Toast.makeText(getApplicationContext(), "Dyve Alert will have sound!", Toast.LENGTH_SHORT)
                        .show();
            }
        }
    };

    public View.OnClickListener vibrateButtonHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (vibratebuttonstate == 0) {

                vibrate.setImageResource(com.Dyve.Dyve.R.drawable.vibrategrey);

                vibratebuttonstate = 1;

                //

                Toast.makeText(getApplicationContext(), "Dyve Alert will not vibrate!", Toast.LENGTH_SHORT)
                        .show();


            } else {

                vibrate.setImageResource(com.Dyve.Dyve.R.drawable.vibrate);
                vibratebuttonstate = 0;

                Toast.makeText(getApplicationContext(), "Dyve Alert will vibrate!", Toast.LENGTH_SHORT)
                        .show();
            }
        }
    };



}



