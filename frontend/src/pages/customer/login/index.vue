<template>
  <v-container class="container d-flex justify-center align-center">
    <v-row align="center" justify="center">
      <v-col cols="12" sm="10">
        <v-card class="elevation-6 mt-10">
          <v-window v-model="step">
            <v-window-item :value="1">
              <v-row>
                <v-col cols="12" md="6">
                  <v-card-text class="mt-5">
                    <h3 class="text-center">Login in to Your Account</h3>
                    <h3 class="text-center mb-3">Or 
                      <router-link style="text-decoration: none" to="/">Back To Home</router-link>
                    </h3>
                    <v-row align="center" justify="center">
                      <v-col cols="12" sm="8">
                        <v-form ref="formLogin" v-model="isValidLoginForm">
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
                            @keypress.enter="handleSignIn()"
                          />
                          <v-text-field
                            v-model="password"
                            required
                            label="Password"
                            outlined
                            dense
                            color="blue"
                            autocomplete="false"
                            type="password"
                            :rules="passwordRules"
                            @keypress.enter="handleSignIn()"
                          />
                          <v-row justify="space-between">
                            <v-col cols="12" sm="7">
                              <v-checkbox
                                v-model="rememberMe"
                                label="Remember Me"
                                class="mt-n1"
                                color="blue"
                              >
                              </v-checkbox>
                            </v-col>
                            <v-col cols="12" sm="5" class="text-right">
                              <router-link class="caption" style="text-decoration: none" to="/forgot-password">Forgot password</router-link>
                            </v-col>
                          </v-row>
                          <v-btn
                            color="blue"
                            dark
                            block
                            tile
                            @click="handleSignIn()"
                            >Log in</v-btn
                          >

                          <h4 class="text-center grey--text mt-4 mb-3">
                            Or Log in using
                          </h4>
                          <div
                            class="
                              d-flex
                              justify-space-around
                              align-items-center
                            "
                          >
                            <v-btn depressed outlined color="grey">
                              <v-icon color="red">mdi-google</v-icon>
                            </v-btn>
                            <v-btn depressed outlined color="grey">
                              <v-icon color="blue">mdi-facebook</v-icon>
                            </v-btn>
                            <v-btn depressed outlined color="grey">
                              <v-icon color="light-blue lighten-3"
                                >mdi-twitter</v-icon
                              >
                            </v-btn>
                          </div>
                        </v-form>
                      </v-col>
                    </v-row>
                  </v-card-text>
                </v-col>
                <v-col cols="12" md="6" class="blue rounded-bl-xl">
                  <div style="text-align: center; padding: 180px 0">
                    <v-card-text class="white--text">
                      <h2 class="text-center">Don't have an account yet?</h2>
                    </v-card-text>
                    <div class="text-center">
                      <v-btn tile outlined dark @click="step++">SIGN UP</v-btn>
                    </div>
                  </div>
                </v-col>
              </v-row>
            </v-window-item>
            <v-window-item :value="2">
              <v-row>
                <v-col cols="12" md="6" class="blue rounded-br-xl">
                  <div style="text-align: center; padding: 180px 0">
                    <v-card-text class="white--text">
                      <h2 class="text-center">Already signed up?</h2>
                    </v-card-text>
                    <div class="text-center">
                      <v-btn tile outlined dark @click="step--">Log in</v-btn>
                    </div>
                  </div>
                </v-col>

                <v-col cols="12" md="6">
                  <v-card-text class="mt-5">
                    <h3 class="text-center mb-3">Sign Up for an account</h3>
                    <v-row align="center" justify="center">
                      <v-col cols="12" sm="8">
                        <v-form ref="formRegister" v-model="isValidRegisterForm">
                          <v-text-field
                            v-model="fullNameRegister"
                            required
                            label="Full Name"
                            outlined
                            dense
                            color="blue"
                            autocomplete="false"
                            :rules="fullNameRules"
                          />
                          <v-text-field
                            v-model="emailRegister"
                            required
                            label="Email"
                            outlined
                            dense
                            color="blue"
                            autocomplete="false"
                            :rules="emailRules"
                          />
                          <v-text-field
                            v-model="passwordRegister"
                            required
                            label="Password"
                            outlined
                            dense
                            color="blue"
                            autocomplete="false"
                            type="password"
                            :rules="passwordRules"
                          />
                          <v-text-field
                            v-model="passwordRegisterConfirm"
                            required
                            label="Confirm Password"
                            outlined
                            dense
                            color="blue"
                            autocomplete="false"
                            type="password"
                            :rules="passwordConfirmRules"
                          />
                          <v-row justify="space-between">
                            <v-col cols="12" sm="7">
                              <v-checkbox
                                required
                                label="I Accept AAE"
                                class="mt-n1"
                                color="blue"
                                :rules="termsRules"
                              >
                              </v-checkbox>
                            </v-col>
                            <v-col cols="12" sm="5" class="text-right">
                              <span class="caption blue--text ml-n4"
                                >Terms & Conditions</span
                              >
                            </v-col>
                          </v-row>
                          <v-btn
                            color="blue"
                            dark
                            block
                            tile
                            @click="handleSignUp()"
                            >Sign up</v-btn
                          >

                          <h4 class="text-center grey--text mt-4 mb-3">
                            Or Sign up using
                          </h4>
                          <div class="d-flex justify-space-around align-center">
                            <v-btn depressed outlined color="grey">
                              <v-icon color="red">mdi-google</v-icon>
                            </v-btn>
                            <v-btn depressed outlined color="grey">
                              <v-icon color="blue">mdi-facebook</v-icon>
                            </v-btn>
                            <v-btn depressed outlined color="grey">
                              <v-icon color="light-blue lighten-3"
                                >mdi-twitter</v-icon
                              >
                            </v-btn>
                          </div>
                        </v-form>
                      </v-col>
                    </v-row>
                  </v-card-text>
                </v-col>
              </v-row>
            </v-window-item>
          </v-window>
        </v-card>
      </v-col>
    </v-row>
    <v-dialog
      v-model="registerSuccessDialog"
      max-width="500"
    >
      <v-card>
        <v-card-title>
          <v-row justify="center mt-3">
            <v-icon
            x-large
            color="green"
            >
              mdi-checkbox-marked-circle
            </v-icon>
          </v-row>
        </v-card-title>

        <v-card-text class="text-center mt-4">
          <h2>Registration completed successfully</h2>
          <p class="mb-0 mt-2">Please check your registered email for email verification</p>
        </v-card-text>

        <v-card-actions>
          <v-spacer></v-spacer>
          <v-btn
            color="green darken-1"
            text
            @click="registerSuccessDialog = false"
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
import { mapActions, mapGetters } from 'vuex';
import { ROLE_CODE } from '@/core/constants';
export default {
  name: "Login",
  data: () => ({
    step: 1,
    registerSuccessDialog: false,
    isValidLoginForm: false,
    isValidRegisterForm: false,
    email: "",
    password: "",
    rememberMe: false,
    fullNameRegister: "",
    emailRegister: "",
    passwordRegister: "",
    passwordRegisterConfirm: "",
    emailRules: [
      v => !!v || 'E-mail is required',
      v => /.+@.+\..+/.test(v) || 'E-mail must be valid',
    ],
    passwordRules: [ 
      v => !!v || 'Password is required',
      v => (v && v.length >= 6) || 'Password must be greater than 6 characters',
    ],
    fullNameRules: [v => !!v || 'Full name is required'],
    termsRules: [v => !!v]
  }),
  computed: {
    ...mapGetters("auth", ["isAuthenticated"]),
    passwordConfirmRules() {
      return [
        v => (v && v === this.passwordRegister) || 'The password confirmation does not match.',
      ]
    }
  },
  methods: {
    ...mapActions('auth', ['login']),
    async handleSignIn() {
      this.$refs.formLogin.validate();
      if (!this.isValidLoginForm) {
        return;
      }
      const request = {
        role: ROLE_CODE.CUSTOMER, 
        email:this.email,
        password: this.password,
        isRemember: this.isRemember
      }
      const { success, message } = await this.login(request);
      if (success) {
        this.$router.push('/');
      } else {
        this.$notice.error(message);
      }
    },
    async handleSignUp() {
      this.$refs.formRegister.validate();
      if (!this.isValidRegisterForm) {
        return;
      }
      const request = {
        email:    this.emailRegister,
        password: this.passwordRegister,
        fullName: this.fullNameRegister
      }
      const { success, message } = await this.$rest.post('/register', request);
      if (success) {
        this.resetForm();
        this.registerSuccessDialog = true;
      } else {
        this.$notice.error(message);
      }
    },

    resetForm() {
      this.$refs.formLogin.reset();
      this.$refs.formRegister.reset();
    }
  },
  created() {
    this.isAuthenticated && this.$router.push({ name: 'Home'})
  }
};
</script>

<style scoped>
.container {
  height: 100%;
}
.v-application .rounded-bl-xl {
  border-bottom-left-radius: 300px !important;
}
.v-application .rounded-br-xl {
  border-bottom-right-radius: 300px !important;
}
</style>
