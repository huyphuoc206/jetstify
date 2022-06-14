<template>
  <v-app-bar app color="#2C3A47" dark>
    <v-spacer />
    <v-btn v-if="isAuthenticated" class="ml-7 mr-5" color="pink" fab dark>
      <v-menu bottom min-width="200px" rounded offset-y>
        <template v-slot:activator="{ on }">
          <v-btn icon x-large v-on="on">
            <v-avatar color="brown" size="48">
              <span class="white--text text-h5 mt">{{ avatar }}</span>
            </v-avatar>
          </v-btn>
        </template>
        <v-card>
          <v-list-item-content class="justify-center">
            <div class="mx-auto text-center">
              <h3>{{ fullName }}</h3>
              <v-divider class="my-3"></v-divider>
              <v-btn depressed rounded text @click="handleLogout()">
                Logout
              </v-btn>
            </div>
          </v-list-item-content>
        </v-card>
      </v-menu>
    </v-btn>
    <v-btn v-else :to="{ name: 'Login' }" class="ml-7 mr-5" color="pink" dark>
      Login
    </v-btn>
  </v-app-bar>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
export default {
  name: "AppBarAdmin",

  computed: {
    ...mapGetters("auth", ["fullName", "isAuthenticated"]),
    avatar() {
      return this.fullName ? this.fullName.charAt(0) : "";
    },
  },

  methods: {
    ...mapActions("auth", ["logout"]),

    async handleLogout() {
      await this.logout();
      this.$router.go(this.$router.currentRoute);
    },
  },
};
</script>
