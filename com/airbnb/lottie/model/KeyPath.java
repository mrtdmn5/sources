package com.airbnb.lottie.model;

import androidx.compose.animation.AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public final class KeyPath {
    public static final KeyPath COMPOSITION = new KeyPath("COMPOSITION");
    public final List<String> keys;
    public KeyPathElement resolvedElement;

    public KeyPath(String... strArr) {
        this.keys = Arrays.asList(strArr);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || KeyPath.class != obj.getClass()) {
            return false;
        }
        KeyPath keyPath = (KeyPath) obj;
        if (!this.keys.equals(keyPath.keys)) {
            return false;
        }
        KeyPathElement keyPathElement = this.resolvedElement;
        KeyPathElement keyPathElement2 = keyPath.resolvedElement;
        if (keyPathElement != null) {
            return keyPathElement.equals(keyPathElement2);
        }
        if (keyPathElement2 == null) {
            return true;
        }
        return false;
    }

    public final boolean fullyResolvesTo(int r8, String str) {
        boolean z;
        boolean z2;
        boolean z3;
        List<String> list = this.keys;
        if (r8 >= list.size()) {
            return false;
        }
        if (r8 == list.size() - 1) {
            z = true;
        } else {
            z = false;
        }
        String str2 = list.get(r8);
        if (!str2.equals("**")) {
            if (!str2.equals(str) && !str2.equals("*")) {
                z3 = false;
            } else {
                z3 = true;
            }
            if ((!z && (r8 != list.size() - 2 || !list.get(list.size() - 1).equals("**"))) || !z3) {
                return false;
            }
            return true;
        }
        if (!z && list.get(r8 + 1).equals(str)) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z2) {
            if (r8 != list.size() - 2 && (r8 != list.size() - 3 || !list.get(list.size() - 1).equals("**"))) {
                return false;
            }
            return true;
        }
        if (z) {
            return true;
        }
        int r82 = r8 + 1;
        if (r82 < list.size() - 1) {
            return false;
        }
        return list.get(r82).equals(str);
    }

    public final int hashCode() {
        int r1;
        int hashCode = this.keys.hashCode() * 31;
        KeyPathElement keyPathElement = this.resolvedElement;
        if (keyPathElement != null) {
            r1 = keyPathElement.hashCode();
        } else {
            r1 = 0;
        }
        return hashCode + r1;
    }

    public final int incrementDepthBy(int r5, String str) {
        if ("__container".equals(str)) {
            return 0;
        }
        List<String> list = this.keys;
        if (!list.get(r5).equals("**")) {
            return 1;
        }
        if (r5 == list.size() - 1 || !list.get(r5 + 1).equals(str)) {
            return 0;
        }
        return 2;
    }

    public final boolean matches(int r5, String str) {
        if ("__container".equals(str)) {
            return true;
        }
        List<String> list = this.keys;
        if (r5 >= list.size()) {
            return false;
        }
        if (list.get(r5).equals(str) || list.get(r5).equals("**") || list.get(r5).equals("*")) {
            return true;
        }
        return false;
    }

    public final boolean propagateToChildren(int r3, String str) {
        if ("__container".equals(str)) {
            return true;
        }
        List<String> list = this.keys;
        if (r3 < list.size() - 1 || list.get(r3).equals("**")) {
            return true;
        }
        return false;
    }

    public final String toString() {
        boolean z;
        StringBuilder sb = new StringBuilder("KeyPath{keys=");
        sb.append(this.keys);
        sb.append(",resolved=");
        if (this.resolvedElement != null) {
            z = true;
        } else {
            z = false;
        }
        return AnimatedContentTransitionScopeImpl$ChildData$$ExternalSyntheticOutline0.m(sb, z, '}');
    }

    public KeyPath(KeyPath keyPath) {
        this.keys = new ArrayList(keyPath.keys);
        this.resolvedElement = keyPath.resolvedElement;
    }
}
