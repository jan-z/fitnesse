// Copyright (C) 2003-2009 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the CPL Common Public License version 1.0.
package fitnesse.testsystems.slim.tables;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import fitnesse.testsystems.slim.SlimTestContext;
import fitnesse.testsystems.slim.Table;
import fitnesse.testsystems.slim.responses.Response;

public class SlimErrorTable extends SlimTable {
  public SlimErrorTable(Table table, String id, SlimTestContext testContext) {
    super(table, id, testContext);
  }

  protected String getTableType() {
    return "UnknownTableType";
  }

  public List<Object> getInstructions() {
    return Collections.emptyList();
  }

  public void evaluateExpectations(Map<String, Object> returnValues) {
    String tableType = table.getCellContents(0, 0);
    Response errorMessage = fail(String.format("\"%s\" is not a valid table type.", tableType));
    table.setCell(0, 0, errorMessage);
  }

  public void evaluateReturnValues(Map<String, Object> returnValues) {
  }
}