package kotlin.jvm.internal;

import androidx.concurrent.futures.AbstractResolvableFuture$$ExternalSyntheticOutline0;
import com.amazonaws.services.s3.internal.Constants;
import java.util.Collection;
import java.util.Map;
import kotlin.Function;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function10;
import kotlin.jvm.functions.Function11;
import kotlin.jvm.functions.Function12;
import kotlin.jvm.functions.Function13;
import kotlin.jvm.functions.Function14;
import kotlin.jvm.functions.Function15;
import kotlin.jvm.functions.Function16;
import kotlin.jvm.functions.Function17;
import kotlin.jvm.functions.Function18;
import kotlin.jvm.functions.Function19;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function20;
import kotlin.jvm.functions.Function21;
import kotlin.jvm.functions.Function22;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.functions.Function7;
import kotlin.jvm.functions.Function8;
import kotlin.jvm.functions.Function9;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.jvm.internal.markers.KMutableMap;

/* loaded from: classes.dex */
public final class TypeIntrinsics {
    public static Collection asMutableCollection(Collection collection) {
        if ((collection instanceof KMappedMarker) && !(collection instanceof KMutableCollection)) {
            throwCce(collection, "kotlin.collections.MutableCollection");
            throw null;
        }
        try {
            return collection;
        } catch (ClassCastException e) {
            Intrinsics.sanitizeStackTrace(TypeIntrinsics.class.getName(), e);
            throw e;
        }
    }

    public static Map asMutableMap(Map map) {
        if ((map instanceof KMappedMarker) && !(map instanceof KMutableMap)) {
            throwCce(map, "kotlin.collections.MutableMap");
            throw null;
        }
        try {
            return map;
        } catch (ClassCastException e) {
            Intrinsics.sanitizeStackTrace(TypeIntrinsics.class.getName(), e);
            throw e;
        }
    }

    public static void beforeCheckcastToFunctionOfArity(int r2, Object obj) {
        if (obj != null && !isFunctionOfArity(r2, obj)) {
            throwCce(obj, "kotlin.jvm.functions.Function" + r2);
            throw null;
        }
    }

    public static boolean isFunctionOfArity(int r3, Object obj) {
        int r4;
        if (!(obj instanceof Function)) {
            return false;
        }
        if (obj instanceof FunctionBase) {
            r4 = ((FunctionBase) obj).getArity();
        } else if (obj instanceof Function0) {
            r4 = 0;
        } else if (obj instanceof Function1) {
            r4 = 1;
        } else if (obj instanceof Function2) {
            r4 = 2;
        } else if (obj instanceof Function3) {
            r4 = 3;
        } else if (obj instanceof Function4) {
            r4 = 4;
        } else if (obj instanceof Function5) {
            r4 = 5;
        } else if (obj instanceof Function6) {
            r4 = 6;
        } else if (obj instanceof Function7) {
            r4 = 7;
        } else if (obj instanceof Function8) {
            r4 = 8;
        } else if (obj instanceof Function9) {
            r4 = 9;
        } else if (obj instanceof Function10) {
            r4 = 10;
        } else if (obj instanceof Function11) {
            r4 = 11;
        } else if (obj instanceof Function12) {
            r4 = 12;
        } else if (obj instanceof Function13) {
            r4 = 13;
        } else if (obj instanceof Function14) {
            r4 = 14;
        } else if (obj instanceof Function15) {
            r4 = 15;
        } else if (obj instanceof Function16) {
            r4 = 16;
        } else if (obj instanceof Function17) {
            r4 = 17;
        } else if (obj instanceof Function18) {
            r4 = 18;
        } else if (obj instanceof Function19) {
            r4 = 19;
        } else if (obj instanceof Function20) {
            r4 = 20;
        } else if (obj instanceof Function21) {
            r4 = 21;
        } else if (obj instanceof Function22) {
            r4 = 22;
        } else {
            r4 = -1;
        }
        if (r4 != r3) {
            return false;
        }
        return true;
    }

    public static void throwCce(Object obj, String str) {
        String name;
        if (obj == null) {
            name = Constants.NULL_VERSION_ID;
        } else {
            name = obj.getClass().getName();
        }
        ClassCastException classCastException = new ClassCastException(AbstractResolvableFuture$$ExternalSyntheticOutline0.m(name, " cannot be cast to ", str));
        Intrinsics.sanitizeStackTrace(TypeIntrinsics.class.getName(), classCastException);
        throw classCastException;
    }
}
