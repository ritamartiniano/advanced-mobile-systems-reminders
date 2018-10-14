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
        mListView = (ListView)findViewById(R.id.reminders_list_view);
        mListView.setDivider(null);
       mDbAdapter = new RemindersAdapter(this);
       mDbAdapter.open();
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
