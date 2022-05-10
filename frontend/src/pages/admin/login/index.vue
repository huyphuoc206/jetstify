<template>
  <v-container fill-height>
    <v-row justify="center" align="center">
      <v-col xs="12" sm="8" md="5">
        <v-card class="elevation-12">
          <v-toolbar dark color="pink">
            <v-toolbar-title>Login</v-toolbar-title>
          </v-toolbar>
          <v-card-text>
            <v-form ref="form" v-model="isValidLoginForm">
              <v-text-field
                v-model="email"
                required
                prepend-icon="person"
                name="email"
                label="Email"
                type="text"
                :rules="emailRules"
                @keypress.enter="handleSignIn()"
              ></v-text-field>
              <v-text-field
                v-model="password"
                required
                prepend-icon="lock"
                name="password"
                label="Password"
                type="password"
                :rules="passwordRules"
                @keypress.enter="handleSignIn()"
              ></v-text-field>
              <v-checkbox
                v-model="rememberMe"
                label="Remember Me"
                class="mt-n1"
                color="blue"
                hide-details
              >
              </v-checkbox>
            </v-form>
          </v-card-text>
          <v-card-actions class="d-flex align-center justify-center">
            <v-spacer></v-spacer>
            <v-btn dark color="pink" @click="handleSignIn()">Login</v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>
<script>
import { mapGetters, mapActions } from 'vuex';
import { ROLE_CODE } from '@/core/constants';
export default {
  name: "AdminLogin",

  data: () => ({
    loading: false,
    isValidLoginForm: false,
    email: "",
    password: "",
    rememberMe: false,
    emailRules: [ v => !!v || 'Email is required' ],
    passwordRules: [ v => !!v || 'Password is required' ]
  }),

  computed: {
    ...mapGetters("auth", ["isAuthenticated"])
  },

  methods: {
    ...mapActions("auth", ["login"]),
    
    async handleSignIn() {
      try {
        this.$refs.form.validate();
        if (!this.isValidLoginForm) {
          return;
        }
        this.loading = true;
        const request = {
          role: ROLE_CODE.ADMIN, 
          email:this.email,
          password: this.password,
          isRemember: this.isRemember
        }
        const { success, message } = await this.login(request);
        if (success) {
          this.$router.push({ name: 'AdminHome' });
        } else {
          this.$notice.error(message);
        }
      } finally {
        this.loading = false;
      }
    },
  },

  created() {
    this.isAuthenticated && this.$router.push({ name: 'AdminHome'})
  }
};
</script>