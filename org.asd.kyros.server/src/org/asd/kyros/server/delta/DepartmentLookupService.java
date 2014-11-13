/**
 *
 */
package org.asd.kyros.server.delta;

import org.asd.kyros.shared.delta.IDepartmentLookupService;
import org.eclipse.scout.rt.server.services.lookup.AbstractSqlLookupService;

/**
 * @author AndrewL
 */
public class DepartmentLookupService extends AbstractSqlLookupService<Long> implements IDepartmentLookupService {

  @Override
  protected String getConfiguredSqlSelect() {
    return "SELECT DPT_ID," +
        "          DPT_NAME" +
        " FROM DEPARTMENT" +
        " WHERE 1=1" +
        " <key> AND DPT_ID = :key </key>" +
        " <text> AND DPT_NAME LIKE :text </text>" +
        " <all> </all>";

  }
}
