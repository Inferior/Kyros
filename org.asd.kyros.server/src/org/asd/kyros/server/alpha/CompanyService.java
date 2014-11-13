/**
 *
 */
package org.asd.kyros.server.alpha;

import org.asd.kyros.shared.alpha.CompanyFormData;
import org.asd.kyros.shared.alpha.CreateCompanyPermission;
import org.asd.kyros.shared.alpha.ICompanyService;
import org.asd.kyros.shared.alpha.ReadCompanyPermission;
import org.asd.kyros.shared.alpha.UpdateCompanyPermission;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.commons.exception.VetoException;
import org.eclipse.scout.rt.server.services.common.jdbc.SQL;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.security.ACCESS;
import org.eclipse.scout.service.AbstractService;

/**
 * @author AndrewL
 */
public class CompanyService extends AbstractService implements ICompanyService {

  @Override
  public CompanyFormData create(CompanyFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreateCompanyPermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    SQL.insert("" +
        "INSERT INTO COMPANY (COMPANY_NAMELONG, COMPANY_NAMESHORT, COMPANY_WEBSITE, COMPANY_TYPE, APPROVAL_STATUS, APPROVAL_TYPE, APPROVAL_LEVEL, APPROVAL_SCOPE, APPROVAL_LOCKHEED, APPROVAL_FMT) " +
        "VALUES (:name, :abbreviation, :website, :type, :approvalStatus, :approvalType, :approvalLevel, :scopeOfApproval, :lockheedMartinApproved, :honeywellFMTApproved)", formData);
    return formData;
  }

  @Override
  public CompanyFormData load(CompanyFormData formData) throws ProcessingException {
    if (!ACCESS.check(new ReadCompanyPermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }

  @Override
  public CompanyFormData prepareCreate(CompanyFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreateCompanyPermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }

  @Override
  public CompanyFormData store(CompanyFormData formData) throws ProcessingException {
    if (!ACCESS.check(new UpdateCompanyPermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }
}
