package com.google.firebase.components;

import androidx.activity.ComponentActivity$2$$ExternalSyntheticOutline0;
import androidx.appcompat.view.menu.SubMenuBuilder$$ExternalSyntheticOutline0;

/* loaded from: classes3.dex */
public final class Dependency {
    public final Qualified<?> anInterface;
    public final int injection;
    public final int type;

    public Dependency(int r1, int r2, Class cls) {
        this((Qualified<?>) Qualified.unqualified(cls), r1, r2);
    }

    public static Dependency required(Class<?> cls) {
        return new Dependency(1, 0, cls);
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Dependency)) {
            return false;
        }
        Dependency dependency = (Dependency) obj;
        if (!this.anInterface.equals(dependency.anInterface) || this.type != dependency.type || this.injection != dependency.injection) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return ((((this.anInterface.hashCode() ^ 1000003) * 1000003) ^ this.type) * 1000003) ^ this.injection;
    }

    public final String toString() {
        String str;
        String str2;
        StringBuilder sb = new StringBuilder("Dependency{anInterface=");
        sb.append(this.anInterface);
        sb.append(", type=");
        int r1 = this.type;
        if (r1 == 1) {
            str = "required";
        } else if (r1 == 0) {
            str = "optional";
        } else {
            str = "set";
        }
        sb.append(str);
        sb.append(", injection=");
        int r12 = this.injection;
        if (r12 != 0) {
            if (r12 != 1) {
                if (r12 == 2) {
                    str2 = "deferred";
                } else {
                    throw new AssertionError(SubMenuBuilder$$ExternalSyntheticOutline0.m("Unsupported injection: ", r12));
                }
            } else {
                str2 = "provider";
            }
        } else {
            str2 = "direct";
        }
        return ComponentActivity$2$$ExternalSyntheticOutline0.m(sb, str2, "}");
    }

    public Dependency(Qualified<?> qualified, int r2, int r3) {
        this.anInterface = qualified;
        this.type = r2;
        this.injection = r3;
    }
}
