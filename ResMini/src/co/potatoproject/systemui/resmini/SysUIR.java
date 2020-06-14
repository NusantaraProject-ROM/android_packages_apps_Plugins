package co.potatoproject.systemui.resmini;

import android.content.Context;
import android.content.res.Resources;
import android.content.pm.PackageManager.NameNotFoundException;

public class SysUIR {
    private Context mContext;

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
        try {
            Resources res = context.getPackageManager().getResourcesForApplication("com.android.systemui");
            return res.getIdentifier(resName, resType, "com.android.systemui");
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
