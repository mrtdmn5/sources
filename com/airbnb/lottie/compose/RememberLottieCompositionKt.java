package com.airbnb.lottie.compose;

import android.content.ContentResolver;
import android.content.Context;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composer$Companion$Empty$1;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda0;
import com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda2;
import com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda3;
import com.airbnb.lottie.LottieTask;
import com.airbnb.lottie.compose.LottieCompositionSpec;
import com.airbnb.lottie.parser.moshi.JsonReader;
import com.airbnb.lottie.parser.moshi.JsonUtf8Reader;
import com.google.common.collect.Platform;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.concurrent.Callable;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import okio.Okio;
import okio.RealBufferedSource;

/* compiled from: rememberLottieComposition.kt */
/* loaded from: classes.dex */
public final class RememberLottieCompositionKt {
    public static final String access$ensureTrailingSlash(String str) {
        boolean z;
        if (str != null && !StringsKt__StringsJVMKt.isBlank(str)) {
            z = false;
        } else {
            z = true;
        }
        if (z) {
            return null;
        }
        if (!StringsKt__StringsKt.endsWith$default((CharSequence) str, '/')) {
            return str.concat("/");
        }
        return str;
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00ea  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object access$lottieComposition(android.content.Context r14, com.airbnb.lottie.compose.LottieCompositionSpec r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, kotlin.coroutines.Continuation r20) {
        /*
            Method dump skipped, instructions count: 293
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.airbnb.lottie.compose.RememberLottieCompositionKt.access$lottieComposition(android.content.Context, com.airbnb.lottie.compose.LottieCompositionSpec, java.lang.String, java.lang.String, java.lang.String, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final LottieTask<LottieComposition> lottieTask(Context context, LottieCompositionSpec lottieCompositionSpec, final String str, boolean z) {
        if (lottieCompositionSpec instanceof LottieCompositionSpec.RawRes) {
            if (Intrinsics.areEqual(str, "__LottieInternalDefaultCacheKey__")) {
                ((LottieCompositionSpec.RawRes) lottieCompositionSpec).getClass();
                return LottieCompositionFactory.fromRawRes(0, context, LottieCompositionFactory.rawResCacheKey(context, 0));
            }
            ((LottieCompositionSpec.RawRes) lottieCompositionSpec).getClass();
            return LottieCompositionFactory.fromRawRes(0, context, str);
        }
        String str2 = null;
        if (lottieCompositionSpec instanceof LottieCompositionSpec.Url) {
            if (Intrinsics.areEqual(str, "__LottieInternalDefaultCacheKey__")) {
                ((LottieCompositionSpec.Url) lottieCompositionSpec).getClass();
                return LottieCompositionFactory.cache("url_null", new LottieCompositionFactory$$ExternalSyntheticLambda0(context, str2, "url_null"));
            }
            ((LottieCompositionSpec.Url) lottieCompositionSpec).getClass();
            return LottieCompositionFactory.cache(str, new LottieCompositionFactory$$ExternalSyntheticLambda0(context, str2, str));
        }
        if (lottieCompositionSpec instanceof LottieCompositionSpec.File) {
            if (z) {
                return null;
            }
            ((LottieCompositionSpec.File) lottieCompositionSpec).getClass();
            new FileInputStream((String) null);
            StringsKt__StringsJVMKt.endsWith(null, "zip", false);
            throw null;
        }
        if (lottieCompositionSpec instanceof LottieCompositionSpec.Asset) {
            if (Intrinsics.areEqual(str, "__LottieInternalDefaultCacheKey__")) {
                return LottieCompositionFactory.fromAsset(context, ((LottieCompositionSpec.Asset) lottieCompositionSpec).assetName);
            }
            String str3 = ((LottieCompositionSpec.Asset) lottieCompositionSpec).assetName;
            HashMap hashMap = LottieCompositionFactory.taskCache;
            return LottieCompositionFactory.cache(str, new LottieCompositionFactory$$ExternalSyntheticLambda3(context.getApplicationContext(), str3, str));
        }
        if (lottieCompositionSpec instanceof LottieCompositionSpec.JsonString) {
            if (!Intrinsics.areEqual(str, "__LottieInternalDefaultCacheKey__")) {
                ((LottieCompositionSpec.JsonString) lottieCompositionSpec).getClass();
                return LottieCompositionFactory.cache(str, new Callable() { // from class: com.airbnb.lottie.LottieCompositionFactory$$ExternalSyntheticLambda1
                    public final /* synthetic */ String f$0 = null;

                    @Override // java.util.concurrent.Callable
                    public final Object call() {
                        RealBufferedSource buffer = Okio.buffer(Okio.source(new ByteArrayInputStream(this.f$0.getBytes())));
                        String[] strArr = JsonReader.REPLACEMENT_CHARS;
                        return LottieCompositionFactory.fromJsonReaderSyncInternal(new JsonUtf8Reader(buffer), str, true);
                    }
                });
            }
            ((LottieCompositionSpec.JsonString) lottieCompositionSpec).getClass();
            throw null;
        }
        if (lottieCompositionSpec instanceof LottieCompositionSpec.ContentProvider) {
            ContentResolver contentResolver = context.getContentResolver();
            ((LottieCompositionSpec.ContentProvider) lottieCompositionSpec).getClass();
            InputStream openInputStream = contentResolver.openInputStream(null);
            if (!Intrinsics.areEqual(str, "__LottieInternalDefaultCacheKey__")) {
                return LottieCompositionFactory.cache(str, new LottieCompositionFactory$$ExternalSyntheticLambda2(openInputStream, 0, str));
            }
            throw null;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final LottieCompositionResultImpl rememberLottieComposition(LottieCompositionSpec.Asset asset, Composer composer) {
        composer.startReplaceableGroup(1388713460);
        RememberLottieCompositionKt$rememberLottieComposition$1 rememberLottieCompositionKt$rememberLottieComposition$1 = new RememberLottieCompositionKt$rememberLottieComposition$1(null);
        Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.LocalContext);
        composer.startReplaceableGroup(-3686930);
        boolean changed = composer.changed(asset);
        Object rememberedValue = composer.rememberedValue();
        Composer$Companion$Empty$1 composer$Companion$Empty$1 = Composer.Companion.Empty;
        if (changed || rememberedValue == composer$Companion$Empty$1) {
            rememberedValue = Platform.mutableStateOf$default(new LottieCompositionResultImpl());
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        composer.startReplaceableGroup(-3686552);
        boolean changed2 = composer.changed(asset) | composer.changed("__LottieInternalDefaultCacheKey__");
        Object rememberedValue2 = composer.rememberedValue();
        if (changed2 || rememberedValue2 == composer$Companion$Empty$1) {
            composer.updateRememberedValue(lottieTask(context, asset, "__LottieInternalDefaultCacheKey__", true));
        }
        composer.endReplaceableGroup();
        EffectsKt.LaunchedEffect(asset, "__LottieInternalDefaultCacheKey__", new RememberLottieCompositionKt$rememberLottieComposition$3(rememberLottieCompositionKt$rememberLottieComposition$1, context, asset, null, "fonts/", ".ttf", "__LottieInternalDefaultCacheKey__", mutableState, null), composer);
        LottieCompositionResultImpl lottieCompositionResultImpl = (LottieCompositionResultImpl) mutableState.getValue();
        composer.endReplaceableGroup();
        return lottieCompositionResultImpl;
    }
}
