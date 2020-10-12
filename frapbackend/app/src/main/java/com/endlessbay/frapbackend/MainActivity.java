package com.endlessbay.frapbackend;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ListView;
import android.app.Dialog;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.endlessbay.frapbackend.m_FireBase.FirebaseHelper;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import com.endlessbay.frapbackend.Service.ListenOrder;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ArrayAdapter<String> adapter;
    DatabaseReference db;
    FirebaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent service = new Intent(getBaseContext(), ListenOrder.class);
        startService(service);
        WebView myWebView = new WebView(this);
        setContentView(myWebView);
        WebSettings webSettings = myWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        myWebView.setWebViewClient(new WebViewClient());
        myWebView.loadUrl("https://frappe-d1495.firebaseio.com/Requests");

            }

    }




