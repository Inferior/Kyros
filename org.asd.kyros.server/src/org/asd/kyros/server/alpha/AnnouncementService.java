/**
 *
 */
package org.asd.kyros.server.alpha;

import org.asd.kyros.shared.alpha.AnnouncementFormData;
import org.asd.kyros.shared.alpha.CreateAnnouncementPermission;
import org.asd.kyros.shared.alpha.IAnnouncementService;
import org.asd.kyros.shared.alpha.ReadAnnouncementPermission;
import org.asd.kyros.shared.alpha.UpdateAnnouncementPermission;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.commons.exception.VetoException;
import org.eclipse.scout.rt.server.services.common.jdbc.SQL;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.security.ACCESS;
import org.eclipse.scout.service.AbstractService;

/**
 * @author AndrewL
 */
public class AnnouncementService extends AbstractService implements IAnnouncementService {

  @Override
  public AnnouncementFormData create(AnnouncementFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreateAnnouncementPermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    SQL.insert("" +
        "INSERT INTO ANNOUNCEMENT (ANN_OUNCEMENT) " +
        "VALUES (:announcement)", formData);
    return formData;
  }

  @Override
  public AnnouncementFormData load(AnnouncementFormData formData) throws ProcessingException {
    if (!ACCESS.check(new ReadAnnouncementPermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }

  @Override
  public AnnouncementFormData prepareCreate(AnnouncementFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreateAnnouncementPermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }

  @Override
  public AnnouncementFormData store(AnnouncementFormData formData) throws ProcessingException {
    if (!ACCESS.check(new UpdateAnnouncementPermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }
}
