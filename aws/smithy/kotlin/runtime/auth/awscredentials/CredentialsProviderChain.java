package aws.smithy.kotlin.runtime.auth.awscredentials;

import java.io.Closeable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.ExceptionsKt;
import kotlin.collections.CollectionsKt__CollectionsKt;
import kotlin.collections.CollectionsKt__IteratorsJVMKt;
import kotlin.collections.CollectionsKt__ReversedViewsKt;
import kotlin.collections.CollectionsKt___CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* compiled from: CredentialsProviderChain.kt */
/* loaded from: classes.dex */
public final class CredentialsProviderChain implements CloseableCredentialsProvider {
    public final CredentialsProvider[] providers;

    public CredentialsProviderChain(CredentialsProvider... credentialsProviderArr) {
        boolean z;
        this.providers = credentialsProviderArr;
        if (credentialsProviderArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        if (!z) {
        } else {
            throw new IllegalArgumentException("at least one provider must be in the chain".toString());
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        Exception exc;
        Closeable closeable;
        ArrayList arrayList = new ArrayList();
        for (CredentialsProvider credentialsProvider : this.providers) {
            try {
                exc = null;
                if (credentialsProvider instanceof Closeable) {
                    closeable = (Closeable) credentialsProvider;
                } else {
                    closeable = null;
                }
                if (closeable != null) {
                    closeable.close();
                }
            } catch (Exception e) {
                exc = e;
            }
            if (exc != null) {
                arrayList.add(exc);
            }
        }
        if (!arrayList.isEmpty()) {
            Exception exc2 = (Exception) CollectionsKt___CollectionsKt.first((List) arrayList);
            Iterator it = CollectionsKt___CollectionsKt.drop(arrayList).iterator();
            while (it.hasNext()) {
                ExceptionsKt.addSuppressed(exc2, (Throwable) it.next());
            }
            throw exc2;
        }
    }

    public final String toString() {
        List listOf = CollectionsKt__CollectionsKt.listOf(this);
        CredentialsProvider[] elements = this.providers;
        Intrinsics.checkNotNullParameter(elements, "elements");
        ArrayList arrayList = new ArrayList(listOf.size() + elements.length);
        arrayList.addAll(listOf);
        CollectionsKt__ReversedViewsKt.addAll(arrayList, elements);
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IteratorsJVMKt.collectionSizeOrDefault(arrayList, 10));
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            arrayList2.add(Reflection.getOrCreateKotlinClass(((CredentialsProvider) it.next()).getClass()).getSimpleName());
        }
        return CollectionsKt___CollectionsKt.joinToString$default(arrayList2, " -> ", null, null, null, 62);
    }
}
