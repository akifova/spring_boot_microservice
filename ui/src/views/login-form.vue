<template>
  <form class="login-form" @submit.prevent="onSubmit">
    <dx-form :form-data="formData" :disabled="loading">
      <dx-item
        data-field="email"
        editor-type="dxTextBox"
        :editor-options="{placeholder: 'e-mail', mode: 'email' }"
      >
        <dx-required-rule :message= "$t('validation.required')" />
        <dx-email-rule :message= "$t('validation.common.invalid-mail')" />
        <dx-label :visible="false" />
      </dx-item>
      <dx-item
        data-field='password'
        editor-type='dxTextBox'
        :editor-options="{ placeholder: $t('app.login.password'), mode: 'password' }"
      >
        <dx-required-rule :message="$t('validation.common.required')" />
        <dx-label :visible="false" />
      </dx-item>
      <dx-button-item>
        <dx-button-options
          width="100%"
          type="default"
          template="signInTemplate"
          :use-submit-behavior="true"
        >
        </dx-button-options>
      </dx-button-item>
      <dx-item>
        <template #default>
          <div class="link">
            <router-link to="/reset-password">{{ $t('app.login.forgot-password')}}</router-link>
          </div>
        </template>
      </dx-item>
<!--      <dx-button-item>
        <dx-button-options
          text="Create an account"
          width="100%"
          :on-click="onCreateAccountClick"
        />
      </dx-button-item>-->
      <template #signInTemplate>
        <div>
          <span class="dx-button-text">
            <dx-load-indicator v-if="loading" width="24px" height="24px" :visible="true" />
            <span v-if="!loading">{{ $t('app.login.sign-in') }}</span>
          </span>
        </div>
      </template>
    </dx-form>
  </form>
</template>

<script>
import DxLoadIndicator from "devextreme-vue/load-indicator";
//import i18n from "@/i18n";
import DxForm, {
  DxItem,
  DxEmailRule,
  DxRequiredRule,
  DxLabel,
  DxButtonItem,
  DxButtonOptions
} from "devextreme-vue/form";
import notify from 'devextreme/ui/notify';

import auth from "../auth";

export default {
  data() {
    return {
      formData: {},
      loading: false
    };
  },
  methods: {
    /*onCreateAccountClick() {
      this.$router.push("/create-account");
    },*/
    onSubmit: async function() {
      const { email, password } = this.formData;
      this.loading = true;

      const result = await auth.logIn(email, password);
      if (!result.isOk) {
        this.loading = false;
        notify(result.message, "error", 2000);
      } else {
        this.$router.push(this.$route.query.redirect || "/home");
      }
    }
  },
  components: {
    DxLoadIndicator,
    DxForm,
    DxEmailRule,
    DxRequiredRule,
    DxItem,
    DxLabel,
    DxButtonItem,
    DxButtonOptions
  }
};
</script>

<style lang="scss">
@import "../themes/generated/variables.base.scss";

.login-form {
  .link {
    text-align: center;
    font-size: 16px;
    font-style: normal;

    a {
      text-decoration: none;
    }
  }

  .form-text {
    margin: 10px 0;
    color: rgba($base-text-color, alpha($base-text-color) * 0.7);
  }
}
</style>
