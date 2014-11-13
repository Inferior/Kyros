/**
 * 
 */
package org.asd.kyros.client.alpha;

import org.asd.kyros.client.alpha.AnnouncementForm.MainBox.CancelButton;
import org.asd.kyros.client.alpha.AnnouncementForm.MainBox.GeneralBox;
import org.asd.kyros.client.alpha.AnnouncementForm.MainBox.GeneralBox.AnnouncementField;
import org.asd.kyros.client.alpha.AnnouncementForm.MainBox.OkButton;
import org.asd.kyros.shared.alpha.AnnouncementFormData;
import org.asd.kyros.shared.alpha.IAnnouncementService;
import org.asd.kyros.shared.alpha.UpdateAnnouncementPermission;
import org.eclipse.scout.commons.annotations.FormData;
import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCancelButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractOkButton;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.IGroupBoxBodyGrid;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.internal.HorizontalGroupBoxBodyGrid;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.service.SERVICES;

/**
 * @author AndrewL
 */
@FormData(value = AnnouncementFormData.class, sdkCommand = FormData.SdkCommand.CREATE)
public class AnnouncementForm extends AbstractForm {

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public AnnouncementForm() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Announcement");
  }

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public void startModify() throws ProcessingException {
    startInternal(new ModifyHandler());
  }

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public void startNew() throws ProcessingException {
    startInternal(new NewHandler());
  }

  /**
   * @return the AnnouncementField
   */
  public AnnouncementField getAnnouncementField(){
    return getFieldByClass(AnnouncementField.class);
  }

  /**
   * @return the CancelButton
   */
  public CancelButton getCancelButton() {
    return getFieldByClass(CancelButton.class);
  }

  /**
   * @return the GeneralBox
   */
  public GeneralBox getGeneralBox(){
    return getFieldByClass(GeneralBox.class);
  }

  /**
   * @return the MainBox
   */
  public MainBox getMainBox() {
    return getFieldByClass(MainBox.class);
  }

  /**
   * @return the OkButton
   */
  public OkButton getOkButton() {
    return getFieldByClass(OkButton.class);
  }

  @Order(10.0)
  public class MainBox extends AbstractGroupBox {

    @Order(10.0)
    public class GeneralBox extends AbstractGroupBox {

      @Override
      protected Class<? extends IGroupBoxBodyGrid> getConfiguredBodyGrid() {
        return HorizontalGroupBoxBodyGrid.class;
      }

      @Override
      protected String getConfiguredLabel() {
        return TEXTS.get("General");
      }

      @Override
      protected boolean getConfiguredLabelVisible() {
        return false;
      }

      @Order(10.0)
      public class AnnouncementField extends AbstractStringField {

        @Override
        protected int getConfiguredGridH() {
          return 4;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Announcement");
        }

        @Override
        protected boolean getConfiguredLabelVisible() {
          return false;
        }

        @Override
        protected int getConfiguredMaxLength() {
          return 345;
        }

        @Override
        protected boolean getConfiguredMultilineText() {
          return true;
        }

        @Override
        protected boolean getConfiguredWrapText() {
          return true;
        }
      }
    }

    @Order(20.0)
    public class OkButton extends AbstractOkButton {
    }

    @Order(30.0)
    public class CancelButton extends AbstractCancelButton {
    }
  }

  public class ModifyHandler extends AbstractFormHandler {

    @Override
    protected void execLoad() throws ProcessingException {
      IAnnouncementService service = SERVICES.getService(IAnnouncementService.class);
      AnnouncementFormData formData = new AnnouncementFormData();
      exportFormData(formData);
      formData = service.load(formData);
      importFormData(formData);
      setEnabledPermission(new UpdateAnnouncementPermission());

    }

    @Override
    protected void execStore() throws ProcessingException {
      IAnnouncementService service = SERVICES.getService(IAnnouncementService.class);
      AnnouncementFormData formData = new AnnouncementFormData();
      exportFormData(formData);
      formData = service.store(formData);

    }
  }

  public class NewHandler extends AbstractFormHandler {

    @Override
    protected void execLoad() throws ProcessingException {
      IAnnouncementService service = SERVICES.getService(IAnnouncementService.class);
      AnnouncementFormData formData = new AnnouncementFormData();
      exportFormData(formData);
      formData = service.prepareCreate(formData);
      importFormData(formData);

    }

    @Override
    protected void execStore() throws ProcessingException {
      IAnnouncementService service = SERVICES.getService(IAnnouncementService.class);
      AnnouncementFormData formData = new AnnouncementFormData();
      exportFormData(formData);
      formData = service.create(formData);

    }
  }
}
