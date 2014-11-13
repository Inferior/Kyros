/**
 * 
 */
package org.asd.kyros.client.alpha;

import org.asd.kyros.client.alpha.ContactForm.MainBox.CancelButton;
import org.asd.kyros.client.alpha.ContactForm.MainBox.GeneralBox;
import org.asd.kyros.client.alpha.ContactForm.MainBox.GeneralBox.CompanyField;
import org.asd.kyros.client.alpha.ContactForm.MainBox.GeneralBox.DivisionField;
import org.asd.kyros.client.alpha.ContactForm.MainBox.GeneralBox.EmailField;
import org.asd.kyros.client.alpha.ContactForm.MainBox.GeneralBox.FaxNumberField;
import org.asd.kyros.client.alpha.ContactForm.MainBox.GeneralBox.FirstNameField;
import org.asd.kyros.client.alpha.ContactForm.MainBox.GeneralBox.HolderOneField;
import org.asd.kyros.client.alpha.ContactForm.MainBox.GeneralBox.LastNameField;
import org.asd.kyros.client.alpha.ContactForm.MainBox.GeneralBox.PhoneNumberField;
import org.asd.kyros.client.alpha.ContactForm.MainBox.GeneralBox.TypeField;
import org.asd.kyros.client.alpha.ContactForm.MainBox.OkButton;
import org.asd.kyros.shared.alpha.ContactFormData;
import org.asd.kyros.shared.alpha.IContactService;
import org.asd.kyros.shared.alpha.UpdateContactPermission;
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
import org.eclipse.scout.rt.client.ui.form.fields.placeholder.AbstractPlaceholderField;
import org.eclipse.scout.rt.client.ui.form.fields.smartfield.AbstractSmartField;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.service.SERVICES;
import org.eclipse.scout.rt.client.ui.form.fields.IValueField;
import org.asd.kyros.shared.delta.CompanyLookupCall;
import org.eclipse.scout.rt.shared.services.lookup.ILookupCall;
import org.asd.kyros.shared.delta.DivisionFromCompanyLookupCall;
import org.asd.kyros.shared.delta.ContactClassificationCodeType;
import org.eclipse.scout.rt.shared.services.common.code.ICodeType;

/**
 * @author AndrewL
 */
@FormData(value = ContactFormData.class, sdkCommand = FormData.SdkCommand.CREATE)
public class ContactForm extends AbstractForm {

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public ContactForm() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Contact");
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
   * @return the CompanyField
   */
  public CompanyField getCompanyField() {
    return getFieldByClass(CompanyField.class);
  }

  /**
   * @return the DivisionField
   */
  public DivisionField getDivisionField() {
    return getFieldByClass(DivisionField.class);
  }

  /**
   * @return the EmailField
   */
  public EmailField getEmailField() {
    return getFieldByClass(EmailField.class);
  }

  /**
   * @return the FaxNumberField
   */
  public FaxNumberField getFaxNumberField() {
    return getFieldByClass(FaxNumberField.class);
  }

  /**
   * @return the FirstNameField
   */
  public FirstNameField getFirstNameField() {
    return getFieldByClass(FirstNameField.class);
  }

  /**
   * @return the GeneralBox
   */
  public GeneralBox getGeneralBox() {
    return getFieldByClass(GeneralBox.class);
  }

  /**
   * @return the HolderOneField
   */
  public HolderOneField getHolderOneField() {
    return getFieldByClass(HolderOneField.class);
  }

  /**
   * @return the LastNameField
   */
  public LastNameField getLastNameField() {
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

  /**
   * @return the PhoneNumberField
   */
  public PhoneNumberField getPhoneNumberField() {
    return getFieldByClass(PhoneNumberField.class);
  }

  /**
   * @return the TypeField
   */
  public TypeField getTypeField() {
    return getFieldByClass(TypeField.class);
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
      public class CompanyField extends AbstractSmartField<Long> {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Company");
        }

        @Override
        protected int getConfiguredLabelPosition() {
          return LABEL_POSITION_TOP;
        }

        @Override
        protected Class<? extends ILookupCall<Long>> getConfiguredLookupCall() {
          return CompanyLookupCall.class;
        }
      }

      @Order(20.0)
      public class DivisionField extends AbstractSmartField<Long> {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Division");
        }

        @Override
        protected int getConfiguredLabelPosition() {
          return LABEL_POSITION_TOP;
        }

        @Override
        protected Class<? extends ILookupCall<Long>> getConfiguredLookupCall() {
          return DivisionFromCompanyLookupCall.class;
        }

        @Override
        protected Class<? extends IValueField> getConfiguredMasterField() {
          return ContactForm.MainBox.GeneralBox.CompanyField.class;
        }

        @Override
        protected boolean getConfiguredMasterRequired() {
          return true;
        }
      }

      @Order(30.0)
      public class TypeField extends AbstractSmartField<Integer> {

        @Override
        protected Class<? extends ICodeType<?, Integer>> getConfiguredCodeType() {
          return ContactClassificationCodeType.class;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Position");
        }

        @Override
        protected int getConfiguredLabelPosition() {
          return LABEL_POSITION_TOP;
        }
      }

      @Order(40.0)
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

      @Order(50.0)
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

      @Order(60.0)
      public class HolderOneField extends AbstractPlaceholderField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("HolderOne");
        }
      }

      @Order(70.0)
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

      @Order(80.0)
      public class PhoneNumberField extends AbstractStringField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("PhoneNumber");
        }

        @Override
        protected int getConfiguredLabelPosition() {
          return LABEL_POSITION_TOP;
        }
      }

      @Order(90.0)
      public class FaxNumberField extends AbstractStringField {

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("FaxNumber");
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
      IContactService service = SERVICES.getService(IContactService.class);
      ContactFormData formData = new ContactFormData();
      exportFormData(formData);
      formData = service.load(formData);
      importFormData(formData);
      setEnabledPermission(new UpdateContactPermission());

    }

    @Override
    protected void execStore() throws ProcessingException {
      IContactService service = SERVICES.getService(IContactService.class);
      ContactFormData formData = new ContactFormData();
      exportFormData(formData);
      formData = service.store(formData);

    }
  }

  public class NewHandler extends AbstractFormHandler {

    @Override
    protected void execLoad() throws ProcessingException {
      IContactService service = SERVICES.getService(IContactService.class);
      ContactFormData formData = new ContactFormData();
      exportFormData(formData);
      formData = service.prepareCreate(formData);
      importFormData(formData);

    }

    @Override
    protected void execStore() throws ProcessingException {
      IContactService service = SERVICES.getService(IContactService.class);
      ContactFormData formData = new ContactFormData();
      exportFormData(formData);
      formData = service.create(formData);

    }
  }
}
