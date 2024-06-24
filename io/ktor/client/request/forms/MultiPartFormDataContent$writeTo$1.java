package io.ktor.client.request.forms;

import com.animaconnected.secondo.R;
import io.ktor.utils.io.ByteWriteChannel;
import java.util.Iterator;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FormDataContent.kt */
@DebugMetadata(c = "io.ktor.client.request.forms.MultiPartFormDataContent", f = "FormDataContent.kt", l = {115, 116, 117, 122, 126, R.styleable.AppTheme_statusTopStripeSetup, 133}, m = "writeTo")
/* loaded from: classes3.dex */
public final class MultiPartFormDataContent$writeTo$1 extends ContinuationImpl {
    public Object L$0;
    public ByteWriteChannel L$1;
    public Iterator L$2;
    public Object L$3;
    public int label;
    public /* synthetic */ Object result;
    public final /* synthetic */ MultiPartFormDataContent this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiPartFormDataContent$writeTo$1(MultiPartFormDataContent multiPartFormDataContent, Continuation<? super MultiPartFormDataContent$writeTo$1> continuation) {
        super(continuation);
        this.this$0 = multiPartFormDataContent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.writeTo(null, this);
    }
}
