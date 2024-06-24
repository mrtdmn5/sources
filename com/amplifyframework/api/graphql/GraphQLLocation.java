package com.amplifyframework.api.graphql;

import androidx.constraintlayout.solver.widgets.ConstraintWidget$$ExternalSyntheticOutline0;

/* loaded from: classes.dex */
public final class GraphQLLocation {
    private int column;
    private int line;

    public GraphQLLocation(int r1, int r2) {
        this.line = r1;
        this.column = r2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || GraphQLLocation.class != obj.getClass()) {
            return false;
        }
        GraphQLLocation graphQLLocation = (GraphQLLocation) obj;
        if (this.line == graphQLLocation.line && this.column == graphQLLocation.column) {
            return true;
        }
        return false;
    }

    public int getColumn() {
        return this.column;
    }

    public int getLine() {
        return this.line;
    }

    public int hashCode() {
        return (this.line * 31) + this.column;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("GraphQLLocation{line='");
        sb.append(this.line);
        sb.append("', column='");
        return ConstraintWidget$$ExternalSyntheticOutline0.m(sb, this.column, "'}");
    }
}
