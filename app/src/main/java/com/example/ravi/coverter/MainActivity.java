package com.example.ravi.coverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Spinner sp1,sp2;
    EditText ed1;
    Button btn;
    String values[];
    TextView t1;
    int pos=0, pos1=0;
    double km =0, m =0, cm=0;
    double feet=0.0, inches=0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t1= (TextView) findViewById(R.id.textView);
        sp1= (Spinner) findViewById(R.id.spinner);
        sp2= (Spinner) findViewById(R.id.spinner2);
        ed1= (EditText) findViewById(R.id.edit);
        btn= (Button) findViewById(R.id.button);
        values=getResources().getStringArray(R.array.data);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,values);
        sp1.setAdapter(adapter);
        sp2.setAdapter(adapter);
        sp1.setPrompt("Select Input Type");
        sp2.setPrompt("Select Output Type");
        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
                pos=position;
            }


            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                pos1=position;

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = ed1.getText().toString();
                int value = Integer.parseInt(s1);
                if(pos==0)
                {
                    String s2 = ed1.getText().toString();
                    km = Double.parseDouble(s2);
                }
                if(pos==1)
                {
                    String s2 = ed1.getText().toString();
                    m = Double.parseDouble(s2);
                }
                if(pos==2)
                {
                    String s2 = ed1.getText().toString();
                    feet = Double.parseDouble(s2);
                }
                if(pos==3)
                {
                    String s2 = ed1.getText().toString();
                    inches = Double.parseDouble(s2);
                }
                if(pos==4)
                {
                    String s2 = ed1.getText().toString();
                    cm = Double.parseDouble(s2);
                }
                if(pos==pos1)
                {
                    String s4=String.valueOf(value);
                    t1.setText(s4);
                }
                if((pos==0) && (pos1==1))
                {
                    m=km*1000;
                    String s4=String.valueOf(m);
                    t1.setText(s4);
                    //Toast.makeText(MainActivity.this, "Value in meter is "+m, Toast.LENGTH_SHORT).show();
                }
                if((pos==0) && (pos1==2))
                {
                    feet=km*3280.8;
                    String s4=String.valueOf(feet);
                    t1.setText(s4);
                    //Toast.makeText(MainActivity.this, "Value in feet is "+feet, Toast.LENGTH_SHORT).show();
                }
                if((pos==0) && (pos1==3))
                {
                    inches=(km*3280.8)*12;
                    String s4=String.valueOf(inches);
                    t1.setText(s4);
                    //Toast.makeText(MainActivity.this, "Value in inches is "+inches, Toast.LENGTH_SHORT).show();
                }
                if((pos==0) && (pos1==4))
                {
                    cm=(km*1000)*100;
                    String s4=String.valueOf(cm);
                    t1.setText(s4);

                    //Toast.makeText(MainActivity.this, "Value in centimeter is "+cm, Toast.LENGTH_SHORT).show();
                }
                if((pos==1) && (pos1==0))
                {
                    km=m/1000;
                    String s4=String.valueOf(km);
                    t1.setText(s4);
                }
                if((pos==1) && (pos1==2))
                {
                    feet=m*3.28;
                    String s4=String.valueOf(feet);
                    t1.setText(s4);
                }
                if((pos==1) && (pos1==3))
                {
                    inches=m*39.37;
                    String s4=String.valueOf(inches);
                    t1.setText(s4);
                }
                if((pos==1) && (pos1==4))
                {
                    cm=m*100;
                    String s4=String.valueOf(cm);
                    t1.setText(s4);
                }
            }
        });
    }
}
