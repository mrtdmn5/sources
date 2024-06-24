package kotlin.sequences;

import com.google.android.gms.internal.fitness.zzba;
import io.ktor.http.ContentTypesKt;
import java.util.Iterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Sequences.kt */
/* loaded from: classes.dex */
public class SequencesKt__SequencesKt extends zzba {
    public static final <T> Sequence<T> generateSequence(final T t, Function1<? super T, ? extends T> nextFunction) {
        Intrinsics.checkNotNullParameter(nextFunction, "nextFunction");
        if (t == null) {
            return EmptySequence.INSTANCE;
        }
        return new GeneratorSequence(nextFunction, new Function0<T>() { // from class: kotlin.sequences.SequencesKt__SequencesKt$generateSequence$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final T invoke() {
                return t;
            }
        });
    }

    public static final <T> Sequence<T> sequenceOf(final T... tArr) {
        boolean z;
        boolean z2 = true;
        if (tArr.length == 0) {
            z = true;
        } else {
            z = false;
        }
        EmptySequence emptySequence = EmptySequence.INSTANCE;
        if (!z) {
            if (tArr.length != 0) {
                z2 = false;
            }
            if (!z2) {
                return (Sequence<T>) new Sequence<Object>() { // from class: kotlin.collections.ArraysKt___ArraysKt$asSequence$$inlined$Sequence$1
                    @Override // kotlin.sequences.Sequence
                    public final Iterator<Object> iterator() {
                        return ContentTypesKt.iterator(tArr);
                    }
                };
            }
            return emptySequence;
        }
        return emptySequence;
    }
}
