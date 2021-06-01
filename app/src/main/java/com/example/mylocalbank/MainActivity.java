package com.example.mylocalbank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    MenuItem website;
    MenuItem contact;
    MenuItem favourite;

    Button ocbc;
    Button dbs;
    Button uob;
    String selected = "";
    String language = "english";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ocbc = findViewById(R.id.btnOCBC);
        dbs = findViewById(R.id.btnDBS);
        uob = findViewById(R.id.btnUOB);

        registerForContextMenu(ocbc);
        registerForContextMenu(dbs);
        registerForContextMenu(uob);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        if(v==dbs){
            selected = "dbs";
        }else if(v==ocbc){
            selected = "ocbc";
        }else if(v==uob){
            selected = "uob";
        }
        getMenuInflater().inflate(R.menu.action_menu,menu);
        website = menu.getItem(0);
        contact = menu.getItem(1);
        favourite = menu.getItem(2);
        if(language.equalsIgnoreCase("english")){
            website.setTitle(getString(R.string.website));
            contact.setTitle(getString(R.string.contact_the_bank));
            favourite.setTitle(getString(R.string.toggle_favourite));
        }else if(language.equalsIgnoreCase("chinese")){
            website.setTitle(getString(R.string.websitechinese));
            contact.setTitle(getString(R.string.contact_the_bankchinese));
            favourite.setTitle(getString(R.string.toggle_favouritechinese));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.english){
            ocbc.setText(R.string.ocbc);
            dbs.setText(R.string.dbs);
            uob.setText(R.string.uob);
            language = "english";
            return true;

        }else if(item.getItemId()==R.id.chinese){
            ocbc.setText(R.string.chineseOCBC);
            dbs.setText(R.string.chineseDBS);
            uob.setText(R.string.chineseUOB);
            language = "chinese";
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if(item.getItemId() == R.id.website){
            if(selected.equalsIgnoreCase("dbs")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.dbsweb)));
                startActivity(intent);
                return true;
            }else if(selected.equalsIgnoreCase("ocbc")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.ocbcweb)));
                startActivity(intent);
                return true;
            }else if(selected.equalsIgnoreCase("uob")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(R.string.uobweb)));
                startActivity(intent);
                return true;
            }
        }else if(item.getItemId()==R.id.contact){
            if(selected.equalsIgnoreCase("dbs")) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.dbsno)));
                startActivity(intent);
                return true;
            }else if(selected.equalsIgnoreCase("ocbc")) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.ocbcno)));
                startActivity(intent);
                return true;
            }else if(selected.equalsIgnoreCase("uob")) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+getString(R.string.uobno)));
                startActivity(intent);
                return true;
            }
        }else if(item.getItemId()==R.id.favourite){
            if(selected.equalsIgnoreCase("dbs")) {
                if(dbs.getCurrentTextColor()==getResources().getColor(R.color.red)) {
                    dbs.setTextColor(getResources().getColor(R.color.black));
                    return true;
                }else if(dbs.getCurrentTextColor()==getResources().getColor(R.color.black)){
                    dbs.setTextColor(getResources().getColor(R.color.red));
                    return true;
                }
            }else if(selected.equalsIgnoreCase("ocbc")) {
                if(ocbc.getCurrentTextColor()==getResources().getColor(R.color.red)) {
                    ocbc.setTextColor(getResources().getColor(R.color.black));
                    return true;
                }else if(ocbc.getCurrentTextColor()==getResources().getColor(R.color.black)){
                    ocbc.setTextColor(getResources().getColor(R.color.red));
                    return true;
                }
            }else if(selected.equalsIgnoreCase("uob")) {
                if(uob.getCurrentTextColor()==getResources().getColor(R.color.red)) {
                    uob.setTextColor(getResources().getColor(R.color.black));
                    return true;
                }else if(uob.getCurrentTextColor()==getResources().getColor(R.color.black)){
                    uob.setTextColor(getResources().getColor(R.color.red));
                    return true;
                }
            }
        }
        return super.onContextItemSelected(item);
    }
}