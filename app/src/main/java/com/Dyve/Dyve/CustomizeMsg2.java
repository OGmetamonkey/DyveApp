package com.Dyve.Dyve;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import static com.Dyve.Dyve.R.id.nonEmgrMsg;
import static com.Dyve.Dyve.R.id.nonEmgrMsg2;
import static com.Dyve.Dyve.R.id.nonEmgrMsg3;
import static com.Dyve.Dyve.R.id.nonEmgrMsg4;
import static com.Dyve.Dyve.R.id.nonEmgrMsg5;

/**
 * Created by Jake on 6/24/2016.
 */

public class CustomizeMsg2 extends AppCompatActivity {

    // private Button saveMsgButton;
    //private Button saveNonMsgButton;

    public static Context contextOfApplication;
    private static final String TAG = "CustomizeMsg2";

    public static Context getContextOfApplication() {
        return contextOfApplication;
    }
    private ImageButton nonEmgr1;
    private ImageButton nonEmgr2;
    private ImageButton nonEmgr3;
    private ImageButton nonEmgr4;
    private ImageButton nonEmgr5;

    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customize_msg_2);
        //customize = 1;
        contextOfApplication = getApplicationContext();

        nonEmgr1 = (ImageButton) findViewById(R.id.nonEmgr1);
        nonEmgr1.setOnClickListener(nonEmgr1ButtonHandler);
        nonEmgr2 = (ImageButton) findViewById(R.id.nonEmgr2);
        nonEmgr2.setOnClickListener(nonEmgr2ButtonHandler);
        nonEmgr3 = (ImageButton) findViewById(R.id.nonEmgr3);
        nonEmgr3.setOnClickListener(nonEmgr3ButtonHandler);
        nonEmgr4 = (ImageButton) findViewById(R.id.nonEmgr4);
        nonEmgr4.setOnClickListener(nonEmgr4ButtonHandler);
        nonEmgr5 = (ImageButton) findViewById(R.id.nonEmgr5);
        nonEmgr5.setOnClickListener(nonEmgr5ButtonHandler);

        final EditText message = (EditText) findViewById(nonEmgrMsg);
        final EditText message2 = (EditText) findViewById(nonEmgrMsg2);
        final EditText message3 = (EditText) findViewById(nonEmgrMsg3);
        final EditText message4 = (EditText) findViewById(nonEmgrMsg4);
        final EditText message5 = (EditText) findViewById(nonEmgrMsg5);

        final SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(contextOfApplication);


        final String txtCheck = getResources().getString(com.Dyve.Dyve.R.string.nonEmgrCustomTxt);
        final String txtCheck2 = getResources().getString(com.Dyve.Dyve.R.string.nonEmgrCustomTxt2);
        final String txtCheck3 = getResources().getString(com.Dyve.Dyve.R.string.nonEmgrCustomTxt3);
        final String txtCheck4 = getResources().getString(com.Dyve.Dyve.R.string.nonEmgrCustomTxt4);
        final String txtCheck5 = getResources().getString(com.Dyve.Dyve.R.string.nonEmgrCustomTxt5);

        String prefsCheck = prefs.getString("nonAutoSave", null);
        String prefsCheck2 = prefs.getString("nonAutoSave12", null);
        String prefsCheck3 = prefs.getString("nonAutoSave13", null);
        String prefsCheck4 = prefs.getString("nonAutoSave14", null);
        String prefsCheck5 = prefs.getString("nonAutoSave15", null);


        if (prefsCheck == null) {
            prefs.edit().putString("nonAutoSave", txtCheck.toString()).commit();
        } else {
        }

        if (prefsCheck2 == null) {
            prefs.edit().putString("nonAutoSave12", txtCheck2.toString()).commit();
        } else {
        }

        if (prefsCheck3 == null) {
            prefs.edit().putString("nonAutoSave13", txtCheck3.toString()).commit();
        } else {
        }

        if (prefsCheck4 == null) {
            prefs.edit().putString("nonAutoSave14", txtCheck4.toString()).commit();
        } else {
        }

        if (prefsCheck5 == null) {
            prefs.edit().putString("nonAutoSave15", txtCheck5.toString()).commit();
        } else {
        }


        Integer nonEmgrbuttonstate = prefs.getInt("nonAutoSave3", 0);

        if (nonEmgrbuttonstate == 0) {
            nonEmgrbuttonstate = 1;
        } else {
        }
        if (nonEmgrbuttonstate.equals(1)) {
            nonEmgr1.setAlpha(1f); // to make it mostly transparent;
            nonEmgr2.setAlpha(0.2f); // to make it mostly transparent;
            nonEmgr3.setAlpha(0.2f); // to make it mostly transparent;
            nonEmgr4.setAlpha(0.2f); // to make it mostly transparent;
            nonEmgr5.setAlpha(0.2f); // to make it mostly transparent;
        }

        if (nonEmgrbuttonstate.equals(2)) {
            nonEmgr2.setAlpha(1f); // to make it mostly transparent;
            nonEmgr1.setAlpha(0.2f); // to make it mostly transparent;
            nonEmgr3.setAlpha(0.2f); // to make it mostly transparent;
            nonEmgr4.setAlpha(0.2f); // to make it mostly transparent;
            nonEmgr5.setAlpha(0.2f); // to make it mostly transparent;
        }

        if (nonEmgrbuttonstate.equals(3)) {
            nonEmgr3.setAlpha(1f); // to make it mostly transparent;
            nonEmgr2.setAlpha(0.2f); // to make it mostly transparent;
            nonEmgr1.setAlpha(0.2f); // to make it mostly transparent;
            nonEmgr4.setAlpha(0.2f); // to make it mostly transparent;
            nonEmgr5.setAlpha(0.2f); // to make it mostly transparent;
        }

        if (nonEmgrbuttonstate.equals(4)) {
            nonEmgr4.setAlpha(1f); // to make it mostly transparent;
            nonEmgr2.setAlpha(0.2f); // to make it mostly transparent;
            nonEmgr3.setAlpha(0.2f); // to make it mostly transparent;
            nonEmgr1.setAlpha(0.2f); // to make it mostly transparent;
            nonEmgr5.setAlpha(0.2f); // to make it mostly transparent;
        }

        if (nonEmgrbuttonstate.equals(5)) {
            nonEmgr5.setAlpha(1f); // to make it mostly transparent;
            nonEmgr2.setAlpha(0.2f); // to make it mostly transparent;
            nonEmgr3.setAlpha(0.2f); // to make it mostly transparent;
            nonEmgr4.setAlpha(0.2f); // to make it mostly transparent;
            nonEmgr1.setAlpha(0.2f); // to make it mostly transparent;
        }

        message.setText(prefs.getString("nonAutoSave", ""));
        message.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                prefs.edit().putString("nonAutoSave", s.toString()).commit();
                Integer nonEmgrbuttonstate = prefs.getInt("nonAutoSave3", 0);
                if(nonEmgrbuttonstate <= 1){
                    prefs.edit().putString("nonAutoSave20", message.getText().toString()).commit();
                }
            }


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                prefs.edit().putString("nonAutoSave", s.toString()).commit();
                Integer nonEmgrbuttonstate = prefs.getInt("nonAutoSave3", 0);
                if (nonEmgrbuttonstate <= 1) {
                    prefs.edit().putString("nonAutoSave20", message.getText().toString()).commit();
                }
            }


            @Override
            public void afterTextChanged(Editable s) {
                prefs.edit().putString("nonAutoSave", s.toString()).commit();
                Integer nonEmgrbuttonstate = prefs.getInt("nonAutoSave3", 0);
                if(nonEmgrbuttonstate <= 1){
                    prefs.edit().putString("nonAutoSave20", message.getText().toString()).commit();

                }
            }});


        message2.setText(prefs.getString("nonAutoSave12", ""));
        message2.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                prefs.edit().putString("nonAutoSave12", s.toString()).commit();
                Integer nonEmgrbuttonstate = prefs.getInt("nonAutoSave3", 0);
                if (nonEmgrbuttonstate == 2) {
                    prefs.edit().putString("nonAutoSave20", message2.getText().toString()).commit();
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                prefs.edit().putString("nonAutoSave12", s.toString()).commit();
                Integer nonEmgrbuttonstate = prefs.getInt("nonAutoSave3", 0);
                if (nonEmgrbuttonstate == 2) {
                    prefs.edit().putString("nonAutoSave20", message2.getText().toString()).commit();
                }
            }


            @Override
            public void afterTextChanged(Editable s) {
                prefs.edit().putString("nonAutoSave12", s.toString()).commit();
                Integer nonEmgrbuttonstate = prefs.getInt("nonAutoSave3", 0);
                if (nonEmgrbuttonstate == 2) {
                    prefs.edit().putString("nonAutoSave20", message2.getText().toString()).commit();
                }
            }
        });

        message3.setText(prefs.getString("nonAutoSave13", ""));
        message3.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                prefs.edit().putString("nonAutoSave13", s.toString()).commit();
                Integer nonEmgrbuttonstate = prefs.getInt("nonAutoSave3", 0);
                if (nonEmgrbuttonstate == 3) {
                    prefs.edit().putString("nonAutoSave20", message3.getText().toString()).commit();
                }
            }


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                prefs.edit().putString("nonAutoSave13", s.toString()).commit();
                Integer nonEmgrbuttonstate = prefs.getInt("nonAutoSave3", 0);
                if (nonEmgrbuttonstate == 3) {
                    prefs.edit().putString("nonAutoSave20", message3.getText().toString()).commit();
                }
            }


            @Override
            public void afterTextChanged(Editable s) {
                prefs.edit().putString("nonAutoSave13", s.toString()).commit();
                Integer nonEmgrbuttonstate = prefs.getInt("nonAutoSave3", 0);
                if (nonEmgrbuttonstate == 3) {
                    prefs.edit().putString("nonAutoSave20", message3.getText().toString()).commit();
                }

            }
        });

        message4.setText(prefs.getString("nonAutoSave14", ""));
        message4.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                prefs.edit().putString("nonAutoSave14", s.toString()).commit();
                Integer nonEmgrbuttonstate = prefs.getInt("nonAutoSave3", 0);
                if (nonEmgrbuttonstate == 4) {
                    prefs.edit().putString("nonAutoSave20", message4.getText().toString()).commit();
                }
            }


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                prefs.edit().putString("nonAutoSave14", s.toString()).commit();
                Integer nonEmgrbuttonstate = prefs.getInt("nonAutoSave3", 0);
                if (nonEmgrbuttonstate == 4) {
                    prefs.edit().putString("nonAutoSave20", message4.getText().toString()).commit();
                }
            }


            @Override
            public void afterTextChanged(Editable s) {
                prefs.edit().putString("nonAutoSave14", s.toString()).commit();
                Integer nonEmgrbuttonstate = prefs.getInt("nonAutoSave3", 0);
                if (nonEmgrbuttonstate == 4) {
                    prefs.edit().putString("nonAutoSave20", message4.getText().toString()).commit();
                }
            }
        });

        message5.setText(prefs.getString("nonAutoSave15", ""));
        message5.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                prefs.edit().putString("nonAutoSave15", s.toString()).commit();
                Integer nonEmgrbuttonstate = prefs.getInt("nonAutoSave3", 0);
                if (nonEmgrbuttonstate == 5) {
                    prefs.edit().putString("nonAutoSave20", message5.getText().toString()).commit();
                }
            }


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                prefs.edit().putString("nonAutoSave15", s.toString()).commit();
                Integer nonEmgrbuttonstate = prefs.getInt("nonAutoSave3", 0);
                if (nonEmgrbuttonstate == 5) {
                    prefs.edit().putString("nonAutoSave20", message5.getText().toString()).commit();
                }
            }


            @Override
            public void afterTextChanged(Editable s) {
                prefs.edit().putString("nonAutoSave15", s.toString()).commit();
                Integer nonEmgrbuttonstate = prefs.getInt("nonAutoSave3", 0);
                if (nonEmgrbuttonstate == 5) {
                    prefs.edit().putString("nonAutoSave20", message5.getText().toString()).commit();
                }
            }
        });

        message.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }

        });

        message2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }

        });

        message3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }

        });

        message4.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }

        });

        message5.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    hideKeyboard(v);
                }
            }

        });

    }


    public View.OnClickListener nonEmgr1ButtonHandler = new View.OnClickListener() {

        public void onClick(View v) {

            Context applicationContext = CustomizeMsg2.getContextOfApplication();
            final SharedPreferences prefs = PreferenceManager
                    .getDefaultSharedPreferences(applicationContext);
            Integer nonEmgrbuttonstate = prefs.getInt("nonAutoSave3", 0);


            if (nonEmgrbuttonstate != 1) {

                nonEmgr1.setAlpha(1f); // to make it mostly transparent;
                nonEmgr2.setAlpha(0.2f); // to make it mostly transparent;
                nonEmgr3.setAlpha(0.2f); // to make it mostly transparent;
                nonEmgr4.setAlpha(0.2f); // to make it mostly transparent;
                nonEmgr5.setAlpha(0.2f); // to make it mostly transparent;
                nonEmgrbuttonstate = 1;
                prefs.edit().putInt("nonAutoSave3", nonEmgrbuttonstate).commit();
                String reply1 = prefs.getString("nonAutoSave1", "");
                prefs.edit().putString("nonAutoSave20",reply1 ).commit();

            } else {
            }
        }
    };

    public View.OnClickListener nonEmgr2ButtonHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Context applicationContext = CustomizeMsg2.getContextOfApplication();
            final SharedPreferences prefs = PreferenceManager
                    .getDefaultSharedPreferences(applicationContext);
            Integer nonEmgrbuttonstate = prefs.getInt("nonAutoSave3", 0);

            if (nonEmgrbuttonstate !=2) {


                nonEmgr2.setAlpha(1f); // to make it mostly transparent;
                nonEmgr1.setAlpha(0.2f); // to make it mostly transparent;
                nonEmgr3.setAlpha(0.2f); // to make it mostly transparent;
                nonEmgr4.setAlpha(0.2f); // to make it mostly transparent;
                nonEmgr5.setAlpha(0.2f); // to make it mostly transparent;
                nonEmgrbuttonstate = 2;
                prefs.edit().putInt("nonAutoSave3", nonEmgrbuttonstate).commit();
                String reply2 = prefs.getString("nonAutoSave12", "");
                prefs.edit().putString("nonAutoSave20", reply2).commit();
            } else {

            }

        }
    };

    public View.OnClickListener nonEmgr3ButtonHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Context applicationContext = CustomizeMsg2.getContextOfApplication();
            final SharedPreferences prefs = PreferenceManager
                    .getDefaultSharedPreferences(applicationContext);
            Integer nonEmgrbuttonstate = prefs.getInt("nonAutoSave3", 0);
            if (nonEmgrbuttonstate !=3) {


                nonEmgr3.setAlpha(1f); // to make it mostly transparent;
                nonEmgr2.setAlpha(0.2f); // to make it mostly transparent;
                nonEmgr1.setAlpha(0.2f); // to make it mostly transparent;
                nonEmgr4.setAlpha(0.2f); // to make it mostly transparent;
                nonEmgr5.setAlpha(0.2f); // to make it mostly transparent;
                nonEmgrbuttonstate = 3;
                prefs.edit().putInt("nonAutoSave3", nonEmgrbuttonstate).commit();
                String reply3 = prefs.getString("nonAutoSave13", "");
                prefs.edit().putString("nonAutoSave20", reply3).commit();
            } else {

            }

        }
    };

    public View.OnClickListener nonEmgr4ButtonHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Context applicationContext = CustomizeMsg2.getContextOfApplication();
            final SharedPreferences prefs = PreferenceManager
                    .getDefaultSharedPreferences(applicationContext);
            Integer nonEmgrbuttonstate = prefs.getInt("nonAutoSave3", 0);
            if (nonEmgrbuttonstate !=4) {


                nonEmgr4.setAlpha(1f); // to make it mostly transparent;
                nonEmgr2.setAlpha(0.2f); // to make it mostly transparent;
                nonEmgr3.setAlpha(0.2f); // to make it mostly transparent;
                nonEmgr1.setAlpha(0.2f); // to make it mostly transparent;
                nonEmgr5.setAlpha(0.2f); // to make it mostly transparent;
                nonEmgrbuttonstate = 4;
                prefs.edit().putInt("nonAutoSave3", nonEmgrbuttonstate).commit();
                String reply4 = prefs.getString("nonAutoSave14", "");
                prefs.edit().putString("nonAutoSave20", reply4).commit();
            } else {

            }

        }
    };

    public View.OnClickListener nonEmgr5ButtonHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Context applicationContext = CustomizeMsg2.getContextOfApplication();
            final SharedPreferences prefs = PreferenceManager
                    .getDefaultSharedPreferences(applicationContext);
            Integer nonEmgrbuttonstate = prefs.getInt("nonAutoSave3", 0);
            if (nonEmgrbuttonstate !=5) {


                nonEmgr5.setAlpha(1f); // to make it mostly transparent;
                nonEmgr2.setAlpha(0.2f); // to make it mostly transparent;
                nonEmgr3.setAlpha(0.2f); // to make it mostly transparent;
                nonEmgr4.setAlpha(0.2f); // to make it mostly transparent;
                nonEmgr1.setAlpha(0.2f); // to make it mostly transparent;
                nonEmgrbuttonstate = 5;
                prefs.edit().putInt("nonAutoSave3", nonEmgrbuttonstate).commit();
                String reply5 = prefs.getString("nonAutoSave15", "");
                prefs.edit().putString("nonAutoSave20", reply5).commit();
            } else {

            }

        }
    };

}



