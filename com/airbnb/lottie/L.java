package com.airbnb.lottie;

import android.content.Context;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverKt$Saver$1;
import androidx.compose.runtime.saveable.SaverScope;
import com.airbnb.lottie.network.LottieNetworkCacheProvider;
import com.airbnb.lottie.network.NetworkCache;
import com.airbnb.lottie.network.NetworkFetcher;
import com.google.gson.internal.ObjectConstructor;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

/* loaded from: classes.dex */
public final class L implements ObjectConstructor {
    public static int depthPastMaxDepth;
    public static volatile NetworkCache networkCache;
    public static volatile NetworkFetcher networkFetcher;

    /* renamed from: com.airbnb.lottie.L$1, reason: invalid class name */
    /* loaded from: classes.dex */
    public final class AnonymousClass1 implements LottieNetworkCacheProvider {
        public final /* synthetic */ Context val$appContext;

        public AnonymousClass1(Context context) {
            this.val$appContext = context;
        }
    }

    public static void endSection() {
        int r0 = depthPastMaxDepth;
        if (r0 > 0) {
            depthPastMaxDepth = r0 - 1;
        }
    }

    public static final SaverKt$Saver$1 listSaver(final Function2 save, Function1 restore) {
        Intrinsics.checkNotNullParameter(save, "save");
        Intrinsics.checkNotNullParameter(restore, "restore");
        Function2<SaverScope, Object, Object> function2 = new Function2<SaverScope, Object, Object>() { // from class: androidx.compose.runtime.saveable.ListSaverKt$listSaver$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(SaverScope saverScope, Object obj) {
                SaverScope Saver = saverScope;
                Intrinsics.checkNotNullParameter(Saver, "$this$Saver");
                List<Object> invoke = save.invoke(Saver, obj);
                int size = invoke.size();
                for (int r1 = 0; r1 < size; r1++) {
                    Object obj2 = invoke.get(r1);
                    if (obj2 != null && !Saver.canBeSaved(obj2)) {
                        throw new IllegalArgumentException("Failed requirement.".toString());
                    }
                }
                List<Object> list = invoke;
                if (!list.isEmpty()) {
                    return new ArrayList(list);
                }
                return null;
            }
        };
        TypeIntrinsics.beforeCheckcastToFunctionOfArity(1, restore);
        return SaverKt.Saver(function2, restore);
    }

    @Override // com.google.gson.internal.ObjectConstructor
    public Object construct() {
        return new TreeSet();
    }
}
