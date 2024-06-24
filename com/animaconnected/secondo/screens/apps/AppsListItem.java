package com.animaconnected.secondo.screens.apps;

import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* compiled from: WatchAppViewHolder.kt */
/* loaded from: classes3.dex */
public interface AppsListItem {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: WatchAppViewHolder.kt */
    /* loaded from: classes3.dex */
    public static final class Type {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ Type[] $VALUES;
        public static final Type App = new Type("App", 0);
        public static final Type Text = new Type("Text", 1);

        private static final /* synthetic */ Type[] $values() {
            return new Type[]{App, Text};
        }

        static {
            Type[] $values = $values();
            $VALUES = $values;
            $ENTRIES = EnumEntriesKt.enumEntries($values);
        }

        private Type(String str, int r2) {
        }

        public static EnumEntries<Type> getEntries() {
            return $ENTRIES;
        }

        public static Type valueOf(String str) {
            return (Type) Enum.valueOf(Type.class, str);
        }

        public static Type[] values() {
            return (Type[]) $VALUES.clone();
        }
    }

    Type getItemType();
}
