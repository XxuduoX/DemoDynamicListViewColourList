package sg.edu.rp.c346.id20007998.demodynamiclistviewcolourlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText etElement;
    EditText etIndex;
    Button btnAdd;
    Button btnRemove;
    Button btnUpdate;
    ListView lvColor;
    ArrayList<String> alColours;
    ArrayAdapter<String>aaColour;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etElement=findViewById(R.id.editTextColor);
        btnAdd=findViewById(R.id.buttonAddItem);
        etIndex=findViewById(R.id.editTextIndex);
        lvColor=findViewById(R.id.listViewColour);
        btnRemove=findViewById(R.id.buttonRemoveColor);
        btnUpdate=findViewById(R.id.buttonUpdateColor);

        alColours=new ArrayList<>();

        alColours.add("Red");
        alColours.add("Orange");


        aaColour=new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1,alColours);
        lvColor.setAdapter(aaColour);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                int index=Integer.parseInt(etIndex.getText().toString());
                String colour=etElement.getText().toString();
                alColours.add(index,colour);
                aaColour.notifyDataSetChanged();
            }
        });
        btnRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                int index=Integer.parseInt(etIndex.getText().toString());
                alColours.remove(index);
                aaColour.notifyDataSetChanged();
            }
        });
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                int index=Integer.parseInt(etIndex.getText().toString());
                String colour=etElement.getText().toString();
                alColours.set(index,colour);
                aaColour.notifyDataSetChanged();
            }
        });


        lvColor.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String colourPos=alColours.get(position);
                Toast.makeText(MainActivity.this,colourPos,Toast.LENGTH_SHORT).show();
            }
        });

    }
}