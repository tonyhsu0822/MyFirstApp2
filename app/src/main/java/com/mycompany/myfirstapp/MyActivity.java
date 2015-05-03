package com.mycompany.myfirstapp;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.support.v4.app.Fragment ;
import android.support.v4.app.FragmentActivity ;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.Vector;

public class MyActivity extends ActionBarActivity {
    public static int times = 0 ;
    public static String[] message = new String[100];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        for(int i = 0; i < 100; i++){
            message[i] = "";
        }
        ListView listView = (ListView)findViewById(R.id.inputRecord);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1, message));
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
    /**Called when the user click the Send button*/
    public void sendMessage(View view){

        //do something in response to button
        Intent intent = new Intent(this, DisplayMessageActivity.class) ;
        EditText editText = (EditText)findViewById(R.id.edit_message) ;

        message[times] = editText.getText().toString() ;
        times ++ ;

        editText.getText().clear();

        ListView listView = (ListView)findViewById(R.id.inputRecord);
        listView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,android.R.id.text1, message));
       // intent.putExtra(EXTRA_MESSAGE,message) ;
        //startActivity(intent);
       // finish();
    }
}
