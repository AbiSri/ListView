package com.abi.sagar.listview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
    TextView colorText;

    String color_names[] = {"Black", "Brown", "Red", "Orange", "Yellow", "Green", "Blue", "Violet", "Gray", "White"};
    Integer image_id[] = {R.drawable.color_black, R.drawable.color_brown, R.drawable.color_red, R.drawable.color_orange, R.drawable.color_yellow, R.drawable.color_green, R.drawable.color_blue, R.drawable.color_violet, R.drawable.color_grey, R.drawable.color_white};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colorText = (TextView) findViewById(R.id.color_text);

        Customlistadapter adapter = new Customlistadapter(this, image_id, color_names);

        ListView lv = (ListView) findViewById(R.id.listView1);
        lv.setAdapter(adapter);
        lv.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                colorText.setText(color_names[position]);
            }
        });


        /*int height = lv.getHeight();
        int itemHeight = lv.getChildAt(0).getHeight();
        lv.setSelectionFromTop(position, height/2 - itemHeight/2);*/


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}