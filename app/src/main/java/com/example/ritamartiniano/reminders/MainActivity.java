package com.example.ritamartiniano.reminders;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.database.Cursor;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView mListView;
    private RemindersAdapter mDbAdapter;
    private RemindersSimpleCursorAdapter mCursorAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.reminders_list_view);
        mListView.setDivider(null);
        mDbAdapter = new RemindersAdapter(this);
        mDbAdapter.open();
        if (savedInstanceState == null) {
            mDbAdapter.deleteAllReminders();
            mDbAdapter.createReminder("Buy learn Android Studio", true);
            mDbAdapter.createReminder("Send Dad Birthday gift", false);
            mDbAdapter.createReminder("Dinner at the Gage on Friday", false);
            mDbAdapter.createReminder("String squash racket", false);
            mDbAdapter.createReminder("Shovel and salt walkways", false);
            mDbAdapter.createReminder("Prepare Advanced Android syllabus", true);
            mDbAdapter.createReminder("Buy new office chair", false);
            mDbAdapter.createReminder("Call Auto-body shop for quote", false);
            mDbAdapter.createReminder("Renew membership to club", false);
            mDbAdapter.createReminder("Buy new Galaxy Android phone", true);
            mDbAdapter.createReminder("Sell old Android phone - auction", false);
            mDbAdapter.createReminder("Buy new paddles for kayaks", false);
            mDbAdapter.createReminder("Call accountant about tax returns", false);
            mDbAdapter.createReminder("Buy 300,000 shares of Google", false);
            mDbAdapter.createReminder("Call the Dalai Lama back", true);

        }

       Cursor cursor = mDbAdapter.fetchAllReminders();
       String[] from = new String[]{
               RemindersAdapter.COL_CONTENT
       };
       int[] to = new int[]{
               R.id.row_text
       };
       mCursorAdapter = new RemindersSimpleCursorAdapter(MainActivity.this,R.layout.reminders_row,cursor,from,to,0);
       mListView.setAdapter(mCursorAdapter);


    }
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_reminders, menu);
        return super.onCreateOptionsMenu(menu);

    }
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch(item.getItemId())
        {
            case R.id.action_new:
                Log.d(getLocalClassName(),"create new Reminder");
                return true;
            case R.id.action_exit:
                finish();
                return true;
            default:
                return false;
        }
    }
}
