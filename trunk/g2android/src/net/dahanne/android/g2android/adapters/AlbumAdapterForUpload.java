package net.dahanne.android.g2android.adapters;

import java.util.List;

import net.dahanne.android.g2android.R;
import net.dahanne.android.g2android.model.Album;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AlbumAdapterForUpload extends ArrayAdapter<Album> {

	private final List<Album> items;
	private final Context context;

	public AlbumAdapterForUpload(Context context, int textViewResourceId,
			List<Album> items) {
		super(context, textViewResourceId, items);
		this.items = items;
		this.context = context;

	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View v = convertView;
		if (v == null) {
			LayoutInflater vi = (LayoutInflater) context
					.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
			v = vi.inflate(R.layout.show_albums_for_upload_row, null);
		}
		Album album = items.get(position);
		if (album != null) {
			TextView tt = (TextView) v.findViewById(R.id.first_line);
			if (tt != null) {
				tt.setText(album.getTitle());
			}
		}
		return v;
	}

	@Override
	public View getDropDownView(int position, View convertView, ViewGroup parent) {
		return getView(position, convertView, parent);
	}
}
