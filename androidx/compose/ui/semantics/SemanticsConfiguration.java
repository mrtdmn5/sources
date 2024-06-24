package androidx.compose.ui.semantics;

import androidx.compose.ui.platform.JvmActuals_jvmKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Function;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.sqlite.jdbc3.JDBC3PreparedStatement$$ExternalSyntheticLambda3;

/* compiled from: SemanticsConfiguration.kt */
/* loaded from: classes.dex */
public final class SemanticsConfiguration implements SemanticsPropertyReceiver, Iterable<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>>, KMappedMarker {
    public boolean isClearingSemantics;
    public boolean isMergingSemanticsOfDescendants;
    public final LinkedHashMap props = new LinkedHashMap();

    public final <T> boolean contains(SemanticsPropertyKey<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        return this.props.containsKey(key);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SemanticsConfiguration)) {
            return false;
        }
        SemanticsConfiguration semanticsConfiguration = (SemanticsConfiguration) obj;
        if (Intrinsics.areEqual(this.props, semanticsConfiguration.props) && this.isMergingSemanticsOfDescendants == semanticsConfiguration.isMergingSemanticsOfDescendants && this.isClearingSemantics == semanticsConfiguration.isClearingSemantics) {
            return true;
        }
        return false;
    }

    public final <T> T get(SemanticsPropertyKey<T> key) {
        Intrinsics.checkNotNullParameter(key, "key");
        T t = (T) this.props.get(key);
        if (t != null) {
            return t;
        }
        throw new IllegalStateException("Key not present: " + key + " - consider getOrElse or getOrNull");
    }

    public final int hashCode() {
        return Boolean.hashCode(this.isClearingSemantics) + JDBC3PreparedStatement$$ExternalSyntheticLambda3.m(this.isMergingSemanticsOfDescendants, this.props.hashCode() * 31, 31);
    }

    @Override // java.lang.Iterable
    public final Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> iterator() {
        return this.props.entrySet().iterator();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.compose.ui.semantics.SemanticsPropertyReceiver
    public final <T> void set(SemanticsPropertyKey<T> key, T t) {
        Intrinsics.checkNotNullParameter(key, "key");
        boolean z = t instanceof AccessibilityAction;
        LinkedHashMap linkedHashMap = this.props;
        if (z && contains(key)) {
            Object obj = linkedHashMap.get(key);
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
            AccessibilityAction accessibilityAction = (AccessibilityAction) obj;
            AccessibilityAction accessibilityAction2 = (AccessibilityAction) t;
            String str = accessibilityAction2.label;
            if (str == null) {
                str = accessibilityAction.label;
            }
            Function function = accessibilityAction2.action;
            if (function == null) {
                function = accessibilityAction.action;
            }
            linkedHashMap.put(key, new AccessibilityAction(str, function));
            return;
        }
        linkedHashMap.put(key, t);
    }

    public final String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        if (this.isMergingSemanticsOfDescendants) {
            sb.append("mergeDescendants=true");
            str = ", ";
        } else {
            str = "";
        }
        if (this.isClearingSemantics) {
            sb.append(str);
            sb.append("isClearingSemantics=true");
            str = ", ";
        }
        for (Map.Entry entry : this.props.entrySet()) {
            SemanticsPropertyKey semanticsPropertyKey = (SemanticsPropertyKey) entry.getKey();
            Object value = entry.getValue();
            sb.append(str);
            sb.append(semanticsPropertyKey.name);
            sb.append(" : ");
            sb.append(value);
            str = ", ";
        }
        return JvmActuals_jvmKt.simpleIdentityToString(this) + "{ " + ((Object) sb) + " }";
    }
}
