/**
 * 
 */
package org.asd.kyros.client.alpha;

import org.asd.kyros.client.alpha.PartForm.MainBox.CancelButton;
import org.asd.kyros.client.alpha.PartForm.MainBox.GeneralBox;
import org.asd.kyros.client.alpha.PartForm.MainBox.GeneralBox.CompanyField;
import org.asd.kyros.client.alpha.PartForm.MainBox.GeneralBox.ForQuoteOnlyField;
import org.asd.kyros.client.alpha.PartForm.MainBox.GeneralBox.NameField;
import org.asd.kyros.client.alpha.PartForm.MainBox.GeneralBox.PartNumberField;
import org.asd.kyros.client.alpha.PartForm.MainBox.GeneralBox.SearchWordField;
import org.asd.kyros.client.alpha.PartForm.MainBox.OkButton;
import org.asd.kyros.shared.alpha.IPartService;
import org.asd.kyros.shared.alpha.PartFormData;
import org.asd.kyros.shared.alpha.UpdatePartPermission;
import org.asd.kyros.shared.delta.CompanyLookupCall;
import org.eclipse.scout.commons.annotations.FormData;
import org.eclipse.scout.commons.annotations.Order;
import org.eclipse.scout.commons.exception.ProcessingException;
import org.eclipse.scout.rt.client.ui.form.AbstractForm;
import org.eclipse.scout.rt.client.ui.form.AbstractFormHandler;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractCancelButton;
import org.eclipse.scout.rt.client.ui.form.fields.button.AbstractOkButton;
import org.eclipse.scout.rt.client.ui.form.fields.checkbox.AbstractCheckBox;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.AbstractGroupBox;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.IGroupBoxBodyGrid;
import org.eclipse.scout.rt.client.ui.form.fields.groupbox.internal.HorizontalGroupBoxBodyGrid;
import org.eclipse.scout.rt.client.ui.form.fields.smartfield.AbstractSmartField;
import org.eclipse.scout.rt.client.ui.form.fields.stringfield.AbstractStringField;
import org.eclipse.scout.rt.shared.TEXTS;
import org.eclipse.scout.rt.shared.services.lookup.ILookupCall;
import org.eclipse.scout.service.SERVICES;

/**
 * @author AndrewL
 */
@FormData(value = PartFormData.class, sdkCommand = FormData.SdkCommand.CREATE)
public class PartForm extends AbstractForm {

  /**
   * @throws org.eclipse.scout.commons.exception.ProcessingException
   */
  public PartForm() throws ProcessingException {
    super();
  }

  @Override
  protected String getConfiguredTitle() {
    return TEXTS.get("Part");
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
   * @return the ForQuoteOnlyField
   */
  public ForQuoteOnlyField getForQuoteOnlyField(){
    return getFieldByClass(ForQuoteOnlyField.class);
  }

  /**
   * @return the GeneralBox
   */
  public GeneralBox getGeneralBox() {
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
  public NameField getNameField() {
    return getFieldByClass(NameField.class);
  }

  /**
   * @return the OkButton
   */
  public OkButton getOkButton() {
    return getFieldByClass(OkButton.class);
  }

  /**
   * @return the PartNumberField
   */
  public PartNumberField getPartNumberField() {
    return getFieldByClass(PartNumberField.class);
  }

  /**
   * @return the SearchWordField
   */
  public SearchWordField getSearchWordField() {
    return getFieldByClass(SearchWordField.class);
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
      public class PartNumberField extends AbstractStringField {

        @Override
        protected int getConfiguredGridW() {
          return 2;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("PartNumber");
        }

        @Override
        protected int getConfiguredLabelPosition() {
          return LABEL_POSITION_TOP;
        }
      }

      @Order(20.0)
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

      @Order(30.0)
      public class NameField extends AbstractStringField {

        @Override
        protected int getConfiguredGridW() {
          return 3;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("Name");
        }

        @Override
        protected int getConfiguredLabelPosition() {
          return LABEL_POSITION_TOP;
        }
      }

      @Order(40.0)
      public class SearchWordField extends AbstractStringField {

        @Override
        protected int getConfiguredGridW() {
          return 2;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("SearchWord");
        }

        @Override
        protected int getConfiguredLabelPosition() {
          return LABEL_POSITION_TOP;
        }
      }

      @Order(50.0)
      public class ForQuoteOnlyField extends AbstractCheckBox {

        @Override
        protected int getConfiguredHorizontalAlignment() {
          return 1;
        }

        @Override
        protected String getConfiguredLabel() {
          return TEXTS.get("ForQuoteOnly");
        }

        @Override
        protected boolean getConfiguredLabelVisible() {
          return false;
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
      IPartService service = SERVICES.getService(IPartService.class);
      PartFormData formData = new PartFormData();
      exportFormData(formData);
      formData = service.load(formData);
      importFormData(formData);
      setEnabledPermission(new UpdatePartPermission());

    }

    @Override
    protected void execStore() throws ProcessingException {
      IPartService service = SERVICES.getService(IPartService.class);
      PartFormData formData = new PartFormData();
      exportFormData(formData);
      formData = service.store(formData);

    }
  }

  public class NewHandler extends AbstractFormHandler {

    @Override
    protected void execLoad() throws ProcessingException {
      IPartService service = SERVICES.getService(IPartService.class);
      PartFormData formData = new PartFormData();
      exportFormData(formData);
      formData = service.prepareCreate(formData);
      importFormData(formData);

    }

    @Override
    protected void execStore() throws ProcessingException {
      IPartService service = SERVICES.getService(IPartService.class);
      PartFormData formData = new PartFormData();
      exportFormData(formData);
      formData = service.create(formData);

    }
  }
}
