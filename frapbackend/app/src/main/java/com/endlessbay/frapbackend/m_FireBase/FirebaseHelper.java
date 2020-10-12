package com.endlessbay.frapbackend.m_FireBase;

import com.endlessbay.frapbackend.m_Model.order;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import java.util.ArrayList;
public class FirebaseHelper {

    DatabaseReference db;
    Boolean saved=null;
    ArrayList<String> orders=new ArrayList<>();


    public FirebaseHelper(DatabaseReference db) {
            this.db = db;
        }
        //READ
        public ArrayList<String> retrieve()
        {
            db.addChildEventListener(new ChildEventListener() {
                @Override
                public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                    fetchData(dataSnapshot);
                }

                @Override
                public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                    fetchData(dataSnapshot);

                }

                @Override
                public void onChildRemoved(DataSnapshot dataSnapshot) {

                }

                @Override
                public void onChildMoved(DataSnapshot dataSnapshot, String s) {

                }

                @Override
                public void onCancelled(DatabaseError databaseError) {

                }
            });

            return orders;
        }

        private void fetchData(DataSnapshot dataSnapshot)
        {
            orders.clear();

            for (DataSnapshot ds : dataSnapshot.getChildren())
            {
                String name=ds.getValue(order.class).getName();
                orders.add(name);
            }
        }
    }

