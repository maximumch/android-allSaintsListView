package com.example.student1.allsaints;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    // Константы для передачи данных через Intent
    // Должны быть доступны "детальной" Activity
    public static final String SAINT_NAME =    "SAINT_NAME";
    public static final String SAINT_ID =      "SAINT_ID";
    public static final String SAINT_RATING =  "SAINT_RATING";

    public static final int    RATING_REQUEST = 777;

    private ListView list;

    //private List<String> saints = new ArrayList<>();
    private List<Saint> data = new ArrayList<>();

    //private ArrayAdapter<String> adapter;
    private SaintAdapter adapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView) findViewById(R.id.list);

        // Источник данных для парсера XML из ресурсов
        InputSource mySaints = new InputSource(getResources().openRawResource(R.raw.saints));
        // Новый XPath запрос
        XPath xPath = XPathFactory.newInstance().newXPath();
        
        // Подробно об XPath
        // http://www.w3schools.com/xsl/xpath_syntax.asp

        // Собственно запрос 
        String  expression = "/saints/saint";

        NodeList nodes;
        try {
            // Результат XPath запроса - набор узлов
            nodes = (NodeList) xPath.evaluate(expression, mySaints, XPathConstants.NODESET);
            if(nodes != null) {
                int numSaints = nodes.getLength();
                // Для каждого из узлов 
                for (int i = 0; i < numSaints; i++)
                {
                    // Узел
                    Node saint = nodes.item(i);
                    ///

                    String name = saint.getFirstChild().getTextContent();
                    Log.d("happy",name);
                    String dob = saint.getChildNodes().item(1).getTextContent();
                    String dod = saint.getChildNodes().item(2).getTextContent();
                    Saint s = new Saint(name, dob,dod,0f);
                    data.add(s);
                    //saints.add(name);


                }
            }
        }
        catch (Exception e)
        {

        }

//        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, saints);
        adapter = new SaintAdapter(this, 0, data );
        list.setAdapter(adapter);
        list.setOnItemClickListener(this);







    }

    // Вызывается при создании контекстного меню
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        getMenuInflater().inflate(R.menu.context, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    // Вызывается при выборе элемента контекстного меню
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        AdapterView.AdapterContextMenuInfo info =
                (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        ///
        return super.onContextItemSelected(item);
    }


    // Вызывается при создании меню
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        ///

        return super.onCreateOptionsMenu(menu);
    }

    // Вызывается при выборе элемента меню
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId())
        {

            ///
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
        //String name = saints.get(position);
        String name = data.get(position).getName();
        Intent i = new Intent(this, SaintDetail.class);
        i.putExtra(SAINT_NAME, name);
        i.putExtra(SAINT_ID, position);
        startActivity(i);
    }
}
