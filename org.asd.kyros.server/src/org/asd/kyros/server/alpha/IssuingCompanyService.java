/**
 *
 */
package org.asd.kyros.server.alpha;

import org.asd.kyros.shared.alpha.CreateIssuingCompanyPermission;
import org.asd.kyros.shared.alpha.IIssuingCompanyService;
import org.asd.kyros.shared.alpha.IssuingCompanyFormData;
import org.asd.kyros.shared.alpha.ReadIssuingCompanyPermission;
import org.asd.kyros.shared.alpha.UpdateIssuingCompanyPermission;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.commons.exception.VetoException;
import org.eclipse.scout.rt.server.services.common.jdbc.SQL;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.security.ACCESS;
import org.eclipse.scout.service.AbstractService;

/**
 * @author AndrewL
 */
public class IssuingCompanyService extends AbstractService implements IIssuingCompanyService {

  @Override
  public IssuingCompanyFormData create(IssuingCompanyFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreateIssuingCompanyPermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    SQL.insert("" +
        "INSERT INTO ISSUINGCOMPANY (IC_NAMELONG, IC_NAMESHORT) " +
        "VALUES (:name, :abbreviation)", formData);
    return formData;
  }

  @Override
  public IssuingCompanyFormData load(IssuingCompanyFormData formData) throws ProcessingException {
    if (!ACCESS.check(new ReadIssuingCompanyPermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }

  @Override
  public IssuingCompanyFormData prepareCreate(IssuingCompanyFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreateIssuingCompanyPermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }

  @Override
  public IssuingCompanyFormData store(IssuingCompanyFormData formData) throws ProcessingException {
    if (!ACCESS.check(new UpdateIssuingCompanyPermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }
}
