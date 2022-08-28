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

import static com.Dyve.Dyve.R.id.emgrMsg;
import static com.Dyve.Dyve.R.id.emgrMsg2;
import static com.Dyve.Dyve.R.id.emgrMsg3;
import static com.Dyve.Dyve.R.id.emgrMsg4;
import static com.Dyve.Dyve.R.id.emgrMsg5;

/**
 * Created by Jake on 6/24/2016.
 */

public class CustomizeMsg extends AppCompatActivity {

   // private Button saveMsgButton;
    //private Button saveNonMsgButton;

    public static Context contextOfApplication;
    private static final String TAG = "CustomizeMsg";

    public static Context getContextOfApplication() {
        return contextOfApplication;
    }
    private ImageButton emgr1;
    private ImageButton emgr2;
    private ImageButton emgr3;
    private ImageButton emgr4;
    private ImageButton emgr5;
    public void hideKeyboard(View view) {
        InputMethodManager inputMethodManager =(InputMethodManager)getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.Dyve.Dyve.R.layout.activity_customize_msg);
        //customize = 1;
        contextOfApplication = getApplicationContext();

        emgr1 = (ImageButton) findViewById(R.id.emgr1);
        emgr1.setOnClickListener(emgr1ButtonHandler);
        emgr2 = (ImageButton) findViewById(R.id.emgr2);
        emgr2.setOnClickListener(emgr2ButtonHandler);
        emgr3 = (ImageButton) findViewById(R.id.emgr3);
        emgr3.setOnClickListener(emgr3ButtonHandler);
        emgr4 = (ImageButton) findViewById(R.id.emgr4);
        emgr4.setOnClickListener(emgr4ButtonHandler);
        emgr5 = (ImageButton) findViewById(R.id.emgr5);
        emgr5.setOnClickListener(emgr5ButtonHandler);

        final EditText message = (EditText) findViewById(emgrMsg);
        final EditText message2 = (EditText) findViewById(emgrMsg2);
        final EditText message3 = (EditText) findViewById(emgrMsg3);
        final EditText message4 = (EditText) findViewById(emgrMsg4);
        final EditText message5 = (EditText) findViewById(emgrMsg5);

        final SharedPreferences prefs = PreferenceManager
                .getDefaultSharedPreferences(contextOfApplication);


        final String txtCheck = getResources().getString(com.Dyve.Dyve.R.string.emgrCustomTxt);
        final String txtCheck2 = getResources().getString(com.Dyve.Dyve.R.string.emgrCustomTxt2);
        final String txtCheck3 = getResources().getString(com.Dyve.Dyve.R.string.emgrCustomTxt3);
        final String txtCheck4 = getResources().getString(com.Dyve.Dyve.R.string.emgrCustomTxt4);
        final String txtCheck5 = getResources().getString(com.Dyve.Dyve.R.string.emgrCustomTxt5);

        String prefsCheck = prefs.getString("autoSave", null);
        String prefsCheck2 = prefs.getString("autoSave12", null);
        String prefsCheck3 = prefs.getString("autoSave13", null);
        String prefsCheck4 = prefs.getString("autoSave14", null);
        String prefsCheck5 = prefs.getString("autoSave15", null);


        if (prefsCheck == null) {
            prefs.edit().putString("autoSave", txtCheck.toString()).commit();
        } else {
        }

        if (prefsCheck2 == null) {
            prefs.edit().putString("autoSave12", txtCheck2.toString()).commit();
        } else {
        }

        if (prefsCheck3 == null) {
            prefs.edit().putString("autoSave13", txtCheck3.toString()).commit();
        } else {
        }

        if (prefsCheck4 == null) {
            prefs.edit().putString("autoSave14", txtCheck4.toString()).commit();
        } else {
        }

        if (prefsCheck5 == null) {
            prefs.edit().putString("autoSave15", txtCheck5.toString()).commit();
        } else {
        }


        Integer emgrbuttonstate = prefs.getInt("autoSave3", 0);

        if (emgrbuttonstate == 0) {
            emgrbuttonstate = 1;
        } else {
        }
        if (emgrbuttonstate.equals(1)) {
            emgr1.setAlpha(1f); // to make it mostly transparent;
            emgr2.setAlpha(0.2f); // to make it mostly transparent;
            emgr3.setAlpha(0.2f); // to make it mostly transparent;
            emgr4.setAlpha(0.2f); // to make it mostly transparent;
            emgr5.setAlpha(0.2f); // to make it mostly transparent;
        }

        if (emgrbuttonstate.equals(2)) {
            emgr2.setAlpha(1f); // to make it mostly transparent;
            emgr1.setAlpha(0.2f); // to make it mostly transparent;
            emgr3.setAlpha(0.2f); // to make it mostly transparent;
            emgr4.setAlpha(0.2f); // to make it mostly transparent;
            emgr5.setAlpha(0.2f); // to make it mostly transparent;
        }

        if (emgrbuttonstate.equals(3)) {
            emgr3.setAlpha(1f); // to make it mostly transparent;
            emgr2.setAlpha(0.2f); // to make it mostly transparent;
            emgr1.setAlpha(0.2f); // to make it mostly transparent;
            emgr4.setAlpha(0.2f); // to make it mostly transparent;
            emgr5.setAlpha(0.2f); // to make it mostly transparent;
        }

        if (emgrbuttonstate.equals(4)) {
            emgr4.setAlpha(1f); // to make it mostly transparent;
            emgr2.setAlpha(0.2f); // to make it mostly transparent;
            emgr3.setAlpha(0.2f); // to make it mostly transparent;
            emgr1.setAlpha(0.2f); // to make it mostly transparent;
            emgr5.setAlpha(0.2f); // to make it mostly transparent;
        }

        if (emgrbuttonstate.equals(5)) {
                emgr5.setAlpha(1f); // to make it mostly transparent;
                emgr2.setAlpha(0.2f); // to make it mostly transparent;
                emgr3.setAlpha(0.2f); // to make it mostly transparent;
                emgr4.setAlpha(0.2f); // to make it mostly transparent;
                emgr1.setAlpha(0.2f); // to make it mostly transparent;
        }

            message.setText(prefs.getString("autoSave", ""));
            message.addTextChangedListener(new TextWatcher() {
                @Override
                public void onTextChanged(CharSequence s, int start, int before,
                                          int count) {
                    prefs.edit().putString("autoSave", s.toString()).commit();
                    Integer emgrbuttonstate = prefs.getInt("autoSave3", 0);
                    if (emgrbuttonstate <= 1) {
                        prefs.edit().putString("autoSave20", message.getText().toString()).commit();
                    }
                }


                @Override
                public void beforeTextChanged(CharSequence s, int start, int count,
                                              int after) {
                    prefs.edit().putString("autoSave", s.toString()).commit();
                    Integer emgrbuttonstate = prefs.getInt("autoSave3", 0);
                    if (emgrbuttonstate <= 1) {
                        prefs.edit().putString("autoSave20", message.getText().toString()).commit();
                    }
                }


                @Override
                public void afterTextChanged(Editable s) {
                    prefs.edit().putString("autoSave", s.toString()).commit();
                    Integer emgrbuttonstate = prefs.getInt("autoSave3", 0);
                    if (emgrbuttonstate <= 1) {
                        prefs.edit().putString("autoSave20", message.getText().toString()).commit();

                    }
                }
            });


    message2.setText(prefs.getString("autoSave12", ""));
    message2.addTextChangedListener(new TextWatcher() {
        @Override
        public void onTextChanged(CharSequence s, int start, int before,
                                  int count) {
            prefs.edit().putString("autoSave12", s.toString()).commit();
            Integer emgrbuttonstate = prefs.getInt("autoSave3", 0);
            if (emgrbuttonstate == 2) {
                prefs.edit().putString("autoSave20", message2.getText().toString()).commit();
            }
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                                      int after) {
            prefs.edit().putString("autoSave12", s.toString()).commit();
            Integer emgrbuttonstate = prefs.getInt("autoSave3", 0);
            if (emgrbuttonstate == 2) {
                prefs.edit().putString("autoSave20", message2.getText().toString()).commit();
            }
        }


        @Override
        public void afterTextChanged(Editable s) {
            prefs.edit().putString("autoSave12", s.toString()).commit();
            Integer emgrbuttonstate = prefs.getInt("autoSave3", 0);
            if (emgrbuttonstate == 2) {
                prefs.edit().putString("autoSave20", message2.getText().toString()).commit();
            }
        }
    });

        message3.setText(prefs.getString("autoSave13", ""));
        message3.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                prefs.edit().putString("autoSave13", s.toString()).commit();
                Integer emgrbuttonstate = prefs.getInt("autoSave3", 0);
                if (emgrbuttonstate == 3) {
                    prefs.edit().putString("autoSave20", message3.getText().toString()).commit();
                }
            }


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                prefs.edit().putString("autoSave13", s.toString()).commit();
                Integer emgrbuttonstate = prefs.getInt("autoSave3", 0);
                if (emgrbuttonstate == 3) {
                    prefs.edit().putString("autoSave20", message3.getText().toString()).commit();
                }
            }


            @Override
            public void afterTextChanged(Editable s) {
                prefs.edit().putString("autoSave13", s.toString()).commit();
                Integer emgrbuttonstate = prefs.getInt("autoSave3", 0);
                if (emgrbuttonstate == 3) {
                    prefs.edit().putString("autoSave20", message3.getText().toString()).commit();
                }

            }
        });

        message4.setText(prefs.getString("autoSave14", ""));
        message4.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                prefs.edit().putString("autoSave14", s.toString()).commit();
                Integer emgrbuttonstate = prefs.getInt("autoSave3", 0);
                if (emgrbuttonstate == 4) {
                    prefs.edit().putString("autoSave20", message4.getText().toString()).commit();
                }
            }


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                prefs.edit().putString("autoSave14", s.toString()).commit();
                Integer emgrbuttonstate = prefs.getInt("autoSave3", 0);
                if (emgrbuttonstate == 4) {
                    prefs.edit().putString("autoSave20", message4.getText().toString()).commit();
                }
            }


            @Override
            public void afterTextChanged(Editable s) {
                prefs.edit().putString("autoSave14", s.toString()).commit();
                Integer emgrbuttonstate = prefs.getInt("autoSave3", 0);
                if (emgrbuttonstate == 4) {
                    prefs.edit().putString("autoSave20", message4.getText().toString()).commit();
                }
            }
        });

        message5.setText(prefs.getString("autoSave15", ""));
        message5.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                prefs.edit().putString("autoSave15", s.toString()).commit();
                Integer emgrbuttonstate = prefs.getInt("autoSave3", 0);
                if (emgrbuttonstate == 5) {
                    prefs.edit().putString("autoSave20", message5.getText().toString()).commit();
                }
            }


            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                prefs.edit().putString("autoSave15", s.toString()).commit();
                Integer emgrbuttonstate = prefs.getInt("autoSave3", 0);
                if (emgrbuttonstate == 5) {
                    prefs.edit().putString("autoSave20", message5.getText().toString()).commit();
                }
            }


            @Override
            public void afterTextChanged(Editable s) {
                prefs.edit().putString("autoSave15", s.toString()).commit();
                Integer emgrbuttonstate = prefs.getInt("autoSave3", 0);
                if (emgrbuttonstate == 5) {
                    prefs.edit().putString("autoSave20", message5.getText().toString()).commit();
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


    public View.OnClickListener emgr1ButtonHandler = new View.OnClickListener() {

        public void onClick(View v) {

            Context applicationContext = CustomizeMsg.getContextOfApplication();
            final SharedPreferences prefs = PreferenceManager
                    .getDefaultSharedPreferences(applicationContext);
            Integer emgrbuttonstate = prefs.getInt("autoSave3", 0);


            if (emgrbuttonstate != 1) {

                emgr1.setAlpha(1f); // to make it mostly transparent;
                emgr2.setAlpha(0.2f); // to make it mostly transparent;
                emgr3.setAlpha(0.2f); // to make it mostly transparent;
                emgr4.setAlpha(0.2f); // to make it mostly transparent;
                emgr5.setAlpha(0.2f); // to make it mostly transparent;
                emgrbuttonstate = 1;
                prefs.edit().putInt("autoSave3", emgrbuttonstate).commit();
                String reply1 = prefs.getString("autoSave1", "");
                prefs.edit().putString("autoSave20",reply1 ).commit();

            } else {
            }
        }
    };

    public View.OnClickListener emgr2ButtonHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Context applicationContext = CustomizeMsg.getContextOfApplication();
            final SharedPreferences prefs = PreferenceManager
                    .getDefaultSharedPreferences(applicationContext);
            Integer emgrbuttonstate = prefs.getInt("autoSave3", 0);

            if (emgrbuttonstate !=2) {


                emgr2.setAlpha(1f); // to make it mostly transparent;
                emgr1.setAlpha(0.2f); // to make it mostly transparent;
                emgr3.setAlpha(0.2f); // to make it mostly transparent;
                emgr4.setAlpha(0.2f); // to make it mostly transparent;
                emgr5.setAlpha(0.2f); // to make it mostly transparent;
                emgrbuttonstate = 2;
                prefs.edit().putInt("autoSave3", emgrbuttonstate).commit();
                String reply2 = prefs.getString("autoSave12", "");
                prefs.edit().putString("autoSave20", reply2).commit();
            } else {

            }

        }
    };

    public View.OnClickListener emgr3ButtonHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Context applicationContext = CustomizeMsg.getContextOfApplication();
            final SharedPreferences prefs = PreferenceManager
                    .getDefaultSharedPreferences(applicationContext);
            Integer emgrbuttonstate = prefs.getInt("autoSave3", 0);
            if (emgrbuttonstate !=3) {


                emgr3.setAlpha(1f); // to make it mostly transparent;
                emgr2.setAlpha(0.2f); // to make it mostly transparent;
                emgr1.setAlpha(0.2f); // to make it mostly transparent;
                emgr4.setAlpha(0.2f); // to make it mostly transparent;
                emgr5.setAlpha(0.2f); // to make it mostly transparent;
                emgrbuttonstate = 3;
                prefs.edit().putInt("autoSave3", emgrbuttonstate).commit();
                String reply3 = prefs.getString("autoSave13", "");
                prefs.edit().putString("autoSave20", reply3).commit();
            } else {

            }

        }
    };

    public View.OnClickListener emgr4ButtonHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Context applicationContext = CustomizeMsg.getContextOfApplication();
            final SharedPreferences prefs = PreferenceManager
                    .getDefaultSharedPreferences(applicationContext);
            Integer emgrbuttonstate = prefs.getInt("autoSave3", 0);
            if (emgrbuttonstate !=4) {


                emgr4.setAlpha(1f); // to make it mostly transparent;
                emgr2.setAlpha(0.2f); // to make it mostly transparent;
                emgr3.setAlpha(0.2f); // to make it mostly transparent;
                emgr1.setAlpha(0.2f); // to make it mostly transparent;
                emgr5.setAlpha(0.2f); // to make it mostly transparent;
                emgrbuttonstate = 4;
                prefs.edit().putInt("autoSave3", emgrbuttonstate).commit();
                String reply4 = prefs.getString("autoSave14", "");
                prefs.edit().putString("autoSave20", reply4).commit();
            } else {

            }

        }
    };

    public View.OnClickListener emgr5ButtonHandler = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Context applicationContext = CustomizeMsg.getContextOfApplication();
            final SharedPreferences prefs = PreferenceManager
                    .getDefaultSharedPreferences(applicationContext);
            Integer emgrbuttonstate = prefs.getInt("autoSave3", 0);
            if (emgrbuttonstate !=5) {


                emgr5.setAlpha(1f); // to make it mostly transparent;
                emgr2.setAlpha(0.2f); // to make it mostly transparent;
                emgr3.setAlpha(0.2f); // to make it mostly transparent;
                emgr4.setAlpha(0.2f); // to make it mostly transparent;
                emgr1.setAlpha(0.2f); // to make it mostly transparent;
                emgrbuttonstate = 5;
                prefs.edit().putInt("autoSave3", emgrbuttonstate).commit();
                String reply5 = prefs.getString("autoSave15", "");
                prefs.edit().putString("autoSave20", reply5).commit();
            } else {

            }

        }
    };

}



