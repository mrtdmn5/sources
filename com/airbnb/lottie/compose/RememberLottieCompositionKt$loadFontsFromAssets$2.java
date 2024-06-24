package com.airbnb.lottie.compose;

import android.content.Context;
import android.graphics.Typeface;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.model.Font;
import com.airbnb.lottie.utils.Logger;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: rememberLottieComposition.kt */
@DebugMetadata(c = "com.airbnb.lottie.compose.RememberLottieCompositionKt$loadFontsFromAssets$2", f = "rememberLottieComposition.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class RememberLottieCompositionKt$loadFontsFromAssets$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ LottieComposition $composition;
    public final /* synthetic */ Context $context;
    public final /* synthetic */ String $fontAssetsFolder;
    public final /* synthetic */ String $fontFileExtension;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RememberLottieCompositionKt$loadFontsFromAssets$2(Context context, LottieComposition lottieComposition, String str, String str2, Continuation continuation) {
        super(2, continuation);
        this.$composition = lottieComposition;
        this.$context = context;
        this.$fontAssetsFolder = str;
        this.$fontFileExtension = str2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new RememberLottieCompositionKt$loadFontsFromAssets$2(this.$context, this.$composition, this.$fontAssetsFolder, this.$fontFileExtension, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((RememberLottieCompositionKt$loadFontsFromAssets$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ResultKt.throwOnFailure(obj);
        for (Font font : this.$composition.fonts.values()) {
            Context context = this.$context;
            Intrinsics.checkNotNullExpressionValue(font, "font");
            StringBuilder sb = new StringBuilder();
            sb.append((Object) this.$fontAssetsFolder);
            String str = font.style;
            sb.append((Object) font.family);
            sb.append(this.$fontFileExtension);
            try {
                Typeface typefaceWithDefaultStyle = Typeface.createFromAsset(context.getAssets(), sb.toString());
                try {
                    Intrinsics.checkNotNullExpressionValue(typefaceWithDefaultStyle, "typefaceWithDefaultStyle");
                    Intrinsics.checkNotNullExpressionValue(str, "font.style");
                    int r4 = 0;
                    boolean contains = StringsKt__StringsKt.contains(str, "Italic", false);
                    boolean contains2 = StringsKt__StringsKt.contains(str, "Bold", false);
                    if (contains && contains2) {
                        r4 = 3;
                    } else if (contains) {
                        r4 = 2;
                    } else if (contains2) {
                        r4 = 1;
                    }
                    if (typefaceWithDefaultStyle.getStyle() != r4) {
                        typefaceWithDefaultStyle = Typeface.create(typefaceWithDefaultStyle, r4);
                    }
                    font.typeface = typefaceWithDefaultStyle;
                } catch (Exception unused) {
                    Logger.INSTANCE.getClass();
                }
            } catch (Exception unused2) {
                Logger.INSTANCE.getClass();
            }
        }
        return Unit.INSTANCE;
    }
}
