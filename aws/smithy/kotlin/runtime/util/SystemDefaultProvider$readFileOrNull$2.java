package aws.smithy.kotlin.runtime.util;

import java.io.File;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.FilesKt__FileReadWriteKt;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: PlatformJVM.kt */
@DebugMetadata(c = "aws.smithy.kotlin.runtime.util.SystemDefaultProvider$readFileOrNull$2", f = "PlatformJVM.kt", l = {}, m = "invokeSuspend")
/* loaded from: classes.dex */
public final class SystemDefaultProvider$readFileOrNull$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super byte[]>, Object> {
    public final /* synthetic */ String $path;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SystemDefaultProvider$readFileOrNull$2(String str, Continuation<? super SystemDefaultProvider$readFileOrNull$2> continuation) {
        super(2, continuation);
        this.$path = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SystemDefaultProvider$readFileOrNull$2(this.$path, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super byte[]> continuation) {
        return ((SystemDefaultProvider$readFileOrNull$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        ResultKt.throwOnFailure(obj);
        return FilesKt__FileReadWriteKt.readBytes(new File(this.$path));
    }
}
