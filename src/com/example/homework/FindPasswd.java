package com.example.homework;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FindPasswd extends Activity {

	EditText email;
	Button   find;
	TextView text;
	DBService dbService;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_find_passwd);
		email=(EditText) findViewById(R.id.editText_find_email);
		find=(Button) findViewById(R.id.find_database);
		text=(TextView) findViewById(R.id.show_answer);
		dbService=new DBService(this);
		
		find.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String myemail=email.getText().toString();
				Cursor cursor=dbService.query_byemail(myemail);
				int flag=0;
				while(cursor.moveToNext())
				{
					String p_email=cursor.getString(cursor.getColumnIndex("email"));
					if(p_email.equals(myemail))
					{
						flag=1;
						String s1="查找成功！"+"\n"+"用户名:"+cursor.getString(cursor.getColumnIndex("user"));
						String s2=s1+"\n"+"密码："+cursor.getString(cursor.getColumnIndex("password"));
						text.setText(s2);
					}
					else
					{
						flag=0;
					}
				}
				if(flag==0)
				{
					text.setText("未找到此邮箱！");
				}
			}
		});
	}
}
