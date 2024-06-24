package aws.smithy.kotlin.runtime.io.middleware;

import androidx.compose.runtime.ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0;
import aws.smithy.kotlin.runtime.io.Handler;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.EmptyList;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Middleware.kt */
/* loaded from: classes.dex */
public final class MiddlewareKt {
    /* JADX WARN: Multi-variable type inference failed */
    public static final <Request, Response> Handler<Request, Response> decorate(Handler<? super Request, ? extends Response> handler, Middleware<Request, Response>... middleware) {
        boolean z;
        boolean z2;
        List list;
        Intrinsics.checkNotNullParameter(handler, "handler");
        Intrinsics.checkNotNullParameter(middleware, "middleware");
        boolean z3 = false;
        if (middleware.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            return handler;
        }
        int length = middleware.length - 1;
        if (length < 0) {
            length = 0;
        }
        if (length >= 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (length == 0) {
                list = EmptyList.INSTANCE;
            } else if (length >= middleware.length) {
                list = ArraysKt___ArraysKt.toList(middleware);
            } else if (length == 1) {
                list = CollectionsKt__CollectionsKt.listOf(middleware[0]);
            } else {
                ArrayList arrayList = new ArrayList(length);
                int r6 = 0;
                for (Middleware<Request, Response> middleware2 : middleware) {
                    arrayList.add(middleware2);
                    r6++;
                    if (r6 == length) {
                        break;
                    }
                }
                list = arrayList;
            }
            if (middleware.length == 0) {
                z3 = true;
            }
            if (!z3) {
                DecoratedHandler decoratedHandler = new DecoratedHandler(handler, middleware[middleware.length - 1]);
                if (!list.isEmpty()) {
                    ListIterator listIterator = list.listIterator(list.size());
                    while (listIterator.hasPrevious()) {
                        decoratedHandler = new DecoratedHandler(decoratedHandler, (Middleware) listIterator.previous());
                    }
                }
                return decoratedHandler;
            }
            throw new NoSuchElementException("Array is empty.");
        }
        throw new IllegalArgumentException(ParcelableSnapshotMutableState$Companion$CREATOR$1$$ExternalSyntheticOutline0.m("Requested element count ", length, " is less than zero.").toString());
    }
}
