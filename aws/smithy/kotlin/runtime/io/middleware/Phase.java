package aws.smithy.kotlin.runtime.io.middleware;

import aws.smithy.kotlin.runtime.io.Handler;
import java.util.Arrays;
import kotlin.collections.ArrayDeque;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Phase.kt */
/* loaded from: classes.dex */
public final class Phase<Request, Response> implements Middleware<Request, Response> {
    public final ArrayDeque<Middleware<Request, Response>> middlewares = new ArrayDeque<>();

    /* compiled from: Phase.kt */
    /* loaded from: classes.dex */
    public enum Order {
        Before,
        After
    }

    /* compiled from: Phase.kt */
    /* loaded from: classes.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[Order.values().length];
            try {
                r0[Order.Before.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[Order.After.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    @Override // aws.smithy.kotlin.runtime.io.middleware.Middleware
    public final <H extends Handler<? super Request, ? extends Response>> Object handle(Request request, H h, Continuation<? super Response> continuation) {
        ArrayDeque<Middleware<Request, Response>> arrayDeque = this.middlewares;
        if (arrayDeque.isEmpty()) {
            return h.call(request, continuation);
        }
        Middleware[] middlewareArr = (Middleware[]) arrayDeque.toArray(new Middleware[0]);
        return MiddlewareKt.decorate(h, (Middleware[]) Arrays.copyOf(middlewareArr, middlewareArr.length)).call(request, continuation);
    }

    public final void register(Middleware<Request, Response> middleware, Order order) {
        Intrinsics.checkNotNullParameter(middleware, "middleware");
        Intrinsics.checkNotNullParameter(order, "order");
        int r4 = WhenMappings.$EnumSwitchMapping$0[order.ordinal()];
        ArrayDeque<Middleware<Request, Response>> arrayDeque = this.middlewares;
        if (r4 != 1) {
            if (r4 == 2) {
                arrayDeque.addLast(middleware);
                return;
            }
            return;
        }
        arrayDeque.addFirst(middleware);
    }
}
