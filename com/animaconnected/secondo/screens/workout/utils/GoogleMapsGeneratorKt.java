package com.animaconnected.secondo.screens.workout.utils;

import android.content.Context;
import androidx.core.content.ContextCompat;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.watch.fitness.LocationEntry;
import com.animaconnected.widget.ImageLoadingState;
import com.kronaby.watch.app.R;
import io.ktor.client.HttpClient;
import io.ktor.client.HttpClientConfig;
import io.ktor.client.HttpClientJvmKt;
import io.ktor.client.plugins.HttpTimeout;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Dispatchers;

/* compiled from: GoogleMapsGenerator.kt */
/* loaded from: classes3.dex */
public final class GoogleMapsGeneratorKt {
    private static final String BASE_URL = "https://maps.googleapis.com/maps/api/staticmap";
    private static final int MAX_ALLOWED_IMAGE_SIZE = 640;
    private static final String TAG = "GoogleMapsGenerator";
    public static final double circleRadiusMeters = 100.0d;
    private static final Lazy client$delegate = LazyKt__LazyJVMKt.lazy(new Function0<HttpClient>() { // from class: com.animaconnected.secondo.screens.workout.utils.GoogleMapsGeneratorKt$client$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final HttpClient invoke() {
            return HttpClientJvmKt.HttpClient(new Function1<HttpClientConfig<?>, Unit>() { // from class: com.animaconnected.secondo.screens.workout.utils.GoogleMapsGeneratorKt$client$2.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(HttpClientConfig<?> httpClientConfig) {
                    invoke2(httpClientConfig);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(HttpClientConfig<?> HttpClient) {
                    Intrinsics.checkNotNullParameter(HttpClient, "$this$HttpClient");
                    HttpClient.install(HttpTimeout.Plugin, new Function1<HttpTimeout.HttpTimeoutCapabilityConfiguration, Unit>() { // from class: com.animaconnected.secondo.screens.workout.utils.GoogleMapsGeneratorKt.client.2.1.1
                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(HttpTimeout.HttpTimeoutCapabilityConfiguration httpTimeoutCapabilityConfiguration) {
                            invoke2(httpTimeoutCapabilityConfiguration);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(HttpTimeout.HttpTimeoutCapabilityConfiguration install) {
                            Intrinsics.checkNotNullParameter(install, "$this$install");
                            int r0 = Duration.$r8$clinit;
                            install.setRequestTimeoutMillis(Long.valueOf(Duration.m1677getInWholeMillisecondsimpl(DurationKt.toDuration(30, DurationUnit.SECONDS))));
                        }
                    });
                }
            });
        }
    });
    private static final Lazy pathColor$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Integer>() { // from class: com.animaconnected.secondo.screens.workout.utils.GoogleMapsGeneratorKt$pathColor$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final Integer invoke() {
            Context context = KronabyApplication.Companion.getContext();
            Object obj = ContextCompat.sLock;
            return Integer.valueOf(ContextCompat.Api23Impl.getColor(context, R.color.paletteLimeGreen));
        }
    });
    public static final int pathLineWeight = 7;
    public static final int zoomLevelFixedLocation = 16;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:15:0x00c8 A[Catch: Exception -> 0x00fc, TryCatch #0 {Exception -> 0x00fc, blocks: (B:13:0x0037, B:15:0x00c8, B:17:0x00d2, B:21:0x00f4, B:22:0x00fb, B:26:0x0048, B:27:0x009c, B:31:0x004c, B:32:0x0074, B:37:0x0053), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00f4 A[Catch: Exception -> 0x00fc, TryCatch #0 {Exception -> 0x00fc, blocks: (B:13:0x0037, B:15:0x00c8, B:17:0x00d2, B:21:0x00f4, B:22:0x00fb, B:26:0x0048, B:27:0x009c, B:31:0x004c, B:32:0x0074, B:37:0x0053), top: B:7:0x0027 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bf A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0096 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0029  */
    /* renamed from: downloadMapImage-CNmA0Ec, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object m1032downloadMapImageCNmA0Ec(long r19, java.util.List<com.animaconnected.watch.fitness.LocationEntry> r21, long r22, int r24, int r25, kotlin.coroutines.Continuation<? super kotlin.Result<android.graphics.Bitmap>> r26) {
        /*
            Method dump skipped, instructions count: 258
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.screens.workout.utils.GoogleMapsGeneratorKt.m1032downloadMapImageCNmA0Ec(long, java.util.List, long, int, int, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: generateMapImage-o3gnWtI, reason: not valid java name */
    public static final Object m1033generateMapImageo3gnWtI(long j, long j2, List<LocationEntry> list, long j3, int r19, Continuation<? super ImageLoadingState> continuation) {
        return BuildersKt.withContext(Dispatchers.IO, new GoogleMapsGeneratorKt$generateMapImage$2(list, j3, j, j2, r19, null), continuation);
    }

    /* renamed from: generateMapImage-o3gnWtI$default, reason: not valid java name */
    public static /* synthetic */ Object m1034generateMapImageo3gnWtI$default(long j, long j2, List list, long j3, int r17, Continuation continuation, int r19, Object obj) {
        int r8;
        if ((r19 & 16) != 0) {
            r8 = R.raw.style_map_dark_no_street_names;
        } else {
            r8 = r17;
        }
        return m1033generateMapImageo3gnWtI(j, j2, list, j3, r8, continuation);
    }

    private static final HttpClient getClient() {
        return (HttpClient) client$delegate.getValue();
    }

    public static final int getPathColor() {
        return ((Number) pathColor$delegate.getValue()).intValue();
    }
}
