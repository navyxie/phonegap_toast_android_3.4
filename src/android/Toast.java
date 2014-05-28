package com.kalengo.weathermeida.plugins;

import org.apache.cordova.api.CallbackContext;
import org.apache.cordova.api.CordovaInterface;
import org.apache.cordova.api.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.widget.Toast;

import com.kalengo.weathermeida.util.UrlUtil;

/**
 * @author Administrator 吐司提示插件
 */
public class Toast extends CordovaPlugin {
	public static String TOAST = "toast";

	public boolean execute(String action, JSONArray data,
			CallbackContext callbackContext) throws JSONException {
		if (TOAST.equals(action)) {
			UrlUtil.info(TOAST, "message:" + data.getString(0) + ",length:"
					+ data.getInt(1));
			toast(data.getString(0), data.getInt(1), callbackContext);
		}
		return false;
	}

	public synchronized void toast(final String message, final int length,
			CallbackContext callbackContext) {
		final CordovaInterface cordova = this.cordova;
		Runnable runnable = new Runnable() {
			public void run() {
				Toast.makeText(cordova.getActivity(), message, length).show();
			}
		};
		this.cordova.getActivity().runOnUiThread(runnable);

	}
}
