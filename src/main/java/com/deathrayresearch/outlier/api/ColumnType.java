package com.deathrayresearch.outlier.api;


import com.deathrayresearch.outlier.columns.Column;

/**
 * Defines the type of data held by a {@link Column}
 */
public enum ColumnType {

  BOOLEAN(false),
  CAT(""),
  FLOAT(Float.NaN),
  SHORT_INT(Short.MIN_VALUE),
  INTEGER(Integer.MIN_VALUE),
  LONG_INT(Long.MIN_VALUE),
  LOCAL_DATE(Integer.MIN_VALUE),
  LOCAL_DATE_TIME(Long.MIN_VALUE),
  LOCAL_TIME(-1),
  DURATION(Long.MIN_VALUE),
  SKIP(null);

  private final Comparable missingValue;

  ColumnType(
      Comparable missingValue) {
    this.missingValue = missingValue;
  }

  public Comparable getMissingValue() {
    return missingValue;
  }
}
