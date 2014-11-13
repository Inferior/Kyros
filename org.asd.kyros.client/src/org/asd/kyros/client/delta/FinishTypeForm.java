/**
 * 
 */
package org.asd.kyros.client.delta;

import org.asd.kyros.client.delta.FinishTypeForm.MainBox.CancelButton;
import org.asd.kyros.client.delta.FinishTypeForm.MainBox.GeneralBox;
import org.asd.kyros.client.delta.FinishTypeForm.MainBox.GeneralBox.GeneralDescriptionField;
import org.asd.kyros.client.delta.FinishTypeForm.MainBox.GeneralBox.ProcessNameField;
import org.asd.kyros.client.delta.FinishTypeForm.MainBox.OkButton;
import org.asd.kyros.shared.delta.FinishTypeFormData;
import org.asd.kyros.shared.delta.IFinishTypeService;
import org.asd.kyros.shared.delta.UpdateFinishTypePermission;
import org.eclipse.scout.commons.annotations.FormData;
import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCancelButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractOkButton;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.service.SERVICES;

/**
 * @author AndrewL
 */
@FormData(value = FinishTypeFormData.class, sdkCommand = FormData.SdkCommand.CREATE)
public class FinishTypeForm extends AbstractForm {

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public FinishTypeForm() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("FinishType");
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
   * @return the GeneralDescriptionField
   */
  public GeneralDescriptionField getGeneralDescriptionField(){
    return getFieldByClass(GeneralDescriptionField.class);
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

  /**
   * @return the ProcessNameField
   */
  public ProcessNameField getProcessNameField(){
    return getFieldByClass(ProcessNameField.class);
  }

  @Order(10.0)
  public class MainBox extends AbstractGroupBox {

    @Order(10.0)
    public class GeneralBox extends AbstractGroupBox {

      @Override
      protected int getConfiguredGridColumnCount() {
        return 2;
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
      public class ProcessNameField extends AbstractStringField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("ProcessName");
        }

        @Override
        protected int getConfiguredLabelPosition() {
          return LABEL_POSITION_TOP;
        }
      }

      @Order(20.0)
      public class GeneralDescriptionField extends AbstractStringField {

        @Override
        protected int getConfiguredGridH() {
          return 4;
        }

        @Override
        protected int getConfiguredGridW() {
          return 2;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("GeneralDescription");
        }

        @Override
        protected int getConfiguredLabelPosition() {
          return LABEL_POSITION_TOP;
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
      IFinishTypeService service = SERVICES.getService(IFinishTypeService.class);
      FinishTypeFormData formData = new FinishTypeFormData();
      exportFormData(formData);
      formData = service.load(formData);
      importFormData(formData);
      setEnabledPermission(new UpdateFinishTypePermission());

    }

    @Override
    protected void execStore() throws ProcessingException {
      IFinishTypeService service = SERVICES.getService(IFinishTypeService.class);
      FinishTypeFormData formData = new FinishTypeFormData();
      exportFormData(formData);
      formData = service.store(formData);

    }
  }

  public class NewHandler extends AbstractFormHandler {

    @Override
    protected void execLoad() throws ProcessingException {
      IFinishTypeService service = SERVICES.getService(IFinishTypeService.class);
      FinishTypeFormData formData = new FinishTypeFormData();
      exportFormData(formData);
      formData = service.prepareCreate(formData);
      importFormData(formData);

    }

    @Override
    protected void execStore() throws ProcessingException {
      IFinishTypeService service = SERVICES.getService(IFinishTypeService.class);
      FinishTypeFormData formData = new FinishTypeFormData();
      exportFormData(formData);
      formData = service.create(formData);

    }
  }
}
