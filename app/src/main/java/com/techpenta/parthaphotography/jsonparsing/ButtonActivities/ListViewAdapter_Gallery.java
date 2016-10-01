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


import com.techpenta.parthaphotography.R;

import com.techpenta.parthaphotography.jsonparsing.Imageloader.ImageLoader;
import com.techpenta.parthaphotography.jsonparsing.Singleitems.SingleItemView_Gallery;

import java.util.ArrayList;
import java.util.HashMap;

public class ListViewAdapter_Gallery extends BaseAdapter {

	// Declare Variables
	Context context;
	LayoutInflater inflater;
	ArrayList<HashMap<String, String>> data;
	ImageLoader imageLoader;
	HashMap<String, String> resultp = new HashMap<String, String>();

	public ListViewAdapter_Gallery(Context context,
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
		View itemView = inflater.inflate(R.layout.galleryitem, parent, false);

		// Get the position
		resultp = data.get(position);


		// Locate the ImageView in listview_item.xml
		flag = (ImageView) itemView.findViewById(R.id.imageViewgallery);
		RelativeLayout gallery_layout=(RelativeLayout) itemView.findViewById(R.id.gallery_Relativelayout);


		if ((position % 2)==0)
		{

			Animation animation;
			animation = AnimationUtils.loadAnimation(itemView.getContext(),
					R.anim.move);
			gallery_layout.startAnimation(animation);

		}


		else {

			Animation animation;
			animation = AnimationUtils.loadAnimation(itemView.getContext(),
					R.anim.reverse_move);
			gallery_layout.startAnimation(animation);

		}



	/*	title.setText(resultp.get(Gallery_Activity.TITLE));
		date.setText(resultp.get(Gallery_Activity.DATE));
		multitext.setText(resultp.get(Gallery_Activity.MULTITEXT));*/








		// Capture position and set results to the ImageView
		// Passes flag images URL into ImageLoader.class
		//imageLoader.DisplayImage(resultp.get(Blog_Activity.FLAG), flag1);
		imageLoader.DisplayImage(resultp.get(Gallery_Activity.FLAG), flag);

		// Capture ListView item click
		itemView.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// Get the position
				resultp = data.get(position);


				Intent intent = new Intent(context,SingleItemView_Gallery.class);
				// Pass all data lifestory
				intent.putExtra("lifestory", resultp.get(Gallery_Activity.LIFESTORY));
				// Pass all data funfacts
				intent.putExtra("funfacts", resultp.get(Gallery_Activity.FUNFACTS));
				// Pass all data habitat
				intent.putExtra("habitat",resultp.get(Gallery_Activity.HABITATE));
				// Pass all data flag
				intent.putExtra("flag",resultp.get(Gallery_Activity.FLAG));
				// Start SingleItemView Class
			//	intent.putExtra("title",resultp.get(Gallery_Activity.TITLE));*/





				context.startActivity(intent);

			}
		});
		return itemView;
	}
}
