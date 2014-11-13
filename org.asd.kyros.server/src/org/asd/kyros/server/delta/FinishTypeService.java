/**
 *
 */
package org.asd.kyros.server.delta;

import org.asd.kyros.shared.delta.CreateFinishTypePermission;
import org.asd.kyros.shared.delta.FinishTypeFormData;
import org.asd.kyros.shared.delta.IFinishTypeService;
import org.asd.kyros.shared.delta.ReadFinishTypePermission;
import org.asd.kyros.shared.delta.UpdateFinishTypePermission;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.commons.exception.VetoException;
import org.eclipse.scout.rt.server.services.common.jdbc.SQL;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.security.ACCESS;
import org.eclipse.scout.service.AbstractService;

/**
 * @author AndrewL
 */
public class FinishTypeService extends AbstractService implements IFinishTypeService {

  @Override
  public FinishTypeFormData create(FinishTypeFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreateFinishTypePermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    SQL.insert("" +
        "INSERT INTO FINISHTYPE (FT_NAME, FT_GENERAL) " +
        "VALUES (:processName, :generalDescription)", formData);
    return formData;
  }

  @Override
  public FinishTypeFormData load(FinishTypeFormData formData) throws ProcessingException {
    if (!ACCESS.check(new ReadFinishTypePermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }

  @Override
  public FinishTypeFormData prepareCreate(FinishTypeFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreateFinishTypePermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }

  @Override
  public FinishTypeFormData store(FinishTypeFormData formData) throws ProcessingException {
    if (!ACCESS.check(new UpdateFinishTypePermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }
}
