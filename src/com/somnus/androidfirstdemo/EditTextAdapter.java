package com.somnus.androidfirstdemo;

import java.util.List;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.somnus.androidfirstdemo.bean.CommentBean;
import com.somnus.androidfirstdemo.view.CommentView;
import com.somnus.androidfirstdemo.view.CommentView.onCommentRatingChangedListener;

public class EditTextAdapter extends BaseAdapter {
	private Context mContext;
	private List<CommentBean> mlist;

	public EditTextAdapter(Context mContext, List<CommentBean> mlist) {
		// TODO Auto-generated constructor stub
		this.mContext = mContext;
		this.mlist = mlist;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		 return mlist == null ? 0 : mlist.size();
//		return 15;
	}

	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return mlist.get(arg0);
	}

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup arg2) {
		// TODO Auto-generated method stub
		final ItemView itemView;
		if (convertView == null) {
			convertView = View.inflate(mContext, R.layout.adapter_edit, null);
			itemView = new ItemView(convertView);
			convertView.setTag(itemView);
		} else {
			itemView = (ItemView) convertView.getTag();
		}
		itemView.setData(mlist.get(position), position);
		return convertView;
	}

	class ItemView {
		public CommentView mCommentView;

		public onCommentRatingChangedListener onCommentRatingChangedListener = new onCommentRatingChangedListener() {

			@Override
			public void onChanged(int position, String comment) {
				// TODO Auto-generated method stub
				mlist.get(position).setComment(comment);
			}
		};

		public ItemView(View v) {
			mCommentView = (CommentView) v.findViewById(R.id.view_comment);
		}

		public void setData(CommentBean msg, int position) {
			mCommentView.setView(msg, position);
			mCommentView.setOnCommentRatingChangedListener(onCommentRatingChangedListener);
		}
	}

}
