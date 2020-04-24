/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file
 * except in compliance with the License. You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package co.potatoproject.plugin.oreoqs.tileimpl;

import android.content.Context;
import android.service.quicksettings.Tile;
import android.util.Log;

import com.android.settingslib.Utils;

import com.android.systemui.R;

/**
 * Cool utils class derived from QSTileImpl
 */
public class QSTileUtils {
    public static int getColorForState(Context context, int state) {
        switch (state) {
            case Tile.STATE_UNAVAILABLE:
                return Utils.getDisabled(context,
                        Utils.getColorAttrDefaultColor(context, android.R.attr.colorForeground));
            case Tile.STATE_INACTIVE:
                return Utils.getColorAttrDefaultColor(context, android.R.attr.textColorHint);
            case Tile.STATE_ACTIVE:
                return Utils.getColorAttrDefaultColor(context, android.R.attr.textColorPrimary);
            default:
                Log.e("QSTile", "Invalid state " + state);
                return 0;
        }
    }
}
