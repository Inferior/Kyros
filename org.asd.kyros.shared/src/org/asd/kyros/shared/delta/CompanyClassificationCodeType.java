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
public class CompanyClassificationCodeType extends AbstractCodeType<Integer, Integer> {

  private static final long serialVersionUID = 1L;
  /**
 * 
 */
  public static final Integer ID = 800;

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public CompanyClassificationCodeType() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredText() {
    return TEXTS.get("CompanyClassification");
  }

  @Override
  public Integer getId() {
    return ID;
  }

  @Order(10.0)
  public static class CustomerCode extends AbstractCode<Integer> {

    private static final long serialVersionUID = 1L;
    /**
   * 
   */
    public static final Integer ID = 801;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Customer");
    }

    @Override
    public Integer getId() {
      return ID;
    }
  }

  @Order(20.0)
  public static class SubContractorCode extends AbstractCode<Integer> {

    private static final long serialVersionUID = 1L;
    /**
   * 
   */
    public static final Integer ID = 802;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Sub-contractor");
    }

    @Override
    public Integer getId() {
      return ID;
    }
  }

  @Order(30.0)
  public static class VendorCode extends AbstractCode<Integer> {

    private static final long serialVersionUID = 1L;
    /**
   * 
   */
    public static final Integer ID = 803;

    @Override
    protected String getConfiguredText() {
      return TEXTS.get("Vendor");
    }

    @Override
    public Integer getId() {
      return ID;
    }
  }
}
