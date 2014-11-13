/**
 *
 */
package org.asd.kyros.server.delta;

import org.asd.kyros.shared.delta.IProcessTypeLookupService;
import org.eclipse.scout.rt.server.services.lookup.AbstractSqlLookupService;

/**
 * @author AndrewL
 */
public class ProcessTypeLookupService extends AbstractSqlLookupService<Long> implements IProcessTypeLookupService {

  @Override
  protected String getConfiguredSqlSelect() {
    return "SELECT FT_ID," +
        "          FT_NAME" +
        " FROM FINISHTYPE" +
        " WHERE 1=1" +
        " <key> AND FT_ID = :key </key>" +
        " <text> AND FT_NAME LIKE :text </text>" +
        " <all> </all>";

  }
}
