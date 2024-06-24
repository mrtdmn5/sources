package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.ConstrainedOnceSequence;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlinx.coroutines.MainCoroutineDispatcher;

/* compiled from: MainDispatchers.kt */
/* loaded from: classes4.dex */
public final class MainDispatcherLoader {
    public static final MainCoroutineDispatcher dispatcher;

    static {
        String str;
        int r1 = SystemPropsKt__SystemPropsKt.AVAILABLE_PROCESSORS;
        Object obj = null;
        try {
            str = System.getProperty("kotlinx.coroutines.fast.service.loader");
        } catch (SecurityException unused) {
            str = null;
        }
        if (str != null) {
            Boolean.parseBoolean(str);
        }
        try {
            Iterator m = MainDispatcherLoader$$ExternalSyntheticServiceLoad0.m();
            Intrinsics.checkNotNullParameter(m, "<this>");
            Sequence sequencesKt__SequencesKt$asSequence$$inlined$Sequence$1 = new SequencesKt__SequencesKt$asSequence$$inlined$Sequence$1(m);
            if (!(sequencesKt__SequencesKt$asSequence$$inlined$Sequence$1 instanceof ConstrainedOnceSequence)) {
                sequencesKt__SequencesKt$asSequence$$inlined$Sequence$1 = new ConstrainedOnceSequence(sequencesKt__SequencesKt$asSequence$$inlined$Sequence$1);
            }
            List<? extends MainDispatcherFactory> list = SequencesKt___SequencesKt.toList(sequencesKt__SequencesKt$asSequence$$inlined$Sequence$1);
            Iterator it = list.iterator();
            if (it.hasNext()) {
                obj = it.next();
                if (it.hasNext()) {
                    int loadPriority = ((MainDispatcherFactory) obj).getLoadPriority();
                    do {
                        Object next = it.next();
                        int loadPriority2 = ((MainDispatcherFactory) next).getLoadPriority();
                        if (loadPriority < loadPriority2) {
                            obj = next;
                            loadPriority = loadPriority2;
                        }
                    } while (it.hasNext());
                }
            }
            MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) obj;
            if (mainDispatcherFactory != null) {
                try {
                    MainCoroutineDispatcher createDispatcher = mainDispatcherFactory.createDispatcher(list);
                    if (createDispatcher != null) {
                        dispatcher = createDispatcher;
                        return;
                    }
                } catch (Throwable th) {
                    mainDispatcherFactory.hintOnError();
                    throw th;
                }
            }
            throw new IllegalStateException("Module with the Main dispatcher is missing. Add dependency providing the Main dispatcher, e.g. 'kotlinx-coroutines-android' and ensure it has the same version as 'kotlinx-coroutines-core'");
        } catch (Throwable th2) {
            throw th2;
        }
    }
}
