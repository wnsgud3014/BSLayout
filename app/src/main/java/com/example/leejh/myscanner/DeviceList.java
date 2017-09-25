package com.example.leejh.myscanner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by SonYoungHoon on 2017-09-23.
 */

public class DeviceList extends Activity {


    ListView listView;

    static boolean isManual = false;
    static String strManual = "";

    protected void onResume() {
        super.onResume();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_list);

        listView = (ListView) this.findViewById(R.id.list_device);

        ArrayList<String> items = new ArrayList<>();

        items.add("Office Drawer");
        items.add("First Baggage");
        items.add("Safe");
        items.add("House Drawer");
        items.add("Second Baggage");

        CustomAdapter adapter = new CustomAdapter(this, 0, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {

                if (!isManual) {
                    Toast.makeText(getApplicationContext(), "Turn on the switch", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(DeviceList.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

        Switch switchAuto = (Switch) findViewById(R.id.switchAuto);

        switchAuto.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked) {
                    isManual = true;
                    strManual = "Manual Mode";
                    buttonView.setText(R.string.switchManual);
                } else {
                    isManual = false;
                    strManual = "Auto Mode";
                    buttonView.setText(R.string.switchAuto);
                }

                Toast.makeText(getApplicationContext(), strManual, Toast.LENGTH_LONG).show();

            }
        });
    }


    private class CustomAdapter extends ArrayAdapter<String> {
        private ArrayList<String> items;

        public CustomAdapter(Context context, int textViewResourceId, ArrayList<String> objects) {
            super(context, textViewResourceId, objects);
            this.items = objects;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            View v = convertView;
            if (v == null) {
                LayoutInflater vi = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                v = vi.inflate(R.layout.item_device, null);
            }

//            ImageView imageView = (ImageView) v.findViewById(R.id.imageView);
//
//            if ("Drawer".equals(items.get(position))) {
//                imageView.setImageResource(R.drawable.officedrawer);
//            } else if ("Baggage".equals(items.get(position))) {
//                imageView.setImageResource(R.drawable.baggage);
//            } else if ("Safe".equals(items.get(position))) {
//                imageView.setImageResource(R.drawable.safe);
//            }
//
//            Button button = (Button)v.findViewById(R.id.buttonDevice);
//            if("Drawer".equals(items.get(position))) {
//                button.setBackgroundResource(R.drawable.officedrawer);
//            } else if("Baggage".equals(items.get(position))) {
//                button.setBackgroundResource(R.drawable.baggage);
//            } else if("Safe".equals(items.get(position))) {
//                button.setBackgroundResource(R.drawable.safe);
//            }

            LinearLayout itemLayout = (LinearLayout)v.findViewById(R.id.itemLayout);

            TextView textView = (TextView) v.findViewById(R.id.textView);
            textView.setText(items.get(position));

            ImageView imageView = (ImageView) v.findViewById(R.id.imageView);


            if("Office Drawer".equals(items.get(position))){
//                textView.setBackgroundColor(getResources().getColor(R.color.colorLightPurple));
                itemLayout.setBackgroundColor(getResources().getColor(R.color.colorLightGreen));
                imageView.setImageResource(R.drawable.drawer_white);
            } else if("House Drawer".equals(items.get(position))) {
                itemLayout.setBackgroundColor(getResources().getColor(R.color.colorSkyBlue));
                imageView.setImageResource(R.drawable.drawer_white);
            } else if("First Baggage".equals(items.get(position))){
//                textView.setBackgroundColor(getResources().getColor(R.color.colorPink));
                itemLayout.setBackgroundColor(getResources().getColor(R.color.colorPink));
                imageView.setImageResource(R.drawable.baggage_white);
            } else if("Second Baggage".equals(items.get(position))) {
                itemLayout.setBackgroundColor(getResources().getColor(R.color.colorOrange));
                imageView.setImageResource(R.drawable.baggage_white);
            } else if("Safe".equals(items.get(position))) {
//                textView.setBackgroundColor(getResources().getColor(R.color.colorOrange));
                itemLayout.setBackgroundColor(getResources().getColor(R.color.colorLightPurple));
                imageView.setImageResource(R.drawable.safe_white);
            }

            final String text = items.get(position);

            return v;
        }
    }
}
