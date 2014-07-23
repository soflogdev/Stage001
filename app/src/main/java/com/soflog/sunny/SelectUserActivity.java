package com.soflog.sunny;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.soflog.sunny.R;

public class SelectUserActivity extends Activity {

    private String[] namesArray;
    private String[] codesArray;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user);


        // File res reading
        namesArray = getResources().getStringArray(R.array.names);
        codesArray = getResources().getStringArray(R.array.codes);

        mTextView = (TextView) findViewById(R.id.textview_helloworld);
    }


    @Override
    protected void onResume() {
        super.onResume();
        StringBuilder text;

        text = new StringBuilder();
        text.append( namesArray[0]);
        text.append( " - "  );
        text.append( codesArray[0]);

        mTextView.setText(text.toString());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.select_user, menu);
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
