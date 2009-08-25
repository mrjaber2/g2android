/*
 * G2Android
 * Copyright (c) 2009 Anthony Dahanne
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General Public License
 * for more details.
 *
 * You should have received a copy of the GNU General Public License along
 * with this program; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
package net.dahanne.android.g2android.activity;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.dahanne.android.g2android.G2AndroidApplication;
import net.dahanne.android.g2android.R;
import net.dahanne.android.g2android.model.Album;
import net.dahanne.android.g2android.model.G2Picture;
import net.dahanne.android.g2android.utils.AlbumUtils;
import net.dahanne.android.g2android.utils.AsyncTask;
import net.dahanne.android.g2android.utils.G2ConnectionUtils;
import net.dahanne.android.g2android.utils.GalleryConnectionException;
import net.dahanne.android.g2android.utils.ToastExceptionUtils;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ViewSwitcher.ViewFactory;

public class ShowGallery extends Activity implements OnItemSelectedListener,
		ViewFactory {
	private List<G2Picture> albumPictures;
	private static final String TAG = "ShowGallery";
	private ImageSwitcher mSwitcher;
	private Gallery gallery;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.imagegallery);
		gallery = (Gallery) findViewById(R.id.gallery);
		mSwitcher = (ImageSwitcher) findViewById(R.id.switcher);

		mSwitcher.setFactory(this);
		mSwitcher.setInAnimation(AnimationUtils.loadAnimation(this,
				android.R.anim.fade_in));
		mSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this,
				android.R.anim.fade_out));

		int albumName = (Integer) getIntent().getSerializableExtra(
				"g2android.Album");
		Album album = AlbumUtils.findAlbumFromAlbumName(
				((G2AndroidApplication) getApplication()).getRootAlbum(),
				albumName);
		HashMap<String, String> imagesProperties = new HashMap<String, String>(
				0);
		try {
			imagesProperties = G2ConnectionUtils.fetchImages(Settings
					.getGalleryHost(this), Settings.getGalleryPath(this),
					Settings.getGalleryPort(this), album.getName());
		} catch (NumberFormatException e) {
			ToastExceptionUtils.toastNumberFormatException(this, e);
		} catch (GalleryConnectionException e) {
			ToastExceptionUtils.toastGalleryException(this, e);
		}
		albumPictures = new ArrayList<G2Picture>();
		albumPictures.addAll(G2ConnectionUtils
				.extractG2PicturesFromProperties(imagesProperties));

		ImageAdapter adapter = new ImageAdapter(this);
		gallery.setAdapter(adapter);
		gallery.setOnItemSelectedListener(this);

	}

	public class ImageAdapter extends BaseAdapter {
		private Context mContext;
		private Map<Integer, Bitmap> bitmapsCache = new HashMap<Integer, Bitmap>();

		public ImageAdapter(Context c) {
			mContext = c;
		}

		public int getCount() {
			return albumPictures.size();
		}

		public Object getItem(int position) {
			return bitmapsCache.get(position);
		}

		public long getItemId(int position) {
			return albumPictures.get(position).getId();
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			Bitmap downloadImage;
			ImageView i = new ImageView(mContext);
			if (bitmapsCache.get(position) == null) {
				downloadImage = BitmapFactory
						.decodeStream(getInputStreamFromUrl((Settings
								.getBaseUrl(ShowGallery.this) + albumPictures
								.get(position).getThumbName())));
				bitmapsCache.put(position, downloadImage);
			} else {
				downloadImage = bitmapsCache.get(position);
			}

			i.setImageBitmap(downloadImage);
			return i;
		}
	}

	private InputStream getInputStreamFromUrl(String url) {

		// System.out.println("Trying to download " + url);// HttpURLConnection
		// con
		// = null;
		// URL url;
		// InputStream is = null;
		// try {
		// url = new URL(urlTyped2);
		// con = (HttpURLConnection) url.openConnection();
		// con.setReadTimeout(10000 /* milliseconds */);
		// con.setConnectTimeout(15000 /* milliseconds */);
		// con.setRequestMethod("GET");
		// con.setDoInput(true);
		// con.setRequestProperty("user-agent", "G2Android");
		// // Start the query
		// con.connect();
		// is = con.getInputStream();
		// } catch (IOException e) {
		// e.printStackTrace();
		// }
		// return is;
		try {
			return G2ConnectionUtils.getInputStreamFromUrl(url);
		} catch (GalleryConnectionException e) {
			ToastExceptionUtils.toastGalleryException(this, e);
		}
		return null;

	}

	@SuppressWarnings("unchecked")
	@Override
	public void onItemSelected(AdapterView<?> parent, View view, int position,
			long id) {
		String resizedName = albumPictures.get(position).getResizedName();
		String uriString = Settings.getBaseUrl(ShowGallery.this) + resizedName;
		// mSwitcher.setImageDrawable(Drawable.createFromStream(getInputStreamFromUrl(uriString),
		// "name"+position));
		// BitmapDrawable bitmapDrawable = new
		// BitmapDrawable(bitmaps.get(position));
		Bitmap currentThumbBitmap = (Bitmap) gallery
				.getItemAtPosition(position);
		BitmapDrawable bitmapDrawable = new BitmapDrawable(currentThumbBitmap);
		mSwitcher.setImageDrawable(bitmapDrawable);
		new DownloadImageTask().execute(uriString, mSwitcher, position);
	}

	@Override
	public View makeView() {
		ImageView i = new ImageView(this);
		i.setBackgroundColor(0xFF000000);
		i.setScaleType(ImageView.ScaleType.FIT_CENTER);
		i.setLayoutParams(new ImageSwitcher.LayoutParams(
				LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		return i;

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
	}

	private class DownloadImageTask extends AsyncTask {
		private ImageSwitcher imageSwitcher = null;
		private int originalPosition;

		@Override
		protected Bitmap doInBackground(Object... urls) {
			imageSwitcher = (ImageSwitcher) urls[1];
			originalPosition = (Integer) urls[2];
			Bitmap downloadImage = null;
			if (originalPosition == gallery.getSelectedItemPosition()) {
				downloadImage = BitmapFactory
						.decodeStream(getInputStreamFromUrl((String) urls[0]));
				Log.i(TAG, "Downloading image in background "
						+ (String) urls[0]);
			} else {
				Log.i(TAG, "Did not download image in background "
						+ (String) urls[0]);
			}
			return downloadImage;
		}

		@Override
		protected void onPostExecute(Object result) {
			if (result == null) {
				return;
			}
			// we check if the user is still looking at the same photo
			// if not, we don't refresh the main view
			if (originalPosition == gallery.getSelectedItemPosition()) {
				imageSwitcher.setImageDrawable(new BitmapDrawable(
						(Bitmap) result));
			}
		}
	}

	//
	// @Override
	// public void onItemClick(AdapterView<?> parent, View view, int position,
	// long id) {
	// Intent intent = new Intent(this, FullImage.class);
	// intent.putExtra("g2Picture", albumPictures.get(position) );
	// startActivity(intent );
	//
	// }

}
