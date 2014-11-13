/**
 * 
 */
package org.asd.kyros.shared.alpha;

import java.util.Map;

import javax.annotation.Generated;

import org.asd.kyros.shared.delta.DepartmentLookupCall;
import org.eclipse.scout.rt.shared.data.form.AbstractFormData;
import org.eclipse.scout.rt.shared.data.form.ValidationRule;
import org.eclipse.scout.rt.shared.data.form.fields.AbstractValueFieldData;

/**
 * <b>NOTE:</b><br>
 * This class is auto generated by the Scout SDK. No manual modifications recommended.
 * 
 * @generated
 */
@Generated(value = "org.eclipse.scout.sdk.workspace.dto.formdata.FormDataDtoUpdateOperation", comments = "This class is auto generated by the Scout SDK. No manual modifications recommended.")
public class EmployeeFormData extends AbstractFormData {

  private static final long serialVersionUID = 1L;

  public EmployeeFormData() {
  }

  public Department getDepartment() {
    return getFieldByClass(Department.class);
  }

  public Email getEmail() {
    return getFieldByClass(Email.class);
  }

  public Extension getExtension() {
    return getFieldByClass(Extension.class);
  }

  public FirstName getFirstName() {
    return getFieldByClass(FirstName.class);
  }

  public LastName getLastName() {
    return getFieldByClass(LastName.class);
  }

  public static class Department extends AbstractValueFieldData<Long> {

    private static final long serialVersionUID = 1L;

    public Department() {
    }

    /**
     * list of derived validation rules.
     */
    @Override
    protected void initValidationRules(Map<String, Object> ruleMap) {
      super.initValidationRules(ruleMap);
      ruleMap.put(ValidationRule.LOOKUP_CALL, DepartmentLookupCall.class);
      ruleMap.put(ValidationRule.ZERO_NULL_EQUALITY, true);
    }
  }

  public static class Email extends AbstractValueFieldData<String> {

    private static final long serialVersionUID = 1L;

    public Email() {
    }

    /**
     * list of derived validation rules.
     */
    @Override
    protected void initValidationRules(Map<String, Object> ruleMap) {
      super.initValidationRules(ruleMap);
      ruleMap.put(ValidationRule.MAX_LENGTH, 4000);
    }
  }

  public static class Extension extends AbstractValueFieldData<String> {

    private static final long serialVersionUID = 1L;

    public Extension() {
    }

    /**
     * list of derived validation rules.
     */
    @Override
    protected void initValidationRules(Map<String, Object> ruleMap) {
      super.initValidationRules(ruleMap);
      ruleMap.put(ValidationRule.MAX_LENGTH, 4000);
    }
  }

  public static class FirstName extends AbstractValueFieldData<String> {

    private static final long serialVersionUID = 1L;

    public FirstName() {
    }

    /**
     * list of derived validation rules.
     */
    @Override
    protected void initValidationRules(Map<String, Object> ruleMap) {
      super.initValidationRules(ruleMap);
      ruleMap.put(ValidationRule.MAX_LENGTH, 4000);
    }
  }

  public static class LastName extends AbstractValueFieldData<String> {

    private static final long serialVersionUID = 1L;

    public LastName() {
    }

    /**
     * list of derived validation rules.
     */
    @Override
    protected void initValidationRules(Map<String, Object> ruleMap) {
      super.initValidationRules(ruleMap);
      ruleMap.put(ValidationRule.MAX_LENGTH, 4000);
    }
  }
}