/**
 * 
 */
package org.asd.kyros.client.alpha;

import org.asd.kyros.client.alpha.EmployeeForm.MainBox.CancelButton;
import org.asd.kyros.client.alpha.EmployeeForm.MainBox.GeneralBox;
import org.asd.kyros.client.alpha.EmployeeForm.MainBox.GeneralBox.DepartmentField;
import org.asd.kyros.client.alpha.EmployeeForm.MainBox.GeneralBox.EmailField;
import org.asd.kyros.client.alpha.EmployeeForm.MainBox.GeneralBox.ExtensionField;
import org.asd.kyros.client.alpha.EmployeeForm.MainBox.GeneralBox.FirstNameField;
import org.asd.kyros.client.alpha.EmployeeForm.MainBox.GeneralBox.HolderOneField;
import org.asd.kyros.client.alpha.EmployeeForm.MainBox.GeneralBox.LastNameField;
import org.asd.kyros.client.alpha.EmployeeForm.MainBox.OkButton;
import org.asd.kyros.shared.alpha.EmployeeFormData;
import org.asd.kyros.shared.alpha.IEmployeeService;
import org.asd.kyros.shared.alpha.UpdateEmployeePermission;
import org.asd.kyros.shared.delta.DepartmentLookupCall;
import org.eclipse.scout.commons.annotations.FormData;
import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCancelButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractOkButton;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.placeholder.AbstractPlaceholderField;
import org.eclipse.scout.rt.client.ui.form.fields.smartfield.AbstractSmartField;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.lookup.ILookupCall;
import org.eclipse.scout.service.SERVICES;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.IGroupBoxBodyGrid;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.internal.HorizontalGroupBoxBodyGrid;

/**
 * @author AndrewL
 */
@FormData(value = EmployeeFormData.class, sdkCommand = FormData.SdkCommand.CREATE)
public class EmployeeForm extends AbstractForm {

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public EmployeeForm() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Employee");
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
   * @return the DepartmentField
   */
  public DepartmentField getDepartmentField(){
    return getFieldByClass(DepartmentField.class);
  }

  /**
   * @return the EmailField
   */
  public EmailField getEmailField(){
    return getFieldByClass(EmailField.class);
  }

  /**
   * @return the ExtensionField
   */
  public ExtensionField getExtensionField(){
    return getFieldByClass(ExtensionField.class);
  }

  /**
   * @return the FirstNameField
   */
  public FirstNameField getFirstNameField(){
    return getFieldByClass(FirstNameField.class);
  }

  /**
   * @return the GeneralBox
   */
  public GeneralBox getGeneralBox(){
    return getFieldByClass(GeneralBox.class);
  }

  /**
   * @return the HolderOneField
   */
  public HolderOneField getHolderOneField(){
    return getFieldByClass(HolderOneField.class);
  }

  /**
   * @return the LastNameField
   */
  public LastNameField getLastNameField(){
    return getFieldByClass(LastNameField.class);
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
      protected int getConfiguredGridColumnCount() {
        return 3;
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
      public class FirstNameField extends AbstractStringField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("FirstName");
        }

        @Override
        protected int getConfiguredLabelPosition() {
          return LABEL_POSITION_TOP;
        }
      }

      @Order(20.0)
      public class LastNameField extends AbstractStringField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("LastName");
        }

        @Override
        protected int getConfiguredLabelPosition() {
          return LABEL_POSITION_TOP;
        }
      }

      @Order(30.0)
      public class HolderOneField extends AbstractPlaceholderField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("HolderOne");
        }
      }

      @Order(40.0)
      public class EmailField extends AbstractStringField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Email");
        }

        @Override
        protected int getConfiguredLabelPosition() {
          return LABEL_POSITION_TOP;
        }
      }

      @Order(50.0)
      public class ExtensionField extends AbstractStringField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Extension");
        }

        @Override
        protected int getConfiguredLabelPosition() {
          return LABEL_POSITION_TOP;
        }
      }

      @Order(60.0)
      public class DepartmentField extends AbstractSmartField<Long> {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Department");
        }

        @Override
        protected int getConfiguredLabelPosition() {
          return LABEL_POSITION_TOP;
        }

        @Override
        protected Class<? extends ILookupCall<Long>> getConfiguredLookupCall() {
          return DepartmentLookupCall.class;
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
      IEmployeeService service = SERVICES.getService(IEmployeeService.class);
      EmployeeFormData formData = new EmployeeFormData();
      exportFormData(formData);
      formData = service.load(formData);
      importFormData(formData);
      setEnabledPermission(new UpdateEmployeePermission());

    }

    @Override
    protected void execStore() throws ProcessingException {
      IEmployeeService service = SERVICES.getService(IEmployeeService.class);
      EmployeeFormData formData = new EmployeeFormData();
      exportFormData(formData);
      formData = service.store(formData);

    }
  }

  public class NewHandler extends AbstractFormHandler {

    @Override
    protected void execLoad() throws ProcessingException {
      IEmployeeService service = SERVICES.getService(IEmployeeService.class);
      EmployeeFormData formData = new EmployeeFormData();
      exportFormData(formData);
      formData = service.prepareCreate(formData);
      importFormData(formData);

    }

    @Override
    protected void execStore() throws ProcessingException {
      IEmployeeService service = SERVICES.getService(IEmployeeService.class);
      EmployeeFormData formData = new EmployeeFormData();
      exportFormData(formData);
      formData = service.create(formData);

    }
  }
}
