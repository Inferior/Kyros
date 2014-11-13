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
public class ApprovalLevelCodeType extends AbstractCodeType<Integer, Integer> {

  private static final long serialVersionUID = 1L;
  /**
 * 
 */
  public static final Integer ID = 700;

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public ApprovalLevelCodeType() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredText() {
    return TEXTS.get("ApprovalLevel");
  }

  @Override
  public Integer getId() {
    return ID;
  }

  @Order(10.0)
  public static class Tier1Code extends AbstractCode<Integer> {

    private static final long serialVersionUID = 1L;
    /**
   * 
   */
    public static final Integer ID = 701;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Tier1");
    }

    @Override
    public Integer getId() {
      return ID;
    }
  }

  @Order(20.0)
  public static class Tier2Code extends AbstractCode<Integer> {

    private static final long serialVersionUID = 1L;
    /**
   * 
   */
    public static final Integer ID = 702;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Tier2");
    }

    @Override
    public Integer getId() {
      return ID;
    }
  }

  @Order(30.0)
  public static class Tier3Code extends AbstractCode<Integer> {

    private static final long serialVersionUID = 1L;
    /**
   * 
   */
    public static final Integer ID = 703;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Tier3");
    }

    @Override
    public Integer getId() {
      return ID;
    }
  }

  @Order(40.0)
  public static class Tier4Code extends AbstractCode<Integer> {

    private static final long serialVersionUID = 1L;
    /**
   * 
   */
    public static final Integer ID = 704;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Tier4");
    }

    @Override
    public Integer getId() {
      return ID;
    }
  }

  @Order(50.0)
  public static class NACode extends AbstractCode<Integer> {

    private static final long serialVersionUID = 1L;
    /**
   * 
   */
    public static final Integer ID = 705;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("NA");
    }

    @Override
    public Integer getId() {
      return ID;
    }
  }
}
