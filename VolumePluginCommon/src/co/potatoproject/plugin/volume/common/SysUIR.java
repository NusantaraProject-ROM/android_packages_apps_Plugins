package co.potatoproject.plugin.volume.common;

import android.content.Context;
import android.content.res.Resources;
import android.content.pm.PackageManager.NameNotFoundException;

import java.util.HashMap;

public class SysUIR {
    private Context mContext;
    private HashMap<String, Integer> mCachedIds = new HashMap<String, Integer>();

    public SysUIR(Context context) {
        mContext = context;
    }

    public int color(String resName) {
        return sysuiResId("color", resName);
    }

    public int attr(String resName) {
        return sysuiResId("attr", resName);
    }

    public int id(String resName) {
        return sysuiResId("id", resName);
    }

    public int style(String resName) {
        return style(resName, mContext);
    }

    public int style(String resName, Context context) {
        return sysuiResId("style", resName, context);
    }

    public int drawable(String resName) {
        return sysuiResId("drawable", resName);
    }

    public int bool(String resName) {
        return sysuiResId("bool", resName);
    }

    public int string(String resName) {
        return sysuiResId("string", resName);
    }

    private int sysuiResId(String resType, String resName) {
        return sysuiResId(resType, resName, mContext);
    }
    
    private int sysuiResId(String resType, String resName, Context context) {
        if(mCachedIds.containsKey(resName)) {
            return mCachedIds.get(resName);
        } else {
            int resId = 0;
            try {
                Resources res = context.getPackageManager().getResourcesForApplication("com.android.systemui");
                resId = res.getIdentifier(resName, resType, "com.android.systemui");
            } catch (NameNotFoundException e) {
                e.printStackTrace();
            }

            mCachedIds.put(resName, resId);

            return resId;
        }
    }
}
