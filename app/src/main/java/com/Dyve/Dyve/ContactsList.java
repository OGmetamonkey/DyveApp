package com.Dyve.Dyve;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.CountDownTimer;
import android.provider.ContactsContract;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.biapps.Contact;
import com.biapps.DatabaseHandler;

import java.util.ArrayList;
import java.util.List;

public class ContactsList extends AppCompatActivity {
    private static final int PICK_CONTACT_REQUEST = 1;  // The request code
    private ImageButton help;
    public static ListView lv;
    public static ArrayList<String> numbers;

    private static final String TAG = "statusMessage";
    private ImageButton peoplefinder;
    private ImageButton peopleeater;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(com.Dyve.Dyve.R.layout.activity_contacts_list);
        Log.i(TAG, "onCreate");
        peoplefinder = (ImageButton) findViewById(com.Dyve.Dyve.R.id.peoplefinder);
        lv = (ListView) findViewById(com.Dyve.Dyve.R.id.ListViewcontacts);
        peoplefinder.setOnClickListener(peoplefinderhandler);
        peopleeater = (ImageButton) findViewById(com.Dyve.Dyve.R.id.peopleeater);
        peopleeater.setOnClickListener(peopleEaterHandler);
        help = (ImageButton) findViewById(com.Dyve.Dyve.R.id.help);
        help.setOnClickListener(helpButtonHandler);
        numbers = new ArrayList<String>(8);
        final String PREFS_NAME = "MyPrefsFile";
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        if (settings.getBoolean("my_first_time_people", true)) {
            //the app is being launched for first time, do something
            Log.d("Comments", "First time");
            final Animation animation1 = new AlphaAnimation(1, 0); // Change alpha from fully visible to invisible
            animation1.setDuration(500); // duration - half a second
            animation1.setInterpolator(new LinearInterpolator()); // do not alter animation rate
            animation1.setRepeatCount(8); // Repeat animation 10 times
            animation1.setRepeatMode(Animation.REVERSE); // Reverse animation at the end so the button will fade back in
            Toast toast2 = Toast.makeText(getApplicationContext(), "Tap here to select emergency contacts!", Toast.LENGTH_LONG);
            toast2.setGravity(Gravity.TOP, 0, 325);
            toast2.show();
            peoplefinder.startAnimation(animation1);

            new CountDownTimer(5000,500) {
                public void onFinish() {
                    // When timer is finished
                    // Execute your code here

                    Toast toast3= Toast.makeText(getApplicationContext(), "Tap here to delete emergency contacts!", Toast.LENGTH_LONG);

                    toast3.setGravity(Gravity.TOP,220,270);
                    toast3.show();
                    peopleeater.startAnimation(animation1);
                }

                public void onTick(long millisUntilFinished) {
                    // millisUntilFinished    The amount of time until finished.
                }
            }.start();
            settings.edit().putBoolean("my_first_time_people", false).commit();

        } else {
            Log.d("Comments", "Not First time");

        }


        DatabaseHandler db = new DatabaseHandler(this);

        List<Contact> contacts = db.getAllContacts();

        for (Contact cn : contacts) {
            String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
            // Writing Contacts to log
            Log.d("Name: ", log);
            if (!numbers.contains(cn.getName()))
                numbers.add(cn.getName());//add number to main list
            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, numbers);
            lv.setAdapter(arrayAdapter);
            arrayAdapter.notifyDataSetChanged();

        }

    }

    View.OnClickListener helpButtonHandler = new View.OnClickListener() {

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
            peoplefinder.startAnimation(animation);

            new CountDownTimer(2500,250) {
                public void onFinish() {
                    // When timer is finished
                    // Execute your code here

                    Toast toast= Toast.makeText(getApplicationContext(), "Tap here to remove emergency contacts!", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER_VERTICAL,0,0);
                    toast.show();
                    peopleeater.startAnimation(animation);
                }

                public void onTick(long millisUntilFinished) {
                    // millisUntilFinished    The amount of time until finished.
                }
            }.start();

        }
    };
    /**
     * CRUD Operations
     */
    int addState;
    public View.OnClickListener peoplefinderhandler = new View.OnClickListener() {
        @Override

        public void onClick(View v) {
            addState = 0;
            Intent pickContactIntent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));//An Intent provides a facility for performing late runtime
            // binding between the code in different applications. Its most significant use is in the launching of activities, where it can be thought of as the
            // glue between activities. It is basically a passive data structure holding an abstract description of an action to be performed.
            //action -- The general action to be performed (ACTION_PICK)
            //data -- The data to operate on, such as a person record in the contacts database, expressed as a Uri (Uri.parse)
            //Uri.parse: The URI contains the Intent's data as the base URI, with an additional fragment describing the action, categories, type, flags, package, component, and extras.
            pickContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE); // Show user only contacts w/ phone numbers
            startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST);
        }
    };

    public View.OnClickListener peopleEaterHandler = new View.OnClickListener() {
        @Override

        public void onClick(View v) {
            addState = 1;
            Intent pickContactIntent = new Intent(Intent.ACTION_PICK, Uri.parse("content://contacts"));//An Intent provides a facility for performing late runtime
            // binding between the code in different applications. Its most significant use is in the launching of activities, where it can be thought of as the
            // glue between activities. It is basically a passive data structure holding an abstract description of an action to be performed.
            //action -- The general action to be performed (ACTION_PICK)
            //data -- The data to operate on, such as a person record in the contacts database, expressed as a Uri (Uri.parse)
            //Uri.parse: The URI contains the Intent's data as the base URI, with an additional fragment describing the action, categories, type, flags, package, component, and extras.
            pickContactIntent.setType(ContactsContract.CommonDataKinds.Phone.CONTENT_TYPE); // Show user only contacts w/ phone numbers
            startActivityForResult(pickContactIntent, PICK_CONTACT_REQUEST);
        }
    };

    protected void onActivityResult(int requestCode, int resultCode, Intent authActivityResult) {
        super.onActivityResult(requestCode, resultCode, authActivityResult);
        switch (requestCode) {
            case (1):
                if (authActivityResult != null && resultCode == RESULT_OK) {
                    //counter = "Yes";
                    DatabaseHandler db = null;
                    if (requestCode == PICK_CONTACT_REQUEST) { // Make sure the request was successful
                        if (resultCode == RESULT_OK) {
                            // The user picked a contact.
                            // The Intent's data Uri identifies which contact was selected.

                            // Do something with the contact here (bigger example below)
                        }
                        Log.d(getClass().getSimpleName(), "Received Result!");

                        Uri contactUri = authActivityResult.getData();
                        String[] projection = {ContactsContract.CommonDataKinds.Phone.NUMBER}; //gets contact URI

                        String number = null;
                        String name = null;
                        // try {
                        Cursor cursor = getContentResolver().query(contactUri, projection, null, null, null);
                        assert cursor != null;
                        cursor.moveToFirst();

                        int column = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER);
                        number = cursor.getString(column);//sets NUMBER as string "number"

                        cursor.close();//pulls the number as string "number"

                        String[] projection2 = {ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_PRIMARY}; //gets contact URI
                        Cursor cursor2 = getContentResolver().query(contactUri, projection2, null, null, null);
                        assert cursor2 != null;
                        cursor2.moveToFirst();

                        int column2 = cursor2.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME_PRIMARY);
                        name = cursor2.getString(column2);//sets NUMBER as string "number"

                        cursor2.close();//pulls the name as string "name"
                        //TODO throw string into listview
                        //} catch (NullPointerException e) {
                        //e.printStackTrace(); //all this does is catch an exception without stopping the program
                        //}finally{

                        //lv = (ListView) findViewById(R.id.ListViewcontacts);

                        db = new DatabaseHandler(this);
/**
 * CRUD Operations
 * */
                        if (addState == 0) {
                            // Inserting Contacts
                            Log.d("Insert: ", "Inserting ..");
                            db.addContact(new Contact(name, number));
                            // Reading all contacts
                            Log.d("Reading: ", "Reading all contacts..");
                            List<Contact> contacts = db.getAllContacts();

                            for (Contact cn : contacts) {
                                String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
                                // Writing Contacts to log
                                Log.d("Name: ", log);
                                if (!numbers.contains(cn.getName()))
                                    numbers.add(cn.getName());//add number to main list

                                ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, numbers);

                                lv.setAdapter(arrayAdapter);
                                arrayAdapter.notifyDataSetChanged();
                                Toast.makeText(getApplicationContext(), "You added " + name + " to your emergency contacts.", Toast.LENGTH_SHORT)
                                        .show();

                            }
                        } else {
// Deleting Contacts
                            Log.d("Delete: ", "Deleting ..");


                            // Reading all contacts
                            Log.d("Reading: ", "Reading all contacts..");
                            List<Contact> contacts = db.getAllContacts();

                            for (Contact cn : contacts) {
                                String log = "Id: " + cn.getID() + " ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
                                // Writing Contacts to log
                                Log.d("Name: ", log);
                                String nameTemp = cn.getName();
                                if (nameTemp.contains(name)) {
                                    int KEY_ID = cn.getID();
                                    String KEY_ID_string = String.valueOf(KEY_ID);

                                    db.deleteContact(db.getContact(KEY_ID));//delete number from main list
                                    numbers.remove(cn.getName());//add number to main list
                                    ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, numbers);

                                    lv.setAdapter(arrayAdapter);
                                    arrayAdapter.notifyDataSetChanged();
                                    Toast.makeText(getApplicationContext(), "You deleted " + name + " from your emergency contacts.", Toast.LENGTH_SHORT)
                                            .show();
                        }
                    }
                }
        }
    }
}}}





