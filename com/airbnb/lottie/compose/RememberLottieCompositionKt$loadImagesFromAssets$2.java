package com.airbnb.lottie.compose;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieImageAsset;
import com.airbnb.lottie.utils.Logger;
import com.airbnb.lottie.utils.Utils;
import com.animaconnected.secondo.R;
import java.io.IOException;
import java.io.InputStream;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: rememberLottieComposition.kt */
@DebugMetadata(c = "com.airbnb.lottie.compose.RememberLottieCompositionKt$loadImagesFromAssets$2", f = "rememberLottieComposition.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RememberLottieCompositionKt$loadImagesFromAssets$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ LottieComposition $composition;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $imageAssetsFolder;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RememberLottieCompositionKt$loadImagesFromAssets$2(Context context, LottieComposition lottieComposition, String str, Continuation continuation) {
        super(2, continuation);
        this.$composition = lottieComposition;
        this.$context = context;
        this.$imageAssetsFolder = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RememberLottieCompositionKt$loadImagesFromAssets$2(this.$context, this.$composition, this.$imageAssetsFolder, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RememberLottieCompositionKt$loadImagesFromAssets$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        String str;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ResultKt.throwOnFailure(obj);
        for (LottieImageAsset asset : this.$composition.images.values()) {
            Intrinsics.checkNotNullExpressionValue(asset, "asset");
            Bitmap bitmap = asset.bitmap;
            String filename = asset.fileName;
            if (bitmap == null) {
                Intrinsics.checkNotNullExpressionValue(filename, "filename");
                if (StringsKt__StringsJVMKt.startsWith(filename, "data:", false) && StringsKt__StringsKt.indexOf$default((CharSequence) filename, "base64,", 0, false, 6) > 0) {
                    try {
                        String substring = filename.substring(StringsKt__StringsKt.indexOf$default((CharSequence) filename, ',', 0, false, 6) + 1);
                        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                        byte[] decode = Base64.decode(substring, 0);
                        BitmapFactory.Options options = new BitmapFactory.Options();
                        options.inScaled = true;
                        options.inDensity = R.styleable.AppTheme_subComplicationDropZoneNotSelected;
                        asset.bitmap = BitmapFactory.decodeByteArray(decode, 0, decode.length, options);
                    } catch (IllegalArgumentException e) {
                        Logger.warning("data URL did not have correct base64 format.", e);
                    }
                }
            }
            Context context = this.$context;
            if (asset.bitmap == null && (str = this.$imageAssetsFolder) != null) {
                try {
                    InputStream open = context.getAssets().open(str + ((Object) filename));
                    Intrinsics.checkNotNullExpressionValue(open, "try {\n        context.as…, e)\n        return\n    }");
                    try {
                        BitmapFactory.Options options2 = new BitmapFactory.Options();
                        options2.inScaled = true;
                        options2.inDensity = R.styleable.AppTheme_subComplicationDropZoneNotSelected;
                        asset.bitmap = Utils.resizeBitmapIfNeeded(BitmapFactory.decodeStream(open, null, options2), asset.width, asset.height);
                    } catch (IllegalArgumentException e2) {
                        Logger.warning("Unable to decode image.", e2);
                    }
                } catch (IOException e3) {
                    Logger.warning("Unable to open asset.", e3);
                }
            }
        }
        return Unit.INSTANCE;
    }
}
