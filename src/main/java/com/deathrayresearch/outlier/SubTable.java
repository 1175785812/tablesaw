package com.deathrayresearch.outlier;

import com.deathrayresearch.outlier.columns.*;

import java.util.List;

/**
 * A specialization of the standard Table used for tables formed by grouping operations on a
 * Table
 */
class SubTable extends Table {

  /** The values that will be summarized on */
  private List<String> values;

  /**
   * Returns a new SubTable from the given table that will include summaries for the given values
   *
   * @param original  The table from which this one was derived
   */
  public SubTable(Table original) {
    super(original.name(),
        original.emptyCopy().columns().toArray(new Column[original.columnCount()]));
  }

  public List<String> getValues() {
    return values;
  }

  public void setValues(List<String> values) {
    this.values = values;
  }

  public void addRow(int rowIndex, Table sourceTable) {
    for (int i = 0; i < columnCount(); i++) {
      Column column = column(i);
      ColumnType type = column.type();
      switch (type) {
        case FLOAT :
          FloatColumn floatColumn = (FloatColumn) column;
          floatColumn.add(sourceTable.floatColumn(i).get(rowIndex));
          break;
        case INTEGER:
          IntColumn intColumn = (IntColumn) column;
          intColumn.add(sourceTable.intColumn(i).get(rowIndex));
          break;
        case SHORT_INT:
          ShortColumn shortColumn = (ShortColumn) column;
          shortColumn.add(sourceTable.shortColumn(i).get(rowIndex));
          break;
        case LONG_INT:
          LongColumn longColumn = (LongColumn) column;
          longColumn.add(sourceTable.longColumn(i).get(rowIndex));
          break;
        case BOOLEAN:
          BooleanColumn booleanColumn = (BooleanColumn) column;
          booleanColumn.add(sourceTable.booleanColumn(i).get(rowIndex));
          break;
        case LOCAL_DATE:
          LocalDateColumn localDateColumn = (LocalDateColumn) column;
          localDateColumn.add(sourceTable.localDateColumn(i).getInt(rowIndex));
          break;
        case LOCAL_TIME:
          LocalTimeColumn localTimeColumn = (LocalTimeColumn) column;
          localTimeColumn.add(sourceTable.localTimeColumn(i).getInt(rowIndex));
          break;
        case LOCAL_DATE_TIME:
          LocalDateTimeColumn localDateTimeColumn = (LocalDateTimeColumn) column;
          localDateTimeColumn.add(sourceTable.localDateTimeColumn(i).getLong(rowIndex));
          break;
        case CAT:
          CategoryColumn categoryColumn = (CategoryColumn) column;
          categoryColumn.add(sourceTable.categoryColumn(i).get(rowIndex));
          break;
        default:
          throw new RuntimeException("Unhandled column type updating columns");
      }
    }
  }
}
