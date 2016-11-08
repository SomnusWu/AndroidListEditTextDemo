package com.somnus.androidfirstdemo.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.somnus.androidfirstdemo.R;
import com.somnus.androidfirstdemo.bean.CommentBean;

public class CommentView extends LinearLayout {
	// private RatingView rv2;
	public EditText edit_comment;
	private onCommentRatingChangedListener onCommentRatingChangedListener;
	private int position;

	public onCommentRatingChangedListener getOnCommentRatingChangedListener() {
		return onCommentRatingChangedListener;
	}

	public void setOnCommentRatingChangedListener(
			onCommentRatingChangedListener onCommentRatingChangedListener) {
		this.onCommentRatingChangedListener = onCommentRatingChangedListener;
	}

	public CommentView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		init(context);
	}

	private void init(Context context) {
		LayoutInflater.from(context).inflate(R.layout.layout_comment, this,
				true);
		initView();
	}

	private void initView() {
		// rv1 = (RatingView) findViewById(R.id.rv1);
		// rv2 = (RatingView) findViewById(R.id.rv2);
		edit_comment = (EditText) findViewById(R.id.edit_comment);
		edit_comment.addTextChangedListener(tw);
		// rv1.setLinstener(changeRatingLinstener);
		// rv2.setLinstener(changeRatingLinstener1);

	}

	// public onChangeRatingLinstener changeRatingLinstener = new
	// onChangeRatingLinstener() {
	//
	// @Override
	// public void onChanged(int star, int position) {
	// // TODO Auto-generated method stub
	// // mList.get(position).setStar1(star);
	// star1 = star;
	// if (onCommentRatingChangedListener != null) {
	// onCommentRatingChangedListener.onChanged(position, star1,
	// star2, edit_comment.getText().toString());
	// }
	// }
	// };

	// public void setView(OrderBean info, int position) {
	public void setView(CommentBean info, int position) {

		// star1 = info.getStar1();
		// star2 = info.getStar2();
		// rv1.setStar(info.getStar1());
		// rv2.setStar(info.getStar2());
		this.position = position;
		// edit_comment.setText(info.getComment());
		edit_comment.setText(info.getComment());
		edit_comment.setFocusable(true);
		edit_comment.setFocusableInTouchMode(true);
		// edit_comment.requestFocus();
		// edit_comment.requestFocusFromTouch();
		// rv1.setPosition(position);
		// rv2.setPosition(position);
		// if(info.getDelivery_type() == 1){
		// tv_comment_name.setText("小哥服务满意度：");
		// }else{
		// tv_comment_name.setText("店家服务满意度：");
		// }
	}

	public TextWatcher tw = new TextWatcher() {

		@Override
		public void onTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {
			// TODO Auto-generated method stub

		}

		@Override
		public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
				int arg3) {
			// TODO Auto-generated method stub

		}

		@Override
		public void afterTextChanged(Editable editable) {
			// TODO Auto-generated method stub
			// mList.get(position).setComment(editable.toString());
			if (onCommentRatingChangedListener != null) {
				onCommentRatingChangedListener.onChanged(position, edit_comment
						.getText().toString());
			}
		}
	};

	public interface onCommentRatingChangedListener {
		void onChanged(int position, String comment);
	}

}
