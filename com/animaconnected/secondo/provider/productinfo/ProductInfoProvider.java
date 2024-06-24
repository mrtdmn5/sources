package com.animaconnected.secondo.provider.productinfo;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import com.animaconnected.future.Future;
import com.animaconnected.future.FutureCoroutineKt;
import com.animaconnected.secondo.KronabyApplication;
import com.animaconnected.secondo.provider.productinfo.watchimage.WatchImageStorage;
import com.animaconnected.secondo.provider.productinfo.watchimage.WatchImageType;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.EmptyMap;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.enums.EnumEntries;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.internal.MainDispatcherLoader;
import kotlinx.coroutines.scheduling.DefaultScheduler;

/* compiled from: ProductInfoProvider.kt */
@SuppressLint({"StaticFieldLeak"})
/* loaded from: classes3.dex */
public final class ProductInfoProvider {
    public static final int $stable;
    public static final ProductInfoProvider INSTANCE = new ProductInfoProvider();
    private static final String TAG = "ProductInfoProvider";
    private static final Context context;
    private static final ProductInfoStorage dataStorage;
    private static final WatchImageStorage imageStorage;
    private static AtomicBoolean isUpdatingProductInfo;

    static {
        Context context2 = KronabyApplication.Companion.getContext();
        context = context2;
        dataStorage = new ProductInfoStorage(context2);
        imageStorage = new WatchImageStorage(context2);
        isUpdatingProductInfo = new AtomicBoolean(false);
        $stable = 8;
    }

    private ProductInfoProvider() {
    }

    public static final void clearCurrentSku() {
        dataStorage.setCurrentSku(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object download(String str, Continuation<? super Bitmap> continuation) {
        return BuildersKt.withContext(Dispatchers.IO, new ProductInfoProvider$download$2(str, null), continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Failed to find 'out' block for switch in B:8:0x0028. Please report as an issue. */
    /* JADX WARN: Removed duplicated region for block: B:102:0x01b7  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x015e A[Catch: Exception -> 0x034e, TryCatch #0 {Exception -> 0x034e, blocks: (B:13:0x0043, B:15:0x02e1, B:17:0x02e7, B:23:0x0316, B:26:0x0326, B:29:0x033c, B:31:0x005e, B:33:0x028e, B:34:0x029a, B:35:0x02b2, B:37:0x02b8, B:42:0x02c9, B:48:0x02d5, B:50:0x007e, B:52:0x0252, B:53:0x0265, B:55:0x0274, B:61:0x009e, B:63:0x021a, B:64:0x0227, B:66:0x0236, B:72:0x00be, B:74:0x01e6, B:75:0x01ec, B:77:0x01fb, B:83:0x00de, B:85:0x01af, B:86:0x01bc, B:88:0x01cb, B:94:0x00fe, B:95:0x0177, B:96:0x0183, B:98:0x0192, B:104:0x0119, B:105:0x0145, B:106:0x014f, B:108:0x015e, B:114:0x0120, B:116:0x012a), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:112:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:17:0x02e7 A[Catch: Exception -> 0x034e, TryCatch #0 {Exception -> 0x034e, blocks: (B:13:0x0043, B:15:0x02e1, B:17:0x02e7, B:23:0x0316, B:26:0x0326, B:29:0x033c, B:31:0x005e, B:33:0x028e, B:34:0x029a, B:35:0x02b2, B:37:0x02b8, B:42:0x02c9, B:48:0x02d5, B:50:0x007e, B:52:0x0252, B:53:0x0265, B:55:0x0274, B:61:0x009e, B:63:0x021a, B:64:0x0227, B:66:0x0236, B:72:0x00be, B:74:0x01e6, B:75:0x01ec, B:77:0x01fb, B:83:0x00de, B:85:0x01af, B:86:0x01bc, B:88:0x01cb, B:94:0x00fe, B:95:0x0177, B:96:0x0183, B:98:0x0192, B:104:0x0119, B:105:0x0145, B:106:0x014f, B:108:0x015e, B:114:0x0120, B:116:0x012a), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0326 A[Catch: Exception -> 0x034e, TRY_ENTER, TryCatch #0 {Exception -> 0x034e, blocks: (B:13:0x0043, B:15:0x02e1, B:17:0x02e7, B:23:0x0316, B:26:0x0326, B:29:0x033c, B:31:0x005e, B:33:0x028e, B:34:0x029a, B:35:0x02b2, B:37:0x02b8, B:42:0x02c9, B:48:0x02d5, B:50:0x007e, B:52:0x0252, B:53:0x0265, B:55:0x0274, B:61:0x009e, B:63:0x021a, B:64:0x0227, B:66:0x0236, B:72:0x00be, B:74:0x01e6, B:75:0x01ec, B:77:0x01fb, B:83:0x00de, B:85:0x01af, B:86:0x01bc, B:88:0x01cb, B:94:0x00fe, B:95:0x0177, B:96:0x0183, B:98:0x0192, B:104:0x0119, B:105:0x0145, B:106:0x014f, B:108:0x015e, B:114:0x0120, B:116:0x012a), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:29:0x033c A[Catch: Exception -> 0x034e, TRY_LEAVE, TryCatch #0 {Exception -> 0x034e, blocks: (B:13:0x0043, B:15:0x02e1, B:17:0x02e7, B:23:0x0316, B:26:0x0326, B:29:0x033c, B:31:0x005e, B:33:0x028e, B:34:0x029a, B:35:0x02b2, B:37:0x02b8, B:42:0x02c9, B:48:0x02d5, B:50:0x007e, B:52:0x0252, B:53:0x0265, B:55:0x0274, B:61:0x009e, B:63:0x021a, B:64:0x0227, B:66:0x0236, B:72:0x00be, B:74:0x01e6, B:75:0x01ec, B:77:0x01fb, B:83:0x00de, B:85:0x01af, B:86:0x01bc, B:88:0x01cb, B:94:0x00fe, B:95:0x0177, B:96:0x0183, B:98:0x0192, B:104:0x0119, B:105:0x0145, B:106:0x014f, B:108:0x015e, B:114:0x0120, B:116:0x012a), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x02b8 A[Catch: Exception -> 0x034e, TryCatch #0 {Exception -> 0x034e, blocks: (B:13:0x0043, B:15:0x02e1, B:17:0x02e7, B:23:0x0316, B:26:0x0326, B:29:0x033c, B:31:0x005e, B:33:0x028e, B:34:0x029a, B:35:0x02b2, B:37:0x02b8, B:42:0x02c9, B:48:0x02d5, B:50:0x007e, B:52:0x0252, B:53:0x0265, B:55:0x0274, B:61:0x009e, B:63:0x021a, B:64:0x0227, B:66:0x0236, B:72:0x00be, B:74:0x01e6, B:75:0x01ec, B:77:0x01fb, B:83:0x00de, B:85:0x01af, B:86:0x01bc, B:88:0x01cb, B:94:0x00fe, B:95:0x0177, B:96:0x0183, B:98:0x0192, B:104:0x0119, B:105:0x0145, B:106:0x014f, B:108:0x015e, B:114:0x0120, B:116:0x012a), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x0274 A[Catch: Exception -> 0x034e, TryCatch #0 {Exception -> 0x034e, blocks: (B:13:0x0043, B:15:0x02e1, B:17:0x02e7, B:23:0x0316, B:26:0x0326, B:29:0x033c, B:31:0x005e, B:33:0x028e, B:34:0x029a, B:35:0x02b2, B:37:0x02b8, B:42:0x02c9, B:48:0x02d5, B:50:0x007e, B:52:0x0252, B:53:0x0265, B:55:0x0274, B:61:0x009e, B:63:0x021a, B:64:0x0227, B:66:0x0236, B:72:0x00be, B:74:0x01e6, B:75:0x01ec, B:77:0x01fb, B:83:0x00de, B:85:0x01af, B:86:0x01bc, B:88:0x01cb, B:94:0x00fe, B:95:0x0177, B:96:0x0183, B:98:0x0192, B:104:0x0119, B:105:0x0145, B:106:0x014f, B:108:0x015e, B:114:0x0120, B:116:0x012a), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0236 A[Catch: Exception -> 0x034e, TryCatch #0 {Exception -> 0x034e, blocks: (B:13:0x0043, B:15:0x02e1, B:17:0x02e7, B:23:0x0316, B:26:0x0326, B:29:0x033c, B:31:0x005e, B:33:0x028e, B:34:0x029a, B:35:0x02b2, B:37:0x02b8, B:42:0x02c9, B:48:0x02d5, B:50:0x007e, B:52:0x0252, B:53:0x0265, B:55:0x0274, B:61:0x009e, B:63:0x021a, B:64:0x0227, B:66:0x0236, B:72:0x00be, B:74:0x01e6, B:75:0x01ec, B:77:0x01fb, B:83:0x00de, B:85:0x01af, B:86:0x01bc, B:88:0x01cb, B:94:0x00fe, B:95:0x0177, B:96:0x0183, B:98:0x0192, B:104:0x0119, B:105:0x0145, B:106:0x014f, B:108:0x015e, B:114:0x0120, B:116:0x012a), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0260  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x01fb A[Catch: Exception -> 0x034e, TryCatch #0 {Exception -> 0x034e, blocks: (B:13:0x0043, B:15:0x02e1, B:17:0x02e7, B:23:0x0316, B:26:0x0326, B:29:0x033c, B:31:0x005e, B:33:0x028e, B:34:0x029a, B:35:0x02b2, B:37:0x02b8, B:42:0x02c9, B:48:0x02d5, B:50:0x007e, B:52:0x0252, B:53:0x0265, B:55:0x0274, B:61:0x009e, B:63:0x021a, B:64:0x0227, B:66:0x0236, B:72:0x00be, B:74:0x01e6, B:75:0x01ec, B:77:0x01fb, B:83:0x00de, B:85:0x01af, B:86:0x01bc, B:88:0x01cb, B:94:0x00fe, B:95:0x0177, B:96:0x0183, B:98:0x0192, B:104:0x0119, B:105:0x0145, B:106:0x014f, B:108:0x015e, B:114:0x0120, B:116:0x012a), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01cb A[Catch: Exception -> 0x034e, TryCatch #0 {Exception -> 0x034e, blocks: (B:13:0x0043, B:15:0x02e1, B:17:0x02e7, B:23:0x0316, B:26:0x0326, B:29:0x033c, B:31:0x005e, B:33:0x028e, B:34:0x029a, B:35:0x02b2, B:37:0x02b8, B:42:0x02c9, B:48:0x02d5, B:50:0x007e, B:52:0x0252, B:53:0x0265, B:55:0x0274, B:61:0x009e, B:63:0x021a, B:64:0x0227, B:66:0x0236, B:72:0x00be, B:74:0x01e6, B:75:0x01ec, B:77:0x01fb, B:83:0x00de, B:85:0x01af, B:86:0x01bc, B:88:0x01cb, B:94:0x00fe, B:95:0x0177, B:96:0x0183, B:98:0x0192, B:104:0x0119, B:105:0x0145, B:106:0x014f, B:108:0x015e, B:114:0x0120, B:116:0x012a), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0192 A[Catch: Exception -> 0x034e, TryCatch #0 {Exception -> 0x034e, blocks: (B:13:0x0043, B:15:0x02e1, B:17:0x02e7, B:23:0x0316, B:26:0x0326, B:29:0x033c, B:31:0x005e, B:33:0x028e, B:34:0x029a, B:35:0x02b2, B:37:0x02b8, B:42:0x02c9, B:48:0x02d5, B:50:0x007e, B:52:0x0252, B:53:0x0265, B:55:0x0274, B:61:0x009e, B:63:0x021a, B:64:0x0227, B:66:0x0236, B:72:0x00be, B:74:0x01e6, B:75:0x01ec, B:77:0x01fb, B:83:0x00de, B:85:0x01af, B:86:0x01bc, B:88:0x01cb, B:94:0x00fe, B:95:0x0177, B:96:0x0183, B:98:0x0192, B:104:0x0119, B:105:0x0145, B:106:0x014f, B:108:0x015e, B:114:0x0120, B:116:0x012a), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object downloadImages(com.animaconnected.secondo.provider.productinfo.ProductInfoData r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            Method dump skipped, instructions count: 876
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.productinfo.ProductInfoProvider.downloadImages(com.animaconnected.secondo.provider.productinfo.ProductInfoData, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0080 A[PHI: r7
  0x0080: PHI (r7v12 java.lang.Object) = (r7v11 java.lang.Object), (r7v1 java.lang.Object) binds: [B:17:0x007d, B:10:0x0026] A[DONT_GENERATE, DONT_INLINE], RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x007f A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0022  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object fetchProductInfo(kotlin.coroutines.Continuation<? super com.animaconnected.cloud.util.CloudProductInfoResponse> r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.animaconnected.secondo.provider.productinfo.ProductInfoProvider$fetchProductInfo$1
            if (r0 == 0) goto L13
            r0 = r7
            com.animaconnected.secondo.provider.productinfo.ProductInfoProvider$fetchProductInfo$1 r0 = (com.animaconnected.secondo.provider.productinfo.ProductInfoProvider$fetchProductInfo$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.animaconnected.secondo.provider.productinfo.ProductInfoProvider$fetchProductInfo$1 r0 = new com.animaconnected.secondo.provider.productinfo.ProductInfoProvider$fetchProductInfo$1
            r0.<init>(r6, r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L36
            if (r2 == r4) goto L32
            if (r2 != r3) goto L2a
            kotlin.ResultKt.throwOnFailure(r7)
            goto L80
        L2a:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L32:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L4a
        L36:
            kotlin.ResultKt.throwOnFailure(r7)
            com.animaconnected.watch.WatchProvider r7 = com.animaconnected.secondo.provider.ProviderFactory.getWatch()
            com.animaconnected.future.Future r7 = r7.getDeviceInformation()
            r0.label = r4
            java.lang.Object r7 = com.animaconnected.future.FutureCoroutineKt.getSuspending(r7, r0)
            if (r7 != r1) goto L4a
            return r1
        L4a:
            java.util.Map r7 = (java.util.Map) r7
            com.animaconnected.watch.device.DeviceInfo r2 = com.animaconnected.watch.device.DeviceInfo.SerialNumber
            java.lang.Object r2 = r7.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            com.animaconnected.watch.device.DeviceInfo r4 = com.animaconnected.watch.device.DeviceInfo.ModelNumber
            java.lang.Object r7 = r7.get(r4)
            java.lang.String r7 = (java.lang.String) r7
            android.content.Context r4 = com.animaconnected.secondo.provider.productinfo.ProductInfoProvider.context
            r5 = 2132017891(0x7f1402e3, float:1.9674073E38)
            java.lang.String r4 = r4.getString(r5)
            java.lang.String r5 = "getString(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            com.animaconnected.cloud.util.CloudProductInfo r5 = new com.animaconnected.cloud.util.CloudProductInfo
            r5.<init>(r2, r7, r4)
            com.animaconnected.cloud.Cloud r7 = com.animaconnected.secondo.provider.ProviderFactory.getCloudProvider()
            com.animaconnected.future.Future r7 = r7.getProductInfo(r5)
            r0.label = r3
            java.lang.Object r7 = com.animaconnected.future.FutureCoroutineKt.getSuspending(r7, r0)
            if (r7 != r1) goto L80
            return r1
        L80:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.productinfo.ProductInfoProvider.fetchProductInfo(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final ProductInfoData getCurrentSkuData() {
        ProductInfoStorage productInfoStorage = dataStorage;
        return productInfoStorage.getDataFromSku(productInfoStorage.getCurrentSku());
    }

    public static final Map<WatchImageType, Bitmap> getImages() {
        Pair pair;
        String currentSku = dataStorage.getCurrentSku();
        if (currentSku == null) {
            return EmptyMap.INSTANCE;
        }
        EnumEntries<WatchImageType> entries = WatchImageType.getEntries();
        ArrayList arrayList = new ArrayList();
        for (WatchImageType watchImageType : entries) {
            Bitmap image = INSTANCE.getImage(watchImageType, currentSku);
            if (image != null) {
                pair = new Pair(watchImageType, image);
            } else {
                pair = null;
            }
            if (pair != null) {
                arrayList.add(pair);
            }
        }
        return MapsKt__MapsKt.toMap(arrayList);
    }

    public static final Future<Unit> updateProductInfoFuture(boolean z) {
        CoroutineScope scope = KronabyApplication.Companion.getScope();
        DefaultScheduler defaultScheduler = Dispatchers.Default;
        return FutureCoroutineKt.asFuture(BuildersKt.async$default(scope, MainDispatcherLoader.dispatcher, new ProductInfoProvider$updateProductInfoFuture$1(z, null), 2));
    }

    public final ProductInfoData getData(String str) {
        return dataStorage.getDataFromSku(str);
    }

    public final Bitmap getImage(WatchImageType type, String str) {
        Intrinsics.checkNotNullParameter(type, "type");
        if (str != null) {
            return imageStorage.getImage(type, str);
        }
        return null;
    }

    public final void setCurrentSku(String str) {
        dataStorage.setCurrentSku(str);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(11:1|(2:3|(9:5|6|7|(1:(1:(3:11|12|13)(2:15|16))(2:17|18))(4:59|(1:61)(1:77)|62|(2:68|(2:70|71)(3:72|73|(1:75)(1:76)))(2:66|67))|19|(17:24|25|(1:27)|28|(1:30)|31|(1:33)(1:57)|34|(1:36)(1:56)|37|(3:(1:40)(1:54)|41|(2:(1:44)(1:53)|(4:46|(2:50|(1:52))(1:49)|12|13)))|55|(0)|50|(0)|12|13)|58|12|13))|80|6|7|(0)(0)|19|(18:21|24|25|(0)|28|(0)|31|(0)(0)|34|(0)(0)|37|(0)|55|(0)|50|(0)|12|13)|58|12|13) */
    /* JADX WARN: Code restructure failed: missing block: B:78:0x0033, code lost:            r0 = move-exception;     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0189, code lost:            android.util.Log.d(com.animaconnected.secondo.provider.productinfo.ProductInfoProvider.TAG, "Fetching productInfo failed: " + r0.getMessage());     */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00ed  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x010c A[Catch: Exception -> 0x0033, TryCatch #0 {Exception -> 0x0033, blocks: (B:11:0x002e, B:18:0x0042, B:19:0x00b3, B:21:0x00ce, B:24:0x00d6, B:28:0x00e7, B:31:0x00ee, B:34:0x00f6, B:36:0x010c, B:37:0x0112, B:40:0x011e, B:41:0x0122, B:44:0x012c, B:49:0x013a, B:50:0x0150, B:58:0x0173, B:73:0x00a7), top: B:7:0x0028 }] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0138 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0172 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0046  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x002a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object updateProductInfo(boolean r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
        /*
            Method dump skipped, instructions count: 424
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.animaconnected.secondo.provider.productinfo.ProductInfoProvider.updateProductInfo(boolean, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ void getImages$annotations() {
    }
}
