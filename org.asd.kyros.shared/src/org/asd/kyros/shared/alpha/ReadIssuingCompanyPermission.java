/**
 * 
 */
package org.asd.kyros.shared.alpha;

import java.security.BasicPermission;

/**
 * @author AndrewL
 */
public class ReadIssuingCompanyPermission extends BasicPermission {

  private static final long serialVersionUID = 1L;

  /**
 * 
 */
  public ReadIssuingCompanyPermission() {
    super("ReadIssuingCompany");
  }
}
