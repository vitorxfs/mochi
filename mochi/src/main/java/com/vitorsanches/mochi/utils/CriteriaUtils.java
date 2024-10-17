package com.vitorsanches.mochi.utils;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Root;

public class CriteriaUtils {
    public static <X> Join<X, ?> getJoin(Root<X> root, String attribute, JoinType joinType) {
        return root.getJoins().stream()
                .filter(j -> (j.getAttribute().getName().equals(attribute)) && j.getJoinType().equals(joinType))
                .findFirst()
                .orElseGet(() -> root.join(attribute, joinType));
    }
}
