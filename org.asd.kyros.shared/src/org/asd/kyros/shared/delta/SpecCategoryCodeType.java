/**
 * 
 */
package org.asd.kyros.shared.delta;

import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.common.code.AbstractCode;
import org.eclipse.scout.rt.shared.services.common.code.AbstractCodeType;

/**
 * @author AndrewL
 */
public class SpecCategoryCodeType extends AbstractCodeType<Integer, Integer> {

  private static final long serialVersionUID = 1L;
  /**
 * 
 */
  public static final Integer ID = 900;

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public SpecCategoryCodeType() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredText() {
    return TEXTS.get("SpecCategory");
  }

  @Override
  public Integer getId() {
    return ID;
  }

  @Order(10.0)
  public static class MaterialCode extends AbstractCode<Integer> {

    private static final long serialVersionUID = 1L;
    /**
   * 
   */
    public static final Integer ID = 901;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Material");
    }

    @Override
    public Integer getId() {
      return ID;
    }
  }

  @Order(20.0)
  public static class ProcessCode extends AbstractCode<Integer> {

    private static final long serialVersionUID = 1L;
    /**
   * 
   */
    public static final Integer ID = 902;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Process");
    }

    @Override
    public Integer getId() {
      return ID;
    }
  }

  @Order(30.0)
  public static class CustomerSpecificCode extends AbstractCode<Integer> {

    private static final long serialVersionUID = 1L;
    /**
   * 
   */
    public static final Integer ID = 903;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("CustomerSpecific");
    }

    @Override
    public Integer getId() {
      return ID;
    }
  }

  @Order(40.0)
  public static class GeneralCode extends AbstractCode<Integer> {

    private static final long serialVersionUID = 1L;
    /**
   * 
   */
    public static final Integer ID = 904;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("General");
    }

    @Override
    public Integer getId() {
      return ID;
    }
  }
}