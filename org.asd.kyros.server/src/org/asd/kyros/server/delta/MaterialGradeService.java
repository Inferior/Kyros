/**
 *
 */
package org.asd.kyros.server.delta;

import org.asd.kyros.shared.delta.CreateMaterialGradePermission;
import org.asd.kyros.shared.delta.IMaterialGradeService;
import org.asd.kyros.shared.delta.MaterialGradeFormData;
import org.asd.kyros.shared.delta.ReadMaterialGradePermission;
import org.asd.kyros.shared.delta.UpdateMaterialGradePermission;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.commons.exception.VetoException;
import org.eclipse.scout.rt.server.services.common.jdbc.SQL;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.security.ACCESS;
import org.eclipse.scout.service.AbstractService;

/**
 * @author AndrewL
 */
public class MaterialGradeService extends AbstractService implements IMaterialGradeService {

  @Override
  public MaterialGradeFormData create(MaterialGradeFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreateMaterialGradePermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    SQL.insert("" +
        "INSERT INTO MATERIALGRADE (MG_DESIGNATOR, MG_DESCRIPTION, MG_CONDUCTIVE, MG_CORROSION, MATERIALTYPE_MT_ID) " +
        "VALUES (:aISIDesignator, :description, :conductive, :corrosionResistant, :materialType)", formData);
    return formData;
  }

  @Override
  public MaterialGradeFormData load(MaterialGradeFormData formData) throws ProcessingException {
    if (!ACCESS.check(new ReadMaterialGradePermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }

  @Override
  public MaterialGradeFormData prepareCreate(MaterialGradeFormData formData) throws ProcessingException {
    if (!ACCESS.check(new CreateMaterialGradePermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }

  @Override
  public MaterialGradeFormData store(MaterialGradeFormData formData) throws ProcessingException {
    if (!ACCESS.check(new UpdateMaterialGradePermission())) {
      throw new VetoException(TEXTS.get("AuthorizationFailed"));
    }
    //TODO [AndrewL] business logic here.
    return formData;
  }
}
