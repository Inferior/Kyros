/**
 *
 */
package org.asd.kyros.server.alpha;

import org.asd.kyros.shared.alpha.CreateDivisionPermission;
import org.asd.kyros.shared.alpha.DivisionFormData;
import org.asd.kyros.shared.alpha.IDivisionService;
import org.asd.kyros.shared.alpha.ReadDivisionPermission;
import org.asd.kyros.shared.alpha.UpdateDivisionPermission;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.commons.exception.VetoException;
import org.eclipse.scout.rt.server.services.common.jdbc.SQL;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.security.ACCESS;
import org.eclipse.scout.service.AbstractService;

/**
 * @author AndrewL
 */
public class DivisionService extends AbstractService implements IDivisionService {

  @Override
  public DivisionFormData create(DivisionFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreateDivisionPermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    SQL.insert("" +
        "INSERT INTO DIVISION (DIVISION_NAME, DIVISION_CAGECODE, COMPANY_COMPANY_ID) " +
        "VALUES (:name, :cageCode, :company)", formData);
    return formData;
  }

  @Override
  public DivisionFormData load(DivisionFormData formData) throws ProcessingException {
    if (!ACCESS.check(new ReadDivisionPermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }

  @Override
  public DivisionFormData prepareCreate(DivisionFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreateDivisionPermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }

  @Override
  public DivisionFormData store(DivisionFormData formData) throws ProcessingException {
    if (!ACCESS.check(new UpdateDivisionPermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }
}