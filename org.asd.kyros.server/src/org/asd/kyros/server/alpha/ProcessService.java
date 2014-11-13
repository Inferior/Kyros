/**
 *
 */
package org.asd.kyros.server.alpha;

import org.asd.kyros.shared.alpha.CreateProcessPermission;
import org.asd.kyros.shared.alpha.IProcessService;
import org.asd.kyros.shared.alpha.ProcessFormData;
import org.asd.kyros.shared.alpha.ReadProcessPermission;
import org.asd.kyros.shared.alpha.UpdateProcessPermission;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.commons.exception.VetoException;
import org.eclipse.scout.rt.server.services.common.jdbc.SQL;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.security.ACCESS;
import org.eclipse.scout.service.AbstractService;

/**
 * @author AndrewL
 */
public class ProcessService extends AbstractService implements IProcessService {

  @Override
  public ProcessFormData create(ProcessFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreateProcessPermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    SQL.insert("" +
        "INSERT INTO PROCESS (PROCESS_NAME, PROCESS_COMMON, PROCESS_LEADTIME, PROCESS_BUILDUP, FINISHTYPE_FT_ID) " +
        "VALUES (:processName, :commonName, :leadTimeDays, :buildUpPerSide, :processType)", formData);
    return formData;
  }

  @Override
  public ProcessFormData load(ProcessFormData formData) throws ProcessingException {
    if (!ACCESS.check(new ReadProcessPermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }

  @Override
  public ProcessFormData prepareCreate(ProcessFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreateProcessPermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }

  @Override
  public ProcessFormData store(ProcessFormData formData) throws ProcessingException {
    if (!ACCESS.check(new UpdateProcessPermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }
}
