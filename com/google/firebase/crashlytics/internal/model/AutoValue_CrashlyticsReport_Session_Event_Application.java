package com.google.firebase.crashlytics.internal.model;

import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_Event_Application extends CrashlyticsReport.Session.Event.Application {
    public final Boolean background;
    public final ImmutableList<CrashlyticsReport.CustomAttribute> customAttributes;
    public final CrashlyticsReport.Session.Event.Application.Execution execution;
    public final ImmutableList<CrashlyticsReport.CustomAttribute> internalKeys;
    public final int uiOrientation;

    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Builder {
        public Boolean background;
        public ImmutableList<CrashlyticsReport.CustomAttribute> customAttributes;
        public CrashlyticsReport.Session.Event.Application.Execution execution;
        public ImmutableList<CrashlyticsReport.CustomAttribute> internalKeys;
        public Integer uiOrientation;

        public Builder(CrashlyticsReport.Session.Event.Application application) {
            this.execution = application.getExecution();
            this.customAttributes = application.getCustomAttributes();
            this.internalKeys = application.getInternalKeys();
            this.background = application.getBackground();
            this.uiOrientation = Integer.valueOf(application.getUiOrientation());
        }

        public final AutoValue_CrashlyticsReport_Session_Event_Application build() {
            String str;
            if (this.execution == null) {
                str = " execution";
            } else {
                str = "";
            }
            if (this.uiOrientation == null) {
                str = str.concat(" uiOrientation");
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application(this.execution, this.customAttributes, this.internalKeys, this.background, this.uiOrientation.intValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }
    }

    public AutoValue_CrashlyticsReport_Session_Event_Application() {
        throw null;
    }

    public AutoValue_CrashlyticsReport_Session_Event_Application(CrashlyticsReport.Session.Event.Application.Execution execution, ImmutableList immutableList, ImmutableList immutableList2, Boolean bool, int r5) {
        this.execution = execution;
        this.customAttributes = immutableList;
        this.internalKeys = immutableList2;
        this.background = bool;
        this.uiOrientation = r5;
    }

    public final boolean equals(Object obj) {
        ImmutableList<CrashlyticsReport.CustomAttribute> immutableList;
        ImmutableList<CrashlyticsReport.CustomAttribute> immutableList2;
        Boolean bool;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application application = (CrashlyticsReport.Session.Event.Application) obj;
        if (this.execution.equals(application.getExecution()) && ((immutableList = this.customAttributes) != null ? immutableList.equals(application.getCustomAttributes()) : application.getCustomAttributes() == null) && ((immutableList2 = this.internalKeys) != null ? immutableList2.equals(application.getInternalKeys()) : application.getInternalKeys() == null) && ((bool = this.background) != null ? bool.equals(application.getBackground()) : application.getBackground() == null) && this.uiOrientation == application.getUiOrientation()) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public final Boolean getBackground() {
        return this.background;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public final ImmutableList<CrashlyticsReport.CustomAttribute> getCustomAttributes() {
        return this.customAttributes;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public final CrashlyticsReport.Session.Event.Application.Execution getExecution() {
        return this.execution;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public final ImmutableList<CrashlyticsReport.CustomAttribute> getInternalKeys() {
        return this.internalKeys;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public final int getUiOrientation() {
        return this.uiOrientation;
    }

    public final int hashCode() {
        int hashCode;
        int hashCode2;
        int hashCode3 = (this.execution.hashCode() ^ 1000003) * 1000003;
        int r2 = 0;
        ImmutableList<CrashlyticsReport.CustomAttribute> immutableList = this.customAttributes;
        if (immutableList == null) {
            hashCode = 0;
        } else {
            hashCode = immutableList.hashCode();
        }
        int r0 = (hashCode3 ^ hashCode) * 1000003;
        ImmutableList<CrashlyticsReport.CustomAttribute> immutableList2 = this.internalKeys;
        if (immutableList2 == null) {
            hashCode2 = 0;
        } else {
            hashCode2 = immutableList2.hashCode();
        }
        int r02 = (r0 ^ hashCode2) * 1000003;
        Boolean bool = this.background;
        if (bool != null) {
            r2 = bool.hashCode();
        }
        return ((r02 ^ r2) * 1000003) ^ this.uiOrientation;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application
    public final Builder toBuilder() {
        return new Builder(this);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Application{execution=");
        sb.append(this.execution);
        sb.append(", customAttributes=");
        sb.append(this.customAttributes);
        sb.append(", internalKeys=");
        sb.append(this.internalKeys);
        sb.append(", background=");
        sb.append(this.background);
        sb.append(", uiOrientation=");
        return ConstraintWidget$$ExternalSyntheticOutline0.m(sb, this.uiOrientation, "}");
    }
}
