package com.deathrayresearch.outlier.api;

import com.deathrayresearch.outlier.columns.ColumnReference;
import com.deathrayresearch.outlier.filter.AllOf;
import com.deathrayresearch.outlier.filter.AnyOf;
import com.deathrayresearch.outlier.filter.Filter;
import com.deathrayresearch.outlier.filter.IsFalse;
import com.deathrayresearch.outlier.filter.IsTrue;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * A static utility class designed to take some of the work, and verbosity, out of making queries
 */
public class QueryHelper {

  /**
   * Returns a column reference for a column with the given name. It will be resolved at query time by associating
   * it with a table. At construction time, the columnType it will resolve to is unknown.
   */
  public static ColumnReference column(String columnName) {
    return new ColumnReference(columnName);
  }

  public static Filter both(Filter a, Filter b) {
    List<Filter> filterList = new ArrayList<>();
    filterList.add(a);
    filterList.add(b);
    return AllOf.allOf(filterList);
  }

  public static Filter allOf(Filter... filters) {
    return AllOf.allOf(filters);
  }

  public static Filter allOf(Collection<Filter> filters) {
    return AllOf.allOf(filters);
  }

  public static Filter and(Filter... filters) {
    return AllOf.allOf(filters);
  }

  public static Filter and(Collection<Filter> filters) {
    return AllOf.allOf(filters);
  }

  public static Filter not(Filter filter) {
    return IsFalse.isFalse(filter);
  }

  public static Filter isFalse(Filter filter) {
    return IsFalse.isFalse(filter);
  }

  public static Filter isTrue(Filter filter) {
    return IsTrue.isTrue(filter);
  }

  public static Filter either(Filter a, Filter b) {
    List<Filter> filterList = new ArrayList<>();
    filterList.add(a);
    filterList.add(b);
    return AnyOf.anyOf(filterList);
  }

  public static Filter anyOf(Filter... filters) {
    return AnyOf.anyOf(filters);
  }

  public static Filter anyOf(Collection<Filter> filters) {
    return AnyOf.anyOf(filters);
  }

  public static Filter or(Filter... filters) {
    return AnyOf.anyOf(filters);
  }

  public static Filter or(Collection<Filter> filters) {
    return AnyOf.anyOf(filters);
  }
}
