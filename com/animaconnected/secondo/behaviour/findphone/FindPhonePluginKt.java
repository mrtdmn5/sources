package com.animaconnected.secondo.behaviour.findphone;

import com.animaconnected.watch.behaviour.interfaces.Music;
import com.kronaby.watch.app.R;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FindPhonePlugin.kt */
/* loaded from: classes3.dex */
public final class FindPhonePluginKt {

    /* compiled from: FindPhonePlugin.kt */
    /* loaded from: classes3.dex */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] r0 = new int[Music.values().length];
            try {
                r0[Music.Discrete.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                r0[Music.Normal.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                r0[Music.NotSet.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                r0[Music.Loud.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                r0[Music.Upbeat.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                r0[Music.Christmas.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = r0;
        }
    }

    public static final int getResource(Music music) {
        Intrinsics.checkNotNullParameter(music, "<this>");
        switch (WhenMappings.$EnumSwitchMapping$0[music.ordinal()]) {
            case 1:
                return R.string.find_phone_sound_discrete;
            case 2:
            case 3:
                return R.string.find_phone_sound_normal;
            case 4:
                return R.string.find_phone_sound_loud;
            case 5:
                return R.string.find_phone_sound_upbeat;
            case 6:
                return R.string.find_phone_sound_christmas;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }
}
