package com.soflog.sunny;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;
import android.widget.TextView;


public class MainActivity extends Activity {

    private PlaceholderFragment mFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {

            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
            mFragment = (PlaceholderFragment) getFragmentManager().findFragmentById(R.id.container);
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        mFragment = (PlaceholderFragment) getFragmentManager().findFragmentById(R.id.container);
        mFragment.addLog("MainActivity > onStart");

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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        private StringBuilder sBuilder ;
        private TextView textviewDebug;

        public void addLog(String s) {
            sBuilder.insert(0, "\n");
            sBuilder.insert(0, s  );
            textviewDebug.setText(sBuilder.toString());
        }

        public PlaceholderFragment() {
        }

        @Override // #Lifecycle #1
        public void onAttach(Activity activity) {
            super.onAttach(activity);

        }

        @Override // Lifecycle #3
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
        {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            textviewDebug = (TextView) rootView.findViewById(R.id.textview_debug);
            addLog("Fragment > onCreateView");
            return rootView;
        }

        @Override  // Lifecycle #4
        public void onActivityCreated(Bundle savedInstanceState) {
            super.onActivityCreated(savedInstanceState);

            addLog("Fragment > onActivityCreated");
        }

        @Override  // Lifecycle #7
        public void onResume() {
            super.onResume();
            addLog("Fragment > onResume");

        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            sBuilder = null;
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            sBuilder = new StringBuilder();
        }


    }
}
