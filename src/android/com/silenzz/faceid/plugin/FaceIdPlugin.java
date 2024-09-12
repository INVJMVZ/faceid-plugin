package com.silenzz.faceid.plugin;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

import android.util.Log;
import android.app.Activity;
import android.app.Application;
import android.content.Context;

import java.util.Date;

import com.silenzz.invfaceid.lib.FaceId;
import com.silenzz.invfaceid.lib.util.DoTask;

public class FaceIdPlugin extends CordovaPlugin {

    private static final String TAG = FaceIdPlugin.class.getSimpleName();

    public static final int REQUEST_CODE = 3388;

    private static final String ACTION_TEST = "test";
    private static final String ACTION_REGISTER = "register";
    private static final String ACTION_RECOGNIZE = "recognize";
    private static final String ACTION_DELETE_ALL = "delete-all";

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);
        Log.d(TAG, "FaceIdPlugin initialize");
    }
    
    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) 
            throws JSONException {
        if (action.equals(ACTION_TEST)) {
            // An example of returning data back to the web layer
            String phrase = args.getString(0);
            // Echo back the first argument      
            final PluginResult result = new PluginResult(PluginResult.Status.OK, "Hola todo el... " + phrase);
            callbackContext.sendPluginResult(result);

            Activity activity = this.cordova.getActivity();
            Context appContext = activity.getBaseContext();
            FaceId.test(activity);
        }
        return true;
    }

}
