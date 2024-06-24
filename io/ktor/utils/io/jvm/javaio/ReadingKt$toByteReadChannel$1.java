package io.ktor.utils.io.jvm.javaio;

import io.ktor.utils.io.ByteChannel;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.InputStream;
import java.nio.ByteBuffer;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

/* compiled from: Reading.kt */
@DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.ReadingKt$toByteReadChannel$1", f = "Reading.kt", l = {60}, m = "invokeSuspend")
/* loaded from: classes3.dex */
public final class ReadingKt$toByteReadChannel$1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
    public final /* synthetic */ ObjectPool<ByteBuffer> $pool;
    public final /* synthetic */ InputStream $this_toByteReadChannel;
    public /* synthetic */ Object L$0;
    public ByteBuffer L$1;
    public int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ReadingKt$toByteReadChannel$1(ObjectPool<ByteBuffer> objectPool, InputStream inputStream, Continuation<? super ReadingKt$toByteReadChannel$1> continuation) {
        super(2, continuation);
        this.$pool = objectPool;
        this.$this_toByteReadChannel = inputStream;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        ReadingKt$toByteReadChannel$1 readingKt$toByteReadChannel$1 = new ReadingKt$toByteReadChannel$1(this.$pool, this.$this_toByteReadChannel, continuation);
        readingKt$toByteReadChannel$1.L$0 = obj;
        return readingKt$toByteReadChannel$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
        return ((ReadingKt$toByteReadChannel$1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        ByteBuffer borrow;
        WriterScope writerScope;
        CoroutineSingletons coroutineSingletons = CoroutineSingletons.COROUTINE_SUSPENDED;
        int r1 = this.label;
        InputStream inputStream = this.$this_toByteReadChannel;
        ObjectPool<ByteBuffer> objectPool = this.$pool;
        if (r1 != 0) {
            if (r1 == 1) {
                borrow = this.L$1;
                writerScope = (WriterScope) this.L$0;
                try {
                    ResultKt.throwOnFailure(obj);
                } catch (Throwable th) {
                    try {
                        writerScope.getChannel$1().close(th);
                    } catch (Throwable th2) {
                        objectPool.recycle(borrow);
                        inputStream.close();
                        throw th2;
                    }
                }
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        } else {
            ResultKt.throwOnFailure(obj);
            WriterScope writerScope2 = (WriterScope) this.L$0;
            borrow = objectPool.borrow();
            writerScope = writerScope2;
        }
        while (true) {
            borrow.clear();
            int read = inputStream.read(borrow.array(), borrow.arrayOffset() + borrow.position(), borrow.remaining());
            if (read < 0) {
                break;
            }
            if (read != 0) {
                borrow.position(borrow.position() + read);
                borrow.flip();
                ByteChannel channel$1 = writerScope.getChannel$1();
                this.L$0 = writerScope;
                this.L$1 = borrow;
                this.label = 1;
                if (channel$1.writeFully(borrow, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            }
        }
        objectPool.recycle(borrow);
        inputStream.close();
        return Unit.INSTANCE;
    }
}
