package com.techpenta.parthaphotography.jsonparsing.ButtonActivities;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;

import android.widget.ImageView;

import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.techpenta.parthaphotography.R;
import com.techpenta.parthaphotography.jsonparsing.Imageloader.ImageLoader;
import com.techpenta.parthaphotography.jsonparsing.Singleitems.SingleItemView;
import com.firebase.client.Firebase;

import java.util.ArrayList;
import java.util.HashMap;

public class ListViewAdapter extends BaseAdapter {

	// Declare Variables
	Context context;
	LayoutInflater inflater;
	ArrayList<HashMap<String, String>> data;
	ImageLoader imageLoader;
	HashMap<String, String> resultp = new HashMap<String, String>();

	Firebase mfirebase;

	boolean animationdone=true;

	public ListViewAdapter(Context context,
						   ArrayList<HashMap<String, String>> arraylist) {
		this.context = context;
		data = arraylist;
		imageLoader = new ImageLoader(context);
	}

	@Override
	public int getCount() {
		return data.size();
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	public View getView(final int position, View convertView, ViewGroup parent) {
		// Declare Variables


		ImageView flag;


		TextView title;
		TextView date;
		TextView multitext;

		inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View itemView = inflater.inflate(R.layout.listview_item, parent, false);

		// Get the position
		resultp = data.get(position);

		// Locate the TextViews in listview_item.xml
	    title = (TextView) itemView.findViewById(R.id.title);
		multitext = (TextView) itemView.findViewById(R.id.multitext);




		RelativeLayout linearLayout=(RelativeLayout) itemView.findViewById(R.id.blog_Relativelayout);

		// Locate the ImageView in listview_item.xml
		flag = (ImageView) itemView.findViewById(R.id.flag);



	if ((position % 2) == 0) {

		Animation animation;
		animation = AnimationUtils.loadAnimation(itemView.getContext(),
				R.anim.move);
		linearLayout.startAnimation(animation);
	} else {

		Animation animation;
		animation = AnimationUtils.loadAnimation(itemView.getContext(),
				R.anim.reverse_move);
		linearLayout.startAnimation(animation);

	}


		// Capture position and set results to the TextViews
		title.setText(resultp.get(Blog_Activity.TITLE));

	multitext.setText(resultp.get(Blog_Activity.MULTITEXT));


	/*	title.setText(resultp.get(Gallery_Activity.TITLE));
		date.setText(resultp.get(Gallery_Activity.DATE));
		multitext.setText(resultp.get(Gallery_Activity.MULTITEXT));*/








		// Capture position and set results to the ImageView
		// Passes flag images URL into ImageLoader.class
		//imageLoader.DisplayImage(resultp.get(Blog_Activity.FLAG), flag1);
		imageLoader.DisplayImage(resultp.get(Blog_Activity.FLAG), flag);
		// Capture ListView item click
		itemView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Get the position
				resultp = data.get(position);
				Intent intent = new Intent(context, SingleItemView.class);
				// Pass all data rank
			/*	intent.putExtra("rank1", resultp.get(Blog_Activity.TITLE));
				Pass all data country
				intent.putExtra("country1", resultp.get(Blog_Activity.COUNTRY));
				// Pass all data population

				// Pass all data flag
				intent.putExtra("flag", resultp.get(Blog_Activity.FLAG));


			//	intent.putExtra("title1", resultp.get(Blog_Activity.TITLE));   */


				intent.putExtra("content", resultp.get(Blog_Activity.CONTENT));


				context.startActivity(intent);

			}
		});
		return itemView;
	}
}
