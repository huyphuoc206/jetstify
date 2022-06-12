<template>
  <v-container class="container d-flex justify-center align-center">
    <v-row v-if="showForm" align="center" justify="center">
      <v-col cols="12" sm="10">
        <v-card class="elevation-6 mt-10">
          <v-row>
            <v-col cols="12">
              <v-card-text class="mt-5">
                <h1 class="text-center">Reset Password</h1>
                <v-row align="center" justify="center">
                  <v-col cols="12" sm="8">
                    <v-form ref="form" v-model="isValidForm">
                      <v-text-field
                        v-model="password"
                        required
                        label="Password"
                        outlined
                        dense
                        color="blue"
                        class="mt-5"
                        autocomplete="false"
                        type="password"
                        :rules="passwordRules"
                      />
                      <v-text-field
                        v-model="passwordConfirm"
                        required
                        label="Confirm Password"
                        outlined
                        dense
                        color="blue"
                        autocomplete="false"
                        type="password"
                        :rules="passwordConfirmRules"
                      />

                      <v-btn
                        color="blue"
                        dark
                        block
                        tile
                        @click="handleResetPassword()"
                        >Reset Password</v-btn
                      >
                    </v-form>
                  </v-col>
                </v-row>
              </v-card-text>
            </v-col>
          </v-row>
        </v-card>
      </v-col>
    </v-row>
    <v-row v-if="showExpired" align="center" justify="center">
      <v-col cols="12">
        <v-card class="elevation-6 mt-10">
          <v-row>
            <v-col cols="12">
              <v-card-text class="mt-5 text-center">
                <h1 class="mb-3">The reset password link has expired</h1>
                <h3>Please make a new request to reset password</h3>
                <v-row align="center" justify="center">
                  <v-col cols="12">
                    <h3 class="text-center mt-3">
                      <router-link style="text-decoration: none" to="/forgot-password"
                        >Forgot Password</router-link
                      >
                    </h3>
                  </v-col>
                </v-row>
              </v-card-text>
            </v-col>
          </v-row>
        </v-card>
      </v-col>
    </v-row>
    <v-dialog v-model="resetSuccessDialog" persistent max-width="500">
      <v-card>
        <v-card-title>
          <v-row justify="center mt-3">
            <v-icon x-large color="green"> mdi-checkbox-marked-circle </v-icon>
          </v-row>
        </v-card-title>

        <v-card-text class="text-center mt-4">
          <h2>Reset password successfully</h2>
          <p class="mb-0 mt-2">You can login with new password</p>
        </v-card-text>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            color="green darken-1"
            text
            @click="resetSuccessDialog = false"
          >
          <router-link style="text-decoration: none" to="/login"
                        >Login</router-link
                      >
          </v-btn>
          <v-spacer></v-spacer>
        </v-card-actions>
      </v-card>
    </v-dialog>
  </v-container>
</template>

<script>
export default {
  name: "ResetPassword",
  data: () => ({
    showForm: false,
    showExpired: false,
    resetSuccessDialog: false,
    isValidForm: false,
    password: "",
    passwordConfirm: "",
    passwordRules: [
      (v) => !!v || "Password is required",
      (v) =>
        (v && v.length >= 6) || "Password must be greater than 6 characters",
    ],
  }),
  computed: {
    passwordConfirmRules() {
      return [
        (v) =>
          (v && v === this.password) ||
          "The password confirmation does not match.",
      ];
    },
  },
  methods: {
    async handleResetPassword() {
      this.$refs.form.validate();
      if (!this.isValidForm) {
        return;
      }
      const email = this.$route.params.email;
      const request = {
        email:    email,
        newPassword: this.password,
        newPasswordConfirm: this.passwordConfirm
      }
      const { success, message } = await this.$rest.put('/reset-password', request);
      if (success) {
        this.resetSuccessDialog = true;
      } else {
        this.$notice.error(message);
      }
    },

    async verifyResetPassword(key = "") {
      const { success, status } = await this.$rest.get(`/verify-forgot-password?key=${key}`);
      if (status === 200) {
        this.showForm = success;
        this.showExpired = !success;
        return;
      }
      !success &&  this.$router.push("/server-error");
    },
  },

  async created() {
    const key = this.$route.params.key;
    await this.verifyResetPassword(key);
  },
};
</script>

<style scoped>
.container {
  height: 100%;
}
</style>
