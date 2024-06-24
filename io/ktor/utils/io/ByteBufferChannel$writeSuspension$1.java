package io.ktor.utils.io;

import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: ByteBufferChannel.kt */
/* loaded from: classes3.dex */
public final class ByteBufferChannel$writeSuspension$1 extends Lambda implements Function1<Continuation<? super Unit>, Object> {
    public final /* synthetic */ ByteBufferChannel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ByteBufferChannel$writeSuspension$1(ByteBufferChannel byteBufferChannel) {
        super(1);
        this.this$0 = byteBufferChannel;
    }

    /* JADX WARN: Code restructure failed: missing block: B:37:0x0070, code lost:            r9.this$0.flushImpl(r0);     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x007b, code lost:            if (r9.this$0.shouldResumeReadOp() == false) goto L41;     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x007d, code lost:            r9.this$0.resumeReadOp();     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0084, code lost:            return kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED;     */
    @Override // kotlin.jvm.functions.Function1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invoke(kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r9 = this;
            kotlin.coroutines.Continuation r10 = (kotlin.coroutines.Continuation) r10
            java.lang.String r0 = "ucont"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            io.ktor.utils.io.ByteBufferChannel r0 = r9.this$0
            int r0 = io.ktor.utils.io.ByteBufferChannel.access$getWriteSuspensionSize$p(r0)
        Ld:
            io.ktor.utils.io.ByteBufferChannel r1 = r9.this$0
            io.ktor.utils.io.internal.ClosedElement r1 = io.ktor.utils.io.ByteBufferChannel.access$getClosed(r1)
            r2 = 0
            if (r1 != 0) goto L91
            io.ktor.utils.io.ByteBufferChannel r1 = r9.this$0
            boolean r1 = r1.writeSuspendPredicate(r0)
            if (r1 != 0) goto L24
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r10.resumeWith(r1)
            goto L70
        L24:
            io.ktor.utils.io.ByteBufferChannel r1 = r9.this$0
            kotlin.coroutines.Continuation r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.intercepted(r10)
            io.ktor.utils.io.ByteBufferChannel r4 = r9.this$0
        L2c:
            java.lang.Object r5 = r1._writeOp
            kotlin.coroutines.Continuation r5 = (kotlin.coroutines.Continuation) r5
            r6 = 1
            r7 = 0
            if (r5 != 0) goto L36
            r5 = r6
            goto L37
        L36:
            r5 = r7
        L37:
            if (r5 == 0) goto L85
            boolean r5 = r4.writeSuspendPredicate(r0)
            if (r5 != 0) goto L40
            goto L6d
        L40:
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r5 = io.ktor.utils.io.ByteBufferChannel._writeOp$FU
        L42:
            boolean r8 = r5.compareAndSet(r1, r2, r3)
            if (r8 == 0) goto L4a
            r5 = r6
            goto L51
        L4a:
            java.lang.Object r8 = r5.get(r1)
            if (r8 == 0) goto L42
            r5 = r7
        L51:
            if (r5 == 0) goto L2c
            boolean r4 = r4.writeSuspendPredicate(r0)
            if (r4 != 0) goto L6e
            java.util.concurrent.atomic.AtomicReferenceFieldUpdater r4 = io.ktor.utils.io.ByteBufferChannel._writeOp$FU
        L5b:
            boolean r5 = r4.compareAndSet(r1, r3, r2)
            if (r5 == 0) goto L63
            r1 = r6
            goto L6a
        L63:
            java.lang.Object r5 = r4.get(r1)
            if (r5 == r3) goto L5b
            r1 = r7
        L6a:
            if (r1 != 0) goto L6d
            goto L6e
        L6d:
            r6 = r7
        L6e:
            if (r6 == 0) goto Ld
        L70:
            io.ktor.utils.io.ByteBufferChannel r10 = r9.this$0
            r10.flushImpl(r0)
            io.ktor.utils.io.ByteBufferChannel r10 = r9.this$0
            boolean r10 = r10.shouldResumeReadOp()
            if (r10 == 0) goto L82
            io.ktor.utils.io.ByteBufferChannel r10 = r9.this$0
            r10.resumeReadOp()
        L82:
            kotlin.coroutines.intrinsics.CoroutineSingletons r10 = kotlin.coroutines.intrinsics.CoroutineSingletons.COROUTINE_SUSPENDED
            return r10
        L85:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "Operation is already in progress"
            java.lang.String r0 = r0.toString()
            r10.<init>(r0)
            throw r10
        L91:
            java.lang.Throwable r10 = r1.getSendException()
            com.google.common.collect.Lists.access$rethrowClosed(r10)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteBufferChannel$writeSuspension$1.invoke(java.lang.Object):java.lang.Object");
    }
}
