package com.amazonaws.services.s3.model;

import androidx.constraintlayout.solver.PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0;
import java.io.Serializable;

/* loaded from: classes.dex */
public class BucketLoggingConfiguration implements Serializable {
    private String destinationBucketName = null;
    private String logFilePrefix = null;

    public BucketLoggingConfiguration() {
    }

    public String getDestinationBucketName() {
        return this.destinationBucketName;
    }

    public String getLogFilePrefix() {
        return this.logFilePrefix;
    }

    public boolean isLoggingEnabled() {
        if (this.destinationBucketName != null && this.logFilePrefix != null) {
            return true;
        }
        return false;
    }

    public void setDestinationBucketName(String str) {
        this.destinationBucketName = str;
    }

    public void setLogFilePrefix(String str) {
        if (str == null) {
            str = "";
        }
        this.logFilePrefix = str;
    }

    public String toString() {
        String str = "LoggingConfiguration enabled=" + isLoggingEnabled();
        if (isLoggingEnabled()) {
            StringBuilder m = PriorityGoalRow$GoalVariableAccessor$$ExternalSyntheticOutline0.m(str, ", destinationBucketName=");
            m.append(getDestinationBucketName());
            m.append(", logFilePrefix=");
            m.append(getLogFilePrefix());
            return m.toString();
        }
        return str;
    }

    public BucketLoggingConfiguration(String str, String str2) {
        setLogFilePrefix(str2);
        setDestinationBucketName(str);
    }
}
