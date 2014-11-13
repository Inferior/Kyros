/**
 * 
 */
package org.asd.kyros.server.services.common.sql;

import com.bsiag.scout.rt.server.jdbc.AbstractMySqlSqlService;

/**
 * @author AndrewL
 */
public class DevelopmentSqlService extends AbstractMySqlSqlService {

  @Override
  protected String getConfiguredJdbcMappingName() {
    return "jdbc:mysql://localhost:3306/kyrosdb";
  }

  @Override
  protected String getConfiguredPassword() {
    return "shogun67";
  }

  @Override
  protected String getConfiguredUsername() {
    return "root";
  }
}
