package com.animaconnected.firebase.config;

import kotlin.jvm.internal.Intrinsics;

/* compiled from: LePingReqParams.kt */
/* loaded from: classes.dex */
public final class LePingReqParams {
    private Model[] devices = new Model[0];

    /* compiled from: LePingReqParams.kt */
    /* loaded from: classes.dex */
    public static final class Model {
        private String model = "";
        private String version = "";

        public final String getModel() {
            return this.model;
        }

        public final String getVersion() {
            return this.version;
        }

        public final void setModel(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.model = str;
        }

        public final void setVersion(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.version = str;
        }
    }

    public final Model[] getDevices() {
        return this.devices;
    }

    public final void setDevices(Model[] modelArr) {
        Intrinsics.checkNotNullParameter(modelArr, "<set-?>");
        this.devices = modelArr;
    }
}
