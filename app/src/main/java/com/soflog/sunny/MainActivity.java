package com.soflog.sunny;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.soflog.sunny.R;

public class MainActivity extends Activity {

    private String name = "UNKNOWN";
    private String code = "INVALID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Intent parentIntent = getIntent();
        if ((parentIntent != null) && (parentIntent.hasExtra("user")))
        {
            name = parentIntent.getStringExtra("user");
            code = parentIntent.getStringExtra("code");
        }


    }


    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, name + " - " + code, Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
