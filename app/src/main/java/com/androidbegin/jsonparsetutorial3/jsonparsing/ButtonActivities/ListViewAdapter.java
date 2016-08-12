package com.androidbegin.jsonparsetutorial3.jsonparsing.ButtonActivities;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import android.widget.ImageView;
import android.widget.TextView;

import com.androidbegin.jsonparsetutorial3.R;
import com.androidbegin.jsonparsetutorial3.jsonparsing.ButtonActivities.Blog_Activity;
import com.androidbegin.jsonparsetutorial3.jsonparsing.ImageLoader;
import com.androidbegin.jsonparsetutorial3.jsonparsing.SingleItemView;

import java.util.ArrayList;
import java.util.HashMap;

public class ListViewAdapter extends BaseAdapter {

	// Declare Variables
	Context context;
	LayoutInflater inflater;
	ArrayList<HashMap<String, String>> data;
	ImageLoader imageLoader;
	HashMap<String, String> resultp = new HashMap<String, String>();

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
		date = (TextView) itemView.findViewById(R.id.date);
		multitext = (TextView) itemView.findViewById(R.id.multitext);




		// Locate the ImageView in listview_item.xml
		flag = (ImageView) itemView.findViewById(R.id.flag);

		// Capture position and set results to the TextViews
		title.setText(resultp.get(Blog_Activity.TITLE));
		date.setText(resultp.get(Blog_Activity.DATE));
		multitext.setText(resultp.get(Blog_Activity.MULTITEXT));




		// Capture position and set results to the ImageView
		// Passes flag images URL into ImageLoader.class
		imageLoader.DisplayImage(resultp.get(Blog_Activity.FLAG), flag);
		// Capture ListView item click
		itemView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Get the position
				resultp = data.get(position);
				Intent intent = new Intent(context, SingleItemView.class);
				// Pass all data rank
				intent.putExtra("rank", resultp.get(Blog_Activity.RANK));
				// Pass all data country
				intent.putExtra("country", resultp.get(Blog_Activity.COUNTRY));
				// Pass all data population
				intent.putExtra("population",resultp.get(Blog_Activity.POPULATION));
				// Pass all data flag
				intent.putExtra("flag", resultp.get(Blog_Activity.FLAG));
				// Start SingleItemView Class
				intent.putExtra("title", resultp.get(Blog_Activity.TITLE));
				context.startActivity(intent);

			}
		});
		return itemView;
	}
}
