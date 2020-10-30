package com.example.homework;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class Star2 extends Activity {

	private Spinner spinner1,spinner2;
	Button bt1,bt2;
	String []str={"°×Ñò×ù","½ðÅ£×ù","Ë«×Ó×ù","¾ÞÐ·×ù","Ê¨×Ó×ù","´¦Å®×ù","Ìì³Ó×ù","ÉäÊÖ×ù","Ä¦ôÉ×ù","Ë®Æ¿×ù","Ë«Óã×ù"};
	String s1,s2;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_star2);
		spinner1 = (Spinner) findViewById(R.id.list1);
		spinner2 = (Spinner) findViewById(R.id.list2); 
		bt1 = (Button) findViewById(R.id.button1);
		bt2 = (Button) findViewById(R.id.button2);
		ArrayAdapter<String> adapter1=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str);
		spinner1.setAdapter(adapter1);
		
		spinner1.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				s1=parent.getItemAtPosition(position).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		ArrayAdapter<String> adapter2=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, str);
		spinner2.setAdapter(adapter2);
		
		spinner2.setOnItemSelectedListener(new OnItemSelectedListener() {

			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				s2=parent.getItemAtPosition(position).toString();
			}

			@Override
			public void onNothingSelected(AdapterView<?> parent) {
				// TODO Auto-generated method stub
				
			}
		});
		
		bt1.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.putExtra("one",s1);
				intent.putExtra("two",s2);
				intent.setClass(Star2.this,Result.class);
				startActivity(intent);
			}
		});
		bt2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(Star2.this, Star.class);
				startActivity(intent);
			}
		});
	}
}
