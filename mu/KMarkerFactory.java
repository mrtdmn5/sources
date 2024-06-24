package mu;

import java.util.concurrent.ConcurrentHashMap;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.slf4j.helpers.BasicMarker;

/* compiled from: KMarkerFactory.kt */
/* loaded from: classes4.dex */
public final class KMarkerFactory {
    public static Marker getMarker(String str) {
        ConcurrentHashMap concurrentHashMap = MarkerFactory.MARKER_FACTORY.markerMap;
        Marker marker = (Marker) concurrentHashMap.get(str);
        if (marker == null) {
            BasicMarker basicMarker = new BasicMarker(str);
            Marker marker2 = (Marker) concurrentHashMap.putIfAbsent(str, basicMarker);
            if (marker2 != null) {
                return marker2;
            }
            return basicMarker;
        }
        return marker;
    }
}
