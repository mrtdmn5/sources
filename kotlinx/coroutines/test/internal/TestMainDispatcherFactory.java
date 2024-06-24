package kotlinx.coroutines.test.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.internal.MainDispatcherFactory;
import kotlinx.coroutines.internal.MissingMainCoroutineDispatcherFactory;

/* compiled from: TestMainDispatcherJvm.kt */
/* loaded from: classes4.dex */
public final class TestMainDispatcherFactory implements MainDispatcherFactory {
    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public MainCoroutineDispatcher createDispatcher(List<? extends MainDispatcherFactory> list) {
        Object obj;
        boolean z;
        ArrayList arrayList = new ArrayList();
        for (Object obj2 : list) {
            if (((MainDispatcherFactory) obj2) != this) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                arrayList.add(obj2);
            }
        }
        Iterator it = arrayList.iterator();
        if (!it.hasNext()) {
            obj = null;
        } else {
            Object next = it.next();
            if (it.hasNext()) {
                int loadPriority = ((MainDispatcherFactory) next).getLoadPriority();
                do {
                    Object next2 = it.next();
                    int loadPriority2 = ((MainDispatcherFactory) next2).getLoadPriority();
                    if (loadPriority < loadPriority2) {
                        next = next2;
                        loadPriority = loadPriority2;
                    }
                } while (it.hasNext());
            }
            obj = next;
        }
        MainDispatcherFactory mainDispatcherFactory = (MainDispatcherFactory) obj;
        if (mainDispatcherFactory == null) {
            mainDispatcherFactory = MissingMainCoroutineDispatcherFactory.INSTANCE;
        }
        try {
            return new TestMainDispatcher(mainDispatcherFactory.createDispatcher(arrayList));
        } catch (Throwable th) {
            mainDispatcherFactory.hintOnError();
            throw th;
        }
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public int getLoadPriority() {
        return Integer.MAX_VALUE;
    }

    @Override // kotlinx.coroutines.internal.MainDispatcherFactory
    public String hintOnError() {
        return null;
    }
}
