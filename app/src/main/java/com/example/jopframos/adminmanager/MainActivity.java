package com.example.jopframos.adminmanager;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;


public class MainActivity extends Activity {

    public static String url = "https://by-invit-only.firebaseio.com/";
    public static final String admins = "Admins";
    private Firebase firebase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Firebase.setAndroidContext(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    public void onBtnFb(View v) {
      url = url.equals("https://by-invit-only.firebaseio.com/") ? "https://testing-3677.firebaseio.com/" : "https://by-invit-only.firebaseio.com/";
    }

    public void onBtnSubmit(View v) {
        connectToFirebase();
        EditText tv = (EditText) findViewById(R.id.editText);
        if(tv.getText().toString().equals("")) {
            Toast.makeText(this, "Invalid email!", Toast.LENGTH_SHORT).show();
        } else {
            firebase.child(admins).child(String.valueOf(tv.getText().toString().hashCode())).setValue("true");
            Toast.makeText(this, "Admin added successfully!", Toast.LENGTH_SHORT).show();
        }
    }

    private void connectToFirebase() {
       firebase = new Firebase(url);
    }
}
