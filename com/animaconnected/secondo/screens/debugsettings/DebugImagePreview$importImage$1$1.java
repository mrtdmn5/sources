package com.animaconnected.secondo.screens.debugsettings;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.ImageDecoder;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import com.animaconnected.info.DateTimeUtilsKt;
import java.io.InputStream;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.ByteStreamsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: DebugImagePreview.kt */
@DebugMetadata(c = "com.animaconnected.secondo.screens.debugsettings.DebugImagePreview$importImage$1$1", f = "DebugImagePreview.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class DebugImagePreview$importImage$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Uri $uri;
    int label;
    final /* synthetic */ DebugImagePreview this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DebugImagePreview$importImage$1$1(DebugImagePreview debugImagePreview, Uri uri, Continuation<? super DebugImagePreview$importImage$1$1> continuation) {
        super(2, continuation);
        this.this$0 = debugImagePreview;
        this.$uri = uri;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DebugImagePreview$importImage$1$1(this.this$0, this.$uri, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ImageDecoder.Source createSource;
        Bitmap decodeBitmap;
        Bitmap copy;
        byte[] readBytes;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        if (this.label == 0) {
            ResultKt.throwOnFailure(obj);
            if (Build.VERSION.SDK_INT >= 28) {
                createSource = ImageDecoder.createSource(this.this$0.requireContext().getContentResolver(), this.$uri);
                decodeBitmap = ImageDecoder.decodeBitmap(createSource);
                copy = decodeBitmap.copy(Bitmap.Config.ARGB_8888, true);
            } else {
                copy = MediaStore.Images.Media.getBitmap(this.this$0.requireContext().getContentResolver(), this.$uri);
            }
            if (copy != null) {
                Storage storage = Storage.INSTANCE;
                String valueOf = String.valueOf(DateTimeUtilsKt.currentTimeMillis());
                Context requireContext = this.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext(...)");
                storage.saveBitmap(valueOf, copy, requireContext);
            } else {
                InputStream openInputStream = this.this$0.requireContext().getContentResolver().openInputStream(this.$uri);
                if (openInputStream != null) {
                    try {
                        readBytes = ByteStreamsKt.readBytes(openInputStream);
                    } finally {
                    }
                } else {
                    readBytes = null;
                }
                CloseableKt.closeFinally(openInputStream, null);
                if (readBytes == null) {
                    return Unit.INSTANCE;
                }
                Storage storage2 = Storage.INSTANCE;
                String valueOf2 = String.valueOf(DateTimeUtilsKt.currentTimeMillis());
                Context requireContext2 = this.this$0.requireContext();
                Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext(...)");
                storage2.saveBinaryData(valueOf2, readBytes, requireContext2);
            }
            this.this$0.refreshList();
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((DebugImagePreview$importImage$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }
}
