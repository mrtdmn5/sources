package com.airbnb.lottie;

import android.graphics.Rect;
import androidx.collection.LongSparseArray;
import androidx.collection.SparseArrayCompat;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.model.FontCharacter;
import com.airbnb.lottie.model.Marker;
import com.airbnb.lottie.model.layer.Layer;
import com.airbnb.lottie.utils.Logger;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public final class LottieComposition {
    public Rect bounds;
    public SparseArrayCompat<FontCharacter> characters;
    public float endFrame;
    public Map<String, Font> fonts;
    public float frameRate;
    public boolean hasDashPattern;
    public Map<String, LottieImageAsset> images;
    public LongSparseArray<Layer> layerMap;
    public List<Layer> layers;
    public List<Marker> markers;
    public Map<String, List<Layer>> precomps;
    public float startFrame;
    public final PerformanceTracker performanceTracker = new PerformanceTracker();
    public final HashSet<String> warnings = new HashSet<>();
    public int maskAndMatteCount = 0;

    public final void addWarning(String str) {
        Logger.warning(str);
        this.warnings.add(str);
    }

    public final float getDuration() {
        return ((this.endFrame - this.startFrame) / this.frameRate) * 1000.0f;
    }

    public final Marker getMarker(String str) {
        int size = this.markers.size();
        for (int r2 = 0; r2 < size; r2++) {
            Marker marker = this.markers.get(r2);
            String str2 = marker.name;
            boolean z = true;
            if (!str2.equalsIgnoreCase(str) && (!str2.endsWith("\r") || !str2.substring(0, str2.length() - 1).equalsIgnoreCase(str))) {
                z = false;
            }
            if (z) {
                return marker;
            }
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("LottieComposition:\n");
        Iterator<Layer> it = this.layers.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString("\t"));
        }
        return sb.toString();
    }
}
