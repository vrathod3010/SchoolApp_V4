package com.example.rathods.schoolapp_v4;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.rathods.schoolapp_v4.R;
import com.example.rathods.schoolapp_v4.User.Models.ModelNews;
import com.example.rathods.schoolapp_v4.utility.WebConfig;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class showNews extends AppCompatActivity {


    String TAG = getClass().getSimpleName();
   TextView tv_title,tv_date,tv_readmore,tv_hotnews,tv_news;
    private ProgressDialog progressDialog;

    //EDIT
    private ModelNews modelNews;
    private boolean isEditMode = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_news);
        if (getIntent().getExtras() != null) {
            modelNews = (ModelNews) getIntent().getSerializableExtra("newsModel");
            isEditMode = true;
        }

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("News");



        // add back arrow to toolbar
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }


        tv_date = (TextView) findViewById(R.id.tv_date);
        tv_hotnews = (TextView) findViewById(R.id.tv_hotnews);
        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_readmore = (TextView) findViewById(R.id.tv_readmore);
        tv_news = (TextView) findViewById(R.id.tv_news);

        tv_date.setText(modelNews.getSdate());

        tv_title.setText(modelNews.getTitle());
        tv_readmore.setText(modelNews.getReadmoreurl());
        tv_news.setText(modelNews.getNews());

        if (modelNews.getHotnews().equalsIgnoreCase("1")) {
            tv_hotnews.setText("Yes");
        } else {
            tv_hotnews.setText("No");
        }











}
    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
