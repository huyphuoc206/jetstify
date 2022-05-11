<template>
  <div>
    <h1>Hello Admin: {{ fullName }}</h1>
    <v-btn @click="handleLogout()"> Logout </v-btn>
  </div>
</template>

<script>
import { mapActions, mapGetters } from "vuex";
export default {
  name: "AdminHome",

  computed: {
    ...mapGetters("auth", ["fullName"]),
    avatar() {
      return this.fullName ? this.fullName.charAt(0) : "";
    },
  },

  methods: {
    ...mapActions("auth", ["logout"]),

    async handleLogout() {
      await this.logout();
    },
  },
};
</script>
