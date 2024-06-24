package io.ktor.client.request.forms;

import com.animaconnected.secondo.R;
import io.ktor.utils.io.ByteWriteChannel;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: FormDataContent.kt */
@DebugMetadata(c = "io.ktor.client.request.forms.FormDataContentKt", f = "FormDataContent.kt", l = {R.styleable.AppTheme_styleMarbleText, R.styleable.AppTheme_themeShadowOpacity, R.styleable.AppTheme_workoutDetailTintColor, R.styleable.AppTheme_workoutDetailTintColor}, m = "copyTo")
/* loaded from: classes3.dex */
public final class FormDataContentKt$copyTo$1 extends ContinuationImpl {
    public Object L$0;
    public ByteWriteChannel L$1;
    public Object L$2;
    public int label;
    public /* synthetic */ Object result;

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return FormDataContentKt.access$copyTo(null, null, this);
    }
}
