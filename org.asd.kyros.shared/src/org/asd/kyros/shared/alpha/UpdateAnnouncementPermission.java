/**
 * 
 */
package org.asd.kyros.shared.alpha;

import java.security.BasicPermission;

/**
 * @author AndrewL
 */
public class UpdateAnnouncementPermission extends BasicPermission {

  private static final long serialVersionUID = 1L;

  /**
 * 
 */
  public UpdateAnnouncementPermission() {
    super("UpdateAnnouncement");
  }
}
