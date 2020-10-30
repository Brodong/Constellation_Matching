package com.example.homework;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.widget.Toast;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHelper extends SQLiteOpenHelper{
	private final static String DATABASE_NAME="table.db";
	private final static int DATABASE_VERSION=1;

	public DBHelper(Context context, String name, CursorFactory factory, int version) {
		super(context, DATABASE_NAME, factory, DATABASE_VERSION);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE people(" 
	                +"id INTEGER PRIMARY KEY AUTOINCREMENT, "
				    +"user VARCHAR(20)," 
				    +"password VARCHAR(20)," 
				    +"email VARCHAR(20))" ;
		db.execSQL(sql);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}

}

