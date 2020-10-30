package com.example.homework;

import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends Activity {

	EditText user;
	EditText password;
	EditText confirm_password;
	EditText email;
	EditText identifying_code;
	Button   send_identifying_code;
	Button   register;
	private String num;
	String  p_user,p_password,p_email;
	DBService dbService;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
		user=(EditText) findViewById(R.id.editText_register_user);
		password=(EditText) findViewById(R.id.editText_register_password);
		confirm_password=(EditText) findViewById(R.id.editText_confirm_password);
		email=(EditText) findViewById(R.id.editText_register_email);
		identifying_code=(EditText) findViewById(R.id.editText_register_identifying_code);
		send_identifying_code=(Button) findViewById(R.id.button_register_send_identifying_code);
		register=(Button) findViewById(R.id.button_register);
		dbService=new DBService(this);
		send_identifying_code.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				num=String.valueOf((int)(Math.random()*10000));
				send_identifying_code.setText(num);
			}
		});
		register.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				if((user.getText().toString().equals("")))
				{
					Toast.makeText(getApplicationContext(), "δ�����û���!",Toast.LENGTH_SHORT).show();
				}
				//ȷ�����������Ƿ�һ��
				if(!(confirm_password.getText().toString().equals(password.getText().toString())))
				{
					Toast.makeText(getApplicationContext(), "�������벻һ����",Toast.LENGTH_SHORT).show();
				}
				else if(email.getText().toString().equals(""))
				{
					Toast.makeText(getApplicationContext(), "����Ϊ�գ�",Toast.LENGTH_SHORT).show();
				}
				//��ʵ��֤���Ƿ���ȷ
				else if(!(identifying_code.getText().toString().equals(num)))
				{
					Toast.makeText(getApplicationContext(), "��֤�벻��ȷ��",Toast.LENGTH_SHORT).show();
				}
				else
				{
					p_user=user.getText().toString();
					p_password=password.getText().toString();
					p_email=email.getText().toString();
					dbService.insert(p_user, p_password, p_email);
					Toast.makeText(getApplicationContext(), "ע��ɹ���������ת�ص�¼���档����",Toast.LENGTH_SHORT).show();
					final Intent intent=new Intent();
					intent.setClass(Register.this, MainActivity.class);
					Timer timer=new Timer();
					TimerTask task=new TimerTask(){
						public void run()
						{
							startActivity(intent);
						}
					};
					timer.schedule(task, 1000*3);
				}
			}
		});
	}
	
}
