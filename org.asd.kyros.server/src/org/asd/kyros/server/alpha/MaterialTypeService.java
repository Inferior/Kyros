/**
 *
 */
package org.asd.kyros.server.alpha;

import org.asd.kyros.shared.alpha.CreateMaterialTypePermission;
import org.asd.kyros.shared.alpha.IMaterialTypeService;
import org.asd.kyros.shared.alpha.MaterialTypeFormData;
import org.asd.kyros.shared.alpha.ReadMaterialTypePermission;
import org.asd.kyros.shared.alpha.UpdateMaterialTypePermission;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.commons.exception.VetoException;
import org.eclipse.scout.rt.server.services.common.jdbc.SQL;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.security.ACCESS;
import org.eclipse.scout.service.AbstractService;

/**
 * @author AndrewL
 */
public class MaterialTypeService extends AbstractService implements IMaterialTypeService {

  @Override
  public MaterialTypeFormData create(MaterialTypeFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreateMaterialTypePermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    SQL.insert("" +
        "INSERT INTO MATERIALTYPE (MT_NAME, MT_GENERIC) " +
        "VALUES (:name, :generalDescription)", formData);

    return formData;
  }

  @Override
  public MaterialTypeFormData load(MaterialTypeFormData formData) throws ProcessingException {
    if (!ACCESS.check(new ReadMaterialTypePermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }

  @Override
  public MaterialTypeFormData prepareCreate(MaterialTypeFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreateMaterialTypePermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }

  @Override
  public MaterialTypeFormData store(MaterialTypeFormData formData) throws ProcessingException {
    if (!ACCESS.check(new UpdateMaterialTypePermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }
}
