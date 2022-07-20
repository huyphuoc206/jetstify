<template>
  <v-app>
    <app-loading />
    <app-notification />
    <template v-if="isAllReady">
      <template v-if="isFullScreen">
        <v-main>
          <v-fab-transition>
            <router-view />
          </v-fab-transition>
        </v-main>
      </template>
      <template v-else>
        <template v-if="isAdmin">
          <app-bar-admin />
          <app-navigation-admin />
          <v-main>
            <v-fab-transition>
              <v-container class="scroll-y" fluid>
                <v-row align="center" justify="center">
                  <router-view />
                </v-row>
              </v-container>
            </v-fab-transition>
            <v-btn
              v-scroll="onScroll"
              bottom
              color="pink"
              dark
              fab
              fixed
              right
              @click="toTop"
              class="clickable"
            >
              <v-icon>mdi-chevron-up</v-icon>
            </v-btn>
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
    </template>
  </v-app>
</template>

<script>
import AppBar from "@/components/customer/AppBar.vue";
import AppNavigation from "@/components/customer/navigation";
import AppBarAdmin from "@/components/admin/AppBar.vue";
import AppNavigationAdmin from "@/components/admin/Navigation.vue";
import AppPlayer from "@/components/customer/Player";
import AppLoading from "@/components/loading";
import AppNotification from "@/components/notification";
import { mapGetters } from "vuex";
import { ROLE_CODE } from "@/core/constants";

export default {
  name: "App",

  components: {
    AppNavigation,
    AppBar,
    AppLoading,
    AppNotification,
    AppPlayer,
    AppBarAdmin,
    AppNavigationAdmin,
  },

  computed: {
    ...mapGetters("auth", ["role"]),
    ...mapGetters("global", ["isReady"]),

    isFullScreen() {
      if (!this.$route.name) return false;
      return this.$route.meta.fullScreen;
    },

    isAdmin() {
      return this.role === ROLE_CODE.ADMIN;
    },

    isAllReady() {
      return this.isReady && !!this.$route.name;
    },
  },

  methods: {
    onScroll(e) {
      if (typeof window === "undefined") return;
      const top = window.pageYOffset || e.target.scrollTop || 0;
      this.fab = top > 20;
    },
    toTop() {
      this.$vuetify.goTo(0);
    },
  },
};
</script>
