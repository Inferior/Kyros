/**
 *
 */
package org.asd.kyros.server.delta;

import org.asd.kyros.shared.delta.IIssuingCompanyLookupService;
import org.eclipse.scout.rt.server.services.lookup.AbstractSqlLookupService;

/**
 * @author AndrewL
 */
public class IssuingCompanyLookupService extends AbstractSqlLookupService<Long> implements IIssuingCompanyLookupService {

  @Override
  protected String getConfiguredSqlSelect() {
    return "SELECT IC_ID," +
        "          IC_NAMESHORT" +
        " FROM ISSUINGCOMPANY" +
        " WHERE 1=1" +
        " <key> AND IC_ID = :key </key>" +
        " <text> AND IC_NAMESHORT LIKE :text </text>" +
        " <all> </all>";

  }
}
