package com.amplifyframework.kotlin.geo;

import com.amplifyframework.geo.models.Coordinates;
import com.amplifyframework.geo.models.MapStyle;
import com.amplifyframework.geo.models.MapStyleDescriptor;
import com.amplifyframework.geo.options.GeoSearchByCoordinatesOptions;
import com.amplifyframework.geo.options.GeoSearchByTextOptions;
import com.amplifyframework.geo.options.GetMapStyleDescriptorOptions;
import com.amplifyframework.geo.result.GeoSearchResult;
import java.util.Collection;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Geo.kt */
/* loaded from: classes.dex */
public interface Geo {

    /* compiled from: Geo.kt */
    /* loaded from: classes.dex */
    public static final class DefaultImpls {
        public static /* synthetic */ Object getMapStyleDescriptor$default(Geo geo, GetMapStyleDescriptorOptions getMapStyleDescriptorOptions, Continuation continuation, int r3, Object obj) {
            if (obj == null) {
                if ((r3 & 1) != 0) {
                    getMapStyleDescriptorOptions = GetMapStyleDescriptorOptions.defaults();
                    Intrinsics.checkNotNullExpressionValue(getMapStyleDescriptorOptions, "defaults()");
                }
                return geo.getMapStyleDescriptor(getMapStyleDescriptorOptions, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getMapStyleDescriptor");
        }

        public static /* synthetic */ Object searchByCoordinates$default(Geo geo, Coordinates coordinates, GeoSearchByCoordinatesOptions geoSearchByCoordinatesOptions, Continuation continuation, int r4, Object obj) {
            if (obj == null) {
                if ((r4 & 2) != 0) {
                    geoSearchByCoordinatesOptions = GeoSearchByCoordinatesOptions.defaults();
                    Intrinsics.checkNotNullExpressionValue(geoSearchByCoordinatesOptions, "defaults()");
                }
                return geo.searchByCoordinates(coordinates, geoSearchByCoordinatesOptions, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: searchByCoordinates");
        }

        public static /* synthetic */ Object searchByText$default(Geo geo, String str, GeoSearchByTextOptions geoSearchByTextOptions, Continuation continuation, int r4, Object obj) {
            if (obj == null) {
                if ((r4 & 2) != 0) {
                    geoSearchByTextOptions = GeoSearchByTextOptions.defaults();
                    Intrinsics.checkNotNullExpressionValue(geoSearchByTextOptions, "defaults()");
                }
                return geo.searchByText(str, geoSearchByTextOptions, continuation);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: searchByText");
        }
    }

    Object getAvailableMaps(Continuation<? super Collection<MapStyle>> continuation);

    Object getDefaultMap(Continuation<? super MapStyle> continuation);

    Object getMapStyleDescriptor(GetMapStyleDescriptorOptions getMapStyleDescriptorOptions, Continuation<? super MapStyleDescriptor> continuation);

    Object searchByCoordinates(Coordinates coordinates, GeoSearchByCoordinatesOptions geoSearchByCoordinatesOptions, Continuation<? super GeoSearchResult> continuation);

    Object searchByText(String str, GeoSearchByTextOptions geoSearchByTextOptions, Continuation<? super GeoSearchResult> continuation);
}
