package com.mycompany.myfirstapp;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MenuFragment2 extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu_fragment2, container, false);
        Button button = (Button) v.findViewById(R.id.button1) ;
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(),MyActivity.class) ;
                startActivity(intent);
                getActivity().finish() ;

            }

        } );
        Button button2 = (Button) v.findViewById(R.id.button2) ;
        button2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(getActivity(),DisplayMessageActivity.class) ;
                startActivity(intent);
                getActivity().finish() ;

            }

        } );
        return v;
    }

}