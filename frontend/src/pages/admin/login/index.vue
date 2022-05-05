<template>
  <v-container fill-height>
    <v-row justify="center" align="center">
      <v-col xs="12" sm="8" md="5">
        <v-card class="elevation-12">
          <v-toolbar dark color="pink">
            <v-toolbar-title>Login</v-toolbar-title>
          </v-toolbar>
          <v-card-text>
            <v-form>
              <v-text-field
                prepend-icon="person"
                name="username"
                label="Username"
                type="text"
                v-model="username"
              ></v-text-field>
              <v-text-field
                prepend-icon="lock"
                name="password"
                label="Password"
                type="password"
                v-model="password"
              ></v-text-field>
            </v-form>
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn dark color="pink" @click="login">Login</v-btn>
          </v-card-actions>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>
<script>
export default {
  name: "AdminLogin",
  data: () => ({
    username: "",
    password: "",
  }),
  methods: {
    login() {
      this.$router.push({ name: "AdminCategory" });
    },
  },
};
</script>