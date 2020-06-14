package co.potatoproject.systemui.resmini;

import android.content.Context;
import android.content.res.Resources;
import android.content.pm.PackageManager.NameNotFoundException;

public class SysUIR {
    private static Context mContext;

    public static void setContext(Context context) {
        mContext = context;
    }

    public static int color(String resName) {
        return sysuiResId("color", resName);
    }

    public static int attr(String resName) {
        return sysuiResId("attr", resName);
    }

    public static int id(String resName) {
        return sysuiResId("id", resName);
    }

    public static int style(String resName, Context context) {
        setContext(context);
        return style(resName);
    }

    public static int style(String resName) {
        return sysuiResId("style", resName);
    }

    public static int drawable(String resName) {
        return sysuiResId("drawable", resName);
    }

    public static int bool(String resName) {
        return sysuiResId("bool", resName);
    }

    public static int string(String resName) {
        return sysuiResId("string", resName);
    }
    
    private static int sysuiResId(String resType, String resName) {
        try {
            Resources res = mContext.getPackageManager().getResourcesForApplication("com.android.systemui");
            return res.getIdentifier(resName, resType, "com.android.systemui");
        }
        catch (NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }
}
