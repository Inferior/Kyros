/**
 *
 */
package org.asd.kyros.server.delta;

import org.asd.kyros.shared.delta.IDivisionFromCompanyLookupService;
import org.eclipse.scout.rt.server.services.lookup.AbstractSqlLookupService;

/**
 * @author AndrewL
 */
public class DivisionFromCompanyLookupService extends AbstractSqlLookupService<Long> implements IDivisionFromCompanyLookupService {

  @Override
  protected String getConfiguredSqlSelect() {
    return "SELECT DIVISION_ID," +
        "          DIVISION_NAME" +
        " FROM DIVISION" +
        " WHERE 1=1" +
        " AND COMPANY_COMPANY_ID = :master" +
        " <key> AND DIVISION_ID = :key </key>" +
        " <text> AND DIVISION_NAME LIKE :text </text>" +
        " <all> </all>";

  }
}
