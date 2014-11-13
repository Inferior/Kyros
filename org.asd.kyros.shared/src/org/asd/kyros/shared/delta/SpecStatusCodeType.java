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
public class SpecStatusCodeType extends AbstractCodeType<Integer, Integer> {

  private static final long serialVersionUID = 1L;
  /**
 * 
 */
  public static final Integer ID = 1100;

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public SpecStatusCodeType() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredText() {
    return TEXTS.get("SpecStatus");
  }

  @Override
  public Integer getId() {
    return ID;
  }

  @Order(10.0)
  public static class ActiveCode extends AbstractCode<Integer> {

    private static final long serialVersionUID = 1L;
    /**
   * 
   */
    public static final Integer ID = 1101;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Active");
    }

    @Override
    public Integer getId() {
      return ID;
    }
  }

  @Order(20.0)
  public static class CancelledCode extends AbstractCode<Integer> {

    private static final long serialVersionUID = 1L;
    /**
   * 
   */
    public static final Integer ID = 1102;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Cancelled");
    }

    @Override
    public Integer getId() {
      return ID;
    }
  }

  @Order(30.0)
  public static class SuperseededCode extends AbstractCode<Integer> {

    private static final long serialVersionUID = 1L;
    /**
   * 
   */
    public static final Integer ID = 1103;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Superseeded");
    }

    @Override
    public Integer getId() {
      return ID;
    }
  }
}
