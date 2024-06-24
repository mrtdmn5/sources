package com.animaconnected.secondo.screens.workout;

import android.graphics.Bitmap;
import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import com.animaconnected.logger.LogKt;
import java.io.File;
import java.io.FileOutputStream;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: BitmapCache.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.workout.BitmapCache$save$2", f = "BitmapCache.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class BitmapCache$save$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    final /* synthetic */ Bitmap $bitmapImage;
    final /* synthetic */ String $fileName;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BitmapCache$save$2(String str, Bitmap bitmap, Continuation<? super BitmapCache$save$2> continuation) {
        super(2, continuation);
        this.$fileName = str;
        this.$bitmapImage = bitmap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        BitmapCache$save$2 bitmapCache$save$2 = new BitmapCache$save$2(this.$fileName, this.$bitmapImage, continuation);
        bitmapCache$save$2.L$0 = obj;
        return bitmapCache$save$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        File cacheDir;
        boolean z;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            cacheDir = BitmapCache.INSTANCE.getCacheDir();
            final File file = new File(cacheDir, ComponentActivity$2$$ExternalSyntheticOutline0.m(new StringBuilder(), this.$fileName, ".png"));
            LogKt.verbose$default((Object) coroutineScope, "BitmapCache", (Throwable) null, false, (Function0) new Function0<String>() { // from class: com.animaconnected.secondo.screens.workout.BitmapCache$save$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final String invoke() {
                    return "saving: " + file.getAbsoluteFile();
                }
            }, 6, (Object) null);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(file);
                try {
                    this.$bitmapImage.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream);
                    CloseableKt.closeFinally(fileOutputStream, null);
                    z = true;
                } finally {
                }
            } catch (Exception unused) {
                z = false;
            }
            return Boolean.valueOf(z);
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((BitmapCache$save$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
