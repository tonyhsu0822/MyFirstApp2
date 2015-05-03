package com.mycompany.myfirstapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class MenuFragment extends Fragment {



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
   @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View view = inflater.inflate(R.layout.fragment_menu, container, false);
       Button button = (Button) view.findViewById(R.id.button1) ;

       button.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v)
           {
               Intent intent = new Intent(getActivity(),MyActivity.class) ;
               startActivity(intent);
               getActivity().finish() ;

           }

       } );
       Button button2 = (Button) view.findViewById(R.id.button2) ;
       button2.setOnClickListener(new View.OnClickListener(){
           @Override
           public void onClick(View v)
           {
               Intent intent = new Intent(getActivity(),DisplayMessageActivity.class) ;
               startActivity(intent);
               getActivity().finish() ;

           }

       } );

        return view ;
   }
   /*  public void change_to_input_page(View view){
        Intent intent1 = new Intent() ;
        intent1.setClass(getActivity(),MyActivity.class) ;
        startActivity(intent1);

    } */
}
