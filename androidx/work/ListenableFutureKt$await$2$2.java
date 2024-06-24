package androidx.work;

import com.google.common.util.concurrent.ListenableFuture;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: ListenableFuture.kt */
/* loaded from: classes.dex */
public final class ListenableFutureKt$await$2$2 extends Lambda implements Function1<Throwable, Unit> {
    public final /* synthetic */ ListenableFuture<Object> $this_await;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ListenableFutureKt$await$2$2(ListenableFuture<Object> listenableFuture) {
        super(1);
        this.$this_await = listenableFuture;
    }

    @Override // kotlin.jvm.functions.Function1
    public final Unit invoke(Throwable th) {
        this.$this_await.cancel(false);
        return Unit.INSTANCE;
    }
}
