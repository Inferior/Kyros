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
public interface IEmployeeService extends IService {

  /**
   * @param formData
   * @return
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  EmployeeFormData create(EmployeeFormData formData) throws ProcessingException;

  /**
   * @param formData
   * @return
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  EmployeeFormData load(EmployeeFormData formData) throws ProcessingException;

  /**
   * @param formData
   * @return
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  EmployeeFormData prepareCreate(EmployeeFormData formData) throws ProcessingException;

  /**
   * @param formData
   * @return
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  EmployeeFormData store(EmployeeFormData formData) throws ProcessingException;
}
