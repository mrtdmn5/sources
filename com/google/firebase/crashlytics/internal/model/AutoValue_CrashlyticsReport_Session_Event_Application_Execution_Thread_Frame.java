package com.google.firebase.crashlytics.internal.model;

import androidx.compose.ui.tooling.ComposableInvoker$$ExternalSyntheticOutline0;
import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;

/* loaded from: classes3.dex */
public final class AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame {
    public final String file;
    public final int importance;
    public final long offset;
    public final long pc;
    public final String symbol;

    /* loaded from: classes3.dex */
    public static final class Builder extends CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder {
        public String file;
        public Integer importance;
        public Long offset;
        public Long pc;
        public String symbol;

        public final AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame build() {
            String str;
            if (this.pc == null) {
                str = " pc";
            } else {
                str = "";
            }
            if (this.symbol == null) {
                str = str.concat(" symbol");
            }
            if (this.offset == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " offset");
            }
            if (this.importance == null) {
                str = ComposableInvoker$$ExternalSyntheticOutline0.m(str, " importance");
            }
            if (str.isEmpty()) {
                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(this.pc.longValue(), this.symbol, this.file, this.offset.longValue(), this.importance.intValue());
            }
            throw new IllegalStateException("Missing required properties:".concat(str));
        }
    }

    public AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame(long j, String str, String str2, long j2, int r7) {
        this.pc = j;
        this.symbol = str;
        this.file = str2;
        this.offset = j2;
        this.importance = r7;
    }

    public final boolean equals(Object obj) {
        String str;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame)) {
            return false;
        }
        CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame frame = (CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame) obj;
        if (this.pc == frame.getPc() && this.symbol.equals(frame.getSymbol()) && ((str = this.file) != null ? str.equals(frame.getFile()) : frame.getFile() == null) && this.offset == frame.getOffset() && this.importance == frame.getImportance()) {
            return true;
        }
        return false;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
    public final String getFile() {
        return this.file;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
    public final int getImportance() {
        return this.importance;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
    public final long getOffset() {
        return this.offset;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
    public final long getPc() {
        return this.pc;
    }

    @Override // com.google.firebase.crashlytics.internal.model.CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame
    public final String getSymbol() {
        return this.symbol;
    }

    public final int hashCode() {
        int hashCode;
        long j = this.pc;
        int hashCode2 = (((((int) (j ^ (j >>> 32))) ^ 1000003) * 1000003) ^ this.symbol.hashCode()) * 1000003;
        String str = this.file;
        if (str == null) {
            hashCode = 0;
        } else {
            hashCode = str.hashCode();
        }
        int r0 = (hashCode2 ^ hashCode) * 1000003;
        long j2 = this.offset;
        return ((r0 ^ ((int) ((j2 >>> 32) ^ j2))) * 1000003) ^ this.importance;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Frame{pc=");
        sb.append(this.pc);
        sb.append(", symbol=");
        sb.append(this.symbol);
        sb.append(", file=");
        sb.append(this.file);
        sb.append(", offset=");
        sb.append(this.offset);
        sb.append(", importance=");
        return ConstraintWidget$$ExternalSyntheticOutline0.m(sb, this.importance, "}");
    }
}
