/**
 * 
 */
package org.asd.kyros.shared.delta;

import java.util.Map;

import javax.annotation.Generated;

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
public class MaterialGradeFormData extends AbstractFormData {

  private static final long serialVersionUID = 1L;

  public MaterialGradeFormData() {
  }

  public AISIDesignator getAISIDesignator() {
    return getFieldByClass(AISIDesignator.class);
  }

  public Conductive getConductive() {
    return getFieldByClass(Conductive.class);
  }

  public CorrosionResistant getCorrosionResistant() {
    return getFieldByClass(CorrosionResistant.class);
  }

  public Description getDescription() {
    return getFieldByClass(Description.class);
  }

  public MaterialType getMaterialType() {
    return getFieldByClass(MaterialType.class);
  }

  public static class AISIDesignator extends AbstractValueFieldData<String> {

    private static final long serialVersionUID = 1L;

    public AISIDesignator() {
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

  public static class Conductive extends AbstractValueFieldData<Boolean> {

    private static final long serialVersionUID = 1L;

    public Conductive() {
    }
  }

  public static class CorrosionResistant extends AbstractValueFieldData<Boolean> {

    private static final long serialVersionUID = 1L;

    public CorrosionResistant() {
    }
  }

  public static class Description extends AbstractValueFieldData<String> {

    private static final long serialVersionUID = 1L;

    public Description() {
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

  public static class MaterialType extends AbstractValueFieldData<Long> {

    private static final long serialVersionUID = 1L;

    public MaterialType() {
    }

    /**
     * list of derived validation rules.
     */
    @Override
    protected void initValidationRules(Map<String, Object> ruleMap) {
      super.initValidationRules(ruleMap);
      ruleMap.put(ValidationRule.LOOKUP_CALL, MaterialTypeLookupCall.class);
      ruleMap.put(ValidationRule.ZERO_NULL_EQUALITY, true);
    }
  }
}
