/**
 * 
 */
package org.asd.kyros.shared.alpha;

import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.shared.validate.IValidationStrategy;
import org.eclipse.scout.rt.shared.validate.InputValidation;
import org.eclipse.scout.service.IService;

/**
 * @author AndrewL
 */
@InputValidation(IValidationStrategy.PROCESS.class)
public interface IIDCDepartmentService extends IService {

  /**
   * @param formData
   * @return
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  IDCDepartmentFormData create(IDCDepartmentFormData formData) throws ProcessingException;

  /**
   * @param formData
   * @return
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  IDCDepartmentFormData load(IDCDepartmentFormData formData) throws ProcessingException;

  /**
   * @param formData
   * @return
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  IDCDepartmentFormData prepareCreate(IDCDepartmentFormData formData) throws ProcessingException;

  /**
   * @param formData
   * @return
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  IDCDepartmentFormData store(IDCDepartmentFormData formData) throws ProcessingException;
}