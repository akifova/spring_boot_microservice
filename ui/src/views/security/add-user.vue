<template>
  <div>
    <h2 class="content-block">{{ $t("security.user.add.content-block") }}</h2>

    <div class="content-block dx-card responsive-paddings">
      <DxForm
        id="frmAddUserAccount"
        labelLocation="top"
        :formData="formData"
        validationGroup="customerData"
        :disabled="loading">

        <DxGroupItem
            :colCountByScreen="colCountByScreen">
          <DxItem
              dataField='email'
              editorType='dxTextBox'
              :editorOptions="{ mode: 'email'}"
          >
            <DxRequiredRule :message="$t('validation.common.required')" />
            <DxEmailRule :message= "$t('validation.common.invalid-mail')" />
            <DxLabel :text="$t('security.user.add.mail')" />
          </DxItem>

          <DxItem
              dataField='password'
              editorType='dxTextBox'
              :editorOptions="{mode: 'password'}"
          >
            <DxRequiredRule :message="$t('validation.common.required')" />
            <DxLabel :text="$t('security.user.add.password')" />
          </DxItem>

          <DxItem
              dataField='checkPass'
              editorType='dxTextBox'
              :editorOptions="{mode: 'password'}"
          >
            <dx-required-rule :message="$t('validation.common.required')" />
            <DxCompareRule
                :comparisonTarget="passwordComparison"
                message="Password and Confirm Password do not match"
            />
            <DxLabel :text="$t('security.user.add.check-pass')" />
          </DxItem>

          <DxItem
              dataField='name'
              editorType='dxTextBox'
          >
            <DxRequiredRule :message="$t('validation.common.required')" />
            <DxLabel :text="$t('security.user.add.name')" />
          </DxItem>

          <DxItem
              dataField='surname'
              editorType='dxTextBox'
          >
            <DxRequiredRule :message="$t('validation.common.required')" />
            <DxLabel :text="$t('security.user.add.surname')" />
          </DxItem>
        </DxGroupItem>

        <DxGroupItem
            :colCountByScreen="colCountByScreen">
          <DxButtonItem
              horizontalAlignment="left">
            <DxButtonOptions
                :text= "$t('common.save')"
                type= "success"
                :onClick="saveForm"/>
          </DxButtonItem>
          <DxButtonItem
              horizontalAlignment="left">
            <DxButtonOptions
                :text= "$t('common.save')"
                type= "success"
                :onClick="saveForm"/>
          </DxButtonItem>
        </DxGroupItem>

      </DxForm>
    </div>
  </div>
</template>

<script>
// import DxLoadIndicator from "devextreme-vue/load-indicator";
import {DxForm, DxItem, DxLabel, DxRequiredRule, DxCompareRule, DxEmailRule,
  DxGroupItem, DxButtonItem, DxButtonOptions} from "devextreme-vue/form";

export default {
  data() {
    return {
      formData: {
        userName: "",
        password: "",
        checkPass: "",
        name: "",
        surname: ""
      },
      colCountByScreen: {
        xs: 1,
        sm: 2,
        md: 3,
        lg: 3
      },
      loading: false
    };
  },
  methods: {
    passwordComparison() {
      return this.password;
    },
    saveForm(e) {
      alert("aaa");
      console.log(e);
      let result = e.validationGroup.validate();
      if (result.isValid) {
        console.log("Ok"); return;
      }

      console.log(this.formData);
    }
  },
  components: {
    DxForm,
    DxItem,
    DxLabel,
    DxRequiredRule,
    DxCompareRule,
    DxEmailRule,
    DxGroupItem,
    DxButtonItem,
    DxButtonOptions
  }
};
</script>
