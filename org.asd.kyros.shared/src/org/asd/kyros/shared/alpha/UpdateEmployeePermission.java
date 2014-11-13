/**
 * 
 */
package org.asd.kyros.shared.alpha;

import java.security.BasicPermission;

/**
 * @author AndrewL
 */
public class UpdateEmployeePermission extends BasicPermission {

  private static final long serialVersionUID = 1L;

  /**
 * 
 */
  public UpdateEmployeePermission() {
    super("UpdateEmployee");
  }
}
