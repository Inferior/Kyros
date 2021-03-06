/**
 * 
 */
package org.asd.kyros.shared.delta;

import org.eclipse.scout.rt.shared.services.lookup.ILookupService;
import org.eclipse.scout.rt.shared.services.lookup.LookupCall;

/**
 * @author AndrewL
 */
public class DivisionFromCompanyLookupCall extends LookupCall<Long> {

  private static final long serialVersionUID = 1L;

  @Override
  protected Class<? extends ILookupService<Long>> getConfiguredService() {
    return IDivisionFromCompanyLookupService.class;
  }
}
