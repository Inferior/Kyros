/**
 * 
 */
package org.asd.kyros.client.alpha;

import org.asd.kyros.client.alpha.IssuingCompanyForm.MainBox.CancelButton;
import org.asd.kyros.client.alpha.IssuingCompanyForm.MainBox.GeneralBox;
import org.asd.kyros.client.alpha.IssuingCompanyForm.MainBox.GeneralBox.AbbreviationField;
import org.asd.kyros.client.alpha.IssuingCompanyForm.MainBox.GeneralBox.NameField;
import org.asd.kyros.client.alpha.IssuingCompanyForm.MainBox.OkButton;
import org.asd.kyros.shared.alpha.IIssuingCompanyService;
import org.asd.kyros.shared.alpha.IssuingCompanyFormData;
import org.asd.kyros.shared.alpha.UpdateIssuingCompanyPermission;
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
@FormData(value = IssuingCompanyFormData.class, sdkCommand = FormData.SdkCommand.CREATE)
public class IssuingCompanyForm extends AbstractForm {

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public IssuingCompanyForm() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("IssuingCompany");
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
   * @return the AbbreviationField
   */
  public AbbreviationField getAbbreviationField(){
    return getFieldByClass(AbbreviationField.class);
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
   * @return the NameField
   */
  public NameField getNameField(){
    return getFieldByClass(NameField.class);
  }

  /**
   * @return the OkButton
   */
  public OkButton getOkButton() {
    return getFieldByClass(OkButton.class);
  }

  @Order(10.0)
  public class MainBox extends AbstractGroupBox {

    @Override
    protected int getConfiguredGridColumnCount() {
      return 1;
    }

    @Order(10.0)
    public class GeneralBox extends AbstractGroupBox {

      @Override
      protected int getConfiguredGridColumnCount() {
        return 1;
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
      public class NameField extends AbstractStringField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Name");
        }

        @Override
        protected int getConfiguredLabelPosition() {
          return LABEL_POSITION_TOP;
        }
      }

      @Order(20.0)
      public class AbbreviationField extends AbstractStringField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Abbreviation");
        }

        @Override
        protected int getConfiguredLabelPosition() {
          return LABEL_POSITION_TOP;
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
      IIssuingCompanyService service = SERVICES.getService(IIssuingCompanyService.class);
      IssuingCompanyFormData formData = new IssuingCompanyFormData();
      exportFormData(formData);
      formData = service.load(formData);
      importFormData(formData);
      setEnabledPermission(new UpdateIssuingCompanyPermission());

    }

    @Override
    protected void execStore() throws ProcessingException {
      IIssuingCompanyService service = SERVICES.getService(IIssuingCompanyService.class);
      IssuingCompanyFormData formData = new IssuingCompanyFormData();
      exportFormData(formData);
      formData = service.store(formData);

    }
  }

  public class NewHandler extends AbstractFormHandler {

    @Override
    protected void execLoad() throws ProcessingException {
      IIssuingCompanyService service = SERVICES.getService(IIssuingCompanyService.class);
      IssuingCompanyFormData formData = new IssuingCompanyFormData();
      exportFormData(formData);
      formData = service.prepareCreate(formData);
      importFormData(formData);

    }

    @Override
    protected void execStore() throws ProcessingException {
      IIssuingCompanyService service = SERVICES.getService(IIssuingCompanyService.class);
      IssuingCompanyFormData formData = new IssuingCompanyFormData();
      exportFormData(formData);
      formData = service.create(formData);

    }
  }
}
