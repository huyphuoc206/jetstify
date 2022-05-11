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
      <template v-if="isAdmin">
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
    </template>
  </v-app>
</template>

<script>
import AppBar from "@/components/customer/AppBar.vue";
import AppNavigation from "@/components/customer/Navigation.vue";
import AppPlayer from "@/components/customer/Player";
import AppLoading from "@/components/loading";
import AppNotification from "@/components/notification";
import { mapActions, mapGetters } from "vuex";
import { ROLE_CODE } from "@/core/constants";

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

    isAdmin() {
      return this.role === ROLE_CODE.ADMIN;
    },
  },

  methods: {
    ...mapActions("auth", ["loadAuthentication"]),
  },

  async created() {
    await this.loadAuthentication();
  },
};
</script>
