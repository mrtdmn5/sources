package com.animaconnected.secondo.provider.productinfo.watchimage;

import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: WatchImageStorage.kt */
@DebugMetadata(c = "com.animaconnected.secondo.provider.productinfo.watchimage.WatchImageStorage$setImage$2", f = "WatchImageStorage.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class WatchImageStorage$setImage$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Object>, Object> {
    final /* synthetic */ Bitmap $bitmap;
    final /* synthetic */ String $sku;
    final /* synthetic */ WatchImageType $type;
    int label;
    final /* synthetic */ WatchImageStorage this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public WatchImageStorage$setImage$2(WatchImageStorage watchImageStorage, String str, WatchImageType watchImageType, Bitmap bitmap, Continuation<? super WatchImageStorage$setImage$2> continuation) {
        super(2, continuation);
        this.this$0 = watchImageStorage;
        this.$sku = str;
        this.$type = watchImageType;
        this.$bitmap = bitmap;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WatchImageStorage$setImage$2(this.this$0, this.$sku, this.$type, this.$bitmap, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public /* bridge */ /* synthetic */ Object invoke(CoroutineScope coroutineScope, Continuation<? super Object> continuation) {
        return invoke2(coroutineScope, (Continuation<Object>) continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        File file;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            try {
                file = this.this$0.getFile(this.$sku, this.$type);
                if (file.exists() && !file.delete()) {
                    throw new IOException("Failed to delete file");
                }
                if (file.createNewFile()) {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    this.$bitmap.compress(Bitmap.CompressFormat.PNG, 0, byteArrayOutputStream);
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    byteArrayOutputStream.close();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(byteArray);
                    fileOutputStream.close();
                    return byteArrayOutputStream;
                }
                throw new IOException("Can't create file");
            } catch (IOException e) {
                e.printStackTrace();
                return Unit.INSTANCE;
            }
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    /* renamed from: invoke, reason: avoid collision after fix types in other method */
    public final Object invoke2(CoroutineScope coroutineScope, Continuation<Object> continuation) {
        return ((WatchImageStorage$setImage$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
