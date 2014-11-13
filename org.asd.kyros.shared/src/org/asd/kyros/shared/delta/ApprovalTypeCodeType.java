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
public class ApprovalTypeCodeType extends AbstractCodeType<Integer, Integer> {

  private static final long serialVersionUID = 1L;
  /**
 * 
 */
  public static final Integer ID = 600;

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public ApprovalTypeCodeType() throws ProcessingException {
    super();
  }

  @Override
  protected boolean getConfiguredIsHierarchy() {
    return true;
  }

  @Override
  protected String getConfiguredText() {
    return TEXTS.get("ApprovalType");
  }

  @Override
  public Integer getId() {
    return ID;
  }

  @Order(10.0)
  public static class SubContractorCode extends AbstractCode<Integer> {

    private static final long serialVersionUID = 1L;
    /**
   * 
   */
    public static final Integer ID = 601;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Sub-contractor");
    }

    @Override
    public Integer getId() {
      return ID;
    }

    @Order(10.0)
    public static class CalibrationCode extends AbstractCode<Integer> {

      private static final long serialVersionUID = 1L;
      /**
     * 
     */
      public static final Integer ID = 602;

      @Override
      protected String getConfiguredText() {
        return TEXTS.get("Calibration");
      }

      @Override
      public Integer getId() {
        return ID;
      }
    }

    @Order(20.0)
    public static class OutsideMachiningCode extends AbstractCode<Integer> {

      private static final long serialVersionUID = 1L;
      /**
     * 
     */
      public static final Integer ID = 603;

      @Override
      protected String getConfiguredText() {
        return TEXTS.get("OutsideMachining");
      }

      @Override
      public Integer getId() {
        return ID;
      }
    }

    @Order(30.0)
    public static class SpecialProcessCode extends AbstractCode<Integer> {

      private static final long serialVersionUID = 1L;
      /**
     * 
     */
      public static final Integer ID = 604;

      @Override
      protected String getConfiguredText() {
        return TEXTS.get("SpecialProcess");
      }

      @Override
      public Integer getId() {
        return ID;
      }
    }

    @Order(40.0)
    public static class SpecialProcessOutsideMachiningCode extends AbstractCode<Integer> {

      private static final long serialVersionUID = 1L;
      /**
     * 
     */
      public static final Integer ID = 605;

      @Override
      protected String getConfiguredText() {
        return TEXTS.get("SpecialProcessOutsideMachining");
      }

      @Override
      public Integer getId() {
        return ID;
      }
    }

    @Order(50.0)
    public static class TestingCode extends AbstractCode<Integer> {

      private static final long serialVersionUID = 1L;
      /**
     * 
     */
      public static final Integer ID = 606;

      @Override
      protected String getConfiguredText() {
        return TEXTS.get("Testing");
      }

      @Override
      public Integer getId() {
        return ID;
      }
    }
  }

  @Order(20.0)
  public static class VendorCode extends AbstractCode<Integer> {

    private static final long serialVersionUID = 1L;
    /**
   * 
   */
    public static final Integer ID = 625;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Vendor");
    }

    @Override
    public Integer getId() {
      return ID;
    }

    @Order(10.0)
    public static class CastingCode extends AbstractCode<Integer> {

      private static final long serialVersionUID = 1L;
      /**
     * 
     */
      public static final Integer ID = 626;

      @Override
      protected String getConfiguredText() {
        return TEXTS.get("Casting");
      }

      @Override
      public Integer getId() {
        return ID;
      }
    }

    @Order(20.0)
    public static class HardwareCode extends AbstractCode<Integer> {

      private static final long serialVersionUID = 1L;
      /**
     * 
     */
      public static final Integer ID = 627;

      @Override
      protected String getConfiguredText() {
        return TEXTS.get("Hardware");
      }

      @Override
      public Integer getId() {
        return ID;
      }
    }

    @Order(30.0)
    public static class RawMaterialCode extends AbstractCode<Integer> {

      private static final long serialVersionUID = 1L;
      /**
     * 
     */
      public static final Integer ID = 627;

      @Override
      protected String getConfiguredText() {
        return TEXTS.get("RawMaterial");
      }

      @Override
      public Integer getId() {
        return ID;
      }
    }

    @Order(40.0)
    public static class InspectionCode extends AbstractCode<Integer> {

      private static final long serialVersionUID = 1L;
      /**
     * 
     */
      public static final Integer ID = 628;

      @Override
      protected String getConfiguredText() {
        return TEXTS.get("Inspection");
      }

      @Override
      public Integer getId() {
        return ID;
      }
    }
  }
}
