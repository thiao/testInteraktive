package com.interaktive.test.mytestinterrative;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.interaktive.test.helper.DialogHelper;
import com.interaktive.test.model.ListeAdapter;
import com.interaktive.test.model.ListeUssAdapter;
import com.interaktive.test.model.OperateurTel;
import com.interaktive.test.model.Usssd;

import java.util.ArrayList;
import java.util.List;

public class UssdActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{
    public static final String[] titles = new String[] { "OrangeSn","Tigo" };
    public static final String[] descriptions = new String[] {"#123#","#167#" };
    ListView listView;
    List<Usssd> rowItems;
    private View dialogri;
    private TextView dilogTitre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ussd);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        dilogTitre = (TextView)findViewById(R.id.titreDialog);
        dialogri = DialogHelper.getInflatedView(UssdActivity.this, R.layout.dialog_dejaincrie);


        rowItems = new ArrayList<Usssd>();
        for (int i = 0; i < titles.length; i++) {
            Usssd item = new Usssd( titles[i], descriptions[i]);
            rowItems.add(item);
        }
        listView = (ListView) findViewById(R.id.ussdlist);
        ListeUssAdapter adapter = new ListeUssAdapter(this, rowItems);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (dialogri.getParent() != null)
            ((ViewGroup) dialogri.getParent()).removeView(dialogri);

        DialogHelper.createCustomDialog(UssdActivity.this, dialogri, "VALIDER", "ANNULER", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialo, int which) {

            }
        }, null).show();

    }
}
