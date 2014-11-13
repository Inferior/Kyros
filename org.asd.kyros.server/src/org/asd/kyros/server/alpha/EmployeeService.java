/**
 *
 */
package org.asd.kyros.server.alpha;

import org.asd.kyros.shared.alpha.CreateEmployeePermission;
import org.asd.kyros.shared.alpha.EmployeeFormData;
import org.asd.kyros.shared.alpha.IEmployeeService;
import org.asd.kyros.shared.alpha.ReadEmployeePermission;
import org.asd.kyros.shared.alpha.UpdateEmployeePermission;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.commons.exception.VetoException;
import org.eclipse.scout.rt.server.services.common.jdbc.SQL;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.security.ACCESS;
import org.eclipse.scout.service.AbstractService;

/**
 * @author AndrewL
 */
public class EmployeeService extends AbstractService implements IEmployeeService {

  @Override
  public EmployeeFormData create(EmployeeFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreateEmployeePermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    SQL.insert("" +
        "INSERT INTO EMPLOYEE (EMP_FIRST, EMP_LAST, EMP_EMAIL, EMP_EXTENSION, DEPARTMENT_DPT_ID) " +
        "VALUES (:firstName, :lastName, :email, :extension, :department)", formData);
    return formData;
  }

  @Override
  public EmployeeFormData load(EmployeeFormData formData) throws ProcessingException {
    if (!ACCESS.check(new ReadEmployeePermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }

  @Override
  public EmployeeFormData prepareCreate(EmployeeFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreateEmployeePermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }

  @Override
  public EmployeeFormData store(EmployeeFormData formData) throws ProcessingException {
    if (!ACCESS.check(new UpdateEmployeePermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }
}
