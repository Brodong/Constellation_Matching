package com.example.homework;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

public class DBService {
	private DBHelper helper;
	public DBService(Context context) {
		this.helper=new DBHelper(context, "table.db", null, 1);
	}
	public void insert(String user,String password,String email){
		String sql = "INSERT INTO people(user,password,email)" +
				"VALUES('"+user+"','"+password+"','"+email+"')";
		SQLiteDatabase db=helper.getWritableDatabase();
		db.execSQL(sql);
	}
	public void delete(String user){
		String sql="delete from people where user='"+user+"'";
		SQLiteDatabase db=helper.getWritableDatabase();
		db.execSQL(sql);
	}
	public Cursor query_byuser(String user){
		SQLiteDatabase db=helper.getReadableDatabase();
		String sql="select * from people where user=?";
		Cursor cursor=db.rawQuery(sql, new String[]{user});
		return cursor;
	}
	public Cursor query_byemail(String email){
		SQLiteDatabase db=helper.getReadableDatabase();
		String sql="select * from people where email=?";
		Cursor cursor=db.rawQuery(sql, new String[]{email});
		return cursor;
	}
	
}
