<template>
  <v-container class="container d-flex justify-center align-center">
    <v-row align="center" justify="center">
      <v-col cols="12" sm="10">
        <v-card class="elevation-6 mt-10">
          <v-row>
            <v-col cols="12">
              <v-card-text class="mt-5">
                <h1 class="text-center">Forgot Password</h1>
                <v-row align="center" justify="center">
                  <v-col cols="12" sm="8">
                    <v-form ref="form" v-model="isValidForm">
                      <v-text-field
                        v-model="email"
                        required
                        label="Email"
                        outlined
                        dense
                        color="blue"
                        autocomplete="false"
                        class="mt-5"
                        :rules="emailRules"
                        @keypress.enter="handleForgotPassword"
                      />

                      <v-btn
                        color="blue"
                        dark
                        block
                        tile
                        @click="handleForgotPassword"
                        >Get New Password</v-btn
                      >
                    </v-form>
                    <h3 class="text-center mt-3"> 
                      <router-link style="text-decoration: none" to="/login">Back To Login</router-link>
                    </h3>
                  </v-col>
                </v-row>
              </v-card-text>
            </v-col>
          </v-row>
        </v-card>
      </v-col>
    </v-row>
    <v-dialog v-model="forgotSuccessDialog" max-width="500">
      <v-card>
        <v-card-title>
          <v-row justify="center mt-3">
            <v-icon x-large color="green"> mdi-checkbox-marked-circle </v-icon>
          </v-row>
        </v-card-title>

        <v-card-text class="text-center mt-4">
          <h2>Request reset password successfully</h2>
          <p class="mb-0 mt-2">
            Please check your email to reset the password
          </p>
        </v-card-text>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            color="green darken-1"
            text
            @click="forgotSuccessDialog = false"
          >
            OK
          </v-btn>
          <v-spacer></v-spacer>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-container>
</template>

<script>
export default {
  name: "ForgotPassword",
  data: () => ({
    forgotSuccessDialog: false,
    isValidForm: false,
    email: "",
    emailRules: [
      (v) => !!v || "E-mail is required",
      (v) => /.+@.+\..+/.test(v) || "E-mail must be valid",
    ],
  }),
  methods: {
    async handleForgotPassword(e) {
      e.preventDefault();
      this.$refs.form.validate();
      if (!this.isValidForm) {
        return;
      }
      const { success, message } = await this.$rest.get(`/forgot-password?email=${this.email}`);
      if (success) {
        this.forgotSuccessDialog = true;
      } else {
        this.$notice.error(message);
      }
    }
  },
};
</script>

<style scoped>
.container {
  height: 100%;
}
</style>
