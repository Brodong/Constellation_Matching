package com.example.homework;

import com.example.homework.R.color;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

	EditText user;
	EditText passwd;
	Button   login;
	Button   forget_password;
	Button   register;
	DBService dbService;
	String p_name,p_password;
	SharedPreferences mySP;
	SharedPreferences.Editor editor;
    String   TABLE_NAME="mytable";
    
    private MediaPlayer mediaPlayer;
    
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		user=(EditText) findViewById(R.id.editText_user);
		passwd=(EditText) findViewById(R.id.editText_password);
		login=(Button) findViewById(R.id.button_login);
	    forget_password=(Button) findViewById(R.id.button_forgetpassword);
	    register=(Button) findViewById(R.id.button_register);
	    dbService=new DBService(this);
	    
	    mySP=getSharedPreferences(TABLE_NAME, Activity.MODE_PRIVATE);
        editor=mySP.edit();
        user.setText(mySP.getString("user",""));
        passwd.setText(mySP.getString("password", ""));
	    
        
	    login.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				editor.putString("user",user.getText().toString());
				editor.putString("password",passwd.getText().toString());
				editor.commit();
				p_name=user.getText().toString();
				p_password=passwd.getText().toString();
				Cursor cursor=dbService.query_byuser(p_name);
				int flag1=0,flag2=0;
				while(cursor.moveToNext())
				{
					String name=cursor.getString(cursor.getColumnIndex("user"));
					if(name.equals(p_name))
					{
						flag1=1;
						String password=cursor.getString(cursor.getColumnIndex("password"));
						if(p_password.equals(password))
						{
							flag2=1;
							Intent intent =new Intent();
							intent.setClass(MainActivity.this,Star.class);
							startActivity(intent);
							//mediaPlayer= MediaPlayer.create(MainActivity.this,R.raw.testsong);  
							//mediaPlayer.start();
							//mediaPlayer = MediaPlayer.create(MainActivity.this,R.raw.xinzuo);  
							//mediaPlayer.start();  
						}
						else
						{
							flag2=0;
						}
					}
					else
					{
						flag1=0;
					}
				}
				if(flag1==0)
				{
					Toast.makeText(getApplicationContext(), "没有此用户名!",Toast.LENGTH_SHORT).show();
				}
				else if(flag2==0)
				{
					Toast.makeText(getApplicationContext(), "密码不正确!",Toast.LENGTH_SHORT).show();
				}
				
			}
		});
	    
	    forget_password.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, FindPasswd.class);
				startActivity(intent);
			}
		});
	    
	    register.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent=new Intent();
				intent.setClass(MainActivity.this, Register.class);
				startActivity(intent);
			}
		});
	    
	    
	}
}
