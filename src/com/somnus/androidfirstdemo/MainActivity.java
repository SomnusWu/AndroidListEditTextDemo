package com.somnus.androidfirstdemo;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

import com.somnus.androidfirstdemo.bean.CommentBean;

public class MainActivity extends Activity {
	private EditTextAdapter mEditTextAdapter;
	private ListView mListView;
	private List<CommentBean> mlist;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mlist = new ArrayList<CommentBean>();
		mEditTextAdapter = new EditTextAdapter(this, mlist);
		mListView = (ListView) findViewById(R.id.list_view);

		for (int i = 0; i < 15; i++) {
			CommentBean bean = new CommentBean();
			mlist.add(bean);
		}
		mListView.setAdapter(mEditTextAdapter);

		mListView.setOnScrollListener(new OnScrollListener() {

			@Override
			public void onScrollStateChanged(AbsListView arg0, int arg1) {
				// TODO Auto-generated method stub
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				if (imm != null) {
					imm.hideSoftInputFromWindow(getWindow().getDecorView()
							.getWindowToken(), 0);
				}
			}

			@Override
			public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {
				// TODO Auto-generated method stub

			}
		});
	}

}
