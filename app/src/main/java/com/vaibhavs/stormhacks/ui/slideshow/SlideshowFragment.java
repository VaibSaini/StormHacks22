package com.vaibhavs.stormhacks.ui.slideshow;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.vaibhavs.stormhacks.Addcontact;
import com.vaibhavs.stormhacks.MainActivity;
import com.vaibhavs.stormhacks.R;
import com.vaibhavs.stormhacks.RegisterPage;

import java.util.ArrayList;
import java.util.List;

public class SlideshowFragment extends Fragment {

    private List<Contact> Contacts = new ArrayList<Contact>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);
        FloatingActionButton fab = root.findViewById(R.id.floatingActionButton5);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), Addcontact.class);
                startActivity(intent);
            }
        });
        addcontacts();
        popcontacts(root);
        registerClickCallback(root);
        return root;
    }

    private void addcontacts() {
        Contacts.add(new Contact("Contact Name",R.drawable.download_edit,"emailaddress@email.com","+1 000 000 0000"));
        Contacts.add(new Contact("Contact Name",R.drawable.download_edit,"emailaddress@email.com","+1 000 000 0000"));
        Contacts.add(new Contact("Contact Name",R.drawable.download_edit,"emailaddress@email.com","+1 000 000 0000"));
        Contacts.add(new Contact("Contact Name",R.drawable.download_edit,"emailaddress@email.com","+1 000 000 0000"));
        Contacts.add(new Contact("Contact Name",R.drawable.download_edit,"emailaddress@email.com","+1 000 000 0000"));
        Contacts.add(new Contact("Contact Name",R.drawable.download_edit,"emailaddress@email.com","+1 000 000 0000"));
        Contacts.add(new Contact("Contact Name",R.drawable.download_edit,"emailaddress@email.com","+1 000 000 0000"));
        Contacts.add(new Contact("Contact Name",R.drawable.download_edit,"emailaddress@email.com","+1 000 000 0000"));
        Contacts.add(new Contact("Contact Name",R.drawable.download_edit,"emailaddress@email.com","+1 000 000 0000"));
        Contacts.add(new Contact("Contact Name",R.drawable.download_edit,"emailaddress@email.com","+1 000 000 0000"));
    }

    private void registerClickCallback(View v) {
        ListView list = (ListView) v.findViewById(R.id.contact_list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked,
                                    int position, long id) {

                Contact clicked = Contacts.get(position);
                Intent i = Addcontact.makeIntent(getActivity(), clicked.getName(), clicked.getImage(), clicked.getEmail(), clicked.getNumber());
                startActivity(i);
                /*String message = "You clicked position " + position
                        + " Which is car make " + clickedCar.getMake();
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();*/
            }
        });
    }

    private void popcontacts(View v) {
        ArrayAdapter<Contact> adapter = new MyListAdapter();
        ListView list = v.findViewById(R.id.contact_list);
        list.setAdapter(adapter);
    }

    private class MyListAdapter extends ArrayAdapter<Contact> {
        public MyListAdapter() {
            super(getActivity(), R.layout.contact_item, Contacts);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            // Make sure we have a view to work with (may have been given null)
            View itemView = convertView;
            if (itemView == null) {
                itemView = getLayoutInflater().inflate(R.layout.contact_item, parent, false);
            }

            // Find the car to work with.
            Contact ccontact = Contacts.get(position);

            // Fill the view
            ImageView imageView = (ImageView)itemView.findViewById(R.id.contact_img);
            imageView.setImageResource(ccontact.getImage());

            // Make:
            TextView makeText = (TextView) itemView.findViewById(R.id.cname_txt);
            makeText.setText(ccontact.getName());

            // Year:
            TextView yearText = (TextView) itemView.findViewById(R.id.details_txt);
            yearText.setText(ccontact.getEmail() + " | "+ ccontact.getNumber());

            return itemView;
        }
    }
}