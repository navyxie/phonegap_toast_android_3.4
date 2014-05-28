package org.kalengo.toast;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.widget.Toast;


/**
 * @author Administrator 吐司提示插件
 */
public class ToastPlugin extends CordovaPlugin {
	public static String TOAST = "toast";

	public boolean execute(String action, JSONArray data,
			CallbackContext callbackContext) throws JSONException {
		if (TOAST.equals(action)) {
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
