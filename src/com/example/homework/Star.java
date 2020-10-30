package com.example.homework;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Star extends Activity {

	Button star2;
	Button star;
	Button back;
	EditText month1;
	EditText month2;
	EditText day1;
	EditText day2;
	EditText year1;
	EditText year2;
	String s1,s2,s3,s4;
	int [] a={120,219,321,420,521,622,723,823,923,1024,1123,1222};
	int [] b={218,320,419,520,621,722,822,922,1023,1122,1221,119};
    String [] s={"Ë®Æ¿×ù","Ë«Óã×ù","°×Ñò×ù","½ðÅ£×ù","Ë«×Ó×ù","¾ÞÐ·×ù","Ê¨×Ó×ù","´¦Å®×ù","Ìì³Ó×ù","ÌìÐ«×ù","ÉäÊÖ×ù","Ä¦ôÉ×ù"};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_star);
		
		star2=(Button) findViewById(R.id.button_match_bystar);
		star=(Button) findViewById(R.id.button_star);
		back=(Button) findViewById(R.id.button_back);
		month1=(EditText) findViewById(R.id.editText_month1);
		month2=(EditText) findViewById(R.id.editText_month2);
		day1=(EditText) findViewById(R.id.editText_day1);
		day2=(EditText) findViewById(R.id.editText_day2);
		year1=(EditText) findViewById(R.id.editText_year1);
		year2=(EditText) findViewById(R.id.editText_year2);
		
		star2.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(Star.this,Star2.class);
				startActivity(intent);
			}
		});
		
		star.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				
				// TODO Auto-generated method stub
				if(year1.getText().toString().equals("")||year2.getText().toString().equals("")
						||month1.getText().toString().equals("")||month2.getText().toString().equals("")
						||day1.getText().toString().equals("")||day2.getText().toString().equals(""))
				{
					Toast.makeText(getApplicationContext(), "ÐÅÏ¢²»ÍêÕû£¡",Toast.LENGTH_SHORT).show();
				}
				else
				{
					s1=month1.getText().toString()+day1.getText().toString();
				    s2=month2.getText().toString()+day2.getText().toString();
					s3=findstar(Integer.parseInt(s1));
					s4=findstar(Integer.parseInt(s2));
				    Intent intent=new Intent();
				    intent.putExtra("one",s3);
				    intent.putExtra("two",s4);
				    intent.setClass(Star.this, Result.class);
				    startActivity(intent);
				}
				
			}
		});
		
		back.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(Star.this, MainActivity.class);
				startActivity(intent);
			}
		});
	}
	public String findstar(int n)
	{
		for(int i=0;i<12;i++)
		{
			if(n>=a[i]&&n<=b[i])
			{
				return s[i];
			}
			if(n>=a[11])
			{
				return s[11];
			}
			if(n<=b[11])
			{
				return s[11];
			}
		}
		return null;
	}
}
