<template>
  <v-app>
    <app-loading />
    <app-notification />
    <template v-if="isFullScreen">
      <v-main>
        <v-fab-transition>
          <router-view />
        </v-fab-transition>
      </v-main>
    </template>
    <template v-else>
      <app-bar />
      <app-navigation />
      <v-main>
        <v-fab-transition>
          <router-view />
        </v-fab-transition>
      </v-main>
      <v-footer class="elevation-10" app fixed style="z-index: 10">
        <app-player />
      </v-footer>
    </template>
  </v-app>
</template>

<script>
import AppBar from "@/components/AppBar.vue";
import AppNavigation from "@/components/Navigation.vue";
import AppPlayer from "@/components/Player";
import AppLoading from "@/components/loading";
import AppNotification from "@/components/notification";
import { mapActions, mapGetters } from "vuex";
import { LOGIN_ROUTE_ROLE } from "@/core/constants";

export default {
  name: "App",

  components: {
    AppNavigation,
    AppBar,
    AppLoading,
    AppNotification,
    AppPlayer,
  },

  computed: {
    ...mapGetters("auth", ["role"]),
    isFullScreen() {
      if (!this.$route.name) return false;
      return this.$route.meta.fullScreen;
    },
  },

  methods: {
    ...mapActions("auth", ["loadAuthentication"]),
    async loadSession() {
      const success = await this.loadAuthentication();
      if (success) {
        this.$router.push({ name: LOGIN_ROUTE_ROLE[this.role]})
      }
    },
  },

  async created() {
    await this.loadSession();
  },
};
</script>
