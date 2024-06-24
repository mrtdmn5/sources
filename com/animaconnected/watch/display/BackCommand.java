package com.animaconnected.watch.display;

import aws.smithy.kotlin.runtime.http.engine.NoProxyHost$$ExternalSyntheticOutline0;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt__MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DrawCommand.kt */
/* loaded from: classes3.dex */
public final class BackCommand extends DrawCommand {
    private final Integer animation;
    private final int navCommand;

    public /* synthetic */ BackCommand(int r1, Integer num, int r3, DefaultConstructorMarker defaultConstructorMarker) {
        this(r1, (r3 & 2) != 0 ? null : num);
    }

    public static /* synthetic */ BackCommand copy$default(BackCommand backCommand, int r1, Integer num, int r3, Object obj) {
        if ((r3 & 1) != 0) {
            r1 = backCommand.navCommand;
        }
        if ((r3 & 2) != 0) {
            num = backCommand.animation;
        }
        return backCommand.copy(r1, num);
    }

    public final int component1() {
        return this.navCommand;
    }

    public final Integer component2() {
        return this.animation;
    }

    public final BackCommand copy(int r2, Integer num) {
        return new BackCommand(r2, num);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BackCommand)) {
            return false;
        }
        BackCommand backCommand = (BackCommand) obj;
        if (this.navCommand == backCommand.navCommand && Intrinsics.areEqual(this.animation, backCommand.animation)) {
            return true;
        }
        return false;
    }

    public final Integer getAnimation() {
        return this.animation;
    }

    public final int getNavCommand() {
        return this.navCommand;
    }

    public int hashCode() {
        int hashCode;
        int hashCode2 = Integer.hashCode(this.navCommand) * 31;
        Integer num = this.animation;
        if (num == null) {
            hashCode = 0;
        } else {
            hashCode = num.hashCode();
        }
        return hashCode2 + hashCode;
    }

    @Override // com.animaconnected.watch.display.DrawCommand
    public Map<Parameter, Object> parameters() {
        LinkedHashMap mutableMapOf = MapsKt__MapsKt.mutableMapOf(new Pair(Parameter.Type, CommandType.Back), new Pair(Parameter.Navigation, Integer.valueOf(this.navCommand)));
        Integer num = this.animation;
        if (num != null) {
            mutableMapOf.put(Parameter.Animation, num);
        }
        return mutableMapOf;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("BackCommand(navCommand=");
        sb.append(this.navCommand);
        sb.append(", animation=");
        return NoProxyHost$$ExternalSyntheticOutline0.m(sb, this.animation, ')');
    }

    public BackCommand(int r2, Integer num) {
        super(null);
        this.navCommand = r2;
        this.animation = num;
    }
}
