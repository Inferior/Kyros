/**
 *
 */
package org.asd.kyros.server.delta;

import org.asd.kyros.shared.delta.IMaterialTypeLookupService;
import org.eclipse.scout.rt.server.services.lookup.AbstractSqlLookupService;

/**
 * @author AndrewL
 */
public class MaterialTypeLookupService extends AbstractSqlLookupService<Long> implements IMaterialTypeLookupService {

  @Override
  protected String getConfiguredSqlSelect() {
    return "SELECT MT_ID," +
        "          MT_NAME" +
        " FROM MATERIALTYPE" +
        " WHERE 1=1" +
        " <key> AND MT_ID = :key </key>" +
        " <text> AND MT_NAME LIKE :text </text>" +
        " <all> </all>";

  }
}
