package com.example.leejh.myscanner;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by SonYoungHoon on 2017-09-23.
 */

public class DeviceList extends Activity {

    ListView listView;

    protected void onResume() {
        super.onResume();
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_list);

        listView = (ListView) this.findViewById(R.id.list_device);

        ArrayList<String> items = new ArrayList<>();

        items.add("Drawer");
        items.add("Baggage");
        items.add("Safe");

        CustomAdapter adapter = new CustomAdapter(this, 0, items);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Intent intent = new Intent(DeviceList.this, MainActivity.class);
                startActivity(intent);
//                finish();
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

            ImageView imageView = (ImageView) v.findViewById(R.id.imageView);

            if ("Drawer".equals(items.get(position))) {
                imageView.setImageResource(R.drawable.officedrawer);
            } else if ("Baggage".equals(items.get(position))) {
                imageView.setImageResource(R.drawable.baggage);
            } else if ("Safe".equals(items.get(position))) {
                imageView.setImageResource(R.drawable.safe);
            }
//
//            Button button = (Button)v.findViewById(R.id.buttonDevice);
//            if("Drawer".equals(items.get(position))) {
//                button.setBackgroundResource(R.drawable.officedrawer);
//            } else if("Baggage".equals(items.get(position))) {
//                button.setBackgroundResource(R.drawable.baggage);
//            } else if("Safe".equals(items.get(position))) {
//                button.setBackgroundResource(R.drawable.safe);
//            }

            TextView textView = (TextView) v.findViewById(R.id.textView);
            textView.setText(items.get(position));

            final String text = items.get(position);

            return v;
        }
    }
}
