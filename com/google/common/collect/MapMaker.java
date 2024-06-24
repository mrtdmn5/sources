package com.google.common.collect;

import com.google.common.base.MoreObjects$ToStringHelper;
import com.google.common.collect.MapMakerInternalMap;

/* loaded from: classes3.dex */
public final class MapMaker {
    public MapMakerInternalMap.Strength keyStrength;
    public boolean useCustomMap;

    public final MapMakerInternalMap.Strength getKeyStrength() {
        MapMakerInternalMap.Strength strength = this.keyStrength;
        MapMakerInternalMap.Strength strength2 = MapMakerInternalMap.Strength.STRONG;
        if (strength == null) {
            if (strength2 != null) {
                return strength2;
            }
            throw new NullPointerException("Both parameters are null");
        }
        return strength;
    }

    public final String toString() {
        boolean z;
        boolean z2;
        MoreObjects$ToStringHelper moreObjects$ToStringHelper = new MoreObjects$ToStringHelper("MapMaker");
        MapMakerInternalMap.Strength strength = this.keyStrength;
        if (strength != null) {
            String obj = strength.toString();
            int length = obj.length();
            int r4 = 0;
            while (true) {
                if (r4 >= length) {
                    break;
                }
                char charAt = obj.charAt(r4);
                if (charAt >= 'A' && charAt <= 'Z') {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    char[] charArray = obj.toCharArray();
                    while (r4 < length) {
                        char c = charArray[r4];
                        if (c >= 'A' && c <= 'Z') {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (z2) {
                            charArray[r4] = (char) (c ^ ' ');
                        }
                        r4++;
                    }
                    obj = String.valueOf(charArray);
                } else {
                    r4++;
                }
            }
            MoreObjects$ToStringHelper.ValueHolder valueHolder = new MoreObjects$ToStringHelper.ValueHolder();
            moreObjects$ToStringHelper.holderTail.next = valueHolder;
            moreObjects$ToStringHelper.holderTail = valueHolder;
            valueHolder.value = obj;
            valueHolder.name = "keyStrength";
        }
        return moreObjects$ToStringHelper.toString();
    }
}
