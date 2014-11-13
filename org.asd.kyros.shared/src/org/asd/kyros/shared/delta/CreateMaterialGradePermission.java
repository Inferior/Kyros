/**
 * 
 */
package org.asd.kyros.shared.delta;

import java.security.BasicPermission;

/**
 * @author AndrewL
 */
public class CreateMaterialGradePermission extends BasicPermission {

  private static final long serialVersionUID = 1L;

  /**
 * 
 */
  public CreateMaterialGradePermission() {
    super("CreateMaterialGrade");
  }
}
