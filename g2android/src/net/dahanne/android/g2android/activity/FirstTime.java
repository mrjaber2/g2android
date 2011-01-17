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

import net.dahanne.android.g2android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;

/**
 * THIS CLASS WAS COPIED FROM THE GPL project Astrid
 * https://github.com/todoroo/astrid
 * 
 * Displays an EULA ("End User License Agreement") that the user has to accept
 * before using the application. Your application should call
 * {@link Eula#showEula(android.app.Activity)} in the onCreate() method of the
 * first activity. If the user accepts the EULA, it will never be shown again.
 * If the user refuses, {@link android.app.Activity#finish()} is invoked on your
 * activity.
 */
class FirstTime {
	private static final String PREFERENCE_EULA_ACCEPTED = "eula.accepted"; //$NON-NLS-1$
	private static final String PREFERENCES_EULA = "eula"; //$NON-NLS-1$

	/**
	 * Displays the EULA if necessary. This method should be called from the
	 * onCreate() method of your main Activity.
	 * 
	 * @param activity
	 *            The Activity to finish if the user rejects the EULA
	 */
	static void showEula(final Activity activity, boolean isExplicitlyCalled) {
		final SharedPreferences preferences = activity.getSharedPreferences(
				PREFERENCES_EULA, Activity.MODE_PRIVATE);
		if (preferences.getBoolean(PREFERENCE_EULA_ACCEPTED, false)
				&& !isExplicitlyCalled) {
			return;
		}

		final AlertDialog.Builder builder = new AlertDialog.Builder(activity);
		builder.setTitle(R.string.switch_title);
		builder.setCancelable(true);
		builder.setPositiveButton(R.string.download_from_market,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						downloadFromMarket(activity, preferences);
					}
				});
		builder.setNegativeButton(R.string.download_from_project_home,
				new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int which) {
						downloadFromProjectHome(activity, preferences);
					}
				});
		builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
			public void onCancel(DialogInterface dialog) {
				refuse(activity);
			}
		});
		builder.setMessage(R.string.switching_to_regalandroid);
		builder.show();
	}

	private static void downloadFromMarket(Activity activity,
			SharedPreferences preferences) {
		preferences.edit().putBoolean(PREFERENCE_EULA_ACCEPTED, true).commit();
		Intent intent = new Intent(
				Intent.ACTION_VIEW,
				Uri.parse("http://market.android.com/details?id=net.dahanne.android.regalandroid"));
		activity.startActivity(intent);

	}

	private static void downloadFromProjectHome(Activity activity,
			SharedPreferences preferences) {
		preferences.edit().putBoolean(PREFERENCE_EULA_ACCEPTED, true).commit();
		Intent intent = new Intent(
				Intent.ACTION_VIEW,
				Uri.parse("http://code.google.com/p/regalandroid/downloads/list"));
		activity.startActivity(intent);
	}

	private static void refuse(Activity activity) {
		activity.finish();
	}

	private FirstTime() {
		// don't construct me
	}
}
