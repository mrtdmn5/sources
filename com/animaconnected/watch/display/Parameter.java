package com.animaconnected.watch.display;

import com.amazonaws.auth.policy.internal.JsonDocumentFields;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* JADX WARN: Unknown enum class pattern. Please report as an issue! */
/* compiled from: DrawCommand.kt */
/* loaded from: classes3.dex */
public final class Parameter {
    private static final /* synthetic */ EnumEntries $ENTRIES;
    private static final /* synthetic */ Parameter[] $VALUES;
    private final int id;
    public static final Parameter Unknown = new Parameter("Unknown", 0, 0);
    public static final Parameter Type = new Parameter("Type", 1, 1);
    public static final Parameter Id = new Parameter(JsonDocumentFields.POLICY_ID, 2, 2);
    public static final Parameter X = new Parameter("X", 3, 3);
    public static final Parameter Y = new Parameter("Y", 4, 4);
    public static final Parameter X2 = new Parameter("X2", 5, 5);
    public static final Parameter Y2 = new Parameter("Y2", 6, 6);
    public static final Parameter Width = new Parameter("Width", 7, 7);
    public static final Parameter Height = new Parameter("Height", 8, 8);
    public static final Parameter Navigation = new Parameter("Navigation", 9, 9);
    public static final Parameter Animation = new Parameter("Animation", 10, 10);
    public static final Parameter Color = new Parameter("Color", 11, 11);
    public static final Parameter Thickness = new Parameter("Thickness", 12, 12);
    public static final Parameter Font = new Parameter("Font", 13, 13);
    public static final Parameter Opacity = new Parameter("Opacity", 14, 14);
    public static final Parameter Data = new Parameter("Data", 15, 15);
    public static final Parameter HID = new Parameter("HID", 16, 16);

    private static final /* synthetic */ Parameter[] $values() {
        return new Parameter[]{Unknown, Type, Id, X, Y, X2, Y2, Width, Height, Navigation, Animation, Color, Thickness, Font, Opacity, Data, HID};
    }

    static {
        Parameter[] $values = $values();
        $VALUES = $values;
        $ENTRIES = EnumEntriesKt.enumEntries($values);
    }

    private Parameter(String str, int r2, int r3) {
        this.id = r3;
    }

    public static EnumEntries<Parameter> getEntries() {
        return $ENTRIES;
    }

    public static Parameter valueOf(String str) {
        return (Parameter) Enum.valueOf(Parameter.class, str);
    }

    public static Parameter[] values() {
        return (Parameter[]) $VALUES.clone();
    }

    public final int getId() {
        return this.id;
    }
}
