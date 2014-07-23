package com.soflog.sunny;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.soflog.sunny.R;

import java.util.Random;

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

        for( int i=0; i<= 2 ; i++ )
        {
            text.append(namesArray[i]);
            text.append(" - ");
            text.append(codesArray[i]);
            text.append("\n");
        }
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

    public void selectuser_click(View view) {
        //TODO: démarrer l'activité MainActivity en mettant comme paramètre le nom et le code de l'utilisateur

        int random_index = new Random().nextInt(namesArray.length);
        int index = 1;
        Intent intent = new Intent(this,MainActivity.class);
        intent.putExtra("user", namesArray[index]);
        intent.putExtra("code", codesArray[index]);

        startActivity(intent);
    }
}
