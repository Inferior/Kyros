/**
 *
 */
package org.asd.kyros.server.alpha;

import org.asd.kyros.shared.alpha.CreatePartPermission;
import org.asd.kyros.shared.alpha.IPartService;
import org.asd.kyros.shared.alpha.PartFormData;
import org.asd.kyros.shared.alpha.ReadPartPermission;
import org.asd.kyros.shared.alpha.UpdatePartPermission;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.commons.exception.VetoException;
import org.eclipse.scout.rt.server.services.common.jdbc.SQL;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.security.ACCESS;
import org.eclipse.scout.service.AbstractService;

/**
 * @author AndrewL
 */
public class PartService extends AbstractService implements IPartService {

  @Override
  public PartFormData create(PartFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreatePartPermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    SQL.insert("" +
        "INSERT INTO PART (PART_NUMBER, PART_NAME, PART_SEARCHWORD, PART_QUOTEONLY, COMPANY_COMPANY_ID) " +
        "VALUES (:partNumber, :name, :searchWord, :forQuoteOnly, :company)", formData);
    return formData;
  }

  @Override
  public PartFormData load(PartFormData formData) throws ProcessingException {
    if (!ACCESS.check(new ReadPartPermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }

  @Override
  public PartFormData prepareCreate(PartFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreatePartPermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }

  @Override
  public PartFormData store(PartFormData formData) throws ProcessingException {
    if (!ACCESS.check(new UpdatePartPermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }
}
