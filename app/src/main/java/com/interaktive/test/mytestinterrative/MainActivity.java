package com.interaktive.test.mytestinterrative;
import android.Manifest;
import android.annotation.TargetApi;
import android.content.Context;
//import com.interaktive.test.model.*;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.interaktive.test.model.ListeAdapter;
import com.interaktive.test.model.OperateurTel;

import java.util.ArrayList;
import java.util.List;

@TargetApi(26)
public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private EditText passworTxt;
    private static final int REQUEST_READ_PHONE_PERMISSIONS = 1;
    private Button testButton;
    public static final String[] titles = new String[] { "Orange Sn","Tigo" };
    public static final String[] descriptions = new String[] {"1000f","1500f" };
    public static final Integer[] images = { R.drawable.ic_orange, R.drawable.ic_tigo_1_jpg};
    ListView listView;
    List<OperateurTel> rowItems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //testButton = (Button) findViewById(R.id.button);
        rowItems = new ArrayList<OperateurTel>();
        for (int i = 0; i < titles.length; i++) {
            OperateurTel item = new OperateurTel( titles[i], descriptions[i],images[i]);
            rowItems.add(item);
        }
        listView = (ListView) findViewById(R.id.list);
        ListeAdapter adapter = new ListeAdapter(this, rowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

     /*   ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},0);
       testButton.setOnClickListener(new View.OnClickListener() {
         //  @RequiresApi(api = 26)
            @Override
            public void onClick(View view) {

                //doJob();
                TelephonyManager telephonyManager = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
                Handler handle = new Handler();
                Log.d("test get operateur " ,"hhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh");
                Log.d("test get operateur " ,telephonyManager.getNetworkOperatorName());
              //  Log.d("test get operateur " ,telephonyManager.);

                TelephonyManager.UssdResponseCallback responseCallback = new TelephonyManager.UssdResponseCallback(){
                    @Override
                    public void onReceiveUssdResponse(TelephonyManager telephonyManager, String request, CharSequence response) {
                        super.onReceiveUssdResponse(telephonyManager, request, response);
                        Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
                    }
                    @Override
                    public void onReceiveUssdResponseFailed(TelephonyManager telephonyManager, String request, int failureCode) {
                        super.onReceiveUssdResponseFailed(telephonyManager, request, failureCode);
                        Toast.makeText(MainActivity.this, String.valueOf(failureCode), Toast.LENGTH_SHORT).show();
                    }
                };
               //telephonyManager.sendUssdRequest("#123#", responseCallback, handler);
                try {
                    Log.e("ussd","trying to send ussd request");
                   telephonyManager.sendUssdRequest("#176#", responseCallback, handle);
                }catch (Exception e){

                    String msg= e.getMessage();
                    Log.e("DEBUG",e.toString());
                    e.printStackTrace();
                }
            }

        });*/

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String encodedHash = Uri.encode("#");
                String ussd = "176" + encodedHash;
                startActivityForResult(new Intent("android.intent.action.CALL",
                        Uri.parse("tel:" + ussd)), 1);

            }
        });


    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast toast = Toast.makeText(getApplicationContext(),
                "Oeprateur" + (position + 1) + ": " + rowItems.get(position),
                Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM|Gravity.CENTER_HORIZONTAL, 0, 0);
        toast.show();

    }

    public void getUserPermission() {
        // check whether "READ_PHONE_STATE" permission is granted or not
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            // we do not have the permissions, we need to request permission from user
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, REQUEST_READ_PHONE_PERMISSIONS);
            return;
        }
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.BLUETOOTH) != PackageManager.PERMISSION_GRANTED) {
            // we do not have the permissions, we need to request permission from user
            ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.CALL_PHONE},REQUEST_READ_PHONE_PERMISSIONS);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.BLUETOOTH}, REQUEST_READ_PHONE_PERMISSIONS);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.BLUETOOTH_ADMIN}, REQUEST_READ_PHONE_PERMISSIONS);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.BLUETOOTH_PRIVILEGED}, REQUEST_READ_PHONE_PERMISSIONS);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.BLUETOOTH_PRIVILEGED}, REQUEST_READ_PHONE_PERMISSIONS);
            return;
        }
    }

    //***************************
    public void doJob(){
    TelephonyManager   telephonyManager=(TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
    Handler handler = new Handler();
    TelephonyManager.UssdResponseCallback callback = new TelephonyManager.UssdResponseCallback() {
        @Override
        public void onReceiveUssdResponse(TelephonyManager telephonyManager, String request, CharSequence response) {
            super.onReceiveUssdResponse(telephonyManager, request, response);
            Log.e("ussd",response.toString());

        }
        @Override
        public void onReceiveUssdResponseFailed(TelephonyManager telephonyManager, String request, int failureCode) {
            super.onReceiveUssdResponseFailed(telephonyManager, request, failureCode);
            Log.e("ussd","failed with code " + Integer.toString(failureCode));
        }
    };

    try {
        Log.e("ussd","trying to send ussd request");
        telephonyManager.sendUssdRequest("#123#",
                callback,
                handler);
    }catch (Exception e){


        String msg= e.getMessage();
        Log.e("DEBUG",e.toString());
        e.printStackTrace();
    }
}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) { switch(item.getItemId()) {
        case R.id.men_preferenc:
            Intent intent = new Intent(MainActivity.this,UssdActivity.class);
            startActivity(intent);
            finish();
            return(true);

    }
        return(super.onOptionsItemSelected(item));
    }
}

