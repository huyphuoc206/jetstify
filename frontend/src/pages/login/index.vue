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
                    <v-row align="center" justify="center">
                      <v-col cols="12" sm="8">
                        <v-text-field
                          label="Email"
                          outlined
                          dense
                          color="blue"
                          autocomplete="false"
                          class="mt-16"
                        />
                        <v-text-field
                          label="Password"
                          outlined
                          dense
                          color="blue"
                          autocomplete="false"
                          type="password"
                        />
                        <v-row justify="space-between">
                          <v-col cols="12" sm="7">
                            <v-checkbox
                              label="Remember Me"
                              class="mt-n1"
                              color="blue"
                            >
                            </v-checkbox>
                          </v-col>
                          <v-col cols="12" sm="5" class="text-right">
                            <a class="caption blue--text"
                              >Forgot password</a
                            >
                          </v-col>
                        </v-row>
                        <v-btn color="blue" dark block tile @click="handleSignIn()">Log in</v-btn>

                        <h4 class="text-center grey--text mt-4 mb-3">
                          Or Log in using
                        </h4>
                        <div
                          class="d-flex justify-space-around align-items-center"
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
                    <h3 class="text-center">Sign Up for an account</h3>
                    <v-row align="center" justify="center">
                      <v-col cols="12" sm="8">
                        <v-row>
                          <v-col cols="12" sm="6">
                            <v-text-field
                              label="First Name"
                              outlined
                              dense
                              color="blue"
                              autocomplete="false"
                              class="mt-4"
                            />
                          </v-col>
                          <v-col cols="12" sm="6">
                            <v-text-field
                              label="Last Name"
                              outlined
                              dense
                              color="blue"
                              autocomplete="false"
                              class="mt-4"
                            />
                          </v-col>
                        </v-row>
                        <v-text-field
                          label="Email"
                          outlined
                          dense
                          color="blue"
                          autocomplete="false"
                        />
                        <v-text-field
                          label="Password"
                          outlined
                          dense
                          color="blue"
                          autocomplete="false"
                          type="password"
                        />
                        <v-row justify="space-between">
                          <v-col cols="12" sm="7">
                            <v-checkbox
                              label="I Accept AAE"
                              class="mt-n1"
                              color="blue"
                            >
                            </v-checkbox>
                          </v-col>
                          <v-col cols="12" sm="5" class="text-right">
                            <span class="caption blue--text ml-n4"
                              >Terms & Conditions</span
                            >
                          </v-col>
                        </v-row>
                        <v-btn color="blue" dark block tile @click="handleSignUp()">Sign up</v-btn>

                        <h4 class="text-center grey--text mt-4 mb-3">
                          Or Sign up using
                        </h4>
                        <div
                          class="d-flex justify-space-around align-center"
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
  </v-container>
</template>

<script>
export default {
  name: "Login",

  data: () => ({
    step: 1
  }),

  methods: {
    handleSignIn() {
      alert('Log in');
    },

    handleSignUp() {
      alert('Sign up');
    },
  },
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
